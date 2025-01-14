
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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ruleRepositoryInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ruleRepositoryInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ruleEngine" type="{http://xmlns.oracle.com/bpel/workflow/userMetadata}ruleEngineEnum"/&gt;
 *         &lt;element name="repositoryLocation" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="dictionaryName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="reposProperty" type="{http://xmlns.oracle.com/bpel/workflow/userMetadata}propertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ruleRepositoryInfoType", propOrder = {
    "ruleEngine",
    "repositoryLocation",
    "dictionaryName",
    "reposProperty"
})
public class RuleRepositoryInfoType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected RuleEngineEnum ruleEngine;
    @XmlElement(required = true)
    protected String repositoryLocation;
    @XmlElement(required = true)
    protected String dictionaryName;
    protected List<PropertyType> reposProperty;

    /**
     * Gets the value of the ruleEngine property.
     * 
     * @return
     *     possible object is
     *     {@link RuleEngineEnum }
     *     
     */
    public RuleEngineEnum getRuleEngine() {
        return ruleEngine;
    }

    /**
     * Sets the value of the ruleEngine property.
     * 
     * @param value
     *     allowed object is
     *     {@link RuleEngineEnum }
     *     
     */
    public void setRuleEngine(RuleEngineEnum value) {
        this.ruleEngine = value;
    }

    /**
     * Gets the value of the repositoryLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepositoryLocation() {
        return repositoryLocation;
    }

    /**
     * Sets the value of the repositoryLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepositoryLocation(String value) {
        this.repositoryLocation = value;
    }

    /**
     * Gets the value of the dictionaryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDictionaryName() {
        return dictionaryName;
    }

    /**
     * Sets the value of the dictionaryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDictionaryName(String value) {
        this.dictionaryName = value;
    }

    /**
     * Gets the value of the reposProperty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reposProperty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReposProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PropertyType }
     * 
     * 
     */
    public List<PropertyType> getReposProperty() {
        if (reposProperty == null) {
            reposProperty = new ArrayList<PropertyType>();
        }
        return this.reposProperty;
    }

}
