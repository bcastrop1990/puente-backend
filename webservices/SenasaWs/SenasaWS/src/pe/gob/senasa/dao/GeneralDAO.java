package pe.gob.senasa.dao;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Writer;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.EnumMap;
import java.util.List;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import oracle.jdbc.OracleTypes;

import org.apache.axis.encoding.Base64;
import org.apache.log4j.Logger;

import org.joda.time.Interval;
import org.joda.time.Period;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import pe.gob.senasa.bean.AdjuntoDocumentoVuce;
import pe.gob.senasa.bean.AnexoPFI;
import pe.gob.senasa.bean.Guardacustodia;
import pe.gob.senasa.bean.LugarProduccionProductoPFI;
import pe.gob.senasa.bean.PaisOrigenProductoPFI;
import pe.gob.senasa.bean.PermisoFitosanitarioTransitoInterno;
import pe.gob.senasa.bean.ProductoPFI;
import pe.gob.senasa.bean.PuntoIngresoProductoPFI;
import pe.gob.senasa.bean.ResultadoConsultaReporte;
import pe.gob.senasa.bean.Solicitante;
import pe.gob.senasa.bean.Trazabilidad;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.interfaces.GeneralInterface;
import pe.gob.senasa.tupa.cis.UCMClient;
import pe.gob.senasa.util.Utility;


//import org.netbeans.lib.ddl.DBConnection;


public class GeneralDAO extends BaseDAO implements GeneralInterface {

	protected static Logger logger = Logger.getLogger(GeneralDAO.class);
  private DBHelper helper;
  private UCMClient ucmClient=null;
	private String msgErr = "";

	public GeneralDAO() {
		super();
	  helper = new DBHelper(SenasaSQL.dsGeneral);
	  ucmClient= new UCMClient();
	}


	private void Log(String s) {
		logger.debug(s);
	}

	private void Log(String s, java.lang.Throwable p2) {
		logger.fatal("GENERAL - " + s, p2);
	}

	public String getMsgErr() {
		return msgErr;
	}

	//public String generaNumeroExpediente(String tipoExpediente, String canal, String userName, String codigoExpedienteTMP ){

	public String generaNumeroExpediente(String codigoExpedienteTMP, String userName) {

		//String sql = SenasaSQL.GENERA_EXPEDIENTE_TMPDEF;
		String sql = SenasaSQL.GENERA_EXPEDIENTE_DEFINITIVO;
		logger.debug("Iniciando generaNumeroExpediente()");
		Log("generaNumeroExpediente() AQUI VA EL " + sql);

		Connection con = null;
		PreparedStatement pst = null;
		CallableStatement cs = null;

		//String codUser = persona.getIdFuncionario();
		String retval = "-1";
		msgErr = "0";
		try {
            con = helper.getConnection();  
			//pst = con.prepareStatement(sql);
			cs = con.prepareCall(sql);
			//if(tipoExpediente=="T")
			//{
			//  cs.setString(1,"");
			//  cs.setString(2,canal);
			//  cs.setString(3,codUser);
			//  cs.registerOutParameter(4, Types.VARCHAR);
			//}
			//else {
			cs.setString(1, codigoExpedienteTMP);
			cs.setString(2, userName);
			cs.registerOutParameter(3, Types.VARCHAR);
			//}

			Log(" = ANTES DE EJECUTAR = ");
			cs.execute();

			Log(" = YA EJECUTE = ");
			retval = cs.getString(3);

			logger.debug("generaNumeroExpediente() Obteniendo Expediente Def.: " + retval);
			Log(" = FIN TODITO = ");
		} catch (SQLException e) {
			Log("generaNumeroExpediente", e);
			msgErr = e.getMessage();
		} catch (Exception e) {
			Log("generaNumeroExpediente", e);
			msgErr = e.getMessage();
		} finally {
		  cleanup(con, pst, null);
		}
		return retval;

	}

	public String generaNumeroSolicitud(String codigoProceso, String codigoInstanciaBPM, String canal, String userName) {

		String sql = SenasaSQL.GENERA_NUMERO_SOLICITUD;

		Log(" AQUI VA EL " + sql);

		Connection con = null;
		PreparedStatement pst = null;
		CallableStatement cs = null;

		String retval = "-1";
		msgErr = "";
		try {
            con = helper.getConnection();  
			cs = con.prepareCall(sql);

			//cs.setObject(1,Types.NULL);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setString(2, codigoProceso);
			cs.setString(3, codigoInstanciaBPM);
			cs.setString(4, canal);
			cs.setString(5, userName);

			Log(" = ANTES DE EJECUTAR = ");
			cs.execute();

			Log(" = YA EJECUTE = ");
			retval = cs.getString(1);
			Log(" = FIN TODITO = ");
		} catch (SQLException e) {
			Log("generaNumeroSolicitud", e);
			msgErr = e.getMessage();
		} catch (Exception e) {
			Log("generaNumeroSolicitud", e);
			msgErr = e.getMessage();
		} finally {
		  cleanup(con, pst, null);
		}
		return retval;

	}

	public void insertarTrazabilidad(Trazabilidad trazabilidad) {
		String sql = SenasaSQL.REGISTRAR_TRAZABILIDAD;

		Log(" AQUI VA EL " + sql);
		Connection con = null;
		CallableStatement cs = null;

		try {
            con = helper.getConnection();

			cs = con.prepareCall(sql);

			Timestamp _dateResult = new Timestamp(trazabilidad.getFechaHora().getTime());

			cs.setString(1, trazabilidad.getProceso());
			cs.setString(2, trazabilidad.getExpedienteTemp());
			cs.setString(3, trazabilidad.getExpedienteDefinitivo());
			cs.setTimestamp(4, _dateResult);
			cs.setString(5, trazabilidad.getDescripcionAsunto());
			cs.setString(6, trazabilidad.getRemitenteAreaEntidad());
			cs.setString(7, trazabilidad.getRemitenteSubAreaEntidad());
			cs.setString(8, trazabilidad.getRemitentePersona());
			cs.setString(9, trazabilidad.getDestinatarioAreaEntidad());
			cs.setString(10, trazabilidad.getDestinatarioSubAreaEntidad());
			cs.setString(11, trazabilidad.getDestinatarioPersona());
			cs.setString(12, trazabilidad.getAccion());
			cs.setString(13, trazabilidad.getEstado());
			cs.setString(14, trazabilidad.getNotas());
		  cs.setString(15, trazabilidad.getProveido());
		  cs.setString(16, trazabilidad.getUrgencia());
			cs.setString(17, trazabilidad.getCanal());
			cs.setString(18, trazabilidad.getCodigoElemento());
			cs.setString(19, trazabilidad.getCodigoElementoRespuesta());

			Log(" = ANTES DE EJECUTAR = ");

			cs.execute();

			Log(" = YA EJECUTE = ");

			Log(" = FIN TODITO = ");

		} catch (SQLException e) {
			Log("insertarTrazabilidad", e);
			msgErr = e.getMessage();
		} catch (Exception e) {
			Log("insertarTrazabilidad", e);
			msgErr = e.getMessage();
		} finally {
		  cleanup(con, cs, null);
		}

	}
  
  public void actualizarTrazabilidad(Trazabilidad trazabilidad) {
    String sql = SenasaSQL.ACTUALIZAR_TRAZABILIDAD;

    Log(" AQUI VA EL " + sql);
    Connection con = null;
    PreparedStatement pst = null;
    CallableStatement cs = null;

    try {
            con = helper.getConnection();
      cs = con.prepareCall(sql);
      cs.setString(1, trazabilidad.getExpedienteTemp());
      cs.setString(2, trazabilidad.getExpedienteDefinitivo());
      Log(" = ANTES DE EJECUTAR = ");
      cs.execute();
      Log(" = YA EJECUTE = ");
    } catch (SQLException e) {
      Log("insertarTrazabilidad", e);
      msgErr = e.getMessage();
    } catch (Exception e) {
      Log("insertarTrazabilidad", e);
      msgErr = e.getMessage();
    } finally {
      cleanup(con, pst, null);
    }
  }


	public byte[] consultaTrazaMensaje(String codigoExpediente, String codigoServicio) {

		String sql = SenasaSQL.CONSULTA_TRAZA;

		Log(" AQUI VA EL " + sql);

		Connection con = null;
		PreparedStatement pst = null;
		CallableStatement cs = null;
		InputStream inputStream = null;

		String retval = "";
		Blob _blob;
		byte[] byteTraza;
		byte[] byteResultTraza = new byte[0];

		String xmlText = null;
		Date fechaXML = new Date();

		msgErr = "";

		try {
            con = helper.getConnection();
			cs = con.prepareCall(sql);
			cs.setString(1, codigoExpediente);
			cs.registerOutParameter(2, Types.BLOB);

			Log(" = ANTES DE EJECUTAR = ");
			cs.execute();

			Log(" = YA EJECUTE = ");
			_blob = cs.getBlob(2);

			if (_blob.equals(null))
				return byteResultTraza;
			//byteTraza = _blob.getBytes(1, (int)_blob.length());
			inputStream = _blob.getBinaryStream();
			byteTraza = new byte[(int)_blob.length()];
			inputStream.read(byteTraza);

			xmlText = new String(byteTraza);

			String _xmlFile = "tempTraza_" + codigoExpediente + ".xml";
			String _xmlPath = ucmClient.PATH_FILES;

			_xmlFile = ucmClient.generarNombreArchivo(_xmlFile);

			File file = new File(_xmlPath + _xmlFile);
			file.createNewFile();

			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			out.write(xmlText);
			out.close();
			//retval = xmlText;
			String _fileXML = _xmlPath + _xmlFile;
			Source xmlSource = new StreamSource(new File(_fileXML));
			Source xsltSource = new StreamSource(new File("traza.xsl"));

			StringWriter cadenaSalida = new StringWriter();

			Result bufferResultado = new StreamResult(cadenaSalida);

			TransformerFactory factoriaTrans = TransformerFactory.newInstance();
			Transformer transformador = factoriaTrans.newTransformer(xsltSource);

			transformador.transform(xmlSource, bufferResultado);
			byteResultTraza = cadenaSalida.toString().getBytes("UTF-8");
			System.out.print(cadenaSalida.toString());

			Log(" = FIN TODITO = ");
		} catch (SQLException e) {
			Log("consultaTrazaMensaje", e);
			msgErr = e.getMessage();
		} catch (Exception e) {
			Log("consultaTrazaMensaje", e);
			msgErr = e.getMessage();
		} finally {
		  cleanup(con, pst, null);
		}
		return byteResultTraza;

	}

	private String obtenerValorTagNodoXML(Element nodoElemento, String nombreNodo) {
		String valor = "";

		try {
			NodeList fstNmElmntLst = nodoElemento.getElementsByTagName(nombreNodo);
			Element fstNmElmnt = (Element)fstNmElmntLst.item(0);
			NodeList fstNm = fstNmElmnt.getChildNodes();

			valor = ((Node)fstNm.item(0)).getNodeValue();
		} catch (Exception e) {
			Log("consultaTrazaMensaje->obtenerValorTagNodoXML", e);
			msgErr = e.getMessage();
		}

		return valor;

	}


	public String guardarExpedienteTemporal(String codigoExpediente, String codigoSolicitud, String codigoServicio, String dniRuc, String sede,
											String observacion, String userName) {

		String sql = SenasaSQL.GUARDAR_EXPEDIENTE_TMP;

		String _idPersona = obtenerIdPersona(dniRuc);

		if ((_idPersona.isEmpty()) || (_idPersona == "")) {
			logger.fatal("NO SE ENCONTRO EL IDENTIFICADOR DE PERSONA PARA EL SOLICITANTE: " + dniRuc);
			msgErr = "NO SE ENCONTRO EL IDENTIFICADOR DE PERSONA PARA EL SOLICITANTE: " + dniRuc;
			return msgErr;
		}

		Log(" AQUI VA EL " + sql);
		Connection con = null;
		PreparedStatement pst = null;
		CallableStatement cs = null;

		String retval = "0";

		try {
            con = helper.getConnection();
			cs = con.prepareCall(sql);

			cs.setString(1, codigoExpediente);
			cs.setString(2, codigoSolicitud);
			cs.setString(3, codigoServicio);
			cs.setString(4, _idPersona);
			cs.setString(5, sede);
			cs.setString(6, observacion);
			cs.setString(7, userName);
			Log(" = ANTES DE EJECUTAR = ");
			cs.execute();
			Log(" = YA EJECUTE = ");


		} catch (SQLException e) {
			Log("guardarExpedienteTemporal", e);
			msgErr = e.getMessage();
			retval = msgErr;
		} catch (Exception e) {
			Log("guardarExpedienteTemporal", e);
			msgErr = e.getMessage();
			retval = msgErr;
		} finally {
		  cleanup(con, pst, null);
		}
		return retval;
	}
  
  

	private String obtenerIdPersona(String dniRucSolicitante) {

		String sql = SenasaSQL.OBTENER_ID_PERSONA;
		Log("obtenerIdPersona(): AQUI VA EL " + sql);

		Connection con =null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String retval = "";
		try {
            con = helper.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, dniRucSolicitante);
			rs = pst.executeQuery();

			int i = 0;
			while (rs.next()) {
				i++;
				if (i == 1)
					retval = rs.getString(1);
			}
			Log(" = TODO FINITO = ");
		} catch (SQLException e) {
			Log("obtenerIdPersona", e);
		} catch (Exception e) {
			Log("obtenerIdPersona", e);
		} finally {
		  cleanup(con, pst, rs);
		}
		return retval;
	}

	public String obtenerCaducidad(String fechaInicio, Double dias, Double horas, Double minutos) {

		String sql = SenasaSQL.CALCULAR_FECHA;
		Log("obtenerIdPersona(): AQUI VA EL " + sql);

		Connection con = null;
		PreparedStatement pst = null;
		CallableStatement cs = null;
		String retval = "";
		java.sql.Timestamp _dateIni = null;
		java.sql.Date _dateEnd = null;
		Timestamp _dateResult = null;
		//_dateIni = Utility.toSQLDate(fechaInicio);
		_dateIni = Utility.parseStringToTimeStamp(fechaInicio);
		String sdateIni;
		String sdateEnd;
		try {
            con = helper.getConnection();
			//String _fechaIni = "to_date('" + fechaInicio + "','dd/MM/yyyy hh24:mi:ss')";
			cs = con.prepareCall(sql);

			cs.registerOutParameter(1, OracleTypes.TIMESTAMP);
			cs.setTimestamp(2, _dateIni);
			cs.setDouble(3, dias);
			cs.setDouble(4, horas);
			cs.setDouble(5, minutos);

			cs.execute();

			_dateResult = cs.getTimestamp(1);

			// = Utility.parseDateToString(Utility.toUtilDate(_dateEnd));
			SimpleDateFormat sdf0 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss ");
			sdateIni = sdf0.format(_dateIni);


			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss ");
			sdateEnd = sdf.format(_dateResult);

			Interval interval = new Interval(_dateIni.getTime(), _dateResult.getTime());
			Period periodo = interval.toPeriod();

			//Integer _dias = periodo.getDays();
			Integer _horas = periodo.getHours();
			Integer _minutos = periodo.getMinutes();
			//_dias++;

			long diferenciaMils = _dateResult.getTime() - _dateIni.getTime();

			Integer _dias = (int)Math.floor(diferenciaMils / (1000 * 60 * 60 * 24));
			//Integer _horas = (int)Math.floor(diferenciaMils/(1000 * 60 * 60));
			//Integer _minutos = (int)Math.floor(diferenciaMils/(1000 * 60));

			retval = "P" + _dias + "DT" + _horas + "H" + _minutos + "M";

			Log(" = TODO FINITO = ");
		} catch (SQLException e) {
			Log("obtenerIdPersona", e);
		} catch (Exception e) {
			Log("obtenerIdPersona", e);
		} finally {
		  cleanup(con, pst, null);
		}
		return retval;
	}

	public String registrarServiciosExp(String codigoExpediente, String codigoSolicitud, String codigoSede, String userName, String codigosServicios) {
		String retval = "0";

		try {

			String[] arrServicio = codigosServicios.split(",");
			int k;

			for (k = 0; k < arrServicio.length; k++) {
				String codServicio = arrServicio[k];
				retval = registrarServicioExp(codigoExpediente, codigoSolicitud, codigoSede, userName, codServicio);
				if (retval != "0") {
					return retval;
				}
			}

		} catch (Exception e) {
			Log("anularBoletas", e);
			retval = e.getMessage();
		} finally {

		}
		return retval;
	}

	private String registrarServicioExp(String codigoExpediente, String codigoSolicitud, String codigoSede, String userName, String codigoServicio) {

		String sql = SenasaSQL.REGISTRAR_SERVICIO;
		Log(" AQUI VA EL " + sql);

		Connection con = null;
		CallableStatement cs = null;
		String retval = "0";

		try {
            con = helper.getConnection();  
			cs = con.prepareCall(sql);
			cs.setString(1, codigoExpediente);
			cs.setString(2, codigoSolicitud);
			cs.setString(3, codigoServicio);
			cs.setString(4, codigoSede);
			cs.setString(5, userName);

			Log(" = ANTES DE EJECUTAR = ");

			cs.execute();

			Log(" = EJECUTADO = ");
		} catch (SQLException e) {
			Log("registrarServicioExp", e);
			retval = e.getMessage();
		} catch (Exception e) {
			Log("registrarServicioExp", e);
			retval = e.getMessage();
		} finally {
		  cleanup(con, cs, null);
		}
		return retval;
	}


	public static void main(String[] args) {

		GeneralDAO objDAO = new GeneralDAO();
		byte[] byteTraza;

		String valor;
		//valor = objDAO.obtenerCaducidad("20/07/2011 13:00:00", 40.0, 13.0, 0.0);
		//byteTraza = objDAO.consultaTrazaMensaje("xxxHamilton", "");

		valor = objDAO.registrarServiciosExp("110600000093", "119900000277", "06", "cberrospi", "047,");


		String s;
		s = valor;
		/*
    String valor;
    byte[] byteTraza;
    Date _fecha = Utility.parseStringToDate("27/06/2011");
    String fech;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm a");

    fech = sdf.format(_fecha);



    valor = objDAO.obtenerCaducidad("27/06/2011", 0.0, 12.0, 0.0);


     Trazabilidad trazabilidad = new Trazabilidad();
     trazabilidad.setAccion("AAAA");
     trazabilidad.setCanal("BBBBB");
     trazabilidad.setDescripcionAsunto("ORUEBHA");
     trazabilidad.setDestinatarioAreaEntidad("MMMMMMM");
     trazabilidad.setDestinatarioPersona("LLLLL");
     trazabilidad.setEstado("TERMINADO");
     trazabilidad.setExpedienteDefinitivo("QQQQQQQQ");
     trazabilidad.setExpedienteTemp("QQQQQQQQ");
     trazabilidad.setFechaHora(new Date(System.currentTimeMillis()));
     trazabilidad.setNotas("TTTTT");
     trazabilidad.setProceso("STD");
     trazabilidad.setRemitenteAreaEntidad("JJJJJ");
     trazabilidad.setRemitentePersona("PPPPPP");

     objDAO.insertarTrazabilidad(trazabilidad);

    //numero = objDAO.generaNumeroExpediente("119900000055", "impofito");
    byteTraza = objDAO.consultaTrazaMensaje("010600000100","");

    String _traza = byteTraza.toString();

    System.out.println(_traza);




    TransformerFactory tFactory = TransformerFactory.newInstance();

       Transformer transformer =
         tFactory.newTransformer
            (new javax.xml.transform.stream.StreamSource
               (""));

       transformer.transform
         (new javax.xml.transform.stream.StreamSource
               (_xmlPath + _xmlFile),
          new javax.xml.transform.stream.StreamResult
          ( new FileOutputStream(_xmlPath + "traza_"+ codigoExpediente +".html")));





     //Parseando el XML:
     DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     DocumentBuilder db = dbf.newDocumentBuilder();
     Document doc = db.parse(file);
     doc.getDocumentElement().normalize();

     NodeList nodeLstCab = doc.getElementsByTagName("proceso");

     for (int s = 0; s < nodeLstCab.getLength(); s++) {

           Node fstNode = nodeLstCab.item(s);

           if (fstNode.getNodeType() == Node.ELEMENT_NODE) {

                // Element fstElmnt01 = (Element) fstNode;
                 String id_proceso =  obtenerValorTagNodoXML((Element) fstNode,"id_proceso");
                 String id_original = obtenerValorTagNodoXML((Element) fstNode,"id_original");
                 String id_final = obtenerValorTagNodoXML((Element) fstNode,"id_final");


                System.out.println(id_proceso );
                 System.out.println(id_original );
             System.out.println(id_final );



           }
     }


    NodeList nodeLstDet = doc.getElementsByTagName("actividad");

    for (int s = 0; s < nodeLstDet.getLength(); s++) {

         Node fstNode = nodeLstDet.item(s);

         if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
           NodeList nodeLstItems = fstNode.getChildNodes();

           for (int t = 0; t < nodeLstItems.getLength(); t++)
           {
               Node fstNodeItem = nodeLstItems.item(t);

               if (fstNodeItem.getNodeType() == Node.ELEMENT_NODE) {
                   String item_fecha_hora =  obtenerValorTagNodoXML((Element) fstNodeItem,"fecha_hora");
                   String item_asunto =  obtenerValorTagNodoXML((Element) fstNodeItem,"asunto");
                   String item_remitente_area =  obtenerValorTagNodoXML((Element) fstNodeItem,"remitente_area");
                   String item_remitente_persona =  obtenerValorTagNodoXML((Element) fstNodeItem,"remitente_persona");
                   String item_destinatario_area =  obtenerValorTagNodoXML((Element) fstNodeItem,"destinatario_area");
                   String item_destinatario_persona =  obtenerValorTagNodoXML((Element) fstNodeItem,"destinatario_persona");
                   String item_estado =  obtenerValorTagNodoXML((Element) fstNodeItem,"estado");
                   String item_notas =  obtenerValorTagNodoXML((Element) fstNodeItem,"notas");
                   String item_canal =  obtenerValorTagNodoXML((Element) fstNodeItem,"canal");

                 System.out.println(item_asunto );
               }

           }
     }

    }
    */

	}


	public ArrayList<ResultadoConsultaReporte> consultaGeneral(pe.gob.senasa.bean.ConsultaReporte consultaReporte) {

		ArrayList<ResultadoConsultaReporte> respuesta = new ArrayList<ResultadoConsultaReporte>();

		String sql = SenasaSQL.CONSULTA_GENERAL;
		Log("obtenerIdPersona(): AQUI VA EL " + sql);

		Connection con = null;
		PreparedStatement pst = null;
		// CallableStatement cs = null;
		ResultSet rs = null;
		String retval = "";

		try {
      con = helper.getConnection();
			StringBuffer filter = new StringBuffer();

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			if (consultaReporte.getCodigoDocumento() != null && !consultaReporte.getCodigoDocumento().trim().equals("")) {
				filter.append(" and t.id_original ='" + consultaReporte.getCodigoDocumento() + "'");
			}

			if (consultaReporte.getFechaDesde() != null) {
				filter.append(" and to_char(t.fech_crea,'dd-MM-yyyy') >= to_date('" + sdf.format(consultaReporte.getFechaDesde()) + "','dd-MM-yyyy')");
			}

			if (consultaReporte.getFechaHasta() != null) {
				filter.append(" and  to_char(t.fech_crea,'dd-MM-yyyy') <= to_date('" + sdf.format(consultaReporte.getFechaHasta()) + "','dd-MM-yyyy')");
			}

			if (consultaReporte.getAreaEntidadRemitente() != null && !consultaReporte.getAreaEntidadRemitente().trim().equals("")) {
				filter.append(" and t.remitente_entidad ='" + consultaReporte.getAreaEntidadRemitente() + "'");
			}

			if (consultaReporte.getNombrePersonaRemitente() != null && !consultaReporte.getNombrePersonaRemitente().trim().equals("")) {
				filter.append(" and t.remitente_persona ='" + consultaReporte.getNombrePersonaRemitente() + "'");
			}

			if (consultaReporte.getAreaEntidadDestino() != null && !consultaReporte.getAreaEntidadDestino().trim().equals("")) {
				filter.append(" and t.destinatario_entidad ='" + consultaReporte.getAreaEntidadDestino() + "'");
			}

			if (consultaReporte.getNombrePersonaDirigido() != null && !consultaReporte.getNombrePersonaDirigido().trim().equals("")) {
				filter.append(" and t.destinatario_persona ='" + consultaReporte.getNombrePersonaDirigido() + "'");
			}

			if (consultaReporte.getFecha() != null) {
				filter.append(" and to_char(t.fecha_hora,'dd-MM-yyyy') = to_date('" + sdf.format(consultaReporte.getFecha()) + "','dd-MM-yyyy')");
			}

			if (consultaReporte.getEstado() != null && !consultaReporte.getEstado().trim().equals("")) {
				filter.append(" and t.estado_traza ='" + consultaReporte.getEstado() + "'");
			}

			sql = sql.replaceAll("%filter%", filter.toString());

			logger.debug("SQL:" + sql.toString());

			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			ResultadoConsultaReporte resultado = null;

			while (rs.next()) {
				resultado = new ResultadoConsultaReporte();

				resultado.setIdProceso(rs.getString("id_proceso"));
				resultado.setIdOriginal(rs.getString("id_original"));
				resultado.setSecuencial(rs.getString("secuencial"));
				resultado.setFechaHora(Utility.toUtilDate(rs.getDate("fecha_hora")));
				resultado.setDescripcionAsunto(rs.getString("descripcion_asunto"));
				resultado.setRemitenteEntidad(rs.getString("remitente_entidad"));
				resultado.setRemitentePersona(rs.getString("remitente_persona"));
				resultado.setDestinatarioPersona(rs.getString("destinatario_entidad"));
				resultado.setDestinatarioPersona(rs.getString("destinatario_persona"));
				resultado.setAccion(rs.getString("accion"));
				resultado.setEstadoTraza(rs.getString("estado_traza"));
				resultado.setFechCrea(Utility.toUtilDate(rs.getDate("fech_crea")));

				respuesta.add(resultado);
			}


		} catch (SQLException e) {
			Log("consultaGeneral", e);
			retval = e.getMessage();
		} catch (Exception e) {
			Log("consultaGeneral", e);
			retval = e.getMessage();
		} finally {
            cleanup(con, pst);
		}


		return respuesta;
	}

	public ArrayList<ResultadoConsultaReporte> consultaDocumentosPendientes(pe.gob.senasa.bean.ConsultaReporte consultaReporte) {
		ArrayList<ResultadoConsultaReporte> respuesta = new ArrayList<ResultadoConsultaReporte>();

		String sql = SenasaSQL.CONSULTA_GENERAL;
		Log("obtenerIdPersona(): AQUI VA EL " + sql);

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String retval = "";

		try {
			StringBuffer filter = new StringBuffer();

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			if (consultaReporte.getCodigoDocumento() != null && !consultaReporte.getCodigoDocumento().trim().equals("")) {
				filter.append(" and t.id_original ='" + consultaReporte.getCodigoDocumento() + "'");
			}

			if (consultaReporte.getFechaDesde() != null) {
				filter.append(" and to_char(t.fech_crea,'dd-MM-yyyy') >= to_date('" + sdf.format(consultaReporte.getFechaDesde()) + "','dd-MM-yyyy')");
			}

			if (consultaReporte.getFechaHasta() != null) {
				filter.append(" and  to_char(t.fech_crea,'dd-MM-yyyy') <= to_date('" + sdf.format(consultaReporte.getFechaHasta()) + "','dd-MM-yyyy')");
			}

			if (consultaReporte.getAreaEntidadRemitente() != null && !consultaReporte.getAreaEntidadRemitente().trim().equals("")) {
				filter.append(" and t.remitente_entidad ='" + consultaReporte.getAreaEntidadRemitente() + "'");
			}

			if (consultaReporte.getNombrePersonaRemitente() != null && !consultaReporte.getNombrePersonaRemitente().trim().equals("")) {
				filter.append(" and t.remitente_persona ='" + consultaReporte.getNombrePersonaRemitente() + "'");
			}

			if (consultaReporte.getAreaEntidadDestino() != null && !consultaReporte.getAreaEntidadDestino().trim().equals("")) {
				filter.append(" and t.destinatario_entidad ='" + consultaReporte.getAreaEntidadDestino() + "'");
			}

			if (consultaReporte.getNombrePersonaDirigido() != null && !consultaReporte.getNombrePersonaDirigido().trim().equals("")) {
				filter.append(" and t.destinatario_persona ='" + consultaReporte.getNombrePersonaDirigido() + "'");
			}

			if (consultaReporte.getFecha() != null) {
				filter.append(" and to_char(t.fecha_hora,'dd-MM-yyyy') = to_date('" + sdf.format(consultaReporte.getFecha()) + "','dd-MM-yyyy')");
			}

			if (consultaReporte.getEstado() != null && !consultaReporte.getEstado().trim().equals("")) {
				filter.append(" and t.estado_traza ='" + consultaReporte.getEstado() + "'");
			}

			sql = sql.replaceAll("%filter%", filter.toString());

			logger.debug("SQL:" + sql.toString());

            con = helper.getConnection();
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			ResultadoConsultaReporte resultado = null;

			while (rs.next()) {
				resultado = new ResultadoConsultaReporte();

				resultado.setIdProceso(rs.getString("id_proceso"));
				resultado.setIdOriginal(rs.getString("id_original"));
				resultado.setSecuencial(rs.getString("secuencial"));
				resultado.setFechaHora(Utility.toUtilDate(rs.getDate("fecha_hora")));
				resultado.setDescripcionAsunto(rs.getString("descripcion_asunto"));
				resultado.setRemitenteEntidad(rs.getString("remitente_entidad"));
				resultado.setRemitentePersona(rs.getString("remitente_persona"));
				resultado.setDestinatarioPersona(rs.getString("destinatario_entidad"));
				resultado.setDestinatarioPersona(rs.getString("destinatario_persona"));
				resultado.setAccion(rs.getString("accion"));
				resultado.setEstadoTraza(rs.getString("estado_traza"));
				resultado.setFechCrea(Utility.toUtilDate(rs.getDate("fech_crea")));

				respuesta.add(resultado);
			}


		} catch (SQLException e) {
			Log("consultaDocumentosPendientes", e);
			retval = e.getMessage();
		} catch (Exception e) {
			Log("consultaDocumentosPendientes", e);
			retval = e.getMessage();
		} finally {
		  cleanup(con, pst, rs);
		}

		return respuesta;
	}

	public ArrayList<ResultadoConsultaReporte> reporteNumeroDerivaciones(pe.gob.senasa.bean.ConsultaReporte consultaReporte) {
		ArrayList<ResultadoConsultaReporte> respuesta = new ArrayList<ResultadoConsultaReporte>();

		String sql = SenasaSQL.CONSULTA_GENERAL;
		Log("obtenerIdPersona(): AQUI VA EL " + sql);

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String retval = "";

		try {
            con = helper.getConnection();
			StringBuffer filter = new StringBuffer();

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			if (consultaReporte.getCodigoDocumento() != null && !consultaReporte.getCodigoDocumento().trim().equals("")) {
				filter.append(" and t.id_original ='" + consultaReporte.getCodigoDocumento() + "'");
			}

			if (consultaReporte.getFechaDesde() != null) {
				filter.append(" and to_char(t.fech_crea,'dd-MM-yyyy') >= to_date('" + sdf.format(consultaReporte.getFechaDesde()) + "','dd-MM-yyyy')");
			}

			if (consultaReporte.getFechaHasta() != null) {
				filter.append(" and  to_char(t.fech_crea,'dd-MM-yyyy') <= to_date('" + sdf.format(consultaReporte.getFechaHasta()) + "','dd-MM-yyyy')");
			}

			if (consultaReporte.getAreaEntidadRemitente() != null && !consultaReporte.getAreaEntidadRemitente().trim().equals("")) {
				filter.append(" and t.remitente_entidad ='" + consultaReporte.getAreaEntidadRemitente() + "'");
			}

			if (consultaReporte.getNombrePersonaRemitente() != null && !consultaReporte.getNombrePersonaRemitente().trim().equals("")) {
				filter.append(" and t.remitente_persona ='" + consultaReporte.getNombrePersonaRemitente() + "'");
			}

			if (consultaReporte.getAreaEntidadDestino() != null && !consultaReporte.getAreaEntidadDestino().trim().equals("")) {
				filter.append(" and t.destinatario_entidad ='" + consultaReporte.getAreaEntidadDestino() + "'");
			}

			if (consultaReporte.getNombrePersonaDirigido() != null && !consultaReporte.getNombrePersonaDirigido().trim().equals("")) {
				filter.append(" and t.destinatario_persona ='" + consultaReporte.getNombrePersonaDirigido() + "'");
			}

			if (consultaReporte.getFecha() != null) {
				filter.append(" and to_char(t.fecha_hora,'dd-MM-yyyy') = to_date('" + sdf.format(consultaReporte.getFecha()) + "','dd-MM-yyyy')");
			}

			if (consultaReporte.getEstado() != null && !consultaReporte.getEstado().trim().equals("")) {
				filter.append(" and t.estado_traza ='" + consultaReporte.getEstado() + "'");
			}

			sql = sql.replaceAll("%filter%", filter.toString());

			logger.debug("SQL:" + sql.toString());

			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			ResultadoConsultaReporte resultado = null;

			while (rs.next()) {
				resultado = new ResultadoConsultaReporte();

				resultado.setIdProceso(rs.getString("id_proceso"));
				resultado.setIdOriginal(rs.getString("id_original"));
				resultado.setSecuencial(rs.getString("secuencial"));
				resultado.setFechaHora(Utility.toUtilDate(rs.getDate("fecha_hora")));
				resultado.setDescripcionAsunto(rs.getString("descripcion_asunto"));
				resultado.setRemitenteEntidad(rs.getString("remitente_entidad"));
				resultado.setRemitentePersona(rs.getString("remitente_persona"));
				resultado.setDestinatarioPersona(rs.getString("destinatario_entidad"));
				resultado.setDestinatarioPersona(rs.getString("destinatario_persona"));
				resultado.setAccion(rs.getString("accion"));
				resultado.setEstadoTraza(rs.getString("estado_traza"));
				resultado.setFechCrea(Utility.toUtilDate(rs.getDate("fech_crea")));

				respuesta.add(resultado);
			}


		} catch (SQLException e) {
			Log("consultaDocumentosPendientes", e);
			retval = e.getMessage();
		} catch (Exception e) {
			Log("consultaDocumentosPendientes", e);
			retval = e.getMessage();
		} finally {
            cleanup(con, pst);
		}

		return respuesta;
	}

	public ArrayList<ResultadoConsultaReporte> reporteDocumentosNoAtendidos(pe.gob.senasa.bean.ConsultaReporte consultaReporte) {
		ArrayList<ResultadoConsultaReporte> respuesta = new ArrayList<ResultadoConsultaReporte>();

		String sql = SenasaSQL.CONSULTA_GENERAL;
		Log("obtenerIdPersona(): AQUI VA EL " + sql);

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String retval = "";

		try {
            con = helper.getConnection();
			StringBuffer filter = new StringBuffer();

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			if (consultaReporte.getCodigoDocumento() != null && !consultaReporte.getCodigoDocumento().trim().equals("")) {
				filter.append(" and t.id_original ='" + consultaReporte.getCodigoDocumento() + "'");
			}

			if (consultaReporte.getFechaDesde() != null) {
				filter.append(" and to_char(t.fech_crea,'dd-MM-yyyy') >= to_date('" + sdf.format(consultaReporte.getFechaDesde()) + "','dd-MM-yyyy')");
			}

			if (consultaReporte.getFechaHasta() != null) {
				filter.append(" and  to_char(t.fech_crea,'dd-MM-yyyy') <= to_date('" + sdf.format(consultaReporte.getFechaHasta()) + "','dd-MM-yyyy')");
			}

			if (consultaReporte.getAreaEntidadRemitente() != null && !consultaReporte.getAreaEntidadRemitente().trim().equals("")) {
				filter.append(" and t.remitente_entidad ='" + consultaReporte.getAreaEntidadRemitente() + "'");
			}

			if (consultaReporte.getNombrePersonaRemitente() != null && !consultaReporte.getNombrePersonaRemitente().trim().equals("")) {
				filter.append(" and t.remitente_persona ='" + consultaReporte.getNombrePersonaRemitente() + "'");
			}

			if (consultaReporte.getAreaEntidadDestino() != null && !consultaReporte.getAreaEntidadDestino().trim().equals("")) {
				filter.append(" and t.destinatario_entidad ='" + consultaReporte.getAreaEntidadDestino() + "'");
			}

			if (consultaReporte.getNombrePersonaDirigido() != null && !consultaReporte.getNombrePersonaDirigido().trim().equals("")) {
				filter.append(" and t.destinatario_persona ='" + consultaReporte.getNombrePersonaDirigido() + "'");
			}

			if (consultaReporte.getFecha() != null) {
				filter.append(" and to_char(t.fecha_hora,'dd-MM-yyyy') = to_date('" + sdf.format(consultaReporte.getFecha()) + "','dd-MM-yyyy')");
			}

			if (consultaReporte.getEstado() != null && !consultaReporte.getEstado().trim().equals("")) {
				filter.append(" and t.estado_traza ='" + consultaReporte.getEstado() + "'");
			}

			sql = sql.replaceAll("%filter%", filter.toString());

			logger.debug("SQL:" + sql.toString());

			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			ResultadoConsultaReporte resultado = null;

			while (rs.next()) {
				resultado = new ResultadoConsultaReporte();

				resultado.setIdProceso(rs.getString("id_proceso"));
				resultado.setIdOriginal(rs.getString("id_original"));
				resultado.setSecuencial(rs.getString("secuencial"));
				resultado.setFechaHora(Utility.toUtilDate(rs.getDate("fecha_hora")));
				resultado.setDescripcionAsunto(rs.getString("descripcion_asunto"));
				resultado.setRemitenteEntidad(rs.getString("remitente_entidad"));
				resultado.setRemitentePersona(rs.getString("remitente_persona"));
				resultado.setDestinatarioPersona(rs.getString("destinatario_entidad"));
				resultado.setDestinatarioPersona(rs.getString("destinatario_persona"));
				resultado.setAccion(rs.getString("accion"));
				resultado.setEstadoTraza(rs.getString("estado_traza"));
				resultado.setFechCrea(Utility.toUtilDate(rs.getDate("fech_crea")));

				respuesta.add(resultado);
			}


		} catch (SQLException e) {
			Log("consultaDocumentosPendientes", e);
			retval = e.getMessage();
		} catch (Exception e) {
			Log("consultaDocumentosPendientes", e);
			retval = e.getMessage();
		} finally {
            cleanup(con, pst);
		}

		return respuesta;
	}


	public String obtenerNombreServicio(String codigoServicio) {

		String sql = SenasaSQL.PAGOS_OBTENERNOMBRESERVICIO;

		logger.debug("codigoServicio: " + codigoServicio);

		Log(" AQUI VA EL " + sql);
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String retval = "";
		try {
            con = helper.getConnection();
			pst = con.prepareStatement(sql);

			pst.setString(1, codigoServicio);


			Log(" = ANTES DE EJECUTAR = ");
			rs = pst.executeQuery();
			Log(" = ENTRANDO = ");
			while (rs.next()) {
				retval = rs.getString("descripcion_servicio");
			}
		} catch (SQLException e) {
			Log("obtenerNombreServicio", e);
		} catch (Exception e) {
			Log("obtenerNombreServicio", e);
		} finally {
		  cleanup(con, pst, rs);
		}
		return retval;
	}

	public Integer verificarEstadoPermiso(String numPermiso) {
		Log(" = VERIFICAR_ESTADO_PERMIDO =");
		int retval = 0;

		String sql = SenasaSQL.VERIFICAR_ESTADO_PERMISO;
		Log(" AQUI VA EL " + sql);
		Connection con = null;
		CallableStatement cs = null;

		try {
            con = helper.getConnection();
			cs = con.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.INTEGER);
			cs.setString(2, numPermiso);
			cs.execute();

			retval = cs.getInt(1);
			Log("= Valor de retorno= " + retval);
			Log(" = TODO FINITO = ");
		} catch (SQLException e) {
			Log("verificarEstadoPermiso", e);
		} catch (Exception e) {
			Log("verificarEstadoPermiso", e);
		} finally {
		  cleanup(con, cs, null);
		}

		return retval;
	}

	public String obtenerFechaAmpliacion(String fechaIni, String tipo, int dias) {
		Log("= CALCULAR_DIAS_AMPLIACION");
		String retval = null;
		String sql = SenasaSQL.CALCULAR_FECHA_AMPLIACION;
		Log(" AQUI VA EL " + sql);
		Connection con = null;
		CallableStatement cs = null;
		try {
            con = helper.getConnection();  
			cs = con.prepareCall(sql);
			cs.setDate(1, Utility.parseStringToDate(fechaIni));
			cs.setString(2, tipo);
			cs.setInt(3, dias);
			cs.registerOutParameter(4, OracleTypes.DATE);
			cs.execute();

			retval = Utility.parseOnlyDateToString(cs.getDate(4));
			Log("= Valor de retorno= " + retval);
			Log(" = TODO FINITO = ");
		} catch (SQLException e) {
			Log("calcularDiasAmpliacion", e);
		} catch (Exception e) {
			Log("calcularDiasAmpliacion", e);
		} finally {
		  cleanup(con, cs, null);
		}

		return retval;
	}
  ///////////////// METODOS VUCE ///////////////////
  public Guardacustodia obtenerDatosGuardacustodia(String nroExpediente){
    logger.debug("OBTENER_DATOS_GUARDACUSTODIA INICIANDO");   
    String sql = SenasaSQL.OBTENER_DATOS_GUARDACUSTODIA;
    logger.debug("Sentencia SQL: "+sql);
    
    Connection con =null;
    CallableStatement cs =null;
    ResultSet rs= null;
    Guardacustodia guardacustodia = null;
    try{
       
       
        
        cs.setString(1, nroExpediente);
        cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
        cs.registerOutParameter(3, OracleTypes.CURSOR, "SYS_REFCURSOR");

        logger.debug(" = voy a ejecutar  OBTENER_DATOS_GUARDACUSTODIA = ");

        cs.execute();
        Log(" = ENTRANDO = ");
        rs = (ResultSet)cs.getObject(2);
        logger.debug("Se ejecuto OBTENER_DATOS_GUARDACUSTODIA");
        if(rs.next()){
          guardacustodia= new Guardacustodia();
          guardacustodia.setNroCertificado(rs.getString("Codigo_Registro_Guardacustodia"));
          guardacustodia.setNomEmpresa(rs.getString("Nombre_Razon_Social"));
          guardacustodia.setNroDocEmpresa(rs.getString("Numero_Doc"));
          guardacustodia.setDirAlmacen(rs.getString("Direccion_Almacen"));
          guardacustodia.setFecEmisionCertf(Utility.parseDateToString(rs.getTimestamp("Fecha_Emision")));
          guardacustodia.setLugarEmisionCertf(rs.getString("Descripcion_Centro_Tramite"));
          //20110111
          guardacustodia.setTermVigncCertf(Utility.parseDateToString(rs.getTimestamp("Fecha_Vencimiento")));
          
          guardacustodia.setCodigoSede(rs.getString("codigo_centro_tramite"));
          guardacustodia.setNombreDepartamento(rs.getString("nomb_dpto_dpt"));
          guardacustodia.setNombreProvincia(rs.getString("nomb_prov_tpr"));
          guardacustodia.setNombreDistrito(rs.getString("nomb_dist_tdi"));
          guardacustodia.setPersonaId(rs.getString("persona_id"));
          guardacustodia.setDireccion(rs.getString("direccion"));
          
        }
        
    }catch (SQLException e) {
			Log("OBTENER_DATOS_GUARDACUSTODIA", e);
		} catch (Exception e) {
			Log("OBTENER_DATOS_GUARDACUSTODIA", e);
		} finally {
		  cleanup(con, cs, rs);
		}
    return guardacustodia;
  }
  public PermisoFitosanitarioTransitoInterno obtenerDatosPFTI(String nroExpediente){
    logger.debug("OBTENER_DATOS_PFTI INICIANDO");   
    String sql = SenasaSQL.OBTENER_DATOS_PFTI;
    logger.debug("Sentencia SQL: "+sql);
    
    Connection con =null;
    CallableStatement cs =null;
    ResultSet rs= null;
    PermisoFitosanitarioTransitoInterno pfti = null;
    try{
            con = helper.getConnection();   
        cs= con.prepareCall(sql);    
        cs.setString(1, nroExpediente);
        cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
        cs.registerOutParameter(3, OracleTypes.CURSOR, "SYS_REFCURSOR");
        cs.registerOutParameter(4, OracleTypes.CURSOR, "SYS_REFCURSOR");
        cs.registerOutParameter(5, OracleTypes.CURSOR, "SYS_REFCURSOR");
        cs.registerOutParameter(6, OracleTypes.CURSOR, "SYS_REFCURSOR");
        cs.registerOutParameter(7, OracleTypes.CURSOR, "SYS_REFCURSOR");

        logger.debug(" = voy a ejecutar  OBTENER_DATOS_PFTI = ");

        cs.execute();
        Log(" = ENTRANDO = ");
        rs = (ResultSet)cs.getObject(2);
        pfti=obtenerDatosCabeceraPFTI(rs);
        if(pfti!=null){
          rs=(ResultSet)cs.getObject(3);
          pfti.setProductosPFI(obtenerDatosProductosPFTI(rs));
          
          rs=(ResultSet)cs.getObject(4);
          pfti.setAnexosPFI(obtenerAnexosPFTI(rs));
          
          rs=(ResultSet)cs.getObject(5);
          pfti.setPaisesOrigenProductoPFI(obtenerPaisOrigenProductoPFTI(rs));
          
          //Lugares de Producccion rs=6
          rs= (ResultSet)cs.getObject(6);
          pfti.setLugaresProduccionProductoPFI(obtenerLugaresProduccionPFTI(rs));
          
          rs=(ResultSet)cs.getObject(7);
          pfti.setPuntoIngresoProductoPFI(obtenerPtoIngresoProductoPFTI(rs));
        }        
        logger.debug(" = OBTENIENDO DATOS PFTI FIN= ");
        
    }catch (SQLException e) {
      logger.debug("OBTENER_DATOS_PFTI Error", e);
    } catch (Exception e) {
      logger.debug("OBTENER_DATOS_PFTI Error", e);
    } finally {
      cleanup(con, cs, rs);
    }
    return pfti;
  }

    private PermisoFitosanitarioTransitoInterno obtenerDatosCabeceraPFTI(ResultSet rs)throws SQLException {
      logger.debug(" = OBTENIENDO DATOS DE LA CABECERA INICIO = ");
        PermisoFitosanitarioTransitoInterno pfti=new PermisoFitosanitarioTransitoInterno();
        
        if(rs.next()){
          
          pfti= new PermisoFitosanitarioTransitoInterno();
          pfti.setNroDocumento(rs.getString("Numero_Permiso"));
          pfti.setLugarEmision(rs.getString("Descripcion_Centro_Tramite"));
          pfti.setFechaEmision(Utility.parseDateToString(rs.getTimestamp("Fecha_Emision")));
          pfti.setFechaVigencia(" ");
          pfti.setNombreSolicitante(rs.getString("Nombre_Razon_Social"));
          pfti.setDmclLegalSolicitante(rs.getString("Direccion")==null?" ":rs.getString("Direccion"));
          pfti.setIndicadorAmpliacion(rs.getString("Indicador_Ampliacion"));
          
          pfti.setDocumentoSolicitante(rs.getString("documento_numero"));
          pfti.setCodigoSede(rs.getString("centro_tramite_solicitud"));
          pfti.setNumeroExpediente(rs.getString("codigo_expediente"));
          pfti.setNombreDepartamento("");
          pfti.setNombreProvincia("");
          pfti.setNombreDistrito("");
          
        }
      logger.debug(" = OBTENIENDO DATOS DE LA CABECERA FIN = ");
      return pfti;
    }

    private ArrayList<ProductoPFI> obtenerDatosProductosPFTI(ResultSet rs)throws SQLException {
      logger.debug(" = OBTENIENDO DATOS DE LOS PRODUCTOS INICIO = ");
      //Obteniendo la lista  de productos
      ArrayList<ProductoPFI> xproductos = new ArrayList<ProductoPFI>();
      ProductoPFI productoPFI=null;
        while(rs.next()){
            logger.debug("Seteando datos Productos");
            productoPFI= new ProductoPFI();          
            productoPFI.setPartidaArancelaria(rs.getString("partida"));
            productoPFI.setCodigoProducto(rs.getString("Codigo_Producto"));
            productoPFI.setUsoDestino(rs.getString("Codigo_Aplicacion"));
            productoPFI.setDescripcion(rs.getString("Nombre_Comercial_Producto"));
            productoPFI.setNombreCientifico(rs.getString("Nombre_Cientifico_Producto"));
            productoPFI.setPesoNeto(rs.getDouble("Cantidad_Peso_Permiso"));
            productoPFI.setCantidad(rs.getDouble("Cantidad_Envase"));
            productoPFI.setTipoEnvase(rs.getString("Descripcion_Tipo_Envase"));
            productoPFI.setPaisProcedencia(rs.getString("Codi_Pais_Tpa_Procedencia"));
            productoPFI.setDescPaisProcedencia(rs.getString("Nomb_Pais_Tpa_Procedencia"));          
            productoPFI.setPaisDestino(rs.getString("Codi_Pais_Tpa_Destino"));
            productoPFI.setDescPaisDestino(rs.getString("Nomb_Pais_Tpa_Destino"));
            xproductos.add(productoPFI);
        }
      logger.debug(" = OBTENIENDO DATOS DE LOS PRODUCTOS FIN = ");
      logger.debug("CANTIDAD DE PRODUCTOS: "+xproductos.size());
      return xproductos;
    }

    private ArrayList<AnexoPFI> obtenerAnexosPFTI(ResultSet rs)throws SQLException {
      logger.debug(" = OBTENIENDO DATOS DE LOS ANEXOS INICIO = ");
      ArrayList<AnexoPFI> xanexos = new ArrayList<AnexoPFI>();
      AnexoPFI anexoPFI=null;
      
      while(rs.next()){
        logger.debug("Seteando datos Anexos");
        anexoPFI= new AnexoPFI();          
        anexoPFI.setPartidaArancelaria(rs.getString("partida"));
        anexoPFI.setDescripcion(rs.getString("Nombre_Comercial_Producto"));
        anexoPFI.setNombreCientifico(rs.getString("Nombre_Cientifico_Producto"));
        anexoPFI.setPesoNeto(rs.getDouble("Cantidad_Peso_Permiso"));
        anexoPFI.setCantidad(rs.getDouble("Cantidad_Envase"));
        anexoPFI.setTipoEnvase(rs.getString("Descripcion_Tipo_Envase"));
        anexoPFI.setPaisProcedencia(rs.getString("Nomb_Pais_Tpa_Procedencia"));
        anexoPFI.setPaisDestino(rs.getString("Nomb_Pais_Tpa_Destino"));
        xanexos.add(anexoPFI);
      }
      
      logger.debug(" = OBTENIENDO DATOS DE LOS ANEXOS FIN = ");
      logger.debug("CANTIDAD DE ANEXOS: "+xanexos.size());
      return xanexos;
    }

    private ArrayList<PaisOrigenProductoPFI> obtenerPaisOrigenProductoPFTI(ResultSet rs)throws SQLException {
      logger.debug(" = OBTENIENDO DATOS DE LOS ANEXOS INICIO = ");
      ArrayList<PaisOrigenProductoPFI> xpaisOrgProdPFI= new ArrayList<PaisOrigenProductoPFI>();
      PaisOrigenProductoPFI paisOrgProdPFTI=null;
      
      while(rs.next()){
        logger.debug("Seteando datos Pais de Origen");
        paisOrgProdPFTI= new PaisOrigenProductoPFI();
        paisOrgProdPFTI.setPaisOrigenProducto(rs.getString(2));
        paisOrgProdPFTI.setDescPaisOrigenProducto(rs.getString(3));        
        xpaisOrgProdPFI.add(paisOrgProdPFTI);
      }
      
      logger.debug(" = OBTENIENDO DATOS DE LOS PAISES DE ORIGEN FIN = ");
      logger.debug("CANTIDAD DE PAISES DE ORIGEN: "+xpaisOrgProdPFI.size());
      return xpaisOrgProdPFI;
    }

    private ArrayList<PuntoIngresoProductoPFI> obtenerPtoIngresoProductoPFTI(ResultSet rs)throws SQLException {
      logger.debug(" = OBTENIENDO DATOS DE LOS PUNTOS DE INGRESO = ");
      ArrayList<PuntoIngresoProductoPFI> xptoIngrProdPFTI= new ArrayList<PuntoIngresoProductoPFI>();
      PuntoIngresoProductoPFI ptoIngrProdPFTI=null;
      
      while(rs.next()){
        logger.debug("Seteando datos Puntos de Ingreso");
        ptoIngrProdPFTI= new PuntoIngresoProductoPFI();          
        ptoIngrProdPFTI.setPuntoIngresoProducto(rs.getString("Descripcion_Centro_Tramite_Ing"));
        ptoIngrProdPFTI.setPuntoSalidaProducto(rs.getString("Descripcion_Centro_Tramite_Sal"));
        xptoIngrProdPFTI.add(ptoIngrProdPFTI);
      }
      
      logger.debug(" = OBTENIENDO DATOS DE LOS PUNTOS DE INGRESO FIN = ");
      logger.debug("CANTIDAD DE Puntos de Ingreso: "+xptoIngrProdPFTI.size());
      return xptoIngrProdPFTI;
    }

    private ArrayList<LugarProduccionProductoPFI> obtenerLugaresProduccionPFTI(ResultSet rs) throws SQLException {
      logger.debug(" = OBTENIENDO DATOS DE LOS LUGARES DE PRODUCCION = ");
      ArrayList<LugarProduccionProductoPFI> xlugarProdPFTI = new ArrayList<LugarProduccionProductoPFI>();
      LugarProduccionProductoPFI lgrProdPFTI = null;
      
      while(rs.next()){
        logger.debug("Seteando datos Puntos de los Lugares de Produccion");
        lgrProdPFTI = new LugarProduccionProductoPFI();
        lgrProdPFTI.setLugarProduccionProducto(rs.getString("Codigo_Lugar_Produccion"));
        lgrProdPFTI.setDescLugarProduccion(rs.getString("Descripcion_Lugar_Produccion"));
        xlugarProdPFTI.add(lgrProdPFTI);  
      }
      logger.debug(" = OBTENIENDO DATOS DE LOS LUGARES DE PRODUCCION FIN = ");
      logger.debug("CANTIDAD DE Puntos de Lugares de Produccion: "+xlugarProdPFTI.size());
          
      return xlugarProdPFTI;
    }
    
  public List<AdjuntoDocumentoVuce> obtenerAdjuntosVuce(String numeroOrden) {

    String sql = SenasaSQL.OBTENER_ADJUNTOS_VUCE;

    logger.debug("numeroOrden: " + numeroOrden);

    Log(" AQUI VA EL " + sql);

    Connection con = null;
    PreparedStatement pst = null;
    CallableStatement cs = null;

    List<AdjuntoDocumentoVuce> retval = new ArrayList<AdjuntoDocumentoVuce>();
    msgErr = "";
    try {
            con = helper.getConnection();  
      cs = con.prepareCall(sql);

      cs.setString(1, numeroOrden);
      cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");

      logger.debug(" = voy a ejecutar  OBTENER_ADJUNTOS_VUCE = ");

      cs.execute();
      Log(" = ENTRANDO = ");
      ResultSet rs = (ResultSet)cs.getObject(2);
      logger.debug("Se ejecuto OBTENER_ADJUNTOS_VUCE");
        AdjuntoDocumentoVuce b = null;
        while (rs.next()) {
            b = new AdjuntoDocumentoVuce();
            b.setId(rs.getLong("id"));
            b.setIdDocumento(rs.getLong("id_documento"));
            b.setIdRequisito(rs.getString("id_requisito"));
            b.setNombre(rs.getString("nombre"));
            b.setUcmId(rs.getString("ucm_id"));
            b.setEstado(rs.getString("estado_registro"));
            retval.add(b);
        }
    } catch (SQLException e) {
      Log("OBTENER_ADJUNTOS_VUCE", e);
      msgErr = e.getMessage();
    } catch (Exception e) {
      Log("OBTENER_ADJUNTOS_VUCE", e);
      msgErr = e.getMessage();
    } finally {
      cleanup(con, pst, null);
    }
    return retval;
  }
  //PSIFUENTES 13/08/2015
  public PermisoFitosanitarioTransitoInterno cargarDatosPFTI(String nroExpediente){
    logger.debug("CARGAR_DATOS_PFTI INICIANDO");   
    String sql = SenasaSQL.CARGAR_DATOS_PFTI;
    logger.debug("Sentencia SQL: "+sql);
    
    Connection con =null;
    CallableStatement cs =null;
    ResultSet rs= null;
    PermisoFitosanitarioTransitoInterno pfti = null;
    try{
            con = helper.getConnection();   
        cs= con.prepareCall(sql);    
        cs.setString(1, nroExpediente);
        cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
        cs.registerOutParameter(3, OracleTypes.CURSOR, "SYS_REFCURSOR");
        cs.registerOutParameter(4, OracleTypes.CURSOR, "SYS_REFCURSOR");
        cs.registerOutParameter(5, OracleTypes.CURSOR, "SYS_REFCURSOR");
        cs.registerOutParameter(6, OracleTypes.CURSOR, "SYS_REFCURSOR");
        cs.registerOutParameter(7, OracleTypes.CURSOR, "SYS_REFCURSOR");
        cs.registerOutParameter(8, OracleTypes.CURSOR, "SYS_REFCURSOR");

        logger.debug(" = voy a ejecutar  CARGAR_DATOS_PFTI = ");

        cs.execute();
        Log(" = ENTRANDO = ");
        rs = (ResultSet)cs.getObject(2);
        pfti=cargarDatosCabeceraPFTI(rs);
        if(pfti!=null){
          rs=(ResultSet)cs.getObject(3);
          pfti.setProductosPFI(cargarDatosProductosPFTI(rs));    
          
          rs=(ResultSet)cs.getObject(4);
          pfti.setAnexosPFI(obtenerAnexosPFTI(rs));
          
          rs=(ResultSet)cs.getObject(5);
          pfti.setPaisesOrigenProductoPFI(obtenerPaisOrigenProductoPFTI(rs));
          
          //Lugares de Producccion rs=6
          rs= (ResultSet)cs.getObject(6);
          pfti.setLugaresProduccionProductoPFI(obtenerLugaresProduccionPFTI(rs));
          
          rs=(ResultSet)cs.getObject(7);
          pfti.setPuntoIngresoProductoPFI(cargarPtoIngresoProductoPFTI(rs));
          
          rs=(ResultSet)cs.getObject(8);
          pfti.setSolicitante(obtSolicitantePFTI(rs));
          //pfti.setSolicitante(null);
        }        
        logger.debug(" = CARGAR DATOS PFTI FIN= ");
        
    }catch (SQLException e) {
      logger.debug("CARGAR_DATOS_PFTI Error", e);
    } catch (Exception e) {
      logger.debug("CARGAR_DATOS_PFTI Error", e);
    } finally {
      cleanup(con, cs, rs);
    }
    return pfti;
  }
  
  private PermisoFitosanitarioTransitoInterno cargarDatosCabeceraPFTI(ResultSet rs)throws SQLException {
    logger.debug(" = OBTENIENDO DATOS DE LA CABECERA INICIO = ");
      PermisoFitosanitarioTransitoInterno pfti=new PermisoFitosanitarioTransitoInterno();
      
      if(rs.next()){
        
        pfti= new PermisoFitosanitarioTransitoInterno();
        pfti.setNroDocumento(rs.getString("Numero_Permiso"));
        pfti.setLugarEmision(rs.getString("Descripcion_Centro_Tramite"));
        pfti.setFechaEmision(Utility.parseDateToString(rs.getTimestamp("Fecha_Emision")));
        pfti.setFechaVigencia(" ");
        pfti.setCodigoSede(rs.getString("centro_tramite_solicitud"));
        pfti.setNumeroExpediente(rs.getString("codigo_expediente"));
        pfti.setCodigoRequImpoProducto(rs.getString("codigo_requ_tran_producto"));
      }
    logger.debug(" = CARGANDO DATOS DE LA CABECERA FIN = ");
    return pfti;
  }
  
  private ArrayList<ProductoPFI> cargarDatosProductosPFTI(ResultSet rs)throws SQLException {
    logger.debug(" = CARGANDO DATOS DE LOS PRODUCTOS INICIO = ");
    //Obteniendo la lista  de productos
    ArrayList<ProductoPFI> xproductos = new ArrayList<ProductoPFI>();
    ProductoPFI productoPFI=null;
      while(rs.next()){
          logger.debug("Seteando datos Productos");
          productoPFI= new ProductoPFI();          
          
      /*    productoPFI.setPartidaArancelaria(rs.getString("partida"));
          productoPFI.setCodigoProducto(rs.getString("Codigo_Producto"));
          productoPFI.setUsoDestino(rs.getString("Codigo_Aplicacion"));          
          productoPFI.setDescripcion(rs.getString("Nombre_Comercial_Producto"));
          productoPFI.setNombreCientifico(rs.getString("Nombre_Cientifico_Producto"));
          //  productoPFI.setPesoNeto(rs.getDouble("Cantidad_Peso_Permiso"));
          //   productoPFI.setPesoNeto(Utility.TryParseDouble("Cantidad_Peso_Permiso"));
          productoPFI.setPesoNeto(rs.getDouble("Cantidad_Peso_Permiso"));
          productoPFI.setCantidad(rs.getDouble("Cantidad_Envase"));
          productoPFI.setTipoEnvase(rs.getString("Codigo_Tipo_Envase"));
          productoPFI.setPaisProcedencia(rs.getString("Codi_Pais_Tpa_Procedencia"));
          productoPFI.setDescPaisProcedencia(rs.getString("Nomb_Pais_Tpa_Procedencia"));
          productoPFI.setPaisDestino(rs.getString("Codi_Pais_Tpa_Destino"));
          productoPFI.setDescPaisDestino(rs.getString("Nomb_Pais_Tpa_Destino"));          
          productoPFI.setDesTipoEnvase(rs.getString("Descripcion_Tipo_Envase"));
          //productoPFI.setCantidad(Utility.TryParseDouble("Cantidad_Envase"));
         // System.out.println("cantidad de envase:" + productoPFI.getCantidad() );
          productoPFI.setCodUniMed(rs.getString("Codi_Unid_Med"));
          productoPFI.setDescUniMed(rs.getString("desc_unid_med"));
          productoPFI.setDesTipoEnvase(rs.getString("descripcion_tipo_envase")); */          
              
          productoPFI.setPartidaArancelaria(rs.getString("partida"));
          productoPFI.setCodigoProducto(rs.getString("Codigo_Producto"));
          productoPFI.setUsoDestino(rs.getString("Codigo_Aplicacion"));
          productoPFI.setDescripcion(rs.getString("Nombre_Comercial_Producto"));
          productoPFI.setNombreCientifico(rs.getString("Nombre_Cientifico_Producto"));
          productoPFI.setPesoNeto(rs.getDouble("Cantidad_Peso_Permiso"));
          productoPFI.setCantidad(rs.getDouble("Cantidad_Envase"));
          //productoPFI.setTipoEnvase(rs.getString("Descripcion_Tipo_Envase"));
          productoPFI.setTipoEnvase(rs.getString("Codigo_Tipo_Envase"));
          productoPFI.setDesTipoEnvase(rs.getString("Descripcion_Tipo_Envase"));
          productoPFI.setPaisProcedencia(rs.getString("Codi_Pais_Tpa_Procedencia"));
          productoPFI.setDescPaisProcedencia(rs.getString("Nomb_Pais_Tpa_Procedencia"));          
          productoPFI.setPaisDestino(rs.getString("Codi_Pais_Tpa_Destino"));
          productoPFI.setDescPaisDestino(rs.getString("Nomb_Pais_Tpa_Destino"));
          xproductos.add(productoPFI);
      }
    logger.debug(" = OBTENIENDO DATOS DE LOS PRODUCTOS FIN = ");
    logger.debug("CANTIDAD DE PRODUCTOS: "+xproductos.size());
    return xproductos;
  }
 
  private ArrayList<Solicitante> obtSolicitantePFTI(ResultSet rs)throws SQLException {
    logger.debug(" = CARGANDO DATOS DEL SOLICITANTE = ");
    ArrayList<Solicitante> xsolicitante= new ArrayList<Solicitante>();
    Solicitante solicitante=null;
    
    while(rs.next()){
      logger.debug("Seteando datos Puntos de Ingreso");
      solicitante= new Solicitante();          
      solicitante.setCodigoSolicitante(rs.getString("persona_id"));
      solicitante.setTipoSolicitante(rs.getString("persona_tipo"));
      solicitante.setDniRuc(rs.getString("documento_numero"));
      solicitante.setTipoDocumento(rs.getString("documento_tipo"));
      solicitante.setNombreRazonSocial(rs.getString("nombre_razon_social"));
      solicitante.setDomicilioLegal(rs.getString("direccion"));
      solicitante.setTelefono(rs.getString("telefono"));
      solicitante.setTelefonoMovil(rs.getString("telefono_movil"));
      solicitante.setEmail(rs.getString("correo_electronico"));
      solicitante.setDepartamento(rs.getString("departamento_id"));
      solicitante.setProvincia(rs.getString("provincia_id"));
      solicitante.setDistrito(rs.getString("distrito_id"));
      solicitante.setNombreDepartamento(rs.getString("departamento_nombre"));
      solicitante.setNombreProvincia(rs.getString("provincia_nombre"));
      solicitante.setNombreDistrito(rs.getString("distrito_nombre"));    
      xsolicitante.add(solicitante);
    }
    
    logger.debug(" = CARGANDO DATOS DE LOS PUNTOS DE INGRESO FIN = ");
    logger.debug("CANTIDAD DE Puntos de Ingreso: "+xsolicitante.size());
    return xsolicitante;
  }  
 
  private ArrayList<PuntoIngresoProductoPFI> cargarPtoIngresoProductoPFTI(ResultSet rs)throws SQLException {
    logger.debug(" = CARGANDO DATOS DE LOS PUNTOS DE INGRESO = ");
    ArrayList<PuntoIngresoProductoPFI> xptoIngrProdPFTI= new ArrayList<PuntoIngresoProductoPFI>();
    PuntoIngresoProductoPFI ptoIngrProdPFTI=null;
    
    while(rs.next()){
      logger.debug("Seteando datos Puntos de Ingreso");
      ptoIngrProdPFTI= new PuntoIngresoProductoPFI();          
      ptoIngrProdPFTI.setPuntoIngresoProducto(rs.getString("Codigo_Centro_Tramite_Ing"));
      ptoIngrProdPFTI.setDescPuntoIngresoProducto(rs.getString("Descripcion_Centro_Tramite_Ing"));
      ptoIngrProdPFTI.setPuntoSalidaProducto(rs.getString("Codigo_Centro_Tramite_Sal"));
      ptoIngrProdPFTI.setDescPuntoSalidaProducto(rs.getString("Descripcion_Centro_Tramite_Sal"));
      xptoIngrProdPFTI.add(ptoIngrProdPFTI);
    }
    
    logger.debug(" = CARGANDO DATOS DE LOS PUNTOS DE INGRESO FIN = ");
    logger.debug("CANTIDAD DE Puntos de Ingreso: "+xptoIngrProdPFTI.size());
    return xptoIngrProdPFTI;
  }  

  
  public String obtenerUcmidPorExpediente(String nroExpediente){
  
    String sql = SenasaSQL.OBTENER_UCMID_POR_EXPEDIENTE;
    logger.debug("Iniciando obtenerUcmidPorExpediente()");
    Log("obtenerUcmidPorExpediente() AQUI VA EL " + sql);

    Connection con = null;
    PreparedStatement pst = null;
    CallableStatement cs = null;

    String retval = null;
    msgErr = "0";
    try {
            con = helper.getConnection();  
      cs = con.prepareCall(sql);

      cs.setString(1, nroExpediente);
      cs.registerOutParameter(2, Types.VARCHAR);

      Log(" = ANTES DE EJECUTAR = ");
      cs.execute();

      Log(" = YA EJECUTE = ");
      retval = cs.getString(2).equals("null") ? "":cs.getString(2);
      System.out.println("Longitud retval:"+retval.length());  

      logger.debug("obtenerUcmidPorExpediente() Obteniendo UCM id: " + retval);
      Log(" = FIN TODITO = ");
    } catch (SQLException e) {
      Log("obtenerUcmidPorExpediente", e);
      msgErr = e.getMessage();
    } catch (Exception e) {
      Log("obtenerUcmidPorExpediente", e);
      msgErr = e.getMessage();
    } finally {
      cleanup(con, pst, null);
    }
    return retval;
      
  }
    
    
  public void actualizarCodigoProcTupaCPE(String pcodexpediente,String ordenvuce, String codproctupa){
        
    String sql = SenasaSQL.ACTUALIZAR_CODIGO_TUPA_CPE;
    Log(" AQUI VA EL " + sql);
    Connection con = null;
    PreparedStatement pst = null;
    CallableStatement cs = null;


    try {
            con = helper.getConnection();
      cs = con.prepareCall(sql);
      cs.setString(1, pcodexpediente);
      cs.setString(2, ordenvuce);
      cs.setString(3, codproctupa);
     
      Log(" = ANTES DE EJECUTAR = ");
      cs.execute();
      String verificar= DocumentosPresentadosVuce(ordenvuce);
      Log(" = YA EJECUTE = "+verificar);
   

    } catch (SQLException e) {
      Log("ActualizarCodProcTupa ", e);
      msgErr = e.getMessage();
    } catch (Exception e) {
      Log("ActualizarCodProcTupa ", e);
      msgErr = e.getMessage();
    } finally {
      cleanup(con, pst, null);
    }
    }
  
  public String DocumentosPresentadosVuce(String ordenvuce) {
    
    String sql = SenasaSQL.ADJUNTAR_DOCUMENTOS_PRESENTADOS;

    Connection con = null;
    CallableStatement cs = null;
    String retval = "";
   
    try {
            con = helper.getConnection();
        cs = con.prepareCall(sql);
        cs.registerOutParameter(1, OracleTypes.VARCHAR);
        cs.setString(2,ordenvuce);
        cs.execute();
       
        retval = cs.getString(1);
        
        logger.debug(" = TODO FINITO = ");
    } catch (SQLException e) {
        Log("adjuntarDocumentosPresentados", e);
    } catch (Exception e) {
        Log("adjuntarDocumentosPresentados", e);
    } finally {
            cleanup(con, cs);
    }
    return retval;
  }
  
  public int  ValidarConfidencial(String codigo, String Usuario) {
    String sql = SenasaSQL.VALIDAR_CONFIDENCIAL01;
    String sql2 = SenasaSQL.VALIDAR_CONFIDENCIAL02;
    Connection con = null; //ConnectionSenasa.getSingletonObject().getConnection();
    CallableStatement cs =null;
    CallableStatement cs1 =null;
    ResultSet rs= null;
    ResultSet rs1= null;
    String codstd="";
    String Confi="";
    int confidencial=1;
    try {
            con = helper.getConnection();
      cs= con.prepareCall(sql);
      cs.setString(1, codigo);
      cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
      cs.execute();
      Log(" = ENTRANDO = ");
      rs = (ResultSet)cs.getObject(2);
      logger.debug("Se ejecuto OBTENER_DATOS_GUARDACUSTODIA");
        if(rs != null && rs.next()){
      codstd= rs.getString("Codigo_Std_Doc");
      Confi= rs.getString("Confidencial"); 
        }
        if(Confi.equals("S")){  
      cs1= con.prepareCall(sql2);
      cs1.registerOutParameter(1, OracleTypes.INTEGER);
      cs1.setString(2, codstd);
      cs1.setString(3, Usuario);
      cs1.execute();
      confidencial = cs1.getInt(1);
        }else if(Confi.equals("N")){
            confidencial=1;
        }else{
              confidencial=1;
            }
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }finally {
            cleanup(con, cs);
    }
    return confidencial;
  } 
  
  public String obtenerPasswordFirmante(String codiusuausu)
    {
      String sql = SenasaSQL.OBTENER_PASSWORD_FIRMANTE_ELECTRONICO;
      Log("obtenerPasswordFirmante(): AQUI VA EL " + sql);
      Connection con = null;
      PreparedStatement pst = null;
      CallableStatement cs = null;
      ResultSet rs = null;
      String passFirmante = "";
      String ucmidFirmante = "";
      try
      {
            con = helper.getConnection();
        pst = con.prepareStatement(sql);
        cs = con.prepareCall(sql);
        
        cs.setString(1, codiusuausu);
        cs.registerOutParameter(2, OracleTypes.CURSOR, "SYS_REFCURSOR");
        cs.executeQuery();
        rs = (ResultSet)cs.getObject(2);
        while (rs.next())
        {
          passFirmante = rs.getString(1);
          ucmidFirmante = rs.getString(2);
        }
      }
      catch (SQLException e)
      {
        Log("obtenerPasswordFirmante", e);
      }
      catch (Exception e)
      {
        Log("obtenerPasswordFirmante", e);
      }
      finally
      {
        cleanup(con, pst, rs);
      }
      return passFirmante + "]]]" + ucmidFirmante;
    }
  
  public String createQR(String data )
  {
    int size=150;
      BitMatrix matrix;
      Writer writer = new MultiFormatWriter();
      try {            
          EnumMap<EncodeHintType,String> hints = new EnumMap<EncodeHintType,String>(EncodeHintType.class);
          hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");            
          matrix = writer.encode(data, BarcodeFormat.QR_CODE, size, size, hints);
          ByteArrayOutputStream output = new ByteArrayOutputStream();
          MatrixToImageWriter.writeToStream(matrix, "PNG", output);
          byte[] data_array = output.toByteArray();
          Base64.encode(data_array);            
          return  Base64.encode(data_array);
      } catch (com.google.zxing.WriterException ex) {
          System.err.println(ex.getMessage());
        return "";
      } catch (IOException ex) {
          System.err.println(ex.getMessage());
          return "";
              
      }
     
  }
 
}
