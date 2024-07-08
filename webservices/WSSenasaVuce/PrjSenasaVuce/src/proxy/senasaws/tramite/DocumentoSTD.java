
package proxy.senasaws.tramite;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for documentoSTD complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="documentoSTD">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="archivoFisico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="archivoFolio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="auditoria" type="{http://tramitedocumentario.ws.senasa.gob.pe}audit" minOccurs="0"/>
 *         &lt;element name="autor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="autorId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoDocPadre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="confidencial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="escenario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaCrea" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechahora" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="indicadorObligatorio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isDocPrincipal" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroExpediente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subTipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipo_doc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ucmId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "documentoSTD", propOrder = {
    "archivoFisico",
    "archivoFolio",
    "auditoria",
    "autor",
    "autorId",
    "codigo",
    "codigoDocPadre",
    "confidencial",
    "escenario",
    "estado",
    "fechaCrea",
    "fechahora",
    "indicadorObligatorio",
    "isDocPrincipal",
    "nombre",
    "numeroExpediente",
    "subTipo",
    "tipo",
    "tipoDoc",
    "ucmId"
})
public class DocumentoSTD {

    protected String archivoFisico;
    protected String archivoFolio;
    protected Audit auditoria;
    protected String autor;
    protected String autorId;
    protected String codigo;
    protected String codigoDocPadre;
    protected String confidencial;
    protected String escenario;
    protected String estado;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaCrea;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechahora;
    protected String indicadorObligatorio;
    protected Boolean isDocPrincipal;
    protected String nombre;
    protected String numeroExpediente;
    protected String subTipo;
    protected String tipo;
    @XmlElement(name = "tipo_doc")
    protected String tipoDoc;
    protected String ucmId;

    /**
     * Gets the value of the archivoFisico property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArchivoFisico() {
        return archivoFisico;
    }

    /**
     * Sets the value of the archivoFisico property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArchivoFisico(String value) {
        this.archivoFisico = value;
    }

    /**
     * Gets the value of the archivoFolio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArchivoFolio() {
        return archivoFolio;
    }

    /**
     * Sets the value of the archivoFolio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArchivoFolio(String value) {
        this.archivoFolio = value;
    }

    /**
     * Gets the value of the auditoria property.
     * 
     * @return
     *     possible object is
     *     {@link Audit }
     *     
     */
    public Audit getAuditoria() {
        return auditoria;
    }

    /**
     * Sets the value of the auditoria property.
     * 
     * @param value
     *     allowed object is
     *     {@link Audit }
     *     
     */
    public void setAuditoria(Audit value) {
        this.auditoria = value;
    }

    /**
     * Gets the value of the autor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Sets the value of the autor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutor(String value) {
        this.autor = value;
    }

    /**
     * Gets the value of the autorId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutorId() {
        return autorId;
    }

    /**
     * Sets the value of the autorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutorId(String value) {
        this.autorId = value;
    }

    /**
     * Gets the value of the codigo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Sets the value of the codigo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigo(String value) {
        this.codigo = value;
    }

    /**
     * Gets the value of the codigoDocPadre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoDocPadre() {
        return codigoDocPadre;
    }

    /**
     * Sets the value of the codigoDocPadre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoDocPadre(String value) {
        this.codigoDocPadre = value;
    }

    /**
     * Gets the value of the confidencial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfidencial() {
        return confidencial;
    }

    /**
     * Sets the value of the confidencial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfidencial(String value) {
        this.confidencial = value;
    }

    /**
     * Gets the value of the escenario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEscenario() {
        return escenario;
    }

    /**
     * Sets the value of the escenario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEscenario(String value) {
        this.escenario = value;
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
     * Gets the value of the fechaCrea property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaCrea() {
        return fechaCrea;
    }

    /**
     * Sets the value of the fechaCrea property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaCrea(XMLGregorianCalendar value) {
        this.fechaCrea = value;
    }

    /**
     * Gets the value of the fechahora property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechahora() {
        return fechahora;
    }

    /**
     * Sets the value of the fechahora property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechahora(XMLGregorianCalendar value) {
        this.fechahora = value;
    }

    /**
     * Gets the value of the indicadorObligatorio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicadorObligatorio() {
        return indicadorObligatorio;
    }

    /**
     * Sets the value of the indicadorObligatorio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicadorObligatorio(String value) {
        this.indicadorObligatorio = value;
    }

    /**
     * Gets the value of the isDocPrincipal property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsDocPrincipal() {
        return isDocPrincipal;
    }

    /**
     * Sets the value of the isDocPrincipal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsDocPrincipal(Boolean value) {
        this.isDocPrincipal = value;
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
     * Gets the value of the subTipo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubTipo() {
        return subTipo;
    }

    /**
     * Sets the value of the subTipo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubTipo(String value) {
        this.subTipo = value;
    }

    /**
     * Gets the value of the tipo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Sets the value of the tipo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo(String value) {
        this.tipo = value;
    }

    /**
     * Gets the value of the tipoDoc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDoc() {
        return tipoDoc;
    }

    /**
     * Sets the value of the tipoDoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDoc(String value) {
        this.tipoDoc = value;
    }

    /**
     * Gets the value of the ucmId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUcmId() {
        return ucmId;
    }

    /**
     * Sets the value of the ucmId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUcmId(String value) {
        this.ucmId = value;
    }

}
