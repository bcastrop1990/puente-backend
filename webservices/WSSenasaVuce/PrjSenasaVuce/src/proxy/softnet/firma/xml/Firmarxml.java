package proxy.softnet.firma.xml;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
// !DO NOT EDIT THIS FILE!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 101221.1153.15811)

@WebService(wsdlLocation="http://servicios.senasa.gob.pe:7003/IntegracionTrustedXML/firmarxml?WSDL",
  targetNamespace="http://clases/", name="firmarxml")
@XmlSeeAlso(
  { proxy.softnet.firma.xml.type.ObjectFactory.class })
public interface Firmarxml
{
  @WebMethod
  @Action(input="http://clases/firmarxml/firmarRequest", output="http://clases/firmarxml/firmarResponse")
  @ResponseWrapper(localName="firmarResponse", targetNamespace="http://clases/",
    className="proxy.softnet.firma.xml.type.FirmarResponse")
  @RequestWrapper(localName="firmar", targetNamespace="http://clases/",
    className="proxy.softnet.firma.xml.type.Firmar")
  @WebResult(targetNamespace="", name="xmlSignping")
  public String firmar(@WebParam(targetNamespace="", name="xmlToSign")
    String xmlToSign, @WebParam(targetNamespace="", name="trustedXUser")
    String trustedXUser, @WebParam(targetNamespace="", name="trustedXPwd")
    String trustedXPwd, @WebParam(targetNamespace="", name="signerDN")
    String signerDN, @WebParam(targetNamespace="", name="tipo")
    String tipo);
}
