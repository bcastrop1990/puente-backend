
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
 * <p>Java class for taskSequenceTypesType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="taskSequenceTypesType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ALL"/&gt;
 *     &lt;enumeration value="PAST"/&gt;
 *     &lt;enumeration value="APPROVERS"/&gt;
 *     &lt;enumeration value="FUTURE"/&gt;
 *     &lt;enumeration value="CURRENT"/&gt;
 *     &lt;enumeration value="AGGREGATE"/&gt;
 *     &lt;enumeration value="USERAPPROVALS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "taskSequenceTypesType")
@XmlEnum
public enum TaskSequenceTypesType {

    ALL,
    PAST,
    APPROVERS,
    FUTURE,
    CURRENT,
    AGGREGATE,
    USERAPPROVALS;

    public String value() {
        return name();
    }

    public static TaskSequenceTypesType fromValue(String v) {
        return valueOf(v);
    }

}
