package pe.gob.senasa.tupa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;


public class TagsBPM {
    
    protected static Logger logger = Logger.getLogger(TagsBPM.class);

    private File sourceFile = null;
    private Hashtable<String, String> srTerms = null;
    private XWPFDocument doc = null;

    public TagsBPM() {
        super();
    }

    public TagsBPM(String nombreArchivo) throws IOException {
        FileInputStream iS = null;
        try {
            this.sourceFile = new File(nombreArchivo);
            if (!this.sourceFile.exists() && !this.sourceFile.canRead()) {
                throw new IllegalArgumentException("El archivo " +
                                                   nombreArchivo +
                                                   " no es Accesible");
            } else {
                iS = new FileInputStream(this.sourceFile);
                this.doc = new XWPFDocument(iS);
                this.srTerms = new Hashtable<String, String>();

            }
        } catch (IOException e) {
            System.out.println(e.toString());
            throw new IOException(e);
        }
        /*finally{
         try{
           //iS.close();
         }
         catch(IOException e){
           System.out.println(e.toString());
           throw new IOException(e);
         }
      }*/
    }

    public void addSearchTerm(String searchTerm, String replacementText) {
        this.srTerms.put(searchTerm, replacementText);
    }

    public byte[] searchReplace() throws FileNotFoundException, IOException {
        Iterator<XWPFParagraph> parasIter = this.doc.getParagraphsIterator();
        Iterator<XWPFRun> runsIter = null;
        Enumeration<String> srchTermEnum = null;
        XWPFParagraph para = null;
        XWPFRun run = null;
        List<XWPFRun> runsList = null;
        String searchTerm = null;
        String runText = null;
        String replacementText = null;
        OutputStream oS = null;
        String paraText = null;
        while (parasIter.hasNext()) {
            para = parasIter.next();
            runsList = para.getRuns();
            runsIter = runsList.iterator();
            while (runsIter.hasNext()) {
                run = runsIter.next();
                runText = run.getText(0);
                //System.out.println(runText);
                if (runText != null) {
                    srchTermEnum = this.srTerms.keys();
                    while (srchTermEnum.hasMoreElements()) {
                        searchTerm = srchTermEnum.nextElement();
                        if (runText.contains(searchTerm)) {
                            replacementText = this.srTerms.get(searchTerm);
                            runText =
                                    runText.replaceAll(searchTerm, replacementText);
                            run.setText(runText, 0);
                        }
                    }
                }
            }
        }
        oS = new FileOutputStream(this.sourceFile);
        this.doc.write(oS);
		   InputStream stream = new FileInputStream(this.sourceFile);
	    
      	byte[] bytes = IOUtils.toByteArray(stream);
        
        oS.flush();
        oS.close();
        
        return bytes;

    }
    
      /**
       * 
       * @param posicionTabla
       * @param lista
       */
      public void agregarDatosTabla(int posicionTabla,ArrayList lista){
        
        if(lista==null || lista.size()==0) return;
        
        int cantRegistro = ((ArrayList)lista.get(0)).size();
        
        XWPFTable xwpft = this.doc.getTableArray(posicionTabla);
        
        ArrayList listaRow =null;
        
        for(int i=0;i<lista.size();i++)
        {
            
            XWPFTableRow row = xwpft.createRow();
            
            listaRow = (ArrayList)lista.get(i);
            
            for(int j=0;j<cantRegistro;j++)
            {
              logger.debug("row:"+row);
                
              logger.debug("row.getCell("+j+"):"+row.getCell(j));
              
              row.getCell(j).setText(""+listaRow.get(j));
              
            }
            
        }
      
      } 
      
      public void insertarEnTabla(int posicionTabla, int posicionRow,int posicionCell, String valor)
      {
          
        XWPFTable xwpft =  this.doc.getTableArray(posicionTabla);
        
        xwpft.getRow(posicionRow).getCell(posicionCell).setText(valor);
        
      }
      
      
      
    
      
      
      
  /**
    * 
    * @param posicionTabla
    * @param lista
    */
   public void agregarDatosTabla(int posicionTabla,boolean insPriLin, ArrayList lista){
     
     if(lista==null || lista.size()==0) return;
     
     int cantRegistro = ((ArrayList)lista.get(0)).size();
     
     XWPFTable xwpft = this.doc.getTableArray(posicionTabla);
     
     logger.debug("cantidad de tablas en el documento:"+ this.doc.getTables().size());
     
     logger.debug("xwpft:"+xwpft);
     
     ArrayList listaRow =null;
     
     for(int i=0;i<lista.size();i++)
     {
       XWPFTableRow row = null;
       
       if(i==0 && insPriLin==true)
       {
         row = xwpft.getRow(0);
       }else
       {
           row = xwpft.createRow();
       }
         
       logger.debug("row:"+row);
       
         listaRow = (ArrayList)lista.get(i);
         
         for(int j=0;j<cantRegistro;j++)
         {
           
           row.getCell(j).setText(""+listaRow.get(j));
           
         }
         
     }
   
   } 
   
   /**
    * 
    * @param posicionTabla
    * @param lista
    */
   public void agregarDatosTabla(int posicionTabla,int posicionDentroTabla,ArrayList lista){
     
     if(lista==null || lista.size()==0) return;
     
     int cantRegistro = ((ArrayList)lista.get(0)).size();
     
     XWPFTable xwpft = this.doc.getTableArray(posicionTabla);
     
     logger.debug("cantidad de tablas:"+ this.doc.getTables().size());
     
     xwpft = this.doc.getTables().get(posicionTabla);
     
     ArrayList listaRow =null;
     
     logger.debug(xwpft);
     
     for(int i=0;i<lista.size();i++)
     {
       
         XWPFTableRow row = xwpft.insertNewTableRow(posicionDentroTabla+i);
         
         logger.debug(row);
         
         listaRow = (ArrayList)lista.get(i);
         
         logger.debug("cantRegistro:"+cantRegistro);
         
         for(int j=0;j<cantRegistro;j++)
         {
           
          logger.debug("listaRow.get(j):"+listaRow.get(j));
           
           
          
           row.createCell();
           
           logger.debug("row.getCell(j):"+row.getCell(j));
           
           row.getCell(j).setText(""+listaRow.get(j));
           
         }
         
     }
   
   }   
   
  public void reemplazarEnTabla(int posicionTabla, int posicionRow,int posicionCell, String campoRemplazar, String valor)
  {
      
    XWPFTable xwpft =  this.doc.getTables().get(posicionTabla);
    
    List<XWPFParagraph> listaParrafos = xwpft.getRow(posicionRow).getCell(posicionCell).getParagraphs();
    
    //System.out.println("numero de parrafos:"+listaParrafos.size());
    
    XWPFParagraph parrafo = null;
    
    XWPFRun run = null;
    
    String runText = null;
    
    //System.out.println("listaParrafos.size():"+listaParrafos.size());
    
    for(int i=0; i<listaParrafos.size();i++){
      
      parrafo = (XWPFParagraph)listaParrafos.get(i);
      
      List<XWPFRun>  runs =parrafo.getRuns(); 
        
      for(int j=0;j<runs.size();j++){
        
        run =runs.get(j);
        
        runText =  run.getText(0);
        
            runText =   runText.replaceAll(campoRemplazar, valor);
       
            run.setText(runText, 0);
        
        
      }
      
    }
   }
   
   
   public static String ByteArrayToString(byte[] ba) 
   {  
     StringBuilder hex = new StringBuilder(ba.length * 2);   
       for (byte b : ba) {
         
         hex.append(b);
       }    
       return hex.toString(); 
    } 
   
   
  public void obtenerTablas(List<XWPFTable> tablaReferencia){
       
       List<XWPFTable> lista = null;
       
       XWPFTable tabla = null;
       
       List<XWPFTableRow> listaRow = null;
       
       XWPFTableRow row = null;
       
       XWPFTableCell cell = null;
       
       List<XWPFTableCell> listaCell = null;
       
       Enumeration<String> srchTermEnum = null;
       
       String searchTerm = null;
       
       String replacementText = null;
       List<XWPFTable> tablaInterna = null;
       
         if(tablaReferencia.size() == 0){
        
         
            lista = this.doc.getTables();
         }
         
         else{
             
             
           lista = tablaReferencia;
         } 
         
       for(int i = 0; i<lista.size(); i++){
           
         tabla = lista.get(i);
         listaRow = tabla.getRows();
           
           for(int j = 0; j<listaRow.size(); j++){
               
             row = listaRow.get(j);
             listaCell = row.getTableCells();
             
               for(int k = 0; k<listaCell.size(); k++){
                   
                 cell = listaCell.get(k);
                 //System.out.println("esta es la celda: "+cell.getText());
                   tablaInterna = cell.getTables();
                   
                   if(tablaInterna.size() > 0){
                     
                   
                     obtenerTablas(cell.getTables());
                   }
                   else{
                     tablaInterna = new ArrayList();
                   }
                   
                  
                       
                     //srchTermEnum = this.srTerms.keys();
                       
                     //while (srchTermEnum.hasMoreElements()) {
                         
                         //searchTerm = srchTermEnum.nextElement();
                         //replacementText = this.srTerms.get(searchTerm);
                   
                     reemplazarEnTablaDocumentario(i, j, k, tabla);
                   
                         
                     //}
                       
                   
               }
           }         
           
       }
     }
  
  
  /**
    * @param posicionTabla
    * @param posicionRow
    * @param posicionCell
    * @param campoRemplazar
    * @param valor
    */
   public void reemplazarEnTablaDocumentario(int posicionTabla, int posicionRow,int posicionCell, XWPFTable tablaInterna)
  {
   Enumeration<String> srchTermEnum = null;
   
   String searchTerm = null;
   XWPFTable xwpft = null;
   
   String replacementText = null;
    
   //System.out.println("Esta es la tabla: "+tablaInterna.getText());
   if( tablaInterna.getRow(posicionRow).getCell(posicionCell) != null){
   List<XWPFParagraph> listaParrafos = tablaInterna.getRow(posicionRow).getCell(posicionCell).getParagraphs();
   
     //System.out.println("numero de parrafos:"+listaParrafos.size());
     XWPFParagraph parrafo = null;
     XWPFRun run = null;
     String runText = null;
   
     for(int i=0; i<listaParrafos.size();i++){

       parrafo = listaParrafos.get(i);
       //System.out.println("Este es el parrafo: "+parrafo.getText());
       List<XWPFRun> runs =parrafo.getRuns();
       //System.out.println("este es el runList "+runs.size());
       for(int j=0;j<runs.size();j++){
           run = runs.get(j);
           
           //System.out.println(runText);
           //if (runText != null) {
             srchTermEnum = this.srTerms.keys();
             while (srchTermEnum.hasMoreElements()) {
                 runText = run.getText(0);
                 searchTerm = srchTermEnum.nextElement();
                 System.out.println("Este es el termino de busqueda: "+searchTerm);
                 System.out.println("Este es el runText: "+runText);
                 if (runText.contains(searchTerm)) {
                   replacementText = this.srTerms.get(searchTerm);
                   System.out.println("Este es el valor de reemplazo: "+replacementText);
                   runText = runText.replaceAll(searchTerm, replacementText);
                   System.out.println("Este es el run reemplazado: "+runText);
                   run.setText(runText, 0);
                 }
             }
         //}
       }

       //run =runs.get(j);
       //runText = run.getText(0);
       //runText = runText.replaceAll(campoRemplazar, valor);
       //run.setText(runText, 0);

     }
   }
  }
    
}
