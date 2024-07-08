
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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sharePayloadConfigurationTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="sharePayloadConfigurationTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="USE_SYSTEM_WIDE_GLOBAL_CONFIGURATION"/&gt;
 *     &lt;enumeration value="ENABLE"/&gt;
 *     &lt;enumeration value="DISABLE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "sharePayloadConfigurationTypeEnum")
@XmlEnum
public enum SharePayloadConfigurationTypeEnum {

    USE_SYSTEM_WIDE_GLOBAL_CONFIGURATION,
    ENABLE,
    DISABLE;

    public String value() {
        return name();
    }

    public static SharePayloadConfigurationTypeEnum fromValue(String v) {
        return valueOf(v);
    }

}
