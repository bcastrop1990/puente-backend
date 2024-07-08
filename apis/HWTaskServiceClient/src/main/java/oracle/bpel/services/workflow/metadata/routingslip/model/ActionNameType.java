
package oracle.bpel.services.workflow.metadata.routingslip.model;

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
 * <p>Java class for actionNameType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="actionNameType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ASSIGN"/&gt;
 *     &lt;enumeration value="ALERT"/&gt;
 *     &lt;enumeration value="COMPLETE"/&gt;
 *     &lt;enumeration value="ERROR"/&gt;
 *     &lt;enumeration value="EXPIRE"/&gt;
 *     &lt;enumeration value="INFO_REQUEST"/&gt;
 *     &lt;enumeration value="OUTCOME_UPDATE"/&gt;
 *     &lt;enumeration value="SUSPEND"/&gt;
 *     &lt;enumeration value="WITHDRAW"/&gt;
 *     &lt;enumeration value="RESUME"/&gt;
 *     &lt;enumeration value="UPDATE"/&gt;
 *     &lt;enumeration value="ALL_OTHER_ACTIONS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "actionNameType")
@XmlEnum
public enum ActionNameType {

    ASSIGN,
    ALERT,
    COMPLETE,
    ERROR,
    EXPIRE,
    INFO_REQUEST,
    OUTCOME_UPDATE,
    SUSPEND,
    WITHDRAW,
    RESUME,
    UPDATE,
    ALL_OTHER_ACTIONS;

    public String value() {
        return name();
    }

    public static ActionNameType fromValue(String v) {
        return valueOf(v);
    }

}
