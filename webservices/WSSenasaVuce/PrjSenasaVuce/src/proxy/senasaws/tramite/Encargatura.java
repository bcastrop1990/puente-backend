
package proxy.senasaws.tramite;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for encargatura complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="encargatura">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="areaEncargado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="areaEncargatura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoEncargado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoEncargatura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaFinEncargatura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaIniEncargatura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreEncargado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreEncargatura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subAreaEncargado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subAreaEncargatura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "encargatura", propOrder = {
    "areaEncargado",
    "areaEncargatura",
    "codigoEncargado",
    "codigoEncargatura",
    "fechaFinEncargatura",
    "fechaIniEncargatura",
    "nombreEncargado",
    "nombreEncargatura",
    "subAreaEncargado",
    "subAreaEncargatura"
})
public class Encargatura {

    protected String areaEncargado;
    protected String areaEncargatura;
    protected String codigoEncargado;
    protected String codigoEncargatura;
    protected String fechaFinEncargatura;
    protected String fechaIniEncargatura;
    protected String nombreEncargado;
    protected String nombreEncargatura;
    protected String subAreaEncargado;
    protected String subAreaEncargatura;

    /**
     * Gets the value of the areaEncargado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaEncargado() {
        return areaEncargado;
    }

    /**
     * Sets the value of the areaEncargado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaEncargado(String value) {
        this.areaEncargado = value;
    }

    /**
     * Gets the value of the areaEncargatura property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaEncargatura() {
        return areaEncargatura;
    }

    /**
     * Sets the value of the areaEncargatura property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaEncargatura(String value) {
        this.areaEncargatura = value;
    }

    /**
     * Gets the value of the codigoEncargado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoEncargado() {
        return codigoEncargado;
    }

    /**
     * Sets the value of the codigoEncargado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoEncargado(String value) {
        this.codigoEncargado = value;
    }

    /**
     * Gets the value of the codigoEncargatura property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoEncargatura() {
        return codigoEncargatura;
    }

    /**
     * Sets the value of the codigoEncargatura property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoEncargatura(String value) {
        this.codigoEncargatura = value;
    }

    /**
     * Gets the value of the fechaFinEncargatura property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaFinEncargatura() {
        return fechaFinEncargatura;
    }

    /**
     * Sets the value of the fechaFinEncargatura property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaFinEncargatura(String value) {
        this.fechaFinEncargatura = value;
    }

    /**
     * Gets the value of the fechaIniEncargatura property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaIniEncargatura() {
        return fechaIniEncargatura;
    }

    /**
     * Sets the value of the fechaIniEncargatura property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaIniEncargatura(String value) {
        this.fechaIniEncargatura = value;
    }

    /**
     * Gets the value of the nombreEncargado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreEncargado() {
        return nombreEncargado;
    }

    /**
     * Sets the value of the nombreEncargado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreEncargado(String value) {
        this.nombreEncargado = value;
    }

    /**
     * Gets the value of the nombreEncargatura property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreEncargatura() {
        return nombreEncargatura;
    }

    /**
     * Sets the value of the nombreEncargatura property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreEncargatura(String value) {
        this.nombreEncargatura = value;
    }

    /**
     * Gets the value of the subAreaEncargado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubAreaEncargado() {
        return subAreaEncargado;
    }

    /**
     * Sets the value of the subAreaEncargado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubAreaEncargado(String value) {
        this.subAreaEncargado = value;
    }

    /**
     * Gets the value of the subAreaEncargatura property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubAreaEncargatura() {
        return subAreaEncargatura;
    }

    /**
     * Sets the value of the subAreaEncargatura property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubAreaEncargatura(String value) {
        this.subAreaEncargatura = value;
    }

}
