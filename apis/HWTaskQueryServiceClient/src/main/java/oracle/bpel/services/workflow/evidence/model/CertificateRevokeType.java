
package oracle.bpel.services.workflow.evidence.model;

/*
 * #%L
 * TUPA: Integration: BPM-Client: HW Task Query Service Client
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
import javax.xml.datatype.XMLGregorianCalendar;
import oracle.bpel.services.workflow.common.model.WorkflowContextType;


/**
 * <p>Java class for CertificateRevokeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CertificateRevokeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/common}workflowContext" minOccurs="0"/&gt;
 *         &lt;element name="issuerName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="certificateId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="issueData" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="crlData" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CertificateRevokeType", propOrder = {
    "workflowContext",
    "issuerName",
    "certificateId",
    "issueData",
    "crlData"
})
public class CertificateRevokeType {

    @XmlElement(namespace = "http://xmlns.oracle.com/bpel/workflow/common")
    protected WorkflowContextType workflowContext;
    @XmlElement(required = true)
    protected String issuerName;
    @XmlElement(required = true)
    protected String certificateId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar issueData;
    @XmlElement(required = true)
    protected String crlData;

    /**
     * Gets the value of the workflowContext property.
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
     * Sets the value of the workflowContext property.
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
     * Gets the value of the issuerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuerName() {
        return issuerName;
    }

    /**
     * Sets the value of the issuerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuerName(String value) {
        this.issuerName = value;
    }

    /**
     * Gets the value of the certificateId property.
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
     * Sets the value of the certificateId property.
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
     * Gets the value of the issueData property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIssueData() {
        return issueData;
    }

    /**
     * Sets the value of the issueData property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIssueData(XMLGregorianCalendar value) {
        this.issueData = value;
    }

    /**
     * Gets the value of the crlData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrlData() {
        return crlData;
    }

    /**
     * Sets the value of the crlData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrlData(String value) {
        this.crlData = value;
    }

}
