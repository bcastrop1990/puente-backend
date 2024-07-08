
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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oracle.bpel.services.workflow.common.model.WorkflowContextType;
import oracle.bpel.services.workflow.task.command.model.TasksUpdateByCommandsType;


/**
 * <p>Java class for updateTasksByCommandsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateTasksByCommandsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/common}workflowContext" minOccurs="0"/&gt;
 *         &lt;element name="taskId" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/taskService/command}tasksUpdateByCommands"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateTasksByCommandsType", propOrder = {
    "workflowContext",
    "taskId",
    "tasksUpdateByCommands"
})
public class UpdateTasksByCommandsType {

    @XmlElement(namespace = "http://xmlns.oracle.com/bpel/workflow/common")
    protected WorkflowContextType workflowContext;
    protected List<String> taskId;
    @XmlElement(namespace = "http://xmlns.oracle.com/bpel/workflow/taskService/command", required = true)
    protected TasksUpdateByCommandsType tasksUpdateByCommands;

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
     * Gets the value of the taskId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taskId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaskId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTaskId() {
        if (taskId == null) {
            taskId = new ArrayList<String>();
        }
        return this.taskId;
    }

    /**
     * Gets the value of the tasksUpdateByCommands property.
     * 
     * @return
     *     possible object is
     *     {@link TasksUpdateByCommandsType }
     *     
     */
    public TasksUpdateByCommandsType getTasksUpdateByCommands() {
        return tasksUpdateByCommands;
    }

    /**
     * Sets the value of the tasksUpdateByCommands property.
     * 
     * @param value
     *     allowed object is
     *     {@link TasksUpdateByCommandsType }
     *     
     */
    public void setTasksUpdateByCommands(TasksUpdateByCommandsType value) {
        this.tasksUpdateByCommands = value;
    }

}
