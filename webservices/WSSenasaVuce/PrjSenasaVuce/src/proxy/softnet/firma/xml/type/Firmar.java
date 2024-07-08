
package proxy.softnet.firma.xml.type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for firmar complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="firmar">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="xmlToSign" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trustedXUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trustedXPwd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signerDN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "firmar", propOrder = {
    "xmlToSign",
    "trustedXUser",
    "trustedXPwd",
    "signerDN",
    "tipo"
})
public class Firmar {

    protected String xmlToSign;
    protected String trustedXUser;
    protected String trustedXPwd;
    protected String signerDN;
    protected String tipo;

    /**
     * Gets the value of the xmlToSign property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlToSign() {
        return xmlToSign;
    }

    /**
     * Sets the value of the xmlToSign property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlToSign(String value) {
        this.xmlToSign = value;
    }

    /**
     * Gets the value of the trustedXUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrustedXUser() {
        return trustedXUser;
    }

    /**
     * Sets the value of the trustedXUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrustedXUser(String value) {
        this.trustedXUser = value;
    }

    /**
     * Gets the value of the trustedXPwd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrustedXPwd() {
        return trustedXPwd;
    }

    /**
     * Sets the value of the trustedXPwd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrustedXPwd(String value) {
        this.trustedXPwd = value;
    }

    /**
     * Gets the value of the signerDN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignerDN() {
        return signerDN;
    }

    /**
     * Sets the value of the signerDN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignerDN(String value) {
        this.signerDN = value;
    }

    /**
     * Gets the value of the tipo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Sets the value of the tipo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo(String value) {
        this.tipo = value;
    }

}
