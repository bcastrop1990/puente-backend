
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
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for attributeLabelTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="attributeLabelTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Text"/&gt;
 *     &lt;enumeration value="Form"/&gt;
 *     &lt;enumeration value="Url"/&gt;
 *     &lt;enumeration value="Date"/&gt;
 *     &lt;enumeration value="Number"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "attributeLabelTypeEnum")
@XmlEnum
public enum AttributeLabelTypeEnum {

    @XmlEnumValue("Text")
    TEXT("Text"),
    @XmlEnumValue("Form")
    FORM("Form"),
    @XmlEnumValue("Url")
    URL("Url"),
    @XmlEnumValue("Date")
    DATE("Date"),
    @XmlEnumValue("Number")
    NUMBER("Number");
    private final String value;

    AttributeLabelTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AttributeLabelTypeEnum fromValue(String v) {
        for (AttributeLabelTypeEnum c: AttributeLabelTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
