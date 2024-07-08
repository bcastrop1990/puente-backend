package pe.gob.senasa.test;

import java.io.IOException;
import java.io.StringReader;

import java.sql.Timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import pe.gob.senasa.service.IGestionVUCEService;
import pe.gob.senasa.service.serviceImpl.GestionVUCEService;


public class Test {
    public Test() {
        super();
    }

 
   public static void main(String[] args) 
   {
       
      IGestionVUCEService g = new GestionVUCEService();
      
      /*DatosIIV d= g.obtenerDatosIIV("1", "O2011006848","F");
      System.out.println(d.getProductos().getListaProductos().size());*/
     // DatosExpo d= g.obtenerDatosExpoFito("1", "O2011006848");
      //System.out.println(d.getProductos().getListaProductos().size());
      
       
    /* String v="Sol. PFI-110100000057-23/11/2011 11:41 AM";
     int idx = v.indexOf("\\/");
     System.out.println(idx);
     System.out.println(v.length());
     System.out.println(v.substring(0, 3));*/
    SimpleDateFormat sdf2= new SimpleDateFormat("hh:mm");
    
    java.util.Date date1 = new java.util.Date();
      System.out.println("Hello World! "+ date1);
        try {
            date1=sdf2.parse("10:30");
        } catch (ParseException e) {
          System.out.println("error parse ! "+ e);
        }
        System.out.println("SDF ! "+ date1);
      
      
     // java.sql.Date date2 = new java.sql.Date(date1.getTime());
     Timestamp date2 = new Timestamp(date1.getTime());
      System.out.println("Hello World2 ! "+ date2);
     StringBuilder xmlString =new StringBuilder();
     xmlString.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
     xmlString.append("<suce>");
     xmlString.append("<DocumentHeader>");
     xmlString.append("<Name>");
     xmlString.append("omar");
     xmlString.append("</Name>");
     xmlString.append("</DocumentHeader>");
     xmlString.append("</suce>");
     
     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
     DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            System.out.println(xmlString.toString());
            Document document = builder.parse(new InputSource(new StringReader(xmlString.toString())));
            
            System.out.println(document);
            
        } catch (ParserConfigurationException e) {
          System.out.println("ParserConfigurationException" + e);
        } catch (SAXException e) {
          System.out.println("Error SAXException" + e);
        } catch (IOException e) {
          System.out.println("IOException" + e);
        }


        //g.cierreTramite("110100000053", "001", listaAdjuntos);
   }
}
