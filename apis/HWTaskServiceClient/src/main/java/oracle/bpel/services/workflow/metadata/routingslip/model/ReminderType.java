
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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for reminderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="reminderType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="reminderDuration" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="recurrence" use="required" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}recurrenceType" /&gt;
 *       &lt;attribute name="relativeDate" use="required" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}relativeDateType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reminderType")
public class ReminderType {

    @XmlAttribute(name = "reminderDuration", required = true)
    protected String reminderDuration;
    @XmlAttribute(name = "recurrence", required = true)
    protected String recurrence;
    @XmlAttribute(name = "relativeDate", required = true)
    protected RelativeDateType relativeDate;

    /**
     * Gets the value of the reminderDuration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReminderDuration() {
        return reminderDuration;
    }

    /**
     * Sets the value of the reminderDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReminderDuration(String value) {
        this.reminderDuration = value;
    }

    /**
     * Gets the value of the recurrence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecurrence() {
        return recurrence;
    }

    /**
     * Sets the value of the recurrence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecurrence(String value) {
        this.recurrence = value;
    }

    /**
     * Gets the value of the relativeDate property.
     * 
     * @return
     *     possible object is
     *     {@link RelativeDateType }
     *     
     */
    public RelativeDateType getRelativeDate() {
        return relativeDate;
    }

    /**
     * Sets the value of the relativeDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelativeDateType }
     *     
     */
    public void setRelativeDate(RelativeDateType value) {
        this.relativeDate = value;
    }

}
