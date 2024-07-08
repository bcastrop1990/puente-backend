package pe.gob.senasa.bean;

import java.io.Serializable;


public class DirectorioSenasa implements Serializable {


   

    public DirectorioSenasa() {
      super();
  }
  
  private String GroupName;
  private String NomCuenta;
  private String distNom;
  private String Usuariolist;


    public void setNomCuenta(String NomCuenta) {
        this.NomCuenta = NomCuenta;
    }

    public String getNomCuenta() {
        return NomCuenta;
    }

    public void setDistNom(String distNom) {
        this.distNom = distNom;
    }

    public String getDistNom() {
        return distNom;
    }

    public void setUsuariolist(String Usuariolist) {
        this.Usuariolist = Usuariolist;
    }

    public String getUsuariolist() {
        return Usuariolist;
    }
}
