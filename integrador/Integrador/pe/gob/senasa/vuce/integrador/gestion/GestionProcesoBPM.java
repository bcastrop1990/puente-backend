package pe.gob.senasa.vuce.integrador.gestion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;


import pe.gob.senasa.vuce.integrador.IntegradorConfig;
import pe.gob.senasa.vuce.integrador.bean.ProcesoBPM;
import pe.gob.senasa.vuce.integrador.helper.LogHelper;
import pe.gob.senasa.vuce.integrador.mappers.ColaProcesoBpmMapper;

public class GestionProcesoBPM {
	private static String START_SESSION = "startSession";
	
	public void lanzarProcesoBPM() {
		System.out.println("Inicio de proceso.");
		boolean procesado = true;
		try {
			ColaProcesoBpmMapper map = new ColaProcesoBpmMapper();
			ProcesoBPM proceso = new ProcesoBPM();
			while (procesado) {
				procesado = map.obtenerProcesoBPM(proceso,"0");//Cola de errores
				if (procesado) {
					if (crearInstanciaProceso(proceso)) {
						map.actualizarProcesoInstancia(proceso.getId(), proceso.getInstanciaId());
					} else {
						map.encolarMensajeError(proceso.getId());
						procesado = false;
					}
				}
			}
			procesado = true;
			proceso = new ProcesoBPM();
			while (procesado) {
				procesado = map.obtenerProcesoBPM(proceso,"1");//Cola Normal
				if (procesado) {
					if (crearInstanciaProceso(proceso)) {
						map.actualizarProcesoInstancia(proceso.getId(), proceso.getInstanciaId());
					} else {
						map.encolarMensajeError(proceso.getId());
						//procesado = false;
					}
				}
			}
			LogHelper.info("No hay mensajes pendientes.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Fin de proceso.");
	}
	
	public boolean crearInstanciaProceso(ProcesoBPM servicio)
	{
		try {
			LogHelper.info("Iniciando proceso BPM " + servicio.getBpmProxyMetodo() + " (" + servicio.getBpmProxyClase() + ")");
			LogHelper.info("Servicio: " + servicio.getCodigoServicio() + " | Documento: " + servicio.getNumeroDocumento()+ " | Documento Ref: " + servicio.getNumeroDocumentoRef());
			Class<?> c = Class.forName(servicio.getBpmProxyClase());
			Object proxy = c.newInstance();
			Method createInstance = c.getMethod(servicio.getBpmProxyMetodo(), String.class, String.class, String.class);
			LogHelper.info("MethodCreateInstance: " + createInstance.getName() + " / " + createInstance.isAccessible() + " / " + createInstance.toString());
			createInstance.invoke(proxy, servicio.getCodigoServicio(), servicio.getNumeroDocumento(), servicio.getNumeroDocumentoRef());
			Object instanceID = c.getName() + "#" + new Date().getTime();
			LogHelper.info("Fin proceso BPM " + servicio.getBpmProxyMetodo() + " | Instancia: " + instanceID.toString());
			servicio.setInstanciaId(instanceID.toString());
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}