
package proxy.senasaws.tramite;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for exportacionZooSanitaria complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportacionZooSanitaria">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="anexosCEZ" type="{http://tramitedocumentario.ws.senasa.gob.pe}anexoPZI" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="codigoImportador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="direccionEjecutiva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="direccionImportador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaEmbarque" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechaEmision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaInspeccion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechasDesembarque" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="horaInspeccion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="lugarInspeccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lugarUbicacionEnvio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="medioTransporte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noCertificado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noFolio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreImportador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="observacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paisDestino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paisOrigen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productosCEZ" type="{http://tramitedocumentario.ws.senasa.gob.pe}productoPZI" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="puntoLlegada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="puntoSalida" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="solicitante" type="{http://tramitedocumentario.ws.senasa.gob.pe}solicitante" minOccurs="0"/>
 *         &lt;element name="urlCEZDefinitivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usoDestino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportacionZooSanitaria", propOrder = {
    "anexosCEZ",
    "codigoImportador",
    "direccionEjecutiva",
    "direccionImportador",
    "fechaEmbarque",
    "fechaEmision",
    "fechaInspeccion",
    "fechasDesembarque",
    "horaInspeccion",
    "lugarInspeccion",
    "lugarUbicacionEnvio",
    "medioTransporte",
    "noCertificado",
    "noFolio",
    "nombreImportador",
    "observacion",
    "paisDestino",
    "paisOrigen",
    "productosCEZ",
    "puntoLlegada",
    "puntoSalida",
    "solicitante",
    "urlCEZDefinitivo",
    "usoDestino",
    "usuario"
})
public class ExportacionZooSanitaria {

    @XmlElement(nillable = true)
    protected List<AnexoPZI> anexosCEZ;
    protected String codigoImportador;
    protected String direccionEjecutiva;
    protected String direccionImportador;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaEmbarque;
    protected String fechaEmision;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaInspeccion;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechasDesembarque;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar horaInspeccion;
    protected String lugarInspeccion;
    protected String lugarUbicacionEnvio;
    protected String medioTransporte;
    protected String noCertificado;
    protected String noFolio;
    protected String nombreImportador;
    protected String observacion;
    protected String paisDestino;
    protected String paisOrigen;
    @XmlElement(nillable = true)
    protected List<ProductoPZI> productosCEZ;
    protected String puntoLlegada;
    protected String puntoSalida;
    protected Solicitante solicitante;
    protected String urlCEZDefinitivo;
    protected String usoDestino;
    protected String usuario;

    /**
     * Gets the value of the anexosCEZ property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the anexosCEZ property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnexosCEZ().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AnexoPZI }
     * 
     * 
     */
    public List<AnexoPZI> getAnexosCEZ() {
        if (anexosCEZ == null) {
            anexosCEZ = new ArrayList<AnexoPZI>();
        }
        return this.anexosCEZ;
    }

    /**
     * Gets the value of the codigoImportador property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoImportador() {
        return codigoImportador;
    }

    /**
     * Sets the value of the codigoImportador property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoImportador(String value) {
        this.codigoImportador = value;
    }

    /**
     * Gets the value of the direccionEjecutiva property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccionEjecutiva() {
        return direccionEjecutiva;
    }

    /**
     * Sets the value of the direccionEjecutiva property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccionEjecutiva(String value) {
        this.direccionEjecutiva = value;
    }

    /**
     * Gets the value of the direccionImportador property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccionImportador() {
        return direccionImportador;
    }

    /**
     * Sets the value of the direccionImportador property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccionImportador(String value) {
        this.direccionImportador = value;
    }

    /**
     * Gets the value of the fechaEmbarque property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaEmbarque() {
        return fechaEmbarque;
    }

    /**
     * Sets the value of the fechaEmbarque property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaEmbarque(XMLGregorianCalendar value) {
        this.fechaEmbarque = value;
    }

    /**
     * Gets the value of the fechaEmision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Sets the value of the fechaEmision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaEmision(String value) {
        this.fechaEmision = value;
    }

    /**
     * Gets the value of the fechaInspeccion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaInspeccion() {
        return fechaInspeccion;
    }

    /**
     * Sets the value of the fechaInspeccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaInspeccion(XMLGregorianCalendar value) {
        this.fechaInspeccion = value;
    }

    /**
     * Gets the value of the fechasDesembarque property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechasDesembarque() {
        return fechasDesembarque;
    }

    /**
     * Sets the value of the fechasDesembarque property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechasDesembarque(XMLGregorianCalendar value) {
        this.fechasDesembarque = value;
    }

    /**
     * Gets the value of the horaInspeccion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getHoraInspeccion() {
        return horaInspeccion;
    }

    /**
     * Sets the value of the horaInspeccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setHoraInspeccion(XMLGregorianCalendar value) {
        this.horaInspeccion = value;
    }

    /**
     * Gets the value of the lugarInspeccion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLugarInspeccion() {
        return lugarInspeccion;
    }

    /**
     * Sets the value of the lugarInspeccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLugarInspeccion(String value) {
        this.lugarInspeccion = value;
    }

    /**
     * Gets the value of the lugarUbicacionEnvio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLugarUbicacionEnvio() {
        return lugarUbicacionEnvio;
    }

    /**
     * Sets the value of the lugarUbicacionEnvio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLugarUbicacionEnvio(String value) {
        this.lugarUbicacionEnvio = value;
    }

    /**
     * Gets the value of the medioTransporte property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedioTransporte() {
        return medioTransporte;
    }

    /**
     * Sets the value of the medioTransporte property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedioTransporte(String value) {
        this.medioTransporte = value;
    }

    /**
     * Gets the value of the noCertificado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoCertificado() {
        return noCertificado;
    }

    /**
     * Sets the value of the noCertificado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoCertificado(String value) {
        this.noCertificado = value;
    }

    /**
     * Gets the value of the noFolio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoFolio() {
        return noFolio;
    }

    /**
     * Sets the value of the noFolio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoFolio(String value) {
        this.noFolio = value;
    }

    /**
     * Gets the value of the nombreImportador property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreImportador() {
        return nombreImportador;
    }

    /**
     * Sets the value of the nombreImportador property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreImportador(String value) {
        this.nombreImportador = value;
    }

    /**
     * Gets the value of the observacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * Sets the value of the observacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservacion(String value) {
        this.observacion = value;
    }

    /**
     * Gets the value of the paisDestino property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaisDestino() {
        return paisDestino;
    }

    /**
     * Sets the value of the paisDestino property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaisDestino(String value) {
        this.paisDestino = value;
    }

    /**
     * Gets the value of the paisOrigen property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaisOrigen() {
        return paisOrigen;
    }

    /**
     * Sets the value of the paisOrigen property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaisOrigen(String value) {
        this.paisOrigen = value;
    }

    /**
     * Gets the value of the productosCEZ property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productosCEZ property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductosCEZ().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductoPZI }
     * 
     * 
     */
    public List<ProductoPZI> getProductosCEZ() {
        if (productosCEZ == null) {
            productosCEZ = new ArrayList<ProductoPZI>();
        }
        return this.productosCEZ;
    }

    /**
     * Gets the value of the puntoLlegada property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPuntoLlegada() {
        return puntoLlegada;
    }

    /**
     * Sets the value of the puntoLlegada property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPuntoLlegada(String value) {
        this.puntoLlegada = value;
    }

    /**
     * Gets the value of the puntoSalida property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPuntoSalida() {
        return puntoSalida;
    }

    /**
     * Sets the value of the puntoSalida property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPuntoSalida(String value) {
        this.puntoSalida = value;
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
     * Gets the value of the urlCEZDefinitivo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlCEZDefinitivo() {
        return urlCEZDefinitivo;
    }

    /**
     * Sets the value of the urlCEZDefinitivo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlCEZDefinitivo(String value) {
        this.urlCEZDefinitivo = value;
    }

    /**
     * Gets the value of the usoDestino property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsoDestino() {
        return usoDestino;
    }

    /**
     * Sets the value of the usoDestino property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsoDestino(String value) {
        this.usoDestino = value;
    }

    /**
     * Gets the value of the usuario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Sets the value of the usuario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuario(String value) {
        this.usuario = value;
    }

}
