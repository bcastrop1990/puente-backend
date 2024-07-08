package pe.gob.senasa.vuce.integrador.helper;

import java.io.StringReader;
import java.io.StringWriter;

import org.apache.commons.digester.Digester;

import pe.gob.senasa.vuce.integrador.bean.DocumentoVuce;
import pe.gob.senasa.vuce.integrador.bean.MensajeVUCE;
import pe.gob.senasa.vuce.integrador.bean.SincResultadoErrorVUCE;
import pe.gob.senasa.vuce.integrador.bean.SincResultadoVUCE;
import pe.gob.senasa.vuce.integrador.bean.SincronizacionVUCE;
import pe.gob.senasa.vuce.integrador.bean.TransaccionVuce;
import pe.gob.senasa.vuce.integrador.exception.IntegradorException;

public class XmlHelper {
	private DigesterMensajesVUCE digester;
	public XmlHelper() {
		digester = new DigesterMensajesVUCE();
	}
	
	public void parseXmlTransaccionVuce(MensajeVUCE mensaje) throws IntegradorException {
		TransaccionVuce transac = null;
		try {
			StringWriter sw = new StringWriter();
			sw.write(mensaje.getXmlTransaccion());
			StringReader sr = new StringReader(sw.toString().trim());
			try {
				transac = (TransaccionVuce)digester.prepareDigesterTransaccionVuce().parse(sr);
				if (transac == null) {
					System.out.println("----------------------------------------------------------------");
					StringReader sr2 = new StringReader(sw.toString().trim());
					transac = (TransaccionVuce)digester.prepareDigesterTransaccionVuceAcuerdo().parse(sr2);
				}
			} catch (Exception exc) {
				System.out.println("----------------------------------------------------------------");
				exc.printStackTrace();				
				throw new IntegradorException("Error al interpretar la Transacción VUCE", exc.getCause());
			}
			System.out.println(transac.showInfo());
			mensaje.setTransaccion(transac);
			
		} catch (Exception exc) {
			System.out.println("----------------------------------------------------------------");
			exc.printStackTrace();
			throw new IntegradorException("Error al interpretar la Transacción VUCE", exc.getCause());
		}
	}
	
	public void parseXmlResultadoSincronizacionTablas(SincronizacionVUCE mensaje) throws IntegradorException {
		SincResultadoVUCE resultado = null;
		try {
			StringWriter sw = new StringWriter();
			sw.write(new String(mensaje.getResultado()));
			StringReader sr = new StringReader(sw.toString().trim());
			resultado = (SincResultadoVUCE)digester.prepareDigesterResultadoSincronizacionTablas().parse(sr);
			System.out.println(resultado.showInfo());
			mensaje.setResultadoSinc(resultado);
		} catch (Exception exc) {
			throw new IntegradorException("Error al interpretar el Resultado de Sincronización de Tablas", exc.getCause());
		}
	}
	
	public class DigesterMensajesVUCE {
		
		public Digester prepareDigesterTransaccionVuce()
		{
			Digester digester = new Digester();
			digester.setValidating(false);
			digester.addObjectCreate("transaccion", TransaccionVuce.class);
			digester.addBeanPropertySetter("transaccion/idTransmision", "idTransaccion");
			digester.addBeanPropertySetter("transaccion/tipoMensaje", "tipoMensaje");
			digester.addBeanPropertySetter("transaccion/formato", "formato");

			digester.addObjectCreate("transaccion/documento", DocumentoVuce.class);
			digester.addBeanPropertySetter("transaccion/documento/tipo", "tipo");
			digester.addBeanPropertySetter("transaccion/documento/numero", "numero");
			digester.addBeanPropertySetter("transaccion/documento/monto", "monto");
			digester.addBeanPropertySetter("transaccion/documento/fecha", "fecha");
			digester.addSetNext( "transaccion/documento", "addDocumento" );
			 
			digester.addObjectCreate("transaccion/documentoReferencia", DocumentoVuce.class);
			digester.addBeanPropertySetter("transaccion/documentoReferencia/tipo", "tipo");
			digester.addBeanPropertySetter("transaccion/documentoReferencia/numero", "numero");
			digester.addSetNext( "transaccion/documentoReferencia", "addDocumentoReferencia" );
			return digester;
		}
		
		public Digester prepareDigesterTransaccionVuceAcuerdo()
		{
			Digester digester = new Digester();
			digester.setValidating(false);
			digester.addObjectCreate("transaccionAcuerdo", TransaccionVuce.class);
			digester.addBeanPropertySetter("transaccionAcuerdo/idTransmision", "idTransaccion");
			digester.addBeanPropertySetter("transaccionAcuerdo/tipoMensaje", "tipoMensaje");
			digester.addBeanPropertySetter("transaccionAcuerdo/formato", "formato");

			digester.addObjectCreate("transaccionAcuerdo/documento", DocumentoVuce.class);
			digester.addBeanPropertySetter("transaccionAcuerdo/documento/tipo", "tipo");
			digester.addBeanPropertySetter("transaccionAcuerdo/documento/numero", "numero");
			digester.addBeanPropertySetter("transaccionAcuerdo/documento/monto", "monto");
			digester.addBeanPropertySetter("transaccionAcuerdo/documento/fecha", "fecha");
			digester.addSetNext( "transaccionAcuerdo/documento", "addDocumento" );
			 
			digester.addObjectCreate("transaccionAcuerdo/documentoReferencia", DocumentoVuce.class);
			digester.addBeanPropertySetter("transaccionAcuerdo/documentoReferencia/tipo", "tipo");
			digester.addBeanPropertySetter("transaccionAcuerdo/documentoReferencia/numero", "numero");
			digester.addSetNext( "transaccionAcuerdo/documentoReferencia", "addDocumentoReferencia" );
			return digester;
		}
		
		public Digester prepareDigesterResultadoSincronizacionTablas()
		{
			Digester digester = new Digester();
			digester.setValidating(false);
			digester.addObjectCreate("resultadoSincronizacion", SincResultadoVUCE.class);
			digester.addBeanPropertySetter("resultadoSincronizacion/resultado", "resultado");
			digester.addBeanPropertySetter("resultadoSincronizacion/fecha", "fecha");
			
			digester.addObjectCreate("resultadoSincronizacion/error", SincResultadoErrorVUCE.class);
			digester.addBeanPropertySetter("resultadoSincronizacion/error/tabla", "tabla");
			digester.addBeanPropertySetter("resultadoSincronizacion/error/descripcion", "descripcion");
			digester.addSetNext("resultadoSincronizacion/error", "addError" );
			return digester;
		}
	}
}
