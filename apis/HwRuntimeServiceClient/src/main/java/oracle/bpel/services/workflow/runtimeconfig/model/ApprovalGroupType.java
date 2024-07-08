
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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for approvalGroupType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="approvalGroupType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="approvalGroupId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="approvalGroupName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="javaClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="owner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="approvalGroupMember" type="{http://xmlns.oracle.com/bpel/workflow/runtimeConfig}approvalGroupMemberType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="listModified" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "approvalGroupType", propOrder = {
    "approvalGroupId",
    "approvalGroupName",
    "javaClass",
    "owner",
    "approvalGroupMember",
    "listModified"
})
public class ApprovalGroupType {

    protected int approvalGroupId;
    @XmlElement(required = true)
    protected String approvalGroupName;
    protected String javaClass;
    protected String owner;
    protected List<ApprovalGroupMemberType> approvalGroupMember;
    @XmlElement(defaultValue = "false")
    protected boolean listModified;

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
     * Gets the value of the javaClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJavaClass() {
        return javaClass;
    }

    /**
     * Sets the value of the javaClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJavaClass(String value) {
        this.javaClass = value;
    }

    /**
     * Gets the value of the owner property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the value of the owner property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwner(String value) {
        this.owner = value;
    }

    /**
     * Gets the value of the approvalGroupMember property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the approvalGroupMember property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApprovalGroupMember().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ApprovalGroupMemberType }
     * 
     * 
     */
    public List<ApprovalGroupMemberType> getApprovalGroupMember() {
        if (approvalGroupMember == null) {
            approvalGroupMember = new ArrayList<ApprovalGroupMemberType>();
        }
        return this.approvalGroupMember;
    }

    /**
     * Gets the value of the listModified property.
     * 
     */
    public boolean isListModified() {
        return listModified;
    }

    /**
     * Sets the value of the listModified property.
     * 
     */
    public void setListModified(boolean value) {
        this.listModified = value;
    }

}
