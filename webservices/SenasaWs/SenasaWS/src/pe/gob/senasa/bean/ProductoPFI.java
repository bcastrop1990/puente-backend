package pe.gob.senasa.bean;

import java.io.Serializable;

public class ProductoPFI implements Serializable
{
    
    private String partidaArancelaria;
    private String descripcion;
    private String nombreCientifico;
    private String paisProcedencia;
    private String paisDestino;
    private String descPaisProcedencia;
    private String descPaisDestino;
    private String usoDestino;    
    private String tipoEnvase;
    private String desTipoEnvase;
    private Double cantidad;
    private Double pesoNeto;
    private String codigoProducto;
    private boolean contieneAnexos;
    private String codUniMed;
    private String descUniMed;
    private String cantidadPlantas;
    
    
    public ProductoPFI() {
        super();
    }

    public void setPartidaArancelaria(String partidaArancelaria) {
        this.partidaArancelaria = partidaArancelaria;
    }

    public String getPartidaArancelaria() {
        return partidaArancelaria;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setPaisProcedencia(String paisProcedencia) {
        this.paisProcedencia = paisProcedencia;
    }

    public String getPaisProcedencia() {
        return paisProcedencia;
    }

    public void setUsoDestino(String usoDestino) {
        this.usoDestino = usoDestino;
    }

    public String getUsoDestino() {
        return usoDestino;
    }

    public void setTipoEnvase(String tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    public String getTipoEnvase() {
        return tipoEnvase;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setPesoNeto(Double pesoNeto) {
        this.pesoNeto = pesoNeto;
    }

    public Double getPesoNeto() {
        return pesoNeto;
    }


    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setContieneAnexos(boolean contieneAnexo) {
        this.contieneAnexos = contieneAnexo;
    }

    public boolean isContieneAnexos() {
        return contieneAnexos;
    }

	public String getCodUniMed() {
		return codUniMed;
	}

	public void setCodUniMed(String codUniMed) {
		this.codUniMed = codUniMed;
	}

    public void setCantidadPlantas(String cantidadPlantas) {
        this.cantidadPlantas = cantidadPlantas;
    }

    public String getCantidadPlantas() {
        return cantidadPlantas;
    }

    public void setDesTipoEnvase(String desTipoEnvase) {
        this.desTipoEnvase = desTipoEnvase;
    }

    public String getDesTipoEnvase() {
        return desTipoEnvase;
    }

    public void setDescUniMed(String descUniMed) {
        this.descUniMed = descUniMed;
    }

    public String getDescUniMed() {
        return descUniMed;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public String getPaisDestino() {
        return paisDestino;
    }
    
    public void setDescPaisProcedencia(String descPaisProcedencia) {
        this.descPaisProcedencia = descPaisProcedencia;
    }

    public String getDescPaisProcedencia() {
        return descPaisProcedencia;
    }

    public void setDescPaisDestino(String descPaisDestino) {
        this.descPaisDestino = descPaisDestino;
    }

    public String getDescPaisDestino() {
        return descPaisDestino;
    }
}
