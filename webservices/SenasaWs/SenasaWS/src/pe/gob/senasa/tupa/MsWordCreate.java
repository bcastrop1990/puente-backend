package pe.gob.senasa.tupa;


import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import java.io.File;

import java.util.ArrayList;
import java.util.Random;

import org.apache.log4j.Logger;

import pe.gob.senasa.util.ActiveComponentWord;


public class MsWordCreate {
  protected static Logger logger = Logger.getLogger(MsWordCreate.class);
  private final boolean ISVISIBLE  = false; 
  private final boolean SAVEONEXIT = false;
  
  private static MsWordCreate msWordCreate;
  ///private ActiveXComponent obWordAppGeneral;
  private ActiveXComponent obWordApp;
  private Dispatch obDocuments;
  private Dispatch obDocument;
  private Dispatch obSelection;
  
 /* public static synchronized MsWordCreate getSingletonObject() {
        if (msWordCreate == null) {
            msWordCreate = new MsWordCreate();
        }
        return msWordCreate;
  }*/ 
 /* public static MsWordCreate getInstance() {
      if (MsWordCreate == null) {
          msWordCreate = new MsWordCreate();
      }
      return msWordCreate;
  }*/
  public  MsWordCreate() {
      super();
      /*try {
          Thread.sleep(500);
      } catch (InterruptedException e) {
      }*/
    /*  synchronized (this){
      ActiveXComponent obWord = ActiveXComponent.connectToActiveInstance("Word.Application"); 
      if (obWord==null){
        logger.info("Constructor MsWordCreate obWord is null, no existe instancia de word- instanciando Word.Application");
        obWordApp = new ActiveXComponent("Word.Application");        
      }else{
        obWordApp =  ActiveXComponent.connectToActiveInstance("Word.Application"); 
        logger.info("Constructor MsWordCreate instancia existente- connectToActiveInstance Word.Application");
      }  
  }*/
    }
  public void Open(String filename)  {
    /*ActiveXComponent obWordApp = ActiveXComponent.connectToActiveInstance("Word.Application"); 
    if (obWordApp==null){
      obWordApp = new ActiveXComponent("Word.Application"); 
      obWordApp.setProperty("Visible", new Variant(ISVISIBLE));
      //obWordApp = ActiveXComponent.connectToActiveInstance("Word.Application"); 
    }else{
      obWordApp.setProperty("Visible", new Variant(ISVISIBLE));
    }*/
      
        /*logger.info("MsWordCreate Verificando si existe alguna isntancia- connectToActiveInstance Word.Application");
        ActiveXComponent obWord = ActiveXComponent.connectToActiveInstance("Word.Application"); 
        if (obWord==null){
          logger.info("MsWordCreate obWord is null, no existe instancia de word- instanciando Word.Application");
          obWordApp = new ActiveXComponent("Word.Application");        
        }else{
          obWordApp =  ActiveXComponent.connectToActiveInstance("Word.Application"); 
          logger.info("MsWordCreate instancia existente- connectToActiveInstance Word.Application");
        }*/
      
        obWordApp =  ActiveComponentWord.getInstance().getActiveXComponent();         
        obWordApp.setProperty("Visible", new Variant(true));
        obDocuments = obWordApp.getProperty("Documents").toDispatch();
        logger.info("MsWordCreate Open "+filename);
        obDocument = Dispatch.call(obDocuments, "Open", filename).toDispatch();
        obSelection = obWordApp.getProperty("Selection").toDispatch();    
        logger.info("MsWordCreate archivo abierto correctamente "+filename);
          
        
    }
  
  public void Save(String filename)
  { 
      logger.info("salvando "+filename);
      Dispatch oWordBasic = Dispatch.call(obWordApp, "WordBasic").getDispatch();
      Dispatch.call(oWordBasic, "FileSaveAs", filename);
      Dispatch.call(obDocument, "Close", new Variant(SAVEONEXIT));
      //obWordApp.invoke("Quit", new Variant[0]); 

   /* Dispatch oWordBasic = Dispatch.call(obWordApp, "WordBasic").getDispatch();       
    Dispatch.call(oWordBasic, "FileSaveAs", filename);
    Dispatch.call(obDocument, "Close", new Variant(SAVEONEXIT));
    */
    
   // Dispatch.call(Dispatch.call(obWordApp, "WordBasic").getDispatch(), "FileSaveAs", filename);

  }
  
  
  private void GoHome(){
    Dispatch.call(obSelection, "HomeKey", new Variant("6"));     // WdUnits.wdStory
    //obWordApp.call(obSelection, "HomeKey", new Variant("6"));     // WdUnits.wdStory
  }

  private void GoNextPage()
  {
    Dispatch.call(obSelection, 
                      "GoToNext",
                      new Variant("1"));     // WdGoToItem.wdGoToPage
    
  }

  private void GoToPage(int page)
  {
    GoHome();
    for (int i=1; i<page; i++)
      GoNextPage();   
  }
  
  // Obtiene el numero de paginas del documento
  public int getCounterPages()
  {
    Object attr[] = new Object[] { new Variant("2"),      // statisticPages
                                       Variant.VT_MISSING,    // includeFootnotesAndEndnotes
                                     };
      return Dispatch.callN(obDocument, "ComputeStatistics", attr).getInt();
  }
  
  // Obtiene el valor del margen izquierdo del documento
  public float getMarginLeft()
  {
      Dispatch oPageSetup = Dispatch.get(obDocument, "PageSetup").toDispatch();
      return Dispatch.get(oPageSetup, "LeftMargin").getFloat();
  }
  
  // Obtiene el valor del margen superior del documento
  public float getMarginTop()
  {
      Dispatch oPageSetup = Dispatch.get(obDocument, "PageSetup").toDispatch();
      return Dispatch.get(oPageSetup, "TopMargin").getFloat();
  }
  
  // Obtiene el valor del alto de la pagina
  public float getPageHeight()
  {
      Dispatch oPageSetup = Dispatch.get(obDocument, "PageSetup").toDispatch();
      return Dispatch.get(oPageSetup, "PageHeight").getFloat();
  }
  
  // Obtiene el valor del margen superior del documento
  public float getHeaderDistance()
  {
      Dispatch oPageSetup = Dispatch.get(obDocument, "PageSetup").toDispatch();
      return Dispatch.get(oPageSetup, "HeaderDistance").getFloat();
  }
  
  // Reemplaza todas las ocurrencias del texto tagName por newValue
  public void ReplaceTextByText(String tagName, String newValue)
  {       
    GoHome();
      Dispatch oFind = Dispatch.call(obSelection, "Find").toDispatch();
      
      Object attr[] = new Object[] { new Variant(tagName),  // findText
                                 Variant.VT_MISSING,    // matchCase
                                 Variant.VT_MISSING,    // matchWholeWord
                                 Variant.VT_MISSING,    // matchWildcards
                                 Variant.VT_MISSING,    // matchSoundsLike
                                 Variant.VT_MISSING,    // matchAllWordForms
                                 Variant.VT_MISSING,    // forward
                                 new Variant("1"),      // wrap
                                 Variant.VT_MISSING,    // format
                                 new Variant(newValue), // replaceWith
                                 new Variant("2"),      // replace
                                 Variant.VT_MISSING,    // matchKashida
                                 Variant.VT_MISSING,    // matchDiacritics
                                 Variant.VT_MISSING,    // matchAlefHamza
                                 Variant.VT_MISSING,    // matchControl
                               };
      
      Dispatch.callN(oFind, "Execute", attr);
      
     /*obDocument.put(oFind, "Text", tagName);
     obDocument.call(oFind, "Execute");
     obDocument.put(obSelection, "Text", newValue);*/
  }

  // Reemplaza la 1ra ocurrencia del texto tagname por la imagen referenciada por filename
  public void ReplaceTextByImage(String tagName, String filename)
  {     
    GoHome();
      Dispatch oFind = Dispatch.call(obSelection, "Find").toDispatch();
      Dispatch.put(oFind, "Text", tagName);
      Boolean result = Dispatch.call(oFind, "Execute").getBoolean();
      logger.debug("Verifica si existe  tagName: " + tagName+ " filename: " + filename);

    
      if (result.booleanValue() == false){ 
          logger.debug("No encontro el tagname:"+tagName+" retorna Variant.VT_MISSING: " + Variant.VT_MISSING);
          //return Variant.VT_MISSING.getBoolean();
      }
      Dispatch.put(obSelection, "Text", "");
      Dispatch oImage = Dispatch.get(obSelection, "InLineShapes").toDispatch();
      logger.debug("Reemplazo al parecer EXITOSO. ");
      //return Dispatch.call(oImage, "AddPicture", filename);
      Boolean rp =Dispatch.call(oImage, "AddPicture", filename).getBoolean();
    logger.debug("Reemplazo al parecer EXITOSO 2. " + rp);
    
    //Dispatch.call(Dispatch.get(selection, "InLineShapes").toDispatch(), "AddPicture", imagePath);

  }
  
  // Inserta la imagen flotante (en la esquina superior derecha) referenciada por filename
  public Dispatch InsertImage(String filename)
  {
    return InsertImage(filename, Variant.VT_MISSING);
  }

  // Inserta la imagen flotante referenciada por filename, en base a una referencia
  public Dispatch InsertImage(String filename, Variant anchor)
  {
    GoHome();
      Dispatch oShapes = Dispatch.call(obDocument, "Shapes").toDispatch();
      Object attr[] = new Object[] { new Variant(filename), // fileName
                                       Variant.VT_MISSING,    // linkToFile
                                       Variant.VT_MISSING,    // saveWithDocument
                                       Variant.VT_MISSING,    // left
                                       Variant.VT_MISSING,    // top
                                       Variant.VT_MISSING,    // width
                                       Variant.VT_MISSING,    // height
                                       anchor                 // anchor
                                     };

      return Dispatch.callN(oShapes, "AddPicture", attr).toDispatch();
  } 
  
  // Inserta una lista de imagenes en el border izquierdo de la primera pagina. 
  // A todas las imagenes les aplica pequeños desplazamientos y rotaciones al azar.
  public void InsertStripImagesAtLeft(String filenames[])
  {
    InsertStripImagesAtLeft(filenames, 1);
  }
  
  // Inserta una lista de imagenes en el border izquierdo de la pagina indicada. 
  // A todas las imagenes les aplica pequeños desplazamientos y rotaciones al azar.
  public void InsertStripImagesAtLeft(String filenames[], int page)
  {
    Dispatch oShape;
      Random ran        = new Random();
      float leftMargin  = getMarginLeft();
      float deltaTop    = -getMarginTop() - getHeaderDistance() + ran.nextFloat()*5.0f + 5.0f;
      Variant anchor;
      
      GoToPage(page);
      anchor = Dispatch.get(obSelection, "Range");
      for (String item:filenames)
      {
        oShape = InsertImage(item, anchor);
        Dispatch.put(oShape, "Left", new Variant(-leftMargin + ran.nextFloat()*10.0f));
        Dispatch.put(oShape, "Rotation", new Variant(ran.nextFloat()*40.0f - 20.0f));
        Dispatch.call(oShape, "IncrementTop", new Variant(deltaTop)); 
        Dispatch.call(oShape, "ZOrder", new Variant("5"));
        deltaTop += Dispatch.get(oShape, "Height").getFloat() + ran.nextFloat()*3.0f + 2.0f;
      }
  }
  
  // Inserta una lista de imagenes en el border izquierdo de la primera pagina. 
    // A todas las imagenes les aplica pequños desplazamientos y rotaciones al azar.
    public void InsertStripImagesAtLeft(String filenames[],boolean borrar)
    {
        GoHome();

        Dispatch oShape;
        Random ran       = new Random();
        float leftMargin = getMarginLeft();
        float deltaTop   = -getMarginTop() - getHeaderDistance() + ran.nextFloat()*5.0f + 5.0f;

        for (String item:filenames){
           try{
            oShape = InsertImage(item);
            Dispatch.put(oShape, "Left", new Variant(-leftMargin + ran.nextFloat()*10.0f));
            Dispatch.put(oShape, "Rotation", new Variant(ran.nextFloat()*40.0f - 20.0f));
            Dispatch.call(oShape, "IncrementTop", new Variant(deltaTop));   
            Dispatch.call(oShape, "ZOrder", new Variant("5"));
            deltaTop += Dispatch.get(oShape, "Height").getFloat() + ran.nextFloat()*3.0f + 2.0f;
               
            //if(borrar)UCMClient.eliminarArchivo(item);
            File file= new File(item);      
            if(file.exists()) file.delete();  
          }catch(Exception e){                
              //logger.debug("ERROR : La imagen "+item+" no existe en el filesystem");
              continue;
            }
        }
    }

  
  public Variant FillTable(String tagName, String data[][])
  {
    GoHome();
      Dispatch oFind = Dispatch.call(obSelection, "Find").toDispatch();
      Dispatch.put(oFind, "Text", tagName);
      Boolean result = Dispatch.call(oFind, "Execute").getBoolean();
      if (result.booleanValue() == false)
        return Variant.VT_MISSING;
      Dispatch.put(obSelection, "Text", "");
            
      boolean insertRow = false;
      for (String row[]:data){
        if (insertRow){
          Dispatch.call(obSelection, "InsertRows", new Variant("1"));
        }
        for (String item:row){
          Dispatch.call(obSelection, "TypeText", new Variant(item));   
          Dispatch.call(obSelection, 
                    "MoveRight", 
                    new Variant("1"),    // WdUnits.wdCharacter
                    new Variant("1"));   // Count
        }
        insertRow = true;
      }
      
      return Variant.VT_TRUE;
  } 
  
  // Graba el documento abierto con el nuevo nombre indicado
/*  public void Close(String filename)
  { 
    Dispatch oWordBasic = Dispatch.call(obWordApp, "WordBasic").getDispatch();
      Dispatch.call(oWordBasic, "FileSaveAs", filename);
      Dispatch.call(obDocument, "Close", new Variant(SAVEONEXIT));
      obWordApp.invoke("Quit", new Variant[0]); 
  }*/
  
  // Para prueba 
  public static void main(String[] args) 
  {
    String dir = "C:\\Users\\jgonzalez\\Desktop\\varios\\senasa\\firma\\";
      
    String inputDoc = dir + "prueba plat.docx";
      String outputDoc = dir + "out-java.docx";
      String imgFirma = dir + "firma.png";
      String check1   = dir + "visto1.png";
      String check2   = dir + "visto2.png";
      
      String tagTitle = "<bpm:titulo>";
      String tagTo = "<bpm:destinatario>";
      String tagRef = "<bpm:referencia>";
      String tagFirma = "<bpm:firmaRemitente>";
      String tagTbProdTitle = "<bpm:prodtitle>";
      String tagTbProdDesc  = "<bpm:proddesc>";
      String tagTbProducto  = "<bpm:prod>";
      
      String newTitle = "Prueba desde java";
      String newTo = "Juan Perez Gomez";
      String newRef = "123-8939-eef";
      String newProdTitle = "Factura destallada";
      String newProdDesc = "Venta al Hola, SA, de productos de libreria";
      
      String stripImages[] = new String[] { check1 , check2, check1, check1 , check2, check1 };
      
      String tableData[][] = new String[][] { {"C10291", "Papel Bond B20", "3"},
                          {"C39238", "Lapices", "2"},
                          {"C89211", "Cuadernos tapa dura", "12"},
                          {"C97832", "Boligrafos BIC", "4"},
                          {"C00121", "Factureros", "23"},       
                                            };
      
      MsWordReplace mswr = new MsWordReplace();
      
      try
      {
        //abre en msword documento plantilla
        mswr.Open(inputDoc);
        
        //reemplazo de texto por texto
        mswr.ReplaceTextByText(tagTo, newTo);     
        mswr.ReplaceTextByText(tagTitle, newTitle);
        mswr.ReplaceTextByText(tagRef, newRef);       
        mswr.ReplaceTextByText(tagTbProdTitle, newProdTitle);
        mswr.ReplaceTextByText(tagTbProdDesc, newProdDesc);
        
        //reemaplazo de texto por imagen
        mswr.ReplaceTextByImage(tagFirma, imgFirma);  
          
        //rellenado de tabla
        mswr.FillTable(tagTbProducto, tableData);
        
        //insertar imagenes en el lado izquierdo en todas las paginas 
        int pages = mswr.getCounterPages();       
        for (int i=1; i<=pages; i++)
        {
          mswr.InsertStripImagesAtLeft(stripImages, i);
        }
      }
      finally
      {
        //cierra msword grabado el documento en un nuevo archivo 
        mswr.Close(outputDoc);
      }
  }
  
  public void FillTable(String tagName, ArrayList datos)
  {
      if(datos==null) return;
      
      if(datos.size()==0) return;
      
      String[][] data= new String[datos.size()][((ArrayList)datos.get(0)).size()];
      
      ArrayList dat=null;
      
      for(int i=0; i<datos.size();i++)
      {
          dat = (ArrayList)datos.get(i);
          for(int j=0;j<dat.size();j++)
          {
            data[i][j]=(String)dat.get(j);
          }
      }
      
      FillTable(tagName, data);
  }
  
}
