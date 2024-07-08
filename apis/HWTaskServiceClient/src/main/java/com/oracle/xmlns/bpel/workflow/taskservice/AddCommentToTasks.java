
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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;
import oracle.bpel.services.workflow.common.model.WorkflowContextType;
import oracle.bpel.services.workflow.task.model.CommentType;


/**
 * <p>Java class for addCommentToTasks complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addCommentToTasks"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/common}workflowContext" minOccurs="0"/&gt;
 *         &lt;element name="taskId" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *           &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/task}comment"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addCommentToTasks", propOrder = {
    "content"
})
public class AddCommentToTasks {

    @XmlElementRefs({
        @XmlElementRef(name = "workflowContext", namespace = "http://xmlns.oracle.com/bpel/workflow/common", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "taskId", namespace = "http://xmlns.oracle.com/bpel/workflow/taskService", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "comment", namespace = "http://xmlns.oracle.com/bpel/workflow/taskService", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "comment", namespace = "http://xmlns.oracle.com/bpel/workflow/task", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> content;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "Comment" is used by two different parts of a schema. See: 
     * line 277 of file:/home/usuario/dev/crossnet/senasa_011_item2_desarrollo/integracion/bpm/hw-task-service-client/src/main/resources/wsdl/TaskServicePort_1_2_3.xsd
     * line 276 of file:/home/usuario/dev/crossnet/senasa_011_item2_desarrollo/integracion/bpm/hw-task-service-client/src/main/resources/wsdl/TaskServicePort_1_2_3.xsd
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link CommentType }{@code >}
     * {@link JAXBElement }{@code <}{@link WorkflowContextType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getContent() {
        if (content == null) {
            content = new ArrayList<JAXBElement<?>>();
        }
        return this.content;
    }

}
