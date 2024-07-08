//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.05.21 a las 01:14:30 PM COT 
//


package oracle.bpel.services.workflow.task.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para scaType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="scaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="applicationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="componentName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="compositeDN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="compositeInstanceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="compositeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="compositeVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ecId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parentComponentInstanceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parentComponentInstanceRefId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="headerProperties" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invokedComponent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="compositeCreatedTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="componentInstanceId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="flowId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="scaPartitionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "scaType", propOrder = {
    "applicationName",
    "componentName",
    "compositeDN",
    "compositeInstanceId",
    "compositeName",
    "compositeVersion",
    "ecId",
    "parentComponentInstanceId",
    "parentComponentInstanceRefId",
    "headerProperties",
    "invokedComponent",
    "compositeCreatedTime",
    "componentInstanceId",
    "flowId",
    "scaPartitionId"
})
public class ScaType {

    protected String applicationName;
    protected String componentName;
    protected String compositeDN;
    protected String compositeInstanceId;
    protected String compositeName;
    protected String compositeVersion;
    protected String ecId;
    protected String parentComponentInstanceId;
    protected String parentComponentInstanceRefId;
    protected String headerProperties;
    protected String invokedComponent;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar compositeCreatedTime;
    protected Long componentInstanceId;
    protected Long flowId;
    protected Long scaPartitionId;

    /**
     * Obtiene el valor de la propiedad applicationName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     * Define el valor de la propiedad applicationName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationName(String value) {
        this.applicationName = value;
    }

    /**
     * Obtiene el valor de la propiedad componentName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComponentName() {
        return componentName;
    }

    /**
     * Define el valor de la propiedad componentName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComponentName(String value) {
        this.componentName = value;
    }

    /**
     * Obtiene el valor de la propiedad compositeDN.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompositeDN() {
        return compositeDN;
    }

    /**
     * Define el valor de la propiedad compositeDN.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompositeDN(String value) {
        this.compositeDN = value;
    }

    /**
     * Obtiene el valor de la propiedad compositeInstanceId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompositeInstanceId() {
        return compositeInstanceId;
    }

    /**
     * Define el valor de la propiedad compositeInstanceId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompositeInstanceId(String value) {
        this.compositeInstanceId = value;
    }

    /**
     * Obtiene el valor de la propiedad compositeName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompositeName() {
        return compositeName;
    }

    /**
     * Define el valor de la propiedad compositeName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompositeName(String value) {
        this.compositeName = value;
    }

    /**
     * Obtiene el valor de la propiedad compositeVersion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompositeVersion() {
        return compositeVersion;
    }

    /**
     * Define el valor de la propiedad compositeVersion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompositeVersion(String value) {
        this.compositeVersion = value;
    }

    /**
     * Obtiene el valor de la propiedad ecId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEcId() {
        return ecId;
    }

    /**
     * Define el valor de la propiedad ecId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEcId(String value) {
        this.ecId = value;
    }

    /**
     * Obtiene el valor de la propiedad parentComponentInstanceId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentComponentInstanceId() {
        return parentComponentInstanceId;
    }

    /**
     * Define el valor de la propiedad parentComponentInstanceId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentComponentInstanceId(String value) {
        this.parentComponentInstanceId = value;
    }

    /**
     * Obtiene el valor de la propiedad parentComponentInstanceRefId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentComponentInstanceRefId() {
        return parentComponentInstanceRefId;
    }

    /**
     * Define el valor de la propiedad parentComponentInstanceRefId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentComponentInstanceRefId(String value) {
        this.parentComponentInstanceRefId = value;
    }

    /**
     * Obtiene el valor de la propiedad headerProperties.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeaderProperties() {
        return headerProperties;
    }

    /**
     * Define el valor de la propiedad headerProperties.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeaderProperties(String value) {
        this.headerProperties = value;
    }

    /**
     * Obtiene el valor de la propiedad invokedComponent.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvokedComponent() {
        return invokedComponent;
    }

    /**
     * Define el valor de la propiedad invokedComponent.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvokedComponent(String value) {
        this.invokedComponent = value;
    }

    /**
     * Obtiene el valor de la propiedad compositeCreatedTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCompositeCreatedTime() {
        return compositeCreatedTime;
    }

    /**
     * Define el valor de la propiedad compositeCreatedTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCompositeCreatedTime(XMLGregorianCalendar value) {
        this.compositeCreatedTime = value;
    }

    /**
     * Obtiene el valor de la propiedad componentInstanceId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getComponentInstanceId() {
        return componentInstanceId;
    }

    /**
     * Define el valor de la propiedad componentInstanceId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setComponentInstanceId(Long value) {
        this.componentInstanceId = value;
    }

    /**
     * Obtiene el valor de la propiedad flowId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFlowId() {
        return flowId;
    }

    /**
     * Define el valor de la propiedad flowId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFlowId(Long value) {
        this.flowId = value;
    }

    /**
     * Obtiene el valor de la propiedad scaPartitionId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getScaPartitionId() {
        return scaPartitionId;
    }

    /**
     * Define el valor de la propiedad scaPartitionId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setScaPartitionId(Long value) {
        this.scaPartitionId = value;
    }

}
