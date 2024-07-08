
package proxy.softnet.firma.xml.type;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the proxy.softnet.firma.xml.type package. 
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

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: proxy.softnet.firma.xml.type
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

}
