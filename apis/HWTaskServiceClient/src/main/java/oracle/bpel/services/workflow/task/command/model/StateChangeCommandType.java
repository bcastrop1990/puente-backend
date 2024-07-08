
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
 * <p>Java class for stateChangeCommandType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="stateChangeCommandType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="updateOutcome" type="{http://xmlns.oracle.com/bpel/workflow/taskService/command}updateOutcomeType"/&gt;
 *           &lt;element name="reassignTask" type="{http://xmlns.oracle.com/bpel/workflow/taskService/command}taskAssigneesType"/&gt;
 *           &lt;element name="deleteTask" type="{http://xmlns.oracle.com/bpel/workflow/taskService/command}commandParamType"/&gt;
 *           &lt;element name="purgeTask" type="{http://xmlns.oracle.com/bpel/workflow/taskService/command}commandParamType"/&gt;
 *           &lt;element name="delegateTask" type="{http://xmlns.oracle.com/bpel/workflow/taskService/command}taskAssigneesType"/&gt;
 *           &lt;element name="escalateTask" type="{http://xmlns.oracle.com/bpel/workflow/taskService/command}commandParamType"/&gt;
 *           &lt;element name="withdrawTask" type="{http://xmlns.oracle.com/bpel/workflow/taskService/command}commandParamType"/&gt;
 *           &lt;element name="suspendTask" type="{http://xmlns.oracle.com/bpel/workflow/taskService/command}commandParamType"/&gt;
 *           &lt;element name="releaseTask" type="{http://xmlns.oracle.com/bpel/workflow/taskService/command}commandParamType"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stateChangeCommandType", propOrder = {
    "updateOutcome",
    "reassignTask",
    "deleteTask",
    "purgeTask",
    "delegateTask",
    "escalateTask",
    "withdrawTask",
    "suspendTask",
    "releaseTask"
})
public class StateChangeCommandType {

    protected UpdateOutcomeType updateOutcome;
    protected TaskAssigneesType reassignTask;
    protected CommandParamType deleteTask;
    protected CommandParamType purgeTask;
    protected TaskAssigneesType delegateTask;
    protected CommandParamType escalateTask;
    protected CommandParamType withdrawTask;
    protected CommandParamType suspendTask;
    protected CommandParamType releaseTask;

    /**
     * Gets the value of the updateOutcome property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateOutcomeType }
     *     
     */
    public UpdateOutcomeType getUpdateOutcome() {
        return updateOutcome;
    }

    /**
     * Sets the value of the updateOutcome property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateOutcomeType }
     *     
     */
    public void setUpdateOutcome(UpdateOutcomeType value) {
        this.updateOutcome = value;
    }

    /**
     * Gets the value of the reassignTask property.
     * 
     * @return
     *     possible object is
     *     {@link TaskAssigneesType }
     *     
     */
    public TaskAssigneesType getReassignTask() {
        return reassignTask;
    }

    /**
     * Sets the value of the reassignTask property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskAssigneesType }
     *     
     */
    public void setReassignTask(TaskAssigneesType value) {
        this.reassignTask = value;
    }

    /**
     * Gets the value of the deleteTask property.
     * 
     * @return
     *     possible object is
     *     {@link CommandParamType }
     *     
     */
    public CommandParamType getDeleteTask() {
        return deleteTask;
    }

    /**
     * Sets the value of the deleteTask property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommandParamType }
     *     
     */
    public void setDeleteTask(CommandParamType value) {
        this.deleteTask = value;
    }

    /**
     * Gets the value of the purgeTask property.
     * 
     * @return
     *     possible object is
     *     {@link CommandParamType }
     *     
     */
    public CommandParamType getPurgeTask() {
        return purgeTask;
    }

    /**
     * Sets the value of the purgeTask property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommandParamType }
     *     
     */
    public void setPurgeTask(CommandParamType value) {
        this.purgeTask = value;
    }

    /**
     * Gets the value of the delegateTask property.
     * 
     * @return
     *     possible object is
     *     {@link TaskAssigneesType }
     *     
     */
    public TaskAssigneesType getDelegateTask() {
        return delegateTask;
    }

    /**
     * Sets the value of the delegateTask property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskAssigneesType }
     *     
     */
    public void setDelegateTask(TaskAssigneesType value) {
        this.delegateTask = value;
    }

    /**
     * Gets the value of the escalateTask property.
     * 
     * @return
     *     possible object is
     *     {@link CommandParamType }
     *     
     */
    public CommandParamType getEscalateTask() {
        return escalateTask;
    }

    /**
     * Sets the value of the escalateTask property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommandParamType }
     *     
     */
    public void setEscalateTask(CommandParamType value) {
        this.escalateTask = value;
    }

    /**
     * Gets the value of the withdrawTask property.
     * 
     * @return
     *     possible object is
     *     {@link CommandParamType }
     *     
     */
    public CommandParamType getWithdrawTask() {
        return withdrawTask;
    }

    /**
     * Sets the value of the withdrawTask property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommandParamType }
     *     
     */
    public void setWithdrawTask(CommandParamType value) {
        this.withdrawTask = value;
    }

    /**
     * Gets the value of the suspendTask property.
     * 
     * @return
     *     possible object is
     *     {@link CommandParamType }
     *     
     */
    public CommandParamType getSuspendTask() {
        return suspendTask;
    }

    /**
     * Sets the value of the suspendTask property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommandParamType }
     *     
     */
    public void setSuspendTask(CommandParamType value) {
        this.suspendTask = value;
    }

    /**
     * Gets the value of the releaseTask property.
     * 
     * @return
     *     possible object is
     *     {@link CommandParamType }
     *     
     */
    public CommandParamType getReleaseTask() {
        return releaseTask;
    }

    /**
     * Sets the value of the releaseTask property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommandParamType }
     *     
     */
    public void setReleaseTask(CommandParamType value) {
        this.releaseTask = value;
    }

}
