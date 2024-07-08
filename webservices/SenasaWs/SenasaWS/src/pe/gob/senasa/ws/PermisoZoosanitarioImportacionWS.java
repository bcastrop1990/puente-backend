package pe.gob.senasa.ws;


import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;

import pe.gob.senasa.bean.Ampliacion;
import pe.gob.senasa.bean.AnexoPFI;
import pe.gob.senasa.bean.PaisOrigenAnexoPFI;
import pe.gob.senasa.bean.PaisOrigenProductoPFI;
import pe.gob.senasa.bean.PermisoZoosanitarioImportacion;
import pe.gob.senasa.bean.ProductoPZI;
import pe.gob.senasa.dao.PermisoZooSanitarioImportacionDAO;
import pe.gob.senasa.dao.RequisitoDao;
import pe.gob.senasa.interfaces.PermisoZoosanitarioImportacionInterface;


/**
 * Manejo de información y operaciones de Importacion Zoosanitaria.
 */
@XmlSeeAlso( { java.util.ArrayList.class, ProductoPZI.class, PaisOrigenProductoPFI.class,  AnexoPFI.class,PaisOrigenAnexoPFI.class,Ampliacion.class})
@WebService(name = "PermisoZoosanitarioImportacion",serviceName = "PermisoZoosanitarioImportacion",
            targetNamespace = "http://permisozoosanitarioimportacion.ws.senasa.gob.pe",
            portName = "PermisoZoosanitarioImportacionPort")
public class PermisoZoosanitarioImportacionWS implements PermisoZoosanitarioImportacionInterface {
    
    PermisoZooSanitarioImportacionDAO pzsDAO = null;

    /**
     */
    public PermisoZoosanitarioImportacionWS() 
    {
        pzsDAO = new PermisoZooSanitarioImportacionDAO(); 
    }

    /**
     * 
     * status: Terminado
     * @param noCertificado
     * @return
     */
    @WebMethod
    public PermisoZoosanitarioImportacion obtenerPZIxNoCertificado(String noCertificado){
        return pzsDAO.obtenerPZIxNoCertificado(noCertificado);
    }

    /**
     * 
     * status: Terminado
     * @param dniRuc
     * @return
     */
    @WebMethod
    public ArrayList<PermisoZoosanitarioImportacion> obtenerPZIxSolicitante(String dniRuc){
        return pzsDAO.obtenerPZIxSolicitante(dniRuc);
    }

    /**
     * 
     * status: Terminado
     * @param pzi
     * @return
     */
    @WebMethod
    public Boolean guardarPZI(PermisoZoosanitarioImportacion pzi){
        return pzsDAO.guardarPZI(pzi);
    }

    /**
     * 
     * status: Terminado
     * @param noCertificado
     * @return
     */
    @WebMethod
    public Ampliacion ampliarCertificadoImpoZoo(String noCertificado,String tipo, int cantidad){
        return pzsDAO.ampliarCertificadoImpoZoo(noCertificado, tipo, cantidad);
    }
    
    
  @WebMethod
  public ArrayList<RequisitoDao> obtenerRequisitosSanitariosImpoZooXCertificado(String numeroCertificado){
      //return pzsDAO.ampliarCertificadoImpoZoo(noCertificado, tipo, cantidad);
      return pzsDAO.obtenerRequisitosSanitariosImpoZoo(numeroCertificado);
      
  }
  @WebMethod
  public String generarNroCertificado(String sede){
    return pzsDAO.generarNroCertificado(sede);
  }
  //////////////////////// METODOS VUCE ////////////////////////////////////////////
  @WebMethod 
  public PermisoZoosanitarioImportacion obtenerDatosPZIxExpediente(String nroExpediente){
      return pzsDAO.obtenerDatosPZIVuce(nroExpediente);
  }
  
  
}
