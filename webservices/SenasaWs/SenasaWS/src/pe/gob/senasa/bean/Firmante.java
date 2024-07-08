package pe.gob.senasa.bean;

public class Firmante {
    
    private String userName;
    private String nomencaltura;
    private String lugar;
    
    public Firmante() {
        super();
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setNomencaltura(String nomencaltura) {
        this.nomencaltura = nomencaltura;
    }

    public String getNomencaltura() {
        return nomencaltura;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getLugar() {
        return lugar;
    }
}
