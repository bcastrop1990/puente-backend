package pe.gob.senasa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import pe.gob.senasa.bean.std.DocumentoSTD;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.interfaces.DocumentoStdInterface;


public class DocumentoStdDAO extends BaseDAO implements DocumentoStdInterface {
    
    private DBHelper helper;
    public DocumentoStdDAO() {
        super();
        helper = new DBHelper(SenasaSQL.dsDocumentos);
    }

    private void Log(String s) {
        logger.debug(s);
    }

    private void Log(String s, java.lang.Throwable p2) {
        logger.fatal("GENERAL - " + s, p2);
    }

    public DocumentoSTD grabarDocumentoStdHijo(DocumentoSTD docStd) {

        String sql = SenasaSQL.GRABAR_DOCUMENTO_STD_HIJO;
        logger.debug("Iniciando DocumentoStdDAO.grabarDocumentoStdHijo()");
        Log(SenasaSQL.GRABAR_DOCUMENTO_STD_HIJO);

        Connection con = null;
        PreparedStatement ps = null;
        CallableStatement cs = null;

        try {
            con = helper.getConnection();
            cs = con.prepareCall(sql);
            cs.setString(1, docStd.getCodigoDocPadre());
            cs.setString(2, docStd.getTipo_doc());
            cs.setString(3, docStd.getAutorId());
            cs.setString(4, docStd.getConfidencial());
            cs.setString(5, docStd.getUcmId());
            cs.setString(6, docStd.getArchivoFolio());
            cs.setString(7, docStd.getIndicadorObligatorio());
            cs.setString(8, docStd.getEstado());
            cs.registerOutParameter(9, Types.VARCHAR);
            cs.registerOutParameter(10, Types.VARCHAR);
            cs.setString(11, docStd.getNombre());
            Log(" = ANTES DE EJECUTAR = ");
            cs.execute();
            Log(" = YA EJECUTE = ");
            docStd.setNombre(cs.getString(9));
            docStd.setCodigo(cs.getString(10));
            logger.debug("grabarDocumentoStdHijo() Obteniendo DocumentoStd: codigoStd = " +
                         docStd.getCodigo() + ", nombreStd = " +
                         docStd.getNombre());
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("grabarDocumentoStdHijo", e);
        } catch (Exception e) {
            Log("grabarDocumentoStdHijo", e);
        } finally {
            cleanup(con, cs, null);
        }
        return docStd;
    }

    public String ObtenerCodDocumentoStdPadre(String codigoExpediente) {
        String sql = SenasaSQL.OBTENER_COD_DOCUMENTO_STD_PADRE;
        logger.debug("Iniciando DocumentoStdDAO.ObtenerCodDocumentoStdPadre()");
        Log(SenasaSQL.OBTENER_COD_DOCUMENTO_STD_PADRE);

        Connection con = null;
        PreparedStatement ps = null;
        CallableStatement cs = null;
        String codigoStdDoc = null;
        try {
            con = helper.getConnection();
            cs = con.prepareCall(sql);
            cs.setString(1, codigoExpediente);
            cs.registerOutParameter(2, Types.VARCHAR);
            Log(" = ANTES DE EJECUTAR = ");
            cs.execute();
            Log(" = YA EJECUTE = ");
            codigoStdDoc = cs.getString(2);
            logger.debug("ObtenerCodDocumentoStdPadre() Obteniendo DocumentoStd: codigoStdPadre = " +
                         codigoStdDoc);
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("ObtenerCodDocumentoStdPadre", e);
        } catch (Exception e) {
            Log("ObtenerCodDocumentoStdPadre", e);
        } finally {
            cleanup(con, cs, null);
        }
        return codigoStdDoc;
    }
}
