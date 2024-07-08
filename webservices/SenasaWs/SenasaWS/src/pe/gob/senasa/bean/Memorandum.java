package pe.gob.senasa.bean;

public class Memorandum {
    public Memorandum() {
        super();
    }
    
    private String personaDestino;
    private String subareaDestino;
    private String areaDestino;
    private String asunto;
    private String referencia;
    private String fechaRegistro;
    private String numeroDocumento;
    private String subTipo;

    public String getPersonaDestino() {
        return personaDestino;
    }

    public void setPersonaDestino(String personaDestino) {
        this.personaDestino = personaDestino;
    }

    public String getSubareaDestino() {
        return subareaDestino;
    }

    public void setSubareaDestino(String subareaDestino) {
        this.subareaDestino = subareaDestino;
    }

    public String getAreaDestino() {
        return areaDestino;
    }

    public void setAreaDestino(String areaDestino) {
        this.areaDestino = areaDestino;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public void setSubTipo(String subTipo) {
        this.subTipo = subTipo;
    }

    public String getSubTipo() {
        return subTipo;
    }
}
