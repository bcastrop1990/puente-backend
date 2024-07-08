package pe.gob.senasa.bean;

import java.io.Serializable;

public class Solicitante implements Serializable {
    
    public Solicitante() {
        super();
    }
    
    private String codigoSolicitante;
    private String tipoDocumento;
    private String dniRuc;
    private String nombreRazonSocial;
    private String domicilioLegal;
    private String distrito;
    private String provincia;
    private String departamento;
    private String urbanizacion;
    private String telefono;
    private String telefonoMovil;
    private String email;
    private String dniRepresentanteLegal;
    private String nombreRepresentanteLegal;
    private String nombreImportador;
    private String tipoSolicitante;
    
    private String nombreDepartamento;
    private String nombreProvincia;
    private String nombreDistrito;
  

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setDniRuc(String dniRuc) {
        this.dniRuc = dniRuc;
    }

    public String getDniRuc() {
        return dniRuc;
    }

    public void setNombreRazonSocial(String nombreRazonSocial) {
        this.nombreRazonSocial = nombreRazonSocial;
    }

    public String getNombreRazonSocial() {
        return nombreRazonSocial;
    }

    public void setDomicilioLegal(String domicilioLegal) {
        this.domicilioLegal = domicilioLegal;
    }

    public String getDomicilioLegal() {
        return domicilioLegal;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
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

    public void setDniRepresentanteLegal(String dniRepresentanteLegal) {
        this.dniRepresentanteLegal = dniRepresentanteLegal;
    }

    public String getDniRepresentanteLegal() {
        return dniRepresentanteLegal;
    }

    public void setNombreRepresentanteLegal(String nombreRepresentanteLegal) {
        this.nombreRepresentanteLegal = nombreRepresentanteLegal;
    }

    public String getNombreRepresentanteLegal() {
        return nombreRepresentanteLegal;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setCodigoSolicitante(String codigoSolicitante) {
        this.codigoSolicitante = codigoSolicitante;
    }

    public String getCodigoSolicitante() {
        return codigoSolicitante;
    }

    public void setUrbanizacion(String urbanizacion) {
        this.urbanizacion = urbanizacion;
    }

    public String getUrbanizacion() {
        return urbanizacion;
    }

    public void setNombreImportador(String nombreImportador) {
        this.nombreImportador = nombreImportador;
    }

    public String getNombreImportador() {
        return nombreImportador;
    }

    public void setTipoSolicitante(String tipoSolicitante) {
        this.tipoSolicitante = tipoSolicitante;
    }

    public String getTipoSolicitante() {
        return tipoSolicitante;
    }
    
    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento= nombreDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }
  
    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia= nombreProvincia;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }
  
    public void setNombreDistrito(String nombreDistrito) {
        this.nombreDistrito= nombreDistrito;
    }

    public String getNombreDistrito() {
        return nombreDistrito;
    }
  
}