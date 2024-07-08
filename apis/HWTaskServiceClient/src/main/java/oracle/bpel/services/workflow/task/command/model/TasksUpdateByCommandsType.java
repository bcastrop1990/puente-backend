
package oracle.bpel.services.workflow.task.command.model;

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
 * <p>Java class for tasksUpdateByCommandsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tasksUpdateByCommandsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="simpleCommand" type="{http://xmlns.oracle.com/bpel/workflow/taskService/command}simpleCommandType" minOccurs="0"/&gt;
 *         &lt;element name="stateChangeCommand" type="{http://xmlns.oracle.com/bpel/workflow/taskService/command}stateChangeCommandType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tasksUpdateByCommandsType", propOrder = {
    "simpleCommand",
    "stateChangeCommand"
})
public class TasksUpdateByCommandsType {

    protected SimpleCommandType simpleCommand;
    protected StateChangeCommandType stateChangeCommand;

    /**
     * Gets the value of the simpleCommand property.
     * 
     * @return
     *     possible object is
     *     {@link SimpleCommandType }
     *     
     */
    public SimpleCommandType getSimpleCommand() {
        return simpleCommand;
    }

    /**
     * Sets the value of the simpleCommand property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleCommandType }
     *     
     */
    public void setSimpleCommand(SimpleCommandType value) {
        this.simpleCommand = value;
    }

    /**
     * Gets the value of the stateChangeCommand property.
     * 
     * @return
     *     possible object is
     *     {@link StateChangeCommandType }
     *     
     */
    public StateChangeCommandType getStateChangeCommand() {
        return stateChangeCommand;
    }

    /**
     * Sets the value of the stateChangeCommand property.
     * 
     * @param value
     *     allowed object is
     *     {@link StateChangeCommandType }
     *     
     */
    public void setStateChangeCommand(StateChangeCommandType value) {
        this.stateChangeCommand = value;
    }

}
