
package oracle.bpel.services.workflow.common.tsc.model;

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
 * <p>Java class for anchorTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="anchorTypeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="START_OF_TASK"/&gt;
 *     &lt;enumeration value="START_STAGE"/&gt;
 *     &lt;enumeration value="END_STAGE"/&gt;
 *     &lt;enumeration value="BEFORE_ASSIGNEE"/&gt;
 *     &lt;enumeration value="AFTER_ASSIGNEE"/&gt;
 *     &lt;enumeration value="PARALLEL_TO_ASSIGNEE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "anchorTypeType")
@XmlEnum
public enum AnchorTypeType {

    START_OF_TASK,
    START_STAGE,
    END_STAGE,
    BEFORE_ASSIGNEE,
    AFTER_ASSIGNEE,
    PARALLEL_TO_ASSIGNEE;

    public String value() {
        return name();
    }

    public static AnchorTypeType fromValue(String v) {
        return valueOf(v);
    }

}
