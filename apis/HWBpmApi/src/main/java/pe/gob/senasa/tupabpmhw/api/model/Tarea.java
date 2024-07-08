package pe.gob.senasa.tupabpmhw.api.model;

public class Tarea {

    private final String id;
    private final String titulo;
    private final String duenio;
    private final String rolDuenio;
    private final Object payload;

    public Tarea(String id, String titulo, String duenio, String rolDuenio, Object payload) {
        this.id = id;
        this.titulo = titulo;
        this.duenio = duenio;
        this.rolDuenio = rolDuenio;
        this.payload = payload;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDuenio() {
        return duenio;
    }

    public String getRolDuenio() {
        return rolDuenio;
    }

    public Object getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return "Tarea{" + "id=" + id + ", titulo=" + titulo + ", duenio=" + duenio + ", rolDuenio=" + rolDuenio + ", payload=" + payload + '}';
    }
    
}
