
package proxy.senasaws.tramite;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for puntoIngresoAnexoPFI complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="puntoIngresoAnexoPFI">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="codigoAnexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcionAnexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreCientificoAnexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partidaArancelariaAnexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pesoNeto" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="puntoIngresoAnexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoEnvaseAnexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "puntoIngresoAnexoPFI", propOrder = {
    "cantidad",
    "codigoAnexo",
    "descripcionAnexo",
    "nombreCientificoAnexo",
    "partidaArancelariaAnexo",
    "pesoNeto",
    "puntoIngresoAnexo",
    "tipoEnvaseAnexo"
})
public class PuntoIngresoAnexoPFI {

    protected Double cantidad;
    protected String codigoAnexo;
    protected String descripcionAnexo;
    protected String nombreCientificoAnexo;
    protected String partidaArancelariaAnexo;
    protected Double pesoNeto;
    protected String puntoIngresoAnexo;
    protected String tipoEnvaseAnexo;

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
     * Gets the value of the codigoAnexo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoAnexo() {
        return codigoAnexo;
    }

    /**
     * Sets the value of the codigoAnexo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoAnexo(String value) {
        this.codigoAnexo = value;
    }

    /**
     * Gets the value of the descripcionAnexo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionAnexo() {
        return descripcionAnexo;
    }

    /**
     * Sets the value of the descripcionAnexo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionAnexo(String value) {
        this.descripcionAnexo = value;
    }

    /**
     * Gets the value of the nombreCientificoAnexo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreCientificoAnexo() {
        return nombreCientificoAnexo;
    }

    /**
     * Sets the value of the nombreCientificoAnexo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreCientificoAnexo(String value) {
        this.nombreCientificoAnexo = value;
    }

    /**
     * Gets the value of the partidaArancelariaAnexo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartidaArancelariaAnexo() {
        return partidaArancelariaAnexo;
    }

    /**
     * Sets the value of the partidaArancelariaAnexo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartidaArancelariaAnexo(String value) {
        this.partidaArancelariaAnexo = value;
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
     * Gets the value of the puntoIngresoAnexo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPuntoIngresoAnexo() {
        return puntoIngresoAnexo;
    }

    /**
     * Sets the value of the puntoIngresoAnexo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPuntoIngresoAnexo(String value) {
        this.puntoIngresoAnexo = value;
    }

    /**
     * Gets the value of the tipoEnvaseAnexo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoEnvaseAnexo() {
        return tipoEnvaseAnexo;
    }

    /**
     * Sets the value of the tipoEnvaseAnexo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoEnvaseAnexo(String value) {
        this.tipoEnvaseAnexo = value;
    }

}
