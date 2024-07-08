package pe.gob.senasa.bean;

import java.io.Serializable;

public class ProductoPZI implements Serializable {

    private String partidaArancelaria;
    private String descripcion;
    private String nombreCientifico;
    private String paisProcedencia;
    private Boolean contieneAnexos;
    private Boolean esAnimal;
    private String usoDestino;
    private String especie;
    private String idSexo;
    private String descSexo;
    private Integer edad;
    private String idRaza;
    private String descRaza;
    private String identificacion;
    private String tipoEnvase;
    private String desTipoEnvase;
    private Double cantidad;
    private Double pesoNeto;
    private Integer numeroAnimales;
    private String animalesVivos;
    private String codProducto;
    private String codUniMed;
    private String descUniMed;

    public ProductoPZI() {
        super();
    }

    //Probando

    public void setPartidaArancelaria(String partidaArancelaria) {

        /* if(partidaArancelaria.startsWith("01"))
           this.esAnimal = true;
        else
           this.esAnimal = false;
      */

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

    public void setContieneAnexos(Boolean contieneAnexos) {
        this.contieneAnexos = contieneAnexos;
    }

    public Boolean getContieneAnexos() {
        return contieneAnexos;
    }

    public void setEsAnimal(Boolean esAnimal) {
        this.esAnimal = esAnimal;
    }

    public Boolean getEsAnimal() {
        return esAnimal;
    }

    public void setUsoDestino(String usoDestino) {
        this.usoDestino = usoDestino;
    }

    public String getUsoDestino() {
        return usoDestino;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getEspecie() {
        return especie;
    }

 

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getEdad() {
        return edad;
    }


    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setTipoEnvase(String tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    public String getTipoEnvase() {
        return tipoEnvase;
    }


    public void setDesTipoEnvase(String desTipoEnvase) {
        this.desTipoEnvase = desTipoEnvase;
    }

    public String getDesTipoEnvase() {
        return desTipoEnvase;
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

    public void setNumeroAnimales(Integer numeroAnimales) {
        this.numeroAnimales = numeroAnimales;
    }

    public Integer getNumeroAnimales() {
        return numeroAnimales;
    }

    public void setAnimalesVivos(String animalesVivos) {
        this.animalesVivos = animalesVivos;
    }

    public String getAnimalesVivos() {
        return animalesVivos;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public String getCodUniMed() {
        return codUniMed;
    }

    public void setCodUniMed(String codUniMed) {
        this.codUniMed = codUniMed;
    }

    public void setDescUniMed(String descUniMed) {
        this.descUniMed = descUniMed;
    }

    public String getDescUniMed() {
        return descUniMed;
    }

    public void setIdSexo(String idSexo) {
        this.idSexo = idSexo;
    }

    public String getIdSexo() {
        return idSexo;
    }

    public void setIdRaza(String idRaza) {
        this.idRaza = idRaza;
    }

    public String getIdRaza() {
        return idRaza;
    }


    public void setDescSexo(String descSexo) {
        this.descSexo = descSexo;
    }

    public String getDescSexo() {
        return descSexo;
    }

    public void setDescRaza(String descRaza) {
        this.descRaza = descRaza;
    }

    public String getDescRaza() {
        return descRaza;
    }
}
