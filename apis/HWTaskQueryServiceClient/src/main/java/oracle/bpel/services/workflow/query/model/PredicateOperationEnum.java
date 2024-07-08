
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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for predicateOperationEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="predicateOperationEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="EQ"/&gt;
 *     &lt;enumeration value="NEQ"/&gt;
 *     &lt;enumeration value="GT"/&gt;
 *     &lt;enumeration value="GTE"/&gt;
 *     &lt;enumeration value="LT"/&gt;
 *     &lt;enumeration value="LTE"/&gt;
 *     &lt;enumeration value="LIKE"/&gt;
 *     &lt;enumeration value="NOT_LIKE"/&gt;
 *     &lt;enumeration value="IN"/&gt;
 *     &lt;enumeration value="NOT_IN"/&gt;
 *     &lt;enumeration value="CONTAINS"/&gt;
 *     &lt;enumeration value="NOT_CONTAINS"/&gt;
 *     &lt;enumeration value="BEGINS"/&gt;
 *     &lt;enumeration value="NOT_BEGINS"/&gt;
 *     &lt;enumeration value="ENDS"/&gt;
 *     &lt;enumeration value="NOT_ENDS"/&gt;
 *     &lt;enumeration value="BEFORE"/&gt;
 *     &lt;enumeration value="AFTER"/&gt;
 *     &lt;enumeration value="ON"/&gt;
 *     &lt;enumeration value="NEXT_N_DAYS"/&gt;
 *     &lt;enumeration value="LAST_N_DAYS"/&gt;
 *     &lt;enumeration value="IS_IN_FUTURE"/&gt;
 *     &lt;enumeration value="IS_IN_PAST"/&gt;
 *     &lt;enumeration value="IS_NULL"/&gt;
 *     &lt;enumeration value="IS_NOT_NULL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "predicateOperationEnum", namespace = "http://xmlns.oracle.com/bpel/workflow/taskQuery")
@XmlEnum
public enum PredicateOperationEnum {

    EQ,
    NEQ,
    GT,
    GTE,
    LT,
    LTE,
    LIKE,
    NOT_LIKE,
    IN,
    NOT_IN,
    CONTAINS,
    NOT_CONTAINS,
    BEGINS,
    NOT_BEGINS,
    ENDS,
    NOT_ENDS,
    BEFORE,
    AFTER,
    ON,
    NEXT_N_DAYS,
    LAST_N_DAYS,
    IS_IN_FUTURE,
    IS_IN_PAST,
    IS_NULL,
    IS_NOT_NULL;

    public String value() {
        return name();
    }

    public static PredicateOperationEnum fromValue(String v) {
        return valueOf(v);
    }

}
