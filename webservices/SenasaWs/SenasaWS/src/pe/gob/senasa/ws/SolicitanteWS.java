package pe.gob.senasa.ws;

import java.util.ArrayList;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;

import pe.gob.senasa.bean.Importador;
import pe.gob.senasa.bean.PredioCPE;
import pe.gob.senasa.bean.Recibo;
import pe.gob.senasa.bean.ReciboServicio;
import pe.gob.senasa.bean.Solicitante;
import pe.gob.senasa.bean.TipoDocIden;
import pe.gob.senasa.bean.TipoFiltro;
import pe.gob.senasa.dao.SolicitanteDAO;
import pe.gob.senasa.interfaces.SolicitanteInterface;


/**
 * Manejo de información y operaciones de los solicitantes.
 */
@XmlSeeAlso({ReciboServicio.class})
@WebService(name = "Solicitante", serviceName = "Solicitante", portName = "SolicitantePort", targetNamespace = "http://solicitante.ws.senasa.gob.pe")
public class SolicitanteWS implements SolicitanteInterface {
    
    SolicitanteDAO sDAO = null;
    
    public SolicitanteWS() {
        sDAO = new SolicitanteDAO();
    }


    /**
     * Permite obtener el solicitante
     * status: terminado
     * @param tipoDoc
     * @param numeroDoc
     * @return
     */
    @WebMethod
    public Solicitante obtenerSolicitante(String tipoDoc, String numeroDoc){
        return sDAO.obtenerSolicitante(tipoDoc,numeroDoc);
    }

    /**
     * Permite adicionar solicitante
     * status: terminado
     * @param argSolicitante
     * @return
     */
    @WebMethod
    public Boolean adicionarSolicitante(Solicitante argSolicitante){
        return sDAO.adicionarSolicitante(argSolicitante);
    }


    /**
     * Permite obtener los predios de un solicitante
     * status: terminado
     * @param dniRucSolicitante
     * @return
     */
    @WebMethod
    public ArrayList<PredioCPE> obtenerPrediosCPESolicitante(String dniRucSolicitante){
        return sDAO.obtenerPrediosCPESolicitante(dniRucSolicitante);
    }


    /**
     * Permite validar el almacen de guarda custodia
     * status: terminado
     * @param dniRucSolicitante
     * @param registro
     * @return
     */
    @WebMethod
    public Boolean validarAlmacenGuardacustodia(String dniRucSolicitante, String registro){
        return sDAO.validarAlmacenGuardacustodia(dniRucSolicitante, registro);
    }


    /**
     * Permite validar el germoplasma
     * status: terminado
     * @param dniRucSolicitante
     * @param registro
     * @return
     */
    @WebMethod
    public Boolean validarGermoplasma(String dniRucSolicitante, String registro){
        return sDAO.validarGermoplasma(dniRucSolicitante,registro);
    }

    /**
     * permite validar el registro de cuarentena posentrada
     * status: terminado
     * @param dniRucSolicitante
     * @param registro
     * @return
     */
    @WebMethod
    public Boolean validarRegistroCPE(String dniRucSolicitante, String registro){
        return sDAO.validarRegistroCPE(dniRucSolicitante,registro);
    }

    /**
     * permite obtener el saldo a favor de un solicitante
     * status: terminado
     * @param dniRucSolicitante
     * @return
     */
    @WebMethod
    public Double obtenerSaldoFavorSolicitante(String dniRucSolicitante){
        return sDAO.obtenerSaldoFavorSolicitante(dniRucSolicitante);
    }

    /**
     * permite abonar el saldo a favor de un solicitante
     * status: terminado
     * @param rucAgenteAduanas
     * @param papeletaID
     * @param excedente
     * @return
     */
    @WebMethod
    public String abonarSaldoFavorSolicitantePapeleta(String rucAgenteAduanas,
                                                      String papeletaID,
                                                      Double excedente) {
        return sDAO.abonarSaldoFavorSolicitantePapeleta(rucAgenteAduanas, papeletaID, excedente);
    }

    /**
     *
     * status: terminado
     * @param rucAgenteAduanas
     * @param notaabono
     * @param excedente
     * @return
     */
    @WebMethod
    public String abonarSaldoFavorSolicitanteNotaAbono(String rucAgenteAduanas,
                                                       String notaabono,
                                                       Double excedente) {
        return sDAO.abonarSaldoFavorSolicitanteNotaAbono(rucAgenteAduanas, notaabono, excedente);
    }

    /**
     *
     * status: terminado
     * @param dniRucSolicitante
     * @param tipodeposito
     * @param numerodeposito
     * @param fechadeposito
     * @param montodepositado
     * @return
     */
    @WebMethod
    public String crearDocPapeleta(String dniRucSolicitante, String tipodeposito,
                                String numerodeposito, Date fechadeposito,
                                Double montodepositado) {
        return sDAO.crearDocPapeleta(dniRucSolicitante, tipodeposito, numerodeposito, fechadeposito, montodepositado);
    }

    /**
     *
     * status: terminado
     * @return
     */
    @WebMethod
    public ArrayList<TipoDocIden> obtenerTiposDocInden() {
        return sDAO.obtenerTiposDocInden();
    }

    /**
     *
     * status: terminado
     * @param dni
     * @param excendete
     * @return
     */
    @WebMethod
    public Boolean abonarSaldoSolicitante(String dni,Double excendete) {
      return true;
  }

    /**
     *
     *
     * @param codPais
     * @return
     */
    @WebMethod
    public ArrayList<Importador> obtenerImportadoresXPais(String codPais) {
        return sDAO.obtenerImportadoresXPais(codPais);
  }
  /**
     *
     * @param dniRucSolicitante
     * @param montoUtilizado
     * @return
     */
    @WebMethod
    public String cargarSaldo(String dniRucSolicitante, Double montoUtilizado) {
      return sDAO.cargarSaldo(dniRucSolicitante,montoUtilizado);
  }
  /**
     *
     * @param codigoRecibo
     * @param numeroRecibo
     * @param fechaRecibo
     * @param codigoCentroTramite
     * @param dniRucSolicitante
     * @param codigoExpediente
     * @param montoPagado
     * @param montoRecibo
     * @param montoSaldo
     * @param urlRecibo
     * @param arrayRecibosServicios
     * @return
     */
    @WebMethod
    public String guardarRecibo(String numeroRecibo, String fechaRecibo, 
                                String codigoCentroTramite, String dniRucSolicitante, String codigoExpediente, 
                                Double montoPagado, Double montoRecibo, Double montoSaldo, String observacion, String urlRecibo, ArrayList<ReciboServicio> arrayRecibosServicios) {
      return sDAO.guardarRecibo(numeroRecibo, fechaRecibo, codigoCentroTramite, dniRucSolicitante, codigoExpediente, montoPagado, montoRecibo, montoSaldo, observacion, urlRecibo, arrayRecibosServicios);
  }

  /*

  @WebMethod
  public Boolean guardarReciboServicio(String codigoRecibo, String codigoServicio, Double montoServicio, Double cantidad) {
      return sDAO.guardarReciboServicio(codigoRecibo, codigoServicio, montoServicio, cantidad);
  }
  */

    @WebMethod
    public Recibo obtenerDatosRecibo(String codigoRecibo) {
    return sDAO.obtenerDatosRecibo(codigoRecibo);
  }

    @WebMethod
    public Boolean actualizaUrlRecibo(String codigoRecibo, String urlRecibo) {
    return sDAO.actualizaUrlRecibo(codigoRecibo, urlRecibo);
  }
  
    @WebMethod
    public ArrayList<Solicitante> obtenerRepresentanteLegal(String codPersona) {
    return sDAO.obtenerRepresentanteLegal(codPersona);
  }

    @WebMethod
    public Solicitante obtenerSolicitanteXidPersona(String idPersona) {
        return sDAO.obtenerSolicitanteXidPersona(idPersona);
    }

  @WebMethod
	public ArrayList<Solicitante> obtenerSolicitantesFiltrados(String tipoFiltro, String valorFiltro) {
		return sDAO.obtenerSolicitantesFiltrados(tipoFiltro, valorFiltro);
	}

  @WebMethod
	public ArrayList<TipoFiltro> obtenerTiposFiltroPersona() {
		return sDAO.obtenerTiposFiltroPersona();
	}
}
