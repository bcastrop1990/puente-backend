package pe.gob.senasa.bean;

import java.io.Serializable;

public class FuncionesEquipoTecnico implements Serializable {
    
    private String codFuncionEquipoTecnico;
    private String funcionEquipotecnico;
    
    public FuncionesEquipoTecnico() {
        super();
    }

    public void setCodFuncionEquipoTecnico(String codFuncionEquipoTecnico) {
        this.codFuncionEquipoTecnico = codFuncionEquipoTecnico;
    }

    public String getCodFuncionEquipoTecnico() {
        return codFuncionEquipoTecnico;
    }

    public void setFuncionEquipotecnico(String funcionEquipotecnico) {
        this.funcionEquipotecnico = funcionEquipotecnico;
    }

    public String getFuncionEquipotecnico() {
        return funcionEquipotecnico;
    }
}
