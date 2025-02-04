
package oracle.bpel.services.workflow.metadata.routingslip.model;

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
 * <p>Java class for hierarchyPrincipalType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="hierarchyPrincipalType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="userId" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}parameterType"/&gt;
 *         &lt;element name="jobLevel" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}parameterType" minOccurs="0"/&gt;
 *         &lt;element name="assignmentId" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}parameterType" minOccurs="0"/&gt;
 *         &lt;element name="effectiveDate" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}parameterType" minOccurs="0"/&gt;
 *         &lt;element name="hierarchyType" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}parameterType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hierarchyPrincipalType", propOrder = {
    "userId",
    "jobLevel",
    "assignmentId",
    "effectiveDate",
    "hierarchyType"
})
public class HierarchyPrincipalType {

    @XmlElement(required = true)
    protected ParameterType userId;
    protected ParameterType jobLevel;
    protected ParameterType assignmentId;
    protected ParameterType effectiveDate;
    protected ParameterType hierarchyType;

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link ParameterType }
     *     
     */
    public ParameterType getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParameterType }
     *     
     */
    public void setUserId(ParameterType value) {
        this.userId = value;
    }

    /**
     * Gets the value of the jobLevel property.
     * 
     * @return
     *     possible object is
     *     {@link ParameterType }
     *     
     */
    public ParameterType getJobLevel() {
        return jobLevel;
    }

    /**
     * Sets the value of the jobLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParameterType }
     *     
     */
    public void setJobLevel(ParameterType value) {
        this.jobLevel = value;
    }

    /**
     * Gets the value of the assignmentId property.
     * 
     * @return
     *     possible object is
     *     {@link ParameterType }
     *     
     */
    public ParameterType getAssignmentId() {
        return assignmentId;
    }

    /**
     * Sets the value of the assignmentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParameterType }
     *     
     */
    public void setAssignmentId(ParameterType value) {
        this.assignmentId = value;
    }

    /**
     * Gets the value of the effectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link ParameterType }
     *     
     */
    public ParameterType getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Sets the value of the effectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParameterType }
     *     
     */
    public void setEffectiveDate(ParameterType value) {
        this.effectiveDate = value;
    }

    /**
     * Gets the value of the hierarchyType property.
     * 
     * @return
     *     possible object is
     *     {@link ParameterType }
     *     
     */
    public ParameterType getHierarchyType() {
        return hierarchyType;
    }

    /**
     * Sets the value of the hierarchyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParameterType }
     *     
     */
    public void setHierarchyType(ParameterType value) {
        this.hierarchyType = value;
    }

}
