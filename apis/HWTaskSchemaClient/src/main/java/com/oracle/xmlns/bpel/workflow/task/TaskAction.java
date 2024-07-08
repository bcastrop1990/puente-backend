//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.05.21 a las 01:15:07 PM COT 
//


package com.oracle.xmlns.bpel.workflow.task;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;attribute name="action" use="required" type="{http://xmlns.oracle.com/bpel/workflow/task}taskActionType" />
 *       &lt;attribute name="targetParticipant" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "taskAction")
public class TaskAction {

    @XmlAttribute(name = "action", required = true)
    protected TaskActionType action;
    @XmlAttribute(name = "targetParticipant")
    protected String targetParticipant;

    /**
     * Obtiene el valor de la propiedad action.
     * 
     * @return
     *     possible object is
     *     {@link TaskActionType }
     *     
     */
    public TaskActionType getAction() {
        return action;
    }

    /**
     * Define el valor de la propiedad action.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskActionType }
     *     
     */
    public void setAction(TaskActionType value) {
        this.action = value;
    }

    /**
     * Obtiene el valor de la propiedad targetParticipant.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetParticipant() {
        return targetParticipant;
    }

    /**
     * Define el valor de la propiedad targetParticipant.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetParticipant(String value) {
        this.targetParticipant = value;
    }

}
