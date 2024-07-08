
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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice maxOccurs="unbounded"&gt;
 *         &lt;element name="resourceList" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}resourceListType"/&gt;
 *         &lt;element name="managementChain" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}managementChainListType"/&gt;
 *         &lt;element name="supervisory" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}supervisoryListType"/&gt;
 *         &lt;element name="jobLevel" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}jobLevelListType"/&gt;
 *         &lt;element name="position" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}positionListType"/&gt;
 *         &lt;element name="approvalGroup" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}approvalGroupListType"/&gt;
 *         &lt;element name="ruleset" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}rulesetType"/&gt;
 *         &lt;element name="logicalPeopleGroup" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}logicalPeopleGroupListType"/&gt;
 *         &lt;element name="customList" type="{http://xmlns.oracle.com/bpel/workflow/routingSlip}customListType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "resourceListOrManagementChainOrSupervisory"
})
@XmlRootElement(name = "lists")
public class Lists {

    @XmlElements({
        @XmlElement(name = "resourceList", type = ResourceListType.class),
        @XmlElement(name = "managementChain", type = ManagementChainListType.class),
        @XmlElement(name = "supervisory", type = SupervisoryListType.class),
        @XmlElement(name = "jobLevel", type = JobLevelListType.class),
        @XmlElement(name = "position", type = PositionListType.class),
        @XmlElement(name = "approvalGroup", type = ApprovalGroupListType.class),
        @XmlElement(name = "ruleset", type = RulesetType.class),
        @XmlElement(name = "logicalPeopleGroup", type = LogicalPeopleGroupListType.class),
        @XmlElement(name = "customList", type = CustomListType.class)
    })
    protected List<Object> resourceListOrManagementChainOrSupervisory;

    /**
     * Gets the value of the resourceListOrManagementChainOrSupervisory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resourceListOrManagementChainOrSupervisory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResourceListOrManagementChainOrSupervisory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResourceListType }
     * {@link ManagementChainListType }
     * {@link SupervisoryListType }
     * {@link JobLevelListType }
     * {@link PositionListType }
     * {@link ApprovalGroupListType }
     * {@link RulesetType }
     * {@link LogicalPeopleGroupListType }
     * {@link CustomListType }
     * 
     * 
     */
    public List<Object> getResourceListOrManagementChainOrSupervisory() {
        if (resourceListOrManagementChainOrSupervisory == null) {
            resourceListOrManagementChainOrSupervisory = new ArrayList<Object>();
        }
        return this.resourceListOrManagementChainOrSupervisory;
    }

}
