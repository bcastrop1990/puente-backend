
package oracle.bpel.services.workflow.runtimeconfig.model;

/*
 * #%L
 * TUPA: Integration: BPM-Client: HW Runtime Service Client
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
 * <p>Java class for formatTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="formatTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="NUMBER"/&gt;
 *     &lt;enumeration value="INTEGER"/&gt;
 *     &lt;enumeration value="CURRENCY"/&gt;
 *     &lt;enumeration value="PERCENTAGE"/&gt;
 *     &lt;enumeration value="DATETIME_SHORT"/&gt;
 *     &lt;enumeration value="DATETIME_MEDIUM"/&gt;
 *     &lt;enumeration value="DATETIME_LONG"/&gt;
 *     &lt;enumeration value="DATETIME_FULL"/&gt;
 *     &lt;enumeration value="DATE_SHORT"/&gt;
 *     &lt;enumeration value="DATE_MEDIUM"/&gt;
 *     &lt;enumeration value="DATE_LONG"/&gt;
 *     &lt;enumeration value="DATE_FULL"/&gt;
 *     &lt;enumeration value="TIME_SHORT"/&gt;
 *     &lt;enumeration value="TIME_MEDIUM"/&gt;
 *     &lt;enumeration value="TIME_LONG"/&gt;
 *     &lt;enumeration value="TIME_FULL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "formatTypeEnum")
@XmlEnum
public enum FormatTypeEnum {

    NUMBER,
    INTEGER,
    CURRENCY,
    PERCENTAGE,
    DATETIME_SHORT,
    DATETIME_MEDIUM,
    DATETIME_LONG,
    DATETIME_FULL,
    DATE_SHORT,
    DATE_MEDIUM,
    DATE_LONG,
    DATE_FULL,
    TIME_SHORT,
    TIME_MEDIUM,
    TIME_LONG,
    TIME_FULL;

    public String value() {
        return name();
    }

    public static FormatTypeEnum fromValue(String v) {
        return valueOf(v);
    }

}
