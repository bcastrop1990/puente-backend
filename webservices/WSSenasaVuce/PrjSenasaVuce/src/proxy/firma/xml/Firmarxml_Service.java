package proxy.firma.xml;

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

@WebServiceClient(wsdlLocation="http://bpm.senasa.gob.pe:7003/WSFirmaXMLProd/firmarxml?WSDL",
  targetNamespace="http://clases/", name="firmarxml")
public class Firmarxml_Service
  extends Service
{
  private static URL wsdlLocationURL;

  private static Logger logger;
  static
  {
    try
    {
      logger = Logger.getLogger("proxy.firma.xml.Firmarxml_Service");
      URL baseUrl = Firmarxml_Service.class.getResource(".");
      if (baseUrl == null)
      {
        wsdlLocationURL =
            Firmarxml_Service.class.getResource("http://bpm.senasa.gob.pe:7003/WSFirmaXMLProd/firmarxml?WSDL");
        if (wsdlLocationURL == null)
        {
          baseUrl = new File(".").toURL();
          wsdlLocationURL =
              new URL(baseUrl, "http://bpm.senasa.gob.pe:7003/WSFirmaXMLProd/firmarxml?WSDL");
        }
      }
      else
      {
                if (!baseUrl.getPath().endsWith("/")) {
         baseUrl = new URL(baseUrl, baseUrl.getPath() + "/");
}
                wsdlLocationURL =
            new URL(baseUrl, "http://bpm.senasa.gob.pe:7003/WSFirmaXMLProd/firmarxml?WSDL");
      }
    }
    catch (MalformedURLException e)
    {
      logger.log(Level.ALL,
          "Failed to create wsdlLocationURL using http://bpm.senasa.gob.pe:7003/WSFirmaXMLProd/firmarxml?WSDL",
          e);
    }
  }

  public Firmarxml_Service()
  {
    super(wsdlLocationURL, new QName("http://clases/", "firmarxml"));
  }

  public Firmarxml_Service(URL wsdlLocation, QName serviceName)
  {
    super(wsdlLocation, serviceName);
  }

  @WebEndpoint(name="firmarxmlPort")
  public Firmarxml getFirmarxmlPort()
  {
    return (Firmarxml) super.getPort(new QName("http://clases/",
                                               "firmarxmlPort"),
                                     Firmarxml.class);
  }

  @WebEndpoint(name="firmarxmlPort")
  public Firmarxml getFirmarxmlPort(WebServiceFeature... features)
  {
    return (Firmarxml) super.getPort(new QName("http://clases/",
                                               "firmarxmlPort"),
                                     Firmarxml.class, features);
  }
}
