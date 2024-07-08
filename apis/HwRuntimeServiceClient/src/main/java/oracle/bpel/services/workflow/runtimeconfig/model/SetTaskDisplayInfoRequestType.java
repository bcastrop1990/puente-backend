
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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oracle.bpel.services.workflow.common.model.WorkflowContextType;


/**
 * <p>Java class for setTaskDisplayInfoRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setTaskDisplayInfoRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/common}workflowContext"/&gt;
 *         &lt;element name="taskDefinitionNamespace" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="compositeVersion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="partitionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/runtimeConfig}taskDisplayInfoList"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setTaskDisplayInfoRequestType", propOrder = {
    "workflowContext",
    "taskDefinitionNamespace",
    "compositeVersion",
    "partitionName",
    "taskDisplayInfoList"
})
public class SetTaskDisplayInfoRequestType {

    @XmlElement(namespace = "http://xmlns.oracle.com/bpel/workflow/common", required = true)
    protected WorkflowContextType workflowContext;
    @XmlElement(required = true)
    protected String taskDefinitionNamespace;
    @XmlElement(required = true)
    protected String compositeVersion;
    protected String partitionName;
    @XmlElement(required = true)
    protected TaskDisplayInfoList taskDisplayInfoList;

    /**
     * Gets the value of the workflowContext property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowContextType }
     *     
     */
    public WorkflowContextType getWorkflowContext() {
        return workflowContext;
    }

    /**
     * Sets the value of the workflowContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowContextType }
     *     
     */
    public void setWorkflowContext(WorkflowContextType value) {
        this.workflowContext = value;
    }

    /**
     * Gets the value of the taskDefinitionNamespace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskDefinitionNamespace() {
        return taskDefinitionNamespace;
    }

    /**
     * Sets the value of the taskDefinitionNamespace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskDefinitionNamespace(String value) {
        this.taskDefinitionNamespace = value;
    }

    /**
     * Gets the value of the compositeVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompositeVersion() {
        return compositeVersion;
    }

    /**
     * Sets the value of the compositeVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompositeVersion(String value) {
        this.compositeVersion = value;
    }

    /**
     * Gets the value of the partitionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartitionName() {
        return partitionName;
    }

    /**
     * Sets the value of the partitionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartitionName(String value) {
        this.partitionName = value;
    }

    /**
     * Gets the value of the taskDisplayInfoList property.
     * 
     * @return
     *     possible object is
     *     {@link TaskDisplayInfoList }
     *     
     */
    public TaskDisplayInfoList getTaskDisplayInfoList() {
        return taskDisplayInfoList;
    }

    /**
     * Sets the value of the taskDisplayInfoList property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskDisplayInfoList }
     *     
     */
    public void setTaskDisplayInfoList(TaskDisplayInfoList value) {
        this.taskDisplayInfoList = value;
    }

}
