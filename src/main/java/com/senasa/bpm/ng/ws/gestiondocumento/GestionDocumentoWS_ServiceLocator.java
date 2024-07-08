package com.senasa.bpm.ng.ws.gestiondocumento;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.senasa.bpm.ng.utility.ConfigProperties; 

@Component
public class GestionDocumentoWS_ServiceLocator extends org.apache.axis.client.Service implements GestionDocumentoWS_Service {

    private static final Logger logger = Logger.getLogger(GestionDocumentoWS_ServiceLocator.class.getPackage().getName());

    @Autowired
	ConfigProperties configProp;
    
    private java.lang.String GestionDocumentoWSPort_address;

    public GestionDocumentoWS_ServiceLocator() {
        //initParams();
    }


    public GestionDocumentoWS_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
        //initParams();
    }

    public GestionDocumentoWS_ServiceLocator(java.lang.String wsdlLoc,
                                             javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
       // initParams();
    }

    private void initParams() {
        try {
            //GestionDocumentoWSPort_address = AppConfig.getPropertiesUtil().getProp("ws.GestionDocumentoWS.GestionDocumentoWSPort");
            GestionDocumentoWSPort_address = configProp.getConfigValue("ws.GestionDocumentoWS.GestionDocumentoWSPort");
            logger.log(Level.INFO, "GestionDocumentoWSPort_address:",GestionDocumentoWSPort_address);
            
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error:", e);
        }
    }

    /**
     *     Use to get a proxy class for GestionDocumentoWSPort<br>
    DESARROLLO<br>
    private java.lang.String GestionDocumentoWSPort_address = "http://bpmdes.senasa.gob.pe:7003/GestionDocumentoWS/GestionDocumentoWSPort";<br>
    TEST<br>
    private java.lang.String GestionDocumentoWSPort_address = "http://bpmqa.senasa.gob.pe:7003/GestionDocumentoWS/GestionDocumentoWSPort";<br>
    PRODUCCION<br>
    private java.lang.String GestionDocumentoWSPort_address = "http://bpm.senasa.gob.pe:7003/GestionDocumentoWS/GestionDocumentoWSPort";<br>

     */
    public java.lang.String getGestionDocumentoWSPortAddress() {
    	initParams();
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

    public GestionDocumentoWS_PortType getGestionDocumentoWSPort() throws javax.xml.rpc.ServiceException {
    	initParams();
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(GestionDocumentoWSPort_address);
        } catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getGestionDocumentoWSPort(endpoint);
    }

    public GestionDocumentoWS_PortType getGestionDocumentoWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            GestionDocumentoWSPortBindingStub _stub =
                new GestionDocumentoWSPortBindingStub(portAddress,
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
    	initParams();
        try {
            if (GestionDocumentoWS_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                GestionDocumentoWSPortBindingStub _stub =
                    new GestionDocumentoWSPortBindingStub(new java.net.URL(GestionDocumentoWSPort_address),
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
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
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
