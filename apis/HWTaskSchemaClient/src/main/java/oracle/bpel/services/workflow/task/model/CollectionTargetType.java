//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.05.21 a las 01:14:30 PM COT 
//


package oracle.bpel.services.workflow.task.model;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para collectionTargetType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="collectionTargetType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="xpath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="collectionName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="type" type="{http://xmlns.oracle.com/bpel/workflow/task}collectionTargetTypeEnum"/>
 *         &lt;choice>
 *           &lt;element name="targetIndex" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *           &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/task}keyList"/>
 *         &lt;/choice>
 *         &lt;element name="referencedTaskId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taskAggregationId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="action" type="{http://xmlns.oracle.com/bpel/workflow/task}collectionTargetActionType" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="displayName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "collectionTargetType", propOrder = {
    "id",
    "xpath",
    "collectionName",
    "type",
    "targetIndex",
    "keyList",
    "referencedTaskId",
    "taskAggregationId",
    "action",
    "status",
    "displayName"
})
public class CollectionTargetType {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String xpath;
    @XmlElement(required = true)
    protected String collectionName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected CollectionTargetTypeEnum type;
    protected BigInteger targetIndex;
    protected KeyListType keyList;
    protected String referencedTaskId;
    protected String taskAggregationId;
    protected CollectionTargetActionType action;
    protected String status;
    protected String displayName;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad xpath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXpath() {
        return xpath;
    }

    /**
     * Define el valor de la propiedad xpath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXpath(String value) {
        this.xpath = value;
    }

    /**
     * Obtiene el valor de la propiedad collectionName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollectionName() {
        return collectionName;
    }

    /**
     * Define el valor de la propiedad collectionName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollectionName(String value) {
        this.collectionName = value;
    }

    /**
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link CollectionTargetTypeEnum }
     *     
     */
    public CollectionTargetTypeEnum getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link CollectionTargetTypeEnum }
     *     
     */
    public void setType(CollectionTargetTypeEnum value) {
        this.type = value;
    }

    /**
     * Obtiene el valor de la propiedad targetIndex.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTargetIndex() {
        return targetIndex;
    }

    /**
     * Define el valor de la propiedad targetIndex.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTargetIndex(BigInteger value) {
        this.targetIndex = value;
    }

    /**
     * Obtiene el valor de la propiedad keyList.
     * 
     * @return
     *     possible object is
     *     {@link KeyListType }
     *     
     */
    public KeyListType getKeyList() {
        return keyList;
    }

    /**
     * Define el valor de la propiedad keyList.
     * 
     * @param value
     *     allowed object is
     *     {@link KeyListType }
     *     
     */
    public void setKeyList(KeyListType value) {
        this.keyList = value;
    }

    /**
     * Obtiene el valor de la propiedad referencedTaskId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferencedTaskId() {
        return referencedTaskId;
    }

    /**
     * Define el valor de la propiedad referencedTaskId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferencedTaskId(String value) {
        this.referencedTaskId = value;
    }

    /**
     * Obtiene el valor de la propiedad taskAggregationId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskAggregationId() {
        return taskAggregationId;
    }

    /**
     * Define el valor de la propiedad taskAggregationId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskAggregationId(String value) {
        this.taskAggregationId = value;
    }

    /**
     * Obtiene el valor de la propiedad action.
     * 
     * @return
     *     possible object is
     *     {@link CollectionTargetActionType }
     *     
     */
    public CollectionTargetActionType getAction() {
        return action;
    }

    /**
     * Define el valor de la propiedad action.
     * 
     * @param value
     *     allowed object is
     *     {@link CollectionTargetActionType }
     *     
     */
    public void setAction(CollectionTargetActionType value) {
        this.action = value;
    }

    /**
     * Obtiene el valor de la propiedad status.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define el valor de la propiedad status.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Obtiene el valor de la propiedad displayName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Define el valor de la propiedad displayName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayName(String value) {
        this.displayName = value;
    }

}
