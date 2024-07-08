
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
 * <p>Java class for shortHistoryActionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="shortHistoryActionType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ACQUIRE"/&gt;
 *     &lt;enumeration value="ADHOC_ROUTE"/&gt;
 *     &lt;enumeration value="AUTO_RELEASE"/&gt;
 *     &lt;enumeration value="DELEGATE"/&gt;
 *     &lt;enumeration value="ERROR"/&gt;
 *     &lt;enumeration value="ESCALATE"/&gt;
 *     &lt;enumeration value="INFO_REQUEST"/&gt;
 *     &lt;enumeration value="INFO_SUBMIT"/&gt;
 *     &lt;enumeration value="OUTCOME_UPDATE_ROUTE"/&gt;
 *     &lt;enumeration value="OVERRIDE_ROUTING_SLIP"/&gt;
 *     &lt;enumeration value="PUSH_BACK"/&gt;
 *     &lt;enumeration value="REASSIGN"/&gt;
 *     &lt;enumeration value="RELEASE"/&gt;
 *     &lt;enumeration value="RENEW"/&gt;
 *     &lt;enumeration value="RESUME"/&gt;
 *     &lt;enumeration value="SKIP_CURRENT_ASSIGNMENT"/&gt;
 *     &lt;enumeration value="SUSPEND"/&gt;
 *     &lt;enumeration value="UPDATE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "shortHistoryActionType")
@XmlEnum
public enum ShortHistoryActionType {

    ACQUIRE,
    ADHOC_ROUTE,
    AUTO_RELEASE,
    DELEGATE,
    ERROR,
    ESCALATE,
    INFO_REQUEST,
    INFO_SUBMIT,
    OUTCOME_UPDATE_ROUTE,
    OVERRIDE_ROUTING_SLIP,
    PUSH_BACK,
    REASSIGN,
    RELEASE,
    RENEW,
    RESUME,
    SKIP_CURRENT_ASSIGNMENT,
    SUSPEND,
    UPDATE;

    public String value() {
        return name();
    }

    public static ShortHistoryActionType fromValue(String v) {
        return valueOf(v);
    }

}
