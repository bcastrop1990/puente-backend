package pe.gob.senasa.vuce.integrador.mappers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Hashtable;
import java.util.List;

import oracle.jdbc.OracleTypes;
import oracle.sql.BLOB;

import com.stellent.cis.client.command.CommandException;

import pe.gob.senasa.vuce.integrador.bean.AdjuntoVuce;
import pe.gob.senasa.vuce.integrador.helper.ByteHelper;
import pe.gob.senasa.vuce.integrador.helper.LogHelper;
import pe.gob.senasa.ucm.*;

public class AdjuntoTransaccionMapper {

	public static final String INSERTAR_ADJUNTO = "{ call VUCE.PCKG_TAB_ADJUNTO.SP_INSERT(?,?,?,?,?,?,?) }";

	public void spInsert(Connection conn, List<AdjuntoVuce> adjuntos) throws Exception {
		String log = "spInsert";
		for (AdjuntoVuce adjunto : adjuntos) {
			CallableStatement cs = null;
			try {
				cs = conn.prepareCall(INSERTAR_ADJUNTO);
				cs.registerOutParameter(1, OracleTypes.NUMBER);
				cs.setDouble(2, adjunto.getIdDocumento());
				cs.setString(3, adjunto.getRequisito());
				cs.setString(4, adjunto.getNombre());
				cs.setString(5, adjunto.getExtension());
				cs.setBlob(6, BaseDao.bytesToBlob(conn, adjunto.getArchivo()));
				cs.setString(7, null);
				cs.execute();
				adjunto.setIdAdjunto(cs.getDouble(1));
			} catch (Exception ex) {
				LogHelper.obtenerLogCompleto(log, ex);
				throw ex;
			}
		}
	}

	public void spRegistrarAdjuntoUCM(List<AdjuntoVuce> adjuntos) throws Exception {
		String log = "spRegistrarAdjuntoUCM";
		BaseDao dao = new BaseDao();
		Connection conn = null;
		LogHelper.info("GUARDANDO ADJUNTOS EN UCM: TOTAL " + adjuntos.size() + "ADJUNTOS");
		try {
			for (AdjuntoVuce adjunto : adjuntos) {
				String dDocname = null;
				int dotFile = adjunto.getNombre().lastIndexOf(".");
				String extension = (dotFile > 0 ? adjunto.getNombre().substring(dotFile) : "");
				String titulo = (dotFile > 0 ? adjunto.getNombre().replace(extension, "") : adjunto.getNombre());
				titulo = (titulo.length() > 70 ? titulo.substring(0, 70) : titulo);
				LogHelper.info("GUARDANDO EN UCM: " + adjunto.getIdAdjunto() + " / " + titulo + extension);
				Hashtable<String, String> metadatos = new Hashtable<String, String>();
				metadatos.put("xProfileTrigger", "TUPA-OTRS");
				
				boolean correcto = false;
				int intento = 0;
				while (!correcto && intento < 5) {
					intento++;
					try {
						LogHelper.info("GUARDANDO EN UCM: INTENTO " + intento + ": " + adjunto.getIdAdjunto() + " / " + titulo + extension);
						byte[] archivo;
						if (new File(new String(adjunto.getArchivo())).exists()) {
							LogHelper.info("GUARDANDO EN UCM: ARCHIVO RUTA " + new String(adjunto.getArchivo()));
							archivo = ByteHelper.readFile(new String(adjunto.getArchivo()));
						}
						else {
							LogHelper.info("GUARDANDO EN UCM: ARCHIVO " + adjunto.getArchivo().length);
							archivo = adjunto.getArchivo();
						}
						dDocname = ClienteUCM.getInstance().registrarDocumento(null, titulo, "INTEGRADOR", "OTRS",
								"Interno", "STD", metadatos, titulo + extension, archivo);
						LogHelper.info("GUARDANDO EN UCM: INTENTO " + intento + ": " + adjunto.getIdAdjunto() + " / " + dDocname);
						correcto = true;
					} catch (MalformedURLException e1) {
						correcto = false;
						LogHelper.obtenerLogCompleto("Error al registrar adjunto en UCM de VUCE",e1);
					} catch (CommandException e1) {
						correcto = false;
						LogHelper.obtenerLogCompleto("Error al registrar adjunto en UCM de VUCE",e1);
					} catch (IOException e1) {
						correcto = false;
						LogHelper.obtenerLogCompleto("Error al registrar adjunto en UCM de VUCE",e1);
					}
				}
				CallableStatement cs = null;
				try {
					LogHelper.info("GUARDANDO EN UCM: INICIO ACTUALIZACION BD : " + adjunto.getIdAdjunto());
					conn = dao.getConnection();
					cs = conn.prepareCall(INSERTAR_ADJUNTO);
					cs.setDouble(1, adjunto.getIdAdjunto());
					cs.setDouble(2, new Double(0));
					cs.setString(3, null);
					cs.setString(4, null);
					cs.setString(5, null);
					cs.setBlob(6, BLOB.createTemporary(conn, true, BLOB.DURATION_SESSION));
					cs.setString(7, dDocname);
					cs.execute();
					dao.commit(conn);
					LogHelper.info("GUARDANDO EN UCM: FIN ACTUALIZACION BD : " + adjunto.getIdAdjunto() + " / UCM_ID=" + dDocname);
				} catch (Exception ex) {
					LogHelper.obtenerLogCompleto("Error al actualizar ucmId del adjunto de VUCE - " + log, ex);
					dao.rollback(conn);
					throw ex;
				} finally {
					dao.close(conn);
					conn = null;
				}
			}
		} catch (Exception ex) {
			LogHelper.obtenerLogCompleto(log, ex);
			throw ex;
		}
	}
}