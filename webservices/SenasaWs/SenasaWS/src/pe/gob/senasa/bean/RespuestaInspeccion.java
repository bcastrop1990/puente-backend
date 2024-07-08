package pe.gob.senasa.bean;

import java.io.Serializable;

public class RespuestaInspeccion extends Respuesta  implements Serializable {
    
    private String idInspeccion;
    
    private String[][] listaProducto;
    
    public RespuestaInspeccion() {
        super();
    }

    public void setListaProducto(String[][] listaProducto) {
        this.listaProducto = listaProducto;
    }

    public String[][] getListaProducto() {
        return listaProducto;
    }

    public void setIdInspeccion(String idInspeccion) {
        this.idInspeccion = idInspeccion;
    }

    public String getIdInspeccion() {
        return idInspeccion;
    }
}
