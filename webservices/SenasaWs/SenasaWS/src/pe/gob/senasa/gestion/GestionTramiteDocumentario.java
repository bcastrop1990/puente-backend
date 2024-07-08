package pe.gob.senasa.gestion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.Documento;
import pe.gob.senasa.bean.Propiedad;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.tupa.CreacionDocumentos;


public class GestionTramiteDocumentario {

    protected static Logger logger = Logger.getLogger(GestionTramiteDocumentario.class);
    //private ConectionApp cnApp = null;
    private CreacionDocumentos creacionDocumentos = null;
    private DBHelper helper = null;
    public GestionTramiteDocumentario() {
        super();
        creacionDocumentos = new CreacionDocumentos();
        //cnApp = new ConectionApp();
        helper = new DBHelper(SenasaSQL.dsTramDocu);
    }

    public String generarNumeroDocumento(Connection con, String subTipo, String area, String subArea, String personaId) {
        Connection auxCon = null;
        boolean conexionLocal = false;
        String sql = SenasaSQL.CREAR_DOCUMENTO;
        CallableStatement cstmt = null;
        String rpta = "Error";
        try {
            if (con == null) {
                auxCon = helper.getConnection();
                conexionLocal = true;
            } else
                auxCon = con;

            logger.info("=======Inicio de generarNumeroDocumento en DB ======= ");
            cstmt = auxCon.prepareCall(sql);
            logger.info(" Preparando llamada al SP " + sql);
            logger.info(" subTipo = " + subTipo + " area=  " + area + " subArea=" + subArea + " personaId" + personaId);

            cstmt.registerOutParameter(1, OracleTypes.VARCHAR);
            cstmt.setString(2, subTipo);
            cstmt.setString(3, area);
            cstmt.setString(4, subArea);
            cstmt.setString(5, personaId);

            logger.info(" Ejecutando llamada al SP " + sql);
            cstmt.execute();
            logger.info(" Ejecutó correctamente ");
            rpta = cstmt.getString(1);
            logger.info(" resultado= " + rpta);
        } catch (SQLException e) {
            rpta = "Error SQLException " + e.getMessage();
            logger.info(" SQLException : generarNumeroDocumento en DB", e);
        } catch (Exception e) {
            rpta = "Error Exception " + e.getMessage();
            logger.info(" Exception al generarNumeroDocumento en DB ", e);
        } finally {
            try {
                if (cstmt != null)
                    cstmt.close();
            } catch (SQLException sqe) {
                logger.fatal("Ha ocurrido un error cerrando el statement:" + sqe.getMessage());
            }
            try {
                if (auxCon != null && conexionLocal)
                    auxCon.close();
            } catch (SQLException sqe) {
                logger.fatal("Ha ocurrido un error cerrando cerrando la conexión con la base de datos:" + sqe.getMessage());
            }
        }
        return rpta;
    }

    public Documento generarDocumento(String txId, byte[] documentoFisico, String nombre, Documento documento) {
        Connection conn = null;
        String returnDdocName = null;
        try {
            conn = helper.getConnection();
            conn.setAutoCommit(false);
            String numeroDocumento =
                generarNumeroDocumento(conn, documento.getMemorandum().getSubTipo(), documento.getMemorandum().getAreaDestino(),
                                       documento.getMemorandum().getSubareaDestino(),
                                       documento.getMemorandum().getPersonaDestino());
            if (numeroDocumento.indexOf("Exception") >= 0) {
                documento.setEstado("Error al adjuntar Documento. No se puede generar el número de documento.");
                logger.info("Error al adjuntar Documento. No se puede generar el número de documento.");
                conn.rollback();
            } else {
                documento.getMetadatos().add(new Propiedad("dDocTitle", numeroDocumento));
                documento.getMetadatos().add(new Propiedad("xNumeroDocumentoPrincipal", numeroDocumento));

                // ELIMINAR RESOLUCION JEFATURA y RESOLUCION DIRECTORAL
                //String numeroInternoDoc = numeroDocumento.replace("RESOLUCION JEFATURAL-", "");
                //numeroInternoDoc = numeroInternoDoc.replace("RESOLUCION DIRECTORAL-", "");
                //documento.getMemorandum().setNumeroDocumento(numeroInternoDoc);
                documento.getMemorandum().setNumeroDocumento(numeroDocumento);
                returnDdocName = creacionDocumentos.establecerIngreso(txId, documentoFisico, nombre, documento);
                if (returnDdocName == null) {
                    conn.rollback();
                } else if (returnDdocName.indexOf("0-ERROR") >= 0) {
                    documento.setEstado("Ocurrio un error al generar el documento.");
                    logger.info("Ocurrio un error genéroco al generar el documento.");
                    conn.rollback();
                } else if (returnDdocName.indexOf("1-VISTO") >= 0) {
                    documento.setEstado("Error al adjuntar Documento no se encontraron vistos");
                    logger.info("Error al adjuntar Documento no se encontraron vistos");
                    conn.rollback();
                } else if (returnDdocName.indexOf("2-FIRMA") >= 0) {
                    documento.setEstado("Error al adjuntar Documento no se encontraron firmas");
                    logger.info("Error al adjuntar Documento no se encontraron firmas");
                    conn.rollback();
                    //aqui agregar condicional
                } else if (returnDdocName.indexOf("3 - TAG") >= 0) {
                    documento.setEstado("No se encontro el bpmTagFirmaRemitente");
                    logger.info("No se encontro el bpmTagFirmaRemitente");
                    conn.rollback();
                } else if (returnDdocName.indexOf("4 - TAG") >= 0) {
                    documento.setEstado("No se encontro el bpmTagFechaRegistro");
                    logger.info("No se encontro el bpmTagFechaRegistro");
                    conn.rollback();
                } else if (returnDdocName.indexOf("5 - TAG") >= 0) {
                    documento.setEstado("No se encontro el bpmTagNumeroDocumento");
                    logger.info("No se encontro el bpmTagNumeroDocumento");
                    conn.rollback();
                } else {
                    conn.commit();
                    documento.setUcmId(returnDdocName);
                }
            }
        } catch (SQLException e) {
            returnDdocName = null;
            try {
                if (conn != null)
                    conn.rollback();
            } catch (SQLException er) {
                logger.info(" SQLException : generarDocumento - rollback", e);
                er.printStackTrace();
            }
            logger.info(" SQLException : generarDocumento", e);
        } catch (Exception e) {
            returnDdocName = null;
            try {
                if (conn != null)
                    conn.rollback();
            } catch (SQLException er) {
                logger.info(" SQLException : generarDocumento - rollback", e);
                er.printStackTrace();
            }
            logger.info(" Exception al generarDocumentoB ", e);
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                logger.info(" SQLException : generarDocumento - close", e);
                e.printStackTrace();
            }
        }
        return documento;
    }

}
