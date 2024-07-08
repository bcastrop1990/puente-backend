
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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for taskOptionalInfoEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="taskOptionalInfoEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Actions"/&gt;
 *     &lt;enumeration value="GroupActions"/&gt;
 *     &lt;enumeration value="CustomActions"/&gt;
 *     &lt;enumeration value="Attachments"/&gt;
 *     &lt;enumeration value="Comments"/&gt;
 *     &lt;enumeration value="Payload"/&gt;
 *     &lt;enumeration value="ShortHistory"/&gt;
 *     &lt;enumeration value="TemplateTasks"/&gt;
 *     &lt;enumeration value="ACTION_DISPLAY_NAME"/&gt;
 *     &lt;enumeration value="TASK_VIEW_CONTEXT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "taskOptionalInfoEnum", namespace = "http://xmlns.oracle.com/bpel/workflow/taskQuery")
@XmlEnum
public enum TaskOptionalInfoEnum {

    @XmlEnumValue("Actions")
    ACTIONS("Actions"),
    @XmlEnumValue("GroupActions")
    GROUP_ACTIONS("GroupActions"),
    @XmlEnumValue("CustomActions")
    CUSTOM_ACTIONS("CustomActions"),
    @XmlEnumValue("Attachments")
    ATTACHMENTS("Attachments"),
    @XmlEnumValue("Comments")
    COMMENTS("Comments"),
    @XmlEnumValue("Payload")
    PAYLOAD("Payload"),
    @XmlEnumValue("ShortHistory")
    SHORT_HISTORY("ShortHistory"),
    @XmlEnumValue("TemplateTasks")
    TEMPLATE_TASKS("TemplateTasks"),
    ACTION_DISPLAY_NAME("ACTION_DISPLAY_NAME"),
    TASK_VIEW_CONTEXT("TASK_VIEW_CONTEXT");
    private final String value;

    TaskOptionalInfoEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TaskOptionalInfoEnum fromValue(String v) {
        for (TaskOptionalInfoEnum c: TaskOptionalInfoEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
