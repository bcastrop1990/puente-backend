
package oracle.bpel.services.workflow.task.error.model;

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
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="taskId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="taskNumber" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="taskVersion" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="taskDefinitionId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="errorId" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="errorArgs" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="errorMessage" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="errorDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="errorStackTrace" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="errorType" type="{http://xmlns.oracle.com/bpel/workflow/taskError}errorType"/&gt;
 *         &lt;element name="isRecoverable" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="sca"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="componentName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="compositeDN" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="compositeName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="compositeVersion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="compositeInstanceId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="ecid" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="compositeCreatedTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="faultCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="taskName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="submittedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="submittedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ruleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="errorParameters" type="{http://xmlns.oracle.com/bpel/workflow/taskError}errorParameterListType" minOccurs="0"/&gt;
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
    "id",
    "taskId",
    "taskNumber",
    "taskVersion",
    "taskDefinitionId",
    "errorId",
    "errorArgs",
    "errorMessage",
    "errorDate",
    "errorStackTrace",
    "errorType",
    "isRecoverable",
    "sca",
    "faultCode",
    "taskName",
    "submittedDate",
    "submittedBy",
    "ruleName",
    "errorParameters"
})
@XmlRootElement(name = "taskError")
public class TaskError {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String taskId;
    @XmlElement(required = true)
    protected BigInteger taskNumber;
    @XmlElement(required = true)
    protected BigInteger taskVersion;
    @XmlElement(required = true)
    protected String taskDefinitionId;
    @XmlElement(required = true)
    protected BigInteger errorId;
    @XmlElement(required = true)
    protected String errorArgs;
    @XmlElement(required = true)
    protected String errorMessage;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar errorDate;
    @XmlElement(required = true)
    protected String errorStackTrace;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ErrorType errorType;
    protected boolean isRecoverable;
    @XmlElement(required = true)
    protected TaskError.Sca sca;
    protected String faultCode;
    protected String taskName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar submittedDate;
    protected String submittedBy;
    protected String ruleName;
    protected ErrorParameterListType errorParameters;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
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
     * Gets the value of the taskNumber property.
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
     * Sets the value of the taskNumber property.
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
     * Gets the value of the taskVersion property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTaskVersion() {
        return taskVersion;
    }

    /**
     * Sets the value of the taskVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTaskVersion(BigInteger value) {
        this.taskVersion = value;
    }

    /**
     * Gets the value of the taskDefinitionId property.
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
     * Sets the value of the taskDefinitionId property.
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
     * Gets the value of the errorId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getErrorId() {
        return errorId;
    }

    /**
     * Sets the value of the errorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setErrorId(BigInteger value) {
        this.errorId = value;
    }

    /**
     * Gets the value of the errorArgs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorArgs() {
        return errorArgs;
    }

    /**
     * Sets the value of the errorArgs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorArgs(String value) {
        this.errorArgs = value;
    }

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the errorDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getErrorDate() {
        return errorDate;
    }

    /**
     * Sets the value of the errorDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setErrorDate(XMLGregorianCalendar value) {
        this.errorDate = value;
    }

    /**
     * Gets the value of the errorStackTrace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorStackTrace() {
        return errorStackTrace;
    }

    /**
     * Sets the value of the errorStackTrace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorStackTrace(String value) {
        this.errorStackTrace = value;
    }

    /**
     * Gets the value of the errorType property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorType }
     *     
     */
    public ErrorType getErrorType() {
        return errorType;
    }

    /**
     * Sets the value of the errorType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorType }
     *     
     */
    public void setErrorType(ErrorType value) {
        this.errorType = value;
    }

    /**
     * Gets the value of the isRecoverable property.
     * 
     */
    public boolean isIsRecoverable() {
        return isRecoverable;
    }

    /**
     * Sets the value of the isRecoverable property.
     * 
     */
    public void setIsRecoverable(boolean value) {
        this.isRecoverable = value;
    }

    /**
     * Gets the value of the sca property.
     * 
     * @return
     *     possible object is
     *     {@link TaskError.Sca }
     *     
     */
    public TaskError.Sca getSca() {
        return sca;
    }

    /**
     * Sets the value of the sca property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskError.Sca }
     *     
     */
    public void setSca(TaskError.Sca value) {
        this.sca = value;
    }

    /**
     * Gets the value of the faultCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaultCode() {
        return faultCode;
    }

    /**
     * Sets the value of the faultCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaultCode(String value) {
        this.faultCode = value;
    }

    /**
     * Gets the value of the taskName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * Sets the value of the taskName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskName(String value) {
        this.taskName = value;
    }

    /**
     * Gets the value of the submittedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSubmittedDate() {
        return submittedDate;
    }

    /**
     * Sets the value of the submittedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSubmittedDate(XMLGregorianCalendar value) {
        this.submittedDate = value;
    }

    /**
     * Gets the value of the submittedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmittedBy() {
        return submittedBy;
    }

    /**
     * Sets the value of the submittedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmittedBy(String value) {
        this.submittedBy = value;
    }

    /**
     * Gets the value of the ruleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuleName() {
        return ruleName;
    }

    /**
     * Sets the value of the ruleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuleName(String value) {
        this.ruleName = value;
    }

    /**
     * Gets the value of the errorParameters property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorParameterListType }
     *     
     */
    public ErrorParameterListType getErrorParameters() {
        return errorParameters;
    }

    /**
     * Sets the value of the errorParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorParameterListType }
     *     
     */
    public void setErrorParameters(ErrorParameterListType value) {
        this.errorParameters = value;
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
     *         &lt;element name="componentName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="compositeDN" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="compositeName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="compositeVersion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="compositeInstanceId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="ecid" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="compositeCreatedTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
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
        "componentName",
        "compositeDN",
        "compositeName",
        "compositeVersion",
        "compositeInstanceId",
        "ecid",
        "compositeCreatedTime"
    })
    public static class Sca {

        @XmlElement(required = true)
        protected String componentName;
        @XmlElement(required = true)
        protected String compositeDN;
        @XmlElement(required = true)
        protected String compositeName;
        @XmlElement(required = true)
        protected String compositeVersion;
        @XmlElement(required = true)
        protected String compositeInstanceId;
        @XmlElement(required = true)
        protected String ecid;
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar compositeCreatedTime;

        /**
         * Gets the value of the componentName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getComponentName() {
            return componentName;
        }

        /**
         * Sets the value of the componentName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setComponentName(String value) {
            this.componentName = value;
        }

        /**
         * Gets the value of the compositeDN property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCompositeDN() {
            return compositeDN;
        }

        /**
         * Sets the value of the compositeDN property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCompositeDN(String value) {
            this.compositeDN = value;
        }

        /**
         * Gets the value of the compositeName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCompositeName() {
            return compositeName;
        }

        /**
         * Sets the value of the compositeName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCompositeName(String value) {
            this.compositeName = value;
        }

        /**
         * Gets the value of the compositeVersion property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCompositeVersion() {
            return compositeVersion;
        }

        /**
         * Sets the value of the compositeVersion property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCompositeVersion(String value) {
            this.compositeVersion = value;
        }

        /**
         * Gets the value of the compositeInstanceId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCompositeInstanceId() {
            return compositeInstanceId;
        }

        /**
         * Sets the value of the compositeInstanceId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCompositeInstanceId(String value) {
            this.compositeInstanceId = value;
        }

        /**
         * Gets the value of the ecid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEcid() {
            return ecid;
        }

        /**
         * Sets the value of the ecid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEcid(String value) {
            this.ecid = value;
        }

        /**
         * Gets the value of the compositeCreatedTime property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getCompositeCreatedTime() {
            return compositeCreatedTime;
        }

        /**
         * Sets the value of the compositeCreatedTime property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setCompositeCreatedTime(XMLGregorianCalendar value) {
            this.compositeCreatedTime = value;
        }

    }

}
