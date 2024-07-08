package pe.gob.senasa.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import org.apache.log4j.Logger;


public class Utility {
    
    protected static Logger logger = Logger.getLogger(Utility.class);

    
    public static void printResultSet(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        
        int count = md.getColumnCount();
        println("<table border=1>");
        print("<tr>");
        for (int i = 1; i <= count; i++) {
            print("<th>");
            print(md.getColumnTypeName(i) + "");
        }
        println("</tr>");
        while (rs.next()) {
            print("<tr>");
            for (int i = 1; i <= count; i++) {
                print("<td>");
                print(rs.getString(i));
            }
            println("</tr>");
        }
        println("</table>");

    }

    private static void println(String s) {
        System.out.println(s);
    }

    private static void print(String s) {
        System.out.print(s);
    }

    public static double TryParseDouble(String s) {
        double d = 0.0;
        try {
            d = Double.parseDouble(s);
        } catch (Exception e) {
            d = 0.0;
        }
        return d;
    }

    public static int TryParseInteger(String s) {
        int d = 0;
        try {
            d = Integer.parseInt(s);
        } catch (Exception e) {
            d = 0;
        }
        return d;
    }

    public static java.sql.Date toSQLDate(Date utilDate) {
      java.sql.Date sqlDate =null; 
        if (utilDate!=null){
          sqlDate = new java.sql.Date(utilDate.getTime());    
        }
        
        return sqlDate;
    }
    
    public static Date toUtilDate(java.sql.Date sqlDate) {
        if(sqlDate==null) return null;
        Date utilDate = new Date(sqlDate.getTime());
        return utilDate;
    }
    
    public  static String validateString(Object valor){
            String valorElements = String.valueOf(valor);
            return (valorElements.compareTo("null")==0?"":(String)valor);
    }
    
    public static double validateDouble(Object valor){
            String valorElements = String.valueOf(valor);
            return (valorElements.compareTo("null")==0?null:new Double (valorElements));
    }
    
    public static byte[] BlobToByteArray(Blob blob){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        
        InputStream in=null;
            try {
            in = blob.getBinaryStream();
        } catch (SQLException e) {
                Log("Ocurrio un problema obteniedo el Blob");
        }
        int n = 0;
        try {
            while ((n=in.read(buf))>=0){
           baos.write(buf, 0, n);
        }
        } catch (IOException e) {
            Log("Ocurrio un problema leyend el Blob");
        }
        try {
            in.close();
        } catch (IOException e) {
            Log("Ocurrio un problema cerrando el InputStream el Blob");
        }
        return baos.toByteArray();     
    }
    
    private static void Log(String s) {
        logger.debug(s);
    }

    private static void Log(String s, java.lang.Throwable p2) {
        logger.fatal("Utility - " + s, p2);
    }
    
    
    public static String parseDateToString(Date fech){
      if(fech== null) return null;  
        
      String fecha = null;
      
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
      
      fecha = sdf.format(fech);
      
      return fecha;
    }
    
  public static String parseOnlyDateToString(Date fech){
    if(fech== null) return null;  
      
    String fecha = null;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    fecha = sdf.format(fech);
    
    return fecha;
  }
    
    
  public static java.sql.Date parseStringToDate(String fech)
  {
      
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    java.sql.Date sqlDate = null;
    
    try {
            sqlDate = new java.sql.Date(sdf.parse(fech).getTime());
    } catch (ParseException e) {
        logger.fatal("parseStringToDate",e);
    }
    
    return sqlDate;
  }
  
  public static java.sql.Timestamp parseStringToTimeStamp(String fech)
  {
    String _format;
    
    if(fech.trim().length()>10)
      _format = "dd/MM/yyyy HH:mm:ss";
    else
      _format = "dd/MM/yyyy";  
    
    SimpleDateFormat sdf = new SimpleDateFormat(_format);
    
    java.sql.Timestamp sqlDate = null;
    
    try {
            sqlDate = new java.sql.Timestamp(sdf.parse(fech).getTime());
    } catch (ParseException e) {
        logger.fatal("parseStringToDate",e);
    }
    
    return sqlDate;
  }

  
   public static String remplazoNull(String valor)
  {
      if(valor!=null && !valor.equals("null"))
      {
          return valor;
      }
      else{
          return " ";
      }
      
  }
    
}
