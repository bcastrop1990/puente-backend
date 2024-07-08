//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.05.21 a las 01:14:30 PM COT 
//


package oracle.bpel.services.workflow.task.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para customAttributesType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="customAttributesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customAttributeString1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customAttributeString2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customAttributeNumber1" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="customAttributeNumber2" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="customAttributeDate1" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="customAttributeDate2" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customAttributesType", propOrder = {
    "customAttributeString1",
    "customAttributeString2",
    "customAttributeNumber1",
    "customAttributeNumber2",
    "customAttributeDate1",
    "customAttributeDate2"
})
public class CustomAttributesType {

    protected String customAttributeString1;
    protected String customAttributeString2;
    protected Double customAttributeNumber1;
    protected Double customAttributeNumber2;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar customAttributeDate1;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar customAttributeDate2;

    /**
     * Obtiene el valor de la propiedad customAttributeString1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomAttributeString1() {
        return customAttributeString1;
    }

    /**
     * Define el valor de la propiedad customAttributeString1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomAttributeString1(String value) {
        this.customAttributeString1 = value;
    }

    /**
     * Obtiene el valor de la propiedad customAttributeString2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomAttributeString2() {
        return customAttributeString2;
    }

    /**
     * Define el valor de la propiedad customAttributeString2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomAttributeString2(String value) {
        this.customAttributeString2 = value;
    }

    /**
     * Obtiene el valor de la propiedad customAttributeNumber1.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCustomAttributeNumber1() {
        return customAttributeNumber1;
    }

    /**
     * Define el valor de la propiedad customAttributeNumber1.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCustomAttributeNumber1(Double value) {
        this.customAttributeNumber1 = value;
    }

    /**
     * Obtiene el valor de la propiedad customAttributeNumber2.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCustomAttributeNumber2() {
        return customAttributeNumber2;
    }

    /**
     * Define el valor de la propiedad customAttributeNumber2.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCustomAttributeNumber2(Double value) {
        this.customAttributeNumber2 = value;
    }

    /**
     * Obtiene el valor de la propiedad customAttributeDate1.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCustomAttributeDate1() {
        return customAttributeDate1;
    }

    /**
     * Define el valor de la propiedad customAttributeDate1.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCustomAttributeDate1(XMLGregorianCalendar value) {
        this.customAttributeDate1 = value;
    }

    /**
     * Obtiene el valor de la propiedad customAttributeDate2.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCustomAttributeDate2() {
        return customAttributeDate2;
    }

    /**
     * Define el valor de la propiedad customAttributeDate2.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCustomAttributeDate2(XMLGregorianCalendar value) {
        this.customAttributeDate2 = value;
    }

}
