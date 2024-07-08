
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
 * <p>Java class for disconnectedModeTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="disconnectedModeTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="server"/&gt;
 *     &lt;enumeration value="client"/&gt;
 *     &lt;enumeration value="both"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "disconnectedModeTypeEnum")
@XmlEnum
public enum DisconnectedModeTypeEnum {

    @XmlEnumValue("server")
    SERVER("server"),
    @XmlEnumValue("client")
    CLIENT("client"),
    @XmlEnumValue("both")
    BOTH("both");
    private final String value;

    DisconnectedModeTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DisconnectedModeTypeEnum fromValue(String v) {
        for (DisconnectedModeTypeEnum c: DisconnectedModeTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
