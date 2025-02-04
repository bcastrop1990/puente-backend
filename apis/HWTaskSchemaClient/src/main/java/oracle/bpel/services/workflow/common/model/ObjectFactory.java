//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.05.21 a las 01:14:30 PM COT 
//


package oracle.bpel.services.workflow.common.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oracle.bpel.services.workflow.common.model package. 
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

    private final static QName _RefreshWorkflowContextRequest_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/common", "refreshWorkflowContextRequest");
    private final static QName _WorkflowContext_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/common", "workflowContext");
    private final static QName _Credential_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/common", "credential");
    private final static QName _Participant_QNAME = new QName("http://xmlns.oracle.com/bpel/workflow/common", "participant");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oracle.bpel.services.workflow.common.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WorkflowContextType }
     * 
     */
    public WorkflowContextType createWorkflowContextType() {
        return new WorkflowContextType();
    }

    /**
     * Create an instance of {@link CredentialType }
     * 
     */
    public CredentialType createCredentialType() {
        return new CredentialType();
    }

    /**
     * Create an instance of {@link PrincipleRefType }
     * 
     */
    public PrincipleRefType createPrincipleRefType() {
        return new PrincipleRefType();
    }

    /**
     * Create an instance of {@link PrincipleListType }
     * 
     */
    public PrincipleListType createPrincipleListType() {
        return new PrincipleListType();
    }

    /**
     * Create an instance of {@link PropertyType }
     * 
     */
    public PropertyType createPropertyType() {
        return new PropertyType();
    }

    /**
     * Create an instance of {@link PropertiesType }
     * 
     */
    public PropertiesType createPropertiesType() {
        return new PropertiesType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WorkflowContextType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/common", name = "refreshWorkflowContextRequest")
    public JAXBElement<WorkflowContextType> createRefreshWorkflowContextRequest(WorkflowContextType value) {
        return new JAXBElement<WorkflowContextType>(_RefreshWorkflowContextRequest_QNAME, WorkflowContextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WorkflowContextType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/common", name = "workflowContext")
    public JAXBElement<WorkflowContextType> createWorkflowContext(WorkflowContextType value) {
        return new JAXBElement<WorkflowContextType>(_WorkflowContext_QNAME, WorkflowContextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CredentialType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/common", name = "credential")
    public JAXBElement<CredentialType> createCredential(CredentialType value) {
        return new JAXBElement<CredentialType>(_Credential_QNAME, CredentialType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrincipleRefType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bpel/workflow/common", name = "participant")
    public JAXBElement<PrincipleRefType> createParticipant(PrincipleRefType value) {
        return new JAXBElement<PrincipleRefType>(_Participant_QNAME, PrincipleRefType.class, null, value);
    }

}
