package proxy.senasaws.tramite;

import javax.xml.ws.WebServiceRef;
// !THE CHANGES MADE TO THIS FILE WILL BE DESTROYED IF REGENERATED!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 101221.1153.15811)

public class TramiteDocumentarioPortClient
{
  @WebServiceRef
  private static TramiteDocumentario_Service tramiteDocumentario_Service;

  public static void main(String [] args)
  {
    tramiteDocumentario_Service = new TramiteDocumentario_Service();
    TramiteDocumentario tramiteDocumentario = tramiteDocumentario_Service.getTramiteDocumentarioPort();
    // Add your code to call the desired methods.
  }
}
