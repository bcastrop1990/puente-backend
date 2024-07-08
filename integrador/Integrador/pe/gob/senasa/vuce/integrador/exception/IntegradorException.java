package pe.gob.senasa.vuce.integrador.exception;

@SuppressWarnings("serial")
public class IntegradorException extends Exception
{
	public static String errorRegistrarMensajeVuce = "Ocurri� un error al Registrar el Mensaje.";
	public static String errorProcesarMensajeVuce = "Ocurri� un error al Procesar el Mensaje.";
	public static String errorInstanciasProcesoBPM = "Ocurri� un error al iniciar la instancia del proceso BPM.";
	public static String errorRegistrarLiquidacionVuce = "Ocurri� un error al Registrar la Liquidaci�n.";
	
	public IntegradorException(String mensaje, Throwable causa)
	{	
		super(mensaje,causa);
	}
	
	public IntegradorException(String mensaje)
	{	
		super(mensaje);
	}
}
