package pe.gob.senasa.ucm;

import java.util.ArrayList;
import java.util.List;

public class Documento {
    private String id;
    private String nombre;
    private String url;
    private String confidencial;
    private List<Version> versiones = null;

    public Documento() {
        super();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setVersiones(List<Version> versiones) {
        this.versiones = versiones;
    }

    public List<Version> getVersiones() {
        if (versiones==null)
            versiones = new ArrayList<Version>();
        return versiones;
    }

    public void setConfidencial(String confidencial) {
        this.confidencial = confidencial;
    }

    public String getConfidencial() {
        return confidencial;
    }
}
