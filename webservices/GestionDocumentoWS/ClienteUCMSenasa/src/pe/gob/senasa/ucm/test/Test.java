package pe.gob.senasa.ucm.test;

import com.stellent.cis.client.io.ICISTransferStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import pe.gob.senasa.ucm.ClienteUCM;
import pe.gob.senasa.ucm.Documento;
import pe.gob.senasa.ucm.Version;

public class Test {
	public Test() {
		super();
	}

	public static void main(String[] args) {
            Documento doc = ClienteUCM.getInstance().obtenerInfoDocumento("00019989");
	    System.out.println(doc.getNombre());
	    System.out.println(doc.getId());
	    System.out.println(doc.getUrl());
	    System.out.println(doc.getConfidencial());
	    System.out.println(doc.getVersiones().size());
        for(Version v : doc.getVersiones()) {
            System.out.println(v.getId());
            System.out.println(v.getEtiqueta());
            System.out.println(v.getFecha());
            System.out.println(v.getUrl());
        }
              /*   byte[] archivo;
	      ICISTransferStream stream = ClienteUCM.getInstance().obtenerDocumentoPorTitulo("SIN_VALOR-FDSE");
	      try {
                System.out.println(stream.getContentType());
	        System.out.println(stream.getContentLength());
	        System.out.println(stream.getFileName());
	        FileOutputStream buffer = new FileOutputStream("D:/JM/ucm_doc.pdf");
	        int nRead;
	        byte[] data = new byte[16384];
	        while ((nRead = stream.getInputStream().read(data, 0, data.length)) != -1) {
	          buffer.write(data, 0, nRead);
	        }
	        buffer.flush();
	        buffer.close();
	        //archivo = buffer.toByteArray();
	      } catch (IOException e) {
	        e.printStackTrace();
	      }
	      System.out.println("FIN");*/
	}
}