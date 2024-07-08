
package proxy.senasaws.tramite;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anexoPFI complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="anexoPFI">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="cantidadPlantas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codUniMed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoPadre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="desTipoEnvase" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="desUniMed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descRaza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descSexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcionPadre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="edad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idRaza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idSexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isAnimalVivo" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="nombreCientifico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreCientificoPadre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paisDestino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paisProcedencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partidaArancelaria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partidaArancelariaPadre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "anexoPFI", propOrder = {
    "cantidad",
    "cantidadPlantas",
    "codUniMed",
    "codigo",
    "codigoPadre",
    "desTipoEnvase",
    "desUniMed",
    "descRaza",
    "descSexo",
    "descripcion",
    "descripcionPadre",
    "edad",
    "idRaza",
    "idSexo",
    "isAnimalVivo",
    "nombreCientifico",
    "nombreCientificoPadre",
    "paisDestino",
    "paisProcedencia",
    "partidaArancelaria",
    "partidaArancelariaPadre",
    "pesoNeto",
    "tipoEnvase",
    "usoDestino"
})
public class AnexoPFI {

    protected Double cantidad;
    protected String cantidadPlantas;
    protected String codUniMed;
    protected String codigo;
    protected String codigoPadre;
    protected String desTipoEnvase;
    protected String desUniMed;
    protected String descRaza;
    protected String descSexo;
    protected String descripcion;
    protected String descripcionPadre;
    protected int edad;
    protected String idRaza;
    protected String idSexo;
    protected Boolean isAnimalVivo;
    protected String nombreCientifico;
    protected String nombreCientificoPadre;
    protected String paisDestino;
    protected String paisProcedencia;
    protected String partidaArancelaria;
    protected String partidaArancelariaPadre;
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
     * Gets the value of the edad property.
     * 
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Sets the value of the edad property.
     * 
     */
    public void setEdad(int value) {
        this.edad = value;
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
