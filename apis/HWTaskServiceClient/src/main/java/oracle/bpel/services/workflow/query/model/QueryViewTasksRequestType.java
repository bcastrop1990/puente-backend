
package oracle.bpel.services.workflow.query.model;

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
import oracle.bpel.services.workflow.common.model.WorkflowContextType;


/**
 * <p>Java class for queryViewTasksRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="queryViewTasksRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/common}workflowContext" minOccurs="0"/&gt;
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/taskQuery}viewTaskPredicateQuery"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queryViewTasksRequestType", propOrder = {
    "workflowContext",
    "viewTaskPredicateQuery"
})
public class QueryViewTasksRequestType {

    @XmlElement(namespace = "http://xmlns.oracle.com/bpel/workflow/common")
    protected WorkflowContextType workflowContext;
    @XmlElement(namespace = "http://xmlns.oracle.com/bpel/workflow/taskQuery", required = true)
    protected ViewTaskPredicateQueryType viewTaskPredicateQuery;

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
     * Gets the value of the viewTaskPredicateQuery property.
     * 
     * @return
     *     possible object is
     *     {@link ViewTaskPredicateQueryType }
     *     
     */
    public ViewTaskPredicateQueryType getViewTaskPredicateQuery() {
        return viewTaskPredicateQuery;
    }

    /**
     * Sets the value of the viewTaskPredicateQuery property.
     * 
     * @param value
     *     allowed object is
     *     {@link ViewTaskPredicateQueryType }
     *     
     */
    public void setViewTaskPredicateQuery(ViewTaskPredicateQueryType value) {
        this.viewTaskPredicateQuery = value;
    }

}
