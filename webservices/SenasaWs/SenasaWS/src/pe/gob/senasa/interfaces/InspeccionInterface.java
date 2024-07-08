package pe.gob.senasa.interfaces;

import java.util.List;

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


public interface InspeccionInterface 
{
    //public RespuestaInspeccion insertarInspeccion(Inspeccion inspeccion);
    
    public void actualizarProductoInspeccion(ProductoInspeccion productoInspeccion);
    
    public String registrarLote(Lote lote);
    
    public Lote consultarLote(String idLote);
    
    public String registrarConcepto(Concepto concepto);
    
    public Concepto consultarConcepto(String idConcepto);
    
    public List<TipoMuestra> obtenerTipoMuestrasXClase(String codigoClase,String codigoPrueba);
    
    public List<AreaLaboratorio> obtenerAreaLaboratorioXClase(String codigoClase);

    public List<ProcedenciaOrigenMuestra> obtenerProcedenciaOrigenMuestra();
    
    public List<PruebaDiagnostica> listaServicioAnalisisVegetal(String campoBusqueda);
    
    public List<ActividadVigilancia> listaMotivo();
    
    public List<VigilanciaActivaPruebas> listaServicioAnalisisAnimal(String campoBusqueda);
    
    public List<EspeciesAnimales>  listaTipoEspecieAnimal();
    
    public RespuestaAnalisisLaboratorio respuestaSolicitudAnalisisLaboratorio(String numeroSolicitudAnalisis, String codigoClase);
    
    public String solicitudAnalisisLaboratorioAnimal(SolicitudAnalisisAnimal solicitudAnalisisAnimal);
    
    public String solicitudAnalisisLaboratorioVegetal(SolicitudAnalisisVegetal solicitudAnalisisVegetal);
    
    public List<TipoRechazo> listarTiposRechazos(); 
    
    public List<TipoIdentificacionAnimal> listarTipoIdentificacionAnimal(); 
    
    public List<Sexo> listarSexoAnimal();
    
    public List<Raza> listarRazaAnimal(String codigoEspecie);
    
    public List<UnidadMedida> listarUnidadTiempo();
    
    public List<TipoCrianza> listarTipoCrianzas();

    public List<ProductoInspeccion> obtenerProductosInspeccionExp(String codigoExpediente) ;   
  
}
