package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;


public class PermisoFitosanitarioImportacion implements Serializable {
    
    public PermisoFitosanitarioImportacion() {
        super();
    }
    
    private String fechaDeEmicion;
    private String direccionEjecutiva;
    private String descDireccionEjecutiva;
    private String noCertificado;
    private boolean indicadorAmpliacion;
    private String noFolio;
    private String urlPFIDefinitivo;
    private String fechaVigencia;
    private ArrayList<ProductoPFI> productosPFI = new ArrayList<ProductoPFI>();
    private ArrayList<LugarProduccionProductoPFI> lugaresProduccionProductoPFI = new ArrayList<LugarProduccionProductoPFI>();
    private ArrayList<PaisOrigenProductoPFI> paisesOrigenProductoPFI = new ArrayList<PaisOrigenProductoPFI>();
    private ArrayList<PuntoIngresoProductoPFI> puntoIngresoProductoPFI = new ArrayList<PuntoIngresoProductoPFI>();
    private ArrayList<AnexoPFI> anexosPFI = new ArrayList<AnexoPFI>();
    private ArrayList<LugarProduccionAnexoPFI> lugaresProduccionAnexoPFI = new ArrayList<LugarProduccionAnexoPFI>();
    private ArrayList<PaisOrigenAnexoPFI> paisesOrigenAnexoPFI = new ArrayList<PaisOrigenAnexoPFI>();
    private ArrayList<PuntoIngresoAnexoPFI> puntoIngresoAnexoPFI = new ArrayList<PuntoIngresoAnexoPFI>();
    private Solicitante solicitante;
    private String cadenaProductos;
    private Date fechaAmpliacion;
    private String codigoRequImpoProducto;
    
    private String userName;
    private Double secuencial;
    private String periodoVegetativo;
    private String numeroInspecciones;
   //private String nombreRepresentanteLegal;
   //private String dniRepresentanteLegal;
   //private String idRepresentanteLegal;
    
    public void setSecuencial(Double secuencial) {
        this.secuencial = secuencial;
    }
    
    public Double getSecuencial() {
        return secuencial;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
  
    public String getUserName() {
        return userName;
    }
  
    public void setDireccionEjecutiva(String direccionEjecutiva) {
        this.direccionEjecutiva = direccionEjecutiva;
    }

    public String getDireccionEjecutiva() {
        return direccionEjecutiva;
    }

    public void setNoCertificado(String noCertificado) {
        this.noCertificado = noCertificado;
    }

    public String getNoCertificado() {
        return noCertificado;
    }

    public void setNoFolio(String noFolio) {
        this.noFolio = noFolio;
    }

    public String getNoFolio() {
        return noFolio;
    }

    public void setUrlPFIDefinitivo(String urlPFIDefinitivo) {
        this.urlPFIDefinitivo = urlPFIDefinitivo;
    }

    public String getUrlPFIDefinitivo() {
        return urlPFIDefinitivo;
    }

    public void setProductosPFI(ArrayList<ProductoPFI> productosPFI) {
        this.productosPFI = productosPFI;
    }

    public ArrayList<ProductoPFI> getProductosPFI() {
        return productosPFI;
    }

    public void setLugaresProduccionProductoPFI(ArrayList<LugarProduccionProductoPFI> lugaresProduccionProductoPFI) {
        this.lugaresProduccionProductoPFI = lugaresProduccionProductoPFI;
    }

    public ArrayList<LugarProduccionProductoPFI> getLugaresProduccionProductoPFI() {
        return lugaresProduccionProductoPFI;
    }

    public void setPaisesOrigenProductoPFI(ArrayList<PaisOrigenProductoPFI> paisesOrigenProductoPFI) {
        this.paisesOrigenProductoPFI = paisesOrigenProductoPFI;
    }

    public ArrayList<PaisOrigenProductoPFI> getPaisesOrigenProductoPFI() {
        return paisesOrigenProductoPFI;
    }

    public void setPuntoIngresoProductoPFI(ArrayList<PuntoIngresoProductoPFI> puntoIngresoProductoPFI) {
        this.puntoIngresoProductoPFI = puntoIngresoProductoPFI;
    }

    public ArrayList<PuntoIngresoProductoPFI> getPuntoIngresoProductoPFI() {
        return puntoIngresoProductoPFI;
    }

    public void setAnexosPFI(ArrayList<AnexoPFI> anexosPFI) {
        this.anexosPFI = anexosPFI;
    }

    public ArrayList<AnexoPFI> getAnexosPFI() {
        return anexosPFI;
    }

    public void setLugaresProduccionAnexoPFI(ArrayList<LugarProduccionAnexoPFI> lugaresProduccionAnexoPFI) {
        this.lugaresProduccionAnexoPFI = lugaresProduccionAnexoPFI;
    }

    public ArrayList<LugarProduccionAnexoPFI> getLugaresProduccionAnexoPFI() {
        return lugaresProduccionAnexoPFI;
    }

    public void setPaisesOrigenAnexoPFI(ArrayList<PaisOrigenAnexoPFI> paisesOrigenAnexoPFI) {
        this.paisesOrigenAnexoPFI = paisesOrigenAnexoPFI;
    }

    public ArrayList<PaisOrigenAnexoPFI> getPaisesOrigenAnexoPFI() {
        return paisesOrigenAnexoPFI;
    }

    public void setPuntoIngresoAnexoPFI(ArrayList<PuntoIngresoAnexoPFI> puntoIngresoAnexoPFI) {
        this.puntoIngresoAnexoPFI = puntoIngresoAnexoPFI;
    }

    public ArrayList<PuntoIngresoAnexoPFI> getPuntoIngresoAnexoPFI() {
        return puntoIngresoAnexoPFI;
    }

    public void setFechaDeEmicion(String fechaDeEmicion) {
        this.fechaDeEmicion = fechaDeEmicion;
    }

    public String getFechaDeEmicion() {
        return fechaDeEmicion;
    }

    public void setFechaVigencia(String fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public String getFechaVigencia() {
        return fechaVigencia;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setIndicadorAmpliacion(boolean indicadorAmpliacion) {
        this.indicadorAmpliacion = indicadorAmpliacion;
    }

    public boolean isIndicadorAmpliacion() {
        return indicadorAmpliacion;
    }

    public void setFechaAmpliacion(Date fechaAmpliacion) {
        this.fechaAmpliacion = fechaAmpliacion;
    }

    public Date getFechaAmpliacion() {
        return fechaAmpliacion;
    }
    
    
  public void setCodigoRequImpoProducto(String codigoRequImpoProducto) {
      this.codigoRequImpoProducto = codigoRequImpoProducto;
  }

  public String getCodigoRequImpoProducto() {
      return codigoRequImpoProducto;
  }


    public void setPeriodoVegetativo(String periodoVegetativo) {
        this.periodoVegetativo = periodoVegetativo;
    }

    public String getPeriodoVegetativo() {
        return periodoVegetativo;
    }

    public void setNumeroInspecciones(String numeroInspecciones) {
        this.numeroInspecciones = numeroInspecciones;
    }

    public String getNumeroInspecciones() {
        return numeroInspecciones;
    }

    public void setDescDireccionEjecutiva(String descDireccionEjecutiva) {
        this.descDireccionEjecutiva = descDireccionEjecutiva;
    }

    public String getDescDireccionEjecutiva() {
        return descDireccionEjecutiva;
    }

    public void setCadenaProductos(String cadenaProductos) {
        this.cadenaProductos = cadenaProductos;
    }

    public String getCadenaProductos() {
        return cadenaProductos;
    }
}
