package pe.gob.senasa.ws.documentoStd.sql;


public class SQLHelper {
    public static final String DATA_SOURCE_SENASA = "pruebaDS";
    public static final String CREAR_DOCUMENTO = "{ ?=call Pckg_Documento_STD.Fn_Crear_Documento(?,?,?,?) }";
    public static final String  CONSULTA_GENERAL = "{call Pckg_Documento_Std.Sp_Consulta_General(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    public static final String  CONSULTA_PENDIENTES = "{call Pckg_Documento_Std.Sp_Consulta_Pendientes(?,?,?,?,?,?,?,?)}";
    public static final String  REPORTE_GENERAL = "{call Pckg_Documento_Std.Sp_ConsultaSTDGeneral(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    
    public static final String REGISTRAR_DOCUMENTO =  "{ call Pckg_Documento_Std.Sp_Registrar_Documento(?,?,?,?,?,?,?,?,?,?,?) }";
    public static final String ACTUALIZAR_DOCUMENTO = "{ call Pckg_Documento_STD.Sp_Actualizar_Documento(?,?,?,?,?,?,?) }";/*RCF*/
    public static final String GRABAR_DOC_REGISTRO_ARCHIVO = "{ call PCKG_GRABAR.Sp_sys_registro_archivo(?,?,?,?) }";
    public static final String GRABAR_DOC_ANEXO = "{ call PCKG_GRABAR.Sp_Grabar_Documento_Anexo(?,?,?,?,?,?) }";
    public static final String GRABAR_RESOLUTIVO_PROV = "{ call PCKG_GRABAR.Sp_Grabar_Resolutivo_Prov(?,?,?,?,?,?,?,?,?,?) }";
    
    public static final String CONSULTAR_PARTICIPACION = "{ ?=call Pckg_Documento_STD.Fn_Consultar_Participacion(?,?) }";
}
