package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.ArrayList;


public class SolicitudAnalisisUCDSV implements Serializable{
    
    private CabeceraSolicitudAnalisis cabecera;
    private ArrayList<DetalleSolicitudUCDSV> detalles;

    public SolicitudAnalisisUCDSV(CabeceraSolicitudAnalisis cabecera,
                                  ArrayList<DetalleSolicitudUCDSV> detalles) {
        super();
        this.cabecera = cabecera;
        this.detalles = detalles;
    }
    
    public SolicitudAnalisisUCDSV() {
        super();
    }


    public void setCabecera(CabeceraSolicitudAnalisis cabecera) {
        this.cabecera = cabecera;
    }

    public CabeceraSolicitudAnalisis getCabecera() {
        return cabecera;
    }

    public void setDetalles(ArrayList<DetalleSolicitudUCDSV> detalles) {
        this.detalles = detalles;
    }

    public ArrayList<DetalleSolicitudUCDSV> getDetalles() {
        return detalles;
    }
    
    
}
