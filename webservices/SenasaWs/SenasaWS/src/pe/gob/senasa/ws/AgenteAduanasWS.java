package pe.gob.senasa.ws;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

import pe.gob.senasa.bean.AgenteAduanas;
import pe.gob.senasa.dao.AgenteAduanasDAO;
import pe.gob.senasa.interfaces.AgenteAduanasInterface;


/**
 * Servicios para el manejo de la información relacionada con las agencias de aduanas.
 */
@WebService(name = "AgenteAduanas",serviceName = "AgenteAduanas",
            targetNamespace = "http://aduanas.ws.senasa.gob.pe",
            portName = "AgenteAduanasPort")
public class AgenteAduanasWS implements AgenteAduanasInterface {

    AgenteAduanasDAO ageneDao = null;

    /**
     */
    public AgenteAduanasWS() {
        ageneDao = new AgenteAduanasDAO();
    }

    /**
	 *
	 * status: Terminado
	 * Permite obtener el agente de aduanas dado un nombre de documento.
	 * @param numeroDocumento
	 * @return
	 */
    @WebMethod
  public AgenteAduanas obtenerAgenteAduanas(String numeroDocumento) {
      return ageneDao.obtenerAgenteAduanas(numeroDocumento);
  }


    /**
     * 
     * status: Terminado
     * Permite obtener el saldo a favor del agente aduanal.
     * @param rucAgenteAduanas
     * @return
     */
    @WebMethod
    public double obtenerSaldoFavorAgenteAduanas(String rucAgenteAduanas) {
        return ageneDao.obtenerSaldoFavorAgenteAduanas(rucAgenteAduanas);
    }

    /**
     * 
     * status: Terminado
     * @param rucAgenteAduanas
     * @param papeletaID
     * @param excedente
     * @return
     */
    @WebMethod
    public String abonarSaldoFavorAgenteAduanasPapeleta(String rucAgenteAduanas,
                                                        String papeletaID,
                                                        Double excedente) {
        return ageneDao.abonarSaldoFavorAgenteAduanasNotaAbono(rucAgenteAduanas, papeletaID, excedente);
    }

    /**
     * 
     * status: Terminado
     * @param rucAgenteAduanas
     * @param notaabono
     * @param excedente
     * @return
     */
    @WebMethod
    public String abonarSaldoFavorAgenteAduanasNotaAbono(String rucAgenteAduanas,
                                                         String notaabono,
                                                         Double excedente) {
        return ageneDao.abonarSaldoFavorAgenteAduanasNotaAbono(rucAgenteAduanas, notaabono, excedente);
    }

    /**
     * 
     * status: Terminado
     * @param dniRucSolicitante
     * @param tipodeposito
     * @param numerodeposito
     * @param fechadeposito
     * @param montodepositado
     * @return
     */
    @WebMethod
    public String CrearPapeleta(String dniRucSolicitante, String tipodeposito,
                                String numerodeposito, Date fechadeposito,
                                Double montodepositado) {
        return ageneDao.CrearPapeleta(dniRucSolicitante, tipodeposito, numerodeposito, fechadeposito, montodepositado);
    }


    /**
     * 
     * status: Terminado
     * @param dni
     * @param excendete
     * @return
     */
    @WebMethod
      public Boolean abonarSaldoAgenciaAduanas(String dni,Double excendete) {
          return true;
      }
    
    @WebMethod
    public AgenteAduanas obtenerAgenteAduanasXidPersona(String idPersona) {
        return ageneDao.obtenerAgenteAduanasXidPersona(idPersona);
    }
}
