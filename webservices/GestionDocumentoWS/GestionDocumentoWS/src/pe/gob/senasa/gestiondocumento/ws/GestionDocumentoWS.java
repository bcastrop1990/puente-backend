package pe.gob.senasa.gestiondocumento.ws;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

import java.util.Hashtable;

import java.io.InputStream;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.log4j.Logger;

import pe.gob.senasa.gestiondocumento.ucm.Propiedad;
import pe.gob.senasa.ucm.ClienteUCM;
import pe.gob.senasa.ucm.Documento;

/**
 * Servicios para el manejo de la información relacionada con las agencias de aduanas.
 */
@WebService(name = "GestionDocumentoWS", serviceName = "GestionDocumentoWS", targetNamespace = "http://gestiondocumento.ws.senasa.gob.pe",
            portName = "GestionDocumentoWSPort")

public class GestionDocumentoWS {
    protected static Logger logger = Logger.getLogger(GestionDocumentoWS.class);

    public GestionDocumentoWS() {
    }

    private Hashtable obtenerPropiedades(String propiedades) {
        Hashtable metadatos = new Hashtable();
        if (propiedades != null && !propiedades.isEmpty()) {
            String[] props = propiedades.split("|");
            for (String prop : props) {
                String[] p = prop.split(":");
                if (p.length == 2) {
                    if (p[0] != null && p[1] != null && !p[1].isEmpty()) {
                        System.out.println("Property:" + p[0] + "=>" + p[1]);
                        metadatos.put(p[0], p[1]);
                    }
                }
            }
        }
        return metadatos;
    }

    private Hashtable obtenerPropiedades(Propiedad[] propiedades) {
        Hashtable metadatos = new Hashtable();
        if (propiedades != null) {
            for (Propiedad prop : propiedades) {
                if (prop != null && prop.getNombre() != null && !prop.getNombre().isEmpty()) {
                    System.out.println("Property:" + prop.getNombre() + "=>" + prop.getValor());
                    metadatos.put(prop.getNombre(), prop.getValor());
                }
            }
        }
        return metadatos;
    }

    @WebMethod
    public String registrarDocumentoServidor(String id, String titulo, String autor, String tipo, String grupo, String cuenta, String nombreArchivo,
                                             Propiedad[] propiedades) {
        try {
            logger.info("INICIO: registrarDocumentoServidor : " + id + " / " + titulo + " / " + autor + " / " + tipo + " / " + grupo + " / " + cuenta + " / " +
                        propiedades + " / " + nombreArchivo);
            String ucmId =
                ClienteUCM.getInstance().registrarDocumento(id, titulo, autor, tipo, grupo, cuenta, obtenerPropiedades(propiedades), nombreArchivo, null);
            logger.info("TERMINO: registrarDocumentoServidor : " + ucmId);
            return ucmId;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ERROR: registrarDocumentoServidor : " + e.getMessage(), e);
            return null;
        }
    }

    @WebMethod
    public String registrarDocumentoServidorPlano(String id, String titulo, String autor, String tipo, String grupo, String cuenta, String nombreArchivo,
                                                  String propiedades) {
        try {
            logger.info("INICIO: registrarDocumentoServidorPlano : " + id + " / " + titulo + " / " + autor + " / " + tipo + " / " + grupo + " / " + cuenta +
                        " / " + propiedades + " / " + nombreArchivo);
            String ucmId =
                ClienteUCM.getInstance().registrarDocumento(id, titulo, autor, tipo, grupo, cuenta, obtenerPropiedades(propiedades), nombreArchivo, null);
            logger.info("TERMINO: registrarDocumentoServidorPlano : " + ucmId);
            return ucmId;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ERROR: registrarDocumentoServidorPlano : " + e.getMessage(), e);
            return null;
        }
    }

    @WebMethod
    public String registrarDocumento(String id, String titulo, String autor, String tipo, String grupo, String cuenta, String nombreArchivo,
                                     byte[] contenidoArchivo, Propiedad[] propiedades) {
        try {
            logger.info("INICIO: registrarDocumento : " + id + " / " + titulo + " / " + autor + " / " + tipo + " / " + grupo + " / " + cuenta + " / " +
                        propiedades.length + " / " + nombreArchivo + " / " + contenidoArchivo);
            String ucmId = null;
            if (contenidoArchivo != null && contenidoArchivo.length != 0)
                ucmId =
                        ClienteUCM.getInstance().registrarDocumento(id, titulo, autor, tipo, grupo, cuenta, obtenerPropiedades(propiedades), nombreArchivo, contenidoArchivo);
            ;
            logger.info("TERMINO: registrarDocumento : " + ucmId);
            return ucmId;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ERROR: registrarDocumento : " + e.getMessage(), e);
            return null;
        }
    }

    @WebMethod
    public String registrarDocumentoPlano(String id, String titulo, String autor, String tipo, String grupo, String cuenta, String nombreArchivo,
                                          byte[] contenidoArchivo, String propiedades) {
        try {
            logger.info("INICIO: registrarDocumentoPlano : " + id + " / " + titulo + " / " + autor + " / " + tipo + " / " + grupo + " / " + cuenta + " / " +
                        propiedades + " / " + nombreArchivo + " / " + contenidoArchivo);
            String ucmId = null;
            if (contenidoArchivo != null && contenidoArchivo.length != 0)
                ucmId =
                        ClienteUCM.getInstance().registrarDocumento(id, titulo, autor, tipo, grupo, cuenta, obtenerPropiedades(propiedades), nombreArchivo, contenidoArchivo);
            ;
            logger.info("TERMINO: registrarDocumentoPlano : " + ucmId);
            return ucmId;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ERROR: registrarDocumentoPlano : " + e.getMessage(), e);
            return null;
        }
    }

    @WebMethod
    public String obtenerURL(String idDocumento) {
        try {
            logger.info("INICIO: obtenerURL : " + idDocumento);
            String urlDocumento = ClienteUCM.getInstance().obtenerUrl(idDocumento);
            logger.info("TERMINO: obtenerURL : " + urlDocumento);
            return urlDocumento;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ERROR: obtenerURL : " + e.getMessage(), e);
            return null;
        }
    }

    @WebMethod
    public Documento obtenerInfoDocumento(String idDocumento) {
        try {
            logger.info("INICIO: obtenerInfoDocumento : " + idDocumento);
            Documento documento = ClienteUCM.getInstance().obtenerInfoDocumento(idDocumento);
            logger.info("TERMINO: obtenerInfoDocumento : " + documento.getId() + " / " + documento.getNombre() + " / " + documento.getUrl() + " / " +
                        documento.getVersiones().size());
            return documento;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ERROR: obtenerInfoDocumento : " + e.getMessage(), e);
            return null;
        }
    }

    @WebMethod
    public byte[] obtenerDocumento(String idDocumento) {
        try {
            logger.info("INICIO: obtenerDocumento : " + idDocumento);
            InputStream stream = ClienteUCM.getInstance().obtenerDocumento(idDocumento).getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int nRead;
            byte[] data = new byte[16384];
            while ((nRead = stream.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
            buffer.close();
            logger.info("TERMINO: obtenerDocumento : " + buffer.size());
            return buffer.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ERROR: obtenerDocumento : " + e.getMessage(), e);
            return null;
        }
    }
}
