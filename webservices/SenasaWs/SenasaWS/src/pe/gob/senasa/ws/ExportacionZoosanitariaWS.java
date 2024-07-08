
package pe.gob.senasa.ws;


import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import pe.gob.senasa.bean.AutorizacionSanitariaEstExpoZoo;
import pe.gob.senasa.bean.ExportacionZooSanitaria;
import pe.gob.senasa.dao.ExportacionZooSanitariaDAO;
import pe.gob.senasa.interfaces.ExportacionZooSanitariaInterface;


/**
 * Manejo de información y operaciones de exportacion zoosanitaria.
 */
@WebService(name = "ExportacionZoosanitaria",
            serviceName = "ExportacionZoosanitaria",
            targetNamespace = "http://exportacionzoosanitaria.ws.senasa.gob.pe",
            portName = "ExportacionZoosanitariaPort")
public class ExportacionZoosanitariaWS implements ExportacionZooSanitariaInterface {

    ExportacionZooSanitariaDAO ezs = null;

    /**
     */
    public ExportacionZoosanitariaWS() {

        ezs = new ExportacionZooSanitariaDAO();

    }


    /**
     *
     * status: Terminado
     * @param partidaArancelaria
     * @param paisProcedencia
     * @param usoDestino
     * @return
     */
    @WebMethod
    public ArrayList obtenerRequisitosSanitariosExpoZoo(String partidaArancelaria,
                                                        String paisProcedencia,
                                                        String usoDestino) {

        return ezs.obtenerRequisitosSanitariosExpoZoo(partidaArancelaria,
                                                      paisProcedencia,
                                                      usoDestino);
    }

    /**
     *
     * status: Terminado
     * @param noCertificado
     * @return
     */
    @WebMethod
    public ExportacionZooSanitaria obtenerExportacionZooXNoCertificado(String noCertificado) {
        return ezs.obtenerExportacionZooXNoCertificado(noCertificado);
    }

    /**
     *
     * status: Terminado
     * @param noCertificado
     * @return
     */
    @WebMethod
    public boolean ampliarCertificadoExpoZoo(String noCertificado) {
        return true;
    }

    /**
     *
     * status: Terminado
     * @param dniRuc
     * @return
     */
    @WebMethod
    public ArrayList<ExportacionZooSanitaria> obtenerExportacionZooxSolicitante(String dniRuc) {
        return ezs.obtenerExportacionZooxSolicitante(dniRuc);
    }

    /**
     *
     * status: Terminado
     * @param expoZoo
     * @return
     */
    @WebMethod
    public Boolean guardarExportacionZoo(ExportacionZooSanitaria expoZoo) {
        return ezs.guardarExportacionZoo(expoZoo);
    }

    @WebMethod
    public String obtenerNumeroCertificadoExpoZoo(String sede){
        return ezs.obtenerNumeroCertificadoExpoZoo(sede);
    }    
    @WebMethod
    public AutorizacionSanitariaEstExpoZoo obtenerDatosAutorizacionExpoZoo(@WebParam(name = "nroExpediente")String nroExpediente,@WebParam(name = "codigoServicio") String codigoServicio){
        return ezs.obtenerDatosAutorizacionExpoZoo(nroExpediente, codigoServicio);    
    }
    
}
