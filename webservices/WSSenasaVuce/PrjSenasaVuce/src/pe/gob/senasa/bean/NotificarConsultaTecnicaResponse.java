package pe.gob.senasa.bean;

import java.io.Serializable;

public class NotificarConsultaTecnicaResponse  implements Serializable{
    public NotificarConsultaTecnicaResponse() {
        super();
    }

    private Auditoria auditoria;
    private Boolean flagValidar;

    public void setFlagValidar(Boolean flagValidar) {
        this.flagValidar = flagValidar;
    }

    public Boolean getFlagValidar() {
        return flagValidar;
    }

    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }

    public Auditoria getAuditoria() {
        return auditoria;
    }
}
