//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.05.21 a las 01:14:30 PM COT 
//


package oracle.bpel.services.workflow.task.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para systemAttributesType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="systemAttributesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accessKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="acquiredBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="approvalDuration" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="approvers" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="assignedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="assigneeGroups" type="{http://xmlns.oracle.com/bpel/workflow/task}identityType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="assigneeUsers" type="{http://xmlns.oracle.com/bpel/workflow/task}identityType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="createdDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="customActions" type="{http://xmlns.oracle.com/bpel/workflow/task}actionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="digitalSignatureRequired" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="displayInfo" type="{http://xmlns.oracle.com/bpel/workflow/task}displayInfoType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="elapsedTime" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="expirationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="expirationDuration" type="{http://www.w3.org/2001/XMLSchema}duration" minOccurs="0"/>
 *         &lt;element name="fromUser" type="{http://xmlns.oracle.com/bpel/workflow/task}identityType" minOccurs="0"/>
 *         &lt;element name="hasSubTasks" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="inShortHistory" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="isGroup" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mailStatus" type="{http://xmlns.oracle.com/bpel/workflow/task}mailStatusEnum" minOccurs="0"/>
 *         &lt;element name="numberOfTimesModified" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="originalAssigneeUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="outcome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parallelOutcomeCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passwordRequiredOnUpdate" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="pushbackSequence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="secureNotifications" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="shortHistory" type="{http://xmlns.oracle.com/bpel/workflow/task}shortHistoryType" minOccurs="0"/>
 *         &lt;element name="state" type="{http://xmlns.oracle.com/bpel/workflow/task}stateEnum" minOccurs="0"/>
 *         &lt;element name="substate" type="{http://xmlns.oracle.com/bpel/workflow/task}substateEnum" minOccurs="0"/>
 *         &lt;element name="systemActions" type="{http://xmlns.oracle.com/bpel/workflow/task}actionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="systemString1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="systemString2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="systemString3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taskGroupId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taskId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taskNumber" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="updatedBy" type="{http://xmlns.oracle.com/bpel/workflow/task}identityType" minOccurs="0"/>
 *         &lt;element name="updatedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="versionReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taskDefinitionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taskDefinitionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workflowPattern" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isTestTask" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="participantName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="readByUsers" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reviewers" type="{http://xmlns.oracle.com/bpel/workflow/task}identityType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="assignees" type="{http://xmlns.oracle.com/bpel/workflow/task}identityType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="taskGroupInstanceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subTaskGroupInstanceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parentTaskVersion" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="agRootId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="agMileStonePath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rootTaskId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parentTaskId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="systemStringActions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="restrictedActions" type="{http://xmlns.oracle.com/bpel/workflow/task}actionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="updatedNotificationId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="assignmentContext" type="{http://xmlns.oracle.com/bpel/workflow/task}assignmentContextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/task}collectionTarget" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="preActionUserSteps" type="{http://xmlns.oracle.com/bpel/workflow/task}preActionUserStepsType" minOccurs="0"/>
 *         &lt;element name="aggregationTaskId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isTemplateTask" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="taskViewContext" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taskNamespace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="actionDisplayName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timers" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="componentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="activityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="activityId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="processDueDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="thread" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="parentThread" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="step" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="visibilityRuleConditionValues" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isPartialTask" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="organizationalUnitId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tenantId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="listBuilderId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="caseId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="organizationalUnitName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="swimlaneRole" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="excludedParticipants" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timersSuspended" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="tenantIdNumber" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="taskAgeFromCreatedDate" type="{http://www.w3.org/2001/XMLSchema}duration" minOccurs="0"/>
 *         &lt;element name="taskAgeFromAssignedDate" type="{http://www.w3.org/2001/XMLSchema}duration" minOccurs="0"/>
 *         &lt;element name="taskTimeRemaining" type="{http://www.w3.org/2001/XMLSchema}duration" minOccurs="0"/>
 *         &lt;element name="isDecomposedTask" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="formName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="decomposedTaskGroupInstanceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="stopTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="workingDuration" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="acquiredByDisplayName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="originalAssigneeUserDisplayName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="approversDisplayNames" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="imageUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hiddenAttributes" type="{http://xmlns.oracle.com/bpel/workflow/task}hiddenAttributesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "systemAttributesType", propOrder = {
    "accessKey",
    "acquiredBy",
    "approvalDuration",
    "approvers",
    "assignedDate",
    "assigneeGroups",
    "assigneeUsers",
    "createdDate",
    "customActions",
    "digitalSignatureRequired",
    "displayInfo",
    "elapsedTime",
    "endDate",
    "expirationDate",
    "expirationDuration",
    "fromUser",
    "hasSubTasks",
    "inShortHistory",
    "isGroup",
    "language",
    "mailStatus",
    "numberOfTimesModified",
    "originalAssigneeUser",
    "outcome",
    "parallelOutcomeCount",
    "passwordRequiredOnUpdate",
    "pushbackSequence",
    "secureNotifications",
    "shortHistory",
    "state",
    "substate",
    "systemActions",
    "systemString1",
    "systemString2",
    "systemString3",
    "taskGroupId",
    "taskId",
    "taskNumber",
    "updatedBy",
    "updatedDate",
    "version",
    "versionReason",
    "taskDefinitionId",
    "taskDefinitionName",
    "workflowPattern",
    "isTestTask",
    "participantName",
    "readByUsers",
    "reviewers",
    "assignees",
    "taskGroupInstanceId",
    "subTaskGroupInstanceId",
    "parentTaskVersion",
    "agRootId",
    "agMileStonePath",
    "rootTaskId",
    "parentTaskId",
    "systemStringActions",
    "restrictedActions",
    "updatedNotificationId",
    "stage",
    "assignmentContext",
    "collectionTarget",
    "preActionUserSteps",
    "aggregationTaskId",
    "isTemplateTask",
    "taskViewContext",
    "taskNamespace",
    "actionDisplayName",
    "timers",
    "componentType",
    "activityName",
    "activityId",
    "processDueDate",
    "thread",
    "parentThread",
    "step",
    "visibilityRuleConditionValues",
    "isPartialTask",
    "organizationalUnitId",
    "tenantId",
    "listBuilderId",
    "caseId",
    "organizationalUnitName",
    "swimlaneRole",
    "excludedParticipants",
    "timersSuspended",
    "tenantIdNumber",
    "taskAgeFromCreatedDate",
    "taskAgeFromAssignedDate",
    "taskTimeRemaining",
    "isDecomposedTask",
    "formName",
    "decomposedTaskGroupInstanceId",
    "startTime",
    "stopTime",
    "workingDuration",
    "acquiredByDisplayName",
    "originalAssigneeUserDisplayName",
    "approversDisplayNames",
    "imageUrl",
    "hiddenAttributes"
})
public class SystemAttributesType {

    protected String accessKey;
    protected String acquiredBy;
    protected Long approvalDuration;
    protected String approvers;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar assignedDate;
    protected List<IdentityType> assigneeGroups;
    protected List<IdentityType> assigneeUsers;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdDate;
    protected List<ActionType> customActions;
    protected Boolean digitalSignatureRequired;
    protected List<DisplayInfoType> displayInfo;
    protected Long elapsedTime;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expirationDate;
    protected Duration expirationDuration;
    protected IdentityType fromUser;
    protected Boolean hasSubTasks;
    protected Boolean inShortHistory;
    protected Boolean isGroup;
    protected String language;
    @XmlSchemaType(name = "string")
    protected MailStatusEnum mailStatus;
    protected BigInteger numberOfTimesModified;
    protected String originalAssigneeUser;
    protected String outcome;
    protected String parallelOutcomeCount;
    protected Boolean passwordRequiredOnUpdate;
    protected String pushbackSequence;
    protected Boolean secureNotifications;
    protected ShortHistoryType shortHistory;
    @XmlSchemaType(name = "string")
    protected StateEnum state;
    @XmlSchemaType(name = "string")
    protected SubstateEnum substate;
    protected List<ActionType> systemActions;
    protected String systemString1;
    protected String systemString2;
    protected String systemString3;
    protected String taskGroupId;
    protected String taskId;
    protected BigInteger taskNumber;
    protected IdentityType updatedBy;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updatedDate;
    protected BigInteger version;
    protected String versionReason;
    protected String taskDefinitionId;
    protected String taskDefinitionName;
    protected String workflowPattern;
    protected Boolean isTestTask;
    protected String participantName;
    protected String readByUsers;
    protected List<IdentityType> reviewers;
    protected List<IdentityType> assignees;
    protected String taskGroupInstanceId;
    protected String subTaskGroupInstanceId;
    protected BigInteger parentTaskVersion;
    protected Long agRootId;
    protected String agMileStonePath;
    protected String rootTaskId;
    protected String parentTaskId;
    protected String systemStringActions;
    protected List<ActionType> restrictedActions;
    protected String updatedNotificationId;
    protected String stage;
    protected List<AssignmentContextType> assignmentContext;
    protected List<CollectionTargetType> collectionTarget;
    protected PreActionUserStepsType preActionUserSteps;
    protected String aggregationTaskId;
    protected Boolean isTemplateTask;
    protected String taskViewContext;
    protected String taskNamespace;
    protected String actionDisplayName;
    protected String timers;
    protected String componentType;
    protected String activityName;
    protected String activityId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar processDueDate;
    protected BigInteger thread;
    protected BigInteger parentThread;
    protected BigInteger step;
    protected String visibilityRuleConditionValues;
    protected Boolean isPartialTask;
    protected String organizationalUnitId;
    protected String tenantId;
    protected String listBuilderId;
    protected String caseId;
    protected String organizationalUnitName;
    protected String swimlaneRole;
    protected String excludedParticipants;
    @XmlElement(defaultValue = "false")
    protected Boolean timersSuspended;
    @XmlElement(defaultValue = "-1")
    protected Long tenantIdNumber;
    protected Duration taskAgeFromCreatedDate;
    protected Duration taskAgeFromAssignedDate;
    protected Duration taskTimeRemaining;
    @XmlElement(defaultValue = "false")
    protected Boolean isDecomposedTask;
    protected String formName;
    protected String decomposedTaskGroupInstanceId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startTime;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar stopTime;
    protected BigInteger workingDuration;
    protected String acquiredByDisplayName;
    protected String originalAssigneeUserDisplayName;
    protected String approversDisplayNames;
    protected String imageUrl;
    protected HiddenAttributesType hiddenAttributes;

    /**
     * Obtiene el valor de la propiedad accessKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessKey() {
        return accessKey;
    }

    /**
     * Define el valor de la propiedad accessKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessKey(String value) {
        this.accessKey = value;
    }

    /**
     * Obtiene el valor de la propiedad acquiredBy.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcquiredBy() {
        return acquiredBy;
    }

    /**
     * Define el valor de la propiedad acquiredBy.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcquiredBy(String value) {
        this.acquiredBy = value;
    }

    /**
     * Obtiene el valor de la propiedad approvalDuration.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getApprovalDuration() {
        return approvalDuration;
    }

    /**
     * Define el valor de la propiedad approvalDuration.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setApprovalDuration(Long value) {
        this.approvalDuration = value;
    }

    /**
     * Obtiene el valor de la propiedad approvers.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApprovers() {
        return approvers;
    }

    /**
     * Define el valor de la propiedad approvers.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApprovers(String value) {
        this.approvers = value;
    }

    /**
     * Obtiene el valor de la propiedad assignedDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAssignedDate() {
        return assignedDate;
    }

    /**
     * Define el valor de la propiedad assignedDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAssignedDate(XMLGregorianCalendar value) {
        this.assignedDate = value;
    }

    /**
     * Gets the value of the assigneeGroups property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assigneeGroups property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssigneeGroups().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentityType }
     * 
     * 
     */
    public List<IdentityType> getAssigneeGroups() {
        if (assigneeGroups == null) {
            assigneeGroups = new ArrayList<IdentityType>();
        }
        return this.assigneeGroups;
    }

    /**
     * Gets the value of the assigneeUsers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assigneeUsers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssigneeUsers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentityType }
     * 
     * 
     */
    public List<IdentityType> getAssigneeUsers() {
        if (assigneeUsers == null) {
            assigneeUsers = new ArrayList<IdentityType>();
        }
        return this.assigneeUsers;
    }

    /**
     * Obtiene el valor de la propiedad createdDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedDate() {
        return createdDate;
    }

    /**
     * Define el valor de la propiedad createdDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedDate(XMLGregorianCalendar value) {
        this.createdDate = value;
    }

    /**
     * Gets the value of the customActions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customActions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomActions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActionType }
     * 
     * 
     */
    public List<ActionType> getCustomActions() {
        if (customActions == null) {
            customActions = new ArrayList<ActionType>();
        }
        return this.customActions;
    }

    /**
     * Obtiene el valor de la propiedad digitalSignatureRequired.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDigitalSignatureRequired() {
        return digitalSignatureRequired;
    }

    /**
     * Define el valor de la propiedad digitalSignatureRequired.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDigitalSignatureRequired(Boolean value) {
        this.digitalSignatureRequired = value;
    }

    /**
     * Gets the value of the displayInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the displayInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisplayInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DisplayInfoType }
     * 
     * 
     */
    public List<DisplayInfoType> getDisplayInfo() {
        if (displayInfo == null) {
            displayInfo = new ArrayList<DisplayInfoType>();
        }
        return this.displayInfo;
    }

    /**
     * Obtiene el valor de la propiedad elapsedTime.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getElapsedTime() {
        return elapsedTime;
    }

    /**
     * Define el valor de la propiedad elapsedTime.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setElapsedTime(Long value) {
        this.elapsedTime = value;
    }

    /**
     * Obtiene el valor de la propiedad endDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Define el valor de la propiedad endDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Obtiene el valor de la propiedad expirationDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpirationDate() {
        return expirationDate;
    }

    /**
     * Define el valor de la propiedad expirationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpirationDate(XMLGregorianCalendar value) {
        this.expirationDate = value;
    }

    /**
     * Obtiene el valor de la propiedad expirationDuration.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getExpirationDuration() {
        return expirationDuration;
    }

    /**
     * Define el valor de la propiedad expirationDuration.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setExpirationDuration(Duration value) {
        this.expirationDuration = value;
    }

    /**
     * Obtiene el valor de la propiedad fromUser.
     * 
     * @return
     *     possible object is
     *     {@link IdentityType }
     *     
     */
    public IdentityType getFromUser() {
        return fromUser;
    }

    /**
     * Define el valor de la propiedad fromUser.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentityType }
     *     
     */
    public void setFromUser(IdentityType value) {
        this.fromUser = value;
    }

    /**
     * Obtiene el valor de la propiedad hasSubTasks.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasSubTasks() {
        return hasSubTasks;
    }

    /**
     * Define el valor de la propiedad hasSubTasks.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasSubTasks(Boolean value) {
        this.hasSubTasks = value;
    }

    /**
     * Obtiene el valor de la propiedad inShortHistory.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInShortHistory() {
        return inShortHistory;
    }

    /**
     * Define el valor de la propiedad inShortHistory.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInShortHistory(Boolean value) {
        this.inShortHistory = value;
    }

    /**
     * Obtiene el valor de la propiedad isGroup.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsGroup() {
        return isGroup;
    }

    /**
     * Define el valor de la propiedad isGroup.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsGroup(Boolean value) {
        this.isGroup = value;
    }

    /**
     * Obtiene el valor de la propiedad language.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Define el valor de la propiedad language.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Obtiene el valor de la propiedad mailStatus.
     * 
     * @return
     *     possible object is
     *     {@link MailStatusEnum }
     *     
     */
    public MailStatusEnum getMailStatus() {
        return mailStatus;
    }

    /**
     * Define el valor de la propiedad mailStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link MailStatusEnum }
     *     
     */
    public void setMailStatus(MailStatusEnum value) {
        this.mailStatus = value;
    }

    /**
     * Obtiene el valor de la propiedad numberOfTimesModified.
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
     * Define el valor de la propiedad numberOfTimesModified.
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
     * Obtiene el valor de la propiedad originalAssigneeUser.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalAssigneeUser() {
        return originalAssigneeUser;
    }

    /**
     * Define el valor de la propiedad originalAssigneeUser.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalAssigneeUser(String value) {
        this.originalAssigneeUser = value;
    }

    /**
     * Obtiene el valor de la propiedad outcome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutcome() {
        return outcome;
    }

    /**
     * Define el valor de la propiedad outcome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutcome(String value) {
        this.outcome = value;
    }

    /**
     * Obtiene el valor de la propiedad parallelOutcomeCount.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParallelOutcomeCount() {
        return parallelOutcomeCount;
    }

    /**
     * Define el valor de la propiedad parallelOutcomeCount.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParallelOutcomeCount(String value) {
        this.parallelOutcomeCount = value;
    }

    /**
     * Obtiene el valor de la propiedad passwordRequiredOnUpdate.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPasswordRequiredOnUpdate() {
        return passwordRequiredOnUpdate;
    }

    /**
     * Define el valor de la propiedad passwordRequiredOnUpdate.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPasswordRequiredOnUpdate(Boolean value) {
        this.passwordRequiredOnUpdate = value;
    }

    /**
     * Obtiene el valor de la propiedad pushbackSequence.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPushbackSequence() {
        return pushbackSequence;
    }

    /**
     * Define el valor de la propiedad pushbackSequence.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPushbackSequence(String value) {
        this.pushbackSequence = value;
    }

    /**
     * Obtiene el valor de la propiedad secureNotifications.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSecureNotifications() {
        return secureNotifications;
    }

    /**
     * Define el valor de la propiedad secureNotifications.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSecureNotifications(Boolean value) {
        this.secureNotifications = value;
    }

    /**
     * Obtiene el valor de la propiedad shortHistory.
     * 
     * @return
     *     possible object is
     *     {@link ShortHistoryType }
     *     
     */
    public ShortHistoryType getShortHistory() {
        return shortHistory;
    }

    /**
     * Define el valor de la propiedad shortHistory.
     * 
     * @param value
     *     allowed object is
     *     {@link ShortHistoryType }
     *     
     */
    public void setShortHistory(ShortHistoryType value) {
        this.shortHistory = value;
    }

    /**
     * Obtiene el valor de la propiedad state.
     * 
     * @return
     *     possible object is
     *     {@link StateEnum }
     *     
     */
    public StateEnum getState() {
        return state;
    }

    /**
     * Define el valor de la propiedad state.
     * 
     * @param value
     *     allowed object is
     *     {@link StateEnum }
     *     
     */
    public void setState(StateEnum value) {
        this.state = value;
    }

    /**
     * Obtiene el valor de la propiedad substate.
     * 
     * @return
     *     possible object is
     *     {@link SubstateEnum }
     *     
     */
    public SubstateEnum getSubstate() {
        return substate;
    }

    /**
     * Define el valor de la propiedad substate.
     * 
     * @param value
     *     allowed object is
     *     {@link SubstateEnum }
     *     
     */
    public void setSubstate(SubstateEnum value) {
        this.substate = value;
    }

    /**
     * Gets the value of the systemActions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the systemActions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSystemActions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActionType }
     * 
     * 
     */
    public List<ActionType> getSystemActions() {
        if (systemActions == null) {
            systemActions = new ArrayList<ActionType>();
        }
        return this.systemActions;
    }

    /**
     * Obtiene el valor de la propiedad systemString1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystemString1() {
        return systemString1;
    }

    /**
     * Define el valor de la propiedad systemString1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystemString1(String value) {
        this.systemString1 = value;
    }

    /**
     * Obtiene el valor de la propiedad systemString2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystemString2() {
        return systemString2;
    }

    /**
     * Define el valor de la propiedad systemString2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystemString2(String value) {
        this.systemString2 = value;
    }

    /**
     * Obtiene el valor de la propiedad systemString3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystemString3() {
        return systemString3;
    }

    /**
     * Define el valor de la propiedad systemString3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystemString3(String value) {
        this.systemString3 = value;
    }

    /**
     * Obtiene el valor de la propiedad taskGroupId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskGroupId() {
        return taskGroupId;
    }

    /**
     * Define el valor de la propiedad taskGroupId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskGroupId(String value) {
        this.taskGroupId = value;
    }

    /**
     * Obtiene el valor de la propiedad taskId.
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
     * Define el valor de la propiedad taskId.
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
     * Obtiene el valor de la propiedad taskNumber.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTaskNumber() {
        return taskNumber;
    }

    /**
     * Define el valor de la propiedad taskNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTaskNumber(BigInteger value) {
        this.taskNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad updatedBy.
     * 
     * @return
     *     possible object is
     *     {@link IdentityType }
     *     
     */
    public IdentityType getUpdatedBy() {
        return updatedBy;
    }

    /**
     * Define el valor de la propiedad updatedBy.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentityType }
     *     
     */
    public void setUpdatedBy(IdentityType value) {
        this.updatedBy = value;
    }

    /**
     * Obtiene el valor de la propiedad updatedDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUpdatedDate() {
        return updatedDate;
    }

    /**
     * Define el valor de la propiedad updatedDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUpdatedDate(XMLGregorianCalendar value) {
        this.updatedDate = value;
    }

    /**
     * Obtiene el valor de la propiedad version.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getVersion() {
        return version;
    }

    /**
     * Define el valor de la propiedad version.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setVersion(BigInteger value) {
        this.version = value;
    }

    /**
     * Obtiene el valor de la propiedad versionReason.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersionReason() {
        return versionReason;
    }

    /**
     * Define el valor de la propiedad versionReason.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersionReason(String value) {
        this.versionReason = value;
    }

    /**
     * Obtiene el valor de la propiedad taskDefinitionId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskDefinitionId() {
        return taskDefinitionId;
    }

    /**
     * Define el valor de la propiedad taskDefinitionId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskDefinitionId(String value) {
        this.taskDefinitionId = value;
    }

    /**
     * Obtiene el valor de la propiedad taskDefinitionName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskDefinitionName() {
        return taskDefinitionName;
    }

    /**
     * Define el valor de la propiedad taskDefinitionName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskDefinitionName(String value) {
        this.taskDefinitionName = value;
    }

    /**
     * Obtiene el valor de la propiedad workflowPattern.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkflowPattern() {
        return workflowPattern;
    }

    /**
     * Define el valor de la propiedad workflowPattern.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkflowPattern(String value) {
        this.workflowPattern = value;
    }

    /**
     * Obtiene el valor de la propiedad isTestTask.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsTestTask() {
        return isTestTask;
    }

    /**
     * Define el valor de la propiedad isTestTask.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsTestTask(Boolean value) {
        this.isTestTask = value;
    }

    /**
     * Obtiene el valor de la propiedad participantName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParticipantName() {
        return participantName;
    }

    /**
     * Define el valor de la propiedad participantName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParticipantName(String value) {
        this.participantName = value;
    }

    /**
     * Obtiene el valor de la propiedad readByUsers.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReadByUsers() {
        return readByUsers;
    }

    /**
     * Define el valor de la propiedad readByUsers.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReadByUsers(String value) {
        this.readByUsers = value;
    }

    /**
     * Gets the value of the reviewers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reviewers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReviewers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentityType }
     * 
     * 
     */
    public List<IdentityType> getReviewers() {
        if (reviewers == null) {
            reviewers = new ArrayList<IdentityType>();
        }
        return this.reviewers;
    }

    /**
     * Gets the value of the assignees property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assignees property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssignees().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentityType }
     * 
     * 
     */
    public List<IdentityType> getAssignees() {
        if (assignees == null) {
            assignees = new ArrayList<IdentityType>();
        }
        return this.assignees;
    }

    /**
     * Obtiene el valor de la propiedad taskGroupInstanceId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskGroupInstanceId() {
        return taskGroupInstanceId;
    }

    /**
     * Define el valor de la propiedad taskGroupInstanceId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskGroupInstanceId(String value) {
        this.taskGroupInstanceId = value;
    }

    /**
     * Obtiene el valor de la propiedad subTaskGroupInstanceId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubTaskGroupInstanceId() {
        return subTaskGroupInstanceId;
    }

    /**
     * Define el valor de la propiedad subTaskGroupInstanceId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubTaskGroupInstanceId(String value) {
        this.subTaskGroupInstanceId = value;
    }

    /**
     * Obtiene el valor de la propiedad parentTaskVersion.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getParentTaskVersion() {
        return parentTaskVersion;
    }

    /**
     * Define el valor de la propiedad parentTaskVersion.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setParentTaskVersion(BigInteger value) {
        this.parentTaskVersion = value;
    }

    /**
     * Obtiene el valor de la propiedad agRootId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAgRootId() {
        return agRootId;
    }

    /**
     * Define el valor de la propiedad agRootId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAgRootId(Long value) {
        this.agRootId = value;
    }

    /**
     * Obtiene el valor de la propiedad agMileStonePath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgMileStonePath() {
        return agMileStonePath;
    }

    /**
     * Define el valor de la propiedad agMileStonePath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgMileStonePath(String value) {
        this.agMileStonePath = value;
    }

    /**
     * Obtiene el valor de la propiedad rootTaskId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRootTaskId() {
        return rootTaskId;
    }

    /**
     * Define el valor de la propiedad rootTaskId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRootTaskId(String value) {
        this.rootTaskId = value;
    }

    /**
     * Obtiene el valor de la propiedad parentTaskId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentTaskId() {
        return parentTaskId;
    }

    /**
     * Define el valor de la propiedad parentTaskId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentTaskId(String value) {
        this.parentTaskId = value;
    }

    /**
     * Obtiene el valor de la propiedad systemStringActions.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystemStringActions() {
        return systemStringActions;
    }

    /**
     * Define el valor de la propiedad systemStringActions.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystemStringActions(String value) {
        this.systemStringActions = value;
    }

    /**
     * Gets the value of the restrictedActions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the restrictedActions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRestrictedActions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActionType }
     * 
     * 
     */
    public List<ActionType> getRestrictedActions() {
        if (restrictedActions == null) {
            restrictedActions = new ArrayList<ActionType>();
        }
        return this.restrictedActions;
    }

    /**
     * Obtiene el valor de la propiedad updatedNotificationId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdatedNotificationId() {
        return updatedNotificationId;
    }

    /**
     * Define el valor de la propiedad updatedNotificationId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdatedNotificationId(String value) {
        this.updatedNotificationId = value;
    }

    /**
     * Obtiene el valor de la propiedad stage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStage() {
        return stage;
    }

    /**
     * Define el valor de la propiedad stage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStage(String value) {
        this.stage = value;
    }

    /**
     * Gets the value of the assignmentContext property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assignmentContext property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssignmentContext().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AssignmentContextType }
     * 
     * 
     */
    public List<AssignmentContextType> getAssignmentContext() {
        if (assignmentContext == null) {
            assignmentContext = new ArrayList<AssignmentContextType>();
        }
        return this.assignmentContext;
    }

    /**
     * Gets the value of the collectionTarget property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the collectionTarget property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCollectionTarget().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CollectionTargetType }
     * 
     * 
     */
    public List<CollectionTargetType> getCollectionTarget() {
        if (collectionTarget == null) {
            collectionTarget = new ArrayList<CollectionTargetType>();
        }
        return this.collectionTarget;
    }

    /**
     * Obtiene el valor de la propiedad preActionUserSteps.
     * 
     * @return
     *     possible object is
     *     {@link PreActionUserStepsType }
     *     
     */
    public PreActionUserStepsType getPreActionUserSteps() {
        return preActionUserSteps;
    }

    /**
     * Define el valor de la propiedad preActionUserSteps.
     * 
     * @param value
     *     allowed object is
     *     {@link PreActionUserStepsType }
     *     
     */
    public void setPreActionUserSteps(PreActionUserStepsType value) {
        this.preActionUserSteps = value;
    }

    /**
     * Obtiene el valor de la propiedad aggregationTaskId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAggregationTaskId() {
        return aggregationTaskId;
    }

    /**
     * Define el valor de la propiedad aggregationTaskId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAggregationTaskId(String value) {
        this.aggregationTaskId = value;
    }

    /**
     * Obtiene el valor de la propiedad isTemplateTask.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsTemplateTask() {
        return isTemplateTask;
    }

    /**
     * Define el valor de la propiedad isTemplateTask.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsTemplateTask(Boolean value) {
        this.isTemplateTask = value;
    }

    /**
     * Obtiene el valor de la propiedad taskViewContext.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskViewContext() {
        return taskViewContext;
    }

    /**
     * Define el valor de la propiedad taskViewContext.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskViewContext(String value) {
        this.taskViewContext = value;
    }

    /**
     * Obtiene el valor de la propiedad taskNamespace.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskNamespace() {
        return taskNamespace;
    }

    /**
     * Define el valor de la propiedad taskNamespace.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskNamespace(String value) {
        this.taskNamespace = value;
    }

    /**
     * Obtiene el valor de la propiedad actionDisplayName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionDisplayName() {
        return actionDisplayName;
    }

    /**
     * Define el valor de la propiedad actionDisplayName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionDisplayName(String value) {
        this.actionDisplayName = value;
    }

    /**
     * Obtiene el valor de la propiedad timers.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimers() {
        return timers;
    }

    /**
     * Define el valor de la propiedad timers.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimers(String value) {
        this.timers = value;
    }

    /**
     * Obtiene el valor de la propiedad componentType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComponentType() {
        return componentType;
    }

    /**
     * Define el valor de la propiedad componentType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComponentType(String value) {
        this.componentType = value;
    }

    /**
     * Obtiene el valor de la propiedad activityName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityName() {
        return activityName;
    }

    /**
     * Define el valor de la propiedad activityName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityName(String value) {
        this.activityName = value;
    }

    /**
     * Obtiene el valor de la propiedad activityId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityId() {
        return activityId;
    }

    /**
     * Define el valor de la propiedad activityId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityId(String value) {
        this.activityId = value;
    }

    /**
     * Obtiene el valor de la propiedad processDueDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProcessDueDate() {
        return processDueDate;
    }

    /**
     * Define el valor de la propiedad processDueDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProcessDueDate(XMLGregorianCalendar value) {
        this.processDueDate = value;
    }

    /**
     * Obtiene el valor de la propiedad thread.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getThread() {
        return thread;
    }

    /**
     * Define el valor de la propiedad thread.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setThread(BigInteger value) {
        this.thread = value;
    }

    /**
     * Obtiene el valor de la propiedad parentThread.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getParentThread() {
        return parentThread;
    }

    /**
     * Define el valor de la propiedad parentThread.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setParentThread(BigInteger value) {
        this.parentThread = value;
    }

    /**
     * Obtiene el valor de la propiedad step.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getStep() {
        return step;
    }

    /**
     * Define el valor de la propiedad step.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setStep(BigInteger value) {
        this.step = value;
    }

    /**
     * Obtiene el valor de la propiedad visibilityRuleConditionValues.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVisibilityRuleConditionValues() {
        return visibilityRuleConditionValues;
    }

    /**
     * Define el valor de la propiedad visibilityRuleConditionValues.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVisibilityRuleConditionValues(String value) {
        this.visibilityRuleConditionValues = value;
    }

    /**
     * Obtiene el valor de la propiedad isPartialTask.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsPartialTask() {
        return isPartialTask;
    }

    /**
     * Define el valor de la propiedad isPartialTask.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsPartialTask(Boolean value) {
        this.isPartialTask = value;
    }

    /**
     * Obtiene el valor de la propiedad organizationalUnitId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizationalUnitId() {
        return organizationalUnitId;
    }

    /**
     * Define el valor de la propiedad organizationalUnitId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizationalUnitId(String value) {
        this.organizationalUnitId = value;
    }

    /**
     * Obtiene el valor de la propiedad tenantId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTenantId() {
        return tenantId;
    }

    /**
     * Define el valor de la propiedad tenantId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTenantId(String value) {
        this.tenantId = value;
    }

    /**
     * Obtiene el valor de la propiedad listBuilderId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListBuilderId() {
        return listBuilderId;
    }

    /**
     * Define el valor de la propiedad listBuilderId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListBuilderId(String value) {
        this.listBuilderId = value;
    }

    /**
     * Obtiene el valor de la propiedad caseId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseId() {
        return caseId;
    }

    /**
     * Define el valor de la propiedad caseId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseId(String value) {
        this.caseId = value;
    }

    /**
     * Obtiene el valor de la propiedad organizationalUnitName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizationalUnitName() {
        return organizationalUnitName;
    }

    /**
     * Define el valor de la propiedad organizationalUnitName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizationalUnitName(String value) {
        this.organizationalUnitName = value;
    }

    /**
     * Obtiene el valor de la propiedad swimlaneRole.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwimlaneRole() {
        return swimlaneRole;
    }

    /**
     * Define el valor de la propiedad swimlaneRole.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwimlaneRole(String value) {
        this.swimlaneRole = value;
    }

    /**
     * Obtiene el valor de la propiedad excludedParticipants.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExcludedParticipants() {
        return excludedParticipants;
    }

    /**
     * Define el valor de la propiedad excludedParticipants.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExcludedParticipants(String value) {
        this.excludedParticipants = value;
    }

    /**
     * Obtiene el valor de la propiedad timersSuspended.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTimersSuspended() {
        return timersSuspended;
    }

    /**
     * Define el valor de la propiedad timersSuspended.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTimersSuspended(Boolean value) {
        this.timersSuspended = value;
    }

    /**
     * Obtiene el valor de la propiedad tenantIdNumber.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTenantIdNumber() {
        return tenantIdNumber;
    }

    /**
     * Define el valor de la propiedad tenantIdNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTenantIdNumber(Long value) {
        this.tenantIdNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad taskAgeFromCreatedDate.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getTaskAgeFromCreatedDate() {
        return taskAgeFromCreatedDate;
    }

    /**
     * Define el valor de la propiedad taskAgeFromCreatedDate.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setTaskAgeFromCreatedDate(Duration value) {
        this.taskAgeFromCreatedDate = value;
    }

    /**
     * Obtiene el valor de la propiedad taskAgeFromAssignedDate.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getTaskAgeFromAssignedDate() {
        return taskAgeFromAssignedDate;
    }

    /**
     * Define el valor de la propiedad taskAgeFromAssignedDate.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setTaskAgeFromAssignedDate(Duration value) {
        this.taskAgeFromAssignedDate = value;
    }

    /**
     * Obtiene el valor de la propiedad taskTimeRemaining.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getTaskTimeRemaining() {
        return taskTimeRemaining;
    }

    /**
     * Define el valor de la propiedad taskTimeRemaining.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setTaskTimeRemaining(Duration value) {
        this.taskTimeRemaining = value;
    }

    /**
     * Obtiene el valor de la propiedad isDecomposedTask.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsDecomposedTask() {
        return isDecomposedTask;
    }

    /**
     * Define el valor de la propiedad isDecomposedTask.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsDecomposedTask(Boolean value) {
        this.isDecomposedTask = value;
    }

    /**
     * Obtiene el valor de la propiedad formName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormName() {
        return formName;
    }

    /**
     * Define el valor de la propiedad formName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormName(String value) {
        this.formName = value;
    }

    /**
     * Obtiene el valor de la propiedad decomposedTaskGroupInstanceId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDecomposedTaskGroupInstanceId() {
        return decomposedTaskGroupInstanceId;
    }

    /**
     * Define el valor de la propiedad decomposedTaskGroupInstanceId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDecomposedTaskGroupInstanceId(String value) {
        this.decomposedTaskGroupInstanceId = value;
    }

    /**
     * Obtiene el valor de la propiedad startTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartTime() {
        return startTime;
    }

    /**
     * Define el valor de la propiedad startTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartTime(XMLGregorianCalendar value) {
        this.startTime = value;
    }

    /**
     * Obtiene el valor de la propiedad stopTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStopTime() {
        return stopTime;
    }

    /**
     * Define el valor de la propiedad stopTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStopTime(XMLGregorianCalendar value) {
        this.stopTime = value;
    }

    /**
     * Obtiene el valor de la propiedad workingDuration.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getWorkingDuration() {
        return workingDuration;
    }

    /**
     * Define el valor de la propiedad workingDuration.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setWorkingDuration(BigInteger value) {
        this.workingDuration = value;
    }

    /**
     * Obtiene el valor de la propiedad acquiredByDisplayName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcquiredByDisplayName() {
        return acquiredByDisplayName;
    }

    /**
     * Define el valor de la propiedad acquiredByDisplayName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcquiredByDisplayName(String value) {
        this.acquiredByDisplayName = value;
    }

    /**
     * Obtiene el valor de la propiedad originalAssigneeUserDisplayName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalAssigneeUserDisplayName() {
        return originalAssigneeUserDisplayName;
    }

    /**
     * Define el valor de la propiedad originalAssigneeUserDisplayName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalAssigneeUserDisplayName(String value) {
        this.originalAssigneeUserDisplayName = value;
    }

    /**
     * Obtiene el valor de la propiedad approversDisplayNames.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproversDisplayNames() {
        return approversDisplayNames;
    }

    /**
     * Define el valor de la propiedad approversDisplayNames.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproversDisplayNames(String value) {
        this.approversDisplayNames = value;
    }

    /**
     * Obtiene el valor de la propiedad imageUrl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Define el valor de la propiedad imageUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageUrl(String value) {
        this.imageUrl = value;
    }

    /**
     * Obtiene el valor de la propiedad hiddenAttributes.
     * 
     * @return
     *     possible object is
     *     {@link HiddenAttributesType }
     *     
     */
    public HiddenAttributesType getHiddenAttributes() {
        return hiddenAttributes;
    }

    /**
     * Define el valor de la propiedad hiddenAttributes.
     * 
     * @param value
     *     allowed object is
     *     {@link HiddenAttributesType }
     *     
     */
    public void setHiddenAttributes(HiddenAttributesType value) {
        this.hiddenAttributes = value;
    }

}
