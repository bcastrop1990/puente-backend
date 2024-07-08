package pe.gob.senasa.gestiondocumento.ucm;

public class Propiedad {

    private String nombre;
    private String valor;

    public Propiedad() {
	super();
    }

    public Propiedad(String nombre, String valor) {
	super();
	this.nombre = nombre;
	this.valor = valor;
    }


    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public String getNombre() {
	return nombre;
    }

    public void setValor(String valor) {
	this.valor = valor;
    }

    public String getValor() {
	return valor;
    }
}
