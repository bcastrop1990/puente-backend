package pe.gob.senasa.bean;

import java.util.ArrayList;
import java.util.Date;


public class PermisoZoosanitarioImportacion {
    
    public PermisoZoosanitarioImportacion() {
        super();
    }
   
    private String direccionEjecutiva;
    private String noCertificado;
    private String noFolio;
    private String urlPZIDefinitivo;
    private String puntoIngreso;
    private Date fechaProbableIngreso;
    private Date fechaAmpliacion;
    private String puntoSalida;
    private Date fechaProbableSalida;
    private ProductoPZI productoPZI;
    private Date fechaEmision;
    private Date fechaEntrega;
    private boolean indicadorAmpliacion;
    private Solicitante solicitante;
    private String usuario;
    private String codReqImpProducto;
    private String descDireccionEjecutiva;
    
    private ArrayList<PaisOrigenProductoPFI> paisesOrigenProductoPZI = new ArrayList<PaisOrigenProductoPFI>();
    private ArrayList<AnexoPFI> anexosPZI = new ArrayList<AnexoPFI>();
    private ArrayList<PaisOrigenAnexoPFI> paisesOrigenAnexoPZI = new ArrayList<PaisOrigenAnexoPFI>();
    private ArrayList<PuntoIngresoProductoPFI> puntosIngresoProductoPZI = new ArrayList<PuntoIngresoProductoPFI>(); 

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

    public void setUrlPZIDefinitivo(String urlPZIDefinitivo) {
        this.urlPZIDefinitivo = urlPZIDefinitivo;
    }

    public String getUrlPZIDefinitivo() {
        return urlPZIDefinitivo;
    }

    public void setPuntoIngreso(String puntoIngreso) {
        this.puntoIngreso = puntoIngreso;
    }

    public String getPuntoIngreso() {
        return puntoIngreso;
    }

    public void setFechaProbableIngreso(Date fechaProbableIngreso) {
        this.fechaProbableIngreso = fechaProbableIngreso;
    }

    public Date getFechaProbableIngreso() {
        return fechaProbableIngreso;
    }

    public void setPuntoSalida(String puntoSalida) {
        this.puntoSalida = puntoSalida;
    }

    public String getPuntoSalida() {
        return puntoSalida;
    }

    public void setFechaProbableSalida(Date fechaProbableSalida) {
        this.fechaProbableSalida = fechaProbableSalida;
    }

    public Date getFechaProbableSalida() {
        return fechaProbableSalida;
    }

    public void setProductoPZI(ProductoPZI productoPZI) {
        this.productoPZI = productoPZI;
    }

    public ProductoPZI getProductoPZI() {
        return productoPZI;
    }

    public void setPaisesOrigenProductoPZI(ArrayList<PaisOrigenProductoPFI> paisesOrigenProductoPZI) {
        this.paisesOrigenProductoPZI = paisesOrigenProductoPZI;
    }

    public ArrayList<PaisOrigenProductoPFI> getPaisesOrigenProductoPZI() {
        return paisesOrigenProductoPZI;
    }

    public void setAnexosPZI(ArrayList<AnexoPFI> anexosPZI) {
        this.anexosPZI = anexosPZI;
    }

    public ArrayList<AnexoPFI> getAnexosPZI() {
        return anexosPZI;
    }

    public void setPaisesOrigenAnexoPZI(ArrayList<PaisOrigenAnexoPFI> paisesOrigenAnexoPZI) {
        this.paisesOrigenAnexoPZI = paisesOrigenAnexoPZI;
    }

    public ArrayList<PaisOrigenAnexoPFI> getPaisesOrigenAnexoPZI() {
        return paisesOrigenAnexoPZI;
    }


    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setFechaAmpliacion(Date fechaAmpliacion) {
        this.fechaAmpliacion = fechaAmpliacion;
    }

    public Date getFechaAmpliacion() {
        return fechaAmpliacion;
    }

    public void setIndicadorAmpliacion(boolean indicadorAmpliacion) {
        this.indicadorAmpliacion = indicadorAmpliacion;
    }

    public boolean isIndicadorAmpliacion() {
        return indicadorAmpliacion;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setCodReqImpProducto(String codReqImpProducto) {
        this.codReqImpProducto = codReqImpProducto;
    }

    public String getCodReqImpProducto() {
        return codReqImpProducto;
    }

    public void setDescDireccionEjecutiva(String descDireccionEjecutiva) {
        this.descDireccionEjecutiva = descDireccionEjecutiva;
    }

    public String getDescDireccionEjecutiva() {
        return descDireccionEjecutiva;
    }

    public void setPuntosIngresoProductoPZI(ArrayList<PuntoIngresoProductoPFI> puntosIngresoProductoPZI) {
        this.puntosIngresoProductoPZI = puntosIngresoProductoPZI;
    }

    public ArrayList<PuntoIngresoProductoPFI> getPuntosIngresoProductoPZI() {
        return puntosIngresoProductoPZI;
    }
}
