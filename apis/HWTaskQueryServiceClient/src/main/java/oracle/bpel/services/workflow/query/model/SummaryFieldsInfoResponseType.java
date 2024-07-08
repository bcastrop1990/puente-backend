
package oracle.bpel.services.workflow.query.model;

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
 * <p>Java class for summaryFieldsInfoResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="summaryFieldsInfoResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="summaryFieldInfo" type="{http://xmlns.oracle.com/bpel/workflow/taskQueryService}summaryFieldInfoType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "summaryFieldsInfoResponseType", propOrder = {
    "summaryFieldInfo"
})
public class SummaryFieldsInfoResponseType {

    protected SummaryFieldInfoType summaryFieldInfo;

    /**
     * Gets the value of the summaryFieldInfo property.
     * 
     * @return
     *     possible object is
     *     {@link SummaryFieldInfoType }
     *     
     */
    public SummaryFieldInfoType getSummaryFieldInfo() {
        return summaryFieldInfo;
    }

    /**
     * Sets the value of the summaryFieldInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link SummaryFieldInfoType }
     *     
     */
    public void setSummaryFieldInfo(SummaryFieldInfoType value) {
        this.summaryFieldInfo = value;
    }

}
