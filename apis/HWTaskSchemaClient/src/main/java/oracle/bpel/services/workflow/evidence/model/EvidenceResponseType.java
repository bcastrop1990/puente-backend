//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.05.21 a las 01:14:30 PM COT 
//


package oracle.bpel.services.workflow.evidence.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EvidenceResponseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EvidenceResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/TaskEvidenceService}evidence" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EvidenceResponseType", propOrder = {
    "evidence"
})
public class EvidenceResponseType {

    protected EvidenceType evidence;

    /**
     * Obtiene el valor de la propiedad evidence.
     * 
     * @return
     *     possible object is
     *     {@link EvidenceType }
     *     
     */
    public EvidenceType getEvidence() {
        return evidence;
    }

    /**
     * Define el valor de la propiedad evidence.
     * 
     * @param value
     *     allowed object is
     *     {@link EvidenceType }
     *     
     */
    public void setEvidence(EvidenceType value) {
        this.evidence = value;
    }

}
