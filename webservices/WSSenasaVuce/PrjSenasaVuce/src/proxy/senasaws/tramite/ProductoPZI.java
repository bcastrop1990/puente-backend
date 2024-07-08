
package proxy.senasaws.tramite;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for productoPZI complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="productoPZI">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="animalesVivos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="codProducto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codUniMed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contieneAnexos" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="desTipoEnvase" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descRaza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descSexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descUniMed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="edad" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="esAnimal" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="especie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idRaza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idSexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="identificacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreCientifico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroAnimales" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
@XmlType(name = "productoPZI", propOrder = {
    "animalesVivos",
    "cantidad",
    "codProducto",
    "codUniMed",
    "contieneAnexos",
    "desTipoEnvase",
    "descRaza",
    "descSexo",
    "descUniMed",
    "descripcion",
    "edad",
    "esAnimal",
    "especie",
    "idRaza",
    "idSexo",
    "identificacion",
    "nombreCientifico",
    "numeroAnimales",
    "paisProcedencia",
    "partidaArancelaria",
    "pesoNeto",
    "tipoEnvase",
    "usoDestino"
})
public class ProductoPZI {

    protected String animalesVivos;
    protected Double cantidad;
    protected String codProducto;
    protected String codUniMed;
    protected Boolean contieneAnexos;
    protected String desTipoEnvase;
    protected String descRaza;
    protected String descSexo;
    protected String descUniMed;
    protected String descripcion;
    protected Integer edad;
    protected Boolean esAnimal;
    protected String especie;
    protected String idRaza;
    protected String idSexo;
    protected String identificacion;
    protected String nombreCientifico;
    protected Integer numeroAnimales;
    protected String paisProcedencia;
    protected String partidaArancelaria;
    protected Double pesoNeto;
    protected String tipoEnvase;
    protected String usoDestino;

    /**
     * Gets the value of the animalesVivos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnimalesVivos() {
        return animalesVivos;
    }

    /**
     * Sets the value of the animalesVivos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnimalesVivos(String value) {
        this.animalesVivos = value;
    }

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
     * Gets the value of the codProducto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodProducto() {
        return codProducto;
    }

    /**
     * Sets the value of the codProducto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodProducto(String value) {
        this.codProducto = value;
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
     * Gets the value of the contieneAnexos property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isContieneAnexos() {
        return contieneAnexos;
    }

    /**
     * Sets the value of the contieneAnexos property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setContieneAnexos(Boolean value) {
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
     * Gets the value of the descRaza property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescRaza() {
        return descRaza;
    }

    /**
     * Sets the value of the descRaza property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescRaza(String value) {
        this.descRaza = value;
    }

    /**
     * Gets the value of the descSexo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescSexo() {
        return descSexo;
    }

    /**
     * Sets the value of the descSexo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescSexo(String value) {
        this.descSexo = value;
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
     * Gets the value of the edad property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * Sets the value of the edad property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEdad(Integer value) {
        this.edad = value;
    }

    /**
     * Gets the value of the esAnimal property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEsAnimal() {
        return esAnimal;
    }

    /**
     * Sets the value of the esAnimal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEsAnimal(Boolean value) {
        this.esAnimal = value;
    }

    /**
     * Gets the value of the especie property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * Sets the value of the especie property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEspecie(String value) {
        this.especie = value;
    }

    /**
     * Gets the value of the idRaza property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdRaza() {
        return idRaza;
    }

    /**
     * Sets the value of the idRaza property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdRaza(String value) {
        this.idRaza = value;
    }

    /**
     * Gets the value of the idSexo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdSexo() {
        return idSexo;
    }

    /**
     * Sets the value of the idSexo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdSexo(String value) {
        this.idSexo = value;
    }

    /**
     * Gets the value of the identificacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * Sets the value of the identificacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificacion(String value) {
        this.identificacion = value;
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
     * Gets the value of the numeroAnimales property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumeroAnimales() {
        return numeroAnimales;
    }

    /**
     * Sets the value of the numeroAnimales property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumeroAnimales(Integer value) {
        this.numeroAnimales = value;
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
