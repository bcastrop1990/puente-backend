package pe.gob.senasa.bean;

import java.io.Serializable;

public class Producto implements Serializable{
    public Producto() {
        super();
    }
  private String codigoProducto;
  private String nombreComercial;
  private String nombreCientifico;
  private String codigoPartAranc;
  private String codigoCRF;
  private String indCuarentena;
  private String indGuardacustodia;
  private String perVegetativo;
  private Integer numInspecciones;
  private String codEspecie;  
  private Boolean isAnimal;
  private Boolean isAnexo;


    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setCodigoPartAranc(String codigoPartAranc) {
        this.codigoPartAranc = codigoPartAranc;
    }

    public String getCodigoPartAranc() {
        return codigoPartAranc;
    }

    public void setCodigoCRF(String codigoCRF) {
        this.codigoCRF = codigoCRF;
    }

    public String getCodigoCRF() {
        return codigoCRF;
    }

    public void setIndCuarentena(String indCuarentena) {
        this.indCuarentena = indCuarentena;
    }

    public String getIndCuarentena() {
        return indCuarentena;
    }

    public void setIndGuardacustodia(String indGuardacustodia) {
        this.indGuardacustodia = indGuardacustodia;
    }

    public String getIndGuardacustodia() {
        return indGuardacustodia;
    }

    public void setPerVegetativo(String perVegetativo) {
        this.perVegetativo = perVegetativo;
    }

    public String getPerVegetativo() {
        return perVegetativo;
    }

    public void setCodEspecie(String codEspecie) {
        this.codEspecie = codEspecie;
    }

    public String getCodEspecie() {
        return codEspecie;
    }

    public void setNumInspecciones(Integer numInspecciones) {
        this.numInspecciones = numInspecciones;
    }

    public Integer getNumInspecciones() {
        return numInspecciones;
    }

    public void setIsAnimal(Boolean isAnimal) {
        this.isAnimal = isAnimal;
    }

    public Boolean getIsAnimal() {
        return isAnimal;
    }

    public void setIsAnexo(Boolean isAnexo) {
        this.isAnexo = isAnexo;
    }

    public Boolean getIsAnexo() {
        return isAnexo;
    }
}
