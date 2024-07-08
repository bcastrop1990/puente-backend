package pe.gob.senasa.vuce.integrador.test;

import pe.gob.senasa.vuce.integrador.main.MainIntegrador;

public class MainEnviarNotificaciones {
	public static void main(String[] args) {
		args = new String[1];
		args[0] = "NOTIFICAR";
		MainIntegrador.main(args);
	}
}
