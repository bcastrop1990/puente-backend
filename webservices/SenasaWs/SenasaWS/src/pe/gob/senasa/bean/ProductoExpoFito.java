package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.Date;


public class ProductoExpoFito implements Serializable {
    
    private static final long serialVersionUID = 6005072824386166392L;
    
    private String codigoCertificadoFitoExpo;
    private String secuencialProducto;
    private String codiUnidMed;
    private String desUnidadMedia;
    private String codigoTipoEnvase;
    private String desTipoEnvase;
    private String cantidadPeso;
    private String codigoProducto;
    private String partidaArancelaria;
    private String nombreComun;
    private String nombreCientifico;
    private String cantidadEnvase;
    private String cultivarId;
    private String marcaDistintiva;
    private String personaId;
    private String estado;
    private String userCrea;
    private String userModi;
    private Date fechModi;
    private Date fechrea;
    private String codigoProductoPadre;

    public ProductoExpoFito() {
        super();
    }

    public void setCodigoCertificadoFitoExpo(String codigoCertificadoFitoExpo) {
        this.codigoCertificadoFitoExpo = codigoCertificadoFitoExpo;
    }

    public String getCodigoCertificadoFitoExpo() {
        return codigoCertificadoFitoExpo;
    }

    public void setSecuencialProducto(String secuencialProducto) {
        this.secuencialProducto = secuencialProducto;
    }

    public String getSecuencialProducto() {
        return secuencialProducto;
    }

    public void setCodiUnidMed(String codiUnidMed) {
        this.codiUnidMed = codiUnidMed;
    }

    public String getCodiUnidMed() {
        return codiUnidMed;
    }

    public void setCodigoTipoEnvase(String codigoTipoEnvase) {
        this.codigoTipoEnvase = codigoTipoEnvase;
    }

    public String getCodigoTipoEnvase() {
        return codigoTipoEnvase;
    }

    public void setCantidadPeso(String cantidadPeso) {
        this.cantidadPeso = cantidadPeso;
    }

    public String getCantidadPeso() {
        return cantidadPeso;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCantidadEnvase(String cantidadEnvase) {
        this.cantidadEnvase = cantidadEnvase;
    }

    public String getCantidadEnvase() {
        return cantidadEnvase;
    }

    public void setCultivarId(String cultivarId) {
        this.cultivarId = cultivarId;
    }

    public String getCultivarId() {
        return cultivarId;
    }

    public void setMarcaDistintiva(String marcaDistintiva) {
        this.marcaDistintiva = marcaDistintiva;
    }

    public String getMarcaDistintiva() {
        return marcaDistintiva;
    }

    public void setPersonaId(String personaId) {
        this.personaId = personaId;
    }

    public String getPersonaId() {
        return personaId;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setUserCrea(String userCrea) {
        this.userCrea = userCrea;
    }

    public String getUserCrea() {
        return userCrea;
    }

    public void setUserModi(String userModi) {
        this.userModi = userModi;
    }

    public String getUserModi() {
        return userModi;
    }

    public void setFechModi(Date fechModi) {
        this.fechModi = fechModi;
    }

    public Date getFechModi() {
        return fechModi;
    }

    public void setFechrea(Date fechrea) {
        this.fechrea = fechrea;
    }

    public Date getFechrea() {
        return fechrea;
    }

    public void setCodigoProductoPadre(String codigoProductoPadre) {
        this.codigoProductoPadre = codigoProductoPadre;
    }

    public String getCodigoProductoPadre() {
        return codigoProductoPadre;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setDesUnidadMedia(String desUnidadMedia) {
        this.desUnidadMedia = desUnidadMedia;
    }

    public String getDesUnidadMedia() {
        return desUnidadMedia;
    }

    public void setDesTipoEnvase(String desTipoEnvase) {
        this.desTipoEnvase = desTipoEnvase;
    }

    public String getDesTipoEnvase() {
        return desTipoEnvase;
    }

    public void setPartidaArancelaria(String partidaArancelaria) {
        this.partidaArancelaria = partidaArancelaria;
    }

    public String getPartidaArancelaria() {
        return partidaArancelaria;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }
}
