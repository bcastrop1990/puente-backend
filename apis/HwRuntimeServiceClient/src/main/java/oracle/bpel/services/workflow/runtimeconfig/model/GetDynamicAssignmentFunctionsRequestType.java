
package oracle.bpel.services.workflow.runtimeconfig.model;

/*
 * #%L
 * TUPA: Integration: BPM-Client: HW Runtime Service Client
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
import oracle.bpel.services.workflow.common.model.ParticipantTypeEnum;
import oracle.bpel.services.workflow.common.model.WorkflowContextType;


/**
 * <p>Java class for getDynamicAssignmentFunctionsRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getDynamicAssignmentFunctionsRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/common}workflowContext"/&gt;
 *         &lt;element name="assigneeType" type="{http://xmlns.oracle.com/bpel/workflow/common}participantTypeEnum" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDynamicAssignmentFunctionsRequestType", propOrder = {
    "workflowContext",
    "assigneeType"
})
public class GetDynamicAssignmentFunctionsRequestType {

    @XmlElement(namespace = "http://xmlns.oracle.com/bpel/workflow/common", required = true)
    protected WorkflowContextType workflowContext;
    @XmlSchemaType(name = "string")
    protected ParticipantTypeEnum assigneeType;

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
     * Gets the value of the assigneeType property.
     * 
     * @return
     *     possible object is
     *     {@link ParticipantTypeEnum }
     *     
     */
    public ParticipantTypeEnum getAssigneeType() {
        return assigneeType;
    }

    /**
     * Sets the value of the assigneeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParticipantTypeEnum }
     *     
     */
    public void setAssigneeType(ParticipantTypeEnum value) {
        this.assigneeType = value;
    }

}
