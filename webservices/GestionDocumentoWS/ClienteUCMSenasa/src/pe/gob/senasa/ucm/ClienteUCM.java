package pe.gob.senasa.ucm;

import com.stellent.cis.ICISApplication;

import com.stellent.cis.client.api.scs.ISCSContent;
import com.stellent.cis.client.api.scs.ISCSContentID;
import com.stellent.cis.client.api.scs.ISCSRevisionNode;
import com.stellent.cis.client.api.scs.context.ISCSContext;
import com.stellent.cis.client.api.scs.document.ISCSDocumentActionResponse;
import com.stellent.cis.client.api.scs.document.checkin.ISCSDocumentCheckinAPI;
import com.stellent.cis.client.api.scs.document.checkin.ISCSDocumentCheckinResponse;
import com.stellent.cis.client.api.scs.document.checkout.ISCSDocumentCheckoutAPI;
import com.stellent.cis.client.api.scs.document.information.ISCSDocMetaDefinition;
import com.stellent.cis.client.api.scs.document.information.ISCSDocumentInformationAPI;
import com.stellent.cis.client.api.scs.document.information.ISCSDocumentInformationResponse;
import com.stellent.cis.client.api.scs.document.information.ISCSRevisionHistory;
import com.stellent.cis.client.api.scs.document.update.ISCSDocumentUpdateAPI;
import com.stellent.cis.client.api.scs.file.ISCSFileAPI;
import com.stellent.cis.client.api.scs.file.ISCSFileInfo;
import com.stellent.cis.client.api.scs.search.ISCSSearchAPI;
import com.stellent.cis.client.api.scs.search.ISCSSearchResponse;
import com.stellent.cis.client.api.scs.search.ISCSSearchResult;
import com.stellent.cis.client.command.CommandException;
import com.stellent.cis.client.io.ICISTransferStream;
import com.stellent.cis.impl.CISApplicationFactory;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import java.io.InputStream;

import java.net.MalformedURLException;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ClienteUCM {
    protected static Logger logger = Logger.getLogger(ClienteUCM.class);

    public ClienteUCM() {
	super();
    }

    private static ClienteUCM instance = null;

    public static ClienteUCM getInstance() {
	if (instance == null)
	    instance = new ClienteUCM();
	return instance;
    }

    protected ICISApplication aplicacion;
    protected String USER_NAME_UCM = "sysadmin";

    protected ICISApplication initAppliaction() {
	if (aplicacion != null) {
	    return aplicacion;
	}
	try {
	    Properties propiedades = new Properties();
	    propiedades.setProperty(ICISApplication.PROPERTY_CONFIG_SERVER_ADAPTER_CONFIG, "adapterconfig.xml");
	    propiedades.setProperty(ICISApplication.PROPERTY_CONFIG_TYPE, "server");
	    propiedades.setProperty(ICISApplication.PROPERTY_CONFIG_SERVER_TYPE, "standalone");
	    propiedades.setProperty(ICISApplication.PROPERTY_CONFIG_SERVER_TEMP_DIRECTORY, "C:/temporal/");
	    aplicacion = CISApplicationFactory.initialize(propiedades);
	    return aplicacion;
	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}
    }

    protected ISCSContentID obtenerContenidoID(String idDocumento) {
	aplicacion = initAppliaction();
	ISCSContentID contentId = (ISCSContentID)aplicacion.getUCPMAPI().createObject(ISCSContentID.class);
	contentId.setContentID(idDocumento);
	contentId.setRevisionSelectionMethod(ISCSContentID.REVISION_LATEST);
	return contentId;
    }

    protected ISCSContext obtenerContexto() {
	ISCSContext contexto = aplicacion.getUCPMAPI().getActiveAPI()._createSCSContext();
	contexto.setUser(USER_NAME_UCM);
	return contexto;
    }

    protected ICISTransferStream prepararStream(String nombreArchivo, byte[] contenidoArchivo) throws IOException {
	try {
	    ICISTransferStream transferStream = aplicacion.getUCPMAPI().createTransferStream();
	    if (contenidoArchivo == null || contenidoArchivo.length == 0) {
		File archivo = new File(nombreArchivo);
		if (!archivo.exists()) {
		    return null;
		}
		transferStream.setFile(archivo);
	    } else {
		transferStream.setFileName(nombreArchivo);
		transferStream.setInputStream(new ByteArrayInputStream(contenidoArchivo));
		transferStream.setContentLength(contenidoArchivo.length);
	    }
	    return transferStream;
	} catch(Exception ex) {
	    ex.printStackTrace();
	    return null;
        }
    }

    protected ISCSContent prepararContenido(ISCSContentID id, String titulo, String autor, String tipo, String grupo, String cuenta, Hashtable propiedades) {
	if (titulo == null || titulo.isEmpty())
	    titulo = "(Sin t�tulo)"; //dDocTitle
	else if (titulo.length() > 80)
	    titulo = titulo.substring(0, 80);

	if (autor == null || autor.isEmpty())
	    autor = "(Sin usuario)"; //dDocAuthor
	if (tipo == null || tipo.isEmpty())
	    tipo = "OTRS"; //dDocType
	if (grupo == null || grupo.isEmpty())
	    grupo = "Interno"; //dSecurityGroup
	if (cuenta == null || cuenta.isEmpty())
	    cuenta = "OTRO"; //dDocAccount

	if (propiedades == null)
	    propiedades = new Hashtable();
	if (!propiedades.containsKey("xProfileTrigger"))
	    propiedades.put("xProfileTrigger", "OTRO-OTRS");
	if (!propiedades.containsKey("xConfidencial"))
	    propiedades.put("xConfidencial", "NO");
	if (propiedades.containsKey("dDocTitle") && propiedades.get("dDocTitle").toString().length() > 80) {
	    String aux = propiedades.get("dDocTitle").toString().substring(0, 80);
	    propiedades.put("dDocTitle", aux);
	}
	aplicacion = initAppliaction();
	ISCSContent contenido = (ISCSContent)aplicacion.getUCPMAPI().createObject(ISCSContent.class);
	if (id != null)
	    contenido.setContentID(id);
	contenido.setAuthor(autor);
	contenido.setSecurityGroup(grupo);
	contenido.setTitle(titulo);
	contenido.setType(tipo);
	contenido.setSecurityAccount(cuenta);
	Enumeration e = propiedades.keys();
	while (e.hasMoreElements()) {
	    String nNombreMetadato = (String)e.nextElement();
	    String valorMetadato = (String)propiedades.get(nNombreMetadato);
	    contenido.setProperty(nNombreMetadato, valorMetadato);
	}
	return contenido;
    }

    protected ISCSContentID CheckOutDocumento(String idDocumento) throws CommandException {
	if (idDocumento == null || idDocumento.trim().length() == 0)
	    return null;

	aplicacion = initAppliaction();

	ISCSContentID contentId = obtenerContenidoID(idDocumento);
	ISCSContext contexto = obtenerContexto();


	ISCSDocumentCheckoutAPI checkout = aplicacion.getUCPMAPI().getActiveAPI().getDocumentCheckoutAPI();
	try {
	    ISCSDocumentActionResponse docResponse = checkout.checkoutFileByName(contexto, contentId);
	    return docResponse.getContent().getContentID();
	} catch (CommandException e) {
	    e.printStackTrace();
	    checkout.undoCheckoutFileByName(contexto, contentId);
	    throw e;
	}
    }

    protected Documento GetDocumentInformation(String idDocumento) throws CommandException {
        aplicacion = initAppliaction();
        
        Documento doc = new Documento();
        ISCSContentID contenido = obtenerContenidoID(idDocumento);
        ISCSContext contexto = obtenerContexto();
        ISCSDocumentInformationAPI info = aplicacion.getUCPMAPI().getActiveAPI().getDocumentInformationAPI();
        ISCSDocumentInformationResponse response = (ISCSDocumentInformationResponse)aplicacion.getUCPMAPI().createObject(ISCSDocumentInformationResponse.class);
        response = info.getDocumentInformationByName(contexto, contenido);
        doc.setConfidencial("NO");
        if (response.getDocNode().getProperty("xConfidencial")!=null && response.getDocNode().getProperty("xConfidencial").getValue()!=null)
            doc.setConfidencial(response.getDocNode().getProperty("xConfidencial").getValue().getStringValue().toUpperCase());
        doc.setId(idDocumento);
        doc.setNombre(response.getDocNode().getTitle());
        doc.setUrl(response.getDocumentURL());
        int i = 1;
        for(int j = 0; j < response.getRevisionHistory().size(); j++)  {
            ISCSRevisionHistory rev = (ISCSRevisionHistory)response.getRevisionHistory().get(j);
            Version v = new Version();
            v.setId(rev.getRevisionID());
            v.setEtiqueta(rev.getRevisionLabel());
            if (rev.getReleaseDate()!=null)
                v.setFecha(dateToString(rev.getReleaseDate()));
            if (response.getDocNode().getRevisionLabel().equals(rev.getRevisionLabel()))
                v.setUrl(response.getDocumentURL());
            else
                v.setUrl(convertUrlToRevision(response.getDocumentURL(), rev.getRevisionID()));
            doc.getVersiones().add(v);
            i++;
        }
        return doc;
    }
    
    private String convertUrlToRevision(String url, String revisionId) {
        int j = url.lastIndexOf(".");
        return url.substring(0, j) + "~" + revisionId + url.substring(j);
    }
            
    private String dateToString(Date c){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        if (c != null) {
            return sdf.format(c.getTime());
        }
        return "";
    }

    protected String CheckInDocumento(ISCSContentID id, String titulo, String autor, String tipo, String grupo, String cuenta, Hashtable propiedades,
				      String nombreArchivo, byte[] contenidoArchivo) throws CommandException, IOException {
	ISCSContent contenido = prepararContenido(id, titulo, autor, tipo, grupo, cuenta, propiedades);
	ICISTransferStream transferStream = prepararStream(nombreArchivo, contenidoArchivo);
	ISCSContext contexto = obtenerContexto();
	String dDocname = "";
	if (transferStream == null && id != null) {
	    ISCSDocumentUpdateAPI update = aplicacion.getUCPMAPI().getActiveAPI().getDocumentUpdateAPI();
	    ISCSDocumentActionResponse response = (ISCSDocumentActionResponse)aplicacion.getUCPMAPI().createObject(ISCSDocumentActionResponse.class);
	    response = update.updateInfo(contexto, contenido);
	    dDocname = response.getContent().getContentID().getContentID();
	} else {
	    ISCSDocumentCheckinAPI checkin = aplicacion.getUCPMAPI().getActiveAPI().getDocumentCheckinAPI();
	    ISCSDocumentCheckinResponse response = (ISCSDocumentCheckinResponse)aplicacion.getUCPMAPI().createObject(ISCSDocumentCheckinResponse.class);
	    response = checkin.checkinFileStream(contexto, contenido, transferStream);
	    dDocname = response.getContent().getContentID().getContentID();    
	}
	
	System.out.println("CheckIn=>dDocname=>" + dDocname);
	return dDocname;
    }

    public String registrarDocumento(String id, String titulo, String autor, String tipo, String grupo, String cuenta, Hashtable propiedades,
				     String nombreArchivo, byte[] contenidoArchivo) throws MalformedURLException, CommandException, IOException {
	ISCSContentID contentID = null;
	if (id != null && id.trim().length() != 0 && !id.isEmpty()) {
	    contentID = CheckOutDocumento(id);
	}
	return CheckInDocumento(contentID, titulo, autor, tipo, grupo, cuenta, propiedades, nombreArchivo, contenidoArchivo);
    }

    public String obtenerUrl(String idDocumento) {
	try {
	    aplicacion = initAppliaction();

	    ISCSContentID contentId = obtenerContenidoID(idDocumento);
	    ISCSContext contexto = obtenerContexto();

	    ISCSDocumentInformationAPI documentInfoAPI = aplicacion.getUCPMAPI().getActiveAPI().getDocumentInformationAPI();
	    ISCSDocumentInformationResponse docResponse = documentInfoAPI.getDocumentInformationByName(contexto, contentId);

	    String url = docResponse.getDocumentURL();
	    System.out.println("Documento=> ID:" + idDocumento + " | URL:" + url);
	    return url;
	} catch (CommandException e) {
	    e.printStackTrace();
	    return null;
	}
    }

    public Documento obtenerInfoDocumento(String idDocumento) {
        try {
            return GetDocumentInformation(idDocumento);
        } catch (CommandException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ICISTransferStream obtenerDocumento(String idDocumento) {
	try {
	    aplicacion = initAppliaction();
	    ISCSContentID contentId = obtenerContenidoID(idDocumento);
	    ISCSContext contexto = obtenerContexto();
	    ISCSFileInfo info = (ISCSFileInfo)aplicacion.getUCPMAPI().createObject(ISCSFileInfo.class);
	    info.setRendition(ISCSFileInfo.RENDITION_WEB);

	    ISCSFileAPI fileAPI = aplicacion.getUCPMAPI().getActiveAPI().getFileAPI();
	    ICISTransferStream stream = fileAPI.getFile(contexto, contentId, info);
	    return stream;
	} catch (CommandException e) {
	    e.printStackTrace();
	}
	return null;
    }
    
    public String obtenerIdDocumentoPorTitulo(String titulo) {
        try {
            String dDocName = "";
            aplicacion = initAppliaction();
            ISCSContext contexto = obtenerContexto();
            ISCSFileInfo info = (ISCSFileInfo)aplicacion.getUCPMAPI().createObject(ISCSFileInfo.class);
            info.setRendition(ISCSFileInfo.RENDITION_WEB);

            ISCSSearchAPI searchAPI = aplicacion.getUCPMAPI().getActiveAPI().getSearchAPI();
            ISCSSearchResponse searchResponse = searchAPI.search(contexto, "dDocTitle <matches> `" + titulo + "`", 25);
            Iterator it = searchResponse.getResults().iterator();
            List<ISCSSearchResult> results = null;
            if (!searchResponse.getResults().isEmpty()) {
                results = searchResponse.getResults();
                ISCSSearchResult searchResult = results.get(0);
                dDocName = searchResult.getContentID().getContentID();
            }

            return dDocName;
        } catch (CommandException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ICISTransferStream obtenerDocumentoPorTitulo(String titulo) {
	try {
	    String dDocName = "";
	    aplicacion = initAppliaction();
	    ISCSContext contexto = obtenerContexto();
	    ISCSFileInfo info = (ISCSFileInfo)aplicacion.getUCPMAPI().createObject(ISCSFileInfo.class);
	    info.setRendition(ISCSFileInfo.RENDITION_WEB);

	    ISCSSearchAPI searchAPI = aplicacion.getUCPMAPI().getActiveAPI().getSearchAPI();
	    ISCSSearchResponse searchResponse = searchAPI.search(contexto, "dDocTitle <matches> `" + titulo + "`", 25);
	    Iterator it = searchResponse.getResults().iterator();
	    List<ISCSSearchResult> results = null;
	    if (!searchResponse.getResults().isEmpty()) {
		results = searchResponse.getResults();
		ISCSSearchResult searchResult = results.get(0);
		dDocName = searchResult.getContentID().getContentID();
		System.out.println(searchResult.getTitle());
		System.out.println(searchResult.getAuthor());
		System.out.println(dDocName);
	    }

	    return obtenerDocumento(dDocName);
	} catch (CommandException e) {
	    e.printStackTrace();
	}
	return null;
    }

}
