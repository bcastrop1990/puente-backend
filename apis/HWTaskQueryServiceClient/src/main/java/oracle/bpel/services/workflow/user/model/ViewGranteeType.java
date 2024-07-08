
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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import oracle.bpel.services.workflow.common.model.PrincipleRefType;


/**
 * <p>Java class for viewGranteeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="viewGranteeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://xmlns.oracle.com/bpel/workflow/common}principleRefType"&gt;
 *       &lt;attribute name="grantType" use="required" type="{http://xmlns.oracle.com/bpel/workflow/userMetadata}grantTypeEnum" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "viewGranteeType")
public class ViewGranteeType
    extends PrincipleRefType
{

    @XmlAttribute(name = "grantType", required = true)
    protected GrantTypeEnum grantType;

    /**
     * Gets the value of the grantType property.
     * 
     * @return
     *     possible object is
     *     {@link GrantTypeEnum }
     *     
     */
    public GrantTypeEnum getGrantType() {
        return grantType;
    }

    /**
     * Sets the value of the grantType property.
     * 
     * @param value
     *     allowed object is
     *     {@link GrantTypeEnum }
     *     
     */
    public void setGrantType(GrantTypeEnum value) {
        this.grantType = value;
    }

}
