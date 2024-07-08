
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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="translatedValue" type="{http://xmlns.oracle.com/bpel/workflow/translatedValues}translatedValue" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "translatedValue"
})
@XmlRootElement(name = "translatedValues")
public class TranslatedValues {

    protected List<TranslatedValue> translatedValue;

    /**
     * Gets the value of the translatedValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the translatedValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTranslatedValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TranslatedValue }
     * 
     * 
     */
    public List<TranslatedValue> getTranslatedValue() {
        if (translatedValue == null) {
            translatedValue = new ArrayList<TranslatedValue>();
        }
        return this.translatedValue;
    }

}
