
package com.oracle.bpmn.process.bpmtupa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *       &lt;sequence>
 *         &lt;element name="codigoServicio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idOrdenVuce" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nroExpediente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "codigoServicio",
    "idOrdenVuce",
    "nroExpediente"
})
@XmlRootElement(name = "start")
public class Start {

    @XmlElement(required = true)
    protected String codigoServicio;
    @XmlElement(required = true)
    protected String idOrdenVuce;
    @XmlElement(required = true)
    protected String nroExpediente;

    /**
     * Obtiene el valor de la propiedad codigoServicio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoServicio() {
        return codigoServicio;
    }

    /**
     * Define el valor de la propiedad codigoServicio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoServicio(String value) {
        this.codigoServicio = value;
    }

    /**
     * Obtiene el valor de la propiedad idOrdenVuce.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdOrdenVuce() {
        return idOrdenVuce;
    }

    /**
     * Define el valor de la propiedad idOrdenVuce.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdOrdenVuce(String value) {
        this.idOrdenVuce = value;
    }

    /**
     * Obtiene el valor de la propiedad nroExpediente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNroExpediente() {
        return nroExpediente;
    }

    /**
     * Define el valor de la propiedad nroExpediente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNroExpediente(String value) {
        this.nroExpediente = value;
    }

}
