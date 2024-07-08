package pe.gob.senasa.vuce.integrador;

import java.util.Arrays;
import java.util.List;

import pe.com.jarch.logger.JLevel;
import pe.com.jarch.logger.JLogger;
import pe.gob.senasa.vuce.integrador.gestion.GestionBase;
import pe.gob.senasa.vuce.integrador.gestion.GestionEnviarMensaje;
import pe.gob.senasa.vuce.integrador.gestion.GestionLiquidacionPagosVUCE;
import pe.gob.senasa.vuce.integrador.gestion.GestionProcesoBPM;
import pe.gob.senasa.vuce.integrador.gestion.GestionRecepcionarMensaje;
import pe.gob.senasa.vuce.integrador.gestion.GestionSincronizacionTablas;

public class Integrador {

	public void ejecutarAccion(String accion, String param2, String param3) {
		System.out.println("Inicio de proceso.");
		if (accion.equalsIgnoreCase("CONFIRMAR"))
		{
			JLogger.initialize("Confirmar");
			if (param2 != null && !param2.trim().isEmpty()) {
				new GestionBase().confirmar(new Integer(param2).intValue(), null);
			}
		}
		else if (accion.equalsIgnoreCase("RECEPCIONAR"))
		{
			JLogger.initialize("Recepcionar");
			new GestionRecepcionarMensaje().recepcionar();
		}
		else if (accion.equalsIgnoreCase("RECEPCIONAR_LIMITE"))
		{
			if (param2 != null && !param2.trim().isEmpty()) {
				List<String> tipos = null; 
				if (param3 != null && !param3.trim().isEmpty()) {
					if (param3.equals("NULL"))
						tipos = null;
					else
						tipos = Arrays.asList(param3.split("\\s*,\\s*"));
					
					JLogger.initialize("RecepcionarLimite_" + param3.replace(",",""));
					new GestionRecepcionarMensaje().recepcionar(new Integer(param2).intValue(), tipos);
				}	
			}	
		}
		else if (accion.equalsIgnoreCase("NOTIFICAR"))
		{
			JLogger.initialize("Notificar");
			new GestionEnviarMensaje().enviarMensajesCola(null);
		}
		else if (accion.equalsIgnoreCase("NOTIFICAR_CANAL"))
		{
			if (param2 != null && !param2.trim().isEmpty()) {
				if (param2.equals("01")) {
					param2 = null;
					JLogger.initialize("NotificarCanal_01");
					new GestionEnviarMensaje().enviarMensajesCola(null);
				}else{
					JLogger.initialize("NotificarCanal_" + param2);
					new GestionEnviarMensaje().enviarMensajesCola(param2);
				}
			}
		}
		else if (accion.equalsIgnoreCase("LIQUIDAR_PAGOS"))
		{
			JLogger.initialize("LiquidarPagos");
			JLogger.getCurrentLog().log(JLevel.INFO_APP, "PROCESO: Liquidacion de Pagos VUCE");
			new GestionLiquidacionPagosVUCE().procesarLiquidacion();
		}
		else if (accion.equalsIgnoreCase("SINCRONIZAR_TABLAS"))
		{
			JLogger.initialize("SincronizarTablas");
			new GestionSincronizacionTablas().Sincronizar();
		}
		else if (accion.equalsIgnoreCase("OBTENER_LOG_SINCRONIZACION"))
		{
			JLogger.initialize("ObtenerLogSincronizacion");
			new GestionSincronizacionTablas().ObtenerResultado();
		}
		else if (accion.equalsIgnoreCase("INSTANCIAR_PROCESOS_BPM"))
		{
			JLogger.initialize("InstanciarProcesosBPM");
			new GestionProcesoBPM().lanzarProcesoBPM();			
		}
		else if (accion.equalsIgnoreCase("OBTENER_ZIP"))
		{
			//JLogger.initialize("LanzarProcesosBPM");
			//new GestionProcesoBPM().lanzarProcesoBPM();			
		}
		else
		{
			JLogger.getCurrentLog().log(JLevel.SEVERE, "Debe especificar un parametro de ejecucion. (RECEPCIONAR/NOTIFICAR)");
		}
		System.out.println("Fin de proceso.");
	}	
}