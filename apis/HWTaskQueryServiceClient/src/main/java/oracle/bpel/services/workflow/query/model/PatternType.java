
package oracle.bpel.services.workflow.query.model;

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
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for patternType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="patternType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Fyi"/&gt;
 *     &lt;enumeration value="ManagementChain"/&gt;
 *     &lt;enumeration value="Parallel"/&gt;
 *     &lt;enumeration value="Participant"/&gt;
 *     &lt;enumeration value="Sequence"/&gt;
 *     &lt;enumeration value="SequentialParticipant"/&gt;
 *     &lt;enumeration value="Stage"/&gt;
 *     &lt;enumeration value="TODO"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "patternType")
@XmlEnum
public enum PatternType {

    @XmlEnumValue("Fyi")
    FYI("Fyi"),
    @XmlEnumValue("ManagementChain")
    MANAGEMENT_CHAIN("ManagementChain"),
    @XmlEnumValue("Parallel")
    PARALLEL("Parallel"),
    @XmlEnumValue("Participant")
    PARTICIPANT("Participant"),
    @XmlEnumValue("Sequence")
    SEQUENCE("Sequence"),
    @XmlEnumValue("SequentialParticipant")
    SEQUENTIAL_PARTICIPANT("SequentialParticipant"),
    @XmlEnumValue("Stage")
    STAGE("Stage"),
    TODO("TODO");
    private final String value;

    PatternType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PatternType fromValue(String v) {
        for (PatternType c: PatternType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
