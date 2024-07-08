package pe.gob.senasa.vuce.integrador.main;

import pe.com.jarch.logger.JLevel;
import pe.com.jarch.logger.JLogger;
import pe.gob.senasa.vuce.integrador.Integrador;

public class MainIntegrador {
	public static void main(String[] args) {
		if (args.length == 1) {
			new Integrador().ejecutarAccion(args[0].toString(), null, null);
		}
		else if (args.length == 2)
		{
			new Integrador().ejecutarAccion(args[0].toString(), args[1].toString(), null);
		}
		else if (args.length == 3)
		{
			new Integrador().ejecutarAccion(args[0].toString(), args[1].toString(), args[2].toString());
		}
		else
		{
			JLogger.getCurrentLog().log(JLevel.SEVERE, "Debe especificar un parametro de ejecucion. (RECEPCIONAR/NOTIFICAR)");
		}
	}
}
