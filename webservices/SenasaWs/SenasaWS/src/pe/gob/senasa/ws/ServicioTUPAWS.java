package pe.gob.senasa.ws;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import pe.gob.senasa.bean.Analisis;
import pe.gob.senasa.bean.AreaGestion;
import pe.gob.senasa.bean.CentroTramite;
import pe.gob.senasa.bean.ExpPersonaJuridica;
import pe.gob.senasa.bean.ExpPersonaNatural;
import pe.gob.senasa.bean.Expediente;
import pe.gob.senasa.bean.OperLogisticoJuridica;
import pe.gob.senasa.bean.OperLogisticoNatural;
import pe.gob.senasa.bean.Operador;
import pe.gob.senasa.bean.Producto;
import pe.gob.senasa.bean.Recibo;
import pe.gob.senasa.bean.RequisitoServicio;
import pe.gob.senasa.bean.Sede;
import pe.gob.senasa.bean.ServicioClase;
import pe.gob.senasa.bean.ServicioTUPA;
import pe.gob.senasa.bean.Solicitante;
import pe.gob.senasa.bean.Vacuna;
import pe.gob.senasa.dao.ServicioTUPADAO;
import pe.gob.senasa.interfaces.ServicioTUPAInterface;


/**
 * Manejo de informaci�n y operaciones de los servicios TUPA.
 */
@WebService(name = "ServicioTUPA", serviceName = "ServicioTUPA", portName = "ServicioTUPAPort",
            targetNamespace = "http://serviciotupa.ws.senasa.gob.pe")
public class ServicioTUPAWS implements ServicioTUPAInterface {
    ServicioTUPADAO sDAO = null;

    /**
     */
    public ServicioTUPAWS() {
        sDAO = new ServicioTUPADAO();
    }

    /**
     *
     * status: Terminado
     * @return
     */
    @WebMethod
    public ArrayList<ServicioTUPA> obtenerServiciosTupa() {
        return sDAO.obtenerServiciosTupa();
    }

    /**
     *
     * status: Terminado
     * @param servicioTupa
     * @param sede
     * @param codigoCliente
     * @return
     */
    @WebMethod
    public String obtenerNumeroExpediente(String servicioTupa, String sede, String codigoCliente) {
        return sDAO.obtenerNumeroExpediente(servicioTupa, sede, codigoCliente);
    }

    /**
     *
     * status: Terminado
     * @param servicioTupa
     * @param sede
     * @return
     */
    @WebMethod
    public String obtenerNumeroCertificado(String servicioTupa, String sede) {
        return sDAO.obtenerNumeroCertificado(servicioTupa, sede);
    }

    public String obtenerServicio(String codigoServicio) {
        return null;
    }

    @WebMethod
    public String obtenerDescripcionServicio(String codigoServicio) {
        return sDAO.obtenerDescripcionServicio(codigoServicio);
    }

    /**
     * @param codigoServicio
     * @return
     */
    @WebMethod
    public boolean servicioTupaCobrarPorProducto(String codigoServicio) {
        return sDAO.servicioTupaCobrarPorProducto(codigoServicio);
    }

    /**
     * @return
     */
    @WebMethod
    public ArrayList<AreaGestion> obtenerAreasGestion() {
        return sDAO.obtenerAreasGestion();
    }

    @WebMethod
    public ArrayList<CentroTramite> obtenerCentrosTramite() {
        return sDAO.obtenerCentrosTramite();
    }

    @WebMethod
    public ArrayList<CentroTramite> obtenerCentrosTramitePorDepartamento(String codDepartamento) {
        return sDAO.obtenerCentrosTramitePorDepartamento(codDepartamento);
    }

    @WebMethod
    public ArrayList<ServicioTUPA> obtenerServicioXCentroTramite(String codigoCentroTramite, String codigoAreaGestion) {
        return sDAO.obtenerServicioXCentroTramite(codigoCentroTramite, codigoAreaGestion);
    }

    @WebMethod
    public ArrayList<RequisitoServicio> obtenerRequisitoXServicio(String codigoServicio) {
        return sDAO.obtenerRequisitoXServicio(codigoServicio);
    }

    @WebMethod
    public ArrayList<ExpPersonaNatural> obtenerExpedientePersonaNatural(String codigoExpediente) {
        return sDAO.obtenerExpedientePersonaNatural(codigoExpediente);
    }

    @WebMethod
    public ArrayList<ExpPersonaJuridica> obtenerExpedientePersonaJuridica(String codigoExpediente) {
        return sDAO.obtenerExpedientePersonaJuridica(codigoExpediente);
    }

    @WebMethod
    public ArrayList<OperLogisticoNatural> obtenerOperLogisticoNatural() {
        return sDAO.obtenerOperLogisticoNatural();
    }

    @WebMethod
    public ArrayList<OperLogisticoJuridica> obtenerOperLogisticoJuridica() {
        return sDAO.obtenerOperLogisticoJuridica();
    }

    @WebMethod
    public String obtenerClaseExpServicio(String codigoExpediente) {
        return sDAO.obtenerClaseExpServicio(codigoExpediente);
    }

    @WebMethod
    public ArrayList<ServicioClase> obtenerServiciosXClase(String codigoClase) {
        return sDAO.obtenerServiciosXClase(codigoClase);
    }

    @WebMethod
    public String obtenerInspeccionesExpediente(String codigoExpediente, String codigoServicio) {
        return sDAO.obtenerInspeccionesExpediente(codigoExpediente, codigoServicio);
    }

    @WebMethod
    public String obtenerTipoServicioExpediente(String codigoExpediente, String codigoServicio) {
        return sDAO.obtenerTipoServicioExpediente(codigoExpediente, codigoServicio);
    }

    @WebMethod
    public ArrayList<Sede> obtenerPuntosIngreso(String codigoExpediente, String codigoServicio) {
        return sDAO.obtenerPuntosIngreso(codigoExpediente, codigoServicio);
    }

    @WebMethod
    public ArrayList<Producto> obtenerProductosExp(String codigoExpediente, String codPuntoIngreso) {
        return sDAO.obtenerProductosExp(codigoExpediente, codPuntoIngreso);
    }

    @WebMethod
    public ArrayList<Producto> obtenerProductosInspeccion(String codigoExpediente, String codigoServicio) {
        return sDAO.obtenerProductosInspeccion(codigoExpediente, codigoServicio);
    }

    @WebMethod
    public Expediente obtenerExpediente(String codigoExpediente) {
        return sDAO.obtenerExpediente(codigoExpediente);
    }
    /*
    @WebMethod
    public String guardarReciboPago(Recibo reciboPago) {
    return  sDAO.guardarReciboPago(reciboPago);
  }*/

    @WebMethod
    public Operador obtenerOperador(String tipoDocumento, String numeroDocumento) {
        return sDAO.obtenerOperador(tipoDocumento, numeroDocumento);
    }

    @WebMethod
    public ArrayList<Vacuna> obtenerListaVacunas() {
        return sDAO.obtenerListaVacunas();
    }

    @WebMethod
    public ArrayList<Analisis> obtenerListaAnalisis() {
        return sDAO.obtenerListaAnalisis();
    }

    @WebMethod
    public Solicitante obtenerSolicitanteExp(String codigoExpediente) {
        return sDAO.obtenerSolicitanteExp(codigoExpediente);
    }

    @WebMethod
    public String anularExpediente(String codigoExpediente) {
        return sDAO.anularExpediente(codigoExpediente);
    }

    @WebMethod
    public ArrayList<ServicioTUPA> obtenerServiciosExpediente(String codigoExpediente) {
        return sDAO.obtenerServiciosExpediente(codigoExpediente);
    }

    @WebMethod
    public String anularServicioExpediente(String codigoExpediente, String codigosServicios) {
        return sDAO.anularServicioExpediente(codigoExpediente, codigosServicios);
    }

    @WebMethod
    public ArrayList<Recibo> obtenerListaRecibos(String codigoExpediente, String codigoServicio) {
        return sDAO.obtenerListaRecibos(codigoExpediente, codigoServicio);
    }

    @WebMethod
    public String anularBoletas(String codigosRecibos) {
        return sDAO.anularBoletas(codigosRecibos);
    }

    @WebMethod
    public ServicioTUPA obtenerInformacionServicioTupa(String codigosServicio) {
        return sDAO.obtenerInformacionServicioTupa(codigosServicio);
    }
}
