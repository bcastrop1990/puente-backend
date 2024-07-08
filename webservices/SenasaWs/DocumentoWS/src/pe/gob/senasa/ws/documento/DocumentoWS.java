package pe.gob.senasa.ws.documento;

import javax.jws.WebMethod;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;

import pe.gob.senasa.ws.documento.bean.Documento;
import pe.gob.senasa.helper.bean.Auditoria;
import pe.gob.senasa.ws.documento.dao.DocumentoDAO;

@XmlSeeAlso({Auditoria.class, Documento.class})
@WebService(name = "Documento",serviceName = "Documento", 
            targetNamespace = "http://documento.ws.senasa.gob.pe", portName = "DocumentoPort")
public class DocumentoWS implements IDocumentoServicio {
    private DocumentoDAO dao = null;
    public DocumentoWS() {
        super();
        dao = new DocumentoDAO();
    }
}
