
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
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for actionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="actionType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *       &lt;attribute name="name" use="required" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}actionNameType" /&gt;
 *       &lt;attribute name="recipient" use="required" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}recipientType" /&gt;
 *       &lt;attribute name="adhocRecipients" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="wordMLXSLT" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="xslt" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actionType", propOrder = {
    "value"
})
public class ActionType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "name", required = true)
    protected ActionNameType name;
    @XmlAttribute(name = "recipient", required = true)
    protected RecipientType recipient;
    @XmlAttribute(name = "adhocRecipients")
    protected String adhocRecipients;
    @XmlAttribute(name = "wordMLXSLT")
    protected String wordMLXSLT;
    @XmlAttribute(name = "xslt")
    protected String xslt;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link ActionNameType }
     *     
     */
    public ActionNameType getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActionNameType }
     *     
     */
    public void setName(ActionNameType value) {
        this.name = value;
    }

    /**
     * Gets the value of the recipient property.
     * 
     * @return
     *     possible object is
     *     {@link RecipientType }
     *     
     */
    public RecipientType getRecipient() {
        return recipient;
    }

    /**
     * Sets the value of the recipient property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecipientType }
     *     
     */
    public void setRecipient(RecipientType value) {
        this.recipient = value;
    }

    /**
     * Gets the value of the adhocRecipients property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdhocRecipients() {
        return adhocRecipients;
    }

    /**
     * Sets the value of the adhocRecipients property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdhocRecipients(String value) {
        this.adhocRecipients = value;
    }

    /**
     * Gets the value of the wordMLXSLT property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWordMLXSLT() {
        return wordMLXSLT;
    }

    /**
     * Sets the value of the wordMLXSLT property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWordMLXSLT(String value) {
        this.wordMLXSLT = value;
    }

    /**
     * Gets the value of the xslt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXslt() {
        return xslt;
    }

    /**
     * Sets the value of the xslt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXslt(String value) {
        this.xslt = value;
    }

}
