
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
import javax.xml.bind.annotation.XmlType;
import oracle.bpel.services.workflow.common.model.WorkflowContextType;


/**
 * <p>Java class for approvalGroupRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="approvalGroupRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/common}workflowContext"/&gt;
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/runtimeConfig}approvalGroup"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "approvalGroupRequestType", propOrder = {
    "workflowContext",
    "approvalGroup"
})
public class ApprovalGroupRequestType {

    @XmlElement(namespace = "http://xmlns.oracle.com/bpel/workflow/common", required = true)
    protected WorkflowContextType workflowContext;
    @XmlElement(required = true)
    protected ApprovalGroupType approvalGroup;

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
     * Gets the value of the approvalGroup property.
     * 
     * @return
     *     possible object is
     *     {@link ApprovalGroupType }
     *     
     */
    public ApprovalGroupType getApprovalGroup() {
        return approvalGroup;
    }

    /**
     * Sets the value of the approvalGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApprovalGroupType }
     *     
     */
    public void setApprovalGroup(ApprovalGroupType value) {
        this.approvalGroup = value;
    }

}