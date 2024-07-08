
package proxy.senasaws.tramite;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anexoPZI complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="anexoPZI">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="cantidadAnimal" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="codPaisDestino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codUniMed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoPadre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="desDestino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="desTipoEnvase" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="desUniMed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcionPadre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="edadAnimal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="especieAnimal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isAnimalVivo" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="nombreCientifico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreCientificoPadre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nroIdentfAnimal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paisProcedencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partidaArancelaria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partidaArancelariaPadre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pesoNeto" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="razaAnimal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sexoAnimal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "anexoPZI", propOrder = {
    "cantidad",
    "cantidadAnimal",
    "codPaisDestino",
    "codUniMed",
    "codigo",
    "codigoPadre",
    "desDestino",
    "desTipoEnvase",
    "desUniMed",
    "descripcion",
    "descripcionPadre",
    "edadAnimal",
    "especieAnimal",
    "isAnimalVivo",
    "nombreCientifico",
    "nombreCientificoPadre",
    "nroIdentfAnimal",
    "paisProcedencia",
    "partidaArancelaria",
    "partidaArancelariaPadre",
    "pesoNeto",
    "razaAnimal",
    "sexoAnimal",
    "tipoEnvase",
    "usoDestino"
})
public class AnexoPZI {

    protected Double cantidad;
    protected Integer cantidadAnimal;
    protected String codPaisDestino;
    protected String codUniMed;
    protected String codigo;
    protected String codigoPadre;
    protected String desDestino;
    protected String desTipoEnvase;
    protected String desUniMed;
    protected String descripcion;
    protected String descripcionPadre;
    protected String edadAnimal;
    protected String especieAnimal;
    protected Boolean isAnimalVivo;
    protected String nombreCientifico;
    protected String nombreCientificoPadre;
    protected String nroIdentfAnimal;
    protected String paisProcedencia;
    protected String partidaArancelaria;
    protected String partidaArancelariaPadre;
    protected Double pesoNeto;
    protected String razaAnimal;
    protected String sexoAnimal;
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
     * Gets the value of the cantidadAnimal property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCantidadAnimal() {
        return cantidadAnimal;
    }

    /**
     * Sets the value of the cantidadAnimal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCantidadAnimal(Integer value) {
        this.cantidadAnimal = value;
    }

    /**
     * Gets the value of the codPaisDestino property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPaisDestino() {
        return codPaisDestino;
    }

    /**
     * Sets the value of the codPaisDestino property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPaisDestino(String value) {
        this.codPaisDestino = value;
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
     * Gets the value of the codigoPadre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoPadre() {
        return codigoPadre;
    }

    /**
     * Sets the value of the codigoPadre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoPadre(String value) {
        this.codigoPadre = value;
    }

    /**
     * Gets the value of the desDestino property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesDestino() {
        return desDestino;
    }

    /**
     * Sets the value of the desDestino property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesDestino(String value) {
        this.desDestino = value;
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
     * Gets the value of the desUniMed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesUniMed() {
        return desUniMed;
    }

    /**
     * Sets the value of the desUniMed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesUniMed(String value) {
        this.desUniMed = value;
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
     * Gets the value of the descripcionPadre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionPadre() {
        return descripcionPadre;
    }

    /**
     * Sets the value of the descripcionPadre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionPadre(String value) {
        this.descripcionPadre = value;
    }

    /**
     * Gets the value of the edadAnimal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEdadAnimal() {
        return edadAnimal;
    }

    /**
     * Sets the value of the edadAnimal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEdadAnimal(String value) {
        this.edadAnimal = value;
    }

    /**
     * Gets the value of the especieAnimal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEspecieAnimal() {
        return especieAnimal;
    }

    /**
     * Sets the value of the especieAnimal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEspecieAnimal(String value) {
        this.especieAnimal = value;
    }

    /**
     * Gets the value of the isAnimalVivo property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsAnimalVivo() {
        return isAnimalVivo;
    }

    /**
     * Sets the value of the isAnimalVivo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsAnimalVivo(Boolean value) {
        this.isAnimalVivo = value;
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
     * Gets the value of the nombreCientificoPadre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreCientificoPadre() {
        return nombreCientificoPadre;
    }

    /**
     * Sets the value of the nombreCientificoPadre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreCientificoPadre(String value) {
        this.nombreCientificoPadre = value;
    }

    /**
     * Gets the value of the nroIdentfAnimal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNroIdentfAnimal() {
        return nroIdentfAnimal;
    }

    /**
     * Sets the value of the nroIdentfAnimal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNroIdentfAnimal(String value) {
        this.nroIdentfAnimal = value;
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
     * Gets the value of the partidaArancelariaPadre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartidaArancelariaPadre() {
        return partidaArancelariaPadre;
    }

    /**
     * Sets the value of the partidaArancelariaPadre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartidaArancelariaPadre(String value) {
        this.partidaArancelariaPadre = value;
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
     * Gets the value of the razaAnimal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRazaAnimal() {
        return razaAnimal;
    }

    /**
     * Sets the value of the razaAnimal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRazaAnimal(String value) {
        this.razaAnimal = value;
    }

    /**
     * Gets the value of the sexoAnimal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSexoAnimal() {
        return sexoAnimal;
    }

    /**
     * Sets the value of the sexoAnimal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSexoAnimal(String value) {
        this.sexoAnimal = value;
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
