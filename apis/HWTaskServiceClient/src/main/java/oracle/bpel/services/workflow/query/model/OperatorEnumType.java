
package oracle.bpel.services.workflow.query.model;

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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OperatorEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OperatorEnumType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="EQUAL"/&gt;
 *     &lt;enumeration value="NOTEQ"/&gt;
 *     &lt;enumeration value="LESS"/&gt;
 *     &lt;enumeration value="MORE"/&gt;
 *     &lt;enumeration value="MOREEQ"/&gt;
 *     &lt;enumeration value="EQLESS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "OperatorEnumType")
@XmlEnum
public enum OperatorEnumType {

    EQUAL,
    NOTEQ,
    LESS,
    MORE,
    MOREEQ,
    EQLESS;

    public String value() {
        return name();
    }

    public static OperatorEnumType fromValue(String v) {
        return valueOf(v);
    }

}
