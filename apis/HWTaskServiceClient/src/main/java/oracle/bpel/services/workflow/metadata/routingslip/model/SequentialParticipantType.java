
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
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sequentialParticipantType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sequentialParticipantType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://xmlns.oracle.com/bpel/workflow/routingSlip}genericParticipantType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="resource" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}resourceType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="list" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}listType" minOccurs="0"/&gt;
 *         &lt;element name="properties" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}propertiesType" minOccurs="0"/&gt;
 *         &lt;element name="assignmentContext" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}assignmentContextType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="dynamicAssignment" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}dynamicAssignmentType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="expirationDuration" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="systemLevels" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="moveForwardOnExpiry" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sequentialParticipantType", propOrder = {
    "resource",
    "list",
    "properties",
    "assignmentContext",
    "dynamicAssignment"
})
public class SequentialParticipantType
    extends GenericParticipantType
{

    protected List<ResourceType> resource;
    protected ListType list;
    protected PropertiesType properties;
    protected List<AssignmentContextType> assignmentContext;
    protected DynamicAssignmentType dynamicAssignment;
    @XmlAttribute(name = "expirationDuration")
    protected String expirationDuration;
    @XmlAttribute(name = "systemLevels")
    protected BigInteger systemLevels;
    @XmlAttribute(name = "moveForwardOnExpiry")
    protected Boolean moveForwardOnExpiry;

    /**
     * Gets the value of the resource property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resource property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResource().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResourceType }
     * 
     * 
     */
    public List<ResourceType> getResource() {
        if (resource == null) {
            resource = new ArrayList<ResourceType>();
        }
        return this.resource;
    }

    /**
     * Gets the value of the list property.
     * 
     * @return
     *     possible object is
     *     {@link ListType }
     *     
     */
    public ListType getList() {
        return list;
    }

    /**
     * Sets the value of the list property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListType }
     *     
     */
    public void setList(ListType value) {
        this.list = value;
    }

    /**
     * Gets the value of the properties property.
     * 
     * @return
     *     possible object is
     *     {@link PropertiesType }
     *     
     */
    public PropertiesType getProperties() {
        return properties;
    }

    /**
     * Sets the value of the properties property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertiesType }
     *     
     */
    public void setProperties(PropertiesType value) {
        this.properties = value;
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
     * Gets the value of the dynamicAssignment property.
     * 
     * @return
     *     possible object is
     *     {@link DynamicAssignmentType }
     *     
     */
    public DynamicAssignmentType getDynamicAssignment() {
        return dynamicAssignment;
    }

    /**
     * Sets the value of the dynamicAssignment property.
     * 
     * @param value
     *     allowed object is
     *     {@link DynamicAssignmentType }
     *     
     */
    public void setDynamicAssignment(DynamicAssignmentType value) {
        this.dynamicAssignment = value;
    }

    /**
     * Gets the value of the expirationDuration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpirationDuration() {
        return expirationDuration;
    }

    /**
     * Sets the value of the expirationDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpirationDuration(String value) {
        this.expirationDuration = value;
    }

    /**
     * Gets the value of the systemLevels property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSystemLevels() {
        return systemLevels;
    }

    /**
     * Sets the value of the systemLevels property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSystemLevels(BigInteger value) {
        this.systemLevels = value;
    }

    /**
     * Gets the value of the moveForwardOnExpiry property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMoveForwardOnExpiry() {
        return moveForwardOnExpiry;
    }

    /**
     * Sets the value of the moveForwardOnExpiry property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMoveForwardOnExpiry(Boolean value) {
        this.moveForwardOnExpiry = value;
    }

}
