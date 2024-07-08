
package oracle.bpel.services.workflow.runtimeconfig.model;

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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for payloadMappingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="payloadMappingType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="label" type="{http://xmlns.oracle.com/bpel/workflow/runtimeConfig}attributeLabelType"/&gt;
 *         &lt;element name="payloadAttribute" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="xpath" type="{http://xmlns.oracle.com/bpel/workflow/runtimeConfig}xpathType" minOccurs="0"/&gt;
 *         &lt;element name="createdDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="componentType" type="{http://xmlns.oracle.com/bpel/workflow/runtimeConfig}componentTypeEnum" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="workflowId" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="taskDefinitionNamespace" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="forAllTaskVersions" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "payloadMappingType", propOrder = {
    "label",
    "payloadAttribute",
    "xpath",
    "createdDate",
    "description",
    "componentType"
})
public class PayloadMappingType {

    @XmlElement(required = true)
    protected AttributeLabelType label;
    @XmlElement(required = true)
    protected String payloadAttribute;
    protected XpathType xpath;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdDate;
    protected String description;
    @XmlSchemaType(name = "string")
    protected ComponentTypeEnum componentType;
    @XmlAttribute(name = "workflowId")
    protected String workflowId;
    @XmlAttribute(name = "taskDefinitionNamespace")
    protected String taskDefinitionNamespace;
    @XmlAttribute(name = "forAllTaskVersions")
    protected Boolean forAllTaskVersions;

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link AttributeLabelType }
     *     
     */
    public AttributeLabelType getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributeLabelType }
     *     
     */
    public void setLabel(AttributeLabelType value) {
        this.label = value;
    }

    /**
     * Gets the value of the payloadAttribute property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayloadAttribute() {
        return payloadAttribute;
    }

    /**
     * Sets the value of the payloadAttribute property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayloadAttribute(String value) {
        this.payloadAttribute = value;
    }

    /**
     * Gets the value of the xpath property.
     * 
     * @return
     *     possible object is
     *     {@link XpathType }
     *     
     */
    public XpathType getXpath() {
        return xpath;
    }

    /**
     * Sets the value of the xpath property.
     * 
     * @param value
     *     allowed object is
     *     {@link XpathType }
     *     
     */
    public void setXpath(XpathType value) {
        this.xpath = value;
    }

    /**
     * Gets the value of the createdDate property.
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
     * Sets the value of the createdDate property.
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
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the componentType property.
     * 
     * @return
     *     possible object is
     *     {@link ComponentTypeEnum }
     *     
     */
    public ComponentTypeEnum getComponentType() {
        return componentType;
    }

    /**
     * Sets the value of the componentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComponentTypeEnum }
     *     
     */
    public void setComponentType(ComponentTypeEnum value) {
        this.componentType = value;
    }

    /**
     * Gets the value of the workflowId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkflowId() {
        return workflowId;
    }

    /**
     * Sets the value of the workflowId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkflowId(String value) {
        this.workflowId = value;
    }

    /**
     * Gets the value of the taskDefinitionNamespace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskDefinitionNamespace() {
        return taskDefinitionNamespace;
    }

    /**
     * Sets the value of the taskDefinitionNamespace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskDefinitionNamespace(String value) {
        this.taskDefinitionNamespace = value;
    }

    /**
     * Gets the value of the forAllTaskVersions property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isForAllTaskVersions() {
        if (forAllTaskVersions == null) {
            return false;
        } else {
            return forAllTaskVersions;
        }
    }

    /**
     * Sets the value of the forAllTaskVersions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setForAllTaskVersions(Boolean value) {
        this.forAllTaskVersions = value;
    }

}
