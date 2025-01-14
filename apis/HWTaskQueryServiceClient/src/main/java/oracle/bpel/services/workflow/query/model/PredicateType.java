
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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for predicateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="predicateType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;sequence minOccurs="0"&gt;
 *             &lt;element name="lhs" type="{http://xmlns.oracle.com/bpel/workflow/taskQuery}predicateType"/&gt;
 *             &lt;element name="logicalOperator" type="{http://xmlns.oracle.com/bpel/workflow/taskQuery}predicateJoinOperatorEnum"/&gt;
 *             &lt;element name="rhs" type="{http://xmlns.oracle.com/bpel/workflow/taskQuery}predicateType"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;element name="clause" type="{http://xmlns.oracle.com/bpel/workflow/taskQuery}clauseType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "predicateType", namespace = "http://xmlns.oracle.com/bpel/workflow/taskQuery", propOrder = {
    "lhs",
    "logicalOperator",
    "rhs",
    "clause"
})
public class PredicateType {

    protected PredicateType lhs;
    @XmlSchemaType(name = "string")
    protected PredicateJoinOperatorEnum logicalOperator;
    protected PredicateType rhs;
    protected List<ClauseType> clause;

    /**
     * Gets the value of the lhs property.
     * 
     * @return
     *     possible object is
     *     {@link PredicateType }
     *     
     */
    public PredicateType getLhs() {
        return lhs;
    }

    /**
     * Sets the value of the lhs property.
     * 
     * @param value
     *     allowed object is
     *     {@link PredicateType }
     *     
     */
    public void setLhs(PredicateType value) {
        this.lhs = value;
    }

    /**
     * Gets the value of the logicalOperator property.
     * 
     * @return
     *     possible object is
     *     {@link PredicateJoinOperatorEnum }
     *     
     */
    public PredicateJoinOperatorEnum getLogicalOperator() {
        return logicalOperator;
    }

    /**
     * Sets the value of the logicalOperator property.
     * 
     * @param value
     *     allowed object is
     *     {@link PredicateJoinOperatorEnum }
     *     
     */
    public void setLogicalOperator(PredicateJoinOperatorEnum value) {
        this.logicalOperator = value;
    }

    /**
     * Gets the value of the rhs property.
     * 
     * @return
     *     possible object is
     *     {@link PredicateType }
     *     
     */
    public PredicateType getRhs() {
        return rhs;
    }

    /**
     * Sets the value of the rhs property.
     * 
     * @param value
     *     allowed object is
     *     {@link PredicateType }
     *     
     */
    public void setRhs(PredicateType value) {
        this.rhs = value;
    }

    /**
     * Gets the value of the clause property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clause property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClause().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClauseType }
     * 
     * 
     */
    public List<ClauseType> getClause() {
        if (clause == null) {
            clause = new ArrayList<ClauseType>();
        }
        return this.clause;
    }

}
