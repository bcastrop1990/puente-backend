//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.05.21 a las 01:14:30 PM COT 
//


package oracle.bpel.services.workflow.evidence.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EvidenceListResponseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EvidenceListResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/TaskEvidenceService}evidenceList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EvidenceListResponseType", propOrder = {
    "evidenceList"
})
public class EvidenceListResponseType {

    @XmlElement(required = true)
    protected EvidenceListType evidenceList;

    /**
     * Obtiene el valor de la propiedad evidenceList.
     * 
     * @return
     *     possible object is
     *     {@link EvidenceListType }
     *     
     */
    public EvidenceListType getEvidenceList() {
        return evidenceList;
    }

    /**
     * Define el valor de la propiedad evidenceList.
     * 
     * @param value
     *     allowed object is
     *     {@link EvidenceListType }
     *     
     */
    public void setEvidenceList(EvidenceListType value) {
        this.evidenceList = value;
    }

}
