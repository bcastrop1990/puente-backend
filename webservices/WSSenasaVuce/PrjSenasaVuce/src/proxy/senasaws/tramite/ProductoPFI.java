
package proxy.senasaws.tramite;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for productoPFI complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="productoPFI">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="cantidadPlantas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codUniMed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoProducto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contieneAnexos" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="desTipoEnvase" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descPaisDestino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descPaisProcedencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descUniMed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreCientifico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paisDestino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paisProcedencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partidaArancelaria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pesoNeto" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="tipoEnvase" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usoDestino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productoPFI", propOrder = {
    "cantidad",
    "cantidadPlantas",
    "codUniMed",
    "codigoProducto",
    "contieneAnexos",
    "desTipoEnvase",
    "descPaisDestino",
    "descPaisProcedencia",
    "descUniMed",
    "descripcion",
    "nombreCientifico",
    "paisDestino",
    "paisProcedencia",
    "partidaArancelaria",
    "pesoNeto",
    "tipoEnvase",
    "usoDestino"
})
public class ProductoPFI {

    protected Double cantidad;
    protected String cantidadPlantas;
    protected String codUniMed;
    protected String codigoProducto;
    protected boolean contieneAnexos;
    protected String desTipoEnvase;
    protected String descPaisDestino;
    protected String descPaisProcedencia;
    protected String descUniMed;
    protected String descripcion;
    protected String nombreCientifico;
    protected String paisDestino;
    protected String paisProcedencia;
    protected String partidaArancelaria;
    protected Double pesoNeto;
    protected String tipoEnvase;
    protected String usoDestino;

    /**
     * Gets the value of the cantidad property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCantidad() {
        return cantidad;
    }

    /**
     * Sets the value of the cantidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCantidad(Double value) {
        this.cantidad = value;
    }

    /**
     * Gets the value of the cantidadPlantas property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCantidadPlantas() {
        return cantidadPlantas;
    }

    /**
     * Sets the value of the cantidadPlantas property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCantidadPlantas(String value) {
        this.cantidadPlantas = value;
    }

    /**
     * Gets the value of the codUniMed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodUniMed() {
        return codUniMed;
    }

    /**
     * Sets the value of the codUniMed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodUniMed(String value) {
        this.codUniMed = value;
    }

    /**
     * Gets the value of the codigoProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoProducto() {
        return codigoProducto;
    }

    /**
     * Sets the value of the codigoProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoProducto(String value) {
        this.codigoProducto = value;
    }

    /**
     * Gets the value of the contieneAnexos property.
     * 
     */
    public boolean isContieneAnexos() {
        return contieneAnexos;
    }

    /**
     * Sets the value of the contieneAnexos property.
     * 
     */
    public void setContieneAnexos(boolean value) {
        this.contieneAnexos = value;
    }

    /**
     * Gets the value of the desTipoEnvase property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesTipoEnvase() {
        return desTipoEnvase;
    }

    /**
     * Sets the value of the desTipoEnvase property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesTipoEnvase(String value) {
        this.desTipoEnvase = value;
    }

    /**
     * Gets the value of the descPaisDestino property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescPaisDestino() {
        return descPaisDestino;
    }

    /**
     * Sets the value of the descPaisDestino property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescPaisDestino(String value) {
        this.descPaisDestino = value;
    }

    /**
     * Gets the value of the descPaisProcedencia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescPaisProcedencia() {
        return descPaisProcedencia;
    }

    /**
     * Sets the value of the descPaisProcedencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescPaisProcedencia(String value) {
        this.descPaisProcedencia = value;
    }

    /**
     * Gets the value of the descUniMed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescUniMed() {
        return descUniMed;
    }

    /**
     * Sets the value of the descUniMed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescUniMed(String value) {
        this.descUniMed = value;
    }

    /**
     * Gets the value of the descripcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the value of the descripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Gets the value of the nombreCientifico property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreCientifico() {
        return nombreCientifico;
    }

    /**
     * Sets the value of the nombreCientifico property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreCientifico(String value) {
        this.nombreCientifico = value;
    }

    /**
     * Gets the value of the paisDestino property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaisDestino() {
        return paisDestino;
    }

    /**
     * Sets the value of the paisDestino property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaisDestino(String value) {
        this.paisDestino = value;
    }

    /**
     * Gets the value of the paisProcedencia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaisProcedencia() {
        return paisProcedencia;
    }

    /**
     * Sets the value of the paisProcedencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaisProcedencia(String value) {
        this.paisProcedencia = value;
    }

    /**
     * Gets the value of the partidaArancelaria property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartidaArancelaria() {
        return partidaArancelaria;
    }

    /**
     * Sets the value of the partidaArancelaria property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartidaArancelaria(String value) {
        this.partidaArancelaria = value;
    }

    /**
     * Gets the value of the pesoNeto property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPesoNeto() {
        return pesoNeto;
    }

    /**
     * Sets the value of the pesoNeto property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPesoNeto(Double value) {
        this.pesoNeto = value;
    }

    /**
     * Gets the value of the tipoEnvase property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoEnvase() {
        return tipoEnvase;
    }

    /**
     * Sets the value of the tipoEnvase property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoEnvase(String value) {
        this.tipoEnvase = value;
    }

    /**
     * Gets the value of the usoDestino property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsoDestino() {
        return usoDestino;
    }

    /**
     * Sets the value of the usoDestino property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsoDestino(String value) {
        this.usoDestino = value;
    }

}
