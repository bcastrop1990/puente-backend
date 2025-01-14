
package com.oracle.xmlns.bpel.workflow.taskservice;

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
import oracle.bpel.services.workflow.task.model.Task;


/**
 * <p>Java class for taskAssignedMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="taskAssignedMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="action" type="{http://xmlns.oracle.com/bpel/workflow/taskService}assignedActionType"/&gt;
 *         &lt;element name="previousOutcome" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="previousOutcomeUpdatedBy" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/task}task"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "taskAssignedMessageType", propOrder = {
    "action",
    "previousOutcome",
    "previousOutcomeUpdatedBy",
    "task"
})
public class TaskAssignedMessageType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected AssignedActionType action;
    @XmlElement(required = true)
    protected String previousOutcome;
    @XmlElement(required = true)
    protected String previousOutcomeUpdatedBy;
    @XmlElement(namespace = "http://xmlns.oracle.com/bpel/workflow/task", required = true)
    protected Task task;

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link AssignedActionType }
     *     
     */
    public AssignedActionType getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssignedActionType }
     *     
     */
    public void setAction(AssignedActionType value) {
        this.action = value;
    }

    /**
     * Gets the value of the previousOutcome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreviousOutcome() {
        return previousOutcome;
    }

    /**
     * Sets the value of the previousOutcome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreviousOutcome(String value) {
        this.previousOutcome = value;
    }

    /**
     * Gets the value of the previousOutcomeUpdatedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreviousOutcomeUpdatedBy() {
        return previousOutcomeUpdatedBy;
    }

    /**
     * Sets the value of the previousOutcomeUpdatedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreviousOutcomeUpdatedBy(String value) {
        this.previousOutcomeUpdatedBy = value;
    }

    /**
     * Gets the value of the task property.
     * 
     * @return
     *     possible object is
     *     {@link Task }
     *     
     */
    public Task getTask() {
        return task;
    }

    /**
     * Sets the value of the task property.
     * 
     * @param value
     *     allowed object is
     *     {@link Task }
     *     
     */
    public void setTask(Task value) {
        this.task = value;
    }

}
