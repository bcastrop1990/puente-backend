
package oracle.bpel.services.workflow.task.model;

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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for scaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="scaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="applicationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="componentName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="compositeDN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="compositeInstanceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="compositeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="compositeVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ecId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="parentComponentInstanceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="parentComponentInstanceRefId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="headerProperties" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="invokedComponent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="compositeCreatedTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="componentInstanceId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="flowId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="scaPartitionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "scaType", propOrder = {
    "applicationName",
    "componentName",
    "compositeDN",
    "compositeInstanceId",
    "compositeName",
    "compositeVersion",
    "ecId",
    "parentComponentInstanceId",
    "parentComponentInstanceRefId",
    "headerProperties",
    "invokedComponent",
    "compositeCreatedTime",
    "componentInstanceId",
    "flowId",
    "scaPartitionId"
})
public class ScaType {

    protected String applicationName;
    protected String componentName;
    protected String compositeDN;
    protected String compositeInstanceId;
    protected String compositeName;
    protected String compositeVersion;
    protected String ecId;
    protected String parentComponentInstanceId;
    protected String parentComponentInstanceRefId;
    protected String headerProperties;
    protected String invokedComponent;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar compositeCreatedTime;
    protected Long componentInstanceId;
    protected Long flowId;
    protected Long scaPartitionId;

    /**
     * Gets the value of the applicationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     * Sets the value of the applicationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationName(String value) {
        this.applicationName = value;
    }

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
     * Gets the value of the ecId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEcId() {
        return ecId;
    }

    /**
     * Sets the value of the ecId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEcId(String value) {
        this.ecId = value;
    }

    /**
     * Gets the value of the parentComponentInstanceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentComponentInstanceId() {
        return parentComponentInstanceId;
    }

    /**
     * Sets the value of the parentComponentInstanceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentComponentInstanceId(String value) {
        this.parentComponentInstanceId = value;
    }

    /**
     * Gets the value of the parentComponentInstanceRefId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentComponentInstanceRefId() {
        return parentComponentInstanceRefId;
    }

    /**
     * Sets the value of the parentComponentInstanceRefId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentComponentInstanceRefId(String value) {
        this.parentComponentInstanceRefId = value;
    }

    /**
     * Gets the value of the headerProperties property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeaderProperties() {
        return headerProperties;
    }

    /**
     * Sets the value of the headerProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeaderProperties(String value) {
        this.headerProperties = value;
    }

    /**
     * Gets the value of the invokedComponent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvokedComponent() {
        return invokedComponent;
    }

    /**
     * Sets the value of the invokedComponent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvokedComponent(String value) {
        this.invokedComponent = value;
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

    /**
     * Gets the value of the componentInstanceId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getComponentInstanceId() {
        return componentInstanceId;
    }

    /**
     * Sets the value of the componentInstanceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setComponentInstanceId(Long value) {
        this.componentInstanceId = value;
    }

    /**
     * Gets the value of the flowId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFlowId() {
        return flowId;
    }

    /**
     * Sets the value of the flowId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFlowId(Long value) {
        this.flowId = value;
    }

    /**
     * Gets the value of the scaPartitionId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getScaPartitionId() {
        return scaPartitionId;
    }

    /**
     * Sets the value of the scaPartitionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setScaPartitionId(Long value) {
        this.scaPartitionId = value;
    }

}
