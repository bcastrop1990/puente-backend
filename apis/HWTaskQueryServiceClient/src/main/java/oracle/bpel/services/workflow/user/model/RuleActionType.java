
package oracle.bpel.services.workflow.user.model;

/*
 * #%L
 * TUPA: Integration: BPM-Client: HW Task Query Service Client
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
 * noOperation is intended to be empty tag. Type is set to xsd:string to
 *         work-around JAXB-generation issues...
 * 
 * <p>Java class for ruleActionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ruleActionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="noOperation" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="reassign" type="{http://xmlns.oracle.com/bpel/workflow/userMetadata}ruleAssignmentType"/&gt;
 *         &lt;element name="delegate" type="{http://xmlns.oracle.com/bpel/workflow/userMetadata}ruleAssignmentType"/&gt;
 *         &lt;element name="setOutcome" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute name="actionType" use="required" type="{http://xmlns.oracle.com/bpel/workflow/userMetadata}actionTypeEnum" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ruleActionType", propOrder = {
    "noOperation",
    "reassign",
    "delegate",
    "setOutcome"
})
public class RuleActionType {

    protected String noOperation;
    protected RuleAssignmentType reassign;
    protected RuleAssignmentType delegate;
    protected String setOutcome;
    @XmlAttribute(name = "actionType", required = true)
    protected ActionTypeEnum actionType;

    /**
     * Gets the value of the noOperation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoOperation() {
        return noOperation;
    }

    /**
     * Sets the value of the noOperation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoOperation(String value) {
        this.noOperation = value;
    }

    /**
     * Gets the value of the reassign property.
     * 
     * @return
     *     possible object is
     *     {@link RuleAssignmentType }
     *     
     */
    public RuleAssignmentType getReassign() {
        return reassign;
    }

    /**
     * Sets the value of the reassign property.
     * 
     * @param value
     *     allowed object is
     *     {@link RuleAssignmentType }
     *     
     */
    public void setReassign(RuleAssignmentType value) {
        this.reassign = value;
    }

    /**
     * Gets the value of the delegate property.
     * 
     * @return
     *     possible object is
     *     {@link RuleAssignmentType }
     *     
     */
    public RuleAssignmentType getDelegate() {
        return delegate;
    }

    /**
     * Sets the value of the delegate property.
     * 
     * @param value
     *     allowed object is
     *     {@link RuleAssignmentType }
     *     
     */
    public void setDelegate(RuleAssignmentType value) {
        this.delegate = value;
    }

    /**
     * Gets the value of the setOutcome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSetOutcome() {
        return setOutcome;
    }

    /**
     * Sets the value of the setOutcome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSetOutcome(String value) {
        this.setOutcome = value;
    }

    /**
     * Gets the value of the actionType property.
     * 
     * @return
     *     possible object is
     *     {@link ActionTypeEnum }
     *     
     */
    public ActionTypeEnum getActionType() {
        return actionType;
    }

    /**
     * Sets the value of the actionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActionTypeEnum }
     *     
     */
    public void setActionType(ActionTypeEnum value) {
        this.actionType = value;
    }

}
