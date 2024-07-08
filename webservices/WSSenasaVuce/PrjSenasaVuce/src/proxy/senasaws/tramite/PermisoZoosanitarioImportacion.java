
package proxy.senasaws.tramite;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for permisoZoosanitarioImportacion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="permisoZoosanitarioImportacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="anexosPZI" type="{http://tramitedocumentario.ws.senasa.gob.pe}anexoPFI" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="codReqImpProducto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descDireccionEjecutiva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="direccionEjecutiva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaAmpliacion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechaEmision" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechaEntrega" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechaProbableIngreso" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechaProbableSalida" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="indicadorAmpliacion" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="noCertificado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noFolio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paisesOrigenAnexoPZI" type="{http://tramitedocumentario.ws.senasa.gob.pe}paisOrigenAnexoPFI" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="paisesOrigenProductoPZI" type="{http://tramitedocumentario.ws.senasa.gob.pe}paisOrigenProductoPFI" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="productoPZI" type="{http://tramitedocumentario.ws.senasa.gob.pe}productoPZI" minOccurs="0"/>
 *         &lt;element name="puntoIngreso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="puntoSalida" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="puntosIngresoProductoPZI" type="{http://tramitedocumentario.ws.senasa.gob.pe}puntoIngresoProductoPFI" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="solicitante" type="{http://tramitedocumentario.ws.senasa.gob.pe}solicitante" minOccurs="0"/>
 *         &lt;element name="urlPZIDefinitivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "permisoZoosanitarioImportacion", propOrder = {
    "anexosPZI",
    "codReqImpProducto",
    "descDireccionEjecutiva",
    "direccionEjecutiva",
    "fechaAmpliacion",
    "fechaEmision",
    "fechaEntrega",
    "fechaProbableIngreso",
    "fechaProbableSalida",
    "indicadorAmpliacion",
    "noCertificado",
    "noFolio",
    "paisesOrigenAnexoPZI",
    "paisesOrigenProductoPZI",
    "productoPZI",
    "puntoIngreso",
    "puntoSalida",
    "puntosIngresoProductoPZI",
    "solicitante",
    "urlPZIDefinitivo",
    "usuario"
})
public class PermisoZoosanitarioImportacion {

    @XmlElement(nillable = true)
    protected List<AnexoPFI> anexosPZI;
    protected String codReqImpProducto;
    protected String descDireccionEjecutiva;
    protected String direccionEjecutiva;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaAmpliacion;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaEmision;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaEntrega;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaProbableIngreso;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaProbableSalida;
    protected boolean indicadorAmpliacion;
    protected String noCertificado;
    protected String noFolio;
    @XmlElement(nillable = true)
    protected List<PaisOrigenAnexoPFI> paisesOrigenAnexoPZI;
    @XmlElement(nillable = true)
    protected List<PaisOrigenProductoPFI> paisesOrigenProductoPZI;
    protected ProductoPZI productoPZI;
    protected String puntoIngreso;
    protected String puntoSalida;
    @XmlElement(nillable = true)
    protected List<PuntoIngresoProductoPFI> puntosIngresoProductoPZI;
    protected Solicitante solicitante;
    protected String urlPZIDefinitivo;
    protected String usuario;

    /**
     * Gets the value of the anexosPZI property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the anexosPZI property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnexosPZI().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AnexoPFI }
     * 
     * 
     */
    public List<AnexoPFI> getAnexosPZI() {
        if (anexosPZI == null) {
            anexosPZI = new ArrayList<AnexoPFI>();
        }
        return this.anexosPZI;
    }

    /**
     * Gets the value of the codReqImpProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodReqImpProducto() {
        return codReqImpProducto;
    }

    /**
     * Sets the value of the codReqImpProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodReqImpProducto(String value) {
        this.codReqImpProducto = value;
    }

    /**
     * Gets the value of the descDireccionEjecutiva property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescDireccionEjecutiva() {
        return descDireccionEjecutiva;
    }

    /**
     * Sets the value of the descDireccionEjecutiva property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescDireccionEjecutiva(String value) {
        this.descDireccionEjecutiva = value;
    }

    /**
     * Gets the value of the direccionEjecutiva property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccionEjecutiva() {
        return direccionEjecutiva;
    }

    /**
     * Sets the value of the direccionEjecutiva property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccionEjecutiva(String value) {
        this.direccionEjecutiva = value;
    }

    /**
     * Gets the value of the fechaAmpliacion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaAmpliacion() {
        return fechaAmpliacion;
    }

    /**
     * Sets the value of the fechaAmpliacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaAmpliacion(XMLGregorianCalendar value) {
        this.fechaAmpliacion = value;
    }

    /**
     * Gets the value of the fechaEmision property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Sets the value of the fechaEmision property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaEmision(XMLGregorianCalendar value) {
        this.fechaEmision = value;
    }

    /**
     * Gets the value of the fechaEntrega property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * Sets the value of the fechaEntrega property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaEntrega(XMLGregorianCalendar value) {
        this.fechaEntrega = value;
    }

    /**
     * Gets the value of the fechaProbableIngreso property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaProbableIngreso() {
        return fechaProbableIngreso;
    }

    /**
     * Sets the value of the fechaProbableIngreso property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaProbableIngreso(XMLGregorianCalendar value) {
        this.fechaProbableIngreso = value;
    }

    /**
     * Gets the value of the fechaProbableSalida property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaProbableSalida() {
        return fechaProbableSalida;
    }

    /**
     * Sets the value of the fechaProbableSalida property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaProbableSalida(XMLGregorianCalendar value) {
        this.fechaProbableSalida = value;
    }

    /**
     * Gets the value of the indicadorAmpliacion property.
     * 
     */
    public boolean isIndicadorAmpliacion() {
        return indicadorAmpliacion;
    }

    /**
     * Sets the value of the indicadorAmpliacion property.
     * 
     */
    public void setIndicadorAmpliacion(boolean value) {
        this.indicadorAmpliacion = value;
    }

    /**
     * Gets the value of the noCertificado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoCertificado() {
        return noCertificado;
    }

    /**
     * Sets the value of the noCertificado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoCertificado(String value) {
        this.noCertificado = value;
    }

    /**
     * Gets the value of the noFolio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoFolio() {
        return noFolio;
    }

    /**
     * Sets the value of the noFolio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoFolio(String value) {
        this.noFolio = value;
    }

    /**
     * Gets the value of the paisesOrigenAnexoPZI property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paisesOrigenAnexoPZI property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaisesOrigenAnexoPZI().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaisOrigenAnexoPFI }
     * 
     * 
     */
    public List<PaisOrigenAnexoPFI> getPaisesOrigenAnexoPZI() {
        if (paisesOrigenAnexoPZI == null) {
            paisesOrigenAnexoPZI = new ArrayList<PaisOrigenAnexoPFI>();
        }
        return this.paisesOrigenAnexoPZI;
    }

    /**
     * Gets the value of the paisesOrigenProductoPZI property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paisesOrigenProductoPZI property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaisesOrigenProductoPZI().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaisOrigenProductoPFI }
     * 
     * 
     */
    public List<PaisOrigenProductoPFI> getPaisesOrigenProductoPZI() {
        if (paisesOrigenProductoPZI == null) {
            paisesOrigenProductoPZI = new ArrayList<PaisOrigenProductoPFI>();
        }
        return this.paisesOrigenProductoPZI;
    }

    /**
     * Gets the value of the productoPZI property.
     * 
     * @return
     *     possible object is
     *     {@link ProductoPZI }
     *     
     */
    public ProductoPZI getProductoPZI() {
        return productoPZI;
    }

    /**
     * Sets the value of the productoPZI property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductoPZI }
     *     
     */
    public void setProductoPZI(ProductoPZI value) {
        this.productoPZI = value;
    }

    /**
     * Gets the value of the puntoIngreso property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPuntoIngreso() {
        return puntoIngreso;
    }

    /**
     * Sets the value of the puntoIngreso property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPuntoIngreso(String value) {
        this.puntoIngreso = value;
    }

    /**
     * Gets the value of the puntoSalida property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPuntoSalida() {
        return puntoSalida;
    }

    /**
     * Sets the value of the puntoSalida property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPuntoSalida(String value) {
        this.puntoSalida = value;
    }

    /**
     * Gets the value of the puntosIngresoProductoPZI property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the puntosIngresoProductoPZI property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPuntosIngresoProductoPZI().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PuntoIngresoProductoPFI }
     * 
     * 
     */
    public List<PuntoIngresoProductoPFI> getPuntosIngresoProductoPZI() {
        if (puntosIngresoProductoPZI == null) {
            puntosIngresoProductoPZI = new ArrayList<PuntoIngresoProductoPFI>();
        }
        return this.puntosIngresoProductoPZI;
    }

    /**
     * Gets the value of the solicitante property.
     * 
     * @return
     *     possible object is
     *     {@link Solicitante }
     *     
     */
    public Solicitante getSolicitante() {
        return solicitante;
    }

    /**
     * Sets the value of the solicitante property.
     * 
     * @param value
     *     allowed object is
     *     {@link Solicitante }
     *     
     */
    public void setSolicitante(Solicitante value) {
        this.solicitante = value;
    }

    /**
     * Gets the value of the urlPZIDefinitivo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlPZIDefinitivo() {
        return urlPZIDefinitivo;
    }

    /**
     * Sets the value of the urlPZIDefinitivo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlPZIDefinitivo(String value) {
        this.urlPZIDefinitivo = value;
    }

    /**
     * Gets the value of the usuario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Sets the value of the usuario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuario(String value) {
        this.usuario = value;
    }

}
