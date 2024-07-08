
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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ucmInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ucmInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ucmError" type="{http://xmlns.oracle.com/bpel/workflow/runtimeConfig}ucmErrorType" minOccurs="0"/&gt;
 *         &lt;element name="ucmDocuments" type="{http://xmlns.oracle.com/bpel/workflow/runtimeConfig}ucmDocumentType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ucmDocTypes" type="{http://xmlns.oracle.com/bpel/workflow/runtimeConfig}ucmDocType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ucmDocFields" type="{http://xmlns.oracle.com/bpel/workflow/runtimeConfig}ucmPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ucmSecGroups" type="{http://xmlns.oracle.com/bpel/workflow/runtimeConfig}ucmSecGroupType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ucmAccounts" type="{http://xmlns.oracle.com/bpel/workflow/runtimeConfig}ucmAccountType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ucmFolders" type="{http://xmlns.oracle.com/bpel/workflow/runtimeConfig}ucmFolderType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ucmProperty" type="{http://xmlns.oracle.com/bpel/workflow/runtimeConfig}ucmPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ucmInfoType", propOrder = {
    "ucmError",
    "ucmDocuments",
    "ucmDocTypes",
    "ucmDocFields",
    "ucmSecGroups",
    "ucmAccounts",
    "ucmFolders",
    "ucmProperty"
})
public class UcmInfoType {

    protected UcmErrorType ucmError;
    protected List<UcmDocumentType> ucmDocuments;
    protected List<UcmDocType> ucmDocTypes;
    protected List<UcmPropertyType> ucmDocFields;
    protected List<UcmSecGroupType> ucmSecGroups;
    protected List<UcmAccountType> ucmAccounts;
    protected List<UcmFolderType> ucmFolders;
    protected List<UcmPropertyType> ucmProperty;

    /**
     * Gets the value of the ucmError property.
     * 
     * @return
     *     possible object is
     *     {@link UcmErrorType }
     *     
     */
    public UcmErrorType getUcmError() {
        return ucmError;
    }

    /**
     * Sets the value of the ucmError property.
     * 
     * @param value
     *     allowed object is
     *     {@link UcmErrorType }
     *     
     */
    public void setUcmError(UcmErrorType value) {
        this.ucmError = value;
    }

    /**
     * Gets the value of the ucmDocuments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ucmDocuments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUcmDocuments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UcmDocumentType }
     * 
     * 
     */
    public List<UcmDocumentType> getUcmDocuments() {
        if (ucmDocuments == null) {
            ucmDocuments = new ArrayList<UcmDocumentType>();
        }
        return this.ucmDocuments;
    }

    /**
     * Gets the value of the ucmDocTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ucmDocTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUcmDocTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UcmDocType }
     * 
     * 
     */
    public List<UcmDocType> getUcmDocTypes() {
        if (ucmDocTypes == null) {
            ucmDocTypes = new ArrayList<UcmDocType>();
        }
        return this.ucmDocTypes;
    }

    /**
     * Gets the value of the ucmDocFields property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ucmDocFields property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUcmDocFields().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UcmPropertyType }
     * 
     * 
     */
    public List<UcmPropertyType> getUcmDocFields() {
        if (ucmDocFields == null) {
            ucmDocFields = new ArrayList<UcmPropertyType>();
        }
        return this.ucmDocFields;
    }

    /**
     * Gets the value of the ucmSecGroups property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ucmSecGroups property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUcmSecGroups().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UcmSecGroupType }
     * 
     * 
     */
    public List<UcmSecGroupType> getUcmSecGroups() {
        if (ucmSecGroups == null) {
            ucmSecGroups = new ArrayList<UcmSecGroupType>();
        }
        return this.ucmSecGroups;
    }

    /**
     * Gets the value of the ucmAccounts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ucmAccounts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUcmAccounts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UcmAccountType }
     * 
     * 
     */
    public List<UcmAccountType> getUcmAccounts() {
        if (ucmAccounts == null) {
            ucmAccounts = new ArrayList<UcmAccountType>();
        }
        return this.ucmAccounts;
    }

    /**
     * Gets the value of the ucmFolders property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ucmFolders property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUcmFolders().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UcmFolderType }
     * 
     * 
     */
    public List<UcmFolderType> getUcmFolders() {
        if (ucmFolders == null) {
            ucmFolders = new ArrayList<UcmFolderType>();
        }
        return this.ucmFolders;
    }

    /**
     * Gets the value of the ucmProperty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ucmProperty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUcmProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UcmPropertyType }
     * 
     * 
     */
    public List<UcmPropertyType> getUcmProperty() {
        if (ucmProperty == null) {
            ucmProperty = new ArrayList<UcmPropertyType>();
        }
        return this.ucmProperty;
    }

}
