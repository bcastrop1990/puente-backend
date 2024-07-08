
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
 * <p>Java class for attributeLabelTypeRequestEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="attributeLabelTypeRequestEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Public"/&gt;
 *     &lt;enumeration value="Protected"/&gt;
 *     &lt;enumeration value="Text"/&gt;
 *     &lt;enumeration value="Form"/&gt;
 *     &lt;enumeration value="Url"/&gt;
 *     &lt;enumeration value="Date"/&gt;
 *     &lt;enumeration value="Number"/&gt;
 *     &lt;enumeration value="PublicText"/&gt;
 *     &lt;enumeration value="PublicForm"/&gt;
 *     &lt;enumeration value="PublicUrl"/&gt;
 *     &lt;enumeration value="PublicDate"/&gt;
 *     &lt;enumeration value="PublicNumber"/&gt;
 *     &lt;enumeration value="ProtectedText"/&gt;
 *     &lt;enumeration value="ProtectedForm"/&gt;
 *     &lt;enumeration value="ProtectedUrl"/&gt;
 *     &lt;enumeration value="ProtectedDate"/&gt;
 *     &lt;enumeration value="ProtectedNumber"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "attributeLabelTypeRequestEnum")
@XmlEnum
public enum AttributeLabelTypeRequestEnum {

    @XmlEnumValue("Public")
    PUBLIC("Public"),
    @XmlEnumValue("Protected")
    PROTECTED("Protected"),
    @XmlEnumValue("Text")
    TEXT("Text"),
    @XmlEnumValue("Form")
    FORM("Form"),
    @XmlEnumValue("Url")
    URL("Url"),
    @XmlEnumValue("Date")
    DATE("Date"),
    @XmlEnumValue("Number")
    NUMBER("Number"),
    @XmlEnumValue("PublicText")
    PUBLIC_TEXT("PublicText"),
    @XmlEnumValue("PublicForm")
    PUBLIC_FORM("PublicForm"),
    @XmlEnumValue("PublicUrl")
    PUBLIC_URL("PublicUrl"),
    @XmlEnumValue("PublicDate")
    PUBLIC_DATE("PublicDate"),
    @XmlEnumValue("PublicNumber")
    PUBLIC_NUMBER("PublicNumber"),
    @XmlEnumValue("ProtectedText")
    PROTECTED_TEXT("ProtectedText"),
    @XmlEnumValue("ProtectedForm")
    PROTECTED_FORM("ProtectedForm"),
    @XmlEnumValue("ProtectedUrl")
    PROTECTED_URL("ProtectedUrl"),
    @XmlEnumValue("ProtectedDate")
    PROTECTED_DATE("ProtectedDate"),
    @XmlEnumValue("ProtectedNumber")
    PROTECTED_NUMBER("ProtectedNumber");
    private final String value;

    AttributeLabelTypeRequestEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AttributeLabelTypeRequestEnum fromValue(String v) {
        for (AttributeLabelTypeRequestEnum c: AttributeLabelTypeRequestEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
