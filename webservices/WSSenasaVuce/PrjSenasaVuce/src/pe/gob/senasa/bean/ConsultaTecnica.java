package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.Date;


public class ConsultaTecnica implements Serializable{
    public ConsultaTecnica() {
        super();
    }
    
    private String nombre;
    private String rucdni;
    private String descProducto;
    private String partidaArancelaria;
    private String paisOrigen;
    private String paisProcedencia;
    private String paisDestino;
    private String descComercial;
    private String subPartidaNacional;
    private Integer cantidad;
    private String unidadMedida;
    private String aplicacion;
    private String asunto;
    private String pregunta;
    private String respuesta;
    private String baseLegal;
    private String operacion;
    private Date fechaRespuesta;
    private String ucmIdRespuesta;
    private Auditoria auditoria;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setRucdni(String rucdni) {
        this.rucdni = rucdni;
    }

    public String getRucdni() {
        return rucdni;
    }

    public void setDescProducto(String descProducto) {
        this.descProducto = descProducto;
    }

    public String getDescProducto() {
        return descProducto;
    }

    public void setPartidaArancelaria(String partidaArancelaria) {
        this.partidaArancelaria = partidaArancelaria;
    }

    public String getPartidaArancelaria() {
        return partidaArancelaria;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisProcedencia(String paisProcedencia) {
        this.paisProcedencia = paisProcedencia;
    }

    public String getPaisProcedencia() {
        return paisProcedencia;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setDescComercial(String descComercial) {
        this.descComercial = descComercial;
    }

    public String getDescComercial() {
        return descComercial;
    }

    public void setSubPartidaNacional(String subPartidaNacional) {
        this.subPartidaNacional = subPartidaNacional;
    }

    public String getSubPartidaNacional() {
        return subPartidaNacional;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }

    public Auditoria getAuditoria() {
        return auditoria;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setBaseLegal(String baseLegal) {
        this.baseLegal = baseLegal;
    }

    public String getBaseLegal() {
        return baseLegal;
    }

    public void setFechaRespuesta(Date fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public Date getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setUcmIdRespuesta(String ucmIdRespuesta) {
        this.ucmIdRespuesta = ucmIdRespuesta;
    }

    public String getUcmIdRespuesta() {
        return ucmIdRespuesta;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getOperacion() {
        return operacion;
    }
}
