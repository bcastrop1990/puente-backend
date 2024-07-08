package pe.gob.senasa.vuce.integrador.test;

/*import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;*/

public class MainIntegradorCargaMetadata {
	
	/*public static void main(String[] args) {
		Document doc;
		String zipFileName = "E:/ebxml_templates/SNS031.xml";
		try {
			doc=filetoDocument(zipFileName);
			procesarFormato(doc, "SNS031");			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static Document filetoDocument (String Ruta)
	{
		Document doc = null;
		try 
		{
			File file = new File(Ruta);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			  DocumentBuilder db = dbf.newDocumentBuilder();
			  doc = db.parse(file);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return doc;
	}
	
	private static void procesarFormato(Document doc, String codFormato)
	{
		try
		{
			EbXmlHelper ebXmlHelper = new EbXmlHelper(); 
			ebXmlHelper.readEbXMLFormato((Element)doc.getDocumentElement(), codFormato, "", null);					
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}*/

}
