package pe.gob.senasa.bean;

public class Entidad {
   String nombre= "";
   String idEntidad = "";
   String emailEntidad = "";

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIdEntidad(String idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getIdEntidad() {
        return idEntidad;
    }

    public void setEmailEntidad(String emailEntidad) {
        this.emailEntidad = emailEntidad;
    }

    public String getEmailEntidad() {
        return emailEntidad;
    }
}
