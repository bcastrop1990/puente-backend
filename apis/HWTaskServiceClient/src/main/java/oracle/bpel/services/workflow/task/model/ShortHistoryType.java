
package oracle.bpel.services.workflow.task.model;

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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for shortHistoryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="shortHistoryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="task" type="{http://xmlns.oracle.com/bpel/workflow/task}shortHistoryTaskType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shortHistoryType", propOrder = {
    "task"
})
public class ShortHistoryType {

    protected List<ShortHistoryTaskType> task;

    /**
     * Gets the value of the task property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the task property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTask().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShortHistoryTaskType }
     * 
     * 
     */
    public List<ShortHistoryTaskType> getTask() {
        if (task == null) {
            task = new ArrayList<ShortHistoryTaskType>();
        }
        return this.task;
    }

}
