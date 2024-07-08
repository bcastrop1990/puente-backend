
package com.oracle.xmlns.bpel.workflow.translatedvalues;

/*
 * #%L
 * TUPA: Integration: BPM-Client: HW Runtime Service Client
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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for outcomeTranslatedValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="outcomeTranslatedValue"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="outcomeName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="outcomeValue" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "outcomeTranslatedValue", propOrder = {
    "outcomeName",
    "outcomeValue"
})
public class OutcomeTranslatedValue {

    @XmlElement(required = true)
    protected String outcomeName;
    @XmlElement(required = true)
    protected String outcomeValue;

    /**
     * Gets the value of the outcomeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutcomeName() {
        return outcomeName;
    }

    /**
     * Sets the value of the outcomeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutcomeName(String value) {
        this.outcomeName = value;
    }

    /**
     * Gets the value of the outcomeValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutcomeValue() {
        return outcomeValue;
    }

    /**
     * Sets the value of the outcomeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutcomeValue(String value) {
        this.outcomeValue = value;
    }

}
