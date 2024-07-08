//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.05.21 a las 01:14:30 PM COT 
//


package oracle.bpel.services.workflow.task.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para preActionUserStepType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="preActionUserStepType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userStep" type="{http://xmlns.oracle.com/bpel/workflow/task}preActionUserStepEnum"/>
 *         &lt;element name="outcome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "preActionUserStepType", propOrder = {
    "userStep",
    "outcome"
})
public class PreActionUserStepType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected PreActionUserStepEnum userStep;
    @XmlElement(required = true)
    protected String outcome;

    /**
     * Obtiene el valor de la propiedad userStep.
     * 
     * @return
     *     possible object is
     *     {@link PreActionUserStepEnum }
     *     
     */
    public PreActionUserStepEnum getUserStep() {
        return userStep;
    }

    /**
     * Define el valor de la propiedad userStep.
     * 
     * @param value
     *     allowed object is
     *     {@link PreActionUserStepEnum }
     *     
     */
    public void setUserStep(PreActionUserStepEnum value) {
        this.userStep = value;
    }

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

}
