package pe.gob.senasa.ws.trazabilidad.bean;

import java.util.Date;

import pe.gob.senasa.helper.bean.Auditoria;

public class Trazabilidad {
    public Trazabilidad() {
        super();
    }
    
    private String proceso;
    private String idOriginal;
    private String idFinal;
    private int secuencial;
    private Date   fechaHora;
    private String descripcionAsunto;
    private String remitenteAreaEntidad;
    private String remitenteSubAreaEntidad;
    private String remitentePersona;
    private String remitenteUsuario;
    private String destinatarioAreaEntidad;
    private String destinatarioSubAreaEntidad;
    private String destinatarioPersona;
    private String destinatarioUsuario;
    private String accion;
    private String estado;
    private String notas;
    private String proveido;
    private String urgencia;
    private String canal="BPM";
    private int secuencialSuperior;
    private String codigoElemento;
    private String codigoElementoRespuesta;
    private String ucmid;
    
    private Auditoria auditoria = null;

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public String getProceso() {
        return proceso;
    }

    public void setIdOriginal(String idOriginal) {
        this.idOriginal = idOriginal;
    }

    public String getIdOriginal() {
        return idOriginal;
    }

    public void setIdFinal(String idFinal) {
        this.idFinal = idFinal;
    }

    public String getIdFinal() {
        return idFinal;
    }

    public void setSecuencial(int secuencial) {
        this.secuencial = secuencial;
    }

    public int getSecuencial() {
        return secuencial;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setDescripcionAsunto(String descripcionAsunto) {
        this.descripcionAsunto = descripcionAsunto;
    }

    public String getDescripcionAsunto() {
        return descripcionAsunto;
    }

    public void setRemitenteAreaEntidad(String remitenteAreaEntidad) {
        this.remitenteAreaEntidad = remitenteAreaEntidad;
    }

    public String getRemitenteAreaEntidad() {
        return remitenteAreaEntidad;
    }

    public void setRemitenteSubAreaEntidad(String remitenteSubAreaEntidad) {
        this.remitenteSubAreaEntidad = remitenteSubAreaEntidad;
    }

    public String getRemitenteSubAreaEntidad() {
        return remitenteSubAreaEntidad;
    }

    public void setRemitentePersona(String remitentePersona) {
        this.remitentePersona = remitentePersona;
    }

    public String getRemitentePersona() {
        return remitentePersona;
    }

    public void setRemitenteUsuario(String remitenteUsuario) {
        this.remitenteUsuario = remitenteUsuario;
    }

    public String getRemitenteUsuario() {
        return remitenteUsuario;
    }

    public void setDestinatarioAreaEntidad(String destinatarioAreaEntidad) {
        this.destinatarioAreaEntidad = destinatarioAreaEntidad;
    }

    public String getDestinatarioAreaEntidad() {
        return destinatarioAreaEntidad;
    }

    public void setDestinatarioSubAreaEntidad(String destinatarioSubAreaEntidad) {
        this.destinatarioSubAreaEntidad = destinatarioSubAreaEntidad;
    }

    public String getDestinatarioSubAreaEntidad() {
        return destinatarioSubAreaEntidad;
    }

    public void setDestinatarioPersona(String destinatarioPersona) {
        this.destinatarioPersona = destinatarioPersona;
    }

    public String getDestinatarioPersona() {
        return destinatarioPersona;
    }

    public void setDestinatarioUsuario(String destinatarioUsuario) {
        this.destinatarioUsuario = destinatarioUsuario;
    }

    public String getDestinatarioUsuario() {
        return destinatarioUsuario;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getAccion() {
        return accion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getNotas() {
        return notas;
    }

    public void setProveido(String proveido) {
        this.proveido = proveido;
    }

    public String getProveido() {
        return proveido;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getCanal() {
        return canal;
    }

    public void setSecuencialSuperior(int secuencialSuperior) {
        this.secuencialSuperior = secuencialSuperior;
    }

    public int getSecuencialSuperior() {
        return secuencialSuperior;
    }

    public void setCodigoElemento(String codigoElemento) {
        this.codigoElemento = codigoElemento;
    }

    public String getCodigoElemento() {
        return codigoElemento;
    }

    public void setCodigoElementoRespuesta(String codigoElementoRespuesta) {
        this.codigoElementoRespuesta = codigoElementoRespuesta;
    }

    public String getCodigoElementoRespuesta() {
        return codigoElementoRespuesta;
    }
    
    public void setUcmid(String ucmid) {
        this.ucmid = ucmid;
    }
  
    public String getUcmid() {
        return ucmid;
    }
    
    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }

    public Auditoria getAuditoria() {
        if (auditoria == null)
            auditoria = new Auditoria();
        return auditoria;
    }
    
}
