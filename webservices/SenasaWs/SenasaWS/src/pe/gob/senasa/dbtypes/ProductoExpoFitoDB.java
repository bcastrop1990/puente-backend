package pe.gob.senasa.dbtypes;

import java.io.Serializable;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

import pe.gob.senasa.bean.ProductoExpoFito;


public class ProductoExpoFitoDB extends ProductoExpoFito implements Serializable ,SQLData{
    
    public static final String SQL_TYPE="FINALBPM.T_PRODUCTO_EXP_FITO";//"Finalbpm.t_Producto_Exp_Fito";
    public static final String SQL_TYPE_ARRAY="FINALBPM.T_PRODUCTO_EXP_FITO_ARRAY";//"Finalbpm.t_Producto_Exp_Fito_Array";
    
    public static final String SQL_TYPE_ANX="FINALBPM.T_PRODUCTO_EXP_FITO_ANX";//"Finalbpm.t_Producto_Exp_Fito_Anx";
    public static final String SQL_TYPE_ARRAY_ANX="FINALBPM.T_PRODUCTO_EXP_FITO_ANX_ARRAY";//"Finalbpm.t_Producto_Exp_Fito_Anx_Array";

    private static final long serialVersionUID = -2137097007209083238L;
    
    private String type;

    public ProductoExpoFitoDB() {
        super();
    }

    public String getSQLTypeName()
    {
        return getType();
    }

    public void readSQL(SQLInput stream, String typeName)
    {
        
    }

    public void writeSQL(SQLOutput stream)  throws SQLException
    {
                stream.writeString(getCodigoCertificadoFitoExpo());
                stream.writeString(getSecuencialProducto());
                stream.writeString(getCodiUnidMed());
                stream.writeString(getCodigoTipoEnvase());
                stream.writeString(getCantidadPeso());
                stream.writeString(getCodigoProducto());
                stream.writeString(getCantidadEnvase());
                stream.writeString(getCultivarId());
                stream.writeString(getMarcaDistintiva());
                stream.writeString(getEstado());
                stream.writeString(getPersonaId());
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
