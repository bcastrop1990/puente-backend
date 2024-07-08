package pe.gob.senasa.vuce.integrador.helper;

import java.io.PrintWriter;
import java.io.StringWriter;

import pe.com.jarch.logger.JLevel;
import pe.com.jarch.logger.JLogger;



public class LogHelper {
    public LogHelper() {
        super();
    }
        
    public static void info(String mensaje) {
    	JLogger.getCurrentLog().log(JLevel.INFO_APP, mensaje);
    }
    
    public static void obtenerLogCompleto(String componente, Exception ex) {
        try {
        	
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            JLogger.getCurrentLog().log(JLevel.SEVERE, componente + " *** ERROR *** " + ex.getMessage() + " |\n| " + errors.toString(), ex);
        } catch (Exception exAny) {
        	JLogger.getCurrentLog().log(JLevel.SEVERE, componente + " *** ERROR *** " + exAny.getMessage() + " |\n| ERROR AL OBTENER LOG COMPLETO", exAny);
        }
    }
}