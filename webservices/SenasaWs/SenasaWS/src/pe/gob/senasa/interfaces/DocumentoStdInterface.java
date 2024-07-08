package pe.gob.senasa.interfaces;

import pe.gob.senasa.bean.std.DocumentoSTD;

public interface DocumentoStdInterface {
    
  public DocumentoSTD grabarDocumentoStdHijo(DocumentoSTD docStd);
  public String ObtenerCodDocumentoStdPadre(String codigoExpediente);
      
}
