package pe.gob.senasa.dbtypes;

import java.io.Serializable;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.sql.Datum;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.StructDescriptor;

import pe.gob.senasa.bean.SIIMF;


public class SolicitudSiimf implements ORAData, ORADataFactory,Serializable {
    
    private static final long serialVersionUID = 0L;
    
    private SIIMF siimf;
    
    public static final String SQL_TYPE = "SIGSVE.SOLICITUDUCDSA";

    public SolicitudSiimf() {
        super();
    }
    
    public SolicitudSiimf(SIIMF siimf)
    {
        super();
    }

    public Datum toDatum(Connection connection) throws SQLException {
        StructDescriptor desc = new StructDescriptor(this.SQL_TYPE,connection);
        
       /* STRUCT struct =  new STRUCT(desc,connection,new Object[]{   
        "ACTIVO",
        null,
        siimf.getCodigoCentroTramite(),
        "BPM",
        siimf.getCodigoExpediente(),
        siimf.get,
        this.razonSocial,
        this.tipo,
        this.tipoVigilancia,
        this.programa,
        this.sede,
        this.empleado,
        this.cliente});
        return struct;
        */

        return null;
    }

    public ORAData create(Datum datum, int i) {
        return null;
    }
}
