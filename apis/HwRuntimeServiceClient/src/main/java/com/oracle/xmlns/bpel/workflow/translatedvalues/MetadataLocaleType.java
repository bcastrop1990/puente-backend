
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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for metadataLocaleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="metadataLocaleType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="localeValue" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="stageTranslatedValues" type="{http://xmlns.oracle.com/bpel/workflow/translatedValues}stageTranslatedValues" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="participantTranslatedValues" type="{http://xmlns.oracle.com/bpel/workflow/translatedValues}participantTranslatedValues" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="outcomeTranslatedValues" type="{http://xmlns.oracle.com/bpel/workflow/translatedValues}outcomeTranslatedValues" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "metadataLocaleType", propOrder = {
    "localeValue",
    "stageTranslatedValues",
    "participantTranslatedValues",
    "outcomeTranslatedValues"
})
public class MetadataLocaleType {

    @XmlElement(required = true)
    protected String localeValue;
    protected List<StageTranslatedValues> stageTranslatedValues;
    protected List<ParticipantTranslatedValues> participantTranslatedValues;
    protected List<OutcomeTranslatedValues> outcomeTranslatedValues;

    /**
     * Gets the value of the localeValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocaleValue() {
        return localeValue;
    }

    /**
     * Sets the value of the localeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocaleValue(String value) {
        this.localeValue = value;
    }

    /**
     * Gets the value of the stageTranslatedValues property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stageTranslatedValues property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStageTranslatedValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StageTranslatedValues }
     * 
     * 
     */
    public List<StageTranslatedValues> getStageTranslatedValues() {
        if (stageTranslatedValues == null) {
            stageTranslatedValues = new ArrayList<StageTranslatedValues>();
        }
        return this.stageTranslatedValues;
    }

    /**
     * Gets the value of the participantTranslatedValues property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the participantTranslatedValues property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParticipantTranslatedValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParticipantTranslatedValues }
     * 
     * 
     */
    public List<ParticipantTranslatedValues> getParticipantTranslatedValues() {
        if (participantTranslatedValues == null) {
            participantTranslatedValues = new ArrayList<ParticipantTranslatedValues>();
        }
        return this.participantTranslatedValues;
    }

    /**
     * Gets the value of the outcomeTranslatedValues property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outcomeTranslatedValues property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutcomeTranslatedValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OutcomeTranslatedValues }
     * 
     * 
     */
    public List<OutcomeTranslatedValues> getOutcomeTranslatedValues() {
        if (outcomeTranslatedValues == null) {
            outcomeTranslatedValues = new ArrayList<OutcomeTranslatedValues>();
        }
        return this.outcomeTranslatedValues;
    }

}
