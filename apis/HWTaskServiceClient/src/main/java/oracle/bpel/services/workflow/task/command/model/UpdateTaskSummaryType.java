
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
import javax.xml.bind.annotation.XmlType;
import oracle.bpel.services.workflow.query.model.SummaryFieldsInfoResponseType;


/**
 * <p>Java class for updateTaskSummaryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateTaskSummaryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/taskQueryService}taskSummaryFieldsInfoResponse" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateTaskSummaryType", propOrder = {
    "taskSummaryFieldsInfoResponse"
})
public class UpdateTaskSummaryType {

    @XmlElement(namespace = "http://xmlns.oracle.com/bpel/workflow/taskQueryService")
    protected SummaryFieldsInfoResponseType taskSummaryFieldsInfoResponse;

    /**
     * Gets the value of the taskSummaryFieldsInfoResponse property.
     * 
     * @return
     *     possible object is
     *     {@link SummaryFieldsInfoResponseType }
     *     
     */
    public SummaryFieldsInfoResponseType getTaskSummaryFieldsInfoResponse() {
        return taskSummaryFieldsInfoResponse;
    }

    /**
     * Sets the value of the taskSummaryFieldsInfoResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link SummaryFieldsInfoResponseType }
     *     
     */
    public void setTaskSummaryFieldsInfoResponse(SummaryFieldsInfoResponseType value) {
        this.taskSummaryFieldsInfoResponse = value;
    }

}
