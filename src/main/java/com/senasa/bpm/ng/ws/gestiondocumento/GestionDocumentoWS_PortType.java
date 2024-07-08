package com.senasa.bpm.ng.ws.gestiondocumento;

public interface GestionDocumentoWS_PortType extends java.rmi.Remote {
    public java.lang.String registrarDocumentoServidor(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4, java.lang.String arg5, java.lang.String arg6, Propiedad[] arg7) throws java.rmi.RemoteException;
    public java.lang.String registrarDocumentoServidorPlano(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4, java.lang.String arg5, java.lang.String arg6, java.lang.String arg7) throws java.rmi.RemoteException;
    public java.lang.String registrarDocumento(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4, java.lang.String arg5, java.lang.String arg6, byte[] arg7, Propiedad[] arg8) throws java.rmi.RemoteException;
    public java.lang.String registrarDocumentoPlano(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4, java.lang.String arg5, java.lang.String arg6, byte[] arg7, java.lang.String arg8) throws java.rmi.RemoteException;
    public java.lang.String obtenerURL(java.lang.String arg0) throws java.rmi.RemoteException;
    public Documento obtenerInfoDocumento(java.lang.String arg0) throws java.rmi.RemoteException;
    public byte[] obtenerDocumento(java.lang.String arg0) throws java.rmi.RemoteException;
}
