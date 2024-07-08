
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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for preActionUserStepType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="preActionUserStepType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="userStep" type="{http://xmlns.oracle.com/bpel/workflow/task}preActionUserStepEnum"/&gt;
 *         &lt;element name="outcome" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "preActionUserStepType", propOrder = {
    "userStep",
    "outcome"
})
public class PreActionUserStepType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected PreActionUserStepEnum userStep;
    @XmlElement(required = true)
    protected String outcome;

    /**
     * Gets the value of the userStep property.
     * 
     * @return
     *     possible object is
     *     {@link PreActionUserStepEnum }
     *     
     */
    public PreActionUserStepEnum getUserStep() {
        return userStep;
    }

    /**
     * Sets the value of the userStep property.
     * 
     * @param value
     *     allowed object is
     *     {@link PreActionUserStepEnum }
     *     
     */
    public void setUserStep(PreActionUserStepEnum value) {
        this.userStep = value;
    }

    /**
     * Gets the value of the outcome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutcome() {
        return outcome;
    }

    /**
     * Sets the value of the outcome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutcome(String value) {
        this.outcome = value;
    }

}
