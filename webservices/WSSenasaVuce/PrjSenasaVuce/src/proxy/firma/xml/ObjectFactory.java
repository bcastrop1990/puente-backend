
package proxy.firma.xml;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the proxy.firma.xml package. 
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

    private final static QName _FirmarResponse_QNAME = new QName("http://clases/", "firmarResponse");
    private final static QName _Firmar_QNAME = new QName("http://clases/", "firmar");
    private final static QName _ObtenerRespuestaResponse_QNAME = new QName("http://clases/", "obtenerRespuestaResponse");
    private final static QName _ObtenerRespuesta_QNAME = new QName("http://clases/", "obtenerRespuesta");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: proxy.firma.xml
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FirmarResponse }
     * 
     */
    public FirmarResponse createFirmarResponse() {
        return new FirmarResponse();
    }

    /**
     * Create an instance of {@link Firmar }
     * 
     */
    public Firmar createFirmar() {
        return new Firmar();
    }

    /**
     * Create an instance of {@link ObtenerRespuestaResponse }
     * 
     */
    public ObtenerRespuestaResponse createObtenerRespuestaResponse() {
        return new ObtenerRespuestaResponse();
    }

    /**
     * Create an instance of {@link ObtenerRespuesta }
     * 
     */
    public ObtenerRespuesta createObtenerRespuesta() {
        return new ObtenerRespuesta();
    }

    /**
     * Create an instance of {@link Respuesta }
     * 
     */
    public Respuesta createRespuesta() {
        return new Respuesta();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FirmarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://clases/", name = "firmarResponse")
    public JAXBElement<FirmarResponse> createFirmarResponse(FirmarResponse value) {
        return new JAXBElement<FirmarResponse>(_FirmarResponse_QNAME, FirmarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Firmar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://clases/", name = "firmar")
    public JAXBElement<Firmar> createFirmar(Firmar value) {
        return new JAXBElement<Firmar>(_Firmar_QNAME, Firmar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerRespuestaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://clases/", name = "obtenerRespuestaResponse")
    public JAXBElement<ObtenerRespuestaResponse> createObtenerRespuestaResponse(ObtenerRespuestaResponse value) {
        return new JAXBElement<ObtenerRespuestaResponse>(_ObtenerRespuestaResponse_QNAME, ObtenerRespuestaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerRespuesta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://clases/", name = "obtenerRespuesta")
    public JAXBElement<ObtenerRespuesta> createObtenerRespuesta(ObtenerRespuesta value) {
        return new JAXBElement<ObtenerRespuesta>(_ObtenerRespuesta_QNAME, ObtenerRespuesta.class, null, value);
    }

}
