package pe.gob.senasa.bean;

import java.util.ArrayList;

import pe.gob.senasa.dao.RequisitoDao;


public class Documento {
  
  String subtipo = "";
  
  Solicitante solicitante = new Solicitante();
  AgenteAduanas agencia = new AgenteAduanas();
  Area direccionEjecutiva = new Area();
  ReciboPago recibo = new ReciboPago();
  ServicioTUPA servicioTupa;
  
  ArrayList<String> listaFirmantes = new ArrayList<String>();
  private boolean encargatura = false;
  private boolean sinFirma = false;
  private boolean previsualizar = false;
  
  String  codigoCentroTramite;
  String  codigoServicio;
  String ucmId;
  String estado;
  
  PermisoFitosanitarioImportacion pfi = new PermisoFitosanitarioImportacion();
  PermisoZoosanitarioImportacion pzi = new PermisoZoosanitarioImportacion();
  AnexoPFI apfi = new AnexoPFI();
  ExportacionZooSanitaria cez = new ExportacionZooSanitaria();
  RegistroCPE cpe = new RegistroCPE();

  ArrayList<RequisitoDao> requisitosSanitarios = new ArrayList<RequisitoDao>();

  ArrayList<Propiedad> metadatos = new ArrayList<Propiedad>();
  
  Memorandum memorandum = new Memorandum();
  
  private boolean ampliacion= false;
  
  private boolean modificacion = false;
  
  ArrayList<ReciboServicio> serviciosTUPARecibo = new  ArrayList<ReciboServicio>();
      
      /**
     * @param subtipo
     */
    public void setSubtipo(String subtipo) {
        this.subtipo = subtipo;
    }

    public String getSubtipo() {
        return subtipo;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setAgencia(AgenteAduanas agencia) {
        this.agencia = agencia;
    }

    public AgenteAduanas getAgencia() {
        return agencia;
    }

    public void setDireccionEjecutiva(Area direccionEjecutiva) {
        this.direccionEjecutiva = direccionEjecutiva;
    }

    public Area getDireccionEjecutiva() {
        return direccionEjecutiva;
    }

    public void setPfi(PermisoFitosanitarioImportacion pfi) {
        this.pfi = pfi;
    }

    public PermisoFitosanitarioImportacion getPfi() {
        return pfi;
    }

    public void setPzi(PermisoZoosanitarioImportacion pzi) {
        this.pzi = pzi;
    }

    public PermisoZoosanitarioImportacion getPzi() {
        return pzi;
    }

    public void setApfi(AnexoPFI apfi) {
        this.apfi = apfi;
    }

    public AnexoPFI getApfi() {
        return apfi;
    }

    public void setCez(ExportacionZooSanitaria cez) {
        this.cez = cez;
    }

    public ExportacionZooSanitaria getCez() {
        return cez;
    }

    public void setCpe(RegistroCPE cpe) {
        this.cpe = cpe;
    }

    public RegistroCPE getCpe() {
        return cpe;
    }

    public void setReciboPago(ReciboPago recibo) {
        this.recibo = recibo;
    }

    public ReciboPago getReciboPago() {
        return recibo;
    }

    public void setServicioTupa(ServicioTUPA servicioTupa) {
        this.servicioTupa = servicioTupa;
    }

    public ServicioTUPA getServicioTupa() {
        return servicioTupa;
    }

    public void setRequisitosSanitarios(ArrayList<RequisitoDao> requisitosSanitarios) {
        this.requisitosSanitarios = requisitosSanitarios;
    }

    public ArrayList<RequisitoDao> getRequisitosSanitarios() {
        return requisitosSanitarios;
    }


    public void setMetadatos(ArrayList<Propiedad> metadatos) {
        this.metadatos = metadatos;
    }

    public ArrayList<Propiedad> getMetadatos() {
        return metadatos;
    }

    public void setMemorandum(Memorandum memorandum) {
        this.memorandum = memorandum;
    }

    public Memorandum getMemorandum() {
        return memorandum;
    }

    public void setAmpliacion(boolean ampliacion) {
        this.ampliacion = ampliacion;
    }

    public boolean isAmpliacion()
    {
        return ampliacion;
    }

    public void setModificacion(boolean modificacion) {
        this.modificacion = modificacion;
    }

    public boolean isModificacion() {
        return modificacion;
    }

    public void setListaFirmantes(ArrayList<String> listaFirmantes) {
        this.listaFirmantes = listaFirmantes;
    }

    public ArrayList<String> getListaFirmantes() {
        return listaFirmantes;
    }

    public void setCodigoCentroTramite(String codigoCentroTramite) {
        this.codigoCentroTramite = codigoCentroTramite;
    }

    public String getCodigoCentroTramite() {
        return codigoCentroTramite;
    }

    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getCodigoServicio() {
        return codigoServicio;
    }
   //--------------------------------- 
  public void setServiciosTUPARecibo(ArrayList<ReciboServicio> serviciosTUPARecibo) {
      this.serviciosTUPARecibo = serviciosTUPARecibo;
  }

  public ArrayList<ReciboServicio> getServiciosTUPARecibo() {
      return serviciosTUPARecibo;
  }

	public void setEncargatura(boolean encargatura) {
		this.encargatura = encargatura;
	}

	public boolean isEncargatura() {
		return encargatura;
	}

	public void setSinFirma(boolean sinFirma) {
		this.sinFirma = sinFirma;
	}

	public boolean isSinFirma() {
		return sinFirma;
	}
  
  public boolean isConFirma() {
    return !sinFirma;
  }

	public void setPrevisualizar(boolean previsualizar) {
		this.previsualizar = previsualizar;
	}

	public boolean isPrevisualizar() {
		return previsualizar;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setUcmId(String ucmId) {
		this.ucmId = ucmId;
	}

	public String getUcmId() {
		return ucmId;
	}
}
