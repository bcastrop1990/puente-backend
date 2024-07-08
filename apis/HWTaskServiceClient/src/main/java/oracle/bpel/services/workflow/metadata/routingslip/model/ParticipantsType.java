
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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for participantsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="participantsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence maxOccurs="unbounded"&gt;
 *         &lt;choice maxOccurs="unbounded"&gt;
 *           &lt;element name="participant" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}participantType"/&gt;
 *           &lt;element name="sequentialParticipant" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}sequentialParticipantType"/&gt;
 *           &lt;element name="adhoc" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}adhocType"/&gt;
 *           &lt;element name="managementChain" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}managementChainType"/&gt;
 *           &lt;element name="parallel" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}parallelType"/&gt;
 *           &lt;element name="fyi" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}fyiType"/&gt;
 *           &lt;element name="notify" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}notifyType"/&gt;
 *           &lt;element name="stage" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}stageType"/&gt;
 *           &lt;element name="forEach" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}forEachType"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="isAdhocRoutingSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "participantsType", propOrder = {
    "participantOrSequentialParticipantOrAdhoc"
})
@XmlSeeAlso({
    ForEachType.class,
    StageType.class
})
public class ParticipantsType {

    @XmlElements({
        @XmlElement(name = "participant", type = ParticipantType.class),
        @XmlElement(name = "sequentialParticipant", type = SequentialParticipantType.class),
        @XmlElement(name = "adhoc", type = AdhocType.class),
        @XmlElement(name = "managementChain", type = ManagementChainType.class),
        @XmlElement(name = "parallel", type = ParallelType.class),
        @XmlElement(name = "fyi", type = FyiType.class),
        @XmlElement(name = "notify", type = NotifyType.class),
        @XmlElement(name = "stage", type = StageType.class),
        @XmlElement(name = "forEach", type = ForEachType.class)
    })
    protected List<Object> participantOrSequentialParticipantOrAdhoc;
    @XmlAttribute(name = "isAdhocRoutingSupported")
    protected Boolean isAdhocRoutingSupported;

    /**
     * Gets the value of the participantOrSequentialParticipantOrAdhoc property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the participantOrSequentialParticipantOrAdhoc property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParticipantOrSequentialParticipantOrAdhoc().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParticipantType }
     * {@link SequentialParticipantType }
     * {@link AdhocType }
     * {@link ManagementChainType }
     * {@link ParallelType }
     * {@link FyiType }
     * {@link NotifyType }
     * {@link StageType }
     * {@link ForEachType }
     * 
     * 
     */
    public List<Object> getParticipantOrSequentialParticipantOrAdhoc() {
        if (participantOrSequentialParticipantOrAdhoc == null) {
            participantOrSequentialParticipantOrAdhoc = new ArrayList<Object>();
        }
        return this.participantOrSequentialParticipantOrAdhoc;
    }

    /**
     * Gets the value of the isAdhocRoutingSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsAdhocRoutingSupported() {
        return isAdhocRoutingSupported;
    }

    /**
     * Sets the value of the isAdhocRoutingSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsAdhocRoutingSupported(Boolean value) {
        this.isAdhocRoutingSupported = value;
    }

}
