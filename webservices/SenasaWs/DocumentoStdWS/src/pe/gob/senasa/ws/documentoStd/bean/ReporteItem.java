package pe.gob.senasa.ws.documentoStd.bean;

import java.util.Date;

import pe.gob.senasa.helper.bean.Auditoria;

public class ReporteItem {
    public ReporteItem() {
        super();
    }
    private String titulo;
    private byte[] reporte;
    private Auditoria auditoria;
    private String numeroDocumento;
    private String numeroExpediente;
    private String accion;
    private Date fechaRegDesde;
    private Date fechaRegHasta;
    private Date fecha;
    private Date fechaHora;
    private String anio;
    
    private String idTipoOrigenDestino;
    private String idEscenarioRem;
    private String idAreaEntidadRem;
    private String areaEntidadRem;
    private String idSubAreaEntidadRem;
    private String subAreaEntidadRem;
    private String idPersonaRem;
    private String personaRem;
    
    private String idEscenarioDest;
    private String idAreaEntidadDest;
    private String areaEntidadDest;
    private String idSubAreaEntidadDest;
    private String subAreaEntidadDest;
    private String idPersonaDest;
    private String personaDest;
    
    private String idAreaFunc;
    private String areaFunc;
    private String idSubAreaFunc;
    private String subAreFunc;
    private String idPersonaFunc;
    private String personaFunc;
    
    private String idTipoDocumental;
    private String idSubTipoDocumental;
    private String asunto;
    private String Proveido;
    private String estado;
    private String idProceso;
    private String codElemento;
    private String codElementoRpta;
    private String urgencia;
    private String notas;
    
    private String tipoReporte;

    private String tipoCertificado;

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getAccion() {
        return accion;
    }

    public void setFechaRegDesde(Date fechaRegDesde) {
        this.fechaRegDesde = fechaRegDesde;
    }

    public Date getFechaRegDesde() {
        return fechaRegDesde;
    }

    public void setFechaRegHasta(Date fechaRegHasta) {
        this.fechaRegHasta = fechaRegHasta;
    }

    public Date getFechaRegHasta() {
        return fechaRegHasta;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getAnio() {
        return anio;
    }

    public void setIdTipoOrigenDestino(String idTipoOrigenDestino) {
        this.idTipoOrigenDestino = idTipoOrigenDestino;
    }

    public String getIdTipoOrigenDestino() {
        return idTipoOrigenDestino;
    }

    public void setIdAreaEntidadRem(String idAreaEntidadRem) {
        this.idAreaEntidadRem = idAreaEntidadRem;
    }

    public String getIdAreaEntidadRem() {
        return idAreaEntidadRem;
    }

    public void setAreaEntidadRem(String areaEntidadRem) {
        this.areaEntidadRem = areaEntidadRem;
    }

    public String getAreaEntidadRem() {
        return areaEntidadRem;
    }

    public void setIdSubAreaEntidadRem(String idSubAreaEntidadRem) {
        this.idSubAreaEntidadRem = idSubAreaEntidadRem;
    }

    public String getIdSubAreaEntidadRem() {
        return idSubAreaEntidadRem;
    }

    public void setSubAreaEntidadRem(String subAreaEntidadRem) {
        this.subAreaEntidadRem = subAreaEntidadRem;
    }

    public String getSubAreaEntidadRem() {
        return subAreaEntidadRem;
    }

    public void setIdPersonaRem(String idPersonaRem) {
        this.idPersonaRem = idPersonaRem;
    }

    public String getIdPersonaRem() {
        return idPersonaRem;
    }

    public void setPersonaRem(String personaRem) {
        this.personaRem = personaRem;
    }

    public String getPersonaRem() {
        return personaRem;
    }

    public void setIdAreaEntidadDest(String idAreaEntidadDest) {
        this.idAreaEntidadDest = idAreaEntidadDest;
    }

    public String getIdAreaEntidadDest() {
        return idAreaEntidadDest;
    }

    public void setAreaEntidadDest(String areaEntidadDest) {
        this.areaEntidadDest = areaEntidadDest;
    }

    public String getAreaEntidadDest() {
        return areaEntidadDest;
    }

    public void setIdSubAreaEntidadDest(String idSubAreaEntidadDest) {
        this.idSubAreaEntidadDest = idSubAreaEntidadDest;
    }

    public String getIdSubAreaEntidadDest() {
        return idSubAreaEntidadDest;
    }

    public void setSubAreaEntidadDest(String subAreaEntidadDest) {
        this.subAreaEntidadDest = subAreaEntidadDest;
    }

    public String getSubAreaEntidadDest() {
        return subAreaEntidadDest;
    }

    public void setIdPersonaDest(String idPersonaDest) {
        this.idPersonaDest = idPersonaDest;
    }

    public String getIdPersonaDest() {
        return idPersonaDest;
    }

    public void setPersonaDest(String personaDest) {
        this.personaDest = personaDest;
    }

    public String getPersonaDest() {
        return personaDest;
    }

    public void setIdTipoDocumental(String idTipoDocumental) {
        this.idTipoDocumental = idTipoDocumental;
    }

    public String getIdTipoDocumental() {
        return idTipoDocumental;
    }

    public void setIdSubTipoDocumental(String idSubTipoDocumental) {
        this.idSubTipoDocumental = idSubTipoDocumental;
    }

    public String getIdSubTipoDocumental() {
        return idSubTipoDocumental;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setProveido(String Proveido) {
        this.Proveido = Proveido;
    }

    public String getProveido() {
        return Proveido;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setIdProceso(String idProceso) {
        this.idProceso = idProceso;
    }

    public String getIdProceso() {
        return idProceso;
    }

    public void setCodElemento(String codElemento) {
        this.codElemento = codElemento;
    }

    public String getCodElemento() {
        return codElemento;
    }

    public void setCodElementoRpta(String codElementoRpta) {
        this.codElementoRpta = codElementoRpta;
    }

    public String getCodElementoRpta() {
        return codElementoRpta;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getNotas() {
        return notas;
    }

    public void setReporte(byte[] reporte) {
        this.reporte = reporte;
    }

    public byte[] getReporte() {
        return reporte;
    }

    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }

    public Auditoria getAuditoria() {
        return auditoria;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setIdEscenarioRem(String idEscenarioRem) {
        this.idEscenarioRem = idEscenarioRem;
    }

    public String getIdEscenarioRem() {
        return idEscenarioRem;
    }

    public void setIdEscenarioDest(String idEscenarioDest) {
        this.idEscenarioDest = idEscenarioDest;
    }

    public String getIdEscenarioDest() {
        return idEscenarioDest;
    }

    public void setIdPersonaFunc(String idPersonaFunc) {
        this.idPersonaFunc = idPersonaFunc;
    }

    public String getIdPersonaFunc() {
        return idPersonaFunc;
    }

    public void setPersonaFunc(String personaFunc) {
        this.personaFunc = personaFunc;
    }

    public String getPersonaFunc() {
        return personaFunc;
    }

    public void setIdAreaFunc(String idAreaFunc) {
        this.idAreaFunc = idAreaFunc;
    }

    public String getIdAreaFunc() {
        return idAreaFunc;
    }

    public void setAreaFunc(String areaFunc) {
        this.areaFunc = areaFunc;
    }

    public String getAreaFunc() {
        return areaFunc;
    }

    public void setIdSubAreaFunc(String idSubAreaFunc) {
        this.idSubAreaFunc = idSubAreaFunc;
    }

    public String getIdSubAreaFunc() {
        return idSubAreaFunc;
    }

    public void setSubAreFunc(String subAreFunc) {
        this.subAreFunc = subAreFunc;
    }

    public String getSubAreFunc() {
        return subAreFunc;
    }

    public void setNumeroExpediente(String numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public String getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setTipoReporte(String tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    public String getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoCertificado(String tipoCertificado) {
        this.tipoCertificado = tipoCertificado;
    }

    public String getTipoCertificado() {
        return tipoCertificado;
    }
}
