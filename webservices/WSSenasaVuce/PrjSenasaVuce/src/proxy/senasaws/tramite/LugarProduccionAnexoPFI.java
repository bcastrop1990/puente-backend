
package proxy.senasaws.tramite;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lugarProduccionAnexoPFI complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="lugarProduccionAnexoPFI">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoAnexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcionAnexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lugarProduccionAnexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreCientificoAnexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partidaArancelariaAnexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "lugarProduccionAnexoPFI", propOrder = {
    "codigoAnexo",
    "descripcionAnexo",
    "lugarProduccionAnexo",
    "nombreCientificoAnexo",
    "partidaArancelariaAnexo",
    "tipoEnvaseAnexo"
})
public class LugarProduccionAnexoPFI {

    protected String codigoAnexo;
    protected String descripcionAnexo;
    protected String lugarProduccionAnexo;
    protected String nombreCientificoAnexo;
    protected String partidaArancelariaAnexo;
    protected String tipoEnvaseAnexo;

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
     * Gets the value of the lugarProduccionAnexo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLugarProduccionAnexo() {
        return lugarProduccionAnexo;
    }

    /**
     * Sets the value of the lugarProduccionAnexo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLugarProduccionAnexo(String value) {
        this.lugarProduccionAnexo = value;
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
