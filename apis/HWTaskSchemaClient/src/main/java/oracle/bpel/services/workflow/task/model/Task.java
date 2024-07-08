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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import oracle.bpel.services.workflow.evidence.model.EvidenceType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="payload" type="{http://xmlns.oracle.com/bpel/workflow/task}HTResgistrarSolicitudPayloadType" minOccurs="0"/>
 *         &lt;element name="taskDefinitionURI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ownerUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ownerGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ownerRole" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="priority" type="{http://xmlns.oracle.com/bpel/workflow/task}priorityType" minOccurs="0"/>
 *         &lt;element name="packageName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="identityContext" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userComment" type="{http://xmlns.oracle.com/bpel/workflow/task}commentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="attachment" type="{http://xmlns.oracle.com/bpel/workflow/task}attachmentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="document" type="{http://xmlns.oracle.com/bpel/workflow/task}documentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="processInfo" type="{http://xmlns.oracle.com/bpel/workflow/task}processType" minOccurs="0"/>
 *         &lt;element name="systemAttributes" type="{http://xmlns.oracle.com/bpel/workflow/task}systemAttributesType" minOccurs="0"/>
 *         &lt;element name="systemMessageAttributes" type="{http://xmlns.oracle.com/bpel/workflow/task}systemMessageAttributesType" minOccurs="0"/>
 *         &lt;element name="titleResourceKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="callback" type="{http://xmlns.oracle.com/bpel/workflow/task}callbackType" minOccurs="0"/>
 *         &lt;element name="identificationKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dueDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="isPublic" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="percentageComplete" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="sca" type="{http://xmlns.oracle.com/bpel/workflow/task}scaType" minOccurs="0"/>
 *         &lt;element name="applicationContext" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="evidence" type="{http://xmlns.oracle.com/bpel/workflow/TaskEvidenceService}EvidenceType" minOccurs="0"/>
 *         &lt;element name="taskDefinitionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subcategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taskDisplayUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="documentPackageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="correlationId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mdsLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creatorDisplayName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ownerUserDisplayName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ownerGroupDisplayName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ownerRoleDisplayName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customAttributes" type="{http://xmlns.oracle.com/bpel/workflow/task}customAttributesType" minOccurs="0"/>
 *         &lt;element name="shortSummary" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="longSummary" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notificationMode" type="{http://xmlns.oracle.com/bpel/workflow/task}taskNotificationMode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "title",
    "payload",
    "taskDefinitionURI",
    "creator",
    "ownerUser",
    "ownerGroup",
    "ownerRole",
    "priority",
    "packageName",
    "identityContext",
    "userComment",
    "attachment",
    "document",
    "processInfo",
    "systemAttributes",
    "systemMessageAttributes",
    "titleResourceKey",
    "callback",
    "identificationKey",
    "category",
    "startDate",
    "dueDate",
    "isPublic",
    "percentageComplete",
    "sca",
    "applicationContext",
    "evidence",
    "taskDefinitionId",
    "subcategory",
    "taskDisplayUrl",
    "documentPackageId",
    "correlationId",
    "mdsLabel",
    "creatorDisplayName",
    "ownerUserDisplayName",
    "ownerGroupDisplayName",
    "ownerRoleDisplayName",
    "customAttributes",
    "shortSummary",
    "longSummary",
    "notificationMode"
})
@XmlRootElement(name = "task")
public class Task {

    protected String title;
    protected HTResgistrarSolicitudPayloadType payload;
    protected String taskDefinitionURI;
    protected String creator;
    protected String ownerUser;
    protected String ownerGroup;
    protected String ownerRole;
    protected BigInteger priority;
    protected String packageName;
    protected String identityContext;
    protected List<CommentType> userComment;
    protected List<AttachmentType> attachment;
    protected List<DocumentType> document;
    protected ProcessType processInfo;
    protected SystemAttributesType systemAttributes;
    protected SystemMessageAttributesType systemMessageAttributes;
    protected String titleResourceKey;
    protected CallbackType callback;
    protected String identificationKey;
    protected String category;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dueDate;
    protected Boolean isPublic;
    protected Double percentageComplete;
    protected ScaType sca;
    protected String applicationContext;
    protected EvidenceType evidence;
    protected String taskDefinitionId;
    protected String subcategory;
    protected String taskDisplayUrl;
    protected String documentPackageId;
    protected String correlationId;
    protected String mdsLabel;
    protected String creatorDisplayName;
    protected String ownerUserDisplayName;
    protected String ownerGroupDisplayName;
    protected String ownerRoleDisplayName;
    protected CustomAttributesType customAttributes;
    protected String shortSummary;
    protected String longSummary;
    @XmlSchemaType(name = "string")
    protected TaskNotificationMode notificationMode;

    /**
     * Obtiene el valor de la propiedad title.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Define el valor de la propiedad title.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Obtiene el valor de la propiedad payload.
     * 
     * @return
     *     possible object is
     *     {@link HTResgistrarSolicitudPayloadType }
     *     
     */
    public HTResgistrarSolicitudPayloadType getPayload() {
        return payload;
    }

    /**
     * Define el valor de la propiedad payload.
     * 
     * @param value
     *     allowed object is
     *     {@link HTResgistrarSolicitudPayloadType }
     *     
     */
    public void setPayload(HTResgistrarSolicitudPayloadType value) {
        this.payload = value;
    }

    /**
     * Obtiene el valor de la propiedad taskDefinitionURI.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskDefinitionURI() {
        return taskDefinitionURI;
    }

    /**
     * Define el valor de la propiedad taskDefinitionURI.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskDefinitionURI(String value) {
        this.taskDefinitionURI = value;
    }

    /**
     * Obtiene el valor de la propiedad creator.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreator() {
        return creator;
    }

    /**
     * Define el valor de la propiedad creator.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreator(String value) {
        this.creator = value;
    }

    /**
     * Obtiene el valor de la propiedad ownerUser.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerUser() {
        return ownerUser;
    }

    /**
     * Define el valor de la propiedad ownerUser.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerUser(String value) {
        this.ownerUser = value;
    }

    /**
     * Obtiene el valor de la propiedad ownerGroup.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerGroup() {
        return ownerGroup;
    }

    /**
     * Define el valor de la propiedad ownerGroup.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerGroup(String value) {
        this.ownerGroup = value;
    }

    /**
     * Obtiene el valor de la propiedad ownerRole.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerRole() {
        return ownerRole;
    }

    /**
     * Define el valor de la propiedad ownerRole.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerRole(String value) {
        this.ownerRole = value;
    }

    /**
     * Obtiene el valor de la propiedad priority.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPriority() {
        return priority;
    }

    /**
     * Define el valor de la propiedad priority.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPriority(BigInteger value) {
        this.priority = value;
    }

    /**
     * Obtiene el valor de la propiedad packageName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * Define el valor de la propiedad packageName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageName(String value) {
        this.packageName = value;
    }

    /**
     * Obtiene el valor de la propiedad identityContext.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentityContext() {
        return identityContext;
    }

    /**
     * Define el valor de la propiedad identityContext.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentityContext(String value) {
        this.identityContext = value;
    }

    /**
     * Gets the value of the userComment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userComment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserComment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommentType }
     * 
     * 
     */
    public List<CommentType> getUserComment() {
        if (userComment == null) {
            userComment = new ArrayList<CommentType>();
        }
        return this.userComment;
    }

    /**
     * Gets the value of the attachment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachmentType }
     * 
     * 
     */
    public List<AttachmentType> getAttachment() {
        if (attachment == null) {
            attachment = new ArrayList<AttachmentType>();
        }
        return this.attachment;
    }

    /**
     * Gets the value of the document property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the document property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentType }
     * 
     * 
     */
    public List<DocumentType> getDocument() {
        if (document == null) {
            document = new ArrayList<DocumentType>();
        }
        return this.document;
    }

    /**
     * Obtiene el valor de la propiedad processInfo.
     * 
     * @return
     *     possible object is
     *     {@link ProcessType }
     *     
     */
    public ProcessType getProcessInfo() {
        return processInfo;
    }

    /**
     * Define el valor de la propiedad processInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessType }
     *     
     */
    public void setProcessInfo(ProcessType value) {
        this.processInfo = value;
    }

    /**
     * Obtiene el valor de la propiedad systemAttributes.
     * 
     * @return
     *     possible object is
     *     {@link SystemAttributesType }
     *     
     */
    public SystemAttributesType getSystemAttributes() {
        return systemAttributes;
    }

    /**
     * Define el valor de la propiedad systemAttributes.
     * 
     * @param value
     *     allowed object is
     *     {@link SystemAttributesType }
     *     
     */
    public void setSystemAttributes(SystemAttributesType value) {
        this.systemAttributes = value;
    }

    /**
     * Obtiene el valor de la propiedad systemMessageAttributes.
     * 
     * @return
     *     possible object is
     *     {@link SystemMessageAttributesType }
     *     
     */
    public SystemMessageAttributesType getSystemMessageAttributes() {
        return systemMessageAttributes;
    }

    /**
     * Define el valor de la propiedad systemMessageAttributes.
     * 
     * @param value
     *     allowed object is
     *     {@link SystemMessageAttributesType }
     *     
     */
    public void setSystemMessageAttributes(SystemMessageAttributesType value) {
        this.systemMessageAttributes = value;
    }

    /**
     * Obtiene el valor de la propiedad titleResourceKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitleResourceKey() {
        return titleResourceKey;
    }

    /**
     * Define el valor de la propiedad titleResourceKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitleResourceKey(String value) {
        this.titleResourceKey = value;
    }

    /**
     * Obtiene el valor de la propiedad callback.
     * 
     * @return
     *     possible object is
     *     {@link CallbackType }
     *     
     */
    public CallbackType getCallback() {
        return callback;
    }

    /**
     * Define el valor de la propiedad callback.
     * 
     * @param value
     *     allowed object is
     *     {@link CallbackType }
     *     
     */
    public void setCallback(CallbackType value) {
        this.callback = value;
    }

    /**
     * Obtiene el valor de la propiedad identificationKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificationKey() {
        return identificationKey;
    }

    /**
     * Define el valor de la propiedad identificationKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificationKey(String value) {
        this.identificationKey = value;
    }

    /**
     * Obtiene el valor de la propiedad category.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategory() {
        return category;
    }

    /**
     * Define el valor de la propiedad category.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategory(String value) {
        this.category = value;
    }

    /**
     * Obtiene el valor de la propiedad startDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Define el valor de la propiedad startDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Obtiene el valor de la propiedad dueDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDueDate() {
        return dueDate;
    }

    /**
     * Define el valor de la propiedad dueDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDueDate(XMLGregorianCalendar value) {
        this.dueDate = value;
    }

    /**
     * Obtiene el valor de la propiedad isPublic.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsPublic() {
        return isPublic;
    }

    /**
     * Define el valor de la propiedad isPublic.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsPublic(Boolean value) {
        this.isPublic = value;
    }

    /**
     * Obtiene el valor de la propiedad percentageComplete.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPercentageComplete() {
        return percentageComplete;
    }

    /**
     * Define el valor de la propiedad percentageComplete.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPercentageComplete(Double value) {
        this.percentageComplete = value;
    }

    /**
     * Obtiene el valor de la propiedad sca.
     * 
     * @return
     *     possible object is
     *     {@link ScaType }
     *     
     */
    public ScaType getSca() {
        return sca;
    }

    /**
     * Define el valor de la propiedad sca.
     * 
     * @param value
     *     allowed object is
     *     {@link ScaType }
     *     
     */
    public void setSca(ScaType value) {
        this.sca = value;
    }

    /**
     * Obtiene el valor de la propiedad applicationContext.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationContext() {
        return applicationContext;
    }

    /**
     * Define el valor de la propiedad applicationContext.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationContext(String value) {
        this.applicationContext = value;
    }

    /**
     * Obtiene el valor de la propiedad evidence.
     * 
     * @return
     *     possible object is
     *     {@link EvidenceType }
     *     
     */
    public EvidenceType getEvidence() {
        return evidence;
    }

    /**
     * Define el valor de la propiedad evidence.
     * 
     * @param value
     *     allowed object is
     *     {@link EvidenceType }
     *     
     */
    public void setEvidence(EvidenceType value) {
        this.evidence = value;
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
     * Obtiene el valor de la propiedad subcategory.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubcategory() {
        return subcategory;
    }

    /**
     * Define el valor de la propiedad subcategory.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubcategory(String value) {
        this.subcategory = value;
    }

    /**
     * Obtiene el valor de la propiedad taskDisplayUrl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskDisplayUrl() {
        return taskDisplayUrl;
    }

    /**
     * Define el valor de la propiedad taskDisplayUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskDisplayUrl(String value) {
        this.taskDisplayUrl = value;
    }

    /**
     * Obtiene el valor de la propiedad documentPackageId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentPackageId() {
        return documentPackageId;
    }

    /**
     * Define el valor de la propiedad documentPackageId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentPackageId(String value) {
        this.documentPackageId = value;
    }

    /**
     * Obtiene el valor de la propiedad correlationId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrelationId() {
        return correlationId;
    }

    /**
     * Define el valor de la propiedad correlationId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrelationId(String value) {
        this.correlationId = value;
    }

    /**
     * Obtiene el valor de la propiedad mdsLabel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMdsLabel() {
        return mdsLabel;
    }

    /**
     * Define el valor de la propiedad mdsLabel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMdsLabel(String value) {
        this.mdsLabel = value;
    }

    /**
     * Obtiene el valor de la propiedad creatorDisplayName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatorDisplayName() {
        return creatorDisplayName;
    }

    /**
     * Define el valor de la propiedad creatorDisplayName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatorDisplayName(String value) {
        this.creatorDisplayName = value;
    }

    /**
     * Obtiene el valor de la propiedad ownerUserDisplayName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerUserDisplayName() {
        return ownerUserDisplayName;
    }

    /**
     * Define el valor de la propiedad ownerUserDisplayName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerUserDisplayName(String value) {
        this.ownerUserDisplayName = value;
    }

    /**
     * Obtiene el valor de la propiedad ownerGroupDisplayName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerGroupDisplayName() {
        return ownerGroupDisplayName;
    }

    /**
     * Define el valor de la propiedad ownerGroupDisplayName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerGroupDisplayName(String value) {
        this.ownerGroupDisplayName = value;
    }

    /**
     * Obtiene el valor de la propiedad ownerRoleDisplayName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerRoleDisplayName() {
        return ownerRoleDisplayName;
    }

    /**
     * Define el valor de la propiedad ownerRoleDisplayName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerRoleDisplayName(String value) {
        this.ownerRoleDisplayName = value;
    }

    /**
     * Obtiene el valor de la propiedad customAttributes.
     * 
     * @return
     *     possible object is
     *     {@link CustomAttributesType }
     *     
     */
    public CustomAttributesType getCustomAttributes() {
        return customAttributes;
    }

    /**
     * Define el valor de la propiedad customAttributes.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomAttributesType }
     *     
     */
    public void setCustomAttributes(CustomAttributesType value) {
        this.customAttributes = value;
    }

    /**
     * Obtiene el valor de la propiedad shortSummary.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortSummary() {
        return shortSummary;
    }

    /**
     * Define el valor de la propiedad shortSummary.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortSummary(String value) {
        this.shortSummary = value;
    }

    /**
     * Obtiene el valor de la propiedad longSummary.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongSummary() {
        return longSummary;
    }

    /**
     * Define el valor de la propiedad longSummary.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongSummary(String value) {
        this.longSummary = value;
    }

    /**
     * Obtiene el valor de la propiedad notificationMode.
     * 
     * @return
     *     possible object is
     *     {@link TaskNotificationMode }
     *     
     */
    public TaskNotificationMode getNotificationMode() {
        return notificationMode;
    }

    /**
     * Define el valor de la propiedad notificationMode.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskNotificationMode }
     *     
     */
    public void setNotificationMode(TaskNotificationMode value) {
        this.notificationMode = value;
    }

}
