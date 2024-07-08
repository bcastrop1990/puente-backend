
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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for earlyCompletionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="earlyCompletionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="outcome" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="condition" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="inherit" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}earlyCompletionInheritType" /&gt;
 *       &lt;attribute name="completeTask" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}earlyCompletionCompleteType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "earlyCompletionType", propOrder = {
    "outcome"
})
public class EarlyCompletionType {

    protected List<String> outcome;
    @XmlAttribute(name = "condition")
    protected String condition;
    @XmlAttribute(name = "inherit")
    protected EarlyCompletionInheritType inherit;
    @XmlAttribute(name = "completeTask")
    protected EarlyCompletionCompleteType completeTask;

    /**
     * Gets the value of the outcome property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outcome property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutcome().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getOutcome() {
        if (outcome == null) {
            outcome = new ArrayList<String>();
        }
        return this.outcome;
    }

    /**
     * Gets the value of the condition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCondition() {
        return condition;
    }

    /**
     * Sets the value of the condition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCondition(String value) {
        this.condition = value;
    }

    /**
     * Gets the value of the inherit property.
     * 
     * @return
     *     possible object is
     *     {@link EarlyCompletionInheritType }
     *     
     */
    public EarlyCompletionInheritType getInherit() {
        return inherit;
    }

    /**
     * Sets the value of the inherit property.
     * 
     * @param value
     *     allowed object is
     *     {@link EarlyCompletionInheritType }
     *     
     */
    public void setInherit(EarlyCompletionInheritType value) {
        this.inherit = value;
    }

    /**
     * Gets the value of the completeTask property.
     * 
     * @return
     *     possible object is
     *     {@link EarlyCompletionCompleteType }
     *     
     */
    public EarlyCompletionCompleteType getCompleteTask() {
        return completeTask;
    }

    /**
     * Sets the value of the completeTask property.
     * 
     * @param value
     *     allowed object is
     *     {@link EarlyCompletionCompleteType }
     *     
     */
    public void setCompleteTask(EarlyCompletionCompleteType value) {
        this.completeTask = value;
    }

}
