package pe.gob.senasa.bean;


public class RespuestaAnalisisLaboratorio extends Respuesta {
    
    private boolean resultadoEspera;
    
    private String numeroUCM;
    
    private String urlUCM;
    
   private String resultadoDetalle;
    
    public RespuestaAnalisisLaboratorio() {
        super();
    }

    public RespuestaAnalisisLaboratorio(boolean resultadoEspera, String numeroUCM,
                                        String urlUCM, String resultadoDetalle) {
        super();
        this.resultadoEspera = resultadoEspera;
        this.numeroUCM = numeroUCM;
        this.urlUCM = urlUCM;
        this.resultadoDetalle = resultadoDetalle;
        
    }


    public void setNumeroUCM(String numeroUCM) {
        this.numeroUCM = numeroUCM;
    }

    public String getNumeroUCM() {
        return numeroUCM;
    }

    public void setUrlUCM(String urlUCM) {
        this.urlUCM = urlUCM;
    }

    public String getUrlUCM() {
        return urlUCM;
    }


    public void setResultadoEspera(boolean resultadoEspera) {
        this.resultadoEspera = resultadoEspera;
    }

    public boolean getResultadoEspera() {
        return resultadoEspera;
    }

    public void setResultadoDetalle(String resultadoDetalle) {
        this.resultadoDetalle = resultadoDetalle;
    }

    public String getResultadoDetalle() {
        return resultadoDetalle;
    }
}
