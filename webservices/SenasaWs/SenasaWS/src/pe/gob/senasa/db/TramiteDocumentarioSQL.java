package pe.gob.senasa.db;

public class TramiteDocumentarioSQL {

    public static final String REGISTRAR_DOCUMENTO_STD =  "{ CALL Pckg_Documento_Std.Sp_Registrar_Documento(?,?,?,?,?,?,?,?,?,?,?) }";
    public static final String ACTUALIZAR_DOCUMENTO_STD =  "{ CALL Pckg_Documento_Std.Sp_Actualizar_Documento(?,?,?,?) }";
    public static final String ACTUALIZAR_ARCHIVO_STD =  "{ CALL Pckg_Documento_Std.Sp_Actualizar_Archivo(?,?,?,?,?) }";
    public static final String ELIMINAR_DOCUMENTO_ADJUNTO_STD =  "{ CALL Pckg_Documento_Std.Sp_Eliminar_Adjunto(?,?) }";
    public static final String ELIMINAR_DOCUMENTO_STD =  "{ CALL Pckg_Documento_Std.Sp_Eliminar_Documentostd(?,?) }";
    public static final String ELIMINAR_NUMERACION_DOCUMENTO_STD =  "{ CALL Pckg_Documento_Std.Sp_Eliminar_Numeracion(?,?,?,?) }";
    public static final String OBTENER_DOCUMENTO_ADJUNTO_STD =  "{ CALL Pckg_Documento_Std.Sp_Obtener_Adjuntos(?,?) }";
    public static final String VERIFICAR_PARTICIPACION_STD =  "{ CALL Pckg_Documento_Std.Sp_Verificar_Acceso_Documento(?,?,?) }";
    
    public static final String CONSULTA_DOCUMENTOS_GENERALES = "{call Pckg_Documento_Std.Sp_ConsultaSTDGeneral(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    public static final String CONSULTA_DOCUMENTOS = "{call Pckg_Documento_Std.Sp_ConsultaDocumentos(?,?)}";
    public static final String CONSULTA_TRAZABILIDAD_FINAL = "{call Pckg_Documento_Std.Sp_ConsultaTrazaxIdFinal(?,?)}";
    
    public static final String OBTENER_ENCARGATURA = "{call Pckg_Usuario.Sp_Obtener_Encargatura(?,?)}";
    public static final String OBTENER_ENCARGADO = "{call Pckg_Usuario.Sp_Obtener_Encargado(?,?)}";
    
    public static final String OBTENER_EXPEDIENTE = "{call Pckg_Expediente.Sp_Obtener_Expediente(?,?)}";
    public static final String OBTENER_DOCUMENTO = "{call Pckg_Documento_Std.Sp_Obtener_Documento_Numero(?,?,?)}";
    public static final String OBTENER_SUBTIPO_DOC_MP = "{call Pckg_Documento_Std.Sp_Obtener_Subtipos_Mp(?)}";
    
    // INTEGRACION MINAG
    public static final String OBTENER_BANDEJA_ELECTRONICA = "{call Integrador_Std.Pckg_Documento.Sp_Obtener_Bandeja(?)}";
    public static final String PROCESAR_DOCUMENTO = "{ CALL Integrador_Std.Pckg_Documento.Sp_Procesar_Documento(?,?,?,?,?) }";
    
    //ELIMINAR
    public static final String REGISTRAR_EXPEDIENTE_STD = "{call Pckg_Expediente.Sp_Registrar(?,?,?,?,?,?,?)}";
    public static final String ANEXAR_DOCUMENTO_EXPEDIENTE = "{call Pckg_Documento_Std.Sp_Anexar_Documento_Expediente(?,?,?)}";
}
