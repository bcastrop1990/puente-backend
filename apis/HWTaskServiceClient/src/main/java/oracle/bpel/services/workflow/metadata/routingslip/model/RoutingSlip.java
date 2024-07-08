
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

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="globalConfiguration" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}globalConfigurationType" minOccurs="0"/&gt;
 *         &lt;element name="assignmentService" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}assignmentServiceType" minOccurs="0"/&gt;
 *         &lt;element name="participants" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}participantsType" minOccurs="0"/&gt;
 *         &lt;element name="onErrorParticipant" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}onErrorParticipantType" minOccurs="0"/&gt;
 *         &lt;element name="notification" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}notificationType" minOccurs="0"/&gt;
 *         &lt;element name="reviewer" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}reviewerType" minOccurs="0"/&gt;
 *         &lt;element name="forwardingRules" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}forwardingRulesType" minOccurs="0"/&gt;
 *         &lt;element name="systemParameters" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}systemParametersType" minOccurs="0"/&gt;
 *         &lt;element name="restrictedAssignmentCallback" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}restrictedAssignmentCallbackType" minOccurs="0"/&gt;
 *         &lt;element name="excludedParticipants" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}excludedParticipantsType" minOccurs="0"/&gt;
 *         &lt;element name="customListBuilders" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}customListBuildersType" minOccurs="0"/&gt;
 *         &lt;element name="onExpireParticipant" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}onExpireParticipantType" minOccurs="0"/&gt;
 *         &lt;element name="skipCreatorAsApprover" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="assignToCreatorsManager" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="targetNamespace" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="numberOfTimesModified" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="taskId" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="systemAttributeCurrentAssignmentTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *       &lt;attribute name="releaseVersion" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="routingType" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}routingType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "globalConfiguration",
    "assignmentService",
    "participants",
    "onErrorParticipant",
    "notification",
    "reviewer",
    "forwardingRules",
    "systemParameters",
    "restrictedAssignmentCallback",
    "excludedParticipants",
    "customListBuilders",
    "onExpireParticipant",
    "skipCreatorAsApprover",
    "assignToCreatorsManager"
})
@XmlRootElement(name = "routingSlip")
public class RoutingSlip {

    protected GlobalConfigurationType globalConfiguration;
    protected AssignmentServiceType assignmentService;
    protected ParticipantsType participants;
    protected OnErrorParticipantType onErrorParticipant;
    protected NotificationType notification;
    protected ReviewerType reviewer;
    protected ForwardingRulesType forwardingRules;
    protected SystemParametersType systemParameters;
    protected RestrictedAssignmentCallbackType restrictedAssignmentCallback;
    protected ExcludedParticipantsType excludedParticipants;
    protected CustomListBuildersType customListBuilders;
    protected OnExpireParticipantType onExpireParticipant;
    protected Boolean skipCreatorAsApprover;
    protected Boolean assignToCreatorsManager;
    @XmlAttribute(name = "targetNamespace")
    protected String targetNamespace;
    @XmlAttribute(name = "numberOfTimesModified")
    protected BigInteger numberOfTimesModified;
    @XmlAttribute(name = "taskId")
    protected String taskId;
    @XmlAttribute(name = "systemAttributeCurrentAssignmentTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar systemAttributeCurrentAssignmentTime;
    @XmlAttribute(name = "releaseVersion")
    protected String releaseVersion;
    @XmlAttribute(name = "routingType")
    protected RoutingType routingType;

    /**
     * Gets the value of the globalConfiguration property.
     * 
     * @return
     *     possible object is
     *     {@link GlobalConfigurationType }
     *     
     */
    public GlobalConfigurationType getGlobalConfiguration() {
        return globalConfiguration;
    }

    /**
     * Sets the value of the globalConfiguration property.
     * 
     * @param value
     *     allowed object is
     *     {@link GlobalConfigurationType }
     *     
     */
    public void setGlobalConfiguration(GlobalConfigurationType value) {
        this.globalConfiguration = value;
    }

    /**
     * Gets the value of the assignmentService property.
     * 
     * @return
     *     possible object is
     *     {@link AssignmentServiceType }
     *     
     */
    public AssignmentServiceType getAssignmentService() {
        return assignmentService;
    }

    /**
     * Sets the value of the assignmentService property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssignmentServiceType }
     *     
     */
    public void setAssignmentService(AssignmentServiceType value) {
        this.assignmentService = value;
    }

    /**
     * Gets the value of the participants property.
     * 
     * @return
     *     possible object is
     *     {@link ParticipantsType }
     *     
     */
    public ParticipantsType getParticipants() {
        return participants;
    }

    /**
     * Sets the value of the participants property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParticipantsType }
     *     
     */
    public void setParticipants(ParticipantsType value) {
        this.participants = value;
    }

    /**
     * Gets the value of the onErrorParticipant property.
     * 
     * @return
     *     possible object is
     *     {@link OnErrorParticipantType }
     *     
     */
    public OnErrorParticipantType getOnErrorParticipant() {
        return onErrorParticipant;
    }

    /**
     * Sets the value of the onErrorParticipant property.
     * 
     * @param value
     *     allowed object is
     *     {@link OnErrorParticipantType }
     *     
     */
    public void setOnErrorParticipant(OnErrorParticipantType value) {
        this.onErrorParticipant = value;
    }

    /**
     * Gets the value of the notification property.
     * 
     * @return
     *     possible object is
     *     {@link NotificationType }
     *     
     */
    public NotificationType getNotification() {
        return notification;
    }

    /**
     * Sets the value of the notification property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotificationType }
     *     
     */
    public void setNotification(NotificationType value) {
        this.notification = value;
    }

    /**
     * Gets the value of the reviewer property.
     * 
     * @return
     *     possible object is
     *     {@link ReviewerType }
     *     
     */
    public ReviewerType getReviewer() {
        return reviewer;
    }

    /**
     * Sets the value of the reviewer property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReviewerType }
     *     
     */
    public void setReviewer(ReviewerType value) {
        this.reviewer = value;
    }

    /**
     * Gets the value of the forwardingRules property.
     * 
     * @return
     *     possible object is
     *     {@link ForwardingRulesType }
     *     
     */
    public ForwardingRulesType getForwardingRules() {
        return forwardingRules;
    }

    /**
     * Sets the value of the forwardingRules property.
     * 
     * @param value
     *     allowed object is
     *     {@link ForwardingRulesType }
     *     
     */
    public void setForwardingRules(ForwardingRulesType value) {
        this.forwardingRules = value;
    }

    /**
     * Gets the value of the systemParameters property.
     * 
     * @return
     *     possible object is
     *     {@link SystemParametersType }
     *     
     */
    public SystemParametersType getSystemParameters() {
        return systemParameters;
    }

    /**
     * Sets the value of the systemParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link SystemParametersType }
     *     
     */
    public void setSystemParameters(SystemParametersType value) {
        this.systemParameters = value;
    }

    /**
     * Gets the value of the restrictedAssignmentCallback property.
     * 
     * @return
     *     possible object is
     *     {@link RestrictedAssignmentCallbackType }
     *     
     */
    public RestrictedAssignmentCallbackType getRestrictedAssignmentCallback() {
        return restrictedAssignmentCallback;
    }

    /**
     * Sets the value of the restrictedAssignmentCallback property.
     * 
     * @param value
     *     allowed object is
     *     {@link RestrictedAssignmentCallbackType }
     *     
     */
    public void setRestrictedAssignmentCallback(RestrictedAssignmentCallbackType value) {
        this.restrictedAssignmentCallback = value;
    }

    /**
     * Gets the value of the excludedParticipants property.
     * 
     * @return
     *     possible object is
     *     {@link ExcludedParticipantsType }
     *     
     */
    public ExcludedParticipantsType getExcludedParticipants() {
        return excludedParticipants;
    }

    /**
     * Sets the value of the excludedParticipants property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExcludedParticipantsType }
     *     
     */
    public void setExcludedParticipants(ExcludedParticipantsType value) {
        this.excludedParticipants = value;
    }

    /**
     * Gets the value of the customListBuilders property.
     * 
     * @return
     *     possible object is
     *     {@link CustomListBuildersType }
     *     
     */
    public CustomListBuildersType getCustomListBuilders() {
        return customListBuilders;
    }

    /**
     * Sets the value of the customListBuilders property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomListBuildersType }
     *     
     */
    public void setCustomListBuilders(CustomListBuildersType value) {
        this.customListBuilders = value;
    }

    /**
     * Gets the value of the onExpireParticipant property.
     * 
     * @return
     *     possible object is
     *     {@link OnExpireParticipantType }
     *     
     */
    public OnExpireParticipantType getOnExpireParticipant() {
        return onExpireParticipant;
    }

    /**
     * Sets the value of the onExpireParticipant property.
     * 
     * @param value
     *     allowed object is
     *     {@link OnExpireParticipantType }
     *     
     */
    public void setOnExpireParticipant(OnExpireParticipantType value) {
        this.onExpireParticipant = value;
    }

    /**
     * Gets the value of the skipCreatorAsApprover property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSkipCreatorAsApprover() {
        return skipCreatorAsApprover;
    }

    /**
     * Sets the value of the skipCreatorAsApprover property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSkipCreatorAsApprover(Boolean value) {
        this.skipCreatorAsApprover = value;
    }

    /**
     * Gets the value of the assignToCreatorsManager property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAssignToCreatorsManager() {
        return assignToCreatorsManager;
    }

    /**
     * Sets the value of the assignToCreatorsManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAssignToCreatorsManager(Boolean value) {
        this.assignToCreatorsManager = value;
    }

    /**
     * Gets the value of the targetNamespace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetNamespace() {
        return targetNamespace;
    }

    /**
     * Sets the value of the targetNamespace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetNamespace(String value) {
        this.targetNamespace = value;
    }

    /**
     * Gets the value of the numberOfTimesModified property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfTimesModified() {
        return numberOfTimesModified;
    }

    /**
     * Sets the value of the numberOfTimesModified property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfTimesModified(BigInteger value) {
        this.numberOfTimesModified = value;
    }

    /**
     * Gets the value of the taskId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Sets the value of the taskId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskId(String value) {
        this.taskId = value;
    }

    /**
     * Gets the value of the systemAttributeCurrentAssignmentTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSystemAttributeCurrentAssignmentTime() {
        return systemAttributeCurrentAssignmentTime;
    }

    /**
     * Sets the value of the systemAttributeCurrentAssignmentTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSystemAttributeCurrentAssignmentTime(XMLGregorianCalendar value) {
        this.systemAttributeCurrentAssignmentTime = value;
    }

    /**
     * Gets the value of the releaseVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReleaseVersion() {
        return releaseVersion;
    }

    /**
     * Sets the value of the releaseVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReleaseVersion(String value) {
        this.releaseVersion = value;
    }

    /**
     * Gets the value of the routingType property.
     * 
     * @return
     *     possible object is
     *     {@link RoutingType }
     *     
     */
    public RoutingType getRoutingType() {
        return routingType;
    }

    /**
     * Sets the value of the routingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoutingType }
     *     
     */
    public void setRoutingType(RoutingType value) {
        this.routingType = value;
    }

}
