
package proxy.senasaws.tramite;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for reciboPago complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="reciboPago">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fechaHora" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroExpediente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroRecibo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sedeSenasa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="valorPagado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="valorSaldo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reciboPago", propOrder = {
    "fechaHora",
    "numeroExpediente",
    "numeroRecibo",
    "sedeSenasa",
    "valorPagado",
    "valorSaldo"
})
public class ReciboPago {

    protected String fechaHora;
    protected String numeroExpediente;
    protected String numeroRecibo;
    protected String sedeSenasa;
    protected String valorPagado;
    protected String valorSaldo;

    /**
     * Gets the value of the fechaHora property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaHora() {
        return fechaHora;
    }

    /**
     * Sets the value of the fechaHora property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaHora(String value) {
        this.fechaHora = value;
    }

    /**
     * Gets the value of the numeroExpediente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroExpediente() {
        return numeroExpediente;
    }

    /**
     * Sets the value of the numeroExpediente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroExpediente(String value) {
        this.numeroExpediente = value;
    }

    /**
     * Gets the value of the numeroRecibo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroRecibo() {
        return numeroRecibo;
    }

    /**
     * Sets the value of the numeroRecibo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroRecibo(String value) {
        this.numeroRecibo = value;
    }

    /**
     * Gets the value of the sedeSenasa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSedeSenasa() {
        return sedeSenasa;
    }

    /**
     * Sets the value of the sedeSenasa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSedeSenasa(String value) {
        this.sedeSenasa = value;
    }

    /**
     * Gets the value of the valorPagado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValorPagado() {
        return valorPagado;
    }

    /**
     * Sets the value of the valorPagado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValorPagado(String value) {
        this.valorPagado = value;
    }

    /**
     * Gets the value of the valorSaldo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValorSaldo() {
        return valorSaldo;
    }

    /**
     * Sets the value of the valorSaldo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValorSaldo(String value) {
        this.valorSaldo = value;
    }

}
