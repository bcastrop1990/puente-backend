
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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oracle.bpel.services.workflow.task.model.CollectionTargetType;


/**
 * <p>Java class for systemParametersType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="systemParametersType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="parameter" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}systemParameterType" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/task}collectionTarget"/&gt;
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/routingSlip}substitutionRules"/&gt;
 *         &lt;element name="substitutionRulesParticipant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "systemParametersType", propOrder = {
    "parameter",
    "collectionTarget",
    "substitutionRules",
    "substitutionRulesParticipant"
})
public class SystemParametersType {

    @XmlElement(required = true)
    protected List<SystemParameterType> parameter;
    @XmlElement(namespace = "http://xmlns.oracle.com/bpel/workflow/task", required = true)
    protected CollectionTargetType collectionTarget;
    @XmlElement(required = true)
    protected SubstitutionRules substitutionRules;
    protected String substitutionRulesParticipant;

    /**
     * Gets the value of the parameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SystemParameterType }
     * 
     * 
     */
    public List<SystemParameterType> getParameter() {
        if (parameter == null) {
            parameter = new ArrayList<SystemParameterType>();
        }
        return this.parameter;
    }

    /**
     * Gets the value of the collectionTarget property.
     * 
     * @return
     *     possible object is
     *     {@link CollectionTargetType }
     *     
     */
    public CollectionTargetType getCollectionTarget() {
        return collectionTarget;
    }

    /**
     * Sets the value of the collectionTarget property.
     * 
     * @param value
     *     allowed object is
     *     {@link CollectionTargetType }
     *     
     */
    public void setCollectionTarget(CollectionTargetType value) {
        this.collectionTarget = value;
    }

    /**
     * Gets the value of the substitutionRules property.
     * 
     * @return
     *     possible object is
     *     {@link SubstitutionRules }
     *     
     */
    public SubstitutionRules getSubstitutionRules() {
        return substitutionRules;
    }

    /**
     * Sets the value of the substitutionRules property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubstitutionRules }
     *     
     */
    public void setSubstitutionRules(SubstitutionRules value) {
        this.substitutionRules = value;
    }

    /**
     * Gets the value of the substitutionRulesParticipant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubstitutionRulesParticipant() {
        return substitutionRulesParticipant;
    }

    /**
     * Sets the value of the substitutionRulesParticipant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubstitutionRulesParticipant(String value) {
        this.substitutionRulesParticipant = value;
    }

}
