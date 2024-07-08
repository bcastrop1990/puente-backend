
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
 * <p>Java class for groupNotificationConfigurationTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="groupNotificationConfigurationTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="SEND_INDIVIDUAL_NOTIFICATION"/&gt;
 *     &lt;enumeration value="SEND_SHARED_EMAIL_TO_ALL_GROUP_MEMBER_EMAILID"/&gt;
 *     &lt;enumeration value="ADD_ALL_RECIPIENTS_IN_TO_LIST"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "groupNotificationConfigurationTypeEnum")
@XmlEnum
public enum GroupNotificationConfigurationTypeEnum {

    SEND_INDIVIDUAL_NOTIFICATION,
    SEND_SHARED_EMAIL_TO_ALL_GROUP_MEMBER_EMAILID,
    ADD_ALL_RECIPIENTS_IN_TO_LIST;

    public String value() {
        return name();
    }

    public static GroupNotificationConfigurationTypeEnum fromValue(String v) {
        return valueOf(v);
    }

}