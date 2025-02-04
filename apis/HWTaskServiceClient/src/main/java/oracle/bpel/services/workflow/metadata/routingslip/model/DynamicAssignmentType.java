
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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dynamicAssignmentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dynamicAssignmentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="assignmentPattern" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}assignmentPatternType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="identityTypeToSelect" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}resourceIdentityType" default="user" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dynamicAssignmentType", propOrder = {
    "assignmentPattern"
})
public class DynamicAssignmentType {

    protected AssignmentPatternType assignmentPattern;
    @XmlAttribute(name = "identityTypeToSelect")
    protected ResourceIdentityType identityTypeToSelect;

    /**
     * Gets the value of the assignmentPattern property.
     * 
     * @return
     *     possible object is
     *     {@link AssignmentPatternType }
     *     
     */
    public AssignmentPatternType getAssignmentPattern() {
        return assignmentPattern;
    }

    /**
     * Sets the value of the assignmentPattern property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssignmentPatternType }
     *     
     */
    public void setAssignmentPattern(AssignmentPatternType value) {
        this.assignmentPattern = value;
    }

    /**
     * Gets the value of the identityTypeToSelect property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceIdentityType }
     *     
     */
    public ResourceIdentityType getIdentityTypeToSelect() {
        if (identityTypeToSelect == null) {
            return ResourceIdentityType.USER;
        } else {
            return identityTypeToSelect;
        }
    }

    /**
     * Sets the value of the identityTypeToSelect property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceIdentityType }
     *     
     */
    public void setIdentityTypeToSelect(ResourceIdentityType value) {
        this.identityTypeToSelect = value;
    }

}
