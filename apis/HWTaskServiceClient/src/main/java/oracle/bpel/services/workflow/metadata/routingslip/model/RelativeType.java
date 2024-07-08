
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
 * <p>Java class for relativeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="relativeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="startingPoint"/&gt;
 *     &lt;enumeration value="creator"/&gt;
 *     &lt;enumeration value="absolute"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "relativeType")
@XmlEnum
public enum RelativeType {

    @XmlEnumValue("startingPoint")
    STARTING_POINT("startingPoint"),
    @XmlEnumValue("creator")
    CREATOR("creator"),
    @XmlEnumValue("absolute")
    ABSOLUTE("absolute");
    private final String value;

    RelativeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RelativeType fromValue(String v) {
        for (RelativeType c: RelativeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
