
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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for assignmentContextValueEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="assignmentContextValueEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="RESOURCE"/&gt;
 *     &lt;enumeration value="STATIC"/&gt;
 *     &lt;enumeration value="XPATH"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "assignmentContextValueEnum")
@XmlEnum
public enum AssignmentContextValueEnum {

    RESOURCE,
    STATIC,
    XPATH;

    public String value() {
        return name();
    }

    public static AssignmentContextValueEnum fromValue(String v) {
        return valueOf(v);
    }

}
