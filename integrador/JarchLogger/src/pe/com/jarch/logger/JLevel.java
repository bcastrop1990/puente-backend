package pe.com.jarch.logger;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.util.logging.Level;

public class JLevel extends Level {
  private static final long serialVersionUID = 1L;
  
  public static final Level INFO_APP = new JLevel("INFO[APP]", 830);
  
  public static final Level INFO_FINE = new JLevel("INFO[1]", 825);
  
  public static final Level INFO_FINNER = new JLevel("INFO[2]", 820);
  
  public static final Level INFO_WS = new JLevel("INFO[WS]", 815);
  
  public static final Level INFO_BD = new JLevel("INFO[BD]", 810);
  
  public static final Level INFO_FINNEST = new JLevel("INFO[3]", 805);
  
  public static Level STDOUT = new JLevel("STDOUT", Level.INFO.intValue() + 101);
  
  public static Level STDERR = new JLevel("STDERR", Level.INFO.intValue() + 102);
  
  private JLevel(String name, int value) {
    super(name, value);
  }
  
  protected Object readResolve() throws ObjectStreamException {
    if (intValue() == INFO_APP.intValue())
      return INFO_APP; 
    if (intValue() == INFO_FINE.intValue())
      return INFO_FINE; 
    if (intValue() == INFO_FINNER.intValue())
      return INFO_FINNER; 
    if (intValue() == INFO_WS.intValue())
      return INFO_WS; 
    if (intValue() == INFO_BD.intValue())
      return INFO_BD; 
    if (intValue() == INFO_FINNEST.intValue())
      return INFO_FINNEST; 
    if (intValue() == STDOUT.intValue())
      return STDOUT; 
    if (intValue() == STDERR.intValue())
      return STDERR; 
    throw new InvalidObjectException("Unknown instance :" + this);
  }
}
