
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
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for excludedParticipantType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="excludedParticipantType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="previousLaneParticipant"/&gt;
 *     &lt;enumeration value="previousParticipantInCurrentTask"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "excludedParticipantType")
@XmlEnum
public enum ExcludedParticipantType {

    @XmlEnumValue("previousLaneParticipant")
    PREVIOUS_LANE_PARTICIPANT("previousLaneParticipant"),
    @XmlEnumValue("previousParticipantInCurrentTask")
    PREVIOUS_PARTICIPANT_IN_CURRENT_TASK("previousParticipantInCurrentTask");
    private final String value;

    ExcludedParticipantType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ExcludedParticipantType fromValue(String v) {
        for (ExcludedParticipantType c: ExcludedParticipantType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
