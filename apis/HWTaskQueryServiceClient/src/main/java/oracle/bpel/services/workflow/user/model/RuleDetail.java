
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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="generalInfo" type="{http://xmlns.oracle.com/bpel/workflow/userMetadata}ruleInfoType"/&gt;
 *         &lt;element name="taskTests" type="{http://xmlns.oracle.com/bpel/workflow/userMetadata}ruleTestListType"/&gt;
 *         &lt;element name="payloadTests" type="{http://xmlns.oracle.com/bpel/workflow/userMetadata}ruleTestListType"/&gt;
 *         &lt;element name="action" type="{http://xmlns.oracle.com/bpel/workflow/userMetadata}ruleActionType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "generalInfo",
    "taskTests",
    "payloadTests",
    "action"
})
@XmlRootElement(name = "ruleDetail")
public class RuleDetail {

    @XmlElement(required = true)
    protected RuleInfoType generalInfo;
    @XmlElement(required = true)
    protected RuleTestListType taskTests;
    @XmlElement(required = true)
    protected RuleTestListType payloadTests;
    @XmlElement(required = true)
    protected RuleActionType action;

    /**
     * Gets the value of the generalInfo property.
     * 
     * @return
     *     possible object is
     *     {@link RuleInfoType }
     *     
     */
    public RuleInfoType getGeneralInfo() {
        return generalInfo;
    }

    /**
     * Sets the value of the generalInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link RuleInfoType }
     *     
     */
    public void setGeneralInfo(RuleInfoType value) {
        this.generalInfo = value;
    }

    /**
     * Gets the value of the taskTests property.
     * 
     * @return
     *     possible object is
     *     {@link RuleTestListType }
     *     
     */
    public RuleTestListType getTaskTests() {
        return taskTests;
    }

    /**
     * Sets the value of the taskTests property.
     * 
     * @param value
     *     allowed object is
     *     {@link RuleTestListType }
     *     
     */
    public void setTaskTests(RuleTestListType value) {
        this.taskTests = value;
    }

    /**
     * Gets the value of the payloadTests property.
     * 
     * @return
     *     possible object is
     *     {@link RuleTestListType }
     *     
     */
    public RuleTestListType getPayloadTests() {
        return payloadTests;
    }

    /**
     * Sets the value of the payloadTests property.
     * 
     * @param value
     *     allowed object is
     *     {@link RuleTestListType }
     *     
     */
    public void setPayloadTests(RuleTestListType value) {
        this.payloadTests = value;
    }

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link RuleActionType }
     *     
     */
    public RuleActionType getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link RuleActionType }
     *     
     */
    public void setAction(RuleActionType value) {
        this.action = value;
    }

}
