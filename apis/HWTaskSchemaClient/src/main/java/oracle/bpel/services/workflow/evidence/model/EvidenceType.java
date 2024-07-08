//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.05.21 a las 01:14:30 PM COT 
//


package oracle.bpel.services.workflow.evidence.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para EvidenceType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EvidenceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="evidenceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="taskId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="taskNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="taskVersion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="taskPriority" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="taskTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="taskStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="taskSubStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="taskOutcome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="wfType" type="{http://xmlns.oracle.com/bpel/workflow/TaskEvidenceService}WFTypeEnumType"/>
 *         &lt;element name="certIssuerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="certificateId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="policy" type="{http://xmlns.oracle.com/bpel/workflow/TaskEvidenceService}PolicyEnumType"/>
 *         &lt;element name="plainText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="plainTextEnc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="signature" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="createDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="signedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="UpdatableEvidenceAttributes" type="{http://xmlns.oracle.com/bpel/workflow/TaskEvidenceService}UpdatableEvidenceAttributesType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EvidenceType", propOrder = {
    "evidenceId",
    "taskId",
    "taskNumber",
    "taskVersion",
    "taskPriority",
    "taskTitle",
    "taskStatus",
    "taskSubStatus",
    "taskOutcome",
    "wfType",
    "certIssuerName",
    "certificateId",
    "policy",
    "plainText",
    "plainTextEnc",
    "signature",
    "createDate",
    "signedDate",
    "updatableEvidenceAttributes"
})
public class EvidenceType {

    @XmlElement(required = true)
    protected String evidenceId;
    @XmlElement(required = true)
    protected String taskId;
    protected int taskNumber;
    protected int taskVersion;
    protected int taskPriority;
    @XmlElement(required = true)
    protected String taskTitle;
    @XmlElement(required = true)
    protected String taskStatus;
    @XmlElement(required = true)
    protected String taskSubStatus;
    @XmlElement(required = true)
    protected String taskOutcome;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected WFTypeEnumType wfType;
    protected String certIssuerName;
    protected String certificateId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected PolicyEnumType policy;
    @XmlElement(required = true)
    protected String plainText;
    @XmlElement(required = true)
    protected String plainTextEnc;
    @XmlElement(required = true)
    protected String signature;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar signedDate;
    @XmlElement(name = "UpdatableEvidenceAttributes", required = true)
    protected UpdatableEvidenceAttributesType updatableEvidenceAttributes;

    /**
     * Obtiene el valor de la propiedad evidenceId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvidenceId() {
        return evidenceId;
    }

    /**
     * Define el valor de la propiedad evidenceId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvidenceId(String value) {
        this.evidenceId = value;
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
     */
    public int getTaskNumber() {
        return taskNumber;
    }

    /**
     * Define el valor de la propiedad taskNumber.
     * 
     */
    public void setTaskNumber(int value) {
        this.taskNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad taskVersion.
     * 
     */
    public int getTaskVersion() {
        return taskVersion;
    }

    /**
     * Define el valor de la propiedad taskVersion.
     * 
     */
    public void setTaskVersion(int value) {
        this.taskVersion = value;
    }

    /**
     * Obtiene el valor de la propiedad taskPriority.
     * 
     */
    public int getTaskPriority() {
        return taskPriority;
    }

    /**
     * Define el valor de la propiedad taskPriority.
     * 
     */
    public void setTaskPriority(int value) {
        this.taskPriority = value;
    }

    /**
     * Obtiene el valor de la propiedad taskTitle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskTitle() {
        return taskTitle;
    }

    /**
     * Define el valor de la propiedad taskTitle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskTitle(String value) {
        this.taskTitle = value;
    }

    /**
     * Obtiene el valor de la propiedad taskStatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskStatus() {
        return taskStatus;
    }

    /**
     * Define el valor de la propiedad taskStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskStatus(String value) {
        this.taskStatus = value;
    }

    /**
     * Obtiene el valor de la propiedad taskSubStatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskSubStatus() {
        return taskSubStatus;
    }

    /**
     * Define el valor de la propiedad taskSubStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskSubStatus(String value) {
        this.taskSubStatus = value;
    }

    /**
     * Obtiene el valor de la propiedad taskOutcome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskOutcome() {
        return taskOutcome;
    }

    /**
     * Define el valor de la propiedad taskOutcome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskOutcome(String value) {
        this.taskOutcome = value;
    }

    /**
     * Obtiene el valor de la propiedad wfType.
     * 
     * @return
     *     possible object is
     *     {@link WFTypeEnumType }
     *     
     */
    public WFTypeEnumType getWfType() {
        return wfType;
    }

    /**
     * Define el valor de la propiedad wfType.
     * 
     * @param value
     *     allowed object is
     *     {@link WFTypeEnumType }
     *     
     */
    public void setWfType(WFTypeEnumType value) {
        this.wfType = value;
    }

    /**
     * Obtiene el valor de la propiedad certIssuerName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertIssuerName() {
        return certIssuerName;
    }

    /**
     * Define el valor de la propiedad certIssuerName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertIssuerName(String value) {
        this.certIssuerName = value;
    }

    /**
     * Obtiene el valor de la propiedad certificateId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificateId() {
        return certificateId;
    }

    /**
     * Define el valor de la propiedad certificateId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificateId(String value) {
        this.certificateId = value;
    }

    /**
     * Obtiene el valor de la propiedad policy.
     * 
     * @return
     *     possible object is
     *     {@link PolicyEnumType }
     *     
     */
    public PolicyEnumType getPolicy() {
        return policy;
    }

    /**
     * Define el valor de la propiedad policy.
     * 
     * @param value
     *     allowed object is
     *     {@link PolicyEnumType }
     *     
     */
    public void setPolicy(PolicyEnumType value) {
        this.policy = value;
    }

    /**
     * Obtiene el valor de la propiedad plainText.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlainText() {
        return plainText;
    }

    /**
     * Define el valor de la propiedad plainText.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlainText(String value) {
        this.plainText = value;
    }

    /**
     * Obtiene el valor de la propiedad plainTextEnc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlainTextEnc() {
        return plainTextEnc;
    }

    /**
     * Define el valor de la propiedad plainTextEnc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlainTextEnc(String value) {
        this.plainTextEnc = value;
    }

    /**
     * Obtiene el valor de la propiedad signature.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Define el valor de la propiedad signature.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignature(String value) {
        this.signature = value;
    }

    /**
     * Obtiene el valor de la propiedad createDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreateDate() {
        return createDate;
    }

    /**
     * Define el valor de la propiedad createDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreateDate(XMLGregorianCalendar value) {
        this.createDate = value;
    }

    /**
     * Obtiene el valor de la propiedad signedDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSignedDate() {
        return signedDate;
    }

    /**
     * Define el valor de la propiedad signedDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSignedDate(XMLGregorianCalendar value) {
        this.signedDate = value;
    }

    /**
     * Obtiene el valor de la propiedad updatableEvidenceAttributes.
     * 
     * @return
     *     possible object is
     *     {@link UpdatableEvidenceAttributesType }
     *     
     */
    public UpdatableEvidenceAttributesType getUpdatableEvidenceAttributes() {
        return updatableEvidenceAttributes;
    }

    /**
     * Define el valor de la propiedad updatableEvidenceAttributes.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdatableEvidenceAttributesType }
     *     
     */
    public void setUpdatableEvidenceAttributes(UpdatableEvidenceAttributesType value) {
        this.updatableEvidenceAttributes = value;
    }

}
