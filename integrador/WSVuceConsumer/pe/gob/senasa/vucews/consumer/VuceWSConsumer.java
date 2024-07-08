package pe.gob.senasa.vucews.consumer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataHandler;
import javax.mail.util.ByteArrayDataSource;
import javax.xml.ws.soap.SOAPFaultException;

import pe.com.jarch.logger.JLevel;
import pe.com.jarch.logger.JLogger;
import pe.gob.mincetur.vuce.ve.remoting.ws.entidad.VucentWS;
import pe.gob.mincetur.vuce.ve.remoting.ws.entidad.VucentWSImplService;
import pe.gob.senasa.vucews.security.VuceWsSecurity;

public class VuceWSConsumer {

	/* Agregar en los constructores del VucentWSImplService
	 * la siguiente linea:
	 *    this.setHandlerResolver(new HeaderHandlerResolver());
	 *    
	 * Agregar al inicio de la clase al iniciar la URL
	 * url = pe.gob.mincetur.vuce.ve.remoting.ws.entidad.VucentWSImplService.class.getResource("/META-INF/wsdl/VucentWS.wsdl");
     * if (url == null) throw new MalformedURLException("/META-INF/wsdl/VucentWS.wsdl does not exist in the module.");
	 */
	private VucentWS proxy = null;
	private final int MSJ_ERROR = 1;
	private final int MSJ_CORRECTO = 0;

	public VuceWSConsumer()
	{	
	}
	
	public List<byte[]> obtenerTransaccionesPendientes()
	{
		try
		{
			this.proxy = new VucentWSImplService().getVucentWSImplPort();
			List<byte[]> lstAux = new ArrayList<byte[]>();
			List<DataHandler> lstDh = this.proxy.obtenerTransaccionesPendientes(VuceWsSecurity.getInstance().getIdEntity());
			JLogger.getCurrentLog().log(JLevel.INFO_WS, "Recepción de " + lstDh.size() + " transacciones pendientes con exito.");
			for(DataHandler data : lstDh) {
				lstAux.add(toBytes(data));
			}
			JLogger.getCurrentLog().log(JLevel.INFO_WS, "Recepción de transacciones pendientes con exito.");
			return lstAux;
		}catch(SOAPFaultException ex)
		{
			JLogger.getCurrentLog().log(JLevel.SEVERE, "Error en el WebService VuceEntidad - obtenerTransaccionesPendientes", ex);
			ex.printStackTrace();
			return null;
		} catch (IOException e) {
			JLogger.getCurrentLog().log(JLevel.SEVERE, "Error en el WebService VuceEntidad - obtenerTransaccionesPendientes", e);
			e.printStackTrace();
			return null;
		}catch(Exception ex)
		{
			JLogger.getCurrentLog().log(JLevel.SEVERE, "Error desconocido en el WebService VuceEntidad - obtenerTransaccionesPendientes", ex);
			ex.printStackTrace();
			return null;
		}
	}
	
	public List<byte[]> obtenerTransaccionesPendientes(int limite, List<String> tipoTransacciones)
	{
		try
		{
			this.proxy = new VucentWSImplService().getVucentWSImplPort();
			List<byte[]> lstAux = new ArrayList<byte[]>();
			List<DataHandler> lstDh = this.proxy.obtenerTransaccionesPendientesConLimite(VuceWsSecurity.getInstance().getIdEntity(), tipoTransacciones, limite);
			JLogger.getCurrentLog().log(JLevel.INFO_WS, "Recepción de " + lstDh.size() + " transacciones pendientes con exito.");
			for(DataHandler data : lstDh) {
				lstAux.add(toBytes(data));
			}
			JLogger.getCurrentLog().log(JLevel.INFO_WS, "Recepción de transacciones pendientes (LIMITE = " + limite + ") con exito.");
			return lstAux;
		}catch(SOAPFaultException ex)
		{
			JLogger.getCurrentLog().log(JLevel.SEVERE, "Error en el WebService VuceEntidad - obtenerTransaccionesPendientesConLimite", ex);
			ex.printStackTrace();
			return null;
		} catch (IOException e) {
			JLogger.getCurrentLog().log(JLevel.SEVERE, "Error en el WebService VuceEntidad - obtenerTransaccionesPendientesConLimite", e);
			e.printStackTrace();
			return null;
		}catch(Exception ex)
		{
			JLogger.getCurrentLog().log(JLevel.SEVERE, "Error desconocido en el WebService VuceEntidad - obtenerTransaccionesPendientesConLimite", ex);
			ex.printStackTrace();
			return null;
		}
	}
	
	public boolean confirmarRecepcionMensaje(int idTransaccion)
	{
		try
		{
			this.proxy = new VucentWSImplService().getVucentWSImplPort();
			this.proxy.confirmarRecepcionMensaje(idTransaccion, MSJ_CORRECTO, "");
			JLogger.getCurrentLog().log(JLevel.INFO_WS, "Confirmación de recepción con exito.");
			return true;
		}catch(SOAPFaultException ex)
		{
			JLogger.getCurrentLog().log(JLevel.SEVERE, "Error en el WebService VuceEntidad", ex);
			ex.printStackTrace();
			return false;
		}catch(Exception ex)
		{
			JLogger.getCurrentLog().log(JLevel.SEVERE, "Error desconocido en el WebService VuceEntidad", ex);
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean confirmarRecepcionMensaje(int idTransaccion, String errores)
	{
		try
		{
			this.proxy = new VucentWSImplService().getVucentWSImplPort();
			this.proxy.confirmarRecepcionMensaje(idTransaccion, MSJ_ERROR, errores);
			JLogger.getCurrentLog().log(JLevel.INFO_WS, "Confirmación de recepción con exito.");
			return true;
		}catch(SOAPFaultException ex)
		{
			JLogger.getCurrentLog().log(JLevel.SEVERE, "Error en el WebService VuceEntidad", ex);
			ex.printStackTrace();
			return false;
		}catch(Exception ex)
		{
			JLogger.getCurrentLog().log(JLevel.SEVERE, "Error desconocido en el WebService VuceEntidad", ex);
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean enviarNotificaciones(byte[] xmlNotificacion, byte[] ebXML, byte[] adjuntos)
	{
		try
		{
			this.proxy = new VucentWSImplService().getVucentWSImplPort();
			this.proxy.enviarNotificaciones(toDataHandler(xmlNotificacion),
											toDataHandler(ebXML),
											toDataHandler(adjuntos));
			JLogger.getCurrentLog().log(JLevel.INFO_WS, "Envío de notificacion con exito.");
			return true;
		}catch(SOAPFaultException ex)
		{
			JLogger.getCurrentLog().log(JLevel.SEVERE, "Error en el WebService VuceEntidad", ex);
			ex.printStackTrace();
			return false;
		}catch(Exception ex)
		{
			JLogger.getCurrentLog().log(JLevel.SEVERE, "Error desconocido en el WebService VuceEntidad", ex);
			ex.printStackTrace();
			return false;
		}
	}
	
	public Integer sincronizarTablas(byte[] xmlMensaje, byte[] xmlTablas)
	{
		try
		{
			this.proxy = new VucentWSImplService().getVucentWSImplPort();
			return new Integer(this.proxy.sincronizarTablas(VuceWsSecurity.getInstance().getIdEntity(),toDataHandler(xmlMensaje), toDataHandler(xmlTablas)));
		}catch(SOAPFaultException ex)
		{
			JLogger.getCurrentLog().log(JLevel.SEVERE, "Error en el WebService VuceEntidad", ex);
			ex.printStackTrace();
			return null;
		}catch(Exception ex)
		{
			JLogger.getCurrentLog().log(JLevel.SEVERE, "Error desconocido en el WebService VuceEntidad", ex);
			ex.printStackTrace();
			return null;
		}
	}
	
	public byte[] obtenerResultadoSincronizacionTablas(int idProcesoSincronizacion)
	{
		try
		{
			this.proxy = new VucentWSImplService().getVucentWSImplPort();
			DataHandler dh = this.proxy.obtenerResultadoSincronizacionTablas(VuceWsSecurity.getInstance().getIdEntity(),idProcesoSincronizacion);
			return toBytes(dh);
		}catch(SOAPFaultException ex)
		{
			JLogger.getCurrentLog().log(JLevel.SEVERE, "Error en el WebService VuceEntidad", ex);
			ex.printStackTrace();
			return null;
		} catch (IOException e) {
			JLogger.getCurrentLog().log(JLevel.SEVERE, "Error en el WebService VuceEntidad", e);
			e.printStackTrace();
			return null;
		}catch(Exception ex)
		{
			JLogger.getCurrentLog().log(JLevel.SEVERE, "Error desconocido en el WebService VuceEntidad", ex);
			ex.printStackTrace();
			return null;
		}
	}
	
	public List<byte[]> obtenerLiquidacionPagos()
	{
		try
		{
			this.proxy = new VucentWSImplService().getVucentWSImplPort();
			List<byte[]> lstAux = new ArrayList<byte[]>();
			List<DataHandler> lstDh = this.proxy.obtenerLiquidacionPagos(VuceWsSecurity.getInstance().getIdEntity());
			for(DataHandler data : lstDh) {
				byte[] item = toBytes(data);
				if (item != null)
					lstAux.add(item);
			}
			/*for(DataHandler data : lstDh) {
				lstAux.add((byte[])data.getContent());
			}*/
			return lstAux;
		}catch(SOAPFaultException ex)
		{
			JLogger.getCurrentLog().log(JLevel.SEVERE, "Error en el WebService VuceEntidad", ex);
			ex.printStackTrace();
			return null;
		} catch (IOException e) {
			JLogger.getCurrentLog().log(JLevel.SEVERE, "Error en el WebService VuceEntidad", e);
			e.printStackTrace();
			return null;
		}catch(Exception ex)
		{
			JLogger.getCurrentLog().log(JLevel.SEVERE, "Error desconocido en el WebService VuceEntidad", ex);
			ex.printStackTrace();
			return null;
		}
	}
	
	private byte[] toBytes(DataHandler dh) throws IOException {
	    ByteArrayOutputStream bos = new ByteArrayOutputStream();
	    InputStream in = dh.getInputStream();
	    byte[] buffer = new byte[1024];
	    int bytesRead;
	    while ( (bytesRead = in.read(buffer)) >= 0 ) {
	        bos.write(buffer, 0, bytesRead);
	    }
	    if (bos.toByteArray().length == 0)
	    	return null;
	    else
	    	return bos.toByteArray();
	}
	
	private DataHandler toDataHandler(byte[] data) throws IOException {
		if (data == null) {
			return new DataHandler(null, "application/octet-stream");
		}
		System.out.println("**" + data);
	    InputStream in = new ByteArrayInputStream(data);
	    DataHandler dh = new DataHandler(new ByteArrayDataSource(in,"application/octet-stream"));
	    return dh;
	}
}
