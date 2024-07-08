
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
 * <p>Java class for earlyCompletionCompleteType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="earlyCompletionCompleteType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="root"/&gt;
 *     &lt;enumeration value="current"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "earlyCompletionCompleteType")
@XmlEnum
public enum EarlyCompletionCompleteType {

    @XmlEnumValue("root")
    ROOT("root"),
    @XmlEnumValue("current")
    CURRENT("current");
    private final String value;

    EarlyCompletionCompleteType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EarlyCompletionCompleteType fromValue(String v) {
        for (EarlyCompletionCompleteType c: EarlyCompletionCompleteType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
