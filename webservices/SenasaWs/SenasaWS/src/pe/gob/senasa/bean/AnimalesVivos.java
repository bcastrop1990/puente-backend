package pe.gob.senasa.bean;

import java.io.Serializable;

public class AnimalesVivos implements Serializable {
    
    public AnimalesVivos() {
        super();
    }
    
    private String codAnimalVivo;
    private String animalVivo;

    public void setCodAnimalVivo(String codAnimalVivo) {
        this.codAnimalVivo = codAnimalVivo;
    }

    public String getCodAnimalVivo() {
        return codAnimalVivo;
    }

    public void setAnimalVivo(String animalVivo) {
        this.animalVivo = animalVivo;
    }

    public String getAnimalVivo() {
        return animalVivo;
    }
}
