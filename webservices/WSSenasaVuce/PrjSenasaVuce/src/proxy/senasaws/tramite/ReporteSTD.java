
package proxy.senasaws.tramite;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for reporteSTD complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="reporteSTD">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="anio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="areaEntidadDest" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="areaEntidadRem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="asunto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codElemento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codElementoRpta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechaHora" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechaRegDesde" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechaRegHasta" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="idAreaEntidadDest" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idAreaEntidadRem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idPersonaDest" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idPersonaRem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idProceso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idSubAreaEntidadDest" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idSubAreaEntidadRem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idSubTipoDocumental" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idTipoDocumental" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idTipoOrigenDestino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="personaDest" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="personaRem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proveido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subAreaEntidadDest" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subAreaEntidadRem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="urgencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reporteSTD", propOrder = {
    "accion",
    "anio",
    "areaEntidadDest",
    "areaEntidadRem",
    "asunto",
    "codElemento",
    "codElementoRpta",
    "estado",
    "fecha",
    "fechaHora",
    "fechaRegDesde",
    "fechaRegHasta",
    "idAreaEntidadDest",
    "idAreaEntidadRem",
    "idPersonaDest",
    "idPersonaRem",
    "idProceso",
    "idSubAreaEntidadDest",
    "idSubAreaEntidadRem",
    "idSubTipoDocumental",
    "idTipoDocumental",
    "idTipoOrigenDestino",
    "notas",
    "numeroDocumento",
    "personaDest",
    "personaRem",
    "proveido",
    "subAreaEntidadDest",
    "subAreaEntidadRem",
    "urgencia"
})
public class ReporteSTD {

    protected String accion;
    protected String anio;
    protected String areaEntidadDest;
    protected String areaEntidadRem;
    protected String asunto;
    protected String codElemento;
    protected String codElementoRpta;
    protected String estado;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaHora;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaRegDesde;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaRegHasta;
    protected String idAreaEntidadDest;
    protected String idAreaEntidadRem;
    protected String idPersonaDest;
    protected String idPersonaRem;
    protected String idProceso;
    protected String idSubAreaEntidadDest;
    protected String idSubAreaEntidadRem;
    protected String idSubTipoDocumental;
    protected String idTipoDocumental;
    protected String idTipoOrigenDestino;
    protected String notas;
    protected String numeroDocumento;
    protected String personaDest;
    protected String personaRem;
    protected String proveido;
    protected String subAreaEntidadDest;
    protected String subAreaEntidadRem;
    protected String urgencia;

    /**
     * Gets the value of the accion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccion() {
        return accion;
    }

    /**
     * Sets the value of the accion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccion(String value) {
        this.accion = value;
    }

    /**
     * Gets the value of the anio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnio() {
        return anio;
    }

    /**
     * Sets the value of the anio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnio(String value) {
        this.anio = value;
    }

    /**
     * Gets the value of the areaEntidadDest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaEntidadDest() {
        return areaEntidadDest;
    }

    /**
     * Sets the value of the areaEntidadDest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaEntidadDest(String value) {
        this.areaEntidadDest = value;
    }

    /**
     * Gets the value of the areaEntidadRem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaEntidadRem() {
        return areaEntidadRem;
    }

    /**
     * Sets the value of the areaEntidadRem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaEntidadRem(String value) {
        this.areaEntidadRem = value;
    }

    /**
     * Gets the value of the asunto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * Sets the value of the asunto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAsunto(String value) {
        this.asunto = value;
    }

    /**
     * Gets the value of the codElemento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodElemento() {
        return codElemento;
    }

    /**
     * Sets the value of the codElemento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodElemento(String value) {
        this.codElemento = value;
    }

    /**
     * Gets the value of the codElementoRpta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodElementoRpta() {
        return codElementoRpta;
    }

    /**
     * Sets the value of the codElementoRpta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodElementoRpta(String value) {
        this.codElementoRpta = value;
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
     * Gets the value of the fecha property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * Sets the value of the fecha property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
    }

    /**
     * Gets the value of the fechaHora property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaHora() {
        return fechaHora;
    }

    /**
     * Sets the value of the fechaHora property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaHora(XMLGregorianCalendar value) {
        this.fechaHora = value;
    }

    /**
     * Gets the value of the fechaRegDesde property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaRegDesde() {
        return fechaRegDesde;
    }

    /**
     * Sets the value of the fechaRegDesde property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaRegDesde(XMLGregorianCalendar value) {
        this.fechaRegDesde = value;
    }

    /**
     * Gets the value of the fechaRegHasta property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaRegHasta() {
        return fechaRegHasta;
    }

    /**
     * Sets the value of the fechaRegHasta property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaRegHasta(XMLGregorianCalendar value) {
        this.fechaRegHasta = value;
    }

    /**
     * Gets the value of the idAreaEntidadDest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdAreaEntidadDest() {
        return idAreaEntidadDest;
    }

    /**
     * Sets the value of the idAreaEntidadDest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdAreaEntidadDest(String value) {
        this.idAreaEntidadDest = value;
    }

    /**
     * Gets the value of the idAreaEntidadRem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdAreaEntidadRem() {
        return idAreaEntidadRem;
    }

    /**
     * Sets the value of the idAreaEntidadRem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdAreaEntidadRem(String value) {
        this.idAreaEntidadRem = value;
    }

    /**
     * Gets the value of the idPersonaDest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPersonaDest() {
        return idPersonaDest;
    }

    /**
     * Sets the value of the idPersonaDest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPersonaDest(String value) {
        this.idPersonaDest = value;
    }

    /**
     * Gets the value of the idPersonaRem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPersonaRem() {
        return idPersonaRem;
    }

    /**
     * Sets the value of the idPersonaRem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPersonaRem(String value) {
        this.idPersonaRem = value;
    }

    /**
     * Gets the value of the idProceso property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdProceso() {
        return idProceso;
    }

    /**
     * Sets the value of the idProceso property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdProceso(String value) {
        this.idProceso = value;
    }

    /**
     * Gets the value of the idSubAreaEntidadDest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdSubAreaEntidadDest() {
        return idSubAreaEntidadDest;
    }

    /**
     * Sets the value of the idSubAreaEntidadDest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdSubAreaEntidadDest(String value) {
        this.idSubAreaEntidadDest = value;
    }

    /**
     * Gets the value of the idSubAreaEntidadRem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdSubAreaEntidadRem() {
        return idSubAreaEntidadRem;
    }

    /**
     * Sets the value of the idSubAreaEntidadRem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdSubAreaEntidadRem(String value) {
        this.idSubAreaEntidadRem = value;
    }

    /**
     * Gets the value of the idSubTipoDocumental property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdSubTipoDocumental() {
        return idSubTipoDocumental;
    }

    /**
     * Sets the value of the idSubTipoDocumental property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdSubTipoDocumental(String value) {
        this.idSubTipoDocumental = value;
    }

    /**
     * Gets the value of the idTipoDocumental property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdTipoDocumental() {
        return idTipoDocumental;
    }

    /**
     * Sets the value of the idTipoDocumental property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdTipoDocumental(String value) {
        this.idTipoDocumental = value;
    }

    /**
     * Gets the value of the idTipoOrigenDestino property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdTipoOrigenDestino() {
        return idTipoOrigenDestino;
    }

    /**
     * Sets the value of the idTipoOrigenDestino property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdTipoOrigenDestino(String value) {
        this.idTipoOrigenDestino = value;
    }

    /**
     * Gets the value of the notas property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotas() {
        return notas;
    }

    /**
     * Sets the value of the notas property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotas(String value) {
        this.notas = value;
    }

    /**
     * Gets the value of the numeroDocumento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * Sets the value of the numeroDocumento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroDocumento(String value) {
        this.numeroDocumento = value;
    }

    /**
     * Gets the value of the personaDest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonaDest() {
        return personaDest;
    }

    /**
     * Sets the value of the personaDest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonaDest(String value) {
        this.personaDest = value;
    }

    /**
     * Gets the value of the personaRem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonaRem() {
        return personaRem;
    }

    /**
     * Sets the value of the personaRem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonaRem(String value) {
        this.personaRem = value;
    }

    /**
     * Gets the value of the proveido property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProveido() {
        return proveido;
    }

    /**
     * Sets the value of the proveido property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProveido(String value) {
        this.proveido = value;
    }

    /**
     * Gets the value of the subAreaEntidadDest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubAreaEntidadDest() {
        return subAreaEntidadDest;
    }

    /**
     * Sets the value of the subAreaEntidadDest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubAreaEntidadDest(String value) {
        this.subAreaEntidadDest = value;
    }

    /**
     * Gets the value of the subAreaEntidadRem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubAreaEntidadRem() {
        return subAreaEntidadRem;
    }

    /**
     * Sets the value of the subAreaEntidadRem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubAreaEntidadRem(String value) {
        this.subAreaEntidadRem = value;
    }

    /**
     * Gets the value of the urgencia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrgencia() {
        return urgencia;
    }

    /**
     * Sets the value of the urgencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrgencia(String value) {
        this.urgencia = value;
    }

}
