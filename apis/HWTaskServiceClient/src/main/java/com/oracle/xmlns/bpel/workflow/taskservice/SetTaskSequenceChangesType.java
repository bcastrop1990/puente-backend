
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
import javax.xml.bind.annotation.XmlType;
import oracle.bpel.services.workflow.common.model.WorkflowContextType;
import oracle.bpel.services.workflow.common.tsc.model.TaskSequenceChangeList;
import oracle.bpel.services.workflow.task.model.Task;


/**
 * <p>Java class for setTaskSequenceChangesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setTaskSequenceChangesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/common}workflowContext" minOccurs="0"/&gt;
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/task}task"/&gt;
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/common/tsc}taskSequenceChangeList"/&gt;
 *         &lt;element name="reset" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setTaskSequenceChangesType", propOrder = {
    "workflowContext",
    "task",
    "taskSequenceChangeList",
    "reset"
})
public class SetTaskSequenceChangesType {

    @XmlElement(namespace = "http://xmlns.oracle.com/bpel/workflow/common")
    protected WorkflowContextType workflowContext;
    @XmlElement(namespace = "http://xmlns.oracle.com/bpel/workflow/task", required = true)
    protected Task task;
    @XmlElement(namespace = "http://xmlns.oracle.com/bpel/workflow/common/tsc", required = true)
    protected TaskSequenceChangeList taskSequenceChangeList;
    protected boolean reset;

    /**
     * Gets the value of the workflowContext property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowContextType }
     *     
     */
    public WorkflowContextType getWorkflowContext() {
        return workflowContext;
    }

    /**
     * Sets the value of the workflowContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowContextType }
     *     
     */
    public void setWorkflowContext(WorkflowContextType value) {
        this.workflowContext = value;
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

    /**
     * Gets the value of the taskSequenceChangeList property.
     * 
     * @return
     *     possible object is
     *     {@link TaskSequenceChangeList }
     *     
     */
    public TaskSequenceChangeList getTaskSequenceChangeList() {
        return taskSequenceChangeList;
    }

    /**
     * Sets the value of the taskSequenceChangeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskSequenceChangeList }
     *     
     */
    public void setTaskSequenceChangeList(TaskSequenceChangeList value) {
        this.taskSequenceChangeList = value;
    }

    /**
     * Gets the value of the reset property.
     * 
     */
    public boolean isReset() {
        return reset;
    }

    /**
     * Sets the value of the reset property.
     * 
     */
    public void setReset(boolean value) {
        this.reset = value;
    }

}
