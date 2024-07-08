package pe.gob.senasa.dao;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class RequisitoDao implements SQLData {
    
  public static String SQL_TYPE="T_REQU";
  public static String SQL_TYPE_ARRAY="T_REQU_ARRAY";
    
  String codigoRequisito;
  String descripcionRequisito;
  String orden;
  String sangria;
  String etiqueta;
  String clase;

    public void setCodigoRequisito(String codigoRequisito) {
        this.codigoRequisito = codigoRequisito;
    }

    public String getCodigoRequisito() {
        return codigoRequisito;
    }

    public void setDescripcionRequisito(String descripcionRequisito) {
        this.descripcionRequisito = descripcionRequisito;
    }

    public String getDescripcionRequisito() {
        return descripcionRequisito;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getOrden() {
        return orden;
    }

    public void setSangria(String sangria) {
        this.sangria = sangria;
    }

    public String getSangria() {
        return sangria;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getClase() {
        return clase;
    }

    public String getSQLTypeName() {
        return SQL_TYPE;
    }

    public void readSQL(SQLInput stream, String typeName) throws SQLException {
         setCodigoRequisito(stream.readString());
         setDescripcionRequisito(stream.readString());
         setEtiqueta(stream.readString());
         setOrden(stream.readString());
         setClase(stream.readString());
         setSangria(stream.readString());  
    }

    public void writeSQL(SQLOutput stream) throws SQLException {
              stream.writeString(getCodigoRequisito());
              stream.writeString(getDescripcionRequisito());
              stream.writeString(getEtiqueta());
              stream.writeString(getOrden());
              stream.writeString(getClase());
              stream.writeString(getSangria());
    }
}
