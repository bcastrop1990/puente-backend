//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.05.21 a las 01:14:30 PM COT 
//


package oracle.bpel.services.workflow.task.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para hiddenAttributesType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="hiddenAttributesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="isCreatorHidden" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="creatorCustomText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isAutoApproval" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hiddenAttributesType", propOrder = {
    "isCreatorHidden",
    "creatorCustomText",
    "isAutoApproval"
})
public class HiddenAttributesType {

    protected Boolean isCreatorHidden;
    protected String creatorCustomText;
    protected Boolean isAutoApproval;

    /**
     * Obtiene el valor de la propiedad isCreatorHidden.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsCreatorHidden() {
        return isCreatorHidden;
    }

    /**
     * Define el valor de la propiedad isCreatorHidden.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsCreatorHidden(Boolean value) {
        this.isCreatorHidden = value;
    }

    /**
     * Obtiene el valor de la propiedad creatorCustomText.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatorCustomText() {
        return creatorCustomText;
    }

    /**
     * Define el valor de la propiedad creatorCustomText.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatorCustomText(String value) {
        this.creatorCustomText = value;
    }

    /**
     * Obtiene el valor de la propiedad isAutoApproval.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsAutoApproval() {
        return isAutoApproval;
    }

    /**
     * Define el valor de la propiedad isAutoApproval.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsAutoApproval(Boolean value) {
        this.isAutoApproval = value;
    }

}
