//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.05.21 a las 01:14:59 PM COT 
//


package pe.gob.senasa.soa.service.org.procedimiento.proceso_procedimiento_tupa_v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numeroSolicitud" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numeroExpediente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="estadoSolicitud" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="estadoExpediente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codigoSede" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codigoCentroTramite" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codigoProcedimiento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codigoClase" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="flagRequiereInspeccion" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="flagModificacionCertificado" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="canal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="usuarioMesaPartes" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="usuarioResponsable" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idSolicitante" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codigoServicio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codigoRecibo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ordenVuce" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codigoStdDoc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descripcionServicio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nombreResponsable" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="secuencial" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="plazo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descProcedimientoTUPA" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nombreSolicitante" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cfeUcmId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cfeNombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="documentosAdjuntos" type="{http://soa.senasa.gob.pe/service/ORG/procedimiento/proceso_procedimiento_tupa-v1.0}documentoAdjunto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "numeroSolicitud",
    "numeroExpediente",
    "estadoSolicitud",
    "estadoExpediente",
    "codigoSede",
    "codigoCentroTramite",
    "codigoProcedimiento",
    "codigoClase",
    "flagRequiereInspeccion",
    "flagModificacionCertificado",
    "canal",
    "usuarioMesaPartes",
    "usuarioResponsable",
    "idSolicitante",
    "codigoServicio",
    "codigoRecibo",
    "ordenVuce",
    "codigoStdDoc",
    "descripcionServicio",
    "nombreResponsable",
    "secuencial",
    "plazo",
    "descProcedimientoTUPA",
    "nombreSolicitante",
    "cfeUcmId",
    "cfeNombre",
    "areaRemitente",
    "subAreaRemitente",
    "usuarioDestinatario",
    "nombreDestinatario",
    "areaDestinatario",
    "subAreaDestinatario",
    "observaciones",
    "ucmidDerivacion",
    "documentosAdjuntos"
})
@XmlRootElement(name = "procedimiento")
public class Procedimiento {

    @XmlElement(required = true)
    protected String numeroSolicitud;
    @XmlElement(required = true)
    protected String numeroExpediente;
    @XmlElement(required = true)
    protected String estadoSolicitud;
    @XmlElement(required = true)
    protected String estadoExpediente;
    @XmlElement(required = true)
    protected String codigoSede;
    @XmlElement(required = true)
    protected String codigoCentroTramite;
    @XmlElement(required = true)
    protected String codigoProcedimiento;
    @XmlElement(required = true)
    protected String codigoClase;
    protected boolean flagRequiereInspeccion;
    protected boolean flagModificacionCertificado;
    protected int canal;
    @XmlElement(required = true)
    protected String usuarioMesaPartes;
    @XmlElement(required = true)
    protected String usuarioResponsable;
    @XmlElement(required = true)
    protected String idSolicitante;
    @XmlElement(required = true)
    protected String codigoServicio;
    @XmlElement(required = true)
    protected String codigoRecibo;
    @XmlElement(required = true)
    protected String ordenVuce;
    @XmlElement(required = true)
    protected String codigoStdDoc;
    @XmlElement(required = true)
    protected String descripcionServicio;
    @XmlElement(required = true)
    protected String nombreResponsable;
    protected int secuencial;
    @XmlElement(required = true)
    protected String plazo;
    @XmlElement(required = true)
    protected String descProcedimientoTUPA;
    @XmlElement(required = true)
    protected String nombreSolicitante;
    @XmlElement(required = true)
    protected String cfeUcmId;
    @XmlElement(required = true)
    protected String cfeNombre;
    @XmlElement(required = true)
    protected String areaRemitente;
    @XmlElement(required = true)
    protected String subAreaRemitente;
    @XmlElement(required = true)
    protected String usuarioDestinatario;
    @XmlElement(required = true)
    protected String nombreDestinatario;
    @XmlElement(required = true)
    protected String areaDestinatario;
    @XmlElement(required = true)
    protected String subAreaDestinatario;
    @XmlElement(required = true)
    protected String observaciones;
    @XmlElement(required = true)
    protected String ucmidDerivacion;
    @XmlElement(nillable = true)
    protected List<DocumentoAdjunto> documentosAdjuntos;

    /**
     * Obtiene el valor de la propiedad numeroSolicitud.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroSolicitud() {
        return numeroSolicitud;
    }

    /**
     * Define el valor de la propiedad numeroSolicitud.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroSolicitud(String value) {
        this.numeroSolicitud = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroExpediente.
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
     * Define el valor de la propiedad numeroExpediente.
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
     * Obtiene el valor de la propiedad estadoSolicitud.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    /**
     * Define el valor de la propiedad estadoSolicitud.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoSolicitud(String value) {
        this.estadoSolicitud = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoExpediente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoExpediente() {
        return estadoExpediente;
    }

    /**
     * Define el valor de la propiedad estadoExpediente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoExpediente(String value) {
        this.estadoExpediente = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoSede.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoSede() {
        return codigoSede;
    }

    /**
     * Define el valor de la propiedad codigoSede.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoSede(String value) {
        this.codigoSede = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoCentroTramite.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoCentroTramite() {
        return codigoCentroTramite;
    }

    /**
     * Define el valor de la propiedad codigoCentroTramite.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoCentroTramite(String value) {
        this.codigoCentroTramite = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoProcedimiento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoProcedimiento() {
        return codigoProcedimiento;
    }

    /**
     * Define el valor de la propiedad codigoProcedimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoProcedimiento(String value) {
        this.codigoProcedimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoClase.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoClase() {
        return codigoClase;
    }

    /**
     * Define el valor de la propiedad codigoClase.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoClase(String value) {
        this.codigoClase = value;
    }

    /**
     * Obtiene el valor de la propiedad flagRequiereInspeccion.
     * 
     */
    public boolean isFlagRequiereInspeccion() {
        return flagRequiereInspeccion;
    }

    /**
     * Define el valor de la propiedad flagRequiereInspeccion.
     * 
     */
    public void setFlagRequiereInspeccion(boolean value) {
        this.flagRequiereInspeccion = value;
    }

    /**
     * Obtiene el valor de la propiedad flagModificacionCertificado.
     * 
     */
    public boolean isFlagModificacionCertificado() {
        return flagModificacionCertificado;
    }

    /**
     * Define el valor de la propiedad flagModificacionCertificado.
     * 
     */
    public void setFlagModificacionCertificado(boolean value) {
        this.flagModificacionCertificado = value;
    }

    /**
     * Obtiene el valor de la propiedad canal.
     * 
     */
    public int getCanal() {
        return canal;
    }

    /**
     * Define el valor de la propiedad canal.
     * 
     */
    public void setCanal(int value) {
        this.canal = value;
    }

    /**
     * Obtiene el valor de la propiedad usuarioMesaPartes.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuarioMesaPartes() {
        return usuarioMesaPartes;
    }

    /**
     * Define el valor de la propiedad usuarioMesaPartes.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuarioMesaPartes(String value) {
        this.usuarioMesaPartes = value;
    }

    /**
     * Obtiene el valor de la propiedad usuarioResponsable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuarioResponsable() {
        return usuarioResponsable;
    }

    /**
     * Define el valor de la propiedad usuarioResponsable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuarioResponsable(String value) {
        this.usuarioResponsable = value;
    }

    /**
     * Obtiene el valor de la propiedad idSolicitante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdSolicitante() {
        return idSolicitante;
    }

    /**
     * Define el valor de la propiedad idSolicitante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdSolicitante(String value) {
        this.idSolicitante = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoServicio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoServicio() {
        return codigoServicio;
    }

    /**
     * Define el valor de la propiedad codigoServicio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoServicio(String value) {
        this.codigoServicio = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoRecibo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoRecibo() {
        return codigoRecibo;
    }

    /**
     * Define el valor de la propiedad codigoRecibo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoRecibo(String value) {
        this.codigoRecibo = value;
    }

    /**
     * Obtiene el valor de la propiedad ordenVuce.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrdenVuce() {
        return ordenVuce;
    }

    /**
     * Define el valor de la propiedad ordenVuce.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrdenVuce(String value) {
        this.ordenVuce = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoStdDoc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoStdDoc() {
        return codigoStdDoc;
    }

    /**
     * Define el valor de la propiedad codigoStdDoc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoStdDoc(String value) {
        this.codigoStdDoc = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcionServicio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    /**
     * Define el valor de la propiedad descripcionServicio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionServicio(String value) {
        this.descripcionServicio = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreResponsable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreResponsable() {
        return nombreResponsable;
    }

    /**
     * Define el valor de la propiedad nombreResponsable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreResponsable(String value) {
        this.nombreResponsable = value;
    }

    /**
     * Obtiene el valor de la propiedad secuencial.
     * 
     */
    public int getSecuencial() {
        return secuencial;
    }

    /**
     * Define el valor de la propiedad secuencial.
     * 
     */
    public void setSecuencial(int value) {
        this.secuencial = value;
    }

    /**
     * Obtiene el valor de la propiedad plazo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlazo() {
        return plazo;
    }

    /**
     * Define el valor de la propiedad plazo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlazo(String value) {
        this.plazo = value;
    }

    /**
     * Obtiene el valor de la propiedad descProcedimientoTUPA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescProcedimientoTUPA() {
        return descProcedimientoTUPA;
    }

    /**
     * Define el valor de la propiedad descProcedimientoTUPA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescProcedimientoTUPA(String value) {
        this.descProcedimientoTUPA = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreSolicitante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreSolicitante() {
        return nombreSolicitante;
    }

    /**
     * Define el valor de la propiedad nombreSolicitante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreSolicitante(String value) {
        this.nombreSolicitante = value;
    }

    /**
     * Obtiene el valor de la propiedad cfeUcmId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfeUcmId() {
        return cfeUcmId;
    }

    /**
     * Define el valor de la propiedad cfeUcmId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfeUcmId(String value) {
        this.cfeUcmId = value;
    }

    /**
     * Obtiene el valor de la propiedad cfeNombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfeNombre() {
        return cfeNombre;
    }

    /**
     * Define el valor de la propiedad cfeNombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfeNombre(String value) {
        this.cfeNombre = value;
    }
        
    public String getAreaRemitente() {
		return areaRemitente;
	}

	public void setAreaRemitente(String areaRemitente) {
		this.areaRemitente = areaRemitente;
	}

	public String getSubAreaRemitente() {
		return subAreaRemitente;
	}

	public void setSubAreaRemitente(String subAreaRemitente) {
		this.subAreaRemitente = subAreaRemitente;
	}

	public String getUsuarioDestinatario() {
		return usuarioDestinatario;
	}

	public void setUsuarioDestinatario(String usuarioDestinatario) {
		this.usuarioDestinatario = usuarioDestinatario;
	}

	public String getNombreDestinatario() {
		return nombreDestinatario;
	}

	public void setNombreDestinatario(String nombreDestinatario) {
		this.nombreDestinatario = nombreDestinatario;
	}

	public String getAreaDestinatario() {
		return areaDestinatario;
	}

	public void setAreaDestinatario(String areaDestinatario) {
		this.areaDestinatario = areaDestinatario;
	}

	public String getSubAreaDestinatario() {
		return subAreaDestinatario;
	}

	public void setSubAreaDestinatario(String subAreaDestinatario) {
		this.subAreaDestinatario = subAreaDestinatario;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getUcmidDerivacion() {
		return ucmidDerivacion;
	}

	public void setUcmidDerivacion(String ucmidDerivacion) {
		this.ucmidDerivacion = ucmidDerivacion;
	}

	public void setDocumentosAdjuntos(List<DocumentoAdjunto> documentosAdjuntos) {
		this.documentosAdjuntos = documentosAdjuntos;
	}

	/**
     * Gets the value of the documentosAdjuntos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentosAdjuntos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentosAdjuntos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentoAdjunto }
     * 
     * 
     */
    public List<DocumentoAdjunto> getDocumentosAdjuntos() {
        if (documentosAdjuntos == null) {
            documentosAdjuntos = new ArrayList<DocumentoAdjunto>();
        }
        return this.documentosAdjuntos;
    }

}
