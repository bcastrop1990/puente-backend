package pe.gob.senasa.ws;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;

import pe.gob.senasa.bean.Recibo;
import pe.gob.senasa.bean.ServicioPago;
import pe.gob.senasa.bean.ServicioPagos;
import pe.gob.senasa.bean.TipoPago;
import pe.gob.senasa.dao.PagosDAO;
import pe.gob.senasa.gestion.GestionRecibo;
import pe.gob.senasa.interfaces.PagosInterface;


@XmlSeeAlso( { Recibo.class, ServicioPago.class, ServicioPagos.class })
@WebService(name = "Pagos", serviceName = "Pagos", portName = "PagosPort", targetNamespace = "http://pagos.ws.senasa.gob.pe")
public class PagosWS implements PagosInterface {
    private static transient long transaccion = 0;
    private String txId = "";
    PagosDAO pDAO = null;

    public PagosWS() {
        pDAO = new PagosDAO();
    }

    @WebMethod
    public String guardarReciboPago(Recibo reciboPago) {
        return pDAO.guardarReciboPago(reciboPago);
    }

    @WebMethod
    public String generarReciboPago(Recibo reciboPago) {
        transaccion++;
        txId = "txId=[" + String.valueOf(transaccion) + "] ";
        return new GestionRecibo().generarRecibo(txId, reciboPago);
    }

    @WebMethod
    public String registrarPago(String codigoRecibo, Integer codTipoPago, Double monto, String fechaOper, String boletaFecha,
                                String boletaNumero, String dniRuc) {
        return pDAO.registrarPago(codigoRecibo, codTipoPago, monto, fechaOper, boletaFecha, boletaNumero, dniRuc);
    }

    @WebMethod
    public String actualizarRecibo(String codigoRecibo, String observacion, String urlRecibo, String ucmId) {
        return pDAO.actualizarRecibo(codigoRecibo, observacion, urlRecibo, ucmId);
    }

    @WebMethod
    public Recibo obtenerRecibo(String codigoRecibo) {
        return pDAO.obtenerRecibo(codigoRecibo);
    }

    @WebMethod
    public ArrayList<TipoPago> obtenerTipoPagos() {
        return pDAO.obtenerTipoPagos();
    }

    @WebMethod
    public ArrayList<ServicioPago> obtenerTarifario(ServicioPagos servicioPagos) {
        return pDAO.obtenerTarifario(servicioPagos);
    }

    @WebMethod
    public Boolean existeNumeroBoleta(String numeroBoleta) {
        return pDAO.existeNumeroBoleta(numeroBoleta);
    }

    @WebMethod
    public Recibo obtenerReciboVUCE(String codigoExpediente, String codigoServicio, String idOrdenVuce) {
        return pDAO.obtenerReciboVUCE(codigoExpediente, codigoServicio, idOrdenVuce);
    }
}
