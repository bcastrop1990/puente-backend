
package proxy.senasaws.tramite;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for trazabilidad complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="trazabilidad">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="canal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoElemento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoElementoRespuesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcionAsunto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="destinatarioAreaEntidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="destinatarioPersona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="destinatarioSubAreaEntidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="expedienteDefinitivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="expedienteTemp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaHora" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="notas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proceso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proveido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remitenteAreaEntidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remitentePersona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remitenteSubAreaEntidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "trazabilidad", propOrder = {
    "accion",
    "canal",
    "codigoElemento",
    "codigoElementoRespuesta",
    "descripcionAsunto",
    "destinatarioAreaEntidad",
    "destinatarioPersona",
    "destinatarioSubAreaEntidad",
    "estado",
    "expedienteDefinitivo",
    "expedienteTemp",
    "fechaHora",
    "notas",
    "proceso",
    "proveido",
    "remitenteAreaEntidad",
    "remitentePersona",
    "remitenteSubAreaEntidad",
    "urgencia"
})
public class Trazabilidad {

    protected String accion;
    protected String canal;
    protected String codigoElemento;
    protected String codigoElementoRespuesta;
    protected String descripcionAsunto;
    protected String destinatarioAreaEntidad;
    protected String destinatarioPersona;
    protected String destinatarioSubAreaEntidad;
    protected String estado;
    protected String expedienteDefinitivo;
    protected String expedienteTemp;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaHora;
    protected String notas;
    protected String proceso;
    protected String proveido;
    protected String remitenteAreaEntidad;
    protected String remitentePersona;
    protected String remitenteSubAreaEntidad;
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
     * Gets the value of the canal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCanal() {
        return canal;
    }

    /**
     * Sets the value of the canal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCanal(String value) {
        this.canal = value;
    }

    /**
     * Gets the value of the codigoElemento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoElemento() {
        return codigoElemento;
    }

    /**
     * Sets the value of the codigoElemento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoElemento(String value) {
        this.codigoElemento = value;
    }

    /**
     * Gets the value of the codigoElementoRespuesta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoElementoRespuesta() {
        return codigoElementoRespuesta;
    }

    /**
     * Sets the value of the codigoElementoRespuesta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoElementoRespuesta(String value) {
        this.codigoElementoRespuesta = value;
    }

    /**
     * Gets the value of the descripcionAsunto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionAsunto() {
        return descripcionAsunto;
    }

    /**
     * Sets the value of the descripcionAsunto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionAsunto(String value) {
        this.descripcionAsunto = value;
    }

    /**
     * Gets the value of the destinatarioAreaEntidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinatarioAreaEntidad() {
        return destinatarioAreaEntidad;
    }

    /**
     * Sets the value of the destinatarioAreaEntidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinatarioAreaEntidad(String value) {
        this.destinatarioAreaEntidad = value;
    }

    /**
     * Gets the value of the destinatarioPersona property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinatarioPersona() {
        return destinatarioPersona;
    }

    /**
     * Sets the value of the destinatarioPersona property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinatarioPersona(String value) {
        this.destinatarioPersona = value;
    }

    /**
     * Gets the value of the destinatarioSubAreaEntidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinatarioSubAreaEntidad() {
        return destinatarioSubAreaEntidad;
    }

    /**
     * Sets the value of the destinatarioSubAreaEntidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinatarioSubAreaEntidad(String value) {
        this.destinatarioSubAreaEntidad = value;
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
     * Gets the value of the expedienteDefinitivo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpedienteDefinitivo() {
        return expedienteDefinitivo;
    }

    /**
     * Sets the value of the expedienteDefinitivo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpedienteDefinitivo(String value) {
        this.expedienteDefinitivo = value;
    }

    /**
     * Gets the value of the expedienteTemp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpedienteTemp() {
        return expedienteTemp;
    }

    /**
     * Sets the value of the expedienteTemp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpedienteTemp(String value) {
        this.expedienteTemp = value;
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
     * Gets the value of the proceso property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProceso() {
        return proceso;
    }

    /**
     * Sets the value of the proceso property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProceso(String value) {
        this.proceso = value;
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
     * Gets the value of the remitenteAreaEntidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemitenteAreaEntidad() {
        return remitenteAreaEntidad;
    }

    /**
     * Sets the value of the remitenteAreaEntidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemitenteAreaEntidad(String value) {
        this.remitenteAreaEntidad = value;
    }

    /**
     * Gets the value of the remitentePersona property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemitentePersona() {
        return remitentePersona;
    }

    /**
     * Sets the value of the remitentePersona property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemitentePersona(String value) {
        this.remitentePersona = value;
    }

    /**
     * Gets the value of the remitenteSubAreaEntidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemitenteSubAreaEntidad() {
        return remitenteSubAreaEntidad;
    }

    /**
     * Sets the value of the remitenteSubAreaEntidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemitenteSubAreaEntidad(String value) {
        this.remitenteSubAreaEntidad = value;
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
