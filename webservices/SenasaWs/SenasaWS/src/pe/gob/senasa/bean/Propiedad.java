package pe.gob.senasa.bean;

import java.io.Serializable;

public class Propiedad implements Serializable {
    
    private String xValor="";
    
    private String xPropiedad="";
    
    public Propiedad() {
        super();
    }

	public Propiedad(String xPropiedad, String xValor) {
		super();
		this.xValor = xValor;
		this.xPropiedad = xPropiedad;
	}

	public void setXValor(String xValor) {
        this.xValor = xValor;
    }

    public String getXValor() {
        return xValor;
    }

    public void setXPropiedad(String xPropiedad) {
        this.xPropiedad = xPropiedad;
    }

    public String getXPropiedad() {
        return xPropiedad;
    }
    
    
}
