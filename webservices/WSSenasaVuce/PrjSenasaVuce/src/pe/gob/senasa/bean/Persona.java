package pe.gob.senasa.bean;

import java.io.Serializable;

public class Persona implements Serializable {
    public Persona() {
        super();
    }
    
    private String personaId;
    private String nombreRazonSocial;
    private String personaTipo;
    private String documentoTipo;
    private String documentoNumero;
    private String direccion;
    private String departamentoId;
    private String nombDptoDpt;
    private String provinciaId;
    private String nombProvTpr;
    private String distritoId;
    private String nombDistTdi;
    private String telefono;
    private String email;


    public void setPersonaId(String personaId) {
        this.personaId = personaId;
    }

    public String getPersonaId() {
        return personaId;
    }

    public void setNombreRazonSocial(String nombreRazonSocial) {
        this.nombreRazonSocial = nombreRazonSocial;
    }

    public String getNombreRazonSocial() {
        return nombreRazonSocial;
    }

    public void setPersonaTipo(String personaTipo) {
        this.personaTipo = personaTipo;
    }

    public String getPersonaTipo() {
        return personaTipo;
    }

    public void setDocumentoTipo(String documentoTipo) {
        this.documentoTipo = documentoTipo;
    }

    public String getDocumentoTipo() {
        return documentoTipo;
    }

    public void setDocumentoNumero(String documentoNumero) {
        this.documentoNumero = documentoNumero;
    }

    public String getDocumentoNumero() {
        return documentoNumero;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDepartamentoId(String departamentoId) {
        this.departamentoId = departamentoId;
    }

    public String getDepartamentoId() {
        return departamentoId;
    }

    public void setNombDptoDpt(String nombDptoDpt) {
        this.nombDptoDpt = nombDptoDpt;
    }

    public String getNombDptoDpt() {
        return nombDptoDpt;
    }

    public void setProvinciaId(String provinciaId) {
        this.provinciaId = provinciaId;
    }

    public String getProvinciaId() {
        return provinciaId;
    }

    public void setNombProvTpr(String nombProvTpr) {
        this.nombProvTpr = nombProvTpr;
    }

    public String getNombProvTpr() {
        return nombProvTpr;
    }

    public void setDistritoId(String distritoId) {
        this.distritoId = distritoId;
    }

    public String getDistritoId() {
        return distritoId;
    }

    public void setNombDistTdi(String nombDistTdi) {
        this.nombDistTdi = nombDistTdi;
    }

    public String getNombDistTdi() {
        return nombDistTdi;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
