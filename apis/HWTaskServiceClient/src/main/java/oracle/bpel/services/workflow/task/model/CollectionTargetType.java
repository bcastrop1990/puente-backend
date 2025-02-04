
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

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for collectionTargetType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="collectionTargetType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="xpath" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="collectionName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="type" type="{http://xmlns.oracle.com/bpel/workflow/task}collectionTargetTypeEnum"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="targetIndex" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *           &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/task}keyList"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="referencedTaskId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="taskAggregationId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="action" type="{http://xmlns.oracle.com/bpel/workflow/task}collectionTargetActionType" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="displayName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "collectionTargetType", propOrder = {
    "id",
    "xpath",
    "collectionName",
    "type",
    "targetIndex",
    "keyList",
    "referencedTaskId",
    "taskAggregationId",
    "action",
    "status",
    "displayName"
})
public class CollectionTargetType {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String xpath;
    @XmlElement(required = true)
    protected String collectionName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected CollectionTargetTypeEnum type;
    protected BigInteger targetIndex;
    protected KeyListType keyList;
    protected String referencedTaskId;
    protected String taskAggregationId;
    protected CollectionTargetActionType action;
    protected String status;
    protected String displayName;

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
     * Gets the value of the xpath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXpath() {
        return xpath;
    }

    /**
     * Sets the value of the xpath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXpath(String value) {
        this.xpath = value;
    }

    /**
     * Gets the value of the collectionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollectionName() {
        return collectionName;
    }

    /**
     * Sets the value of the collectionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollectionName(String value) {
        this.collectionName = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link CollectionTargetTypeEnum }
     *     
     */
    public CollectionTargetTypeEnum getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link CollectionTargetTypeEnum }
     *     
     */
    public void setType(CollectionTargetTypeEnum value) {
        this.type = value;
    }

    /**
     * Gets the value of the targetIndex property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTargetIndex() {
        return targetIndex;
    }

    /**
     * Sets the value of the targetIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTargetIndex(BigInteger value) {
        this.targetIndex = value;
    }

    /**
     * Gets the value of the keyList property.
     * 
     * @return
     *     possible object is
     *     {@link KeyListType }
     *     
     */
    public KeyListType getKeyList() {
        return keyList;
    }

    /**
     * Sets the value of the keyList property.
     * 
     * @param value
     *     allowed object is
     *     {@link KeyListType }
     *     
     */
    public void setKeyList(KeyListType value) {
        this.keyList = value;
    }

    /**
     * Gets the value of the referencedTaskId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferencedTaskId() {
        return referencedTaskId;
    }

    /**
     * Sets the value of the referencedTaskId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferencedTaskId(String value) {
        this.referencedTaskId = value;
    }

    /**
     * Gets the value of the taskAggregationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskAggregationId() {
        return taskAggregationId;
    }

    /**
     * Sets the value of the taskAggregationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskAggregationId(String value) {
        this.taskAggregationId = value;
    }

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link CollectionTargetActionType }
     *     
     */
    public CollectionTargetActionType getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link CollectionTargetActionType }
     *     
     */
    public void setAction(CollectionTargetActionType value) {
        this.action = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the displayName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the value of the displayName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayName(String value) {
        this.displayName = value;
    }

}
