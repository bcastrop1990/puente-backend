package pe.gob.senasa.ws.gestiondocumento;

import java.io.File;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
// !DO NOT EDIT THIS FILE!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 101221.1153.15811)

@WebServiceClient(wsdlLocation="http://10.0.0.36/GestionDocumentoWS/GestionDocumentoWSPort?WSDL",
  targetNamespace="http://gestiondocumento.ws.senasa.gob.pe", name="GestionDocumentoWS")
public class GestionDocumentoWS_Service
  extends Service
{
  private static URL wsdlLocationURL;

  private static Logger logger;
  static
  {
    try
    {
      logger = Logger.getLogger("pe.gob.senasa.ws.gestiondocumento.GestionDocumentoWS_Service");
      URL baseUrl = GestionDocumentoWS_Service.class.getResource(".");
      if (baseUrl == null)
      {
        wsdlLocationURL =
            GestionDocumentoWS_Service.class.getResource("http://10.0.0.36/GestionDocumentoWS/GestionDocumentoWSPort?WSDL");
        if (wsdlLocationURL == null)
        {
          baseUrl = new File(".").toURL();
          wsdlLocationURL =
              new URL(baseUrl, "http://10.0.0.36/GestionDocumentoWS/GestionDocumentoWSPort?WSDL");
        }
      }
      else
      {
				if (!baseUrl.getPath().endsWith("/")) {
         baseUrl = new URL(baseUrl, baseUrl.getPath() + "/");
}
				wsdlLocationURL =
            new URL(baseUrl, "http://10.0.0.36/GestionDocumentoWS/GestionDocumentoWSPort?WSDL");
      }
    }
    catch (MalformedURLException e)
    {
      logger.log(Level.ALL,
          "Failed to create wsdlLocationURL using http://10.0.0.36/GestionDocumentoWS/GestionDocumentoWSPort?WSDL",
          e);
    }
  }

  public GestionDocumentoWS_Service()
  {
    super(wsdlLocationURL,
          new QName("http://gestiondocumento.ws.senasa.gob.pe",
                    "GestionDocumentoWS"));
  }

  public GestionDocumentoWS_Service(URL wsdlLocation, QName serviceName)
  {
    super(wsdlLocation, serviceName);
  }

  @WebEndpoint(name="GestionDocumentoWSPort")
  public GestionDocumentoWS getGestionDocumentoWSPort()
  {
    return (GestionDocumentoWS) super.getPort(new QName("http://gestiondocumento.ws.senasa.gob.pe",
                                                        "GestionDocumentoWSPort"),
                                              GestionDocumentoWS.class);
  }

  @WebEndpoint(name="GestionDocumentoWSPort")
  public GestionDocumentoWS getGestionDocumentoWSPort(WebServiceFeature... features)
  {
    return (GestionDocumentoWS) super.getPort(new QName("http://gestiondocumento.ws.senasa.gob.pe",
                                                        "GestionDocumentoWSPort"),
                                              GestionDocumentoWS.class,
                                              features);
  }
}
