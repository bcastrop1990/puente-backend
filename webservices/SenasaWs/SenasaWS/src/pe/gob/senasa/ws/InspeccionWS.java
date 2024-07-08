package pe.gob.senasa.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;

import pe.gob.senasa.bean.ActividadVigilancia;
import pe.gob.senasa.bean.AreaLaboratorio;
import pe.gob.senasa.bean.Concepto;
import pe.gob.senasa.bean.EspeciesAnimales;
import pe.gob.senasa.bean.Lote;
import pe.gob.senasa.bean.ProcedenciaOrigenMuestra;
import pe.gob.senasa.bean.ProductoInspeccion;
import pe.gob.senasa.bean.PruebaDiagnostica;
import pe.gob.senasa.bean.Raza;
import pe.gob.senasa.bean.RespuestaAnalisisLaboratorio;
import pe.gob.senasa.bean.Sexo;
import pe.gob.senasa.bean.SolicitudAnalisisAnimal;
import pe.gob.senasa.bean.SolicitudAnalisisVegetal;
import pe.gob.senasa.bean.TipoCrianza;
import pe.gob.senasa.bean.TipoIdentificacionAnimal;
import pe.gob.senasa.bean.TipoMuestra;
import pe.gob.senasa.bean.TipoRechazo;
import pe.gob.senasa.bean.UnidadMedida;
import pe.gob.senasa.bean.VigilanciaActivaPruebas;
import pe.gob.senasa.dao.InspeccionDAO;
import pe.gob.senasa.gestion.GestionInspeccion;
import pe.gob.senasa.interfaces.InspeccionInterface;


@XmlSeeAlso({Concepto.class})
@WebService(name = "Inspecccion",serviceName = "Inspeccion",
            targetNamespace = "http://inspeccion.ws.senasa.gob.pe",
            portName = "InspeccionPort")
public class InspeccionWS implements InspeccionInterface {
    private static transient long transaccion = 0;
    private String txId = "";
    InspeccionDAO insp=null;
    
    public InspeccionWS() {
        super();
        insp = new InspeccionDAO();
    }

    /*@WebMethod
    public RespuestaInspeccion insertarInspeccion(pe.gob.senasa.bean.Inspeccion inspeccion) {
        return insp.insertarInspeccion(inspeccion);
    }*/

    @WebMethod
    public void actualizarProductoInspeccion(ProductoInspeccion productoInspeccion) 
    {
        insp.actualizarProductoInspeccion(productoInspeccion);
    }

    @WebMethod
    public String registrarLote(Lote lote)
    {
       return insp.registrarLote(lote);
    }

    @WebMethod
    public Lote consultarLote(String idLote) 
    {
       return insp.consultarLote(idLote);
    }

    @WebMethod
    public String registrarConcepto(Concepto concepto)
    {
        return insp.registrarConcepto(concepto);
    }

    @WebMethod
    public Concepto consultarConcepto(String idConcepto) 
    {
       return insp.consultarConcepto(idConcepto);
    }

    @WebMethod
    public List<TipoMuestra> obtenerTipoMuestrasXClase(String codigoClase,String codigoPrueba) {
        return insp.obtenerTipoMuestrasXClase(codigoClase,codigoPrueba);
    }

    @WebMethod
    public List<AreaLaboratorio> obtenerAreaLaboratorioXClase(String codigoClase) {
        return insp.obtenerAreaLaboratorioXClase(codigoClase);
    }

    @WebMethod
    public List<ProcedenciaOrigenMuestra> obtenerProcedenciaOrigenMuestra() {
        return insp.obtenerProcedenciaOrigenMuestra();
    }

    @WebMethod
    public List<PruebaDiagnostica> listaServicioAnalisisVegetal(String campoBusqueda) {
        return insp.listaServicioAnalisisVegetal(campoBusqueda);
    }

    @WebMethod
    public List<ActividadVigilancia> listaMotivo() {
        return insp.listaMotivo();
    }

    @WebMethod
    public List<VigilanciaActivaPruebas> listaServicioAnalisisAnimal(String campoBusqueda) {
        return insp.listaServicioAnalisisAnimal(campoBusqueda);
    }

    @WebMethod
    public List<EspeciesAnimales> listaTipoEspecieAnimal() {
        return insp.listaTipoEspecieAnimal();
    }

    @WebMethod
    public RespuestaAnalisisLaboratorio respuestaSolicitudAnalisisLaboratorio(String numeroSolicitudAnalisis, String codigoClase) {
        return insp.respuestaSolicitudAnalisisLaboratorio(numeroSolicitudAnalisis,codigoClase);
    }

    @WebMethod
    public String solicitudAnalisisLaboratorioAnimal(SolicitudAnalisisAnimal solicitudAnalisisAnimal) {
        return insp.solicitudAnalisisLaboratorioAnimal(solicitudAnalisisAnimal);
    }

    @WebMethod
    public String solicitudAnalisisLaboratorioVegetal(SolicitudAnalisisVegetal solicitudAnalisisVegetal) {
        return insp.solicitudAnalisisLaboratorioVegetal(solicitudAnalisisVegetal);
    }

    @WebMethod
    public List<TipoRechazo> listarTiposRechazos() {
        return insp.listarTiposRechazos();
    }

    @WebMethod
    public List<TipoIdentificacionAnimal> listarTipoIdentificacionAnimal() {
        return insp.listarTipoIdentificacionAnimal();
    }

    @WebMethod
    public List<Sexo> listarSexoAnimal() {
        return insp.listarSexoAnimal();
    }

    @WebMethod
    public List<Raza> listarRazaAnimal(String codigoEspecie) {
        return insp.listarRazaAnimal(codigoEspecie);
    }

    @WebMethod
    public List<UnidadMedida> listarUnidadTiempo() {
        return insp.listarUnidadTiempo();
    }

    @WebMethod
    public List<TipoCrianza> listarTipoCrianzas() {
        return insp.listarTipoCrianzas();
    }
    
  @WebMethod
  public List<ProductoInspeccion> obtenerProductosInspeccionExp(String codigoExpediente) {
    return insp.obtenerProductosInspeccionExp(codigoExpediente);
  }
  
    @WebMethod
    public String generarInformeInspeccionPreliminar(@WebParam(name = "tipo") String tipo, 
                                                     @WebParam(name = "codigoExpediente") String codigoExpediente,
                                                     @WebParam(name = "titulo") String titulo, 
                                                     @WebParam(name = "ucmid") String ucmid) {
        transaccion++;
        txId = "txId=[" + String.valueOf(transaccion) + "] ";
        return new GestionInspeccion().generarInformeInspeccionPreliminar(txId, tipo, codigoExpediente, titulo, ucmid);
    }
  
}
