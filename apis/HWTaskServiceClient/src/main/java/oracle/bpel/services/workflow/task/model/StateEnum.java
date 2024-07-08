
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
 * <p>Java class for stateEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="stateEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ASSIGNED"/&gt;
 *     &lt;enumeration value="ALERTED"/&gt;
 *     &lt;enumeration value="COMPLETED"/&gt;
 *     &lt;enumeration value="ERRORED"/&gt;
 *     &lt;enumeration value="EXPIRED"/&gt;
 *     &lt;enumeration value="INFO_REQUESTED"/&gt;
 *     &lt;enumeration value="OUTCOME_UPDATED"/&gt;
 *     &lt;enumeration value="STALE"/&gt;
 *     &lt;enumeration value="SUSPENDED"/&gt;
 *     &lt;enumeration value="WITHDRAWN"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "stateEnum")
@XmlEnum
public enum StateEnum {

    ASSIGNED,
    ALERTED,
    COMPLETED,
    ERRORED,
    EXPIRED,
    INFO_REQUESTED,
    OUTCOME_UPDATED,
    STALE,
    SUSPENDED,
    WITHDRAWN;

    public String value() {
        return name();
    }

    public static StateEnum fromValue(String v) {
        return valueOf(v);
    }

}
