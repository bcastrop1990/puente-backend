
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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for listType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="listType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="resourceList" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}resourceListType"/&gt;
 *         &lt;element name="managementChain" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}managementChainListType"/&gt;
 *         &lt;element name="supervisory" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}supervisoryListType"/&gt;
 *         &lt;element name="jobLevel" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}jobLevelListType"/&gt;
 *         &lt;element name="position" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}positionListType"/&gt;
 *         &lt;element name="approvalGroup" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}approvalGroupListType"/&gt;
 *         &lt;element name="ruleset" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}rulesetType"/&gt;
 *         &lt;element name="logicalPeopleGroup" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}logicalPeopleGroupListType"/&gt;
 *         &lt;element name="multipleList" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}multipleListType"/&gt;
 *         &lt;element name="customList" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}customListType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listType", propOrder = {
    "resourceList",
    "managementChain",
    "supervisory",
    "jobLevel",
    "position",
    "approvalGroup",
    "ruleset",
    "logicalPeopleGroup",
    "multipleList",
    "customList"
})
public class ListType {

    protected ResourceListType resourceList;
    protected ManagementChainListType managementChain;
    protected SupervisoryListType supervisory;
    protected JobLevelListType jobLevel;
    protected PositionListType position;
    protected ApprovalGroupListType approvalGroup;
    protected RulesetType ruleset;
    protected LogicalPeopleGroupListType logicalPeopleGroup;
    protected MultipleListType multipleList;
    protected CustomListType customList;

    /**
     * Gets the value of the resourceList property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceListType }
     *     
     */
    public ResourceListType getResourceList() {
        return resourceList;
    }

    /**
     * Sets the value of the resourceList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceListType }
     *     
     */
    public void setResourceList(ResourceListType value) {
        this.resourceList = value;
    }

    /**
     * Gets the value of the managementChain property.
     * 
     * @return
     *     possible object is
     *     {@link ManagementChainListType }
     *     
     */
    public ManagementChainListType getManagementChain() {
        return managementChain;
    }

    /**
     * Sets the value of the managementChain property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagementChainListType }
     *     
     */
    public void setManagementChain(ManagementChainListType value) {
        this.managementChain = value;
    }

    /**
     * Gets the value of the supervisory property.
     * 
     * @return
     *     possible object is
     *     {@link SupervisoryListType }
     *     
     */
    public SupervisoryListType getSupervisory() {
        return supervisory;
    }

    /**
     * Sets the value of the supervisory property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupervisoryListType }
     *     
     */
    public void setSupervisory(SupervisoryListType value) {
        this.supervisory = value;
    }

    /**
     * Gets the value of the jobLevel property.
     * 
     * @return
     *     possible object is
     *     {@link JobLevelListType }
     *     
     */
    public JobLevelListType getJobLevel() {
        return jobLevel;
    }

    /**
     * Sets the value of the jobLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link JobLevelListType }
     *     
     */
    public void setJobLevel(JobLevelListType value) {
        this.jobLevel = value;
    }

    /**
     * Gets the value of the position property.
     * 
     * @return
     *     possible object is
     *     {@link PositionListType }
     *     
     */
    public PositionListType getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     * @param value
     *     allowed object is
     *     {@link PositionListType }
     *     
     */
    public void setPosition(PositionListType value) {
        this.position = value;
    }

    /**
     * Gets the value of the approvalGroup property.
     * 
     * @return
     *     possible object is
     *     {@link ApprovalGroupListType }
     *     
     */
    public ApprovalGroupListType getApprovalGroup() {
        return approvalGroup;
    }

    /**
     * Sets the value of the approvalGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApprovalGroupListType }
     *     
     */
    public void setApprovalGroup(ApprovalGroupListType value) {
        this.approvalGroup = value;
    }

    /**
     * Gets the value of the ruleset property.
     * 
     * @return
     *     possible object is
     *     {@link RulesetType }
     *     
     */
    public RulesetType getRuleset() {
        return ruleset;
    }

    /**
     * Sets the value of the ruleset property.
     * 
     * @param value
     *     allowed object is
     *     {@link RulesetType }
     *     
     */
    public void setRuleset(RulesetType value) {
        this.ruleset = value;
    }

    /**
     * Gets the value of the logicalPeopleGroup property.
     * 
     * @return
     *     possible object is
     *     {@link LogicalPeopleGroupListType }
     *     
     */
    public LogicalPeopleGroupListType getLogicalPeopleGroup() {
        return logicalPeopleGroup;
    }

    /**
     * Sets the value of the logicalPeopleGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link LogicalPeopleGroupListType }
     *     
     */
    public void setLogicalPeopleGroup(LogicalPeopleGroupListType value) {
        this.logicalPeopleGroup = value;
    }

    /**
     * Gets the value of the multipleList property.
     * 
     * @return
     *     possible object is
     *     {@link MultipleListType }
     *     
     */
    public MultipleListType getMultipleList() {
        return multipleList;
    }

    /**
     * Sets the value of the multipleList property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultipleListType }
     *     
     */
    public void setMultipleList(MultipleListType value) {
        this.multipleList = value;
    }

    /**
     * Gets the value of the customList property.
     * 
     * @return
     *     possible object is
     *     {@link CustomListType }
     *     
     */
    public CustomListType getCustomList() {
        return customList;
    }

    /**
     * Sets the value of the customList property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomListType }
     *     
     */
    public void setCustomList(CustomListType value) {
        this.customList = value;
    }

}
