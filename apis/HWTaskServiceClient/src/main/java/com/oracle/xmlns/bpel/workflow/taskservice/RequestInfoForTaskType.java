
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


/**
 * <p>Java class for requestInfoForTaskType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="requestInfoForTaskType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://xmlns.oracle.com/bpel/workflow/taskService}taskServiceContextTaskTaskIdBaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="taskAssignee" type="{http://xmlns.oracle.com/bpel/workflow/taskService}taskAssigneeType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestInfoForTaskType", propOrder = {
    "taskAssignee"
})
public class RequestInfoForTaskType
    extends TaskServiceContextTaskTaskIdBaseType
{

    @XmlElement(required = true)
    protected TaskAssigneeType taskAssignee;

    /**
     * Gets the value of the taskAssignee property.
     * 
     * @return
     *     possible object is
     *     {@link TaskAssigneeType }
     *     
     */
    public TaskAssigneeType getTaskAssignee() {
        return taskAssignee;
    }

    /**
     * Sets the value of the taskAssignee property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskAssigneeType }
     *     
     */
    public void setTaskAssignee(TaskAssigneeType value) {
        this.taskAssignee = value;
    }

}
