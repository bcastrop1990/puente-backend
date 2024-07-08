
package com.oracle.xmlns.pcbpel.humanworkflow.configurations;

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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


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
 *         &lt;element name="taskAutoReleaseConfigurations"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="taskAutoRelease" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;attribute name="priority" use="required" type="{http://xmlns.oracle.com/pcbpel/humanworkflow/configurations}priorityType" /&gt;
 *                           &lt;attribute name="default" use="required" type="{http://www.w3.org/2001/XMLSchema}duration" /&gt;
 *                           &lt;attribute name="percentageOfExpiration" use="required" type="{http://xmlns.oracle.com/pcbpel/humanworkflow/configurations}percentageType" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="worklistApplicationURL" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="actionableEmailAccountName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="pushbackAssignee" type="{http://xmlns.oracle.com/pcbpel/humanworkflow/configurations}pushbackAssigneeType"/&gt;
 *         &lt;element name="assigneeDelimiter" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fusionAppsFrontendHostUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="shortHistoryActions"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="action" type="{http://xmlns.oracle.com/pcbpel/humanworkflow/configurations}shortHistoryActionType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="workflowServiceSessionTimeoutInMinutes" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="localeList"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="locale" type="{http://xmlns.oracle.com/pcbpel/humanworkflow/configurations}localeType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="dynamicAssignmentFunctions"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="function" type="{http://xmlns.oracle.com/pcbpel/humanworkflow/configurations}functionType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="portalRealmMapping" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="property" type="{http://xmlns.oracle.com/pcbpel/humanworkflow/configurations}propertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="trustedCAList" type="{http://xmlns.oracle.com/pcbpel/humanworkflow/configurations}trustedCAListType" minOccurs="0"/&gt;
 *         &lt;element name="credentialStoreProperties" type="{http://xmlns.oracle.com/pcbpel/humanworkflow/configurations}credentialStorePropertiesType" minOccurs="0"/&gt;
 *         &lt;element name="ssoOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="errorOnAtLeastJobLevelMissed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="recordTaskAssignmentStatistics" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="acknowledgeFyiUponRead" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="workflowCustomClasspathURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="systemUserConfigurations" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="systemUser" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;attribute name="realmName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="systemUserId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="documentStoreProvider" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ucmIdcUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cmisRepositoryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cmisBindingType" type="{http://xmlns.oracle.com/pcbpel/humanworkflow/configurations}cmisBindingType" minOccurs="0"/&gt;
 *         &lt;element name="cmisBindingClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="caseManagementPermissionTag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fyiDismissalJobFrequency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fyiTaskLifeTime" type="{http://www.w3.org/2001/XMLSchema}duration" minOccurs="0"/&gt;
 *         &lt;element name="caseManagementLink" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="maxNumberOfEmailAttachments" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="maxSizeOfEmailAttachmentsInKB" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="sharePayloadAcrossAllParallelApprovers" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element ref="{http://xmlns.oracle.com/pcbpel/humanworkflow/configurations}assigneeCache"/&gt;
 *         &lt;element name="onCompleted" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="onAlerted" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="onErrored" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "taskAutoReleaseConfigurations",
    "worklistApplicationURL",
    "actionableEmailAccountName",
    "pushbackAssignee",
    "assigneeDelimiter",
    "fusionAppsFrontendHostUrl",
    "shortHistoryActions",
    "workflowServiceSessionTimeoutInMinutes",
    "localeList",
    "dynamicAssignmentFunctions",
    "portalRealmMapping",
    "property",
    "trustedCAList",
    "credentialStoreProperties",
    "ssoOnly",
    "errorOnAtLeastJobLevelMissed",
    "recordTaskAssignmentStatistics",
    "acknowledgeFyiUponRead",
    "workflowCustomClasspathURL",
    "systemUserConfigurations",
    "documentStoreProvider",
    "ucmIdcUrl",
    "cmisRepositoryName",
    "cmisBindingType",
    "cmisBindingClass",
    "caseManagementPermissionTag",
    "fyiDismissalJobFrequency",
    "fyiTaskLifeTime",
    "caseManagementLink",
    "maxNumberOfEmailAttachments",
    "maxSizeOfEmailAttachmentsInKB",
    "sharePayloadAcrossAllParallelApprovers",
    "assigneeCache",
    "onCompleted",
    "onAlerted",
    "onErrored"
})
@XmlRootElement(name = "workflowConfigurations")
public class WorkflowConfigurations {

    @XmlElement(required = true)
    protected WorkflowConfigurations.TaskAutoReleaseConfigurations taskAutoReleaseConfigurations;
    @XmlElement(required = true)
    protected String worklistApplicationURL;
    protected String actionableEmailAccountName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected PushbackAssigneeType pushbackAssignee;
    @XmlElement(required = true)
    protected String assigneeDelimiter;
    protected String fusionAppsFrontendHostUrl;
    @XmlElement(required = true)
    protected WorkflowConfigurations.ShortHistoryActions shortHistoryActions;
    @XmlElement(required = true)
    protected BigInteger workflowServiceSessionTimeoutInMinutes;
    @XmlElement(required = true)
    protected WorkflowConfigurations.LocaleList localeList;
    @XmlElement(required = true)
    protected WorkflowConfigurations.DynamicAssignmentFunctions dynamicAssignmentFunctions;
    @XmlElement(required = true)
    protected String portalRealmMapping;
    protected List<PropertyType> property;
    protected TrustedCAListType trustedCAList;
    protected CredentialStorePropertiesType credentialStoreProperties;
    protected Boolean ssoOnly;
    @XmlElement(defaultValue = "false")
    protected Boolean errorOnAtLeastJobLevelMissed;
    protected Boolean recordTaskAssignmentStatistics;
    protected Boolean acknowledgeFyiUponRead;
    protected String workflowCustomClasspathURL;
    protected WorkflowConfigurations.SystemUserConfigurations systemUserConfigurations;
    protected String documentStoreProvider;
    protected String ucmIdcUrl;
    protected String cmisRepositoryName;
    @XmlSchemaType(name = "string")
    protected CmisBindingType cmisBindingType;
    protected String cmisBindingClass;
    protected String caseManagementPermissionTag;
    @XmlElement(defaultValue = "0 0/1 * * * ?")
    protected String fyiDismissalJobFrequency;
    @XmlElement(defaultValue = "P5D")
    protected Duration fyiTaskLifeTime;
    protected String caseManagementLink;
    @XmlElement(required = true)
    protected BigInteger maxNumberOfEmailAttachments;
    @XmlElement(required = true)
    protected BigInteger maxSizeOfEmailAttachmentsInKB;
    @XmlElement(defaultValue = "false")
    protected Boolean sharePayloadAcrossAllParallelApprovers;
    @XmlElement(required = true)
    protected AssigneeCache assigneeCache;
    protected String onCompleted;
    protected String onAlerted;
    protected String onErrored;

    /**
     * Gets the value of the taskAutoReleaseConfigurations property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowConfigurations.TaskAutoReleaseConfigurations }
     *     
     */
    public WorkflowConfigurations.TaskAutoReleaseConfigurations getTaskAutoReleaseConfigurations() {
        return taskAutoReleaseConfigurations;
    }

    /**
     * Sets the value of the taskAutoReleaseConfigurations property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowConfigurations.TaskAutoReleaseConfigurations }
     *     
     */
    public void setTaskAutoReleaseConfigurations(WorkflowConfigurations.TaskAutoReleaseConfigurations value) {
        this.taskAutoReleaseConfigurations = value;
    }

    /**
     * Gets the value of the worklistApplicationURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorklistApplicationURL() {
        return worklistApplicationURL;
    }

    /**
     * Sets the value of the worklistApplicationURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorklistApplicationURL(String value) {
        this.worklistApplicationURL = value;
    }

    /**
     * Gets the value of the actionableEmailAccountName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionableEmailAccountName() {
        return actionableEmailAccountName;
    }

    /**
     * Sets the value of the actionableEmailAccountName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionableEmailAccountName(String value) {
        this.actionableEmailAccountName = value;
    }

    /**
     * Gets the value of the pushbackAssignee property.
     * 
     * @return
     *     possible object is
     *     {@link PushbackAssigneeType }
     *     
     */
    public PushbackAssigneeType getPushbackAssignee() {
        return pushbackAssignee;
    }

    /**
     * Sets the value of the pushbackAssignee property.
     * 
     * @param value
     *     allowed object is
     *     {@link PushbackAssigneeType }
     *     
     */
    public void setPushbackAssignee(PushbackAssigneeType value) {
        this.pushbackAssignee = value;
    }

    /**
     * Gets the value of the assigneeDelimiter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssigneeDelimiter() {
        return assigneeDelimiter;
    }

    /**
     * Sets the value of the assigneeDelimiter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssigneeDelimiter(String value) {
        this.assigneeDelimiter = value;
    }

    /**
     * Gets the value of the fusionAppsFrontendHostUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFusionAppsFrontendHostUrl() {
        return fusionAppsFrontendHostUrl;
    }

    /**
     * Sets the value of the fusionAppsFrontendHostUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFusionAppsFrontendHostUrl(String value) {
        this.fusionAppsFrontendHostUrl = value;
    }

    /**
     * Gets the value of the shortHistoryActions property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowConfigurations.ShortHistoryActions }
     *     
     */
    public WorkflowConfigurations.ShortHistoryActions getShortHistoryActions() {
        return shortHistoryActions;
    }

    /**
     * Sets the value of the shortHistoryActions property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowConfigurations.ShortHistoryActions }
     *     
     */
    public void setShortHistoryActions(WorkflowConfigurations.ShortHistoryActions value) {
        this.shortHistoryActions = value;
    }

    /**
     * Gets the value of the workflowServiceSessionTimeoutInMinutes property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getWorkflowServiceSessionTimeoutInMinutes() {
        return workflowServiceSessionTimeoutInMinutes;
    }

    /**
     * Sets the value of the workflowServiceSessionTimeoutInMinutes property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setWorkflowServiceSessionTimeoutInMinutes(BigInteger value) {
        this.workflowServiceSessionTimeoutInMinutes = value;
    }

    /**
     * Gets the value of the localeList property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowConfigurations.LocaleList }
     *     
     */
    public WorkflowConfigurations.LocaleList getLocaleList() {
        return localeList;
    }

    /**
     * Sets the value of the localeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowConfigurations.LocaleList }
     *     
     */
    public void setLocaleList(WorkflowConfigurations.LocaleList value) {
        this.localeList = value;
    }

    /**
     * Gets the value of the dynamicAssignmentFunctions property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowConfigurations.DynamicAssignmentFunctions }
     *     
     */
    public WorkflowConfigurations.DynamicAssignmentFunctions getDynamicAssignmentFunctions() {
        return dynamicAssignmentFunctions;
    }

    /**
     * Sets the value of the dynamicAssignmentFunctions property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowConfigurations.DynamicAssignmentFunctions }
     *     
     */
    public void setDynamicAssignmentFunctions(WorkflowConfigurations.DynamicAssignmentFunctions value) {
        this.dynamicAssignmentFunctions = value;
    }

    /**
     * Gets the value of the portalRealmMapping property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortalRealmMapping() {
        return portalRealmMapping;
    }

    /**
     * Sets the value of the portalRealmMapping property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortalRealmMapping(String value) {
        this.portalRealmMapping = value;
    }

    /**
     * Gets the value of the property property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the property property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PropertyType }
     * 
     * 
     */
    public List<PropertyType> getProperty() {
        if (property == null) {
            property = new ArrayList<PropertyType>();
        }
        return this.property;
    }

    /**
     * Gets the value of the trustedCAList property.
     * 
     * @return
     *     possible object is
     *     {@link TrustedCAListType }
     *     
     */
    public TrustedCAListType getTrustedCAList() {
        return trustedCAList;
    }

    /**
     * Sets the value of the trustedCAList property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrustedCAListType }
     *     
     */
    public void setTrustedCAList(TrustedCAListType value) {
        this.trustedCAList = value;
    }

    /**
     * Gets the value of the credentialStoreProperties property.
     * 
     * @return
     *     possible object is
     *     {@link CredentialStorePropertiesType }
     *     
     */
    public CredentialStorePropertiesType getCredentialStoreProperties() {
        return credentialStoreProperties;
    }

    /**
     * Sets the value of the credentialStoreProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link CredentialStorePropertiesType }
     *     
     */
    public void setCredentialStoreProperties(CredentialStorePropertiesType value) {
        this.credentialStoreProperties = value;
    }

    /**
     * Gets the value of the ssoOnly property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSsoOnly() {
        return ssoOnly;
    }

    /**
     * Sets the value of the ssoOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSsoOnly(Boolean value) {
        this.ssoOnly = value;
    }

    /**
     * Gets the value of the errorOnAtLeastJobLevelMissed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isErrorOnAtLeastJobLevelMissed() {
        return errorOnAtLeastJobLevelMissed;
    }

    /**
     * Sets the value of the errorOnAtLeastJobLevelMissed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setErrorOnAtLeastJobLevelMissed(Boolean value) {
        this.errorOnAtLeastJobLevelMissed = value;
    }

    /**
     * Gets the value of the recordTaskAssignmentStatistics property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRecordTaskAssignmentStatistics() {
        return recordTaskAssignmentStatistics;
    }

    /**
     * Sets the value of the recordTaskAssignmentStatistics property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRecordTaskAssignmentStatistics(Boolean value) {
        this.recordTaskAssignmentStatistics = value;
    }

    /**
     * Gets the value of the acknowledgeFyiUponRead property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAcknowledgeFyiUponRead() {
        return acknowledgeFyiUponRead;
    }

    /**
     * Sets the value of the acknowledgeFyiUponRead property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAcknowledgeFyiUponRead(Boolean value) {
        this.acknowledgeFyiUponRead = value;
    }

    /**
     * Gets the value of the workflowCustomClasspathURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkflowCustomClasspathURL() {
        return workflowCustomClasspathURL;
    }

    /**
     * Sets the value of the workflowCustomClasspathURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkflowCustomClasspathURL(String value) {
        this.workflowCustomClasspathURL = value;
    }

    /**
     * Gets the value of the systemUserConfigurations property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowConfigurations.SystemUserConfigurations }
     *     
     */
    public WorkflowConfigurations.SystemUserConfigurations getSystemUserConfigurations() {
        return systemUserConfigurations;
    }

    /**
     * Sets the value of the systemUserConfigurations property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowConfigurations.SystemUserConfigurations }
     *     
     */
    public void setSystemUserConfigurations(WorkflowConfigurations.SystemUserConfigurations value) {
        this.systemUserConfigurations = value;
    }

    /**
     * Gets the value of the documentStoreProvider property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentStoreProvider() {
        return documentStoreProvider;
    }

    /**
     * Sets the value of the documentStoreProvider property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentStoreProvider(String value) {
        this.documentStoreProvider = value;
    }

    /**
     * Gets the value of the ucmIdcUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUcmIdcUrl() {
        return ucmIdcUrl;
    }

    /**
     * Sets the value of the ucmIdcUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUcmIdcUrl(String value) {
        this.ucmIdcUrl = value;
    }

    /**
     * Gets the value of the cmisRepositoryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCmisRepositoryName() {
        return cmisRepositoryName;
    }

    /**
     * Sets the value of the cmisRepositoryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCmisRepositoryName(String value) {
        this.cmisRepositoryName = value;
    }

    /**
     * Gets the value of the cmisBindingType property.
     * 
     * @return
     *     possible object is
     *     {@link CmisBindingType }
     *     
     */
    public CmisBindingType getCmisBindingType() {
        return cmisBindingType;
    }

    /**
     * Sets the value of the cmisBindingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CmisBindingType }
     *     
     */
    public void setCmisBindingType(CmisBindingType value) {
        this.cmisBindingType = value;
    }

    /**
     * Gets the value of the cmisBindingClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCmisBindingClass() {
        return cmisBindingClass;
    }

    /**
     * Sets the value of the cmisBindingClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCmisBindingClass(String value) {
        this.cmisBindingClass = value;
    }

    /**
     * Gets the value of the caseManagementPermissionTag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseManagementPermissionTag() {
        return caseManagementPermissionTag;
    }

    /**
     * Sets the value of the caseManagementPermissionTag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseManagementPermissionTag(String value) {
        this.caseManagementPermissionTag = value;
    }

    /**
     * Gets the value of the fyiDismissalJobFrequency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFyiDismissalJobFrequency() {
        return fyiDismissalJobFrequency;
    }

    /**
     * Sets the value of the fyiDismissalJobFrequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFyiDismissalJobFrequency(String value) {
        this.fyiDismissalJobFrequency = value;
    }

    /**
     * Gets the value of the fyiTaskLifeTime property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getFyiTaskLifeTime() {
        return fyiTaskLifeTime;
    }

    /**
     * Sets the value of the fyiTaskLifeTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setFyiTaskLifeTime(Duration value) {
        this.fyiTaskLifeTime = value;
    }

    /**
     * Gets the value of the caseManagementLink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseManagementLink() {
        return caseManagementLink;
    }

    /**
     * Sets the value of the caseManagementLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseManagementLink(String value) {
        this.caseManagementLink = value;
    }

    /**
     * Gets the value of the maxNumberOfEmailAttachments property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxNumberOfEmailAttachments() {
        return maxNumberOfEmailAttachments;
    }

    /**
     * Sets the value of the maxNumberOfEmailAttachments property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxNumberOfEmailAttachments(BigInteger value) {
        this.maxNumberOfEmailAttachments = value;
    }

    /**
     * Gets the value of the maxSizeOfEmailAttachmentsInKB property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxSizeOfEmailAttachmentsInKB() {
        return maxSizeOfEmailAttachmentsInKB;
    }

    /**
     * Sets the value of the maxSizeOfEmailAttachmentsInKB property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxSizeOfEmailAttachmentsInKB(BigInteger value) {
        this.maxSizeOfEmailAttachmentsInKB = value;
    }

    /**
     * Gets the value of the sharePayloadAcrossAllParallelApprovers property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSharePayloadAcrossAllParallelApprovers() {
        return sharePayloadAcrossAllParallelApprovers;
    }

    /**
     * Sets the value of the sharePayloadAcrossAllParallelApprovers property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSharePayloadAcrossAllParallelApprovers(Boolean value) {
        this.sharePayloadAcrossAllParallelApprovers = value;
    }

    /**
     * Gets the value of the assigneeCache property.
     * 
     * @return
     *     possible object is
     *     {@link AssigneeCache }
     *     
     */
    public AssigneeCache getAssigneeCache() {
        return assigneeCache;
    }

    /**
     * Sets the value of the assigneeCache property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssigneeCache }
     *     
     */
    public void setAssigneeCache(AssigneeCache value) {
        this.assigneeCache = value;
    }

    /**
     * Gets the value of the onCompleted property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnCompleted() {
        return onCompleted;
    }

    /**
     * Sets the value of the onCompleted property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnCompleted(String value) {
        this.onCompleted = value;
    }

    /**
     * Gets the value of the onAlerted property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnAlerted() {
        return onAlerted;
    }

    /**
     * Sets the value of the onAlerted property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnAlerted(String value) {
        this.onAlerted = value;
    }

    /**
     * Gets the value of the onErrored property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnErrored() {
        return onErrored;
    }

    /**
     * Sets the value of the onErrored property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnErrored(String value) {
        this.onErrored = value;
    }


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
     *         &lt;element name="function" type="{http://xmlns.oracle.com/pcbpel/humanworkflow/configurations}functionType" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "function"
    })
    public static class DynamicAssignmentFunctions {

        protected List<FunctionType> function;

        /**
         * Gets the value of the function property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the function property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFunction().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FunctionType }
         * 
         * 
         */
        public List<FunctionType> getFunction() {
            if (function == null) {
                function = new ArrayList<FunctionType>();
            }
            return this.function;
        }

    }


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
     *         &lt;element name="locale" type="{http://xmlns.oracle.com/pcbpel/humanworkflow/configurations}localeType" maxOccurs="unbounded"/&gt;
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
        "locale"
    })
    public static class LocaleList {

        @XmlElement(required = true)
        protected List<LocaleType> locale;

        /**
         * Gets the value of the locale property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the locale property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLocale().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link LocaleType }
         * 
         * 
         */
        public List<LocaleType> getLocale() {
            if (locale == null) {
                locale = new ArrayList<LocaleType>();
            }
            return this.locale;
        }

    }


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
     *         &lt;element name="action" type="{http://xmlns.oracle.com/pcbpel/humanworkflow/configurations}shortHistoryActionType" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "action"
    })
    public static class ShortHistoryActions {

        @XmlSchemaType(name = "string")
        protected List<ShortHistoryActionType> action;

        /**
         * Gets the value of the action property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the action property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAction().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ShortHistoryActionType }
         * 
         * 
         */
        public List<ShortHistoryActionType> getAction() {
            if (action == null) {
                action = new ArrayList<ShortHistoryActionType>();
            }
            return this.action;
        }

    }


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
     *         &lt;element name="systemUser" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;attribute name="realmName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="systemUserId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
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
        "systemUser"
    })
    public static class SystemUserConfigurations {

        @XmlElement(required = true)
        protected List<WorkflowConfigurations.SystemUserConfigurations.SystemUser> systemUser;

        /**
         * Gets the value of the systemUser property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the systemUser property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSystemUser().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link WorkflowConfigurations.SystemUserConfigurations.SystemUser }
         * 
         * 
         */
        public List<WorkflowConfigurations.SystemUserConfigurations.SystemUser> getSystemUser() {
            if (systemUser == null) {
                systemUser = new ArrayList<WorkflowConfigurations.SystemUserConfigurations.SystemUser>();
            }
            return this.systemUser;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;attribute name="realmName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="systemUserId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class SystemUser {

            @XmlAttribute(name = "realmName", required = true)
            protected String realmName;
            @XmlAttribute(name = "systemUserId", required = true)
            protected String systemUserId;

            /**
             * Gets the value of the realmName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRealmName() {
                return realmName;
            }

            /**
             * Sets the value of the realmName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRealmName(String value) {
                this.realmName = value;
            }

            /**
             * Gets the value of the systemUserId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSystemUserId() {
                return systemUserId;
            }

            /**
             * Sets the value of the systemUserId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSystemUserId(String value) {
                this.systemUserId = value;
            }

        }

    }


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
     *         &lt;element name="taskAutoRelease" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;attribute name="priority" use="required" type="{http://xmlns.oracle.com/pcbpel/humanworkflow/configurations}priorityType" /&gt;
     *                 &lt;attribute name="default" use="required" type="{http://www.w3.org/2001/XMLSchema}duration" /&gt;
     *                 &lt;attribute name="percentageOfExpiration" use="required" type="{http://xmlns.oracle.com/pcbpel/humanworkflow/configurations}percentageType" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
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
        "taskAutoRelease"
    })
    public static class TaskAutoReleaseConfigurations {

        @XmlElement(required = true)
        protected List<WorkflowConfigurations.TaskAutoReleaseConfigurations.TaskAutoRelease> taskAutoRelease;

        /**
         * Gets the value of the taskAutoRelease property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the taskAutoRelease property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTaskAutoRelease().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link WorkflowConfigurations.TaskAutoReleaseConfigurations.TaskAutoRelease }
         * 
         * 
         */
        public List<WorkflowConfigurations.TaskAutoReleaseConfigurations.TaskAutoRelease> getTaskAutoRelease() {
            if (taskAutoRelease == null) {
                taskAutoRelease = new ArrayList<WorkflowConfigurations.TaskAutoReleaseConfigurations.TaskAutoRelease>();
            }
            return this.taskAutoRelease;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;attribute name="priority" use="required" type="{http://xmlns.oracle.com/pcbpel/humanworkflow/configurations}priorityType" /&gt;
         *       &lt;attribute name="default" use="required" type="{http://www.w3.org/2001/XMLSchema}duration" /&gt;
         *       &lt;attribute name="percentageOfExpiration" use="required" type="{http://xmlns.oracle.com/pcbpel/humanworkflow/configurations}percentageType" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class TaskAutoRelease {

            @XmlAttribute(name = "priority", required = true)
            protected int priority;
            @XmlAttribute(name = "default", required = true)
            protected Duration _default;
            @XmlAttribute(name = "percentageOfExpiration", required = true)
            protected int percentageOfExpiration;

            /**
             * Gets the value of the priority property.
             * 
             */
            public int getPriority() {
                return priority;
            }

            /**
             * Sets the value of the priority property.
             * 
             */
            public void setPriority(int value) {
                this.priority = value;
            }

            /**
             * Gets the value of the default property.
             * 
             * @return
             *     possible object is
             *     {@link Duration }
             *     
             */
            public Duration getDefault() {
                return _default;
            }

            /**
             * Sets the value of the default property.
             * 
             * @param value
             *     allowed object is
             *     {@link Duration }
             *     
             */
            public void setDefault(Duration value) {
                this._default = value;
            }

            /**
             * Gets the value of the percentageOfExpiration property.
             * 
             */
            public int getPercentageOfExpiration() {
                return percentageOfExpiration;
            }

            /**
             * Sets the value of the percentageOfExpiration property.
             * 
             */
            public void setPercentageOfExpiration(int value) {
                this.percentageOfExpiration = value;
            }

        }

    }

}
