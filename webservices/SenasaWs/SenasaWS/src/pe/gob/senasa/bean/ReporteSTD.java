package pe.gob.senasa.bean;

import java.util.Date;

public class ReporteSTD {
    public ReporteSTD() {
        super();
    }
    private String numeroDocumento;
    private String accion;
    private Date fechaRegDesde;
    private Date fechaRegHasta;
    private Date fecha;
    private Date fechaHora;
    private String anio;
    
    private String idTipoOrigenDestino;
    private String idAreaEntidadRem;
    private String areaEntidadRem;
    private String idSubAreaEntidadRem;
    private String subAreaEntidadRem;
    private String idPersonaRem;
    private String personaRem;
    
    private String idAreaEntidadDest;
    private String areaEntidadDest;
    private String idSubAreaEntidadDest;
    private String subAreaEntidadDest;
    private String idPersonaDest;
    private String personaDest;
    
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


  
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
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

   

    public void setIdTipoOrigenDestino(String idTipoOrigenDestino) {
        this.idTipoOrigenDestino= idTipoOrigenDestino;
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

  

    public void setCodElemento(String codElemento) {
        this.codElemento = codElemento;
    }

    public String getCodElemento() {
        return codElemento;
    }


    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setCodElementoRpta(String codElementoRpta) {
        this.codElementoRpta = codElementoRpta;
    }

    public String getCodElementoRpta() {
        return codElementoRpta;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getAccion() {
        return accion;
    }

    public void setIdProceso(String idProceso) {
        this.idProceso = idProceso;
    }

    public String getIdProceso() {
        return idProceso;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getAnio() {
        return anio;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }


    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getNotas() {
        return notas;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Date getFechaHora() {
        return fechaHora;
    }
}
