
package oracle.bpel.services.workflow.task.model;

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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for hiddenAttributesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="hiddenAttributesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="isCreatorHidden" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="creatorCustomText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="isAutoApproval" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hiddenAttributesType", propOrder = {
    "isCreatorHidden",
    "creatorCustomText",
    "isAutoApproval"
})
public class HiddenAttributesType {

    protected Boolean isCreatorHidden;
    protected String creatorCustomText;
    protected Boolean isAutoApproval;

    /**
     * Gets the value of the isCreatorHidden property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsCreatorHidden() {
        return isCreatorHidden;
    }

    /**
     * Sets the value of the isCreatorHidden property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsCreatorHidden(Boolean value) {
        this.isCreatorHidden = value;
    }

    /**
     * Gets the value of the creatorCustomText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatorCustomText() {
        return creatorCustomText;
    }

    /**
     * Sets the value of the creatorCustomText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatorCustomText(String value) {
        this.creatorCustomText = value;
    }

    /**
     * Gets the value of the isAutoApproval property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsAutoApproval() {
        return isAutoApproval;
    }

    /**
     * Sets the value of the isAutoApproval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsAutoApproval(Boolean value) {
        this.isAutoApproval = value;
    }

}
