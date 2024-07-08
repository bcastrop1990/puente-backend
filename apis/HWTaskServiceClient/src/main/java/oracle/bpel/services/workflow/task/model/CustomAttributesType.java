
package oracle.bpel.services.workflow.task.model;

/*
 * #%L
 * TUPA: Integration: BPM-Client: HW Task Service Client
 * %%
 * Copyright (C) 2016 SENASA
 * %%
 * This software is the confidential and proprietary information of SENASA. 
 * You shall not disclose such confidential information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with 
 * SENASA.
 * #L%
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for customAttributesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="customAttributesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="customAttributeString1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="customAttributeString2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="customAttributeNumber1" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="customAttributeNumber2" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="customAttributeDate1" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="customAttributeDate2" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
     * Gets the value of the customAttributeString1 property.
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
     * Sets the value of the customAttributeString1 property.
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
     * Gets the value of the customAttributeString2 property.
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
     * Sets the value of the customAttributeString2 property.
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
     * Gets the value of the customAttributeNumber1 property.
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
     * Sets the value of the customAttributeNumber1 property.
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
     * Gets the value of the customAttributeNumber2 property.
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
     * Sets the value of the customAttributeNumber2 property.
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
     * Gets the value of the customAttributeDate1 property.
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
     * Sets the value of the customAttributeDate1 property.
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
     * Gets the value of the customAttributeDate2 property.
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
     * Sets the value of the customAttributeDate2 property.
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
