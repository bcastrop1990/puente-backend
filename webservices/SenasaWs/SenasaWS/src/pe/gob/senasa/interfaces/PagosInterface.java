package pe.gob.senasa.interfaces;

import java.util.ArrayList;

import pe.gob.senasa.bean.Recibo;
import pe.gob.senasa.bean.ServicioPago;
import pe.gob.senasa.bean.ServicioPagos;
import pe.gob.senasa.bean.TipoPago;


public interface PagosInterface {

    public String guardarReciboPago(Recibo reciboPago);

    public String registrarPago(String codigoRecibo, Integer codTipoPago, Double monto, String fechaOper, String boletaFecha,
                                String boletaNumero, String dniRuc);

    public String actualizarRecibo(String codigoRecibo, String observacion, String urlRecibo, String ucmId);

    public Recibo obtenerRecibo(String codigoRecibo);

    public ArrayList<TipoPago> obtenerTipoPagos();

    public ArrayList<ServicioPago> obtenerTarifario(ServicioPagos servicioPagos);

    public Boolean existeNumeroBoleta(String numeroBoleta);

    public Recibo obtenerReciboVUCE(String codigoExpediente, String codigoServicio, String idOrdenVuce);
}
