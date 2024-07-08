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
import oracle.bpel.services.workflow.common.model.WorkflowContextType;


/**
 * <p>Clase Java para UpdateEvidenceRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="UpdateEvidenceRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/common}workflowContext" minOccurs="0"/>
 *         &lt;element name="evidenceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UpdatableEvidenceAttributes" type="{http://xmlns.oracle.com/bpel/workflow/TaskEvidenceService}UpdatableEvidenceAttributesType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateEvidenceRequestType", propOrder = {
    "workflowContext",
    "evidenceId",
    "updatableEvidenceAttributes"
})
public class UpdateEvidenceRequestType {

    @XmlElement(namespace = "http://xmlns.oracle.com/bpel/workflow/common")
    protected WorkflowContextType workflowContext;
    @XmlElement(required = true)
    protected String evidenceId;
    @XmlElement(name = "UpdatableEvidenceAttributes", required = true)
    protected UpdatableEvidenceAttributesType updatableEvidenceAttributes;

    /**
     * Obtiene el valor de la propiedad workflowContext.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowContextType }
     *     
     */
    public WorkflowContextType getWorkflowContext() {
        return workflowContext;
    }

    /**
     * Define el valor de la propiedad workflowContext.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowContextType }
     *     
     */
    public void setWorkflowContext(WorkflowContextType value) {
        this.workflowContext = value;
    }

    /**
     * Obtiene el valor de la propiedad evidenceId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvidenceId() {
        return evidenceId;
    }

    /**
     * Define el valor de la propiedad evidenceId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvidenceId(String value) {
        this.evidenceId = value;
    }

    /**
     * Obtiene el valor de la propiedad updatableEvidenceAttributes.
     * 
     * @return
     *     possible object is
     *     {@link UpdatableEvidenceAttributesType }
     *     
     */
    public UpdatableEvidenceAttributesType getUpdatableEvidenceAttributes() {
        return updatableEvidenceAttributes;
    }

    /**
     * Define el valor de la propiedad updatableEvidenceAttributes.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdatableEvidenceAttributesType }
     *     
     */
    public void setUpdatableEvidenceAttributes(UpdatableEvidenceAttributesType value) {
        this.updatableEvidenceAttributes = value;
    }

}
