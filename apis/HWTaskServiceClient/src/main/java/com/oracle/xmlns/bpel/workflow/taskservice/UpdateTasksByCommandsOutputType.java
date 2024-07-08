
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
import oracle.bpel.services.workflow.task.command.model.TasksUpdateByCommandsResponseType;


/**
 * <p>Java class for updateTasksByCommandsOutputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateTasksByCommandsOutputType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/taskService/command}tasksUpdateByCommandsResponse"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateTasksByCommandsOutputType", propOrder = {
    "tasksUpdateByCommandsResponse"
})
public class UpdateTasksByCommandsOutputType {

    @XmlElement(namespace = "http://xmlns.oracle.com/bpel/workflow/taskService/command", required = true)
    protected TasksUpdateByCommandsResponseType tasksUpdateByCommandsResponse;

    /**
     * Gets the value of the tasksUpdateByCommandsResponse property.
     * 
     * @return
     *     possible object is
     *     {@link TasksUpdateByCommandsResponseType }
     *     
     */
    public TasksUpdateByCommandsResponseType getTasksUpdateByCommandsResponse() {
        return tasksUpdateByCommandsResponse;
    }

    /**
     * Sets the value of the tasksUpdateByCommandsResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link TasksUpdateByCommandsResponseType }
     *     
     */
    public void setTasksUpdateByCommandsResponse(TasksUpdateByCommandsResponseType value) {
        this.tasksUpdateByCommandsResponse = value;
    }

}
