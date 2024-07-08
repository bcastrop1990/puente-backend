package pe.gob.senasa.vucews.security.handler;

import java.util.Set;

import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import pe.com.jarch.logger.JLevel;
import pe.com.jarch.logger.JLogger;
import pe.gob.senasa.vucews.security.VuceWsSecurity;

public class HeaderHandler implements SOAPHandler<SOAPMessageContext> {

    public boolean handleMessage(SOAPMessageContext smc) {

        Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (outboundProperty.booleanValue()) {

            try {

                SOAPEnvelope envelope = smc.getMessage().getSOAPPart().getEnvelope();
                if (envelope.getHeader() != null)
                	envelope.getHeader().detachNode();
                SOAPHeader header = envelope.addHeader();

                SOAPElement security =
                        header.addChildElement("Security", "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");

                SOAPElement usernameToken =
                        security.addChildElement("UsernameToken", "wsse");
                //usernameToken.addAttribute(new QName("xmlns:wsse"), "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");

                SOAPElement username =
                        usernameToken.addChildElement("Username", "wsse");
                username.addTextNode(VuceWsSecurity.getInstance().getUsername());

                SOAPElement password =
                        usernameToken.addChildElement("Password", "wsse");
                //password.setAttribute("Type", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");
               password.addTextNode(VuceWsSecurity.getInstance().getPassword());

               //Print out the outbound SOAP message to System.out
               JLogger.getCurrentLog().log(JLevel.INFO_FINNEST, header.toString());
               JLogger.getCurrentLog().log(JLevel.INFO_FINNEST, envelope.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            try {
                
                //This handler does nothing with the response from the Web Service so
                //we just print out the SOAP message.
            	JLogger.getCurrentLog().log(JLevel.INFO_FINNEST, smc.getMessage().getSOAPPart().getEnvelope().toString());

            } catch (Exception ex) {
                ex.printStackTrace();
            } 
        }


        return outboundProperty;

    }

    @SuppressWarnings("unchecked")
	public Set getHeaders() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return null;
    }

    public boolean handleFault(SOAPMessageContext context) {
        //throw new UnsupportedOperationException("Not supported yet.");
        return true;
    }

    public void close(MessageContext context) {
    	//throw new UnsupportedOperationException("Not supported yet.");
    }
}