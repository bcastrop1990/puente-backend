
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
 * <p>Java class for supervisoryListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="supervisoryListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;sequence&gt;
 *           &lt;element name="levels" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}parameterType"/&gt;
 *           &lt;element name="startingPoint" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}hierarchyPrincipalType" minOccurs="0"/&gt;
 *           &lt;element name="uptoApprover" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}hierarchyPrincipalType" minOccurs="0"/&gt;
 *           &lt;element name="autoAction" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}autoActionType" minOccurs="0"/&gt;
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
@XmlType(name = "supervisoryListType", propOrder = {
    "levels",
    "startingPoint",
    "uptoApprover",
    "autoAction",
    "responseType",
    "ruleName",
    "dimensionId",
    "rulesetName",
    "ruleset"
})
public class SupervisoryListType {

    protected ParameterType levels;
    protected HierarchyPrincipalType startingPoint;
    protected HierarchyPrincipalType uptoApprover;
    protected AutoActionType autoAction;
    @XmlSchemaType(name = "string")
    protected ResponseType responseType;
    protected List<String> ruleName;
    protected String dimensionId;
    protected String rulesetName;
    protected RulesetType ruleset;

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
     * Gets the value of the startingPoint property.
     * 
     * @return
     *     possible object is
     *     {@link HierarchyPrincipalType }
     *     
     */
    public HierarchyPrincipalType getStartingPoint() {
        return startingPoint;
    }

    /**
     * Sets the value of the startingPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link HierarchyPrincipalType }
     *     
     */
    public void setStartingPoint(HierarchyPrincipalType value) {
        this.startingPoint = value;
    }

    /**
     * Gets the value of the uptoApprover property.
     * 
     * @return
     *     possible object is
     *     {@link HierarchyPrincipalType }
     *     
     */
    public HierarchyPrincipalType getUptoApprover() {
        return uptoApprover;
    }

    /**
     * Sets the value of the uptoApprover property.
     * 
     * @param value
     *     allowed object is
     *     {@link HierarchyPrincipalType }
     *     
     */
    public void setUptoApprover(HierarchyPrincipalType value) {
        this.uptoApprover = value;
    }

    /**
     * Gets the value of the autoAction property.
     * 
     * @return
     *     possible object is
     *     {@link AutoActionType }
     *     
     */
    public AutoActionType getAutoAction() {
        return autoAction;
    }

    /**
     * Sets the value of the autoAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link AutoActionType }
     *     
     */
    public void setAutoAction(AutoActionType value) {
        this.autoAction = value;
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
