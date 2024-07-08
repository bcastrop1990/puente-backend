package com.senasa.bpm.ng.service.impl;

import com.senasa.bpm.ng.model.response.PersonaResponse;
import com.senasa.bpm.ng.service.ConsultaSunatService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.axis.NoEndPointException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
@Slf4j
public class ConsultaSunatServiceImpl implements ConsultaSunatService {



    @Override
    public List<PersonaResponse> consultaSunat(String ruc) throws NoEndPointException {
        return null;
        /*
        if (this.endpoint == null) {
            throw new NoEndPointException();
        }
        Call call = (Call) new Service().createCall();
        call.setTargetEndpointAddress(this.endpoint);
        call.setOperationName(new QName("http://ws.gestionpersona.senasa.gob.pe/", "obtenerDatosPorRUC"));
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("");
        call.setEncodingStyle(null);
        call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        call.setProperty(Call.PROP_DOMULTIREFS, Boolean.FALSE);
        call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);

        try {
            Object response = call.invoke(new Object[]{ruc});

            if (response instanceof RemoteException) {
                throw (RemoteException) response;
            } else {
                return (List<PersonaResponse>) JavaUtils.convert(response, PersonaResponse.class);
            }
        } catch (RemoteException axisFault) {
            throw axisFault;
        }*/
    }
}



