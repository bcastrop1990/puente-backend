
package proxy.senasaws.tramite;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for puntoIngresoProductoPFI complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="puntoIngresoProductoPFI">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="codigoProducto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descPuntoIngresoProducto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descPuntoSalidaProducto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcionProducto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreCientificoProducto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partidaArancelariaProducto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pesoNeto" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="puntoIngresoProducto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="puntoSalidaProducto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoEnvaseProducto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "puntoIngresoProductoPFI", propOrder = {
    "cantidad",
    "codigoProducto",
    "descPuntoIngresoProducto",
    "descPuntoSalidaProducto",
    "descripcionProducto",
    "nombreCientificoProducto",
    "partidaArancelariaProducto",
    "pesoNeto",
    "puntoIngresoProducto",
    "puntoSalidaProducto",
    "tipoEnvaseProducto"
})
public class PuntoIngresoProductoPFI {

    protected Double cantidad;
    protected String codigoProducto;
    protected String descPuntoIngresoProducto;
    protected String descPuntoSalidaProducto;
    protected String descripcionProducto;
    protected String nombreCientificoProducto;
    protected String partidaArancelariaProducto;
    protected Double pesoNeto;
    protected String puntoIngresoProducto;
    protected String puntoSalidaProducto;
    protected String tipoEnvaseProducto;

    /**
     * Gets the value of the cantidad property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCantidad() {
        return cantidad;
    }

    /**
     * Sets the value of the cantidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCantidad(Double value) {
        this.cantidad = value;
    }

    /**
     * Gets the value of the codigoProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoProducto() {
        return codigoProducto;
    }

    /**
     * Sets the value of the codigoProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoProducto(String value) {
        this.codigoProducto = value;
    }

    /**
     * Gets the value of the descPuntoIngresoProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescPuntoIngresoProducto() {
        return descPuntoIngresoProducto;
    }

    /**
     * Sets the value of the descPuntoIngresoProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescPuntoIngresoProducto(String value) {
        this.descPuntoIngresoProducto = value;
    }

    /**
     * Gets the value of the descPuntoSalidaProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescPuntoSalidaProducto() {
        return descPuntoSalidaProducto;
    }

    /**
     * Sets the value of the descPuntoSalidaProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescPuntoSalidaProducto(String value) {
        this.descPuntoSalidaProducto = value;
    }

    /**
     * Gets the value of the descripcionProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    /**
     * Sets the value of the descripcionProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionProducto(String value) {
        this.descripcionProducto = value;
    }

    /**
     * Gets the value of the nombreCientificoProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreCientificoProducto() {
        return nombreCientificoProducto;
    }

    /**
     * Sets the value of the nombreCientificoProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreCientificoProducto(String value) {
        this.nombreCientificoProducto = value;
    }

    /**
     * Gets the value of the partidaArancelariaProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartidaArancelariaProducto() {
        return partidaArancelariaProducto;
    }

    /**
     * Sets the value of the partidaArancelariaProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartidaArancelariaProducto(String value) {
        this.partidaArancelariaProducto = value;
    }

    /**
     * Gets the value of the pesoNeto property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPesoNeto() {
        return pesoNeto;
    }

    /**
     * Sets the value of the pesoNeto property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPesoNeto(Double value) {
        this.pesoNeto = value;
    }

    /**
     * Gets the value of the puntoIngresoProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPuntoIngresoProducto() {
        return puntoIngresoProducto;
    }

    /**
     * Sets the value of the puntoIngresoProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPuntoIngresoProducto(String value) {
        this.puntoIngresoProducto = value;
    }

    /**
     * Gets the value of the puntoSalidaProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPuntoSalidaProducto() {
        return puntoSalidaProducto;
    }

    /**
     * Sets the value of the puntoSalidaProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPuntoSalidaProducto(String value) {
        this.puntoSalidaProducto = value;
    }

    /**
     * Gets the value of the tipoEnvaseProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoEnvaseProducto() {
        return tipoEnvaseProducto;
    }

    /**
     * Sets the value of the tipoEnvaseProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoEnvaseProducto(String value) {
        this.tipoEnvaseProducto = value;
    }

}
