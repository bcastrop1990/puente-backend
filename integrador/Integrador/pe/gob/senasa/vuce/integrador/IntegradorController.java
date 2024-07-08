package pe.gob.senasa.vuce.integrador;

import java.sql.Connection;

import pe.gob.senasa.vuce.integrador.exception.IntegradorException;
import pe.gob.senasa.vuce.integrador.bean.LiquidacionVUCE;
import pe.gob.senasa.vuce.integrador.bean.MensajeVUCE;
import pe.gob.senasa.vuce.integrador.mappers.AdjuntoTransaccionMapper;
import pe.gob.senasa.vuce.integrador.mappers.BaseDao;
import pe.gob.senasa.vuce.integrador.mappers.LiquidacionMapper;
import pe.gob.senasa.vuce.integrador.mappers.OperationResult;
import pe.gob.senasa.vuce.integrador.mappers.TransaccionMapper;

public class IntegradorController {

	public IntegradorController() {
		DBConfiguration.getInstance().setUserName("Integrador");
	}

	public void registrarMensajeVuce(MensajeVUCE mensaje) throws IntegradorException {
		BaseDao helper = new BaseDao();
		TransaccionMapper mapper = new TransaccionMapper();
		AdjuntoTransaccionMapper adjMapper = new AdjuntoTransaccionMapper();
		Connection conn = null;
		Connection connProc = null;
		try {
			conn = helper.getConnection();
			//mapper.spRegistrar(conn, mensaje.getTransaccion());
			mapper.spRegistrarConXML(conn, mensaje);
			mensaje.setIdDocumentoOnElements();
			if (mensaje.hasEbXML())
				mapper.spInsertEbxml(conn, mensaje);
			if (mensaje.hasAdjuntos())
				adjMapper.spInsert(conn, mensaje.getAdjuntos());
			helper.commit(conn);
			try {
				connProc = helper.getConnection();
				mapper.fnProcesar(connProc, mensaje.getTransaccion());
				helper.commit(connProc);
			} catch (Exception ex) {
				helper.rollback(connProc);
				throw new IntegradorException(IntegradorException.errorProcesarMensajeVuce, ex.getCause());
			} finally {
				helper.close(connProc);
			}
		} catch (Exception ex) {
			helper.rollback(conn);
			throw new IntegradorException(IntegradorException.errorRegistrarMensajeVuce, ex.getCause());
		} finally {
			helper.close(conn);
		}
		
	}

	public OperationResult registrarLiquidacionVuce(LiquidacionVUCE liquidacion) throws IntegradorException {
		try {
			try {
				OperationResult result = new LiquidacionMapper().spGuardarLiquidacion(liquidacion);
				return result;
			} catch (Exception ex) {
				throw new IntegradorException(IntegradorException.errorRegistrarLiquidacionVuce, ex.getCause());
			}
		} catch (Exception ex) {
			throw new IntegradorException(IntegradorException.errorRegistrarLiquidacionVuce, ex.getCause());
		}
	}
}
