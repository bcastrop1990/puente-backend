package pe.gob.senasa.bean;

public class DocumentoElectronico {
    public DocumentoElectronico() {
        super();
    }
    
    private String idEntidad;
    private String idTransaccion;
    private String codigoElemento;
    private String numeroDocumento;
    private String entidad;
    private String area;
    private String fecha;
    private String remitente;
    private String asunto;
    private String entidadIdPersona;
    private String entidadDocumentoTipo;
  private String entidadDocumentoNumero;
  private String entidadNombre;

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setCodigoElemento(String codigoElemento) {
        this.codigoElemento = codigoElemento;
    }

    public String getCodigoElemento() {
        return codigoElemento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setIdEntidad(String idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getIdEntidad() {
        return idEntidad;
    }

    public void setEntidadDocumentoTipo(String entidadDocumentoTipo) {
        this.entidadDocumentoTipo = entidadDocumentoTipo;
    }

    public String getEntidadDocumentoTipo() {
        return entidadDocumentoTipo;
    }

    public void setEntidadDocumentoNumero(String entidadDocumentoNumero) {
        this.entidadDocumentoNumero = entidadDocumentoNumero;
    }

    public String getEntidadDocumentoNumero() {
        return entidadDocumentoNumero;
    }

    public void setEntidadNombre(String entidadNombre) {
        this.entidadNombre = entidadNombre;
    }

    public String getEntidadNombre() {
        return entidadNombre;
    }

    public void setEntidadIdPersona(String entidadIdPersona) {
        this.entidadIdPersona = entidadIdPersona;
    }

    public String getEntidadIdPersona() {
        return entidadIdPersona;
    }
}
