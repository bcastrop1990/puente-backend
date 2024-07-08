
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
 * <p>Java class for assignmentFilterEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="assignmentFilterEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="All"/&gt;
 *     &lt;enumeration value="My"/&gt;
 *     &lt;enumeration value="Group"/&gt;
 *     &lt;enumeration value="My+Group"/&gt;
 *     &lt;enumeration value="My+Group+All"/&gt;
 *     &lt;enumeration value="Reportees"/&gt;
 *     &lt;enumeration value="Creator"/&gt;
 *     &lt;enumeration value="Owner"/&gt;
 *     &lt;enumeration value="Previous"/&gt;
 *     &lt;enumeration value="Admin"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "assignmentFilterEnum", namespace = "http://xmlns.oracle.com/bpel/workflow/taskQuery")
@XmlEnum
public enum AssignmentFilterEnum {

    @XmlEnumValue("All")
    ALL("All"),
    @XmlEnumValue("My")
    MY("My"),
    @XmlEnumValue("Group")
    GROUP("Group"),
    @XmlEnumValue("My+Group")
    MY_GROUP("My+Group"),
    @XmlEnumValue("My+Group+All")
    MY_GROUP_ALL("My+Group+All"),
    @XmlEnumValue("Reportees")
    REPORTEES("Reportees"),
    @XmlEnumValue("Creator")
    CREATOR("Creator"),
    @XmlEnumValue("Owner")
    OWNER("Owner"),
    @XmlEnumValue("Previous")
    PREVIOUS("Previous"),
    @XmlEnumValue("Admin")
    ADMIN("Admin");
    private final String value;

    AssignmentFilterEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AssignmentFilterEnum fromValue(String v) {
        for (AssignmentFilterEnum c: AssignmentFilterEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
