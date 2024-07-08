//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.05.21 a las 01:14:30 PM COT 
//


package oracle.bpel.services.workflow.task.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para flexfieldMappingType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="flexfieldMappingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="attributeLabel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="flexfield" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "flexfieldMappingType", propOrder = {
    "attributeLabel",
    "flexfield",
    "description"
})
public class FlexfieldMappingType {

    @XmlElement(required = true)
    protected String attributeLabel;
    @XmlElement(required = true)
    protected String flexfield;
    protected String description;

    /**
     * Obtiene el valor de la propiedad attributeLabel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttributeLabel() {
        return attributeLabel;
    }

    /**
     * Define el valor de la propiedad attributeLabel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttributeLabel(String value) {
        this.attributeLabel = value;
    }

    /**
     * Obtiene el valor de la propiedad flexfield.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlexfield() {
        return flexfield;
    }

    /**
     * Define el valor de la propiedad flexfield.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlexfield(String value) {
        this.flexfield = value;
    }

    /**
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

}
