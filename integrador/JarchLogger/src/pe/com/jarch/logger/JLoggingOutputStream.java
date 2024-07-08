package pe.com.jarch.logger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class JLoggingOutputStream extends ByteArrayOutputStream {
  private String lineSeparator;
  
  private Logger logger;
  
  private Level level;
  
  public JLoggingOutputStream(Logger logger, Level level) {
    this.logger = logger;
    this.level = level;
    this.lineSeparator = System.getProperty("line.separator");
  }
  
  public void flush() throws IOException {
    synchronized (this) {
      super.flush();
      String record = toString();
      reset();
      if (record.length() == 0 || record.equals(this.lineSeparator))
        return; 
      this.logger.logp(this.level, "", "", record);
    } 
  }
}
