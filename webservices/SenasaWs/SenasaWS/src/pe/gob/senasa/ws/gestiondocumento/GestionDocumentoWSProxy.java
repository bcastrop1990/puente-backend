package pe.gob.senasa.ws.gestiondocumento;

public class GestionDocumentoWSProxy implements pe.gob.senasa.ws.gestiondocumento.GestionDocumentoWS_PortType {
    private String _endpoint = null;
    private pe.gob.senasa.ws.gestiondocumento.GestionDocumentoWS_PortType gestionDocumentoWS_PortType =
        null;

    public GestionDocumentoWSProxy() {
        _initGestionDocumentoWSProxy();
    }

    public GestionDocumentoWSProxy(String endpoint) {
        _endpoint = endpoint;
        _initGestionDocumentoWSProxy();
    }

    private void _initGestionDocumentoWSProxy() {
        try {
            gestionDocumentoWS_PortType =
                    (new pe.gob.senasa.ws.gestiondocumento.GestionDocumentoWS_ServiceLocator()).getGestionDocumentoWSPort();
            if (gestionDocumentoWS_PortType != null) {
                if (_endpoint != null)
                    ((javax.xml.rpc.Stub)gestionDocumentoWS_PortType)._setProperty("javax.xml.rpc.service.endpoint.address",
                                                                                   _endpoint);
                else
                    _endpoint =
                            (String)((javax.xml.rpc.Stub)gestionDocumentoWS_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
            }

        } catch (javax.xml.rpc.ServiceException serviceException) {
        }
    }

    public String getEndpoint() {
        return _endpoint;
    }

    public void setEndpoint(String endpoint) {
        _endpoint = endpoint;
        if (gestionDocumentoWS_PortType != null)
            ((javax.xml.rpc.Stub)gestionDocumentoWS_PortType)._setProperty("javax.xml.rpc.service.endpoint.address",
                                                                           _endpoint);

    }

    public pe.gob.senasa.ws.gestiondocumento.GestionDocumentoWS_PortType getGestionDocumentoWS_PortType() {
        if (gestionDocumentoWS_PortType == null)
            _initGestionDocumentoWSProxy();
        return gestionDocumentoWS_PortType;
    }

    public java.lang.String registrarDocumentoServidor(java.lang.String arg0,
                                                       java.lang.String arg1,
                                                       java.lang.String arg2,
                                                       java.lang.String arg3,
                                                       java.lang.String arg4,
                                                       java.lang.String arg5,
                                                       java.lang.String arg6,
                                                       pe.gob.senasa.ws.gestiondocumento.Propiedad[] arg7) throws java.rmi.RemoteException {
        if (gestionDocumentoWS_PortType == null)
            _initGestionDocumentoWSProxy();
        return gestionDocumentoWS_PortType.registrarDocumentoServidor(arg0,
                                                                      arg1,
                                                                      arg2,
                                                                      arg3,
                                                                      arg4,
                                                                      arg5,
                                                                      arg6,
                                                                      arg7);
    }

    public java.lang.String registrarDocumentoServidorPlano(java.lang.String arg0,
                                                            java.lang.String arg1,
                                                            java.lang.String arg2,
                                                            java.lang.String arg3,
                                                            java.lang.String arg4,
                                                            java.lang.String arg5,
                                                            java.lang.String arg6,
                                                            java.lang.String arg7) throws java.rmi.RemoteException {
        if (gestionDocumentoWS_PortType == null)
            _initGestionDocumentoWSProxy();
        return gestionDocumentoWS_PortType.registrarDocumentoServidorPlano(arg0,
                                                                           arg1,
                                                                           arg2,
                                                                           arg3,
                                                                           arg4,
                                                                           arg5,
                                                                           arg6,
                                                                           arg7);
    }

    public java.lang.String registrarDocumento(java.lang.String arg0,
                                               java.lang.String arg1,
                                               java.lang.String arg2,
                                               java.lang.String arg3,
                                               java.lang.String arg4,
                                               java.lang.String arg5,
                                               java.lang.String arg6,
                                               byte[] arg7,
                                               pe.gob.senasa.ws.gestiondocumento.Propiedad[] arg8) throws java.rmi.RemoteException {
        if (gestionDocumentoWS_PortType == null)
            _initGestionDocumentoWSProxy();
        return gestionDocumentoWS_PortType.registrarDocumento(arg0, arg1, arg2,
                                                              arg3, arg4, arg5,
                                                              arg6, arg7,
                                                              arg8);
    }

    public java.lang.String registrarDocumentoPlano(java.lang.String arg0,
                                                    java.lang.String arg1,
                                                    java.lang.String arg2,
                                                    java.lang.String arg3,
                                                    java.lang.String arg4,
                                                    java.lang.String arg5,
                                                    java.lang.String arg6,
                                                    byte[] arg7,
                                                    java.lang.String arg8) throws java.rmi.RemoteException {
        if (gestionDocumentoWS_PortType == null)
            _initGestionDocumentoWSProxy();
        return gestionDocumentoWS_PortType.registrarDocumentoPlano(arg0, arg1,
                                                                   arg2, arg3,
                                                                   arg4, arg5,
                                                                   arg6, arg7,
                                                                   arg8);
    }

    public java.lang.String obtenerURL(java.lang.String arg0) throws java.rmi.RemoteException {
        if (gestionDocumentoWS_PortType == null)
            _initGestionDocumentoWSProxy();
        return gestionDocumentoWS_PortType.obtenerURL(arg0);
    }

    public pe.gob.senasa.ws.gestiondocumento.Documento obtenerInfoDocumento(java.lang.String arg0) throws java.rmi.RemoteException {
        if (gestionDocumentoWS_PortType == null)
            _initGestionDocumentoWSProxy();
        return gestionDocumentoWS_PortType.obtenerInfoDocumento(arg0);
    }

    public byte[] obtenerDocumento(java.lang.String arg0) throws java.rmi.RemoteException {
        if (gestionDocumentoWS_PortType == null)
            _initGestionDocumentoWSProxy();
        return gestionDocumentoWS_PortType.obtenerDocumento(arg0);
    }


}
