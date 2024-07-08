
package oracle.bpel.services.workflow.query.model;

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
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for actionsType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="actionsType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="allowInitiatorEditParticipants"/&gt;
 *     &lt;enumeration value="allowParticipantsEditParticipants"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "actionsType")
@XmlEnum
public enum ActionsType {

    @XmlEnumValue("allowInitiatorEditParticipants")
    ALLOW_INITIATOR_EDIT_PARTICIPANTS("allowInitiatorEditParticipants"),
    @XmlEnumValue("allowParticipantsEditParticipants")
    ALLOW_PARTICIPANTS_EDIT_PARTICIPANTS("allowParticipantsEditParticipants");
    private final String value;

    ActionsType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ActionsType fromValue(String v) {
        for (ActionsType c: ActionsType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
