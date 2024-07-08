
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

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oracle.bpel.services.workflow.task.command.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TasksUpdateByCommands_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/taskService/command", "tasksUpdateByCommands");
    private final static QName _TasksUpdateByCommandsResponse_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/taskService/command", "tasksUpdateByCommandsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oracle.bpel.services.workflow.task.command.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TasksUpdateByCommandsType }
     * 
     */
    public TasksUpdateByCommandsType createTasksUpdateByCommandsType() {
        return new TasksUpdateByCommandsType();
    }

    /**
     * Create an instance of {@link TasksUpdateByCommandsResponseType }
     * 
     */
    public TasksUpdateByCommandsResponseType createTasksUpdateByCommandsResponseType() {
        return new TasksUpdateByCommandsResponseType();
    }

    /**
     * Create an instance of {@link SimpleCommandType }
     * 
     */
    public SimpleCommandType createSimpleCommandType() {
        return new SimpleCommandType();
    }

    /**
     * Create an instance of {@link StateChangeCommandType }
     * 
     */
    public StateChangeCommandType createStateChangeCommandType() {
        return new StateChangeCommandType();
    }

    /**
     * Create an instance of {@link UpdatePriorityLevelType }
     * 
     */
    public UpdatePriorityLevelType createUpdatePriorityLevelType() {
        return new UpdatePriorityLevelType();
    }

    /**
     * Create an instance of {@link TaskAssigneesType }
     * 
     */
    public TaskAssigneesType createTaskAssigneesType() {
        return new TaskAssigneesType();
    }

    /**
     * Create an instance of {@link TaskAssigneeType }
     * 
     */
    public TaskAssigneeType createTaskAssigneeType() {
        return new TaskAssigneeType();
    }

    /**
     * Create an instance of {@link UpdateOutcomeType }
     * 
     */
    public UpdateOutcomeType createUpdateOutcomeType() {
        return new UpdateOutcomeType();
    }

    /**
     * Create an instance of {@link CommandParamType }
     * 
     */
    public CommandParamType createCommandParamType() {
        return new CommandParamType();
    }

    /**
     * Create an instance of {@link TaskUpdateResultType }
     * 
     */
    public TaskUpdateResultType createTaskUpdateResultType() {
        return new TaskUpdateResultType();
    }

    /**
     * Create an instance of {@link UpdateTaskSummaryType }
     * 
     */
    public UpdateTaskSummaryType createUpdateTaskSummaryType() {
        return new UpdateTaskSummaryType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TasksUpdateByCommandsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/taskService/command", name = "tasksUpdateByCommands")
    public JAXBElement<TasksUpdateByCommandsType> createTasksUpdateByCommands(TasksUpdateByCommandsType value) {
        return new JAXBElement<TasksUpdateByCommandsType>(_TasksUpdateByCommands_QNAME, TasksUpdateByCommandsType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TasksUpdateByCommandsResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/taskService/command", name = "tasksUpdateByCommandsResponse")
    public JAXBElement<TasksUpdateByCommandsResponseType> createTasksUpdateByCommandsResponse(TasksUpdateByCommandsResponseType value) {
        return new JAXBElement<TasksUpdateByCommandsResponseType>(_TasksUpdateByCommandsResponse_QNAME, TasksUpdateByCommandsResponseType.class, null, value);
    }

}
