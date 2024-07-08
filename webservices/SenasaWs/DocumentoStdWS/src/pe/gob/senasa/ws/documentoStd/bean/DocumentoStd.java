package pe.gob.senasa.ws.documentoStd.bean;

import java.util.ArrayList;

import pe.gob.senasa.helper.bean.Auditoria;

public class DocumentoStd {
    private Auditoria auditoria;
    private boolean previsualizar = false;
    private boolean conFirma = true;
    private String personaDestino;
    private String subareaDestino;
    private String areaDestino;
    private String asunto;
    private String referencia;
    private String fechaRegistro;
    private String numeroDocumento;
    private String subTipo;
    private byte[] archivo;
    private String nombreArchivo;
    private ArrayList<FuncionarioStd> firmantes = new ArrayList<FuncionarioStd>();
    private boolean encargatura;
    
    private String codigo;
    private String ucmId;
    private String confidencial;
    private String folio;
    private String escenario;
    private String tipo;
    private String autor;
    private String autorId;
    private String tipoAdjunto;
    private String codigoPadre;
    
    private String fisico;/*RCF*/
    
    public DocumentoStd() {
        super();
    }

    public void setPersonaDestino(String personaDestino) {
        this.personaDestino = personaDestino;
    }

    public String getPersonaDestino() {
        return personaDestino;
    }

    public void setSubareaDestino(String subareaDestino) {
        this.subareaDestino = subareaDestino;
    }

    public String getSubareaDestino() {
        return subareaDestino;
    }

    public void setAreaDestino(String areaDestino) {
        this.areaDestino = areaDestino;
    }

    public String getAreaDestino() {
        return areaDestino;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setSubTipo(String subTipo) {
        this.subTipo = subTipo;
    }

    public String getSubTipo() {
        return subTipo;
    }

    public void setPrevisualizar(boolean previsualizar) {
        this.previsualizar = previsualizar;
    }

    public boolean isPrevisualizar() {
        return previsualizar;
    }

    public void setConFirma(boolean conFirma) {
        this.conFirma = conFirma;
    }

    public boolean isConFirma() {
        return conFirma;
    }

    public void setEncargatura(boolean encargatura) {
        this.encargatura = encargatura;
    }

    public boolean isEncargatura() {
        return encargatura;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

    public byte[] getArchivo() {
        return archivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }

    public Auditoria getAuditoria() {
        return auditoria;
    }

    public void setFirmantes(ArrayList<FuncionarioStd> firmantes) {
        this.firmantes = firmantes;
    }

    public ArrayList<FuncionarioStd> getFirmantes() {
        return firmantes;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setUcmId(String ucmId) {
        this.ucmId = ucmId;
    }

    public String getUcmId() {
        return ucmId;
    }

    public void setConfidencial(String confidencial) {
        this.confidencial = confidencial;
    }

    public String getConfidencial() {
        return confidencial;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getFolio() {
        return folio;
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

    public void setTipoAdjunto(String tipoAdjunto) {
        this.tipoAdjunto = tipoAdjunto;
    }

    public String getTipoAdjunto() {
        return tipoAdjunto;
    }

    public void setCodigoPadre(String codigoPadre) {
        this.codigoPadre = codigoPadre;
    }

    public String getCodigoPadre() {
        return codigoPadre;
    }

    public void setFisico(String fisico) {/*RCF*/
        this.fisico = fisico;
    }

    public String getFisico() {/*RCF*/
        return fisico;
    }
}
