package pe.gob.senasa.bean;

import java.io.Serializable;

public class AnexoPFI  implements Serializable {
    public AnexoPFI() {
        super();
    }  
    private String partidaArancelaria;
    private String descripcion;
    private String nombreCientifico;
    private String partidaArancelariaPadre;
    private String descripcionPadre;
    private String nombreCientificoPadre;
    private String paisProcedencia;
    private String paisDestino;
    private String usoDestino;
    private String tipoEnvase;
    private String desTipoEnvase;
    private Double cantidad;
    private Double pesoNeto;
    private String codigo;
    private String codigoPadre;
    private String codUniMed;
    private String desUniMed;
    private String cantidadPlantas;
    private Boolean isAnimalVivo;
    private String idRaza;
    private String descRaza;
    private int edad;
    private String idSexo;
    private String descSexo;

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

    public void setPartidaArancelariaPadre(String partidaArancelariaPadre) {
        this.partidaArancelariaPadre = partidaArancelariaPadre;
    }

    public String getPartidaArancelariaPadre() {
        return partidaArancelariaPadre;
    }

    public void setDescripcionPadre(String descripcionPadre) {
        this.descripcionPadre = descripcionPadre;
    }

    public String getDescripcionPadre() {
        return descripcionPadre;
    }

    public void setNombreCientificoPadre(String nombreCientificoPadre) {
        this.nombreCientificoPadre = nombreCientificoPadre;
    }

    public String getNombreCientificoPadre() {
        return nombreCientificoPadre;
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


    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigoPadre(String codigoPadre) {
        this.codigoPadre = codigoPadre;
    }

    public String getCodigoPadre() {
        return codigoPadre;
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

    public void setDesUniMed(String desUniMed) {
        this.desUniMed = desUniMed;
    }

    public String getDesUniMed() {
        return desUniMed;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public String getPaisDestino() {
        return paisDestino;
    }


    public void setIsAnimalVivo(Boolean isAnimalVivo) {
        this.isAnimalVivo = isAnimalVivo;
    }

    public Boolean getIsAnimalVivo() {
        return isAnimalVivo;
    }


    public void setIdRaza(String idRaza) {
        this.idRaza = idRaza;
    }

    public String getIdRaza() {
        return idRaza;
    }

    public void setDescRaza(String descRaza) {
        this.descRaza = descRaza;
    }

    public String getDescRaza() {
        return descRaza;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setIdSexo(String idSexo) {
        this.idSexo = idSexo;
    }

    public String getIdSexo() {
        return idSexo;
    }

    public void setDescSexo(String descSexo) {
        this.descSexo = descSexo;
    }

    public String getDescSexo() {
        return descSexo;
    }
}
