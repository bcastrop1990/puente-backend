//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.05.21 a las 01:14:30 PM COT 
//


package oracle.bpel.services.workflow.task.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para stateEnum.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="stateEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ASSIGNED"/>
 *     &lt;enumeration value="ALERTED"/>
 *     &lt;enumeration value="COMPLETED"/>
 *     &lt;enumeration value="ERRORED"/>
 *     &lt;enumeration value="EXPIRED"/>
 *     &lt;enumeration value="INFO_REQUESTED"/>
 *     &lt;enumeration value="OUTCOME_UPDATED"/>
 *     &lt;enumeration value="STALE"/>
 *     &lt;enumeration value="SUSPENDED"/>
 *     &lt;enumeration value="WITHDRAWN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "stateEnum")
@XmlEnum
public enum StateEnum {

    ASSIGNED,
    ALERTED,
    COMPLETED,
    ERRORED,
    EXPIRED,
    INFO_REQUESTED,
    OUTCOME_UPDATED,
    STALE,
    SUSPENDED,
    WITHDRAWN;

    public String value() {
        return name();
    }

    public static StateEnum fromValue(String v) {
        return valueOf(v);
    }

}
