package pe.gob.senasa.bean;

import java.util.Date;
import java.util.List;

public class InpeccionVerificacion {
    public InpeccionVerificacion() {
        super();
    }
    private String codigoIIV;
    private String idCentroTramite;
    private String idAgencia;
    private String idLineaTransporte;
    private String numPermiso;
    private String observacion;
    private String expediente;
    private String idPaisProcedencia;
    private String idLugarInspeccion;
    private String idServicio;
    private Date fechaReg;
    private Date fechaInspeccion;
    private Date HoraInspeccion;
    private String establecImpoAnimal;
    private String idPersona;
    private List<ProductoIIV> listaProductos;
    private List<PaisOrigenIIV> listaPaisesOrg;


    public void setCodigoIIV(String codigoIIV) {
        this.codigoIIV = codigoIIV;
    }

    public String getCodigoIIV() {
        return codigoIIV;
    }

    public void setIdCentroTramite(String idCentroTramite) {
        this.idCentroTramite = idCentroTramite;
    }

    public String getIdCentroTramite() {
        return idCentroTramite;
    }

    public void setIdAgencia(String idAgencia) {
        this.idAgencia = idAgencia;
    }

    public String getIdAgencia() {
        return idAgencia;
    }

    public void setIdLineaTransporte(String idLineaTransporte) {
        this.idLineaTransporte = idLineaTransporte;
    }

    public String getIdLineaTransporte() {
        return idLineaTransporte;
    }

    public void setNumPermiso(String numPermiso) {
        this.numPermiso = numPermiso;
    }

    public String getNumPermiso() {
        return numPermiso;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getObservacion() {
        return observacion;
    }



    public void setIdPaisProcedencia(String idPaisProcedencia) {
        this.idPaisProcedencia = idPaisProcedencia;
    }

    public String getIdPaisProcedencia() {
        return idPaisProcedencia;
    }

    public void setIdLugarInspeccion(String idLugarInspeccion) {
        this.idLugarInspeccion = idLugarInspeccion;
    }

    public String getIdLugarInspeccion() {
        return idLugarInspeccion;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getIdServicio() {
        return idServicio;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaInspeccion(Date fechaInspeccion) {
        this.fechaInspeccion = fechaInspeccion;
    }

    public Date getFechaInspeccion() {
        return fechaInspeccion;
    }

    public void setHoraInspeccion(Date HoraInspeccion) {
        this.HoraInspeccion = HoraInspeccion;
    }

    public Date getHoraInspeccion() {
        return HoraInspeccion;
    }

    public void setEstablecImpoAnimal(String establecImpoAnimal) {
        this.establecImpoAnimal = establecImpoAnimal;
    }

    public String getEstablecImpoAnimal() {
        return establecImpoAnimal;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setListaProductos(List<ProductoIIV> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public List<ProductoIIV> getListaProductos() {
        return listaProductos;
    }

    public void setListaPaisesOrg(List<PaisOrigenIIV> listaPaisesOrg) {
        this.listaPaisesOrg = listaPaisesOrg;
    }

    public List<PaisOrigenIIV> getListaPaisesOrg() {
        return listaPaisesOrg;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public String getExpediente() {
        return expediente;
    }
}
