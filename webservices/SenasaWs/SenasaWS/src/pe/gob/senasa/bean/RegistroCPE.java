package pe.gob.senasa.bean;


import java.util.ArrayList;
import java.util.Date;

public class RegistroCPE {
    
    public RegistroCPE() {
        super();
    }
    
    private String noFolio;
    private String sede;
    private String nombreSede;
    private String direccionSede;
    private String codigoPersona;
    private String noCertificado;
    private String usuario;
    private String estado;
    private Date fechaEmision;
    private ArrayList<LugaresProduccionCPE> lugaresProduccionCPE = new ArrayList<LugaresProduccionCPE>();
    private ArrayList<ProductosCPE> productosCPE = new ArrayList<ProductosCPE>();
    private ArrayList<EquipoTecnicoCPE> equipoTecnicoCPE = new ArrayList<EquipoTecnicoCPE>();
    private Solicitante solicitante;
    private String urlRegistroCPE;

    public void setNoFolio(String noFolio) {
        this.noFolio = noFolio;
    }

    public String getNoFolio() {
        return noFolio;
    }

    public void setNoCertificado(String noCertificado) {
        this.noCertificado = noCertificado;
    }

    public String getNoCertificado() {
        return noCertificado;
    }

    public void setLugaresProduccionCPE(ArrayList<LugaresProduccionCPE> lugaresProduccionCPE) {
        this.lugaresProduccionCPE = lugaresProduccionCPE;
    }

    public ArrayList<LugaresProduccionCPE> getLugaresProduccionCPE() {
        return lugaresProduccionCPE;
    }

    public void setProductosCPE(ArrayList<ProductosCPE> productosCPE) {
        this.productosCPE = productosCPE;
    }

    public ArrayList<ProductosCPE> getProductosCPE() {
        return productosCPE;
    }

    public void setEquipoTecnicoCPE(ArrayList<EquipoTecnicoCPE> equipoTecnicoCPE) {
        this.equipoTecnicoCPE = equipoTecnicoCPE;
    }

    public ArrayList<EquipoTecnicoCPE> getEquipoTecnicoCPE() {
        return equipoTecnicoCPE;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getSede() {
        return sede;
    }

    public void setCodigoPersona(String codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    public String getCodigoPersona() {
        return codigoPersona;
    }


    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setDireccionSede(String direccionSede) {
        this.direccionSede = direccionSede;
    }

    public String getDireccionSede() {
        return direccionSede;
    }

    public void setUrlRegistroCPE(String urlRegistroCPE) {
        this.urlRegistroCPE = urlRegistroCPE;
    }

    public String getUrlRegistroCPE() {
        return urlRegistroCPE;
    }

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}
}
