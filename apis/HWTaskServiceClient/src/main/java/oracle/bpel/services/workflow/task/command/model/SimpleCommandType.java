
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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for simpleCommandType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="simpleCommandType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="resumeTask" type="{http://xmlns.oracle.com/bpel/workflow/taskService/command}commandParamType" minOccurs="0"/&gt;
 *         &lt;element name="acquireTask" type="{http://xmlns.oracle.com/bpel/workflow/taskService/command}commandParamType" minOccurs="0"/&gt;
 *         &lt;element name="startTask" type="{http://xmlns.oracle.com/bpel/workflow/taskService/command}commandParamType" minOccurs="0"/&gt;
 *         &lt;element name="addComment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="updatePriority" type="{http://xmlns.oracle.com/bpel/workflow/taskService/command}updatePriorityLevelType" minOccurs="0"/&gt;
 *         &lt;element name="updateTaskSummary" type="{http://xmlns.oracle.com/bpel/workflow/taskService/command}updateTaskSummaryType" minOccurs="0"/&gt;
 *         &lt;element name="stopTask" type="{http://xmlns.oracle.com/bpel/workflow/taskService/command}commandParamType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "simpleCommandType", propOrder = {
    "resumeTask",
    "acquireTask",
    "startTask",
    "addComment",
    "updatePriority",
    "updateTaskSummary",
    "stopTask"
})
public class SimpleCommandType {

    protected CommandParamType resumeTask;
    protected CommandParamType acquireTask;
    protected CommandParamType startTask;
    protected String addComment;
    protected UpdatePriorityLevelType updatePriority;
    protected UpdateTaskSummaryType updateTaskSummary;
    protected CommandParamType stopTask;

    /**
     * Gets the value of the resumeTask property.
     * 
     * @return
     *     possible object is
     *     {@link CommandParamType }
     *     
     */
    public CommandParamType getResumeTask() {
        return resumeTask;
    }

    /**
     * Sets the value of the resumeTask property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommandParamType }
     *     
     */
    public void setResumeTask(CommandParamType value) {
        this.resumeTask = value;
    }

    /**
     * Gets the value of the acquireTask property.
     * 
     * @return
     *     possible object is
     *     {@link CommandParamType }
     *     
     */
    public CommandParamType getAcquireTask() {
        return acquireTask;
    }

    /**
     * Sets the value of the acquireTask property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommandParamType }
     *     
     */
    public void setAcquireTask(CommandParamType value) {
        this.acquireTask = value;
    }

    /**
     * Gets the value of the startTask property.
     * 
     * @return
     *     possible object is
     *     {@link CommandParamType }
     *     
     */
    public CommandParamType getStartTask() {
        return startTask;
    }

    /**
     * Sets the value of the startTask property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommandParamType }
     *     
     */
    public void setStartTask(CommandParamType value) {
        this.startTask = value;
    }

    /**
     * Gets the value of the addComment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddComment() {
        return addComment;
    }

    /**
     * Sets the value of the addComment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddComment(String value) {
        this.addComment = value;
    }

    /**
     * Gets the value of the updatePriority property.
     * 
     * @return
     *     possible object is
     *     {@link UpdatePriorityLevelType }
     *     
     */
    public UpdatePriorityLevelType getUpdatePriority() {
        return updatePriority;
    }

    /**
     * Sets the value of the updatePriority property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdatePriorityLevelType }
     *     
     */
    public void setUpdatePriority(UpdatePriorityLevelType value) {
        this.updatePriority = value;
    }

    /**
     * Gets the value of the updateTaskSummary property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateTaskSummaryType }
     *     
     */
    public UpdateTaskSummaryType getUpdateTaskSummary() {
        return updateTaskSummary;
    }

    /**
     * Sets the value of the updateTaskSummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateTaskSummaryType }
     *     
     */
    public void setUpdateTaskSummary(UpdateTaskSummaryType value) {
        this.updateTaskSummary = value;
    }

    /**
     * Gets the value of the stopTask property.
     * 
     * @return
     *     possible object is
     *     {@link CommandParamType }
     *     
     */
    public CommandParamType getStopTask() {
        return stopTask;
    }

    /**
     * Sets the value of the stopTask property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommandParamType }
     *     
     */
    public void setStopTask(CommandParamType value) {
        this.stopTask = value;
    }

}
