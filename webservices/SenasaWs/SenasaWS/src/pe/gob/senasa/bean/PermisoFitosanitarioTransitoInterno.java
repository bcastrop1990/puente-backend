package pe.gob.senasa.bean;

import java.util.ArrayList;

import pe.gob.senasa.dao.RequisitoDao;


public class PermisoFitosanitarioTransitoInterno {
   
   private String nroDocumento;
   private String numeroExpediente;
   private String fechaEmision;
   private String lugarEmision;
   private String fechaVigencia;
   private String indicadorAmpliacion;
   private String nombreSolicitante;
   private String dmclLegalSolicitante;
   private ArrayList<ProductoPFI> productosPFI;
   private ArrayList<LugarProduccionProductoPFI> lugaresProduccionProductoPFI;
   private ArrayList<PaisOrigenProductoPFI> paisesOrigenProductoPFI;
   private ArrayList<PuntoIngresoProductoPFI> puntoIngresoProductoPFI;
  private ArrayList<Solicitante> solicitante;
   private ArrayList<AnexoPFI> anexosPFI = new ArrayList<AnexoPFI>();
   private ArrayList<RequisitoDao> listaRequisitos;
   
   private String nombreDepartamento;
   private String nombreProvincia;
   private String nombreDistrito;
   private String documentoSolicitante;
   private String codigoSede;
   private String codigoRequImpoProducto;
   //private Solicitante solicitante;
  
    public PermisoFitosanitarioTransitoInterno() {
        super();
    }

    
    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNumeroExpediente(String numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public String getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaVigencia(String fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public String getFechaVigencia() {
        return fechaVigencia;
    }

    public void setNombreSolicitante(String nombreSolicitante) {
        this.nombreSolicitante = nombreSolicitante;
    }

    public String getNombreSolicitante() {
        return nombreSolicitante;
    }

    public void setDmclLegalSolicitante(String dmclLegalSolicitante) {
        this.dmclLegalSolicitante = dmclLegalSolicitante;
    }

    public String getDmclLegalSolicitante() {
        return dmclLegalSolicitante;
    }



    public void setListaRequisitos(ArrayList<RequisitoDao> listaRequisitos) {
        this.listaRequisitos = listaRequisitos;
    }

    public ArrayList<RequisitoDao> getListaRequisitos() {
        return listaRequisitos;
    }

    public void setLugarEmision(String lugarEmision) {
        this.lugarEmision = lugarEmision;
    }

    public String getLugarEmision() {
        return lugarEmision;
    }

    public void setLugaresProduccionProductoPFI(ArrayList<LugarProduccionProductoPFI> lugaresProduccionProductoPFI) {
        this.lugaresProduccionProductoPFI = lugaresProduccionProductoPFI;
    }

    public ArrayList<LugarProduccionProductoPFI> getLugaresProduccionProductoPFI() {
        return lugaresProduccionProductoPFI;
    }

    public void setPaisesOrigenProductoPFI(ArrayList<PaisOrigenProductoPFI> paisesOrigenProductoPFI) {
        this.paisesOrigenProductoPFI = paisesOrigenProductoPFI;
    }

    public ArrayList<PaisOrigenProductoPFI> getPaisesOrigenProductoPFI() {
        return paisesOrigenProductoPFI;
    }

    public void setPuntoIngresoProductoPFI(ArrayList<PuntoIngresoProductoPFI> puntoIngresoProductoPFI) {
        this.puntoIngresoProductoPFI = puntoIngresoProductoPFI;
    }

    public ArrayList<PuntoIngresoProductoPFI> getPuntoIngresoProductoPFI() {
        return puntoIngresoProductoPFI;
    }

    public void setAnexosPFI(ArrayList<AnexoPFI> anexosPFI) {
        this.anexosPFI = anexosPFI;
    }

    public ArrayList<AnexoPFI> getAnexosPFI() {
        return anexosPFI;
    }

    public void setProductosPFI(ArrayList<ProductoPFI> productosPFI) {
        this.productosPFI = productosPFI;
    }

    public ArrayList<ProductoPFI> getProductosPFI() {
        return productosPFI;
    }

    public void setIndicadorAmpliacion(String indicadorAmpliacion) {
        this.indicadorAmpliacion = indicadorAmpliacion;
    }

    public String getIndicadorAmpliacion() {
        return indicadorAmpliacion;
    }
    
  public void setNombreDepartamento(String nombreDepartamento) {
      this.nombreDepartamento = nombreDepartamento;
  }

  public String getNombreDepartamento() {
      return nombreDepartamento;
  }
  
  public void setNombreProvincia(String nombreProvincia) {
      this.nombreProvincia = nombreProvincia;
  }

  public String getNombreProvincia() {
      return nombreProvincia;
  }
  
  public void setNombreDistrito(String nombreDistrito) {
      this.nombreDistrito = nombreDistrito;
  }

  public String getNombreDistrito() {
      return nombreProvincia;
  }


    public void setDocumentoSolicitante(String documentoSolicitante) {
        this.documentoSolicitante = documentoSolicitante;
    }

    public String getDocumentoSolicitante() {
        return documentoSolicitante;
    }

    public void setCodigoSede(String codigoSede) {
        this.codigoSede = codigoSede;
    }

    public String getCodigoSede() {
        return codigoSede;
    }

    public void setCodigoRequImpoProducto(String codigoRequImpoProducto) {
        this.codigoRequImpoProducto = codigoRequImpoProducto;
    }

    public String getCodigoRequImpoProducto() {
        return codigoRequImpoProducto;
    }

    public void setSolicitante(ArrayList<Solicitante> solicitante) {
        this.solicitante = solicitante;
    }

    public ArrayList<Solicitante> getSolicitante() {
        return solicitante;
    }
}
