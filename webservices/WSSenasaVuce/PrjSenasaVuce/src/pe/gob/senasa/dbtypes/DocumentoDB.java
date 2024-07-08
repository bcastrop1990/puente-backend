package pe.gob.senasa.dbtypes;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

import pe.gob.senasa.bean.AdjuntoDocumento;


public class DocumentoDB extends AdjuntoDocumento implements SQLData {
    //Este bean se utilizara en caso de grabar lista con la clase lista generia
    public DocumentoDB() {
        super();
    }
  private String type;
  
  public void readSQL(SQLInput stream, String typeName){
      
  }  
  public void writeSQL(SQLOutput stream) throws SQLException{
      stream.writeString(getUcmId());
      stream.writeString(getNombre());
  }
  /*
  public String getSQLTypeName() {
      return getType();
  }*/

  public String getSQLTypeName() {
      return "VUCE.DOCUMENTO_UCM";
  }
  public void setType(String type) {
      this.type = type;
  }

  public String getType() {
      return type;
  }
}
