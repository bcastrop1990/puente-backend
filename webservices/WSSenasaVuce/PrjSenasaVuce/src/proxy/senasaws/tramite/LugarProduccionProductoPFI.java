
package proxy.senasaws.tramite;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lugarProduccionProductoPFI complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="lugarProduccionProductoPFI">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoProducto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descLugarProduccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcionProducto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lugarProduccionProducto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreCientificoProducto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partidaArancelariaProducto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "lugarProduccionProductoPFI", propOrder = {
    "codigoProducto",
    "descLugarProduccion",
    "descripcionProducto",
    "lugarProduccionProducto",
    "nombreCientificoProducto",
    "partidaArancelariaProducto",
    "tipoEnvaseProducto"
})
public class LugarProduccionProductoPFI {

    protected String codigoProducto;
    protected String descLugarProduccion;
    protected String descripcionProducto;
    protected String lugarProduccionProducto;
    protected String nombreCientificoProducto;
    protected String partidaArancelariaProducto;
    protected String tipoEnvaseProducto;

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
     * Gets the value of the descLugarProduccion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescLugarProduccion() {
        return descLugarProduccion;
    }

    /**
     * Sets the value of the descLugarProduccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescLugarProduccion(String value) {
        this.descLugarProduccion = value;
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
     * Gets the value of the lugarProduccionProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLugarProduccionProducto() {
        return lugarProduccionProducto;
    }

    /**
     * Sets the value of the lugarProduccionProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLugarProduccionProducto(String value) {
        this.lugarProduccionProducto = value;
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
