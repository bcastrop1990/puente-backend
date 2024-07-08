
package oracle.bpel.services.workflow.task.model;

/*
 * #%L
 * TUPA: Integration: BPM-Client: HW Task Query Service Client
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
 * <p>Java class for substateEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="substateEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ACQUIRED"/&gt;
 *     &lt;enumeration value="ADHOC_ROUTED"/&gt;
 *     &lt;enumeration value="ASSIGNED"/&gt;
 *     &lt;enumeration value="DELEGATED"/&gt;
 *     &lt;enumeration value="ESCALATED"/&gt;
 *     &lt;enumeration value="INFO_SUBMITTED"/&gt;
 *     &lt;enumeration value="PUSHED_BACK"/&gt;
 *     &lt;enumeration value="REASSIGNED"/&gt;
 *     &lt;enumeration value="RELEASED"/&gt;
 *     &lt;enumeration value="RENEWED"/&gt;
 *     &lt;enumeration value="RESUMED"/&gt;
 *     &lt;enumeration value="ROUTED"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "substateEnum")
@XmlEnum
public enum SubstateEnum {

    ACQUIRED,
    ADHOC_ROUTED,
    ASSIGNED,
    DELEGATED,
    ESCALATED,
    INFO_SUBMITTED,
    PUSHED_BACK,
    REASSIGNED,
    RELEASED,
    RENEWED,
    RESUMED,
    ROUTED;

    public String value() {
        return name();
    }

    public static SubstateEnum fromValue(String v) {
        return valueOf(v);
    }

}
