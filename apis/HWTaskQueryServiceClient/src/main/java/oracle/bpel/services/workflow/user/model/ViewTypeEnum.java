
package oracle.bpel.services.workflow.user.model;

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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for viewTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="viewTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="INBOX"/&gt;
 *     &lt;enumeration value="VIEW"/&gt;
 *     &lt;enumeration value="STANDARD_VIEW"/&gt;
 *     &lt;enumeration value="PROCESS_VIEW"/&gt;
 *     &lt;enumeration value="STANDARD_PROCESS_VIEW"/&gt;
 *     &lt;enumeration value="REPORT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "viewTypeEnum")
@XmlEnum
public enum ViewTypeEnum {

    INBOX,
    VIEW,
    STANDARD_VIEW,
    PROCESS_VIEW,
    STANDARD_PROCESS_VIEW,
    REPORT;

    public String value() {
        return name();
    }

    public static ViewTypeEnum fromValue(String v) {
        return valueOf(v);
    }

}
