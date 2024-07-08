
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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for taskSequenceBuilderContextType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="taskSequenceBuilderContextType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="STAGE"/&gt;
 *     &lt;enumeration value="WORKFLOW_PATTERN"/&gt;
 *     &lt;enumeration value="INCLUDE_SEQUENCE_FOR_SINGLE_CHILD"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "taskSequenceBuilderContextType")
@XmlEnum
public enum TaskSequenceBuilderContextType {

    STAGE,
    WORKFLOW_PATTERN,
    INCLUDE_SEQUENCE_FOR_SINGLE_CHILD;

    public String value() {
        return name();
    }

    public static TaskSequenceBuilderContextType fromValue(String v) {
        return valueOf(v);
    }

}
