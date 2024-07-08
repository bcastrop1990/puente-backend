package pe.gob.senasa.vucews.consumer.test;

//import java.util.List;

import pe.gob.senasa.vucews.consumer.VuceWSConsumer;

public class MainStandAloneTestWS {

	public static void main(String[] args) {
		VuceWSConsumer consumer = new VuceWSConsumer();
		//List<byte[]> archivos = consumer.obtenerTransaccionesPendientes();
		//System.out.println("Obtener Transacciones Pendientes:" + archivos.size());
		//consumer.confirmarRecepcionMensaje(413711);
		//System.out.println("Enviando confirmar Recepcion Mensaje");
		consumer.enviarNotificaciones(new String("abcde").getBytes(),null,null);
		System.out.println("Enviando notificaciones");
	}

}
