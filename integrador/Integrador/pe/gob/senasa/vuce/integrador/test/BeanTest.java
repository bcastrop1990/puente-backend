package pe.gob.senasa.vuce.integrador.test;

import java.io.FileOutputStream;
import java.io.IOException;

import pe.gob.senasa.ucm.ClienteUCM;

import com.stellent.cis.client.io.ICISTransferStream;

public class BeanTest {
	public static void main(String[] args) {
		ICISTransferStream stream = ClienteUCM.getInstance().obtenerDocumento("00008964");
		try {
			System.out.println(stream.getFileName());
			System.out.println(stream.getContentType());
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
		System.out.println("FIN");
	}
}
