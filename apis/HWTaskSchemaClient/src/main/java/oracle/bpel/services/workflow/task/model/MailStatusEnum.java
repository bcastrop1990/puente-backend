//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.05.21 a las 01:14:30 PM COT 
//


package oracle.bpel.services.workflow.task.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para mailStatusEnum.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="mailStatusEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ERRORED"/>
 *     &lt;enumeration value="RETRY"/>
 *     &lt;enumeration value="SENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "mailStatusEnum")
@XmlEnum
public enum MailStatusEnum {

    ERRORED,
    RETRY,
    SENT;

    public String value() {
        return name();
    }

    public static MailStatusEnum fromValue(String v) {
        return valueOf(v);
    }

}