package pe.gob.senasa.bean.std;

import java.util.Date;

import pe.gob.senasa.bean.audit.Audit;


public class DocumentoSTD {
    public DocumentoSTD() {
        super();
    }

    private String estado;
    private String codigo;
    private String nombre;
    private String escenario;
    private String tipo;
    private String subTipo;
    private String autor;
    private String autorId;
    private String ucmId;
    private String codigoDocPadre;
    private Date fechaCrea;
    private Boolean isDocPrincipal;
    private String tipo_doc;
    private Date fechahora;
    private String numeroExpediente;
    private Audit auditoria;
    private String archivoFisico;
    private String archivoFolio;
    private String confidencial;
    private String indicadorObligatorio;

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setNombre(String numero) {
        this.nombre = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEscenario(String escenario) {
        this.escenario = escenario;
    }

    public String getEscenario() {
        return escenario;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setSubTipo(String subTipo) {
        this.subTipo = subTipo;
    }

    public String getSubTipo() {
        return subTipo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutorId(String autorId) {
        this.autorId = autorId;
    }

    public String getAutorId() {
        return autorId;
    }

    public void setUcmId(String ucmId) {
        this.ucmId = ucmId;
    }

    public String getUcmId() {
        return ucmId;
    }

    public void setCodigoDocPadre(String codigoDocPadre) {
        this.codigoDocPadre = codigoDocPadre;
    }

    public String getCodigoDocPadre() {
        return codigoDocPadre;
    }


    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setIsDocPrincipal(Boolean isDocPrincipal) {
        this.isDocPrincipal = isDocPrincipal;
    }

    public Boolean getIsDocPrincipal() {
        return isDocPrincipal;
    }

    public void setTipo_doc(String tipo_doc) {
        this.tipo_doc = tipo_doc;
    }

    public String getTipo_doc() {
        return tipo_doc;
    }


    public void setFechahora(Date fechahora) {
        this.fechahora = fechahora;
    }

    public Date getFechahora() {
        return fechahora;
    }

    public void setNumeroExpediente(String numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public String getNumeroExpediente() {
        return numeroExpediente;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
    
    public Audit getAuditoria() {
        if (auditoria == null)
            auditoria = new Audit();
        return auditoria;
    }

    public void setAuditoria(Audit auditoria) {
        this.auditoria = auditoria;
    }

    public void setArchivoFisico(String archivoFisico) {
        this.archivoFisico = archivoFisico;
    }

    public String getArchivoFisico() {
        return archivoFisico;
    }

    public void setArchivoFolio(String archivoFolio) {
        this.archivoFolio = archivoFolio;
    }

    public String getArchivoFolio() {
        return archivoFolio;
    }

    public void setConfidencial(String confidencial) {
        this.confidencial = confidencial;
    }

    public String getConfidencial() {
        return confidencial;
    }

    public void setIndicadorObligatorio(String indicadorObligatorio) {
        this.indicadorObligatorio = indicadorObligatorio;
    }

    public String getIndicadorObligatorio() {
        return indicadorObligatorio;
    }
}
