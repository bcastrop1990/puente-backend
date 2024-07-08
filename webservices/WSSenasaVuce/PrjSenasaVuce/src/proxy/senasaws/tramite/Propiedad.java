
package proxy.senasaws.tramite;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for propiedad complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="propiedad">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="XPropiedad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="XValor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "propiedad", propOrder = {
    "xPropiedad",
    "xValor"
})
public class Propiedad {

    @XmlElement(name = "XPropiedad")
    protected String xPropiedad;
    @XmlElement(name = "XValor")
    protected String xValor;

    /**
     * Gets the value of the xPropiedad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXPropiedad() {
        return xPropiedad;
    }

    /**
     * Sets the value of the xPropiedad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXPropiedad(String value) {
        this.xPropiedad = value;
    }

    /**
     * Gets the value of the xValor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXValor() {
        return xValor;
    }

    /**
     * Sets the value of the xValor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXValor(String value) {
        this.xValor = value;
    }

}
