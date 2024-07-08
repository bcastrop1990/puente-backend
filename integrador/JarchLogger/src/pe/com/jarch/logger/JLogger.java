package pe.com.jarch.logger;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class JLogger {
  private static JLogger instance = null;
  
  private String logName = "AppLogger";
  
  private String logFile = "logging.properties";
  
  private Boolean usePrefixLogFileName = Boolean.valueOf(false);
  
  private String prefixLogFileName = "";
  
  private int fileHandlerLimit = 5000000;
  
  private int fileHandlerCount = 1;
  
  private String baseDirectory = "";
  
  public static void initialize(String prefixLogFileName) {
    if (instance == null)
      instance = new JLogger(Boolean.valueOf(true), prefixLogFileName); 
  }
  
  public static Logger getCurrentLog() {
    if (instance == null)
      instance = new JLogger(Boolean.valueOf(false), ""); 
    return instance.getLog();
  }
  
  private void ReadConfiguration() {
    try {
      Properties fileProp = new Properties();
      System.out.println(getClass().getResource("/" + this.logFile));
      System.out.println(ClassLoader.getSystemResource(this.logFile).getPath());
      fileProp.load(ClassLoader.getSystemResourceAsStream(this.logFile));
      this.fileHandlerLimit = Integer.parseInt(fileProp.getProperty("java.util.logging.FileHandler.limit"));
      this.fileHandlerCount = Integer.parseInt(fileProp.getProperty("java.util.logging.FileHandler.count"));
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd");
      String dateLogName = formatter.format(new Date());
      if (this.usePrefixLogFileName.booleanValue()) {
        String aux = fileProp.getProperty("java.util.logging.FileHandler.pattern");
        int idx = aux.lastIndexOf("/");
        if (idx >= 0) {
          this.baseDirectory = aux.substring(0, idx + 1);
          aux = String.valueOf(this.baseDirectory) + getPrefixLogFileName() + dateLogName + "_" + aux.substring(idx + 1);
        } else {
          aux = String.valueOf(getPrefixLogFileName()) + dateLogName + "_" + aux;
        } 
        System.out.println(aux);
        fileProp.setProperty("java.util.logging.FileHandler.pattern", aux);
      } 
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      fileProp.store(out, "");
      LogManager.getLogManager().readConfiguration(new ByteArrayInputStream(out.toByteArray()));
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  private JLogger(Boolean usePrefixLogFileName, String prefixLogFileName) {
    try {
      this.usePrefixLogFileName = usePrefixLogFileName;
      this.prefixLogFileName = prefixLogFileName;
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd");
      String dateLogName = formatter.format(new Date());
      ReadConfiguration();
      LogManager.getLogManager().addLogger(Logger.getLogger(this.logName));
      Handler[] arrayOfHandler;
      int j = (arrayOfHandler = getLog().getParent().getHandlers()).length;
      for (int i = 0; i < j; i++) {
        Handler hnd = arrayOfHandler[i];
        if (hnd.getClass().getName().equalsIgnoreCase(FileHandler.class.getName()))
          hnd.setFilter(new JLevelFilter(JLevel.STDOUT, true)); 
      } 
      Handler fh1 = new FileHandler(String.valueOf(this.baseDirectory) + getPrefixLogFileName() + dateLogName + "_sysout.log", this.fileHandlerLimit, this.fileHandlerCount, true);
      fh1.setFormatter(new SimpleFormatter());
      fh1.setLevel(JLevel.STDOUT);
      fh1.setFilter(new JLevelFilter(JLevel.STDOUT));
      getLog().addHandler(fh1);
      System.setOut(new PrintStream(new JLoggingOutputStream(getLog(), JLevel.STDOUT), true));
      Object fh2 = new FileHandler(String.valueOf(this.baseDirectory) + getPrefixLogFileName() + dateLogName + "_syserr.log", this.fileHandlerLimit, this.fileHandlerCount, true);
      ((Handler)fh2).setFormatter(new SimpleFormatter());
      ((Handler)fh2).setLevel(JLevel.STDERR);
      ((Handler)fh2).setFilter(new JLevelFilter(JLevel.STDERR));
      getLog().addHandler((Handler)fh2);
      System.setErr(new PrintStream(new JLoggingOutputStream(getLog(), JLevel.STDERR), true));
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  private Logger getLog() {
    return LogManager.getLogManager().getLogger(this.logName);
  }
  
  public String getPrefixLogFileName() {
    if (this.usePrefixLogFileName.booleanValue())
      return String.valueOf(this.prefixLogFileName) + "_"; 
    return "";
  }
}
