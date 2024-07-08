
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
 * <p>Java class for registroCPE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="registroCPE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoPersona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="direccionSede" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="equipoTecnicoCPE" type="{http://tramitedocumentario.ws.senasa.gob.pe}equipoTecnicoCPE" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaEmision" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="lugaresProduccionCPE" type="{http://tramitedocumentario.ws.senasa.gob.pe}lugaresProduccionCPE" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="noCertificado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noFolio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreSede" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productosCPE" type="{http://tramitedocumentario.ws.senasa.gob.pe}productosCPE" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sede" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="solicitante" type="{http://tramitedocumentario.ws.senasa.gob.pe}solicitante" minOccurs="0"/>
 *         &lt;element name="urlRegistroCPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "registroCPE", propOrder = {
    "codigoPersona",
    "direccionSede",
    "equipoTecnicoCPE",
    "estado",
    "fechaEmision",
    "lugaresProduccionCPE",
    "noCertificado",
    "noFolio",
    "nombreSede",
    "productosCPE",
    "sede",
    "solicitante",
    "urlRegistroCPE",
    "usuario"
})
public class RegistroCPE {

    protected String codigoPersona;
    protected String direccionSede;
    @XmlElement(nillable = true)
    protected List<EquipoTecnicoCPE> equipoTecnicoCPE;
    protected String estado;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaEmision;
    @XmlElement(nillable = true)
    protected List<LugaresProduccionCPE> lugaresProduccionCPE;
    protected String noCertificado;
    protected String noFolio;
    protected String nombreSede;
    @XmlElement(nillable = true)
    protected List<ProductosCPE> productosCPE;
    protected String sede;
    protected Solicitante solicitante;
    protected String urlRegistroCPE;
    protected String usuario;

    /**
     * Gets the value of the codigoPersona property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoPersona() {
        return codigoPersona;
    }

    /**
     * Sets the value of the codigoPersona property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoPersona(String value) {
        this.codigoPersona = value;
    }

    /**
     * Gets the value of the direccionSede property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccionSede() {
        return direccionSede;
    }

    /**
     * Sets the value of the direccionSede property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccionSede(String value) {
        this.direccionSede = value;
    }

    /**
     * Gets the value of the equipoTecnicoCPE property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the equipoTecnicoCPE property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEquipoTecnicoCPE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EquipoTecnicoCPE }
     * 
     * 
     */
    public List<EquipoTecnicoCPE> getEquipoTecnicoCPE() {
        if (equipoTecnicoCPE == null) {
            equipoTecnicoCPE = new ArrayList<EquipoTecnicoCPE>();
        }
        return this.equipoTecnicoCPE;
    }

    /**
     * Gets the value of the estado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Sets the value of the estado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
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
     * Gets the value of the lugaresProduccionCPE property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lugaresProduccionCPE property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLugaresProduccionCPE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LugaresProduccionCPE }
     * 
     * 
     */
    public List<LugaresProduccionCPE> getLugaresProduccionCPE() {
        if (lugaresProduccionCPE == null) {
            lugaresProduccionCPE = new ArrayList<LugaresProduccionCPE>();
        }
        return this.lugaresProduccionCPE;
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
     * Gets the value of the nombreSede property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreSede() {
        return nombreSede;
    }

    /**
     * Sets the value of the nombreSede property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreSede(String value) {
        this.nombreSede = value;
    }

    /**
     * Gets the value of the productosCPE property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productosCPE property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductosCPE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductosCPE }
     * 
     * 
     */
    public List<ProductosCPE> getProductosCPE() {
        if (productosCPE == null) {
            productosCPE = new ArrayList<ProductosCPE>();
        }
        return this.productosCPE;
    }

    /**
     * Gets the value of the sede property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSede() {
        return sede;
    }

    /**
     * Sets the value of the sede property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSede(String value) {
        this.sede = value;
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
     * Gets the value of the urlRegistroCPE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlRegistroCPE() {
        return urlRegistroCPE;
    }

    /**
     * Sets the value of the urlRegistroCPE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlRegistroCPE(String value) {
        this.urlRegistroCPE = value;
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
