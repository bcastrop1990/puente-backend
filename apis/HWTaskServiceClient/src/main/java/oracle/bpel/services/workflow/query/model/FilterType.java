
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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FilterType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FilterType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice maxOccurs="unbounded"&gt;
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/taskQueryService}filter"/&gt;
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/taskQueryService}filterPredicate"/&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute name="unaryOperator" type="{http://xmlns.oracle.com/bpel/workflow/taskQueryService}UnaryOperatorEnumType" fixed="NOT" /&gt;
 *       &lt;attribute name="logicalOperator" type="{http://xmlns.oracle.com/bpel/workflow/taskQueryService}LogicalOperatorEnumType" default="AND" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FilterType", propOrder = {
    "filterOrFilterPredicate"
})
public class FilterType {

    @XmlElements({
        @XmlElement(name = "filter", type = FilterType.class),
        @XmlElement(name = "filterPredicate", type = FilterPredicateType.class)
    })
    protected List<Object> filterOrFilterPredicate;
    @XmlAttribute(name = "unaryOperator")
    protected UnaryOperatorEnumType unaryOperator;
    @XmlAttribute(name = "logicalOperator")
    protected LogicalOperatorEnumType logicalOperator;

    /**
     * Gets the value of the filterOrFilterPredicate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the filterOrFilterPredicate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilterOrFilterPredicate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FilterType }
     * {@link FilterPredicateType }
     * 
     * 
     */
    public List<Object> getFilterOrFilterPredicate() {
        if (filterOrFilterPredicate == null) {
            filterOrFilterPredicate = new ArrayList<Object>();
        }
        return this.filterOrFilterPredicate;
    }

    /**
     * Gets the value of the unaryOperator property.
     * 
     * @return
     *     possible object is
     *     {@link UnaryOperatorEnumType }
     *     
     */
    public UnaryOperatorEnumType getUnaryOperator() {
        if (unaryOperator == null) {
            return UnaryOperatorEnumType.NOT;
        } else {
            return unaryOperator;
        }
    }

    /**
     * Sets the value of the unaryOperator property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnaryOperatorEnumType }
     *     
     */
    public void setUnaryOperator(UnaryOperatorEnumType value) {
        this.unaryOperator = value;
    }

    /**
     * Gets the value of the logicalOperator property.
     * 
     * @return
     *     possible object is
     *     {@link LogicalOperatorEnumType }
     *     
     */
    public LogicalOperatorEnumType getLogicalOperator() {
        if (logicalOperator == null) {
            return LogicalOperatorEnumType.AND;
        } else {
            return logicalOperator;
        }
    }

    /**
     * Sets the value of the logicalOperator property.
     * 
     * @param value
     *     allowed object is
     *     {@link LogicalOperatorEnumType }
     *     
     */
    public void setLogicalOperator(LogicalOperatorEnumType value) {
        this.logicalOperator = value;
    }

}
