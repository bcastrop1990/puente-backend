//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.05.21 a las 01:15:07 PM COT 
//


package com.oracle.xmlns.bpel.workflow.task;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para taskActionType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="taskActionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="GOFORWARD"/>
 *     &lt;enumeration value="PUSHBACK"/>
 *     &lt;enumeration value="COMPLETE"/>
 *     &lt;enumeration value="ESCALATE"/>
 *     &lt;enumeration value="GOTO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "taskActionType")
@XmlEnum
public enum TaskActionType {

    GOFORWARD,
    PUSHBACK,
    COMPLETE,
    ESCALATE,
    GOTO;

    public String value() {
        return name();
    }

    public static TaskActionType fromValue(String v) {
        return valueOf(v);
    }

}
