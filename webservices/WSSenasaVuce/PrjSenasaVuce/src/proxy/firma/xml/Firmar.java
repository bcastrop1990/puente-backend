
package proxy.firma.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="certificado" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="clavecertificado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="documento" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="urltsa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usertsa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pwdtsa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Pucmid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PflagTipo" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "certificado",
    "clavecertificado",
    "documento",
    "urltsa",
    "usertsa",
    "pwdtsa",
    "pucmid",
    "pflagTipo"
})
public class Firmar {

    protected byte[] certificado;
    protected String clavecertificado;
    protected byte[] documento;
    protected String urltsa;
    protected String usertsa;
    protected String pwdtsa;
    @XmlElement(name = "Pucmid")
    protected String pucmid;
    @XmlElement(name = "PflagTipo")
    protected int pflagTipo;

    /**
     * Gets the value of the certificado property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getCertificado() {
        return certificado;
    }

    /**
     * Sets the value of the certificado property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setCertificado(byte[] value) {
        this.certificado = ((byte[]) value);
    }

    /**
     * Gets the value of the clavecertificado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClavecertificado() {
        return clavecertificado;
    }

    /**
     * Sets the value of the clavecertificado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClavecertificado(String value) {
        this.clavecertificado = value;
    }

    /**
     * Gets the value of the documento property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getDocumento() {
        return documento;
    }

    /**
     * Sets the value of the documento property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setDocumento(byte[] value) {
        this.documento = ((byte[]) value);
    }

    /**
     * Gets the value of the urltsa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrltsa() {
        return urltsa;
    }

    /**
     * Sets the value of the urltsa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrltsa(String value) {
        this.urltsa = value;
    }

    /**
     * Gets the value of the usertsa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsertsa() {
        return usertsa;
    }

    /**
     * Sets the value of the usertsa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsertsa(String value) {
        this.usertsa = value;
    }

    /**
     * Gets the value of the pwdtsa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwdtsa() {
        return pwdtsa;
    }

    /**
     * Sets the value of the pwdtsa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwdtsa(String value) {
        this.pwdtsa = value;
    }

    /**
     * Gets the value of the pucmid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPucmid() {
        return pucmid;
    }

    /**
     * Sets the value of the pucmid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPucmid(String value) {
        this.pucmid = value;
    }

    /**
     * Gets the value of the pflagTipo property.
     * 
     */
    public int getPflagTipo() {
        return pflagTipo;
    }

    /**
     * Sets the value of the pflagTipo property.
     * 
     */
    public void setPflagTipo(int value) {
        this.pflagTipo = value;
    }

}
