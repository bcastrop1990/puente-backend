//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.05.21 a las 01:15:07 PM COT 
//


package com.oracle.xmlns.bpel.workflow.task;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="outcome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="logicalParticipant" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="actualParticipant" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="level" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="totalNumberOfApprovals" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "outcome",
    "logicalParticipant",
    "actualParticipant",
    "level",
    "totalNumberOfApprovals"
})
@XmlRootElement(name = "previousOutcome")
public class PreviousOutcome {

    @XmlElement(required = true)
    protected String outcome;
    @XmlElement(required = true)
    protected String logicalParticipant;
    @XmlElement(required = true)
    protected String actualParticipant;
    protected Integer level;
    protected int totalNumberOfApprovals;

    /**
     * Obtiene el valor de la propiedad outcome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutcome() {
        return outcome;
    }

    /**
     * Define el valor de la propiedad outcome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutcome(String value) {
        this.outcome = value;
    }

    /**
     * Obtiene el valor de la propiedad logicalParticipant.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogicalParticipant() {
        return logicalParticipant;
    }

    /**
     * Define el valor de la propiedad logicalParticipant.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogicalParticipant(String value) {
        this.logicalParticipant = value;
    }

    /**
     * Obtiene el valor de la propiedad actualParticipant.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActualParticipant() {
        return actualParticipant;
    }

    /**
     * Define el valor de la propiedad actualParticipant.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActualParticipant(String value) {
        this.actualParticipant = value;
    }

    /**
     * Obtiene el valor de la propiedad level.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * Define el valor de la propiedad level.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLevel(Integer value) {
        this.level = value;
    }

    /**
     * Obtiene el valor de la propiedad totalNumberOfApprovals.
     * 
     */
    public int getTotalNumberOfApprovals() {
        return totalNumberOfApprovals;
    }

    /**
     * Define el valor de la propiedad totalNumberOfApprovals.
     * 
     */
    public void setTotalNumberOfApprovals(int value) {
        this.totalNumberOfApprovals = value;
    }

}
