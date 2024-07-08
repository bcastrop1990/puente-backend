
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
 * <p>Java class for restartRootTaskType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="restartRootTaskType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://xmlns.oracle.com/bpel/workflow/taskService}taskServiceContextTaskBaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="restartContext" type="{http://xmlns.oracle.com/bpel/workflow/taskService}restartContextType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "restartRootTaskType", propOrder = {
    "restartContext"
})
public class RestartRootTaskType
    extends TaskServiceContextTaskBaseType
{

    @XmlElement(required = true)
    protected RestartContextType restartContext;

    /**
     * Gets the value of the restartContext property.
     * 
     * @return
     *     possible object is
     *     {@link RestartContextType }
     *     
     */
    public RestartContextType getRestartContext() {
        return restartContext;
    }

    /**
     * Sets the value of the restartContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link RestartContextType }
     *     
     */
    public void setRestartContext(RestartContextType value) {
        this.restartContext = value;
    }

}
