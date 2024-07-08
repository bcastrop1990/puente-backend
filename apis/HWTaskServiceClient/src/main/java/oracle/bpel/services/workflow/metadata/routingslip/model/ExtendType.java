
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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for extendType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="extendType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;sequence&gt;
 *           &lt;element name="ifFinalApproverLevel" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *           &lt;element name="extendBy" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;/sequence&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "extendType", propOrder = {
    "ifFinalApproverLevel",
    "extendBy"
})
public class ExtendType {

    protected Integer ifFinalApproverLevel;
    protected Integer extendBy;

    /**
     * Gets the value of the ifFinalApproverLevel property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIfFinalApproverLevel() {
        return ifFinalApproverLevel;
    }

    /**
     * Sets the value of the ifFinalApproverLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIfFinalApproverLevel(Integer value) {
        this.ifFinalApproverLevel = value;
    }

    /**
     * Gets the value of the extendBy property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getExtendBy() {
        return extendBy;
    }

    /**
     * Sets the value of the extendBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setExtendBy(Integer value) {
        this.extendBy = value;
    }

}
