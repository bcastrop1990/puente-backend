package pe.com.jarch.logger;

import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

class JLevelFilter implements Filter {
  private Level level;
  
  private boolean lessThan = false;
  
  public JLevelFilter(Level level) {
    this.level = level;
  }
  
  public JLevelFilter(Level level, boolean lessThan) {
    this.level = level;
    this.lessThan = lessThan;
  }
  
  public boolean isLoggable(LogRecord record) {
    if (this.lessThan)
      return (this.level.intValue() > record.getLevel().intValue()); 
    return (this.level.intValue() == record.getLevel().intValue());
  }
}
