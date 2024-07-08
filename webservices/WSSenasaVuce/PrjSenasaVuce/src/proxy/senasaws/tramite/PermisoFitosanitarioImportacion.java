
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
 * <p>Java class for permisoFitosanitarioImportacion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="permisoFitosanitarioImportacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="anexosPFI" type="{http://tramitedocumentario.ws.senasa.gob.pe}anexoPFI" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="cadenaProductos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoRequImpoProducto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descDireccionEjecutiva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="direccionEjecutiva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaAmpliacion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechaDeEmicion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaVigencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="indicadorAmpliacion" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="lugaresProduccionAnexoPFI" type="{http://tramitedocumentario.ws.senasa.gob.pe}lugarProduccionAnexoPFI" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="lugaresProduccionProductoPFI" type="{http://tramitedocumentario.ws.senasa.gob.pe}lugarProduccionProductoPFI" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="noCertificado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noFolio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroInspecciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paisesOrigenAnexoPFI" type="{http://tramitedocumentario.ws.senasa.gob.pe}paisOrigenAnexoPFI" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="paisesOrigenProductoPFI" type="{http://tramitedocumentario.ws.senasa.gob.pe}paisOrigenProductoPFI" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="periodoVegetativo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productosPFI" type="{http://tramitedocumentario.ws.senasa.gob.pe}productoPFI" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="puntoIngresoAnexoPFI" type="{http://tramitedocumentario.ws.senasa.gob.pe}puntoIngresoAnexoPFI" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="puntoIngresoProductoPFI" type="{http://tramitedocumentario.ws.senasa.gob.pe}puntoIngresoProductoPFI" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="secuencial" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="solicitante" type="{http://tramitedocumentario.ws.senasa.gob.pe}solicitante" minOccurs="0"/>
 *         &lt;element name="urlPFIDefinitivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "permisoFitosanitarioImportacion", propOrder = {
    "anexosPFI",
    "cadenaProductos",
    "codigoRequImpoProducto",
    "descDireccionEjecutiva",
    "direccionEjecutiva",
    "fechaAmpliacion",
    "fechaDeEmicion",
    "fechaVigencia",
    "indicadorAmpliacion",
    "lugaresProduccionAnexoPFI",
    "lugaresProduccionProductoPFI",
    "noCertificado",
    "noFolio",
    "numeroInspecciones",
    "paisesOrigenAnexoPFI",
    "paisesOrigenProductoPFI",
    "periodoVegetativo",
    "productosPFI",
    "puntoIngresoAnexoPFI",
    "puntoIngresoProductoPFI",
    "secuencial",
    "solicitante",
    "urlPFIDefinitivo",
    "userName"
})
public class PermisoFitosanitarioImportacion {

    @XmlElement(nillable = true)
    protected List<AnexoPFI> anexosPFI;
    protected String cadenaProductos;
    protected String codigoRequImpoProducto;
    protected String descDireccionEjecutiva;
    protected String direccionEjecutiva;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaAmpliacion;
    protected String fechaDeEmicion;
    protected String fechaVigencia;
    protected boolean indicadorAmpliacion;
    @XmlElement(nillable = true)
    protected List<LugarProduccionAnexoPFI> lugaresProduccionAnexoPFI;
    @XmlElement(nillable = true)
    protected List<LugarProduccionProductoPFI> lugaresProduccionProductoPFI;
    protected String noCertificado;
    protected String noFolio;
    protected String numeroInspecciones;
    @XmlElement(nillable = true)
    protected List<PaisOrigenAnexoPFI> paisesOrigenAnexoPFI;
    @XmlElement(nillable = true)
    protected List<PaisOrigenProductoPFI> paisesOrigenProductoPFI;
    protected String periodoVegetativo;
    @XmlElement(nillable = true)
    protected List<ProductoPFI> productosPFI;
    @XmlElement(nillable = true)
    protected List<PuntoIngresoAnexoPFI> puntoIngresoAnexoPFI;
    @XmlElement(nillable = true)
    protected List<PuntoIngresoProductoPFI> puntoIngresoProductoPFI;
    protected Double secuencial;
    protected Solicitante solicitante;
    protected String urlPFIDefinitivo;
    protected String userName;

    /**
     * Gets the value of the anexosPFI property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the anexosPFI property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnexosPFI().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AnexoPFI }
     * 
     * 
     */
    public List<AnexoPFI> getAnexosPFI() {
        if (anexosPFI == null) {
            anexosPFI = new ArrayList<AnexoPFI>();
        }
        return this.anexosPFI;
    }

    /**
     * Gets the value of the cadenaProductos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCadenaProductos() {
        return cadenaProductos;
    }

    /**
     * Sets the value of the cadenaProductos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCadenaProductos(String value) {
        this.cadenaProductos = value;
    }

    /**
     * Gets the value of the codigoRequImpoProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoRequImpoProducto() {
        return codigoRequImpoProducto;
    }

    /**
     * Sets the value of the codigoRequImpoProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoRequImpoProducto(String value) {
        this.codigoRequImpoProducto = value;
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
     * Gets the value of the fechaDeEmicion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaDeEmicion() {
        return fechaDeEmicion;
    }

    /**
     * Sets the value of the fechaDeEmicion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaDeEmicion(String value) {
        this.fechaDeEmicion = value;
    }

    /**
     * Gets the value of the fechaVigencia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaVigencia() {
        return fechaVigencia;
    }

    /**
     * Sets the value of the fechaVigencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaVigencia(String value) {
        this.fechaVigencia = value;
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
     * Gets the value of the lugaresProduccionAnexoPFI property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lugaresProduccionAnexoPFI property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLugaresProduccionAnexoPFI().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LugarProduccionAnexoPFI }
     * 
     * 
     */
    public List<LugarProduccionAnexoPFI> getLugaresProduccionAnexoPFI() {
        if (lugaresProduccionAnexoPFI == null) {
            lugaresProduccionAnexoPFI = new ArrayList<LugarProduccionAnexoPFI>();
        }
        return this.lugaresProduccionAnexoPFI;
    }

    /**
     * Gets the value of the lugaresProduccionProductoPFI property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lugaresProduccionProductoPFI property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLugaresProduccionProductoPFI().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LugarProduccionProductoPFI }
     * 
     * 
     */
    public List<LugarProduccionProductoPFI> getLugaresProduccionProductoPFI() {
        if (lugaresProduccionProductoPFI == null) {
            lugaresProduccionProductoPFI = new ArrayList<LugarProduccionProductoPFI>();
        }
        return this.lugaresProduccionProductoPFI;
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
     * Gets the value of the numeroInspecciones property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroInspecciones() {
        return numeroInspecciones;
    }

    /**
     * Sets the value of the numeroInspecciones property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroInspecciones(String value) {
        this.numeroInspecciones = value;
    }

    /**
     * Gets the value of the paisesOrigenAnexoPFI property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paisesOrigenAnexoPFI property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaisesOrigenAnexoPFI().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaisOrigenAnexoPFI }
     * 
     * 
     */
    public List<PaisOrigenAnexoPFI> getPaisesOrigenAnexoPFI() {
        if (paisesOrigenAnexoPFI == null) {
            paisesOrigenAnexoPFI = new ArrayList<PaisOrigenAnexoPFI>();
        }
        return this.paisesOrigenAnexoPFI;
    }

    /**
     * Gets the value of the paisesOrigenProductoPFI property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paisesOrigenProductoPFI property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaisesOrigenProductoPFI().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaisOrigenProductoPFI }
     * 
     * 
     */
    public List<PaisOrigenProductoPFI> getPaisesOrigenProductoPFI() {
        if (paisesOrigenProductoPFI == null) {
            paisesOrigenProductoPFI = new ArrayList<PaisOrigenProductoPFI>();
        }
        return this.paisesOrigenProductoPFI;
    }

    /**
     * Gets the value of the periodoVegetativo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriodoVegetativo() {
        return periodoVegetativo;
    }

    /**
     * Sets the value of the periodoVegetativo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodoVegetativo(String value) {
        this.periodoVegetativo = value;
    }

    /**
     * Gets the value of the productosPFI property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productosPFI property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductosPFI().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductoPFI }
     * 
     * 
     */
    public List<ProductoPFI> getProductosPFI() {
        if (productosPFI == null) {
            productosPFI = new ArrayList<ProductoPFI>();
        }
        return this.productosPFI;
    }

    /**
     * Gets the value of the puntoIngresoAnexoPFI property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the puntoIngresoAnexoPFI property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPuntoIngresoAnexoPFI().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PuntoIngresoAnexoPFI }
     * 
     * 
     */
    public List<PuntoIngresoAnexoPFI> getPuntoIngresoAnexoPFI() {
        if (puntoIngresoAnexoPFI == null) {
            puntoIngresoAnexoPFI = new ArrayList<PuntoIngresoAnexoPFI>();
        }
        return this.puntoIngresoAnexoPFI;
    }

    /**
     * Gets the value of the puntoIngresoProductoPFI property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the puntoIngresoProductoPFI property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPuntoIngresoProductoPFI().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PuntoIngresoProductoPFI }
     * 
     * 
     */
    public List<PuntoIngresoProductoPFI> getPuntoIngresoProductoPFI() {
        if (puntoIngresoProductoPFI == null) {
            puntoIngresoProductoPFI = new ArrayList<PuntoIngresoProductoPFI>();
        }
        return this.puntoIngresoProductoPFI;
    }

    /**
     * Gets the value of the secuencial property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSecuencial() {
        return secuencial;
    }

    /**
     * Sets the value of the secuencial property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSecuencial(Double value) {
        this.secuencial = value;
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
     * Gets the value of the urlPFIDefinitivo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlPFIDefinitivo() {
        return urlPFIDefinitivo;
    }

    /**
     * Sets the value of the urlPFIDefinitivo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlPFIDefinitivo(String value) {
        this.urlPFIDefinitivo = value;
    }

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

}
