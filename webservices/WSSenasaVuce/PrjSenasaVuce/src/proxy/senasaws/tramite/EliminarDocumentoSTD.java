
package proxy.senasaws.tramite;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eliminarDocumentoSTD complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="eliminarDocumentoSTD">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pcodigoSTD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pIdUcm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eliminarDocumentoSTD", propOrder = {
    "pcodigoSTD",
    "pIdUcm"
})
public class EliminarDocumentoSTD {

    protected String pcodigoSTD;
    protected String pIdUcm;

    /**
     * Gets the value of the pcodigoSTD property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPcodigoSTD() {
        return pcodigoSTD;
    }

    /**
     * Sets the value of the pcodigoSTD property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPcodigoSTD(String value) {
        this.pcodigoSTD = value;
    }

    /**
     * Gets the value of the pIdUcm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPIdUcm() {
        return pIdUcm;
    }

    /**
     * Sets the value of the pIdUcm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPIdUcm(String value) {
        this.pIdUcm = value;
    }

}
