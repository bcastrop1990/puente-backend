
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
 * <p>Java class for includeApproversType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="includeApproversType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="everyone"/&gt;
 *     &lt;enumeration value="firstAndLast"/&gt;
 *     &lt;enumeration value="last"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "includeApproversType")
@XmlEnum
public enum IncludeApproversType {

    @XmlEnumValue("everyone")
    EVERYONE("everyone"),
    @XmlEnumValue("firstAndLast")
    FIRST_AND_LAST("firstAndLast"),
    @XmlEnumValue("last")
    LAST("last");
    private final String value;

    IncludeApproversType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IncludeApproversType fromValue(String v) {
        for (IncludeApproversType c: IncludeApproversType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
