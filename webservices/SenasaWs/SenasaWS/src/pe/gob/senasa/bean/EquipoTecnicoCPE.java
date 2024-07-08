package pe.gob.senasa.bean;

import java.io.Serializable;

public class EquipoTecnicoCPE implements Serializable {
    
    private String dni;
    private String nombre;
    private String apellido;
    private String funcion;
    private String titulo;
    private String observacion;
    private String indicadorAceptacion;
    private String personaId;
    private int flagVuce;
    private int secuencial;
    
    public EquipoTecnicoCPE() {
        super();
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setSecuencial(int secuencial) {
        this.secuencial = secuencial;
    }

    public int getSecuencial() {
        return secuencial;
    }

    public void setFlagVuce(int flagVuce) {
        this.flagVuce = flagVuce;
    }

    public int getFlagVuce() {
        return flagVuce;
    }

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setIndicadorAceptacion(String indicadorAceptacion) {
		this.indicadorAceptacion = indicadorAceptacion;
	}

	public String getIndicadorAceptacion() {
		return indicadorAceptacion;
	}

	public void setPersonaId(String personaId) {
		this.personaId = personaId;
	}

	public String getPersonaId() {
		return personaId;
	}
}
