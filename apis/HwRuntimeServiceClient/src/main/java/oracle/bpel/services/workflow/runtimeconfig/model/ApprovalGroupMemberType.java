
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


/**
 * <p>Java class for approvalGroupMemberType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="approvalGroupMemberType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="approvalGroupId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="member" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="type" type="{http://xmlns.oracle.com/bpel/workflow/runtimeConfig}approvalGroupMemberTypeType"/&gt;
 *         &lt;element name="sequence" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="persistAction" type="{http://xmlns.oracle.com/bpel/workflow/runtimeConfig}persistActionType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "approvalGroupMemberType", propOrder = {
    "approvalGroupId",
    "member",
    "type",
    "sequence",
    "persistAction"
})
public class ApprovalGroupMemberType {

    protected int approvalGroupId;
    @XmlElement(required = true)
    protected String member;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ApprovalGroupMemberTypeType type;
    protected int sequence;
    @XmlSchemaType(name = "string")
    protected PersistActionType persistAction;

    /**
     * Gets the value of the approvalGroupId property.
     * 
     */
    public int getApprovalGroupId() {
        return approvalGroupId;
    }

    /**
     * Sets the value of the approvalGroupId property.
     * 
     */
    public void setApprovalGroupId(int value) {
        this.approvalGroupId = value;
    }

    /**
     * Gets the value of the member property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMember() {
        return member;
    }

    /**
     * Sets the value of the member property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMember(String value) {
        this.member = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link ApprovalGroupMemberTypeType }
     *     
     */
    public ApprovalGroupMemberTypeType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApprovalGroupMemberTypeType }
     *     
     */
    public void setType(ApprovalGroupMemberTypeType value) {
        this.type = value;
    }

    /**
     * Gets the value of the sequence property.
     * 
     */
    public int getSequence() {
        return sequence;
    }

    /**
     * Sets the value of the sequence property.
     * 
     */
    public void setSequence(int value) {
        this.sequence = value;
    }

    /**
     * Gets the value of the persistAction property.
     * 
     * @return
     *     possible object is
     *     {@link PersistActionType }
     *     
     */
    public PersistActionType getPersistAction() {
        return persistAction;
    }

    /**
     * Sets the value of the persistAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersistActionType }
     *     
     */
    public void setPersistAction(PersistActionType value) {
        this.persistAction = value;
    }

}
