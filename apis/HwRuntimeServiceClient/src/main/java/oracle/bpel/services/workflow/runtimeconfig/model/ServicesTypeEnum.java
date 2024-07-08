
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
 * <p>Java class for servicesTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="servicesTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ALL"/&gt;
 *     &lt;enumeration value="EVIDENCE"/&gt;
 *     &lt;enumeration value="IDENTITY"/&gt;
 *     &lt;enumeration value="NOTIFICATION"/&gt;
 *     &lt;enumeration value="RUNTIMECONFIG"/&gt;
 *     &lt;enumeration value="VERIFICATION_CACHE"/&gt;
 *     &lt;enumeration value="VERIFICATION_ACTIONS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "servicesTypeEnum")
@XmlEnum
public enum ServicesTypeEnum {

    ALL,
    EVIDENCE,
    IDENTITY,
    NOTIFICATION,
    RUNTIMECONFIG,
    VERIFICATION_CACHE,
    VERIFICATION_ACTIONS;

    public String value() {
        return name();
    }

    public static ServicesTypeEnum fromValue(String v) {
        return valueOf(v);
    }

}
