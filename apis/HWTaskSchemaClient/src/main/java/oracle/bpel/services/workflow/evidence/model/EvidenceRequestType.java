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
import oracle.bpel.services.workflow.common.model.WorkflowContextType;


/**
 * <p>Clase Java para EvidenceRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EvidenceRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/common}workflowContext" minOccurs="0"/>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fromSignedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="toSignedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="taskNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="signaturePolicy" type="{http://xmlns.oracle.com/bpel/workflow/TaskEvidenceService}PolicyEnumType" minOccurs="0"/>
 *         &lt;element name="signedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="signatureStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="verifiedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="taskOutcome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="operator" type="{http://xmlns.oracle.com/bpel/workflow/TaskEvidenceService}PolicyEnumType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EvidenceRequestType", propOrder = {
    "workflowContext",
    "userName",
    "fromSignedDate",
    "toSignedDate",
    "taskNumber",
    "signaturePolicy",
    "signedDate",
    "signatureStatus",
    "verifiedDate",
    "taskOutcome",
    "operator"
})
public class EvidenceRequestType {

    @XmlElement(namespace = "http://xmlns.oracle.com/bpel/workflow/common")
    protected WorkflowContextType workflowContext;
    protected String userName;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fromSignedDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar toSignedDate;
    protected Integer taskNumber;
    @XmlSchemaType(name = "string")
    protected PolicyEnumType signaturePolicy;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar signedDate;
    protected String signatureStatus;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar verifiedDate;
    @XmlElement(required = true)
    protected String taskOutcome;
    @XmlSchemaType(name = "string")
    protected PolicyEnumType operator;

    /**
     * Obtiene el valor de la propiedad workflowContext.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowContextType }
     *     
     */
    public WorkflowContextType getWorkflowContext() {
        return workflowContext;
    }

    /**
     * Define el valor de la propiedad workflowContext.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowContextType }
     *     
     */
    public void setWorkflowContext(WorkflowContextType value) {
        this.workflowContext = value;
    }

    /**
     * Obtiene el valor de la propiedad userName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Define el valor de la propiedad userName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Obtiene el valor de la propiedad fromSignedDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFromSignedDate() {
        return fromSignedDate;
    }

    /**
     * Define el valor de la propiedad fromSignedDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFromSignedDate(XMLGregorianCalendar value) {
        this.fromSignedDate = value;
    }

    /**
     * Obtiene el valor de la propiedad toSignedDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getToSignedDate() {
        return toSignedDate;
    }

    /**
     * Define el valor de la propiedad toSignedDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setToSignedDate(XMLGregorianCalendar value) {
        this.toSignedDate = value;
    }

    /**
     * Obtiene el valor de la propiedad taskNumber.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTaskNumber() {
        return taskNumber;
    }

    /**
     * Define el valor de la propiedad taskNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTaskNumber(Integer value) {
        this.taskNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad signaturePolicy.
     * 
     * @return
     *     possible object is
     *     {@link PolicyEnumType }
     *     
     */
    public PolicyEnumType getSignaturePolicy() {
        return signaturePolicy;
    }

    /**
     * Define el valor de la propiedad signaturePolicy.
     * 
     * @param value
     *     allowed object is
     *     {@link PolicyEnumType }
     *     
     */
    public void setSignaturePolicy(PolicyEnumType value) {
        this.signaturePolicy = value;
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
     * Obtiene el valor de la propiedad signatureStatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignatureStatus() {
        return signatureStatus;
    }

    /**
     * Define el valor de la propiedad signatureStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignatureStatus(String value) {
        this.signatureStatus = value;
    }

    /**
     * Obtiene el valor de la propiedad verifiedDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getVerifiedDate() {
        return verifiedDate;
    }

    /**
     * Define el valor de la propiedad verifiedDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setVerifiedDate(XMLGregorianCalendar value) {
        this.verifiedDate = value;
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
     * Obtiene el valor de la propiedad operator.
     * 
     * @return
     *     possible object is
     *     {@link PolicyEnumType }
     *     
     */
    public PolicyEnumType getOperator() {
        return operator;
    }

    /**
     * Define el valor de la propiedad operator.
     * 
     * @param value
     *     allowed object is
     *     {@link PolicyEnumType }
     *     
     */
    public void setOperator(PolicyEnumType value) {
        this.operator = value;
    }

}
