
package com.oracle.xmlns.pcbpel.humanworkflow.configurations;

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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pushbackAssigneeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="pushbackAssigneeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="APPROVER"/&gt;
 *     &lt;enumeration value="INITIAL_ASSIGNEES"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "pushbackAssigneeType")
@XmlEnum
public enum PushbackAssigneeType {

    APPROVER,
    INITIAL_ASSIGNEES;

    public String value() {
        return name();
    }

    public static PushbackAssigneeType fromValue(String v) {
        return valueOf(v);
    }

}
