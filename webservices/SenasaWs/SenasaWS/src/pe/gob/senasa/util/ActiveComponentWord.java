package pe.gob.senasa.util;


import com.jacob.activeX.ActiveXComponent;

import org.apache.log4j.Logger;


public class ActiveComponentWord {
  protected static Logger logger = Logger.getLogger(ActiveComponentWord.class);
  private static ActiveComponentWord activeComponentWord;
  private static ActiveXComponent obWord ;
    public ActiveComponentWord() {
        super();
    }
  public static ActiveComponentWord getInstance() {
       if (activeComponentWord == null) {
           activeComponentWord = new ActiveComponentWord();
       }
       return activeComponentWord;
   }
  public synchronized ActiveXComponent getActiveXComponent(){
   // ActiveXComponent obWord = ActiveXComponent.connectToActiveInstance("Word.Application"); 
    if (obWord==null){
      logger.info("Método getActiveXComponent no existe instancia de word- instanciando Word.Application");
      //return new ActiveXComponent("Word.Application");        
      obWord= new ActiveXComponent("Word.Application"); 
      return obWord;
    }else{
      logger.info("Método getActiveXComponent instancia existente- connectToActiveInstance Word.Application");
      //return  ActiveXComponent.connectToActiveInstance("Word.Application"); 
      return obWord;
      
    } 
  }
  
}
