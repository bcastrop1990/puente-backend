package pe.gob.senasa.vuce.integrador.exception;

@SuppressWarnings("serial")
public class IntegradorException extends Exception
{
	public static String errorRegistrarMensajeVuce = "Ocurrió un error al Registrar el Mensaje.";
	public static String errorProcesarMensajeVuce = "Ocurrió un error al Procesar el Mensaje.";
	public static String errorInstanciasProcesoBPM = "Ocurrió un error al iniciar la instancia del proceso BPM.";
	public static String errorRegistrarLiquidacionVuce = "Ocurrió un error al Registrar la Liquidación.";
	
	public IntegradorException(String mensaje, Throwable causa)
	{	
		super(mensaje,causa);
	}
	
	public IntegradorException(String mensaje)
	{	
		super(mensaje);
	}
}
