
package pe.gob.senasa.ws.gestiondocumento;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pe.gob.senasa.ws.gestiondocumento package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RegistrarDocumentoServidor_QNAME = new QName("http://gestiondocumento.ws.senasa.gob.pe", "registrarDocumentoServidor");
    private final static QName _ObtenerDocumento_QNAME = new QName("http://gestiondocumento.ws.senasa.gob.pe", "obtenerDocumento");
    private final static QName _ObtenerDocumentoResponse_QNAME = new QName("http://gestiondocumento.ws.senasa.gob.pe", "obtenerDocumentoResponse");
    private final static QName _ObtenerURL_QNAME = new QName("http://gestiondocumento.ws.senasa.gob.pe", "obtenerURL");
    private final static QName _RegistrarDocumentoResponse_QNAME = new QName("http://gestiondocumento.ws.senasa.gob.pe", "registrarDocumentoResponse");
    private final static QName _RegistrarDocumento_QNAME = new QName("http://gestiondocumento.ws.senasa.gob.pe", "registrarDocumento");
    private final static QName _ObtenerURLResponse_QNAME = new QName("http://gestiondocumento.ws.senasa.gob.pe", "obtenerURLResponse");
    private final static QName _RegistrarDocumentoServidorResponse_QNAME = new QName("http://gestiondocumento.ws.senasa.gob.pe", "registrarDocumentoServidorResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pe.gob.senasa.ws.gestiondocumento
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RegistrarDocumento }
     * 
     */
    public RegistrarDocumento createRegistrarDocumento() {
        return new RegistrarDocumento();
    }

    /**
     * Create an instance of {@link ObtenerURLResponse }
     * 
     */
    public ObtenerURLResponse createObtenerURLResponse() {
        return new ObtenerURLResponse();
    }

    /**
     * Create an instance of {@link RegistrarDocumentoServidorResponse }
     * 
     */
    public RegistrarDocumentoServidorResponse createRegistrarDocumentoServidorResponse() {
        return new RegistrarDocumentoServidorResponse();
    }

    /**
     * Create an instance of {@link RegistrarDocumentoServidor }
     * 
     */
    public RegistrarDocumentoServidor createRegistrarDocumentoServidor() {
        return new RegistrarDocumentoServidor();
    }

    /**
     * Create an instance of {@link ObtenerDocumentoResponse }
     * 
     */
    public ObtenerDocumentoResponse createObtenerDocumentoResponse() {
        return new ObtenerDocumentoResponse();
    }

    /**
     * Create an instance of {@link ObtenerDocumento }
     * 
     */
    public ObtenerDocumento createObtenerDocumento() {
        return new ObtenerDocumento();
    }

    /**
     * Create an instance of {@link ObtenerURL }
     * 
     */
    public ObtenerURL createObtenerURL() {
        return new ObtenerURL();
    }

    /**
     * Create an instance of {@link RegistrarDocumentoResponse }
     * 
     */
    public RegistrarDocumentoResponse createRegistrarDocumentoResponse() {
        return new RegistrarDocumentoResponse();
    }

    /**
     * Create an instance of {@link Propiedad }
     * 
     */
    public Propiedad createPropiedad() {
        return new Propiedad();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarDocumentoServidor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestiondocumento.ws.senasa.gob.pe", name = "registrarDocumentoServidor")
    public JAXBElement<RegistrarDocumentoServidor> createRegistrarDocumentoServidor(RegistrarDocumentoServidor value) {
        return new JAXBElement<RegistrarDocumentoServidor>(_RegistrarDocumentoServidor_QNAME, RegistrarDocumentoServidor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerDocumento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestiondocumento.ws.senasa.gob.pe", name = "obtenerDocumento")
    public JAXBElement<ObtenerDocumento> createObtenerDocumento(ObtenerDocumento value) {
        return new JAXBElement<ObtenerDocumento>(_ObtenerDocumento_QNAME, ObtenerDocumento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerDocumentoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestiondocumento.ws.senasa.gob.pe", name = "obtenerDocumentoResponse")
    public JAXBElement<ObtenerDocumentoResponse> createObtenerDocumentoResponse(ObtenerDocumentoResponse value) {
        return new JAXBElement<ObtenerDocumentoResponse>(_ObtenerDocumentoResponse_QNAME, ObtenerDocumentoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerURL }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestiondocumento.ws.senasa.gob.pe", name = "obtenerURL")
    public JAXBElement<ObtenerURL> createObtenerURL(ObtenerURL value) {
        return new JAXBElement<ObtenerURL>(_ObtenerURL_QNAME, ObtenerURL.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarDocumentoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestiondocumento.ws.senasa.gob.pe", name = "registrarDocumentoResponse")
    public JAXBElement<RegistrarDocumentoResponse> createRegistrarDocumentoResponse(RegistrarDocumentoResponse value) {
        return new JAXBElement<RegistrarDocumentoResponse>(_RegistrarDocumentoResponse_QNAME, RegistrarDocumentoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarDocumento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestiondocumento.ws.senasa.gob.pe", name = "registrarDocumento")
    public JAXBElement<RegistrarDocumento> createRegistrarDocumento(RegistrarDocumento value) {
        return new JAXBElement<RegistrarDocumento>(_RegistrarDocumento_QNAME, RegistrarDocumento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerURLResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestiondocumento.ws.senasa.gob.pe", name = "obtenerURLResponse")
    public JAXBElement<ObtenerURLResponse> createObtenerURLResponse(ObtenerURLResponse value) {
        return new JAXBElement<ObtenerURLResponse>(_ObtenerURLResponse_QNAME, ObtenerURLResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarDocumentoServidorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestiondocumento.ws.senasa.gob.pe", name = "registrarDocumentoServidorResponse")
    public JAXBElement<RegistrarDocumentoServidorResponse> createRegistrarDocumentoServidorResponse(RegistrarDocumentoServidorResponse value) {
        return new JAXBElement<RegistrarDocumentoServidorResponse>(_RegistrarDocumentoServidorResponse_QNAME, RegistrarDocumentoServidorResponse.class, null, value);
    }

}
