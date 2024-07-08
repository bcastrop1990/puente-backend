
package oracle.bpel.services.workflow.runtimeconfig.model;

/*
 * #%L
 * TUPA: Integration: BPM-Client: HW Runtime Service Client
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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ucmRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ucmRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ucmRequest" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ucmRequestParam" type="{http://xmlns.oracle.com/bpel/workflow/runtimeConfig}ucmPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ucmRequestType", propOrder = {
    "ucmRequest",
    "ucmRequestParam"
})
public class UcmRequestType {

    protected List<String> ucmRequest;
    protected List<UcmPropertyType> ucmRequestParam;

    /**
     * Gets the value of the ucmRequest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ucmRequest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUcmRequest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getUcmRequest() {
        if (ucmRequest == null) {
            ucmRequest = new ArrayList<String>();
        }
        return this.ucmRequest;
    }

    /**
     * Gets the value of the ucmRequestParam property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ucmRequestParam property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUcmRequestParam().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UcmPropertyType }
     * 
     * 
     */
    public List<UcmPropertyType> getUcmRequestParam() {
        if (ucmRequestParam == null) {
            ucmRequestParam = new ArrayList<UcmPropertyType>();
        }
        return this.ucmRequestParam;
    }

}