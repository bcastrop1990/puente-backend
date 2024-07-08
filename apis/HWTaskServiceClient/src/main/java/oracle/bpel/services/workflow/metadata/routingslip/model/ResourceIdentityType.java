
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
 * <p>Java class for resourceIdentityType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="resourceIdentityType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="user"/&gt;
 *     &lt;enumeration value="group"/&gt;
 *     &lt;enumeration value="application_role"/&gt;
 *     &lt;enumeration value="position"/&gt;
 *     &lt;enumeration value="logicalPeopleGroup"/&gt;
 *     &lt;enumeration value="case_stakeholder"/&gt;
 *     &lt;enumeration value="queue"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "resourceIdentityType")
@XmlEnum
public enum ResourceIdentityType {

    @XmlEnumValue("user")
    USER("user"),
    @XmlEnumValue("group")
    GROUP("group"),
    @XmlEnumValue("application_role")
    APPLICATION_ROLE("application_role"),
    @XmlEnumValue("position")
    POSITION("position"),
    @XmlEnumValue("logicalPeopleGroup")
    LOGICAL_PEOPLE_GROUP("logicalPeopleGroup"),
    @XmlEnumValue("case_stakeholder")
    CASE_STAKEHOLDER("case_stakeholder"),
    @XmlEnumValue("queue")
    QUEUE("queue");
    private final String value;

    ResourceIdentityType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ResourceIdentityType fromValue(String v) {
        for (ResourceIdentityType c: ResourceIdentityType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
