
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
 * <p>Java class for recipientType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="recipientType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ASSIGNEES"/&gt;
 *     &lt;enumeration value="CREATOR"/&gt;
 *     &lt;enumeration value="APPROVERS"/&gt;
 *     &lt;enumeration value="OWNER"/&gt;
 *     &lt;enumeration value="REVIEWERS"/&gt;
 *     &lt;enumeration value="EMAILADDRESSES"/&gt;
 *     &lt;enumeration value="EMAILADDRESSESXPATH"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "recipientType")
@XmlEnum
public enum RecipientType {

    ASSIGNEES,
    CREATOR,
    APPROVERS,
    OWNER,
    REVIEWERS,
    EMAILADDRESSES,
    EMAILADDRESSESXPATH;

    public String value() {
        return name();
    }

    public static RecipientType fromValue(String v) {
        return valueOf(v);
    }

}
