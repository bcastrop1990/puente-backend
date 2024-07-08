package pe.gob.senasa.bean.std;

import pe.gob.senasa.bean.audit.Audit;

public class Expediente {
    
    private String numero;
    private String idPersona;
    private Audit auditoria;
        
    public Expediente() {
        super();
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public Audit getAuditoria() {
        if (auditoria == null)
            auditoria = new Audit();
        return auditoria;
    }

    public void setAuditoria(Audit auditoria) {
        this.auditoria = auditoria;
    }
}
