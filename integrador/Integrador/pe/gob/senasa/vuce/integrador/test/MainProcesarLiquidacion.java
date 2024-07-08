package pe.gob.senasa.vuce.integrador.test;

import pe.gob.senasa.vuce.integrador.main.MainIntegrador;

public class MainProcesarLiquidacion {
	public static void main(String[] args) {
		args = new String[1];
		args[0] = "LIQUIDAR_PAGOS";
		MainIntegrador.main(args);
	}
}
