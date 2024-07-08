package pe.gob.senasa.ws.documentoStd.gestion;

import java.sql.Connection;
import java.sql.SQLException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.helper.FileHelper;
import pe.gob.senasa.helper.MsExcelHelper;
import pe.gob.senasa.helper.MsWordHelper;
import pe.gob.senasa.helper.UcmHelper;
import pe.gob.senasa.helper.bean.Auditoria;
import pe.gob.senasa.ws.documentoStd.bean.DocumentoStd;
import pe.gob.senasa.ws.documentoStd.bean.ReporteItem;
import pe.gob.senasa.ws.documentoStd.dao.DocumentoStdDAO;
import pe.gob.senasa.ws.documentoStd.sql.SQLHelper;

public class GestionDocumentoStd {
    protected static Logger logger =
        Logger.getLogger(GestionDocumentoStd.class);
    private UcmHelper ucmHelper = null;
    private DBHelper dbHelper = null;

    public GestionDocumentoStd() {
        super();
        ucmHelper = new UcmHelper();
        dbHelper = new DBHelper(SQLHelper.DATA_SOURCE_SENASA);
    }

    private void validarTag(String txId, MsWordHelper msreplace, String tag,
                            String valor, boolean validarLongitud) {
        logger.info(txId + " Reemplazando " + tag + ": " + valor);
        if (valor != null) {
            if (validarLongitud && valor.length() > 250) {
                //msreplace.replaceTextByText(tag,"El valor es demasiado largo para reemplazar el tag.");
                logger.info(txId +"El valor es demasiado largo para reemplazar el tag. Se cortara a 250");
                msreplace.replaceTextByText(tag , valor.substring(0, 250));
            } else {
                msreplace.replaceTextByText(tag, valor);
            }
        } else {
            msreplace.replaceTextByText(tag, "");
        }
    }

    public DocumentoStd obtenerPlantilla(String txId, String nombrePlantilla,
                                         DocumentoStd documento) {
        logger.debug(txId +
                     "------------------ Inicio de  obtenerPlantilla ----------------");
        logger.debug(txId + "nombrePlantilla: '" + nombrePlantilla + "'");
        String nombreArchivo =
            ucmHelper.obtenerPlantilla(txId, nombrePlantilla);
        documento.setAuditoria(new Auditoria());
        if (nombreArchivo != null && !nombreArchivo.isEmpty()) {
            nombreArchivo = FileHelper.PATH_FILES + nombreArchivo;
            MsWordHelper msreplace = null;
            boolean status = false;
            try {
                logger.info(txId + "ejecutarMemorandum abrir archivo  " +
                            nombreArchivo);
                msreplace = new MsWordHelper();
                msreplace.open(nombreArchivo);
                validarTag(txId, msreplace, "bpmTagPersonaDestino",
                           documento.getPersonaDestino(), true);
                validarTag(txId, msreplace, "bpmTagSubareaDestino",
                           documento.getSubareaDestino(), true);
                validarTag(txId, msreplace, "bpmTagAreaDestino",
                           documento.getAreaDestino(), true);
                validarTag(txId, msreplace, "bpmTagReferencia",
                           documento.getReferencia(), true);
                validarTag(txId, msreplace, "bpmTagAsunto",
                           documento.getAsunto(), false);
                status = true;
            } catch (Exception e) {
                logger.error(txId + "ejecutarMemorandum Error==>  " +
                             e.getMessage());
                e.printStackTrace();
                documento.getAuditoria().setMensajeUsuario("Ocurri� un error al obtener la plantilla documental.");
                documento.getAuditoria().setEstado(false);
            } finally {
                if (msreplace != null) {
                    msreplace.close(nombreArchivo);
                }
            }
            if (status)
                documento.setArchivo(FileHelper.leerArchivo(nombreArchivo));
            FileHelper.eliminarArchivo(nombreArchivo);
        }
        return documento;
    }

    public DocumentoStd previsualizar(String txId, byte[] documentoFisico,
                                      String nombre, DocumentoStd documento) {
        logger.info("======= Inicio de previsualizarIngreso ======= ");
        logger.info(txId + "Par�metro Nombre del Archivo " + nombre);
        documento.setPrevisualizar(true);
        Auditoria estado =
            generarDocumentoConTags(txId, documentoFisico, nombre, documento,
                                    true);
        documento.setAuditoria(estado);
        return documento;
    }

    public DocumentoStd generar(String txId, byte[] documentoFisico,
                                String nombre, DocumentoStd documento) {
        Connection conn = null;
        DocumentoStdDAO dao = new DocumentoStdDAO();
        documento.setAuditoria(new Auditoria());
        try {

            conn = dbHelper.getConnectionAsTransaction();
            if (documento.getNumeroDocumento() == null ||
                documento.getNumeroDocumento().isEmpty()) {
                String numeroDocumento =
                    dao.generarNumeroDocumento(conn, documento.getSubTipo(),
                                               documento.getAreaDestino(),
                                               documento.getSubareaDestino(),
                                               documento.getPersonaDestino());
                if (numeroDocumento.indexOf("Exception") >= 0) {
                    documento.getAuditoria().setEstado(false);
                    documento.getAuditoria().setMensajeUsuario("Error al generar el n򭥲o de documento. Por favor, vuelva a intentar.");
                    logger.info("Error al generar el n򭥲o de documento. Por favor, vuelva a intentar.");
                    dbHelper.rollback(conn);                    
                } else
                    documento.setNumeroDocumento(numeroDocumento);
            }
            if (documento.getNumeroDocumento() != null &&
                !documento.getNumeroDocumento().isEmpty()) {
                Auditoria estado =
                    generarDocumentoConTags(txId, documentoFisico, nombre,
                                            documento, true);
                documento.setAuditoria(estado);
                if (estado.isEstado() && documento.getArchivo() != null &&
                    documento.getArchivo().length > 0)
                    dbHelper.commit(conn);
                else
                    dbHelper.rollback(conn);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(" Exception al generarDocumentoB ", e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                logger.info(" SQLException : generarDocumento - close", e);
                e.printStackTrace();
            }
        }
        return documento;
    }

    private Auditoria generarDocumentoConTags(String txId, byte[] archivo,
                                              String nombre,
                                              DocumentoStd documento,
                                              boolean toPDF) {
        Auditoria estado = new Auditoria();
        estado.setEstado(true);
        String fileName =
            FileHelper.PATH_FILES + FileHelper.generarNombreArchivo(nombre);
        if (!FileHelper.guardarArchivo(fileName, archivo))
            return null;
        String stripImages[][] = null;
        String[][] hojaFirmantes = null;
        HashMap<String, String> hmlistaVistos = new HashMap<String, String>();
        String ID_SIN_VALOR_FDVI = "";
        String ID_SIN_VALOR_FDSE = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dt = new Date();
        String dateFormat = "";
        if (documento.getFirmantes() != null &&
            documento.getFirmantes().size() > 0) {
            try {
                if (documento.isConFirma()) {
                    stripImages =
                            new String[documento.getFirmantes().size()][3];
                    hojaFirmantes =
                            new String[documento.getFirmantes().size() - 1][4];
                    if (documento.isPrevisualizar()) {
                        ID_SIN_VALOR_FDVI =
                                ucmHelper.obtenerDocumentoIDPorTitulo(txId,
                                                                      "SIN_VALOR-FDVI");
                        ID_SIN_VALOR_FDSE =
                                ucmHelper.obtenerDocumentoIDPorTitulo(txId,
                                                                      "SIN_VALOR-FDSE");
                    }
                    for (int i = 0; i < documento.getFirmantes().size(); i++) {
                        logger.info(txId + " Firma " + i + " => " +
                                    documento.getFirmantes().get(i).getUsuario());
                        stripImages[i][0] =
                                documento.getFirmantes().get(i).getUsuario().toUpperCase();
                        stripImages[i][1] = "FDVI";
                        stripImages[i][2] = "";
                        if (i != documento.getFirmantes().size() - 1) {
                            hojaFirmantes[i][0] =
                                    documento.getFirmantes().get(i).getNombre();
                            hojaFirmantes[i][1] =
                                    documento.getFirmantes().get(i).getArea();
                            hojaFirmantes[i][2] =
                                    documento.getFirmantes().get(i).getSubArea();
                            hojaFirmantes[i][3] =
                                    documento.getFirmantes().get(i).getFecha();
                        }
                    }

                    if (documento.isEncargatura())
                        stripImages[stripImages.length - 1][1] = "FDEN";
                    else
                        stripImages[stripImages.length - 1][1] = "FDSE";

                    for (int i = 0; i < stripImages.length; i++) {
                        if (documento.isPrevisualizar()) {
                            if (stripImages[i][1].equals("FDVI"))
                                stripImages[i][2] =
                                        ucmHelper.obtenerPlantilla(txId,
                                                                   ID_SIN_VALOR_FDVI);
                            else
                                stripImages[i][2] =
                                        ucmHelper.obtenerPlantilla(txId,
                                                                   ID_SIN_VALOR_FDSE);
                        } else {
                            stripImages[i][2] =
                                    ucmHelper.obtenerPlantilla(txId,
                                                               stripImages[i][0] +
                                                               "-" +
                                                               stripImages[i][1]);
                        }
                    }
                    boolean encontroVisto = true;
                    int i = 0;
                    for (i = 0; i < stripImages.length - 1; i++) {
                        if (hmlistaVistos.get(stripImages[i][0]) == null) {
                            logger.info(txId + "stripImages " + i + " [2]==>" +
                                        FileHelper.PATH_FILES +
                                        stripImages[i][2]);
                            if (stripImages[i][2] == null) {
                                encontroVisto = false;
                                break;
                            } else {
                                hmlistaVistos.put(stripImages[i][0],
                                                  FileHelper.PATH_FILES +
                                                  stripImages[i][2]);
                            }
                        }
                    }
                    if (!encontroVisto) {
                        logger.info(txId + " Vistos no encontrados ");
                        estado.setMensajeUsuario("Error al generar el documento. No se encontr� el visto: " +
                                                 stripImages[i][0] + "-" +
                                                 stripImages[i][1]);
                        estado.setEstado(false);
                    }
                    if (stripImages[stripImages.length - 1][2] == null) {
                        logger.info(txId + " Firma no encontrada");
                        estado.setMensajeUsuario("Error al generar el documento. No se encontr� la firma: " +
                                                 stripImages[stripImages.length -
                                                 1][0] + "-" +
                                                 stripImages[stripImages.length -
                                                 1][1]);
                        estado.setEstado(false);
                    }
                }
            } catch (Exception ex) {
                logger.info(txId + " Error " + ex.getMessage());
                estado.setEstado(false);
                ex.printStackTrace();
            }
            MsWordHelper mswr = null;
            try {
                if (estado.isEstado()) {
                    logger.info(txId + "Instanciando MsWordReplace");
                    mswr = new MsWordHelper();
                    mswr.open(fileName);
                    try {
                        if (!documento.isConFirma()) {
                            logger.info(txId +
                                        "Generando documento sin Firma");
                            mswr.replaceTextByText("bpmTagFirmaRemitente", "");
                            mswr.replaceTextByText("bpmTagFirm", "");
                        } else {
                            logger.info(txId + "Insertando vistos");
                            String[] imagenes =
                                new String[hmlistaVistos.size()];
                            imagenes =
                                    hmlistaVistos.values().toArray(new String[0]);
                            mswr.insertStripImagesAtLeft(imagenes);
                            imagenes = null;
                            hmlistaVistos = null;
                            if (!mswr.findTagName("bpmTagFirmaRemitente")) {
                                if (!mswr.findTagName("bpmTagFirm")) {
                                    estado.setMensajeUsuario("No se encontro el bpmTagFirmaRemitente");
                                    logger.info(txId +
                                                " No se encontro el bpmTagFirmaRemitente");
                                    estado.setEstado(false);
                                } else {
                                    logger.info(txId +
                                                "Reemplazando Firma bpmTagFirm: " +
                                                stripImages[stripImages.length -
                                                1][2]);
                                    mswr.replaceTextByImage("bpmTagFirm",
                                                            FileHelper.PATH_FILES +
                                                            stripImages[stripImages.length -
                                                            1][2]);
                                }
                            } else {
                                logger.info(txId +
                                            "Reemplazando Firma bpmTagFirmaRemitente: " +
                                            stripImages[stripImages.length -
                                            1][2]);
                                mswr.replaceTextByImage("bpmTagFirmaRemitente",
                                                        FileHelper.PATH_FILES +
                                                        stripImages[stripImages.length -
                                                        1][2]);
                            }
                        }
                    } catch (Exception e) {
                        logger.error(txId +
                                     "Exception en establecerIngreso de imagenes bpmTagFirmaRemitente o bpmTagFirm: " +
                                     e.getMessage());
                        estado.setEstado(false);
                    }
                }
                logger.info(txId + " El estado 0 del reemplazo ed tags es: " +
                            estado.isEstado());
                if (estado.isEstado()) {
                    try {
                        if (!mswr.findTagName("bpmTagFechaRegistro")) {
                            estado.setMensajeUsuario("No se encontro el bpmTagFechaRegistro");
                            estado.setEstado(false);
                        } else {
                            logger.info(txId +
                                        "Reemplazando bpmTagFechaRegistro: ");
                            if (documento.getFechaRegistro() == null ||
                                documento.getFechaRegistro().equals("")) {
                                dateFormat = sdf.format(dt);
                                mswr.replaceTextByText("bpmTagFechaRegistro",
                                                       dateFormat.substring(0,
                                                                            2) +
                                                       " de " +
                                                       nameMonth(dateFormat.substring(3,
                                                                                      5)) +
                                                       " de " +
                                                       dateFormat.substring(6,
                                                                            10));
                            } else {
                                try {
                                    logger.info(txId +
                                                "Reemplazando bpmTagFechaRegistro: " +
                                                documento.getFechaRegistro());
                                    dt =
 sdf.parse(documento.getFechaRegistro());
                                } catch (ParseException e) {
                                    logger.error(txId +
                                                 " Fecha enviada en formatto errado: " +
                                                 documento.getFechaRegistro());
                                } finally {
                                    dateFormat = sdf.format(dt);
                                    mswr.replaceTextByText("bpmTagFechaRegistro",
                                                           dateFormat.substring(0,
                                                                                2) +
                                                           " de " +
                                                           nameMonth(dateFormat.substring(3,
                                                                                          5)) +
                                                           " de " +
                                                           dateFormat.substring(6,
                                                                                10));
                                }
                            }
                        }
                    } catch (Exception e) {
                        logger.error(txId +
                                     "Exception en establecerIngreso de imagenes bpmTagFechaRegistro: " +
                                     e.getMessage());
                        estado.setEstado(false);
                    }
                }
                if (estado.isEstado()) {
                    try {
                        if (!mswr.findTagName("bpmTagNumeroDocumento")) {
                            estado.setMensajeUsuario("No se encontro el bpmTagNumeroDocumento");
                            estado.setEstado(false);
                        } else {
                            String numeroInternoDoc =
                                documento.getNumeroDocumento().replace("RESOLUCION JEFATURAL-",
                                                                       "");
                            numeroInternoDoc =
                                    numeroInternoDoc.replace("RESOLUCION DIRECTORAL-",
                                                             "");
                            mswr.replaceTextByText("bpmTagNumeroDocumento",
                                                   numeroInternoDoc);
                            logger.info(txId +
                                        "Reemplazando bpmTagNumeroDocumento: " +
                                        documento.getNumeroDocumento());
                        }
                    } catch (Exception e) {
                        logger.error(txId +
                                     "Exception en establecerIngreso de numero bpmTagNumeroDocumento: " +
                                     e.getMessage());
                        estado.setEstado(false);
                    }
                }

                if (estado.isEstado()) {
                    try {
                        if (mswr.findTagName("bpmTagHojaVisto")) {
                            mswr.fillTable("bpmTagHojaVisto", hojaFirmantes);
                            logger.info(txId +
                                        "Reemplazando bpmTagHojaVisto con : " +
                                        hojaFirmantes.length + " vistos");
                        }
                    } catch (Exception e) {
                        logger.error(txId +
                                     "Exception en establecerIngreso de numero bpmTagHojaVisto: " +
                                     e.getMessage());
                        estado.setEstado(false);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.error(txId + "Exception en establecerIngreso" +
                             e.getMessage());
                estado.setEstado(false);
            } finally {
                if (mswr != null)
                    mswr.close(fileName);
            }
        } else {
            estado.setMensajeUsuario("El documento no se pudo generar porque no contiene firmas.");
            estado.setEstado(false);
        }

        String pdfFile = "";
        String securePdfFile = "";
        logger.info(txId + " El estado del reemplazo ed tags es: " +
                    estado.isEstado());
        if (estado.isEstado()) {
          if (toPDF) {
            pdfFile = convertirDocumentoAPdf(txId, fileName);
            if (pdfFile == null || pdfFile.isEmpty()) {
              estado.setMensajeUsuario("No se pudo convertir el documento a PDF.");
              estado.setEstado(false);
            } /*else
              securePdfFile = FileHelper.applySecurePDF(pdfFile);
            if (securePdfFile == null || securePdfFile.isEmpty()) {
              estado.setMensajeUsuario("No se pudo convertir el documento a SecurePDF.");
              estado.setEstado(false);
            }*/ else {
              documento.setArchivo(FileHelper.leerArchivo(pdfFile/*securePdfFile*/));
              documento.setNombreArchivo(pdfFile/*securePdfFile*/);
            }
          } else {
            documento.setArchivo(FileHelper.leerArchivo(fileName));
            documento.setNombreArchivo(fileName);
          }
        }

        if (stripImages != null && stripImages.length > 0) {
            for (int i = 0; i < stripImages.length; i++) {
                if (stripImages[i].length == 3 && stripImages[i][2] != null) {
                    FileHelper.eliminarArchivo(FileHelper.PATH_FILES +
                                               stripImages[stripImages.length -
                                               1][2]);
                }
            }
        }
        if (pdfFile != null && !pdfFile.isEmpty()) {
            FileHelper.eliminarArchivo(pdfFile);
        }
        if (securePdfFile != null && !securePdfFile.isEmpty()) {
            FileHelper.eliminarArchivo(securePdfFile);
        }
        if (fileName != null && !fileName.isEmpty()) {
            FileHelper.eliminarArchivo(fileName);
        }
        return estado;
    }

    private String convertirDocumentoAPdf(String txId, String filename) {
        MsWordHelper mswr = null;
        logger.info(txId + " Convirtiendo WORD a PDF - Archivo= " + filename);
        try {
            mswr = new MsWordHelper();
            String pdf = mswr.openAndSaveToPDF(filename);
            logger.info(txId + " Convirtiendo WORD a PDF - Terminado= " + pdf);
            return pdf;
        } catch (Exception e) {
            logger.error(txId +
                         "Exception en establecerIngreso de imagenes bpmTagFechaRegistro: " +
                         e.getMessage());
            return null;
        }
    }

    private String nameMonth(String month) {
        if (month.equalsIgnoreCase("01")) {
            return "Enero";
        } else if (month.equalsIgnoreCase("02")) {
            return "Febrero";
        } else if (month.equalsIgnoreCase("03")) {
            return "Marzo";
        } else if (month.equalsIgnoreCase("04")) {
            return "Abril";
        } else if (month.equalsIgnoreCase("05")) {
            return "Mayo";
        } else if (month.equalsIgnoreCase("06")) {
            return "Junio";
        } else if (month.equalsIgnoreCase("07")) {
            return "Julio";
        } else if (month.equalsIgnoreCase("08")) {
            return "Agosto";
        } else if (month.equalsIgnoreCase("09")) {
            return "Septiembre";
        } else if (month.equalsIgnoreCase("10")) {
            return "Octubre";
        } else if (month.equalsIgnoreCase("11")) {
            return "Noviembre";
        } else if (month.equalsIgnoreCase("12")) {
            return "Diciembre";
        } else {
            return month;
        }
    }

    public ReporteItem exportarReporte(ReporteItem reporteFiltro, String formato) {
        reporteFiltro.setAuditoria(new Auditoria());
        reporteFiltro.getAuditoria().setEstado(true);
        DocumentoStdDAO dao = new DocumentoStdDAO();
        MsExcelHelper helper = new MsExcelHelper();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Map<Integer, Object[]> data = new TreeMap<Integer, Object[]>();
        List<ReporteItem> consultaGeneral = new ArrayList<ReporteItem>();
        
        if (!reporteFiltro.getTipoReporte().equals("RG") &&
            !reporteFiltro.getTipoReporte().equals("RP1") &&
            !reporteFiltro.getTipoReporte().equals("RP2") && 
            !reporteFiltro.getTipoReporte().equals("RP3")) {
            reporteFiltro.getAuditoria().setEstado(false);
            return reporteFiltro;
        }
        
        if (reporteFiltro.getTipoReporte().equals("RG") || 
            reporteFiltro.getTipoReporte().equals("RP1")) {
            data.put(new Integer(0) , new Object[] { "Nro", "N򭥲o Documento", "Remitente Entidad", "Remitente Persona", "Asunto", "Fecha" });
        } else if (reporteFiltro.getTipoReporte().equals("RP2")) {
            data.put(new Integer(0) , new Object[] { "Nro", "N򭥲o Documento", "Remitente Entidad", "Remitente Persona", "Asunto", "Fecha", "Funcionario Asignado" });
        } else if (reporteFiltro.getTipoReporte().equals("RP3")) {
            data.put(new Integer(0) , new Object[] { "Nro", "N򭥲o Documento", "Remitente Entidad", "Remitente Persona", "Asunto", "Fecha", "²ea asignada", "Funcionario Asignado" });
        }
        
        if (reporteFiltro.getTipoReporte().equals("RG")) {
            consultaGeneral = dao.consultaGeneral(reporteFiltro);
        } else if (reporteFiltro.getTipoReporte().equals("RP1") ||
                   reporteFiltro.getTipoReporte().equals("RP2") || 
                   reporteFiltro.getTipoReporte().equals("RP3")) {
            consultaGeneral = dao.consultaPendientes(reporteFiltro);
        }
        logger.info("FILAS A EXPORTAR = " + consultaGeneral.size());
            
        int j = 1;
        for (ReporteItem item : consultaGeneral) {
            if (reporteFiltro.getTipoReporte().equals("RG")) {
                data.put(new Integer(j) , new Object[] { j, item.getNumeroDocumento(), item.getAreaEntidadRem(), item.getPersonaRem(), item.getAsunto(), df.format(item.getFecha()) });
            } else if (reporteFiltro.getTipoReporte().equals("RP1")) {
                data.put(new Integer(j) , new Object[] { j, item.getNumeroDocumento(), item.getAreaEntidadRem(), item.getPersonaRem(), item.getAsunto(), df.format(item.getFechaHora()) });
            } else if (reporteFiltro.getTipoReporte().equals("RP2")) {
                data.put(new Integer(j) , new Object[] { j, item.getNumeroDocumento(), item.getAreaEntidadRem(), item.getPersonaRem(), item.getAsunto(), df.format(item.getFechaHora()), item.getPersonaDest() });
            } else if (reporteFiltro.getTipoReporte().equals("RP3")) {
                data.put(new Integer(j) , new Object[] { j, item.getNumeroDocumento(), item.getAreaEntidadRem(), item.getPersonaRem(), item.getAsunto(), df.format(item.getFechaHora()), item.getSubAreaEntidadDest(), item.getPersonaDest() });
            }
            j++;
        }
        reporteFiltro.setReporte(helper.exportDataToBytes(reporteFiltro.getTitulo(), data, formato));
        return reporteFiltro;
    }
}
