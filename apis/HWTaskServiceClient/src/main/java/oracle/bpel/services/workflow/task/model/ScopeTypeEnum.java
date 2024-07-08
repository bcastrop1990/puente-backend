
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
 * <p>Java class for scopeTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="scopeTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="TASK"/&gt;
 *     &lt;enumeration value="PARENT_TASK"/&gt;
 *     &lt;enumeration value="BPM"/&gt;
 *     &lt;enumeration value="CASE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "scopeTypeEnum")
@XmlEnum
public enum ScopeTypeEnum {

    TASK,
    PARENT_TASK,
    BPM,
    CASE;

    public String value() {
        return name();
    }

    public static ScopeTypeEnum fromValue(String v) {
        return valueOf(v);
    }

}
