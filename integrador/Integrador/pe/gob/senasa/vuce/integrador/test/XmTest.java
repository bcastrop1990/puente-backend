package pe.gob.senasa.vuce.integrador.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.xml.sax.SAXException;

import pe.gob.senasa.vuce.integrador.bean.MensajeVUCE;
import pe.gob.senasa.vuce.integrador.exception.IntegradorException;
import pe.gob.senasa.vuce.integrador.helper.XmlHelper;

public class XmTest {
	public static void main(String[] args) throws FileNotFoundException, IOException, SAXException, IntegradorException  {
		XmlHelper xml = new XmlHelper();
		StringBuffer fileData = new StringBuffer(1000);
        BufferedReader reader = new BufferedReader(new FileReader("E:/VUCE_TEST/transaccion.xml"));
        char[] buf = new char[1024];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
            buf = new char[1024];
        }
        reader.close();
		MensajeVUCE mensaje = new MensajeVUCE();
		mensaje.setXmlTransaccion(fileData.toString());
		xml.parseXmlTransaccionVuce(mensaje);
		System.out.println(mensaje.getTransaccion().showInfo());
	}
}
