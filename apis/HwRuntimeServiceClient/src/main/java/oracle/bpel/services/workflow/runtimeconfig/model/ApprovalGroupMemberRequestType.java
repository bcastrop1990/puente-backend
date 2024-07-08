
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
 * <p>Java class for approvalGroupMemberRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="approvalGroupMemberRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/common}workflowContext"/&gt;
 *         &lt;element name="approvalGroupName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/runtimeConfig}approvalGroupMember"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "approvalGroupMemberRequestType", propOrder = {
    "workflowContext",
    "approvalGroupName",
    "approvalGroupMember"
})
public class ApprovalGroupMemberRequestType {

    @XmlElement(namespace = "http://xmlns.oracle.com/bpel/workflow/common", required = true)
    protected WorkflowContextType workflowContext;
    @XmlElement(required = true)
    protected String approvalGroupName;
    @XmlElement(required = true)
    protected ApprovalGroupMemberType approvalGroupMember;

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
     * Gets the value of the approvalGroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApprovalGroupName() {
        return approvalGroupName;
    }

    /**
     * Sets the value of the approvalGroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApprovalGroupName(String value) {
        this.approvalGroupName = value;
    }

    /**
     * Gets the value of the approvalGroupMember property.
     * 
     * @return
     *     possible object is
     *     {@link ApprovalGroupMemberType }
     *     
     */
    public ApprovalGroupMemberType getApprovalGroupMember() {
        return approvalGroupMember;
    }

    /**
     * Sets the value of the approvalGroupMember property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApprovalGroupMemberType }
     *     
     */
    public void setApprovalGroupMember(ApprovalGroupMemberType value) {
        this.approvalGroupMember = value;
    }

}
