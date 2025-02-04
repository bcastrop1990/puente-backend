package proxy.softnet.firma.xml;

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

@WebServiceClient(wsdlLocation="http://servicios.senasa.gob.pe:7003/IntegracionTrustedXML/firmarxml?WSDL",
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
      logger = Logger.getLogger("proxy.softnet.firma.xml.Firmarxml_Service");
      URL baseUrl = Firmarxml_Service.class.getResource(".");
      if (baseUrl == null)
      {
        wsdlLocationURL =
            Firmarxml_Service.class.getResource("http://servicios.senasa.gob.pe:7003/IntegracionTrustedXML/firmarxml?WSDL");
        if (wsdlLocationURL == null)
        {
          baseUrl = new File(".").toURL();
          wsdlLocationURL =
              new URL(baseUrl, "http://servicios.senasa.gob.pe:7003/IntegracionTrustedXML/firmarxml?WSDL");
        }
      }
      else
      {
                if (!baseUrl.getPath().endsWith("/")) {
         baseUrl = new URL(baseUrl, baseUrl.getPath() + "/");
}
                wsdlLocationURL =
            new URL(baseUrl, "http://servicios.senasa.gob.pe:7003/IntegracionTrustedXML/firmarxml?WSDL");
      }
    }
    catch (MalformedURLException e)
    {
      logger.log(Level.ALL,
          "Failed to create wsdlLocationURL using http://servicios.senasa.gob.pe:7003/IntegracionTrustedXML/firmarxml?WSDL",
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
  public proxy.softnet.firma.xml.Firmarxml getFirmarxmlPort()
  {
    return (proxy.softnet.firma.xml.Firmarxml) super.getPort(new QName("http://clases/",
                                                                       "firmarxmlPort"),
                                                             proxy.softnet.firma.xml.Firmarxml.class);
  }

  @WebEndpoint(name="firmarxmlPort")
  public proxy.softnet.firma.xml.Firmarxml getFirmarxmlPort(WebServiceFeature... features)
  {
    return (proxy.softnet.firma.xml.Firmarxml) super.getPort(new QName("http://clases/",
                                                                       "firmarxmlPort"),
                                                             proxy.softnet.firma.xml.Firmarxml.class,
                                                             features);
  }
}
