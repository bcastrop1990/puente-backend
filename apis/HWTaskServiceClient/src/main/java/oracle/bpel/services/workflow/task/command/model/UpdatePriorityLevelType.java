
package oracle.bpel.services.workflow.task.command.model;

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
 * <p>Java class for updatePriorityLevelType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updatePriorityLevelType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="priorityType" type="{http://xmlns.oracle.com/bpel/workflow/taskService/command}updatePriorityType"/&gt;
 *         &lt;element name="priorityLevel" type="{http://xmlns.oracle.com/bpel/workflow/taskService/command}intPriorityType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updatePriorityLevelType", propOrder = {
    "priorityType",
    "priorityLevel"
})
public class UpdatePriorityLevelType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected UpdatePriorityType priorityType;
    protected int priorityLevel;

    /**
     * Gets the value of the priorityType property.
     * 
     * @return
     *     possible object is
     *     {@link UpdatePriorityType }
     *     
     */
    public UpdatePriorityType getPriorityType() {
        return priorityType;
    }

    /**
     * Sets the value of the priorityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdatePriorityType }
     *     
     */
    public void setPriorityType(UpdatePriorityType value) {
        this.priorityType = value;
    }

    /**
     * Gets the value of the priorityLevel property.
     * 
     */
    public int getPriorityLevel() {
        return priorityLevel;
    }

    /**
     * Sets the value of the priorityLevel property.
     * 
     */
    public void setPriorityLevel(int value) {
        this.priorityLevel = value;
    }

}
