package pe.gob.senasa.bean;

import java.io.Serializable;

import java.util.Date;


public class DatosExpo implements Serializable{
    public DatosExpo() {
        super();
    }
  private String codigoCertificadoFitoExpo ;
  private Persona solicitante ;
  private Persona repLegal ;
  private Persona agente ;
  private String codPaisImportador;
  private String desPaisImportador;
  private String codImportador;
  private String nombImportador;
  private String direcImportador;  
  private String codPaisDestino;
  private String descPaisDestino;  
  private String codPtoIngreso;
  private String descPtoIngreso;
  private String codPtoSalida;
  private String descPtoSalida;  
  private String codMedioTransporte;
  private String desMedioTransporte;
  private Date fechaEmbarque;
  private Date fechaDesembarque;
  private String codUsodestino;
  private String desUsoDestino;
  private String codDirecEjecutiva;
  private String desDirecEjecutiva;
  private String tipoModificacion;
  private String numDocResolutivo;
  private String numCertModificar;
  private String codLugInspeccion;
  private String desLugInspeccion;
  
  private String rucLugarInspeccion;
  private String tipoDocLugInspeccion;
  private String tipoServicio;
  private String tpUbEnvio;
  private String certificado;
  private String nombPlanta;
  private String direccPlanta;
  private Date fechaInspeccion;
  private Date horaInspeccion;
  private Boolean isTratCuarentenario;
  private String tipoTratCuarentenario;
  private String destipoTratCuarentenario;
  private String rucLugarInspeccionFinal;
  private String tipoDocLugInspeccionFinal;
  private String tpUbEnvioFinal;
  private String certificadoFinal;
  private String nombPlantaFinal;
  private String direccPlantaFinal;
  private ProductosIIV productos = new ProductosIIV();
  private String nroRegEstbExp;
  private String nroRegEstbPec;

    public void setCodigoCertificadoFitoExpo(String codigoCertificadoFitoExpo) {
        this.codigoCertificadoFitoExpo = codigoCertificadoFitoExpo;
    }

    public String getCodigoCertificadoFitoExpo() {
        return codigoCertificadoFitoExpo;
    }

    public void setSolicitante(Persona solicitante) {
        this.solicitante = solicitante;
    }

    public Persona getSolicitante() {
        return solicitante;
    }

    public void setRepLegal(Persona repLegal) {
        this.repLegal = repLegal;
    }

    public Persona getRepLegal() {
        return repLegal;
    }

    public void setAgente(Persona agente) {
        this.agente = agente;
    }

    public Persona getAgente() {
        return agente;
    }

    public void setCodPaisImportador(String codPaisImportador) {
        this.codPaisImportador = codPaisImportador;
    }

    public String getCodPaisImportador() {
        return codPaisImportador;
    }

    public void setDesPaisImportador(String desPaisImportador) {
        this.desPaisImportador = desPaisImportador;
    }

    public String getDesPaisImportador() {
        return desPaisImportador;
    }

    public void setCodImportador(String codImportador) {
        this.codImportador = codImportador;
    }

    public String getCodImportador() {
        return codImportador;
    }

    public void setNombImportador(String nombImportador) {
        this.nombImportador = nombImportador;
    }

    public String getNombImportador() {
        return nombImportador;
    }

    public void setDirecImportador(String direcImportador) {
        this.direcImportador = direcImportador;
    }

    public String getDirecImportador() {
        return direcImportador;
    }

    public void setCodPaisDestino(String codPaisDestino) {
        this.codPaisDestino = codPaisDestino;
    }

    public String getCodPaisDestino() {
        return codPaisDestino;
    }

    public void setDescPaisDestino(String descPaisDestino) {
        this.descPaisDestino = descPaisDestino;
    }

    public String getDescPaisDestino() {
        return descPaisDestino;
    }

    public void setCodPtoIngreso(String codPtoIngreso) {
        this.codPtoIngreso = codPtoIngreso;
    }

    public String getCodPtoIngreso() {
        return codPtoIngreso;
    }

    public void setDescPtoIngreso(String descPtoIngreso) {
        this.descPtoIngreso = descPtoIngreso;
    }

    public String getDescPtoIngreso() {
        return descPtoIngreso;
    }

    public void setCodPtoSalida(String codPtoSalida) {
        this.codPtoSalida = codPtoSalida;
    }

    public String getCodPtoSalida() {
        return codPtoSalida;
    }

    public void setDescPtoSalida(String descPtoSalida) {
        this.descPtoSalida = descPtoSalida;
    }

    public String getDescPtoSalida() {
        return descPtoSalida;
    }

    public void setCodMedioTransporte(String codMedioTransporte) {
        this.codMedioTransporte = codMedioTransporte;
    }

    public String getCodMedioTransporte() {
        return codMedioTransporte;
    }

    public void setDesMedioTransporte(String desMedioTransporte) {
        this.desMedioTransporte = desMedioTransporte;
    }

    public String getDesMedioTransporte() {
        return desMedioTransporte;
    }

    public void setFechaEmbarque(Date fechaEmbarque) {
        this.fechaEmbarque = fechaEmbarque;
    }

    public Date getFechaEmbarque() {
        return fechaEmbarque;
    }

    public void setFechaDesembarque(Date fechaDesembarque) {
        this.fechaDesembarque = fechaDesembarque;
    }

    public Date getFechaDesembarque() {
        return fechaDesembarque;
    }

    public void setCodUsodestino(String codUsodestino) {
        this.codUsodestino = codUsodestino;
    }

    public String getCodUsodestino() {
        return codUsodestino;
    }

    public void setDesUsoDestino(String desUsoDestino) {
        this.desUsoDestino = desUsoDestino;
    }

    public String getDesUsoDestino() {
        return desUsoDestino;
    }

    public void setCodDirecEjecutiva(String codDirecEjecutiva) {
        this.codDirecEjecutiva = codDirecEjecutiva;
    }

    public String getCodDirecEjecutiva() {
        return codDirecEjecutiva;
    }

    public void setDesDirecEjecutiva(String desDirecEjecutiva) {
        this.desDirecEjecutiva = desDirecEjecutiva;
    }

    public String getDesDirecEjecutiva() {
        return desDirecEjecutiva;
    }

    public void setTipoModificacion(String tipoModificacion) {
        this.tipoModificacion = tipoModificacion;
    }

    public String getTipoModificacion() {
        return tipoModificacion;
    }

    public void setNumDocResolutivo(String numDocResolutivo) {
        this.numDocResolutivo = numDocResolutivo;
    }

    public String getNumDocResolutivo() {
        return numDocResolutivo;
    }

    public void setNumCertModificar(String numCertModificar) {
        this.numCertModificar = numCertModificar;
    }

    public String getNumCertModificar() {
        return numCertModificar;
    }



    public void setRucLugarInspeccion(String rucLugarInspeccion) {
        this.rucLugarInspeccion = rucLugarInspeccion;
    }

    public String getRucLugarInspeccion() {
        return rucLugarInspeccion;
    }

    public void setTipoDocLugInspeccion(String tipoDocLugInspeccion) {
        this.tipoDocLugInspeccion = tipoDocLugInspeccion;
    }

    public String getTipoDocLugInspeccion() {
        return tipoDocLugInspeccion;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTpUbEnvio(String tpUbEnvio) {
        this.tpUbEnvio = tpUbEnvio;
    }

    public String getTpUbEnvio() {
        return tpUbEnvio;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setNombPlanta(String nombPlanta) {
        this.nombPlanta = nombPlanta;
    }

    public String getNombPlanta() {
        return nombPlanta;
    }

    public void setDireccPlanta(String direccPlanta) {
        this.direccPlanta = direccPlanta;
    }

    public String getDireccPlanta() {
        return direccPlanta;
    }

    public void setFechaInspeccion(Date fechaInspeccion) {
        this.fechaInspeccion = fechaInspeccion;
    }

    public Date getFechaInspeccion() {
        return fechaInspeccion;
    }

    public void setHoraInspeccion(Date horaInspeccion) {
        this.horaInspeccion = horaInspeccion;
    }

    public Date getHoraInspeccion() {
        return horaInspeccion;
    }

    public void setIsTratCuarentenario(Boolean isTratCuarentenario) {
        this.isTratCuarentenario = isTratCuarentenario;
    }

    public Boolean getIsTratCuarentenario() {
        return isTratCuarentenario;
    }

    public void setTipoTratCuarentenario(String tipoTratCuarentenario) {
        this.tipoTratCuarentenario = tipoTratCuarentenario;
    }

    public String getTipoTratCuarentenario() {
        return tipoTratCuarentenario;
    }

    public void setDestipoTratCuarentenario(String destipoTratCuarentenario) {
        this.destipoTratCuarentenario = destipoTratCuarentenario;
    }

    public String getDestipoTratCuarentenario() {
        return destipoTratCuarentenario;
    }

    public void setRucLugarInspeccionFinal(String rucLugarInspeccionFinal) {
        this.rucLugarInspeccionFinal = rucLugarInspeccionFinal;
    }

    public String getRucLugarInspeccionFinal() {
        return rucLugarInspeccionFinal;
    }

    public void setTipoDocLugInspeccionFinal(String tipoDocLugInspeccionFinal) {
        this.tipoDocLugInspeccionFinal = tipoDocLugInspeccionFinal;
    }

    public String getTipoDocLugInspeccionFinal() {
        return tipoDocLugInspeccionFinal;
    }

    public void setTpUbEnvioFinal(String tpUbEnvioFinal) {
        this.tpUbEnvioFinal = tpUbEnvioFinal;
    }

    public String getTpUbEnvioFinal() {
        return tpUbEnvioFinal;
    }

    public void setCertificadoFinal(String certificadoFinal) {
        this.certificadoFinal = certificadoFinal;
    }

    public String getCertificadoFinal() {
        return certificadoFinal;
    }

    public void setNombPlantaFinal(String nombPlantaFinal) {
        this.nombPlantaFinal = nombPlantaFinal;
    }

    public String getNombPlantaFinal() {
        return nombPlantaFinal;
    }

    public void setDireccPlantaFinal(String direccPlantaFinal) {
        this.direccPlantaFinal = direccPlantaFinal;
    }

    public String getDireccPlantaFinal() {
        return direccPlantaFinal;
    }

    public void setProductos(ProductosIIV productos) {
        this.productos = productos;
    }

    public ProductosIIV getProductos() {
        return productos;
    }

    public void setCodLugInspeccion(String codLugInspeccion) {
        this.codLugInspeccion = codLugInspeccion;
    }

    public String getCodLugInspeccion() {
        return codLugInspeccion;
    }

    public void setDesLugInspeccion(String desLugInspeccion) {
        this.desLugInspeccion = desLugInspeccion;
    }

    public String getDesLugInspeccion() {
        return desLugInspeccion;
    }

    public void setNroRegEstbExp(String nroRegEstbExp) {
        this.nroRegEstbExp = nroRegEstbExp;
    }

    public String getNroRegEstbExp() {
        return nroRegEstbExp;
    }

    public void setNroRegEstbPec(String nroRegEstbPec) {
        this.nroRegEstbPec = nroRegEstbPec;
    }

    public String getNroRegEstbPec() {
        return nroRegEstbPec;
    }
}
