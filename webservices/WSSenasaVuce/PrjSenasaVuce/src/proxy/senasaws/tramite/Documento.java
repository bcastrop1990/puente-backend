
package proxy.senasaws.tramite;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for documento complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="documento">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="agencia" type="{http://tramitedocumentario.ws.senasa.gob.pe}agenteAduanas" minOccurs="0"/>
 *         &lt;element name="ampliacion" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="apfi" type="{http://tramitedocumentario.ws.senasa.gob.pe}anexoPFI" minOccurs="0"/>
 *         &lt;element name="cez" type="{http://tramitedocumentario.ws.senasa.gob.pe}exportacionZooSanitaria" minOccurs="0"/>
 *         &lt;element name="codigoCentroTramite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoServicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cpe" type="{http://tramitedocumentario.ws.senasa.gob.pe}registroCPE" minOccurs="0"/>
 *         &lt;element name="direccionEjecutiva" type="{http://tramitedocumentario.ws.senasa.gob.pe}area" minOccurs="0"/>
 *         &lt;element name="encargatura" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="listaFirmantes" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="memorandum" type="{http://tramitedocumentario.ws.senasa.gob.pe}memorandum" minOccurs="0"/>
 *         &lt;element name="metadatos" type="{http://tramitedocumentario.ws.senasa.gob.pe}propiedad" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="modificacion" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="pfi" type="{http://tramitedocumentario.ws.senasa.gob.pe}permisoFitosanitarioImportacion" minOccurs="0"/>
 *         &lt;element name="previsualizar" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="pzi" type="{http://tramitedocumentario.ws.senasa.gob.pe}permisoZoosanitarioImportacion" minOccurs="0"/>
 *         &lt;element name="reciboPago" type="{http://tramitedocumentario.ws.senasa.gob.pe}reciboPago" minOccurs="0"/>
 *         &lt;element name="requisitosSanitarios" type="{http://tramitedocumentario.ws.senasa.gob.pe}requisitoDao" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="servicioTupa" type="{http://tramitedocumentario.ws.senasa.gob.pe}servicioTUPA" minOccurs="0"/>
 *         &lt;element name="serviciosTUPARecibo" type="{http://tramitedocumentario.ws.senasa.gob.pe}reciboServicio" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sinFirma" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="solicitante" type="{http://tramitedocumentario.ws.senasa.gob.pe}solicitante" minOccurs="0"/>
 *         &lt;element name="subtipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ucmId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "documento", propOrder = {
    "agencia",
    "ampliacion",
    "apfi",
    "cez",
    "codigoCentroTramite",
    "codigoServicio",
    "cpe",
    "direccionEjecutiva",
    "encargatura",
    "estado",
    "listaFirmantes",
    "memorandum",
    "metadatos",
    "modificacion",
    "pfi",
    "previsualizar",
    "pzi",
    "reciboPago",
    "requisitosSanitarios",
    "servicioTupa",
    "serviciosTUPARecibo",
    "sinFirma",
    "solicitante",
    "subtipo",
    "ucmId"
})
public class Documento {

    protected AgenteAduanas agencia;
    protected boolean ampliacion;
    protected AnexoPFI apfi;
    protected ExportacionZooSanitaria cez;
    protected String codigoCentroTramite;
    protected String codigoServicio;
    protected RegistroCPE cpe;
    protected Area direccionEjecutiva;
    protected boolean encargatura;
    protected String estado;
    @XmlElement(nillable = true)
    protected List<String> listaFirmantes;
    protected Memorandum memorandum;
    @XmlElement(nillable = true)
    protected List<Propiedad> metadatos;
    protected boolean modificacion;
    protected PermisoFitosanitarioImportacion pfi;
    protected boolean previsualizar;
    protected PermisoZoosanitarioImportacion pzi;
    protected ReciboPago reciboPago;
    @XmlElement(nillable = true)
    protected List<RequisitoDao> requisitosSanitarios;
    protected ServicioTUPA servicioTupa;
    @XmlElement(nillable = true)
    protected List<ReciboServicio> serviciosTUPARecibo;
    protected boolean sinFirma;
    protected Solicitante solicitante;
    protected String subtipo;
    protected String ucmId;

    /**
     * Gets the value of the agencia property.
     * 
     * @return
     *     possible object is
     *     {@link AgenteAduanas }
     *     
     */
    public AgenteAduanas getAgencia() {
        return agencia;
    }

    /**
     * Sets the value of the agencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link AgenteAduanas }
     *     
     */
    public void setAgencia(AgenteAduanas value) {
        this.agencia = value;
    }

    /**
     * Gets the value of the ampliacion property.
     * 
     */
    public boolean isAmpliacion() {
        return ampliacion;
    }

    /**
     * Sets the value of the ampliacion property.
     * 
     */
    public void setAmpliacion(boolean value) {
        this.ampliacion = value;
    }

    /**
     * Gets the value of the apfi property.
     * 
     * @return
     *     possible object is
     *     {@link AnexoPFI }
     *     
     */
    public AnexoPFI getApfi() {
        return apfi;
    }

    /**
     * Sets the value of the apfi property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnexoPFI }
     *     
     */
    public void setApfi(AnexoPFI value) {
        this.apfi = value;
    }

    /**
     * Gets the value of the cez property.
     * 
     * @return
     *     possible object is
     *     {@link ExportacionZooSanitaria }
     *     
     */
    public ExportacionZooSanitaria getCez() {
        return cez;
    }

    /**
     * Sets the value of the cez property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportacionZooSanitaria }
     *     
     */
    public void setCez(ExportacionZooSanitaria value) {
        this.cez = value;
    }

    /**
     * Gets the value of the codigoCentroTramite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoCentroTramite() {
        return codigoCentroTramite;
    }

    /**
     * Sets the value of the codigoCentroTramite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoCentroTramite(String value) {
        this.codigoCentroTramite = value;
    }

    /**
     * Gets the value of the codigoServicio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoServicio() {
        return codigoServicio;
    }

    /**
     * Sets the value of the codigoServicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoServicio(String value) {
        this.codigoServicio = value;
    }

    /**
     * Gets the value of the cpe property.
     * 
     * @return
     *     possible object is
     *     {@link RegistroCPE }
     *     
     */
    public RegistroCPE getCpe() {
        return cpe;
    }

    /**
     * Sets the value of the cpe property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistroCPE }
     *     
     */
    public void setCpe(RegistroCPE value) {
        this.cpe = value;
    }

    /**
     * Gets the value of the direccionEjecutiva property.
     * 
     * @return
     *     possible object is
     *     {@link Area }
     *     
     */
    public Area getDireccionEjecutiva() {
        return direccionEjecutiva;
    }

    /**
     * Sets the value of the direccionEjecutiva property.
     * 
     * @param value
     *     allowed object is
     *     {@link Area }
     *     
     */
    public void setDireccionEjecutiva(Area value) {
        this.direccionEjecutiva = value;
    }

    /**
     * Gets the value of the encargatura property.
     * 
     */
    public boolean isEncargatura() {
        return encargatura;
    }

    /**
     * Sets the value of the encargatura property.
     * 
     */
    public void setEncargatura(boolean value) {
        this.encargatura = value;
    }

    /**
     * Gets the value of the estado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Sets the value of the estado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Gets the value of the listaFirmantes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaFirmantes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaFirmantes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getListaFirmantes() {
        if (listaFirmantes == null) {
            listaFirmantes = new ArrayList<String>();
        }
        return this.listaFirmantes;
    }

    /**
     * Gets the value of the memorandum property.
     * 
     * @return
     *     possible object is
     *     {@link Memorandum }
     *     
     */
    public Memorandum getMemorandum() {
        return memorandum;
    }

    /**
     * Sets the value of the memorandum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Memorandum }
     *     
     */
    public void setMemorandum(Memorandum value) {
        this.memorandum = value;
    }

    /**
     * Gets the value of the metadatos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the metadatos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMetadatos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Propiedad }
     * 
     * 
     */
    public List<Propiedad> getMetadatos() {
        if (metadatos == null) {
            metadatos = new ArrayList<Propiedad>();
        }
        return this.metadatos;
    }

    /**
     * Gets the value of the modificacion property.
     * 
     */
    public boolean isModificacion() {
        return modificacion;
    }

    /**
     * Sets the value of the modificacion property.
     * 
     */
    public void setModificacion(boolean value) {
        this.modificacion = value;
    }

    /**
     * Gets the value of the pfi property.
     * 
     * @return
     *     possible object is
     *     {@link PermisoFitosanitarioImportacion }
     *     
     */
    public PermisoFitosanitarioImportacion getPfi() {
        return pfi;
    }

    /**
     * Sets the value of the pfi property.
     * 
     * @param value
     *     allowed object is
     *     {@link PermisoFitosanitarioImportacion }
     *     
     */
    public void setPfi(PermisoFitosanitarioImportacion value) {
        this.pfi = value;
    }

    /**
     * Gets the value of the previsualizar property.
     * 
     */
    public boolean isPrevisualizar() {
        return previsualizar;
    }

    /**
     * Sets the value of the previsualizar property.
     * 
     */
    public void setPrevisualizar(boolean value) {
        this.previsualizar = value;
    }

    /**
     * Gets the value of the pzi property.
     * 
     * @return
     *     possible object is
     *     {@link PermisoZoosanitarioImportacion }
     *     
     */
    public PermisoZoosanitarioImportacion getPzi() {
        return pzi;
    }

    /**
     * Sets the value of the pzi property.
     * 
     * @param value
     *     allowed object is
     *     {@link PermisoZoosanitarioImportacion }
     *     
     */
    public void setPzi(PermisoZoosanitarioImportacion value) {
        this.pzi = value;
    }

    /**
     * Gets the value of the reciboPago property.
     * 
     * @return
     *     possible object is
     *     {@link ReciboPago }
     *     
     */
    public ReciboPago getReciboPago() {
        return reciboPago;
    }

    /**
     * Sets the value of the reciboPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReciboPago }
     *     
     */
    public void setReciboPago(ReciboPago value) {
        this.reciboPago = value;
    }

    /**
     * Gets the value of the requisitosSanitarios property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requisitosSanitarios property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequisitosSanitarios().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RequisitoDao }
     * 
     * 
     */
    public List<RequisitoDao> getRequisitosSanitarios() {
        if (requisitosSanitarios == null) {
            requisitosSanitarios = new ArrayList<RequisitoDao>();
        }
        return this.requisitosSanitarios;
    }

    /**
     * Gets the value of the servicioTupa property.
     * 
     * @return
     *     possible object is
     *     {@link ServicioTUPA }
     *     
     */
    public ServicioTUPA getServicioTupa() {
        return servicioTupa;
    }

    /**
     * Sets the value of the servicioTupa property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServicioTUPA }
     *     
     */
    public void setServicioTupa(ServicioTUPA value) {
        this.servicioTupa = value;
    }

    /**
     * Gets the value of the serviciosTUPARecibo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviciosTUPARecibo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiciosTUPARecibo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReciboServicio }
     * 
     * 
     */
    public List<ReciboServicio> getServiciosTUPARecibo() {
        if (serviciosTUPARecibo == null) {
            serviciosTUPARecibo = new ArrayList<ReciboServicio>();
        }
        return this.serviciosTUPARecibo;
    }

    /**
     * Gets the value of the sinFirma property.
     * 
     */
    public boolean isSinFirma() {
        return sinFirma;
    }

    /**
     * Sets the value of the sinFirma property.
     * 
     */
    public void setSinFirma(boolean value) {
        this.sinFirma = value;
    }

    /**
     * Gets the value of the solicitante property.
     * 
     * @return
     *     possible object is
     *     {@link Solicitante }
     *     
     */
    public Solicitante getSolicitante() {
        return solicitante;
    }

    /**
     * Sets the value of the solicitante property.
     * 
     * @param value
     *     allowed object is
     *     {@link Solicitante }
     *     
     */
    public void setSolicitante(Solicitante value) {
        this.solicitante = value;
    }

    /**
     * Gets the value of the subtipo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubtipo() {
        return subtipo;
    }

    /**
     * Sets the value of the subtipo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubtipo(String value) {
        this.subtipo = value;
    }

    /**
     * Gets the value of the ucmId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUcmId() {
        return ucmId;
    }

    /**
     * Sets the value of the ucmId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUcmId(String value) {
        this.ucmId = value;
    }

}
