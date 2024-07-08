package pe.gob.senasa.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import pe.gob.senasa.bean.Adicional;
import pe.gob.senasa.bean.RequisitoServicio;
import pe.gob.senasa.bean.RequisitosDocumentales;
import pe.gob.senasa.bean.ValidaDocumentoPropio;
import pe.gob.senasa.dao.RequisitosDocumentalesDAO;
import pe.gob.senasa.interfaces.RequisitosDocumentalesInterface;


/**
 * Manejo de información y operaciones de los requisitos documentales.
 */
@WebService(name = "RequisitosDocumentales",serviceName = "RequisitosDocumentales",
            targetNamespace = "http://requisitosdocumentales.ws.senasa.gob.pe",
            portName = "RequisitosDocumentalesPort")
public class RequisitosDocumentalesWS implements RequisitosDocumentalesInterface {
    
    RequisitosDocumentalesDAO rdDAO  = null;

    /**
     */
    public RequisitosDocumentalesWS() {
        rdDAO  = new RequisitosDocumentalesDAO();
    }


    /**
     * 
     * status: En pruebas
     * @param servicioTUPA
     * @return
     */
    @WebMethod
    public ArrayList<RequisitosDocumentales> obtenerRequisitosDocumentales(@WebParam(name = "codigoServicio") String servicioTUPA){
        return rdDAO.obtenerRequisitosDocumentales(servicioTUPA);
    }
    @WebMethod
    public ArrayList<RequisitoServicio> obtenerListaRequisitosPropios(@WebParam(name = "codigoServicio") String codigoServicio,
                                                                      @WebParam(name = "idPersona") String idPersona){
      return rdDAO.obtenerListaRequisitosPropios(codigoServicio,idPersona);
    }
   
   /* public Double ValidarDocumentoPropio(@WebParam(name = "dniRuc") String dniRuc, 
                                         @WebParam(name = "codigoDocumento")String codigoDocumento, 
                                         @WebParam(name = "numeroDocumento")String numeroDocumento, 
                                         @WebParam(name = "tramaProductos")String tramaProductos) {
      return rdDAO.ValidarDocumentoPropio(dniRuc, codigoDocumento, numeroDocumento, tramaProductos);
    }*/
    
  @WebMethod
  public ValidaDocumentoPropio validarDocumentoPropio(@WebParam(name = "prmDocPropio") ValidaDocumentoPropio prmLista) {      
    return rdDAO.validarDocumentoPropio(prmLista);
  }
  @WebMethod
  public List<Adicional> obtenerPredios(@WebParam(name = "idPersona") String idPersona) {      
    return rdDAO.obtenerPredios(idPersona);
  }
    
}