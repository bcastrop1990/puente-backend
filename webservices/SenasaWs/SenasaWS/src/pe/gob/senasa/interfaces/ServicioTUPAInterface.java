package pe.gob.senasa.interfaces;

import java.util.ArrayList;

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


public interface ServicioTUPAInterface {

    public ArrayList<pe.gob.senasa.bean.ServicioTUPA> obtenerServiciosTupa();

    public String obtenerNumeroExpediente(String servicioTupa, String sede, String codigoCliente);

    public String obtenerNumeroCertificado(String servicioTupa, String sede);

    public String obtenerServicio(String codigoServicio);

    public String obtenerDescripcionServicio(String codigoServicio);

    public boolean servicioTupaCobrarPorProducto(String codigoServicio);

    public ArrayList<AreaGestion> obtenerAreasGestion();

    public ArrayList<CentroTramite> obtenerCentrosTramite();

    public ArrayList<CentroTramite> obtenerCentrosTramitePorDepartamento(String codDepartamento);

    public ArrayList<ServicioTUPA> obtenerServicioXCentroTramite(String codigoCentroTramite, String codigoAreaGestion);

    public ArrayList<RequisitoServicio> obtenerRequisitoXServicio(String codigoServicio);

    public ArrayList<ExpPersonaNatural> obtenerExpedientePersonaNatural(String codigoExpediente);

    public ArrayList<ExpPersonaJuridica> obtenerExpedientePersonaJuridica(String codigoExpediente);

    public ArrayList<OperLogisticoNatural> obtenerOperLogisticoNatural();

    public ArrayList<OperLogisticoJuridica> obtenerOperLogisticoJuridica();

    public String obtenerClaseExpServicio(String codigoExpediente);

    public ArrayList<ServicioClase> obtenerServiciosXClase(String codigoClase);

    public String obtenerInspeccionesExpediente(String codigoExpediente, String codigoServicio);

    public String obtenerTipoServicioExpediente(String codigoExpediente, String codigoServicio);

    public ArrayList<Sede> obtenerPuntosIngreso(String codigoExpediente, String codigoServicio);

    public ArrayList<Producto> obtenerProductosExp(String codigoExpediente, String codPuntoIngreso);

    public ArrayList<Producto> obtenerProductosInspeccion(String codigoExpediente, String codigoServicio);

    public Expediente obtenerExpediente(String codigoExpediente);
    //public String guardarReciboPago(Recibo reciboPago);

    public Operador obtenerOperador(String tipoDocumento, String numeroDocumento);

    public ArrayList<Vacuna> obtenerListaVacunas();

    public ArrayList<Analisis> obtenerListaAnalisis();

    public Solicitante obtenerSolicitanteExp(String codigoExpediente);

    public String anularExpediente(String codigoExpediente);

    public ArrayList<ServicioTUPA> obtenerServiciosExpediente(String codigoExpediente);

    public String anularServicioExpediente(String codigoExpediente, String codigosServicios);

    public ArrayList<Recibo> obtenerListaRecibos(String codigoExpediente, String codigoServicio);

    public String anularBoletas(String codigosRecibos);

    public ServicioTUPA obtenerInformacionServicioTupa(String codigosServicio);

}
