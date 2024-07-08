package com.senasa.bpm.ng.ws.gestiondocumento;

public interface GestionDocumentoWS_Service extends javax.xml.rpc.Service {
    public java.lang.String getGestionDocumentoWSPortAddress();

    public GestionDocumentoWS_PortType getGestionDocumentoWSPort() throws javax.xml.rpc.ServiceException;

    public GestionDocumentoWS_PortType getGestionDocumentoWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
