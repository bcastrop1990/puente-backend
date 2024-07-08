package pe.gob.senasa.ws.trazabilidad.sql;


public class SQLHelper {
    public static final String DATA_SOURCE_SENASA = "pruebaDS";
    public static final String INSERTAR_TRAZABILIDAD = "call Finalbpm.Pckg_Trazabilidad.Sp_Insertar(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String ACTUALIZAR_TRAZABILIDAD = "call Finalbpm.Pckg_Trazabilidad.Sp_Actualizar(?,?,?)";
}
