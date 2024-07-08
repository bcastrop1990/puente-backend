package pe.gob.senasa.util;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class Word {
    
      String strDir ="C:\\temporal\\";// "c:jacob_1.9";
      // colocar en la ruta para SOLARIS: \\10.0.0.213\temporal como /var/tmp links to /tmp
     String strInputDoc = strDir + "file_indoc.docX";
     String strOutputDoc = strDir + "file_outdoc.docx";
     String strOldText = "[label:import:1]";
     String strNewText =
             "I am some horribly long sentence, so long that [insert anything]";
     boolean isVisible = true;
     boolean isSaveOnExit = false;


  public Word() {
      //http://www.4ucode.com/Study/Topic/403972
      //http://clq9761.iteye.com/blog/1284318
          ActiveXComponent oWord = new ActiveXComponent("Word.Application");
          oWord.setProperty("Visible", new Variant(isVisible));
          Dispatch oDocuments = oWord.getProperty("Documents").toDispatch();
          Dispatch oDocument = Dispatch.call(oDocuments, "Open", strInputDoc).
                               toDispatch();
          Dispatch oSelection = oWord.getProperty("Selection").toDispatch();
          Dispatch oFind = oWord.call(oSelection, "Find").toDispatch();
          Dispatch.put(oFind, "Text", strOldText);
          Dispatch.call(oFind, "Execute");
          Dispatch.put(oSelection, "Text", strNewText);
          Dispatch.call(oSelection, "MoveDown");
          Dispatch.put(oSelection, "Text",
                       "nSo we got the next line including BR.n");

          Dispatch oFont = Dispatch.get(oSelection, "Font").toDispatch();
          Dispatch.put(oFont, "Bold", "1");
          Dispatch.put(oFont, "Italic", "1");
          Dispatch.put(oFont, "Underline", "0");

          Dispatch oAlign = Dispatch.get(oSelection, "ParagraphFormat").
                            toDispatch();
          Dispatch.put(oAlign, "Alignment", "3");
          Dispatch oWordBasic = (Dispatch) Dispatch.call(oWord, "WordBasic").
                                getDispatch();
          Dispatch.call(oWordBasic, "FileSaveAs", strOutputDoc);
          Dispatch.call(oDocument, "Close", new Variant(isSaveOnExit));
          oWord.invoke("Quit", new Variant[0]);
      }


    public static void main(String[] args) {
        Word word = new Word();
    }
}
