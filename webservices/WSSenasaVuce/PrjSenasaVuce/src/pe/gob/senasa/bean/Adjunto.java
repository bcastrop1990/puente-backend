package pe.gob.senasa.bean;

import java.io.Serializable;

public class Adjunto implements Serializable {
    public Adjunto() {
        super();
    }
    
    private byte[] adjunto;
    private Auditoria auditoria = new Auditoria();


    public void setAdjunto(byte[] adjunto) {
        this.adjunto = adjunto;
    }

    public byte[] getAdjunto() {
        return adjunto;
    }

    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }

    public Auditoria getAuditoria() {
        return auditoria;
    }
}
