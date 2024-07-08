
package proxy.senasaws.tramite;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for lugaresProduccionCPE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="lugaresProduccionCPE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="area" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="departamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descDepartamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descDistrito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descProvincia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="direccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="distrito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaInspeccion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="flagVuce" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="indicadorAcpt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="observacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="provincia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recomendacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="secuencial" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tipoPredio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lugaresProduccionCPE", propOrder = {
    "area",
    "departamento",
    "descDepartamento",
    "descDistrito",
    "descProvincia",
    "direccion",
    "distrito",
    "fechaInspeccion",
    "flagVuce",
    "indicadorAcpt",
    "nombre",
    "observacion",
    "provincia",
    "recomendacion",
    "secuencial",
    "tipoPredio"
})
public class LugaresProduccionCPE {

    protected Double area;
    protected String departamento;
    protected String descDepartamento;
    protected String descDistrito;
    protected String descProvincia;
    protected String direccion;
    protected String distrito;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaInspeccion;
    protected int flagVuce;
    protected String indicadorAcpt;
    protected String nombre;
    protected String observacion;
    protected String provincia;
    protected String recomendacion;
    protected int secuencial;
    protected String tipoPredio;

    /**
     * Gets the value of the area property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getArea() {
        return area;
    }

    /**
     * Sets the value of the area property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setArea(Double value) {
        this.area = value;
    }

    /**
     * Gets the value of the departamento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Sets the value of the departamento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartamento(String value) {
        this.departamento = value;
    }

    /**
     * Gets the value of the descDepartamento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescDepartamento() {
        return descDepartamento;
    }

    /**
     * Sets the value of the descDepartamento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescDepartamento(String value) {
        this.descDepartamento = value;
    }

    /**
     * Gets the value of the descDistrito property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescDistrito() {
        return descDistrito;
    }

    /**
     * Sets the value of the descDistrito property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescDistrito(String value) {
        this.descDistrito = value;
    }

    /**
     * Gets the value of the descProvincia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescProvincia() {
        return descProvincia;
    }

    /**
     * Sets the value of the descProvincia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescProvincia(String value) {
        this.descProvincia = value;
    }

    /**
     * Gets the value of the direccion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Sets the value of the direccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccion(String value) {
        this.direccion = value;
    }

    /**
     * Gets the value of the distrito property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistrito() {
        return distrito;
    }

    /**
     * Sets the value of the distrito property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistrito(String value) {
        this.distrito = value;
    }

    /**
     * Gets the value of the fechaInspeccion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaInspeccion() {
        return fechaInspeccion;
    }

    /**
     * Sets the value of the fechaInspeccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaInspeccion(XMLGregorianCalendar value) {
        this.fechaInspeccion = value;
    }

    /**
     * Gets the value of the flagVuce property.
     * 
     */
    public int getFlagVuce() {
        return flagVuce;
    }

    /**
     * Sets the value of the flagVuce property.
     * 
     */
    public void setFlagVuce(int value) {
        this.flagVuce = value;
    }

    /**
     * Gets the value of the indicadorAcpt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicadorAcpt() {
        return indicadorAcpt;
    }

    /**
     * Sets the value of the indicadorAcpt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicadorAcpt(String value) {
        this.indicadorAcpt = value;
    }

    /**
     * Gets the value of the nombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Gets the value of the observacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * Sets the value of the observacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservacion(String value) {
        this.observacion = value;
    }

    /**
     * Gets the value of the provincia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Sets the value of the provincia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvincia(String value) {
        this.provincia = value;
    }

    /**
     * Gets the value of the recomendacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecomendacion() {
        return recomendacion;
    }

    /**
     * Sets the value of the recomendacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecomendacion(String value) {
        this.recomendacion = value;
    }

    /**
     * Gets the value of the secuencial property.
     * 
     */
    public int getSecuencial() {
        return secuencial;
    }

    /**
     * Sets the value of the secuencial property.
     * 
     */
    public void setSecuencial(int value) {
        this.secuencial = value;
    }

    /**
     * Gets the value of the tipoPredio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoPredio() {
        return tipoPredio;
    }

    /**
     * Sets the value of the tipoPredio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoPredio(String value) {
        this.tipoPredio = value;
    }

}
