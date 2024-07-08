package pe.gob.senasa.bean;

import java.io.Serializable;

public class TipoFiltro implements Serializable {
    
    private String codigo;
    private String filtro;

	public TipoFiltro() {
		super();
	}
  
  public TipoFiltro(String codigo, String filtro) {
    super();
      this.codigo = codigo;
      this.filtro = filtro;    
  }

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public String getFiltro() {
		return filtro;
	}
}
