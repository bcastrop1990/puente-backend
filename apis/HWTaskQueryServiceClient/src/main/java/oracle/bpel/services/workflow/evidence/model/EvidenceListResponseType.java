
package oracle.bpel.services.workflow.evidence.model;

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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EvidenceListResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EvidenceListResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/TaskEvidenceService}evidenceList"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EvidenceListResponseType", propOrder = {
    "evidenceList"
})
public class EvidenceListResponseType {

    @XmlElement(required = true)
    protected EvidenceListType evidenceList;

    /**
     * Gets the value of the evidenceList property.
     * 
     * @return
     *     possible object is
     *     {@link EvidenceListType }
     *     
     */
    public EvidenceListType getEvidenceList() {
        return evidenceList;
    }

    /**
     * Sets the value of the evidenceList property.
     * 
     * @param value
     *     allowed object is
     *     {@link EvidenceListType }
     *     
     */
    public void setEvidenceList(EvidenceListType value) {
        this.evidenceList = value;
    }

}
