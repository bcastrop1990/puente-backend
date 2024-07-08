package pe.gob.senasa.bean;

public class ProductoIiv extends Producto {
    public ProductoIiv() {
        super();
    }
    private String codEnvase;
    private String descEnvase;
    private String codUM;
    private String descUM;
    private Double peso;
    private Double cantEnvase;
    private Double cantidad;
    private String sexo;
    private String edad;
    private String codRaza;
    private String nomRaza;
    private String nombreEspecie;
    private String partidaArancelaria;
    private String numIdenfAnimal;
        

    public void setCodEnvase(String codEnvase) {
        this.codEnvase = codEnvase;
    }

    public String getCodEnvase() {
        return codEnvase;
    }

    public void setDescEnvase(String descEnvase) {
        this.descEnvase = descEnvase;
    }

    public String getDescEnvase() {
        return descEnvase;
    }

    public void setCodUM(String codUM) {
        this.codUM = codUM;
    }

    public String getCodUM() {
        return codUM;
    }

    public void setDescUM(String descUM) {
        this.descUM = descUM;
    }

    public String getDescUM() {
        return descUM;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getPeso() {
        return peso;
    }

    public void setCantEnvase(Double cantEnvase) {
        this.cantEnvase = cantEnvase;
    }

    public Double getCantEnvase() {
        return cantEnvase;
    }


    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEdad() {
        return edad;
    }

    public void setPartidaArancelaria(String partidaArancelaria) {
        this.partidaArancelaria = partidaArancelaria;
    }

    public String getPartidaArancelaria() {
        return partidaArancelaria;
    }

    public void setNombreEspecie(String nombreEspecie) {
        this.nombreEspecie = nombreEspecie;
    }

    public String getNombreEspecie() {
        return nombreEspecie;
    }

    public void setCodRaza(String codRaza) {
        this.codRaza = codRaza;
    }

    public String getCodRaza() {
        return codRaza;
    }

    public void setNomRaza(String nomRaza) {
        this.nomRaza = nomRaza;
    }

    public String getNomRaza() {
        return nomRaza;
    }

    public void setNumIdenfAnimal(String numIdenfAnimal) {
        this.numIdenfAnimal = numIdenfAnimal;
    }

    public String getNumIdenfAnimal() {
        return numIdenfAnimal;
    }
}
