package pe.gob.senasa.bean;

public class Funcionario {
    
    String nombre="";
    String correo="";
    String idFuncionario="";
    String idJefe="";
    String userName="";
    String codigoArea = "";
    String codigoSubArea;
    String abreviaturaArea="";
    String abreviaturaSubArea="";
    String nombreArea="";
    String nombreSubArea="";
    String condicion = "";/*RCF*/
  

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdJefe(String idJefe) {
        this.idJefe = idJefe;
    }

    public String getIdJefe() {
        return idJefe;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setCodigoArea(String codigoArea) {
        this.codigoArea = codigoArea;
    }

    public String getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoSubArea(String codigoSubArea) {
        this.codigoSubArea = codigoSubArea;
    }

    public String getCodigoSubArea() {
        return codigoSubArea;
    }

    public void setAbreviaturaArea(String abreviaturaArea) {
        this.abreviaturaArea = abreviaturaArea;
    }

    public String getAbreviaturaArea() {
        return abreviaturaArea;
    }

    public void setAbreviaturaSubArea(String abreviaturaSubArea) {
        this.abreviaturaSubArea = abreviaturaSubArea;
    }

    public String getAbreviaturaSubArea() {
        return abreviaturaSubArea;
    }
    
  public void setNombreArea(String nombreArea) {
      this.nombreArea = nombreArea;
  }

  public String getNombreArea() {
      return nombreArea;
  }

	public void setNombreSubArea(String nombreSubArea) {
		this.nombreSubArea = nombreSubArea;
	}

	public String getNombreSubArea() {
		return nombreSubArea;
	}

    public void setCondicion(String condicion) {/*RCF*/
        this.condicion = condicion;
    }

    public String getCondicion() {/*RCF*/
        return condicion;
    }
}
