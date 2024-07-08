
package proxy.senasaws.tramite;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for servicioTUPA complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="servicioTUPA">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codServicioTupa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoCentroTramite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoClase" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoExpediente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoSolicitud" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcionCentroTramite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flagImpoExpo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="indicadorCobroPorProducto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreServicioTupa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plazo" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="valorServicioTupa" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "servicioTUPA", propOrder = {
    "codServicioTupa",
    "codigoCentroTramite",
    "codigoClase",
    "codigoExpediente",
    "codigoSolicitud",
    "descripcionCentroTramite",
    "estado",
    "flagImpoExpo",
    "indicadorCobroPorProducto",
    "nombreServicioTupa",
    "plazo",
    "valorServicioTupa"
})
public class ServicioTUPA {

    protected String codServicioTupa;
    protected String codigoCentroTramite;
    protected String codigoClase;
    protected String codigoExpediente;
    protected String codigoSolicitud;
    protected String descripcionCentroTramite;
    protected String estado;
    protected String flagImpoExpo;
    protected String indicadorCobroPorProducto;
    protected String nombreServicioTupa;
    protected float plazo;
    protected float valorServicioTupa;

    /**
     * Gets the value of the codServicioTupa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodServicioTupa() {
        return codServicioTupa;
    }

    /**
     * Sets the value of the codServicioTupa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodServicioTupa(String value) {
        this.codServicioTupa = value;
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
     * Gets the value of the codigoClase property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoClase() {
        return codigoClase;
    }

    /**
     * Sets the value of the codigoClase property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoClase(String value) {
        this.codigoClase = value;
    }

    /**
     * Gets the value of the codigoExpediente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoExpediente() {
        return codigoExpediente;
    }

    /**
     * Sets the value of the codigoExpediente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoExpediente(String value) {
        this.codigoExpediente = value;
    }

    /**
     * Gets the value of the codigoSolicitud property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoSolicitud() {
        return codigoSolicitud;
    }

    /**
     * Sets the value of the codigoSolicitud property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoSolicitud(String value) {
        this.codigoSolicitud = value;
    }

    /**
     * Gets the value of the descripcionCentroTramite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionCentroTramite() {
        return descripcionCentroTramite;
    }

    /**
     * Sets the value of the descripcionCentroTramite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionCentroTramite(String value) {
        this.descripcionCentroTramite = value;
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
     * Gets the value of the flagImpoExpo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagImpoExpo() {
        return flagImpoExpo;
    }

    /**
     * Sets the value of the flagImpoExpo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagImpoExpo(String value) {
        this.flagImpoExpo = value;
    }

    /**
     * Gets the value of the indicadorCobroPorProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicadorCobroPorProducto() {
        return indicadorCobroPorProducto;
    }

    /**
     * Sets the value of the indicadorCobroPorProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicadorCobroPorProducto(String value) {
        this.indicadorCobroPorProducto = value;
    }

    /**
     * Gets the value of the nombreServicioTupa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreServicioTupa() {
        return nombreServicioTupa;
    }

    /**
     * Sets the value of the nombreServicioTupa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreServicioTupa(String value) {
        this.nombreServicioTupa = value;
    }

    /**
     * Gets the value of the plazo property.
     * 
     */
    public float getPlazo() {
        return plazo;
    }

    /**
     * Sets the value of the plazo property.
     * 
     */
    public void setPlazo(float value) {
        this.plazo = value;
    }

    /**
     * Gets the value of the valorServicioTupa property.
     * 
     */
    public float getValorServicioTupa() {
        return valorServicioTupa;
    }

    /**
     * Sets the value of the valorServicioTupa property.
     * 
     */
    public void setValorServicioTupa(float value) {
        this.valorServicioTupa = value;
    }

}
