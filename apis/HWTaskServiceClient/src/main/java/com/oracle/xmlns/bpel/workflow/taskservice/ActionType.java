
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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for actionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="actionType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="REINITIATE"/&gt;
 *     &lt;enumeration value="INITIATE"/&gt;
 *     &lt;enumeration value="OUTCOME_UPDATED"/&gt;
 *     &lt;enumeration value="ACQUIRED"/&gt;
 *     &lt;enumeration value="AUTO_RELEASE"/&gt;
 *     &lt;enumeration value="COMPLETED"/&gt;
 *     &lt;enumeration value="ERRORED"/&gt;
 *     &lt;enumeration value="ESCALATED"/&gt;
 *     &lt;enumeration value="EXPIRED"/&gt;
 *     &lt;enumeration value="INFO_REQUESTED"/&gt;
 *     &lt;enumeration value="INFO_SUBMITTED"/&gt;
 *     &lt;enumeration value="REASSIGNED"/&gt;
 *     &lt;enumeration value="RELEASED"/&gt;
 *     &lt;enumeration value="RENEWED"/&gt;
 *     &lt;enumeration value="RESUMED"/&gt;
 *     &lt;enumeration value="SUBTASK_OUTCOME_UPDATED"/&gt;
 *     &lt;enumeration value="SUSPENDED"/&gt;
 *     &lt;enumeration value="UPDATED"/&gt;
 *     &lt;enumeration value="WITHDRAWN"/&gt;
 *     &lt;enumeration value="SKIP_CURRENT_ASSIGNMENT"/&gt;
 *     &lt;enumeration value="OVERRIDE_ROUTING_SLIP"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "actionType")
@XmlEnum
public enum ActionType {

    REINITIATE,
    INITIATE,
    OUTCOME_UPDATED,
    ACQUIRED,
    AUTO_RELEASE,
    COMPLETED,
    ERRORED,
    ESCALATED,
    EXPIRED,
    INFO_REQUESTED,
    INFO_SUBMITTED,
    REASSIGNED,
    RELEASED,
    RENEWED,
    RESUMED,
    SUBTASK_OUTCOME_UPDATED,
    SUSPENDED,
    UPDATED,
    WITHDRAWN,
    SKIP_CURRENT_ASSIGNMENT,
    OVERRIDE_ROUTING_SLIP;

    public String value() {
        return name();
    }

    public static ActionType fromValue(String v) {
        return valueOf(v);
    }

}
