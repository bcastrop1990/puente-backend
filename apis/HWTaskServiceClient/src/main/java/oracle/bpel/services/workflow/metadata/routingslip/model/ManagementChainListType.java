
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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for managementChainListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="managementChainListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;sequence&gt;
 *           &lt;element name="resource" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}resourceType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *           &lt;element name="acquiredBy" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}parameterType" minOccurs="0"/&gt;
 *           &lt;element name="levels" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}parameterType"/&gt;
 *           &lt;element name="title" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}parameterType" minOccurs="0"/&gt;
 *           &lt;element name="responseType" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}responseType" minOccurs="0"/&gt;
 *           &lt;element name="ruleName" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *           &lt;element name="dimensionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *           &lt;element name="rulesetName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *         &lt;element name="ruleset" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}rulesetType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "managementChainListType", propOrder = {
    "resource",
    "acquiredBy",
    "levels",
    "title",
    "responseType",
    "ruleName",
    "dimensionId",
    "rulesetName",
    "ruleset"
})
public class ManagementChainListType {

    protected List<ResourceType> resource;
    protected ParameterType acquiredBy;
    protected ParameterType levels;
    protected ParameterType title;
    @XmlSchemaType(name = "string")
    protected ResponseType responseType;
    protected List<String> ruleName;
    protected String dimensionId;
    protected String rulesetName;
    protected RulesetType ruleset;

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
     * Gets the value of the acquiredBy property.
     * 
     * @return
     *     possible object is
     *     {@link ParameterType }
     *     
     */
    public ParameterType getAcquiredBy() {
        return acquiredBy;
    }

    /**
     * Sets the value of the acquiredBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParameterType }
     *     
     */
    public void setAcquiredBy(ParameterType value) {
        this.acquiredBy = value;
    }

    /**
     * Gets the value of the levels property.
     * 
     * @return
     *     possible object is
     *     {@link ParameterType }
     *     
     */
    public ParameterType getLevels() {
        return levels;
    }

    /**
     * Sets the value of the levels property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParameterType }
     *     
     */
    public void setLevels(ParameterType value) {
        this.levels = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link ParameterType }
     *     
     */
    public ParameterType getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParameterType }
     *     
     */
    public void setTitle(ParameterType value) {
        this.title = value;
    }

    /**
     * Gets the value of the responseType property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseType }
     *     
     */
    public ResponseType getResponseType() {
        return responseType;
    }

    /**
     * Sets the value of the responseType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseType }
     *     
     */
    public void setResponseType(ResponseType value) {
        this.responseType = value;
    }

    /**
     * Gets the value of the ruleName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ruleName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRuleName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getRuleName() {
        if (ruleName == null) {
            ruleName = new ArrayList<String>();
        }
        return this.ruleName;
    }

    /**
     * Gets the value of the dimensionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDimensionId() {
        return dimensionId;
    }

    /**
     * Sets the value of the dimensionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDimensionId(String value) {
        this.dimensionId = value;
    }

    /**
     * Gets the value of the rulesetName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRulesetName() {
        return rulesetName;
    }

    /**
     * Sets the value of the rulesetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRulesetName(String value) {
        this.rulesetName = value;
    }

    /**
     * Gets the value of the ruleset property.
     * 
     * @return
     *     possible object is
     *     {@link RulesetType }
     *     
     */
    public RulesetType getRuleset() {
        return ruleset;
    }

    /**
     * Sets the value of the ruleset property.
     * 
     * @param value
     *     allowed object is
     *     {@link RulesetType }
     *     
     */
    public void setRuleset(RulesetType value) {
        this.ruleset = value;
    }

}
