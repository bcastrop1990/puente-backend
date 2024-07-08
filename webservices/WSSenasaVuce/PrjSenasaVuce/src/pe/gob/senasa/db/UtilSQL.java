package pe.gob.senasa.db;

public class UtilSQL {
    public UtilSQL() {
        super();
    }

    public static final String GET_DOC_ADJUNTO =
        "{ call Pckg_Documento_Vuce.Sp_Get_DocAdjunto(?,?)}";

    // public static final String ACEPTAR_ORDEN="{?= call Pckg_Gestion_Orden.Fn_Aceptar(?,?)}";//N2 Y DOCUMENT
    //public static final String SUBSANAR_ORDEN="{?= call Pckg_Gestion_Documento.Fn_Subsanar(?,?)}";//N11
    //public static final String APROBAR_SUCE= "{?= call Pckg_Notificaciones_Vuce.Fn_Aprobacion_Suce(?,?)}";//N8

    public static final String NOTIF_SUBSANAR =
        "{?= call Pckg_Documento_Vuce.Fn_SendNotif(?,?,?,?)}";
    
    public static final String NOTIF_ENVIOREQPAGOSUCE =
        "{call FINALBPM.Pckg_Grabar.Sp_Enviar_Pago_Vuce(?, ?, ?)}";

    public static final String NOTIF_ENVIOPAGOSUCE =
        "{?= call Pckg_Documento_Vuce.Fn_SendNotifPagoSuce(?,?,?,?,?)}";

    public static final String NOTIF_RPTAPAGOSUCE =
        "{?= call Pckg_Documento_Vuce.Fn_VerificaPagoCdaSuce(?)}";

    public static final String ENVIAR_NOTIFICACION =
        "{call Pckg_Notificaciones_Vuce.Sp_Registrar_Notificacion(?,?,?,?,?,?,?,?,?,?,?,?,?)}";

    public static final String CIERRE_TRAMITE =
        "{call Pckg_Documento_Vuce.Sp_CierreTramite(?,?,?,?,?,?)}";

    public static final String GET_CONSULTA_TECNICA =
        "{call FINALBPM.Pckg_Consulta_Tecnica.Sp_Consultar_Con_Tec(?,?,?,?,?,?)}";

    public static final String INS_RPTA_CONSULTA_TECNICA =
        "{call FINALBPM.Pckg_Consulta_Tecnica.Sp_Insertar_Con_Tec_Resp(?,?,?,?,?,?)}";

    public static final String CONSULTA_SOLIC_PLANTA =
        "{call SIIMF.pckg_bpm_planta.sp_consultar_solicitud_planta(?,?,?)}";

    public static final String CONSULTA_SOLIC_LUGARPROD =
        "{call SIIMF.pckg_bpm_lugar_prod.sp_consultar_solicitud_lugar(?,?,?,?,?)}";

    public static final String CONSULTA_INSPECCION_PROD =
        "{call  Pckg_Inspeccion.Sp_Consultar_Productos_Exped(?,?)}";

    public static final String DATOS_SOLICITANTE =
        "{call  Pckg_General.Sp_Obtener_Solicitante(?,?)}";

    public static final String CONSULTA_INSPECCION_CONCEPTO =
        "{call  Pckg_Inspeccion.Sp_Consultar_Concepto(?,?)}";

    public static final String CONSULTA_INSPECCION_LOTE =
        "{call  Pckg_Inspeccion.Sp_Consultar_Lote(?,?)}";

    public static final String CONSULTA_DATOSIIVF_VUCE =
        "{call  Pckg_Servicio_SNS009.Sp_Obtener_Datos(?,?,?,?)}";

    public static final String CONSULTA_DATOSIIVZ_VUCE =
        "{call  Pckg_Servicio_SNS010.Sp_Obtener_Datos(?,?,?,?)}";

    public static final String CONSULTA_DATOSEXPOF_VUCE =
        "{call  Pckg_Servicio_SNS022.Sp_Obtener_Datos(?,?,?)}";

    public static final String CONSULTA_DATOSEXPOFMOD_VUCE =
        "{call  Pckg_Servicio_SNS023.Sp_Obtener_Datos(?,?,?)}";

    public static final String CONSULTA_DATOSEXPOZOO_VUCE =
        "{call  Pckg_Servicio_SNS016.Sp_Obtener_Datos(?,?,?)}";

    public static final String OBTENER_DATOS_EXPEDIENTE =
        "{CALL Pckg_Expediente.Sp_Obtener_Expediente(?,?)}";
    
    public static final String OBTENER_CERTIFICADO_XML =
        "{CALL IED_SENASA.Pckg_Ap_Cev.Sp_Generar(?,?,?,?)}";

    public static final String OBTENER_PASSWORD_FIRMANTE_ELECTRONICO = "{ call FINALBPM.Pckg_Firma_Electronica.sp_obtener_password_firmador(?, ?) }";
    
    public static final String NOTIF_PROGRAMACION_INSPECCION = "{ ?=call VUCE.Pckg_Notificaciones_Vuce.Fn_Notificar_Prog_Inspeccion(?,?,?,?,?,?) }";

    public static final String REGISTRAR_CERTIFICADO_XML = "{CALL IED_SENASA.Pckg_Ap_Cev.Sp_Registrar(?,?,?)}";
}
