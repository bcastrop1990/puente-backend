/**
 * GestionDocumentoWS_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.senasa.ws.gestiondocumento;


public class GestionDocumentoWS_ServiceLocator extends org.apache.axis.client.Service implements pe.gob.senasa.ws.gestiondocumento.GestionDocumentoWS_Service {

    public GestionDocumentoWS_ServiceLocator() {
    }


    public GestionDocumentoWS_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public GestionDocumentoWS_ServiceLocator(java.lang.String wsdlLoc,
                                             javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for GestionDocumentoWSPort
    // DESARROLLO
    //private java.lang.String GestionDocumentoWSPort_address = "http://bpmdes.senasa.gob.pe:7003/GestionDocumentoWS/GestionDocumentoWSPort";
    //TEST
     //private java.lang.String GestionDocumentoWSPort_address = "http://bpmqa.senasa.gob.pe:7003/GestionDocumentoWS/GestionDocumentoWSPort";    
    // PRODUCCION
    private java.lang.String GestionDocumentoWSPort_address = "http://bpmdes.senasa.gob.pe:7003/GestionDocumentoWS/GestionDocumentoWSPort";

    public java.lang.String getGestionDocumentoWSPortAddress() {
        return GestionDocumentoWSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String GestionDocumentoWSPortWSDDServiceName =
        "GestionDocumentoWSPort";

    public java.lang.String getGestionDocumentoWSPortWSDDServiceName() {
        return GestionDocumentoWSPortWSDDServiceName;
    }

    public void setGestionDocumentoWSPortWSDDServiceName(java.lang.String name) {
        GestionDocumentoWSPortWSDDServiceName = name;
    }

    public pe.gob.senasa.ws.gestiondocumento.GestionDocumentoWS_PortType getGestionDocumentoWSPort() throws javax.xml.rpc.ServiceException {
        java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(GestionDocumentoWSPort_address);
        } catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getGestionDocumentoWSPort(endpoint);
    }

    public pe.gob.senasa.ws.gestiondocumento.GestionDocumentoWS_PortType getGestionDocumentoWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            pe.gob.senasa.ws.gestiondocumento.GestionDocumentoWSPortBindingStub _stub =
                new pe.gob.senasa.ws.gestiondocumento.GestionDocumentoWSPortBindingStub(portAddress,
                                                                                        this);
            _stub.setPortName(getGestionDocumentoWSPortWSDDServiceName());
            return _stub;
        } catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setGestionDocumentoWSPortEndpointAddress(java.lang.String address) {
        GestionDocumentoWSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (pe.gob.senasa.ws.gestiondocumento.GestionDocumentoWS_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                pe.gob.senasa.ws.gestiondocumento.GestionDocumentoWSPortBindingStub _stub =
                    new pe.gob.senasa.ws.gestiondocumento.GestionDocumentoWSPortBindingStub(new java.net.URL(GestionDocumentoWSPort_address),
                                                                                            this);
                _stub.setPortName(getGestionDocumentoWSPortWSDDServiceName());
                return _stub;
            }
        } catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " +
                                                 (serviceEndpointInterface ==
                                                  null ? "null" :
                                                  serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName,
                                   Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("GestionDocumentoWSPort".equals(inputPortName)) {
            return getGestionDocumentoWSPort();
        } else {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub)_stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://gestiondocumento.ws.senasa.gob.pe",
                                             "GestionDocumentoWS");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://gestiondocumento.ws.senasa.gob.pe",
                                                    "GestionDocumentoWSPort"));
        }
        return ports.iterator();
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress(java.lang.String portName,
                                   java.lang.String address) throws javax.xml.rpc.ServiceException {

        if ("GestionDocumentoWSPort".equals(portName)) {
            setGestionDocumentoWSPortEndpointAddress(address);
        } else { // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" +
                                                     portName);
        }
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress(javax.xml.namespace.QName portName,
                                   java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
