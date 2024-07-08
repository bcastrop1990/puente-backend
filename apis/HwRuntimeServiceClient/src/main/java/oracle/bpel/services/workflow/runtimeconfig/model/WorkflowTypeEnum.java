
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
 * <p>Java class for workflowTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="workflowTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="BPEL_WF_10.1.3"/&gt;
 *     &lt;enumeration value="BPEL_WF_10.1.2"/&gt;
 *     &lt;enumeration value="ORACLE_WF"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "workflowTypeEnum")
@XmlEnum
public enum WorkflowTypeEnum {

    @XmlEnumValue("BPEL_WF_10.1.3")
    BPEL_WF_10_1_3("BPEL_WF_10.1.3"),
    @XmlEnumValue("BPEL_WF_10.1.2")
    BPEL_WF_10_1_2("BPEL_WF_10.1.2"),
    ORACLE_WF("ORACLE_WF");
    private final String value;

    WorkflowTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WorkflowTypeEnum fromValue(String v) {
        for (WorkflowTypeEnum c: WorkflowTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
