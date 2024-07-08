
package proxy.softnet.firma.xml.type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for firmarResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="firmarResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="xmlSignping" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "firmarResponse", propOrder = {
    "xmlSignping"
})
public class FirmarResponse {

    protected String xmlSignping;

    /**
     * Gets the value of the xmlSignping property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlSignping() {
        return xmlSignping;
    }

    /**
     * Sets the value of the xmlSignping property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlSignping(String value) {
        this.xmlSignping = value;
    }

}
