
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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for stageTranslatedValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="stageTranslatedValues"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="stageTranslatedValue" type="{http://xmlns.oracle.com/bpel/workflow/translatedValues}stageTranslatedValue" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stageTranslatedValues", propOrder = {
    "stageTranslatedValue"
})
public class StageTranslatedValues {

    protected List<StageTranslatedValue> stageTranslatedValue;

    /**
     * Gets the value of the stageTranslatedValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stageTranslatedValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStageTranslatedValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StageTranslatedValue }
     * 
     * 
     */
    public List<StageTranslatedValue> getStageTranslatedValue() {
        if (stageTranslatedValue == null) {
            stageTranslatedValue = new ArrayList<StageTranslatedValue>();
        }
        return this.stageTranslatedValue;
    }

}
