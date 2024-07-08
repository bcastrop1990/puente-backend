
package com.oracle.xmlns.bpel.workflow.taskservice;

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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for restartContextType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="restartContextType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="preserveHistory" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="preserveAdhocInsertions" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="reapproveRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="previewRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="newCorrelationId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "restartContextType", propOrder = {
    "preserveHistory",
    "preserveAdhocInsertions",
    "reapproveRequired",
    "previewRequired",
    "newCorrelationId"
})
public class RestartContextType {

    @XmlElement(defaultValue = "false")
    protected boolean preserveHistory;
    @XmlElement(defaultValue = "true")
    protected boolean preserveAdhocInsertions;
    @XmlElement(defaultValue = "true")
    protected boolean reapproveRequired;
    @XmlElement(defaultValue = "false")
    protected boolean previewRequired;
    @XmlElement(required = true)
    protected String newCorrelationId;

    /**
     * Gets the value of the preserveHistory property.
     * 
     */
    public boolean isPreserveHistory() {
        return preserveHistory;
    }

    /**
     * Sets the value of the preserveHistory property.
     * 
     */
    public void setPreserveHistory(boolean value) {
        this.preserveHistory = value;
    }

    /**
     * Gets the value of the preserveAdhocInsertions property.
     * 
     */
    public boolean isPreserveAdhocInsertions() {
        return preserveAdhocInsertions;
    }

    /**
     * Sets the value of the preserveAdhocInsertions property.
     * 
     */
    public void setPreserveAdhocInsertions(boolean value) {
        this.preserveAdhocInsertions = value;
    }

    /**
     * Gets the value of the reapproveRequired property.
     * 
     */
    public boolean isReapproveRequired() {
        return reapproveRequired;
    }

    /**
     * Sets the value of the reapproveRequired property.
     * 
     */
    public void setReapproveRequired(boolean value) {
        this.reapproveRequired = value;
    }

    /**
     * Gets the value of the previewRequired property.
     * 
     */
    public boolean isPreviewRequired() {
        return previewRequired;
    }

    /**
     * Sets the value of the previewRequired property.
     * 
     */
    public void setPreviewRequired(boolean value) {
        this.previewRequired = value;
    }

    /**
     * Gets the value of the newCorrelationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewCorrelationId() {
        return newCorrelationId;
    }

    /**
     * Sets the value of the newCorrelationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewCorrelationId(String value) {
        this.newCorrelationId = value;
    }

}
