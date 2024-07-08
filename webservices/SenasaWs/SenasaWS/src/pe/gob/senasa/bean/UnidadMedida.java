package pe.gob.senasa.bean;

import java.io.Serializable;

public class UnidadMedida implements Serializable {
    
    private String codUnidadMedida;
    private String unidadMedida;
    
    public UnidadMedida() {
        super();
    }

    public UnidadMedida(String codUnidadMedida, String unidadMedida) {
        super();
        this.codUnidadMedida = codUnidadMedida;
        this.unidadMedida = unidadMedida;
    }

    public String getCodUnidadMedida() {
		return codUnidadMedida;
	}

	public void setCodUnidadMedida(String codUnidadMedida) {
		this.codUnidadMedida = codUnidadMedida;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
}
