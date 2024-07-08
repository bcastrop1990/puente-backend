package pe.gob.senasa.ws.expediente.sql;


public class SQLHelper {
    public static final String DATA_SOURCE_SENASA = "pruebaDS";
    public static final String OBTENER_EXPEDIENTE_STD = "{call Pckg_Expediente.Sp_Obtener_Expediente(?,?)}";
    public static final String OBTENER_EXPEDIENTE_VUCE = "{call Pckg_Expediente.Sp_Obtener_Datos_Expediente(?,?)}";
    public static final String OBTENER_EXPEDIENTE_TUPA = "{call Pckg_Expediente.Sp_Obtener_Datos_Exp_Adic(?,?)}";
    public static final String REGISTRAR_EXPEDIENTE_STD = "{call Pckg_Expediente.Sp_Registrar(?,?,?,?,?,?,?)}";
    public static final String REGISTRAR_TRAZA_TUPA_INICIO = "{call Pckg_Expediente.Sp_Registrar_Traza_Tupa_Inicio(?,?,?,?)}";
    public static final String ANEXAR_DOCUMENTO_EXPEDIENTE = "{call Pckg_Documento_Std.Sp_Anexar_Documento_Expediente(?,?,?)}";
    public static final String CIERRE_TOTAL = "{call Senasa.pckg_CERRAR_EXPEDIENTE.SP_CERRAR_TOTAL(?,?,?)}";
    public static final String GRABAR_DOCUMENTO_RESOLUTIVO = "{call Pckg_Grabar.Sp_Grabar_Resolutivo(?,?,?,?,?,?,?)}";
    
  public static final String OBTENER_ORDEN_POR_MTO = "{call Pckg_General.Sp_Get_Orden_Por_MTO(?,?)}";
  

}
