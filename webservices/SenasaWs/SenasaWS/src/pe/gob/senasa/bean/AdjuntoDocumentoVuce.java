package pe.gob.senasa.bean;

import java.io.Serializable;

public class AdjuntoDocumentoVuce implements Serializable {
    public AdjuntoDocumentoVuce() {
        super();
    }
    
    private Long id;
    private Long idDocumento;
    private String idRequisito;
    private String nombre;
    private String ucmId;
    private String estado;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setIdDocumento(Long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Long getIdDocumento() {
        return idDocumento;
    }

    public void setIdRequisito(String idRequisito) {
        this.idRequisito = idRequisito;
    }

    public String getIdRequisito() {
        return idRequisito;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setUcmId(String ucmId) {
        this.ucmId = ucmId;
    }

    public String getUcmId() {
        return ucmId;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}