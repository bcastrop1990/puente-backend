
package oracle.bpel.services.workflow.user.model;

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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import oracle.bpel.services.workflow.common.model.PrincipleListType;
import oracle.bpel.services.workflow.query.model.TaskOptionalInfoType;
import oracle.bpel.services.workflow.query.model.TaskOrderingType;


/**
 * Metadata representing how the results of a query should be presented,
 *         including which columns should be displayed, how the columns should be
 *         formatted, and how the data should be orderd.
 *         Presentations can be associated with views, and provide a way of
 *         defining a standard presentation of data that can be shared amongst
 *         multiple views.
 * 
 * <p>Java class for presentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="presentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="owner" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="identityContext" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="columns" type="{http://xmlns.oracle.com/bpel/workflow/userMetadata}columnListType"/&gt;
 *         &lt;element name="optionalInfo" type="{http://xmlns.oracle.com/bpel/workflow/taskQuery}taskOptionalInfoType" minOccurs="0"/&gt;
 *         &lt;element name="ordering" type="{http://xmlns.oracle.com/bpel/workflow/taskQuery}taskOrderingType" minOccurs="0"/&gt;
 *         &lt;element name="grantees" type="{http://xmlns.oracle.com/bpel/workflow/common}principleListType" minOccurs="0"/&gt;
 *         &lt;element name="createdDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="updatedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="createdBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="updatedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="presentationDataType" type="{http://xmlns.oracle.com/bpel/workflow/userMetadata}presentationDataTypeEnum" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "presentationType", propOrder = {
    "id",
    "name",
    "owner",
    "identityContext",
    "columns",
    "optionalInfo",
    "ordering",
    "grantees",
    "createdDate",
    "updatedDate",
    "createdBy",
    "updatedBy"
})
public class PresentationType {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String owner;
    @XmlElement(required = true)
    protected String identityContext;
    @XmlElement(required = true)
    protected ColumnListType columns;
    protected TaskOptionalInfoType optionalInfo;
    protected TaskOrderingType ordering;
    protected PrincipleListType grantees;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updatedDate;
    protected String createdBy;
    protected String updatedBy;
    @XmlAttribute(name = "presentationDataType")
    protected PresentationDataTypeEnum presentationDataType;

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
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the owner property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the value of the owner property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwner(String value) {
        this.owner = value;
    }

    /**
     * Gets the value of the identityContext property.
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
     * Sets the value of the identityContext property.
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
     * Gets the value of the columns property.
     * 
     * @return
     *     possible object is
     *     {@link ColumnListType }
     *     
     */
    public ColumnListType getColumns() {
        return columns;
    }

    /**
     * Sets the value of the columns property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColumnListType }
     *     
     */
    public void setColumns(ColumnListType value) {
        this.columns = value;
    }

    /**
     * Gets the value of the optionalInfo property.
     * 
     * @return
     *     possible object is
     *     {@link TaskOptionalInfoType }
     *     
     */
    public TaskOptionalInfoType getOptionalInfo() {
        return optionalInfo;
    }

    /**
     * Sets the value of the optionalInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskOptionalInfoType }
     *     
     */
    public void setOptionalInfo(TaskOptionalInfoType value) {
        this.optionalInfo = value;
    }

    /**
     * Gets the value of the ordering property.
     * 
     * @return
     *     possible object is
     *     {@link TaskOrderingType }
     *     
     */
    public TaskOrderingType getOrdering() {
        return ordering;
    }

    /**
     * Sets the value of the ordering property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskOrderingType }
     *     
     */
    public void setOrdering(TaskOrderingType value) {
        this.ordering = value;
    }

    /**
     * Gets the value of the grantees property.
     * 
     * @return
     *     possible object is
     *     {@link PrincipleListType }
     *     
     */
    public PrincipleListType getGrantees() {
        return grantees;
    }

    /**
     * Sets the value of the grantees property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrincipleListType }
     *     
     */
    public void setGrantees(PrincipleListType value) {
        this.grantees = value;
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
     * Gets the value of the updatedDate property.
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
     * Sets the value of the updatedDate property.
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
     * Gets the value of the createdBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the value of the createdBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedBy(String value) {
        this.createdBy = value;
    }

    /**
     * Gets the value of the updatedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * Sets the value of the updatedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdatedBy(String value) {
        this.updatedBy = value;
    }

    /**
     * Gets the value of the presentationDataType property.
     * 
     * @return
     *     possible object is
     *     {@link PresentationDataTypeEnum }
     *     
     */
    public PresentationDataTypeEnum getPresentationDataType() {
        return presentationDataType;
    }

    /**
     * Sets the value of the presentationDataType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PresentationDataTypeEnum }
     *     
     */
    public void setPresentationDataType(PresentationDataTypeEnum value) {
        this.presentationDataType = value;
    }

}
