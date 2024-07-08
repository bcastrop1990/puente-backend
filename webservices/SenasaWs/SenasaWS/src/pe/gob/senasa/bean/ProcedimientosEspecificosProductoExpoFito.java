package pe.gob.senasa.bean;

import java.io.Serializable;

public class ProcedimientosEspecificosProductoExpoFito implements Serializable {

    private static final long serialVersionUID = 1L;
    private String tipoCertificado;
    private String procedimientoEspecifico;
    
    public ProcedimientosEspecificosProductoExpoFito() {
        super();
    }

    public ProcedimientosEspecificosProductoExpoFito(String tipoCertificado,
                                                     String procedimientoEspecifico) {
        super();
        this.tipoCertificado = tipoCertificado;
        this.procedimientoEspecifico = procedimientoEspecifico;
    }

    public void setTipoCertificado(String tipoCertificado) {
        this.tipoCertificado = tipoCertificado;
    }

    public String getTipoCertificado() {
        return tipoCertificado;
    }

    public void setProcedimientoEspecifico(String procedimientoEspecifico) {
        this.procedimientoEspecifico = procedimientoEspecifico;
    }

    public String getProcedimientoEspecifico() {
        return procedimientoEspecifico;
    }
}
