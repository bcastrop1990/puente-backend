package pe.gob.senasa.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.Documento;
import pe.gob.senasa.bean.DocumentoElectronico;
import pe.gob.senasa.bean.Encargatura;
import pe.gob.senasa.bean.ReporteSTD;
import pe.gob.senasa.bean.SubTipo;
import pe.gob.senasa.bean.Trazabilidad;
import pe.gob.senasa.bean.audit.Audit;
import pe.gob.senasa.bean.std.DocumentoSTD;
import pe.gob.senasa.bean.std.Expediente;
import pe.gob.senasa.dao.TramiteDocumentarioDAO;
import pe.gob.senasa.gestion.GestionTramiteDocumentario;
import pe.gob.senasa.interfaces.TramiteDocumentarioInterface;
import pe.gob.senasa.tupa.CreacionDocumentos;


/**
 * Manejo de información y operaciones de Producto.
 */
@XmlSeeAlso( { Trazabilidad.class, DocumentoSTD.class })
@WebService(name = "TramiteDocumentario", serviceName = "TramiteDocumentario",
            targetNamespace = "http://tramitedocumentario.ws.senasa.gob.pe", portName = "TramiteDocumentarioPort")

public class TramiteDocumentarioWS implements TramiteDocumentarioInterface {
    private static transient long transaccion = 0;
    private String txId = "";
    TramiteDocumentarioDAO sDAO = null;
    private GestionTramiteDocumentario gestionTramite = null;
    private CreacionDocumentos creacionDocumentos = null;
  protected static Logger logger = Logger.getLogger(CreacionDocumentos.class);
    public TramiteDocumentarioWS() {
        super();
        sDAO = new TramiteDocumentarioDAO();
    }

    @WebMethod
    public Documento generarDocumentoTramite(@WebParam(name = "documentoFisico")
        byte[] documentoFisico, @WebParam(name = "nombre")
        String nombre, @WebParam(name = "documento")
        Documento documento) {
        transaccion++;
        txId = "txId=[" + String.valueOf(transaccion) + "] ";
        gestionTramite = new GestionTramiteDocumentario();
        return gestionTramite.generarDocumento(txId, documentoFisico, nombre, documento);
    }

    @WebMethod
    public byte[] previsualizarIngresoDocTramite(byte[] documentoFisico, String nombre, Documento documento) {
        transaccion++;
        txId = "txId=[" + String.valueOf(transaccion) + "] ";
        try {
            creacionDocumentos = new CreacionDocumentos();
            return creacionDocumentos.previsualizarIngreso(txId, documentoFisico, nombre, documento);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    @WebMethod
    public void eliminarNumeracioDocumento(@WebParam(name = "subTipo")
        String subTipo, @WebParam(name = "area")
        String area, @WebParam(name = "subArea")
        String subArea, @WebParam(name = "personaId")
        String personaId) {
        sDAO.eliminarNumeracioDocumento(subTipo, area, subArea, personaId);
    }

    @WebMethod
    public String registrarDocumento(DocumentoSTD documento, String usuario) {
        return sDAO.registrarDocumento(documento, usuario);
    }

    @WebMethod
    public void actualizarDocumento(DocumentoSTD documento, String usuario) {
        sDAO.actualizarDocumento(documento, usuario);
    }
    
  @WebMethod
  public void actualizarArchivo(DocumentoSTD documento, String usuario) {
      sDAO.actualizarArchivo(documento, usuario);
  }


    @WebMethod
    public void eliminarDocumentoAdjunto(DocumentoSTD documento) {
        sDAO.eliminarDocumentoAdjunto(documento);
    }

    @WebMethod
    public ArrayList<DocumentoSTD> obtenerAdjuntos(DocumentoSTD doc) {
        return sDAO.obtenerAdjuntos(doc);
    }

    @WebMethod
    public int verificaParticipacion(DocumentoSTD doc) {
        return sDAO.verificaParticipacion(doc);
    }

    @WebMethod
    public List<ReporteSTD> consultaSTDGeneral(ReporteSTD reporteSTD) {
        return sDAO.consultaSTDGeneral(reporteSTD);
    }

  @WebMethod
  public List<ReporteSTD> consultaSTDGeneralExterno(ReporteSTD reporteSTD) {
      return sDAO.consultaSTDGeneralExterno(reporteSTD);
  }

    @WebMethod
    public List<DocumentoSTD> consultaSTDDocumentos(String codElemento) {
        return sDAO.consultaSTDDocumentos(codElemento);
    }

    @WebMethod
    public List<ReporteSTD> consultaSTDxIdFinal(String idFinal) {
        return sDAO.consultaSTDxIdFinal(idFinal);
    }

    @WebMethod
    public List<Encargatura> obtenerEncargatura(String usuario) {
        return sDAO.obtenerEncargatura(usuario);
    }

    @WebMethod
    public List<Encargatura> obtenerEncargado(String usuario) {
        return sDAO.obtenerEncargado(usuario);
    }

    @WebMethod
    public Boolean eliminarDocumentoSTD(@WebParam(name = "pcodigoSTD")
        String pcodigoSTD, @WebParam(name = "pIdUcm")
        String pIdUcm) {
        return sDAO.eliminarDocumentoSTD(pcodigoSTD, pIdUcm);
    }

    @WebMethod
    public List<DocumentoElectronico> obtenerBandejaElectronica() {
        return sDAO.obtenerBandejaElectronica();
    }

    @WebMethod
    public void procesarDocumentoElectronico(@WebParam(name = "idEntidad")
        String idEntidad, @WebParam(name = "idTransaccion")
        String idTransaccion, @WebParam(name = "codigoDocumento")
        String codigoDocumento, @WebParam(name = "accion")
        String accion, @WebParam(name = "usuario")
        String usuario) {
        sDAO.procesarDocumentoElectronico(idEntidad, idTransaccion, codigoDocumento, accion, usuario);
    }

    @WebMethod
    public Expediente obtenerExpedienteStd(String numeroExpediente) {
        return sDAO.obtenerExpedienteStd(numeroExpediente);
    }

    @WebMethod
    public DocumentoSTD obtenerDocumentoStd(String codigoDocumento, String numeroDocumento) {
        return sDAO.obtenerDocumentoStd(codigoDocumento,numeroDocumento);
    }
    
    @WebMethod
    public List<SubTipo> obtenerTiposDocMesaPartes() {
        return sDAO.obtenerTiposDocMesaPartes();
    }
    
    // ELIMINAR PARA VERSION 3
    
    @WebMethod
    public Expediente registrarExpediente(String personaId, String codigoCentro, String observacion, String userName) {
        return sDAO.registrarExpediente(personaId, codigoCentro, observacion, userName);
    }

    @WebMethod
    public Audit anexarDocumentoExpediente(String codigoDocumento, String codigoExpediente, String userName) {
        return sDAO.anexarDocumentoExpediente(codigoDocumento, codigoExpediente, userName);
    }
  @WebMethod
  public boolean updPermiso(@WebParam(name = "documentoSTD")DocumentoSTD doc) {
    /*byte[] buffer=null;
    GestionDocumentoWS_PortType port=null;
      try{
    GestionDocumentoWS_ServiceLocator serviceLocator =
        new GestionDocumentoWS_ServiceLocator();
    port = serviceLocator.getGestionDocumentoWSPort();
    logger.info("ucmId : " + doc.getUcmId());
     buffer = port.obtenerDocumento(doc.getUcmId());
    }
    catch (Exception e) {
    logger.error( e.getMessage() );
    }

    if (buffer != null && buffer.length > 0) {
      ByteArrayInputStream bis = new ByteArrayInputStream(buffer);
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      try {
        PdfReader reader = new PdfReader(bis);
        PdfStamper stamper = new PdfStamper(reader, bos);
             stamper.setEncryption(null, null, ~(PdfWriter.ALLOW_COPY | PdfWriter.ALLOW_SCREENREADERS),
                 PdfWriter.ENCRYPTION_AES_128 | PdfWriter.DO_NOT_ENCRYPT_METADATA);          
        stamper.close();
             //String ucmIdRet = port.registrarDocumento(doc.getUcmId(), doc.getNombre(),doc.getAutor(), doc.getTipo(),"Interno","STD", doc.getUcmId()+".pdf", buffer, null);
             String ucmIdRet = port.registrarDocumento(doc.getUcmId(), doc.getNombre(),doc.getAutor(), doc.getTipo(),"Interno","STD", doc.getUcmId()+".pdf", bos.toByteArray(), null);
           } catch (IOException e) {
        e.printStackTrace();
      } catch (DocumentException e) {
        e.printStackTrace();
      }
      

  }
*/
    return true;
  }

}
