package pe.gob.senasa.dao;

public class LugarProduccionDAO {
    String pais;
    String lugar;
    
    public LugarProduccionDAO(){
      this.pais = "";
      this.lugar = "";
    }

    public LugarProduccionDAO(String pais, String lugar) {
        super();
        this.pais = pais;
        this.lugar = lugar;
    }


    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getLugar() {
        return lugar;
    }
}
