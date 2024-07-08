
package oracle.bpel.services.workflow.evidence.model;

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
import oracle.bpel.services.workflow.common.model.WorkflowContextType;


/**
 * <p>Java class for UpdateEvidenceRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateEvidenceRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/common}workflowContext" minOccurs="0"/&gt;
 *         &lt;element name="evidenceId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="UpdatableEvidenceAttributes" type="{http://xmlns.oracle.com/bpel/workflow/TaskEvidenceService}UpdatableEvidenceAttributesType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateEvidenceRequestType", propOrder = {
    "workflowContext",
    "evidenceId",
    "updatableEvidenceAttributes"
})
public class UpdateEvidenceRequestType {

    @XmlElement(namespace = "http://xmlns.oracle.com/bpel/workflow/common")
    protected WorkflowContextType workflowContext;
    @XmlElement(required = true)
    protected String evidenceId;
    @XmlElement(name = "UpdatableEvidenceAttributes", required = true)
    protected UpdatableEvidenceAttributesType updatableEvidenceAttributes;

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
     * Gets the value of the evidenceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvidenceId() {
        return evidenceId;
    }

    /**
     * Sets the value of the evidenceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvidenceId(String value) {
        this.evidenceId = value;
    }

    /**
     * Gets the value of the updatableEvidenceAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link UpdatableEvidenceAttributesType }
     *     
     */
    public UpdatableEvidenceAttributesType getUpdatableEvidenceAttributes() {
        return updatableEvidenceAttributes;
    }

    /**
     * Sets the value of the updatableEvidenceAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdatableEvidenceAttributesType }
     *     
     */
    public void setUpdatableEvidenceAttributes(UpdatableEvidenceAttributesType value) {
        this.updatableEvidenceAttributes = value;
    }

}
