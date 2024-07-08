package pe.gob.senasa.bean;

import java.io.Serializable;

public class Producto implements Serializable{
    
    public Producto() {
        super();
    }
    
    private String partidaArancelaria;
    private String descripcion;
    private String nombreCientifico;
    private Boolean contieneAnexos;
    private String categoriaRiesgo;
    private Boolean esAnimalVivo;
    private String codigoProducto;
    private String claseProducto;
    private String codigoPadre;
    private String descripcionPadre;
    private String nombreCientificoPadre;
    private String partidaArancelariaPadre;
    private boolean indicadorCuarentena;
    private boolean indicadorGermoplasma;
    private boolean indicadorGCustodia;
    
    private String codigoAplicacion;
    private String descripcionAplicacion;
    private String codigoClase;
    private String cantidadPesoAprobado;
    private String codigoUnidadMedida;
    private String descripcionUnidadMedida;
    private String codigoLugarInspeccion;
    private String codigoTipoEnvase;
    private String cantidadPesoSolicitado;
    private String codigoCentroTramite;
    private String nombreCentroTramite;
    
  public void setCodigoCentroTramite(String codigoCentroTramite) {
      this.codigoCentroTramite= codigoCentroTramite;
  }

  public String getCodigoCentroTramite() {
      return codigoCentroTramite;
  }
  public void setNombreCentroTramite(String nombreCentroTramite) {
      this.nombreCentroTramite= nombreCentroTramite;
  }

  public String getNombreCentroTramite() {
      return nombreCentroTramite;
  }
  
  public void setCantidadPesoSolicitado(String cantidadPesoSolicitado) {
      this.cantidadPesoSolicitado= cantidadPesoSolicitado;
  }

  public String getCantidadPesoSolicitado() {
      return cantidadPesoSolicitado;
  }
  public void setCodigoTipoEnvase(String codigoTipoEnvase) {
      this.codigoTipoEnvase= codigoTipoEnvase;
  }

  public String getCodigoTipoEnvase() {
      return codigoTipoEnvase;
  }
  public void setCodigoLugarInspeccion(String codigoLugarInspeccion) {
      this.codigoLugarInspeccion= codigoLugarInspeccion;
  }

  public String getCodigoLugarInspeccion() {
      return codigoLugarInspeccion;
  }
  public void setDescripcionUnidadMedida(String descripcionUnidadMedida) {
      this.descripcionUnidadMedida= descripcionUnidadMedida;
  }

  public String getDescripcionUnidadMedida() {
      return descripcionUnidadMedida;
  }
  public void setCodigoUnidadMedida(String codigoUnidadMedida) {
      this.codigoUnidadMedida= codigoUnidadMedida;
  }

  public String getCodigoUnidadMedida() {
      return codigoUnidadMedida;
  }

  public void setCantidadPesoAprobado(String cantidadPesoAprobado) {
      this.cantidadPesoAprobado = cantidadPesoAprobado;
  }

  public String getCantidadPesoAprobado() {
      return codigoClase;
  }

  public void setCodigoClase(String codigoClase) {
      this.codigoClase = codigoClase;
  }

  public String getCodigoClase() {
      return codigoClase;
  }
  
  public void setCodigoAplicacion(String codigoAplicacion) {
      this.codigoAplicacion = codigoAplicacion;
  }

  public String getCodigoAplicacion() {
      return codigoAplicacion;
  }
  
  public void setDescripcionAplicacion(String descripcionAplicacion) {
      this.descripcionAplicacion = descripcionAplicacion;
  }

  public String getDescripcionAplicacion() {
      return descripcionAplicacion;
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

    public void setContieneAnexos(Boolean contieneAnexos) {
        this.contieneAnexos = contieneAnexos;
    }

    public Boolean getContieneAnexos() {
        return contieneAnexos;
    }

    public void setCategoriaRiesgo(String categoriaRiesgo) {
        this.categoriaRiesgo = categoriaRiesgo;
    }

    public String getCategoriaRiesgo() {
        return categoriaRiesgo;
    }

    public void setEsAnimalVivo(Boolean esAnimal) {
        this.esAnimalVivo = esAnimal;
    }

    public Boolean getEsAnimalVivo() {
        return esAnimalVivo;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setClaseProducto(String claseProducto) {
        this.claseProducto = claseProducto;
    }

    public String getClaseProducto() {
        return claseProducto;
    }

    public void setCodigoPadre(String codigoPadre) {
        this.codigoPadre = codigoPadre;
    }

    public String getCodigoPadre() {
        return codigoPadre;
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

    public void setPartidaArancelariaPadre(String partidaArancelariaPadre) {
        this.partidaArancelariaPadre = partidaArancelariaPadre;
    }

    public String getPartidaArancelariaPadre() {
        return partidaArancelariaPadre;
    }

    public void setIndicadorCuarentena(boolean indicadorCuarentena) {
        this.indicadorCuarentena = indicadorCuarentena;
    }

    public boolean isIndicadorCuarentena() {
        return indicadorCuarentena;
    }


    public void setIndicadorGermoplasma(boolean indicadorGermoplasma) {
        this.indicadorGermoplasma = indicadorGermoplasma;
    }

    public boolean isIndicadorGermoplasma() {
        return indicadorGermoplasma;
    }


    public void setIndicadorGCustodia(boolean indicadorGCustodia) {
        this.indicadorGCustodia = indicadorGCustodia;
    }

    public boolean isIndicadorGCustodia() {
        return indicadorGCustodia;
    }
}
