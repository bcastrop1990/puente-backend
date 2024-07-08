
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
 * <p>Java class for overrideRoutingSlipType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="overrideRoutingSlipType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://xmlns.oracle.com/bpel/workflow/taskService}taskServiceContextTaskTaskIdBaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="routingSlipURI" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "overrideRoutingSlipType", propOrder = {
    "routingSlipURI"
})
public class OverrideRoutingSlipType
    extends TaskServiceContextTaskTaskIdBaseType
{

    @XmlElement(required = true)
    protected String routingSlipURI;

    /**
     * Gets the value of the routingSlipURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoutingSlipURI() {
        return routingSlipURI;
    }

    /**
     * Sets the value of the routingSlipURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoutingSlipURI(String value) {
        this.routingSlipURI = value;
    }

}
