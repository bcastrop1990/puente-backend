package pe.gob.senasa.vuce.integrador.gestion;

import java.io.File;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import pe.gob.senasa.vuce.integrador.ExtractorBase;
import pe.gob.senasa.vuce.integrador.IntegradorController;
import pe.gob.senasa.vuce.integrador.bean.LiquidacionVUCE;
import pe.gob.senasa.vuce.integrador.exception.IntegradorException;
import pe.gob.senasa.vuce.integrador.helper.ByteHelper;
import pe.gob.senasa.vuce.integrador.helper.ZipHelper;

public class GestionLiquidacionPagosVUCE extends GestionBase {

	private IntegradorController controller = null;
	private ExtractorBase extractor = null;
	private final String nombreDetalleLiq = "PAGVUCE";//"detalle";
	private final String nombreResumenLiq = "PAGVUCERES";//"resumen";
	
	public GestionLiquidacionPagosVUCE()
	{
		this.controller = new IntegradorController();
		this.extractor = new ExtractorBase();
		this.extractor.setShowOuput(true);
	}
	
	public void procesarLiquidacion() {
		System.out.println("Inicio de proceso.");
		List<byte[]> liquidacionPagos = getVuceWSConsumer().obtenerLiquidacionPagos();
		procesar(liquidacionPagos);
		System.out.println("Fin de proceso.");
	}
	
	public void procesar(List<byte[]> archivosLiquidacionPagos) {
		if (archivosLiquidacionPagos != null)
		{
			System.out.println("Procesando " + archivosLiquidacionPagos.size() + " mensajes de Liquidación de pagos VUCE.");
			try {
				extractor.setInfoArchivosZip(ByteHelper.saveTempListFile(archivosLiquidacionPagos));
				for (String infoArchivoZip : extractor.getInfoArchivosZip()) {
					LiquidacionVUCE mensaje = ObtenerLiquidacionDesdeZip(infoArchivoZip);
					mensaje.showInfoObject();
					switch (controller.registrarLiquidacionVuce(mensaje))
					{
						case Success:
							confirmar(mensaje.getIdTransmision().intValue(), null);
							extractor.EliminarArchivo(infoArchivoZip);
						break;
						case Failure:
							confirmar(mensaje.getIdTransmision().intValue(), mensaje.getError());
						break;
						case PckgError:
							System.err.println(mensaje.getError());
							throw new Exception(mensaje.getError());
					}
				}
				extractor.EliminarCarpetaTemporal();
			} catch (IntegradorException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Termino de procesar mensajes de Liquidación.");
		}
	}
	
	private LiquidacionVUCE ObtenerLiquidacionDesdeZip(String infoArchivoZip) throws IntegradorException {
		if (infoArchivoZip != null) {
			try {
				LiquidacionVUCE mensaje = new LiquidacionVUCE();
				ZipFile zip = new ZipFile(new File(infoArchivoZip));
				System.out.println("Descomprimiendo " + zip.size() + " archivos del ZIP: " + infoArchivoZip);
				String infoZipEntry = "";
				
				for (Enumeration<? extends ZipEntry> e = zip.entries(); e.hasMoreElements();) {
					ZipEntry entry = (ZipEntry) e.nextElement();
					infoZipEntry = entry.getName() + "; size: " + entry.getSize() + "; compressed size: " + entry.getCompressedSize();

					if (entry.getName().toLowerCase().startsWith(nombreResumenLiq.toLowerCase())) {
						System.out.println("-->Descomprimiendo RESUMEN..." + infoZipEntry);
						mensaje.setResumenFileName(entry.getName());
						mensaje.setResumen(ZipHelper.UnzipToByteArray(zip, entry));
					} else if (entry.getName().toLowerCase().startsWith(nombreDetalleLiq.toLowerCase()))  {
						System.out.println("-->Descomprimiendo DETALLE..." + infoZipEntry);
						mensaje.setDetalleFileName(entry.getName());
						mensaje.setDetalle(ZipHelper.UnzipToByteArray(zip, entry));
					}
				}
				zip.close();
				return mensaje;
			} catch (Exception e) {
				e.printStackTrace();
				throw new IntegradorException("Error al descomprimir archivo.");
			}
		} else
			throw new IntegradorException("Error al descomprimir archivo de transaccion. No se ha especificado el nombre del archivo.");
	}
}