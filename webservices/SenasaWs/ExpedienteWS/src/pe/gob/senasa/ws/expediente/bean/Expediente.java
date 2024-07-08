package pe.gob.senasa.ws.expediente.bean;

import pe.gob.senasa.helper.bean.Auditoria;

public class Expediente {
    
    private String numero;
    private String idPersona;
    private String fecha;
    private String codigoCentroTramite;
    private String descripcionCentroTramite;
    private String codigoServicio;
    private String descripcionAreaGestion;
    private String descripcionProcedimietoTupa;
    private String descripcionServicio;
    private String nombreRazonSocial;
    private String codigoSolicitud;
    private String ucmId;
    private String codigoProcedimientoTupa;
    private String ordenVuce;
    private String canal;
    private String estado;
    private Auditoria auditoria;
    private String codigoStdDoc;
    private String cerrado;
    
    public Expediente() {
        super();
        auditoria = new Auditoria();
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }

    public Auditoria getAuditoria() {
        return auditoria;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setCodigoCentroTramite(String codigoCentroTramite) {
        this.codigoCentroTramite = codigoCentroTramite;
    }

    public String getCodigoCentroTramite() {
        return codigoCentroTramite;
    }

    public void setDescripcionCentroTramite(String descripcionCentroTramite) {
        this.descripcionCentroTramite = descripcionCentroTramite;
    }

    public String getDescripcionCentroTramite() {
        return descripcionCentroTramite;
    }

    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getCodigoServicio() {
        return codigoServicio;
    }

    public void setDescripcionAreaGestion(String descripcionAreaGestion) {
        this.descripcionAreaGestion = descripcionAreaGestion;
    }

    public String getDescripcionAreaGestion() {
        return descripcionAreaGestion;
    }

    public void setDescripcionProcedimietoTupa(String descripcionProcedimietoTupa) {
        this.descripcionProcedimietoTupa = descripcionProcedimietoTupa;
    }

    public String getDescripcionProcedimietoTupa() {
        return descripcionProcedimietoTupa;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setNombreRazonSocial(String nombreRazonSocial) {
        this.nombreRazonSocial = nombreRazonSocial;
    }

    public String getNombreRazonSocial() {
        return nombreRazonSocial;
    }

    public void setCodigoSolicitud(String codigoSolicitud) {
        this.codigoSolicitud = codigoSolicitud;
    }

    public String getCodigoSolicitud() {
        return codigoSolicitud;
    }

    public void setUcmId(String ucmId) {
        this.ucmId = ucmId;
    }

    public String getUcmId() {
        return ucmId;
    }

    public void setCodigoProcedimientoTupa(String codigoProcedimientoTupa) {
        this.codigoProcedimientoTupa = codigoProcedimientoTupa;
    }

    public String getCodigoProcedimientoTupa() {
        return codigoProcedimientoTupa;
    }

    public void setOrdenVuce(String ordenVuce) {
        this.ordenVuce = ordenVuce;
    }

    public String getOrdenVuce() {
        return ordenVuce;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getCanal() {
        return canal;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setCodigoStdDoc(String codigoStdDoc) {
        this.codigoStdDoc = codigoStdDoc;
    }

    public String getCodigoStdDoc() {
        return codigoStdDoc;
    }

    public void setCerrado(String cerrado) {
        this.cerrado = cerrado;
    }

    public String getCerrado() {
        return cerrado;
    }
}
