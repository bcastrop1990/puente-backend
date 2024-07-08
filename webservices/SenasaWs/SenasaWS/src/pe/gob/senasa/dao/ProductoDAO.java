package pe.gob.senasa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleTypes;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.AnimalesVivos;
import pe.gob.senasa.bean.CentroTramite;
import pe.gob.senasa.bean.LugarInspeccion;
import pe.gob.senasa.bean.LugarUbicacionEnvio;
import pe.gob.senasa.bean.MedioTransporte;
import pe.gob.senasa.bean.Producto;
import pe.gob.senasa.bean.PuestoControl;
import pe.gob.senasa.bean.Sede;
import pe.gob.senasa.bean.Tarifa;
import pe.gob.senasa.bean.TipoEnvase;
import pe.gob.senasa.bean.UnidadMedida;
import pe.gob.senasa.bean.UsoDestino;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;
import pe.gob.senasa.interfaces.ProductoInterface;


public class ProductoDAO extends BaseDAO implements ProductoInterface {

    protected static Logger logger = Logger.getLogger(ProductoDAO.class);
    //ConectionApp cnApp =null;
    private DBHelper helper;
    
    public ProductoDAO() {
        super();
        //cnApp = new ConectionApp();
      helper = new DBHelper(SenasaSQL.DATA_SOURCE_PRODUCTO);
    }

    /**
     *
     * @param tipoBusqueda (Partida Arancelaria, Descripcion, Nombre Cientifico)
     * @param textoBusqueda (%s%) (VALIDAR CON CLIENTE)
     * @param tipoProducto ( Zoosanitario, Fitosanitario )
     * @return
     */
    public ArrayList<Producto> obtenerProductos(String tipoBusqueda,
                                                String textoBusqueda,
                                                String tipoProducto,
                                                String uso) {

        int resTP[] = obtenerTipoBusqueda(tipoBusqueda, tipoProducto);
        String tipoBus[] ={ "(lower(par.partida_arancelaria) like '" + textoBusqueda.toLowerCase() +"%') ",
                            "(lower(p.nombre_comercial_producto) like '%" + textoBusqueda.toLowerCase() + "%') ",
                            "(lower(p.nombre_cientifico_producto) like '%" + textoBusqueda.toLowerCase() + "%') " };
        
        String tipoPro[] = { " (p.codigo_clase = '01') ", " (p.codigo_clase = '02') " };
        
        String whereD    = " where estado in ('ACTIVO','INACTIVO') " + " and " + tipoBus[resTP[0]] +
                           " and " + tipoPro[resTP[1]] +" and USO_IMPORTACION_EXPORTACION in (";

        if (uso != null && uso.equalsIgnoreCase("i")) {
            whereD = whereD + "'I',";
        } else if (uso != null && uso.equalsIgnoreCase("e")) {
            whereD = whereD + "'E',";
        }
        
        whereD = whereD + "'A') ";

        String sql = SenasaSQL.OBTENER_PRODUCTO_ARRIBA + whereD + " " + SenasaSQL.OBTENER_PRODUCTO_ABAJO;
        
        Log(" AQUI VA EL " + sql);
        
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        ArrayList<Producto> retval = new ArrayList<Producto>();
        try {
            //con=cnApp.getConnection();
            //con=cnApp.getConnProducto();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            pst = con.prepareStatement(sql);
            Log(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            Log(" = ENTRANDO = ");
            while (rs.next()) {
                Producto p = obtProResultSet(rs);
                retval.add(p);
            }
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("obtenerProductos", e);
        } catch (Exception e) {
            Log("obtenerProductos", e);
        } finally {
          //cleanup(con, pst, rs);
          //PCSM 06/01/2017
              try {
                  helper.cleanup(con, pst, rs);
              } catch (Exception e) {
                  e.printStackTrace();
              }
        }
        Log("= ESTOY REGRESANDO " + retval.size() + " PRODUCTOS = ");
        return retval;
    }

    public Producto obtenerProducto(String codigoProducto) {

        String sql = SenasaSQL.OBTENER_PRODUCTO_ARRIBA + " " + SenasaSQL.WHERE_X_CODIGO_PRODUCTO +
            " " + SenasaSQL.OBTENER_PRODUCTO_ABAJO;

        Log(" AQUI VA EL " + sql);

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        Producto retval = new Producto();
        try {
            //con=cnApp.getConnection();
            //con=cnApp.getConnProducto();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            pst = con.prepareStatement(sql);
            pst.setString(1, codigoProducto);
            Log(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            Log(" = ENTRANDO = ");
            while (rs.next()) {
                retval = obtProResultSet(rs);
            }
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("obtenerProducto", e);
        } catch (Exception e) {
            Log("obtenerProducto", e);
        } finally {
          //cleanup(con, pst, rs);
          //PCSM 06/01/2017
            try {
                helper.cleanup(con, pst, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retval;
    }
    
    
    public List<Producto> obtenerProducto_CPE_Germo(String Germpm,String CPE,  String paises) {
      String logMsg=Germpm+"-"+CPE + " ";
      Log(logMsg+" ********Inicio del Método obtenerProducto_CPE_Germo********");
      Connection con = null;
      CallableStatement cs = null;
      ResultSet rs = null; 
      String sql = SenasaSQL.OBTENER_REG_PRODUCTOS_CPE_GERMP;
      List<Producto> lista =new ArrayList<Producto>();
      Log(logMsg+"SP a ejecutar" + sql);
      try {
        //con=cnApp.getConnection();  
        //con=cnApp.getConnProducto();  //PCSM 05/01/2017
        con = helper.getConnection();  //PCSM 06/01/2017
        cs = con.prepareCall(sql);        
        cs.setString(1, Germpm);
        cs.setString(2, CPE);
        cs.setString(3, paises);
        cs.registerOutParameter(4,OracleTypes.CURSOR,"SYS_REFCURSOR");
          
        Log(logMsg+"- Ejecutando SP");  
        cs.executeQuery();
        rs = (ResultSet)cs.getObject(4);
        Log(logMsg+" Listando datos");
        while(rs.next()){
            Producto b= new Producto();
            b.setCodigoProducto(rs.getString(1));
            b.setPartidaArancelaria(rs.getString(2));
            b.setDescripcion(rs.getString(3));
            lista.add(b);
        }
        rs.close();
        Log(logMsg+"- Lista completada");;  
      } catch (SQLException e) {
        Log(logMsg+ "SQLException : ", e);
      } catch (Exception e) {
        Log(logMsg+"- Exception : ", e);
      } finally {
        //cleanup(con, cs, rs);
        //PCSM 06/01/2017
          try {
              helper.cleanup(con, cs, rs);
          } catch (Exception e) {
              e.printStackTrace();
          } 
      }
      return lista;
    }


  public List<Producto> obtenerProducto_CPE(String CPE) {
    String logMsg="CPE-"+CPE + " ";
    Log(logMsg+" ********Inicio del Método obtenerProducto_CPE ********");
    Connection con = null;
    CallableStatement cs = null;
    ResultSet rs = null; 
    String sql = SenasaSQL.OBTENER_REG_PRODUCTOS_CPE;
    List<Producto> lista =new ArrayList<Producto>();
    Log(logMsg+"SP a ejecutar" + sql);
    try {
      //con=cnApp.getConnection();  
      //con=cnApp.getConnProducto();  //PCSM 05/01/2017
      con = helper.getConnection();  //PCSM 06/01/2017
      cs = con.prepareCall(sql);        
      cs.setString(1, CPE);
      cs.registerOutParameter(2,OracleTypes.CURSOR,"SYS_REFCURSOR");
        
      Log(logMsg+"- Ejecutando SP");  
      cs.executeQuery();
      rs = (ResultSet)cs.getObject(2);
      Log(logMsg+" Listando datos");
      while(rs.next()){
          Producto b= new Producto();
          b.setCodigoProducto(rs.getString(1));
          b.setPartidaArancelaria(rs.getString(2));
          b.setDescripcion(rs.getString(3));
          lista.add(b);
      }
      rs.close();
      Log(logMsg+"- Lista completada");;  
    } catch (SQLException e) {
      Log(logMsg+ "SQLException : ", e);
    } catch (Exception e) {
      Log(logMsg+"- Exception : ", e);
    } finally {
      //cleanup(con, cs, rs);
      //PCSM 06/01/2017
        try {
            helper.cleanup(con, cs, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return lista;
  }


    public ArrayList<Producto> obtenerAnexos(String tipoBusqueda,
                                             String textoBusqueda,
                                             String codigoProductoPadre) {

        int resTP[] = obtenerTipoBusqueda(tipoBusqueda, "");
        String tipoBus[] =
        { "( par.partida_arancelaria like '%" + textoBusqueda.toUpperCase() + "%' )",
          " (p.nombre_comercial_producto like '%" + textoBusqueda.toUpperCase() + "%') ",
          " (p.nombre_cientifico_producto like '%" + textoBusqueda.toUpperCase() + "%') " };

        String whereAND = " AND " + tipoBus[resTP[0]];
        String sql = SenasaSQL.OBTENER_ANEXOS_X_PADRE + whereAND + " order by p.nombre_comercial_producto ";

        Log(" AQUI VA EL  " + sql);
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        ArrayList<Producto> retval = new ArrayList<Producto>();
        try {
            //con=cnApp.getConnection();
            //con=cnApp.getConnProducto();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            pst = con.prepareStatement(sql);
            pst.setString(1, codigoProductoPadre);
            Log(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            Log(" = ENTRANDO = ");
            while (rs.next()) {
                Producto p = obtProResultSet(rs, false);
                retval.add(p);
            }
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("obtenerProductos", e);
        } catch (Exception e) {
            Log("obtenerProductos", e);
        } finally {
          //cleanup(con, pst, rs);
          //PCSM 06/01/2017
            try {
                helper.cleanup(con, pst, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Log("= ESTOY REGRESANDO " + retval.size() + " ANEXOS = ");
        return retval;
    }


    /***
     *
     */
    public Producto obtenerAnexo(String codigoProducto) {

        String sql = SenasaSQL.OBTENER_ANEXO;
        Log(" AQUI VA EL " + sql);
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        Producto retval = new Producto();
        try {
            //con=cnApp.getConnection();
            //con=cnApp.getConnProducto();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            pst = con.prepareStatement(sql);
            pst.setString(1, codigoProducto);
            Log(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            Log(" = ENTRANDO = ");
            while (rs.next()) {
                retval = obtProAnexoResultSet(rs);
                break;
            }
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("obtenerProductos", e);
        } catch (Exception e) {
            Log("obtenerProductos", e);
        } finally {
          //cleanup(con, pst, rs);
          //PCSM 06/01/2017
            try {
                helper.cleanup(con, pst, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retval;
    }

    /**
     *
     * @param tipoBusqueda - Zoosanitario - Fitosanitario.
     * @return
     */
    public ArrayList<UsoDestino> obtenerUsoDestino(String tipoBusqueda) {

        String sql = SenasaSQL.OBTENER_USODESTINO;
        Log(" AQUI VA EL " + sql);

        int resTP[] = obtenerTipoBusqueda("", tipoBusqueda);
        if (resTP[1] > 0)
            tipoBusqueda = "02";
        else
            tipoBusqueda = "01";

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        ArrayList<UsoDestino> retval = new ArrayList<UsoDestino>();
        try {
            //con=cnApp.getConnection();
            //con=cnApp.getConnProducto();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            pst = con.prepareStatement(sql);
            pst.setString(1, tipoBusqueda);
            Log(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            Log(" = ENTRANDO = ");
            while (rs.next()) {
                retval.add(obtUsoDestino(rs));
            }
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("obtenerUsoDestino", e);
        } catch (Exception e) {
            Log("obtenerUsoDestino", e);
        } finally {
          //cleanup(con, pst, rs);
          //PCSM 06/01/2017
            try {
                helper.cleanup(con, pst, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retval;
    }

    /**
     *
     * @param tipoBusqueda - Zoosanitario - Fitosanitario.
     * @return
     */
    public ArrayList<TipoEnvase> obtenerTipoEnvase(String tipoBusqueda) {
        String sql = SenasaSQL.OBTENER_TIPO_ENVASE;
        Log(" AQUI VA EL " + sql);


        int resTP[] = obtenerTipoBusqueda("", tipoBusqueda);
        if (resTP[1] > 0)        
            tipoBusqueda = "02";
        else
            tipoBusqueda = "01";
      Log(" tipoBusqueda = " + tipoBusqueda);
        Connection con =null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        ArrayList<TipoEnvase> retval = new ArrayList<TipoEnvase>();
        try {
            //con=cnApp.getConnection();
            //con=cnApp.getConnProducto();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            pst = con.prepareStatement(sql);
            pst.setString(1, tipoBusqueda);
            Log(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            Log(" = ENTRANDO = ");
            while (rs.next()) {
                retval.add(obtTipoEnvase(rs));
            }
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("obtenerTipoEnvase", e);
        } catch (Exception e) {
            Log("obtenerTipoEnvase", e);
        } finally {
          //cleanup(con, pst, rs);
          //PCSM 06/01/2017
            try {
                helper.cleanup(con, pst, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retval;
    }

    public ArrayList<Sede> obtenerSedes() {
        String sql = SenasaSQL.OBTENER_SEDES;
        Log(" AQUI VA EL " + sql);

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        ArrayList<Sede> retval = new ArrayList<Sede>();
        try {
            //con=cnApp.getConnection();
            //con=cnApp.getConnProducto();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            pst = con.prepareStatement(sql);
            Log(" = ANTES DE EJECUTAR = " + sql);
            rs = pst.executeQuery();
            Log(" = ENTRANDO = ");
            while (rs.next()) {
                retval.add(obtSede(rs));
            }
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("obtenerTipoEnvase", e);
        } catch (Exception e) {
            Log("obtenerTipoEnvase", e);
        } finally {
          //cleanup(con, pst, rs);
          //PCSM 06/01/2017
            try {
                helper.cleanup(con, pst, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retval;
    }

    public ArrayList<PuestoControl> obtenerPuestosDeControl() {
        String sql = SenasaSQL.OBTENER_PUESTOS_DE_CONTROL;
        Log(" AQUI VA EL " + sql);

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        ArrayList<PuestoControl> retval = new ArrayList<PuestoControl>();
        try {
            //con=cnApp.getConnection();
            //con=cnApp.getConnProducto();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            pst = con.prepareStatement(sql);
            Log(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            Log(" = ENTRANDO = ");
            while (rs.next()) {
                retval.add(obtPuestoControl(rs));
            }
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("obtener puestos de control", e);
        } catch (Exception e) {
            Log("obtener puestos de control", e);
        } finally {
          //cleanup(con, pst, rs);
          //PCSM 06/01/2017
          try {
              helper.cleanup(con, pst, rs);
          } catch (Exception e) {
              e.printStackTrace();
          }
        }
        return retval;
    }

    public ArrayList<LugarUbicacionEnvio> obtenerLugarUbicacionEnvio() {
        ArrayList<LugarInspeccion> ins = obtenerLugarInspeccion();
        ArrayList<LugarUbicacionEnvio> retval =
            new ArrayList<LugarUbicacionEnvio>();
        for (LugarInspeccion li : ins) {
            LugarUbicacionEnvio aux = new LugarUbicacionEnvio();
            aux.setCodLugarUbicacionEnvio(li.getCodLugarInspeccion());
            aux.setLugarUbicacionEnvio(li.getLugarInspeccion());
            retval.add(aux);
        }
        return retval;
    }

    public Boolean validarGermoplasmaProducto(String codigoProducto) {
        String sql = SenasaSQL.VALIDAR_GERMOPLASMA_PRODUCTO;
        Log(" AQUI VA EL " + sql);

        Connection con =null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        boolean retval = false;
        try {
            //con=cnApp.getConnection();
            //con=cnApp.getConnProducto();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            pst = con.prepareStatement(sql);
            pst.setString(1, codigoProducto);
            Log(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            Log(" = ENTRANDO = ");
            while (rs.next()) {
                String s = rs.getString(1);
                if (Integer.parseInt(s) > 0)
                    retval = true;
                break;
            }
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("obtenerTipoEnvase", e);
        } catch (Exception e) {
            Log("obtenerTipoEnvase", e);
        } finally {
          //cleanup(con, pst, rs);
          //PCSM 06/01/2017
          try {
              helper.cleanup(con, pst, rs);
          } catch (Exception e) {
              e.printStackTrace();
          }
        }
        return retval;
    }

    public Boolean validarRegistroCPEProducto(String codigoProducto) {
        String sql = SenasaSQL.VALIDAR_REGISTROCPE;
        Log(" AQUI VA EL " + sql);

        Connection con =null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        boolean retval = false;
        try {
            //con=cnApp.getConnection();
            //con=cnApp.getConnProducto();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            pst = con.prepareStatement(sql);
            pst.setString(1, codigoProducto);
            Log(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            Log(" = ENTRANDO = ");
            while (rs.next()) {
                String s = rs.getString(1);
                if (Integer.parseInt(s) > 0)
                    retval = true;
                break;
            }
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("obtenerTipoEnvase", e);
        } catch (Exception e) {
            Log("obtenerTipoEnvase", e);
        } finally {
          //cleanup(con, pst, rs);
          //PCSM 06/01/2017
            try {
                helper.cleanup(con, pst, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retval;
    }

    public ArrayList<MedioTransporte> obtenerMedioTransporte() {
        String sql = SenasaSQL.OBTENER_MEDIOS_TRANSPORTE;
        Log(" AQUI VA EL " + sql);

        Connection con =null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        ArrayList<MedioTransporte> retval = new ArrayList<MedioTransporte>();
        try {
            //con=cnApp.getConnection();
            //con=cnApp.getConnProducto();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            pst = con.prepareStatement(sql);
            Log(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            Log(" = ENTRANDO = ");
            while (rs.next()) {
                retval.add(obtMedioTransporte(rs));
            }
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("obtenerTipoEnvase", e);
        } catch (Exception e) {
            Log("obtenerTipoEnvase", e);
        } finally {
          //cleanup(con, pst, rs);
          //PCSM 06/01/2017
            try {
                helper.cleanup(con, pst, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retval;
    }


    /**
     * @param ccodcla
     * @return
     */
    public ArrayList<UnidadMedida> obtenerUnidadMedida(String ccodcla) {
        String sql = SenasaSQL.OBTENER_UNIDAD_MEDIDA;
        Log(" AQUI VA EL " + sql);

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        ArrayList<UnidadMedida> retval = new ArrayList<UnidadMedida>();
        try {
            //con=cnApp.getConnection();
            //con=cnApp.getConnProducto();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            pst = con.prepareStatement(sql);
            pst.setString(1, ccodcla);
            Log(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            Log(" = ENTRANDO = ");
            while (rs.next()) {
                retval.add(obtUnidadMedida(rs));
            }
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("obtenerUnidadMedida", e);
        } catch (Exception e) {
            Log("obtenerUnidadMedida", e);
        } finally {
          //cleanup(con, pst, rs);
          //PCSM 06/01/2017
            try {
                helper.cleanup(con, pst, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retval;
    }
    
    
  /**
   * @param ccodcla
   * @return
   */
  public ArrayList<UnidadMedida> obtenerUndMedxProducto(String codProducto) {
      String sql = SenasaSQL.OBTENER_UNIDAD_MEDIDA_XPROD;
      Log("codProducto= "+codProducto + " Inicio del Método obtenerUndMedxProducto " + sql);

      Connection con = null;
      
      CallableStatement cs = null;
      ResultSet rs = null;

      ArrayList<UnidadMedida> retval = new ArrayList<UnidadMedida>();
      try {
          //con=cnApp.getConnection();
          //con=cnApp.getConnProducto();  //PCSM 05/01/2017
          con = helper.getConnection();  //PCSM 06/01/2017
          cs = con.prepareCall(sql);
          
          Log("codProducto= "+codProducto + " Preparando la ejecución del SP " );
          cs.setString(1, codProducto);
          cs.registerOutParameter(2,OracleTypes.CURSOR,"SYS_REFCURSOR");
          
          cs.execute();
          Log("codProducto= "+codProducto + " Se ejecutó el SP " );
          rs = (ResultSet)cs.getObject(2);
          while (rs.next()) {
              UnidadMedida um = new UnidadMedida();
              um.setCodUnidadMedida(rs.getString("codigo"));
              um.setUnidadMedida(rs.getString("descripcion"));              
              retval.add(um);
          }
        Log("codProducto= "+codProducto + " Cantidad de Itemas = " + retval.size() );
      } catch (SQLException e) {
        Log("codProducto= "+codProducto + " Error SQLException :" ,e);
      } catch (Exception e) {
        Log("codProducto= "+codProducto + " Error Exception :" ,e);
      } finally {
          Log("codProducto= "+codProducto + " Fin del Método obtenerUndMedxProducto ");
          //cleanup(con, cs, rs);
          //PCSM 06/01/2017
          try {
              helper.cleanup(con, cs, rs);
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
      return retval;
     
  }

    public ArrayList<LugarInspeccion> obtenerLugarInspeccion() {
        String sql = SenasaSQL.OBTENER_LUGAR_INSPECCION;
        Log(" AQUI VA EL " + sql);

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        ArrayList<LugarInspeccion> retval = new ArrayList<LugarInspeccion>();
        try {
            //con=cnApp.getConnection();
            //con=cnApp.getConnProducto();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            pst = con.prepareStatement(sql);
            Log(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            Log(" = ENTRANDO = ");
            while (rs.next()) {
                retval.add(obtLugarInspeccion(rs));
            }
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("obtenerTipoEnvase", e);
        } catch (Exception e) {
            Log("obtenerTipoEnvase", e);
        } finally {
          //cleanup(con, pst, rs);
          //PCSM 06/01/2017
            try {
                helper.cleanup(con, pst, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retval;
    }

    public Boolean validarMuestras(String codigoProducto, Double pesoNeto) {

        String sql = SenasaSQL.VALIDAR_MUESTRA;
        Log(" AQUI VA EL " + sql);

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        boolean retval = false;
        try {
            //con=cnApp.getConnection();
            //con=cnApp.getConnProducto();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            pst = con.prepareStatement(sql);
            pst.setString(1, codigoProducto);
            pst.setDouble(2, pesoNeto);
            Log(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            Log(" = ENTRANDO = ");
            while (rs.next()) {
                String s = rs.getString(1);
                if (Integer.parseInt(s) > 0)
                    retval = true;
                break;
            }
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("obtenerTipoEnvase", e);
        } catch (Exception e) {
            Log("obtenerTipoEnvase", e);
        } finally {
          //cleanup(con, pst, rs);
          //PCSM 06/01/2017
            try {
                helper.cleanup(con, pst, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retval;
    }

    public ArrayList<AnimalesVivos> obtenerAnimalesVivos() {


        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<AnimalesVivos> retval = new ArrayList<AnimalesVivos>();
        try {
            //con=cnApp.getConnection();
            //con=cnApp.getConnProducto();  //PCSM 05/01/2017
            con = helper.getConnection();  //PCSM 06/01/2017
            String sql = SenasaSQL.OBTENER_ANIMALES_VIVOS;
            Log(" AQUI VA EL " + sql);
            pst = con.prepareStatement(sql);
            Log(" = ANTES DE EJECUTAR = ");
            rs = pst.executeQuery();
            Log(" = ENTRANDO = ");
            while (rs.next()) {
                AnimalesVivos av = new AnimalesVivos();
                av.setCodAnimalVivo(rs.getString(1));
                av.setAnimalVivo(rs.getString(2));
                retval.add(av);
            }
            Log(" = FIN TODITO = ");
        } catch (SQLException e) {
            Log("obtenerAnimalesVivos", e);
        } catch (Exception e) {
            Log("obtenerAnimalesVivos", e);
        } finally {
          //cleanup(con, pst, rs);
          //PCSM 06/01/2017
          try {
              helper.cleanup(con, pst, rs);
          } catch (Exception e) {
              e.printStackTrace();
          }
        }
        return retval;
    }

    private void Log(String s) {
        logger.debug(s);
    }

    private void Log(String s, java.lang.Throwable p2) {
        logger.fatal("ProductoDAO - " + s, p2);
    }

    /**
     * Regresa
     * @param tipoBusqueda
     * @param tipoProducto
     * @return 1 =
     */
    private int[] obtenerTipoBusqueda(String tipoBusqueda,
                                      String tipoProducto) {
        int retval[] = new int[2];
        if (tipoBusqueda.compareTo("Partida Arancelaria") == 0) {
            retval[0] = 0;
        } else if (tipoBusqueda.compareTo("Descripcion") == 0) {
            retval[0] = 1;
        } else if (tipoBusqueda.compareTo("Nombre Cientifico") == 0) {
            retval[0] = 2;
        }
        /// TIPO DE PRODUCTO
        if (tipoProducto.compareTo("Zoosanitario") == 0) {
            retval[1] = 0;
        } else if (tipoProducto.compareTo("Fitosanitario") == 0) {
            retval[1] = 1;
        }
        return retval;
    }

    private Producto obtProResultSet(ResultSet rs) throws SQLException {
        return obtProResultSet(rs, true);
    }

    private Producto obtProResultSet(ResultSet rs,
                                     boolean buscarAnexos) throws SQLException {
        Log(" = SETEANDO obtProResultSet  = ");
        Producto p = new Producto();
        p.setCodigoProducto(rs.getString(1));
        Log(" = SETEANDO obtProResultSet: Codigo Producto=" + rs.getString(1));
      
        p.setDescripcion(rs.getString(2));
        p.setNombreCientifico(rs.getString(3));
        p.setClaseProducto(rs.getString(4));
        p.setCategoriaRiesgo(rs.getString(5));
        p.setPartidaArancelaria(rs.getString(6));
        p.setEsAnimalVivo((p.getPartidaArancelaria().startsWith("01")) ?(true) : (false));
        
        
        //TODO: CHEQUEAR....

        int aux = 0;
        
        try
        {
            aux = Integer.parseInt(rs.getString(7));    
        }
        catch(NumberFormatException e)
        {
           aux = 0;
        }
            
        p.setContieneAnexos((aux > 0) ? (true) : (false));
        Log("= SETEANDO obtProResultSet: setIndicadorCuarentena = "+ rs.getString(8));
        p.setIndicadorCuarentena(rs.getString(8)!=null && rs.getString(8).toUpperCase().equals("X")?(true):(false));
        p.setIndicadorGermoplasma(rs.getString(9)!=null && rs.getString(9).toUpperCase().equals("X")?(true):(false));
        p.setIndicadorGCustodia(rs.getString(10)!=null && rs.getString(10).toUpperCase().equals("X")?(true):(false));
        
        //boolean _blC = rs.getString(8)!=null && rs.getString(8).toUpperCase().equals("X")?(true):(false);
        //Log("= SETEANDO obtProResultSet: setIndicadorCuarentena Transformado= "+ _blC);
      
        Log(" = FIN SETEANDO obtProResultSet = ");
        
        return p;
    }

    private TipoEnvase obtTipoEnvase(ResultSet rs) throws SQLException {
        TipoEnvase te = new TipoEnvase();
        te.setCodTipoEnvase(rs.getString(1));
        te.setTipoEnvase(rs.getString(2));
        return te;
    }

    private UsoDestino obtUsoDestino(ResultSet rs) throws SQLException {
        UsoDestino ud = new UsoDestino();
        ud.setCodUsoDestino(rs.getString(1));
        ud.setUsoDestino(rs.getString(2));
        return ud;
    }

    private MedioTransporte obtMedioTransporte(ResultSet rs) throws SQLException {
        MedioTransporte mt = new MedioTransporte();
        mt.setCodMedioTransporte(rs.getString(1));
        mt.setMedioTransporte(rs.getString(2));
        return mt;
    }

    private UnidadMedida obtUnidadMedida(ResultSet rs) throws SQLException {
        UnidadMedida mt = new UnidadMedida();
        mt.setCodUnidadMedida(rs.getString(1));
        mt.setUnidadMedida(rs.getString(2));
        return mt;
    }

    private LugarInspeccion obtLugarInspeccion(ResultSet rs) throws SQLException {
        LugarInspeccion mt = new LugarInspeccion();
        mt.setCodLugarInspeccion(rs.getString(1));
        mt.setLugarInspeccion(rs.getString(2));
        return mt;
    }

    private Sede obtSede(ResultSet rs) throws SQLException {
        Sede sd = new Sede();
        sd.setCodSede(rs.getString(1));
        sd.setDescSede(rs.getString(2));
        sd.setDescTipoSede(rs.getString(3));
        return sd;
    }
    
    private PuestoControl obtPuestoControl(ResultSet rs) throws SQLException{
        PuestoControl pc= new PuestoControl();
        pc.setCodSede(rs.getString(1));
        pc.setDescSede(rs.getString(2));
        pc.setDescTipoSede(rs.getString(3));
        pc.setCodMediotransporte(rs.getString(4));
        
        return pc;
    }

    private Producto obtProAnexoResultSet(ResultSet rs) throws SQLException {
        Log(" = SETEANDO obtProResultSet  = ");
        Producto p = new Producto();
        p.setCodigoProducto(rs.getString(1));
        p.setDescripcion(rs.getString(2));
        p.setNombreCientifico(rs.getString(3));
        int aux = Integer.parseInt(rs.getString(4));
        p.setEsAnimalVivo((aux == 1) ? (true) : (false));
        //TODO: CHEQUEAR....
        p.setCategoriaRiesgo(rs.getString(5));
        p.setPartidaArancelaria(rs.getString(6));
        aux = Integer.parseInt(rs.getString(7));
        p.setContieneAnexos(false);
        p.setCodigoPadre(rs.getString(8));
        p.setDescripcionPadre(rs.getString(9));
        p.setNombreCientificoPadre(rs.getString(10));
        p.setPartidaArancelariaPadre(rs.getString(11));
        Log(" = FIN SETEANDO = ");
        return p;
    }

/***** INICIO TARIFAS ****/

    public String obtenerTarifa(String codigoProducto, String codigoServicio,
                                String peso) {
        Tarifa tarifa = new Tarifa(codigoProducto,peso,codigoServicio);
        ArrayList<Tarifa> tarifas = new ArrayList<Tarifa>();
        tarifas.add(tarifa);
        return obtenerTarifaMultiple(tarifas);
    }

    /**
     * @return
     */
    public String obtenerTarifaMultiple(ArrayList<Tarifa> tarifas){
        //Connection conn = ConnectionSenasa.getSingletonObject().getConnection();
        //Connection conn = ConnectionSenasa.getSingletonObject().getConnProducto();  //PCSM 05/01/2017
        Connection conn = null; //PCSM 09/01/2017
        try
         {          
           conn = helper.getConnection();  //PCSM 09/01/2017
         }catch(Exception e){
             logger.fatal(e);
         }
        
        return tarificar(conn, tarifas);
    }


    public String obtenerTarifaMultipleLocal(ArrayList<Tarifa> tarifas) {
        //Connection conn = ConnectionSenasa.getConnectionSimple();
        Connection conn = null; //PCSM 09/01/2017
        try
         {          
           conn = helper.getConnection();  //PCSM 09/01/2017
         }catch(Exception e){
             logger.fatal(e);
         }
        
        return tarificar(conn, tarifas);
    }

    public String tarificar(Connection conn, ArrayList<Tarifa> tarifas) {
                
        CallableStatement cs = null;
        String sql ="{ ? = call vuce.pckg_calculo_tarifa.fn_calcular(?,?,?,?) }";
        String tarifa = "";
        String codigoError = "";
        try {
            
            cs = conn.prepareCall(sql);
            StructDescriptor structDescriptor =
                new StructDescriptor("SENASA.T_PRODUCTO", conn);
            STRUCT arregloProductos[] = new STRUCT[tarifas.size()];
            
            logger.debug("tarifas.size():"+tarifas.size());

            for (int i=0; i < tarifas.size(); i++)
            {
                String[] producto = new String[3];
                
                Tarifa t = tarifas.get(i);
                
              logger.debug("t.getCodigoServicio():--"+t.getCodigoServicio()+"--");
              logger.debug("t.getCodigoProducto():--"+t.getCodigoProducto()+"--");
              logger.debug("t.getPeso():--"+t.getPeso()+"--");
                
                producto[0] =  t.getCodigoServicio()== null ? null:t.getCodigoServicio();
                
                producto[1] =  t.getCodigoProducto()==null || t.getCodigoProducto().trim().equals("") ? null:t.getCodigoProducto();
                
                producto[2] =  t.getPeso()==null  || t.getPeso().trim().equals("") ? null:t.getPeso();
                
                logger.debug("registro:--"+i+"--");
                logger.debug("getCodigoServicio:"+ producto[0]);
                logger.debug("getCodigoProducto:"+ producto[1]);
                logger.debug("getPeso:"+ producto[2]);
                
                arregloProductos[i] = new STRUCT(structDescriptor, conn, producto);
            }

            ArrayDescriptor descriptorTarifas = ArrayDescriptor.createDescriptor("SENASA.T_PRODUCTO_ARRAY",conn);
            ARRAY arregloTarifas = new ARRAY(descriptorTarifas, conn, arregloProductos);
            cs.setArray(2, arregloTarifas);

            cs.registerOutParameter(1, Types.INTEGER);
            cs.registerOutParameter(3, Types.DOUBLE);
            cs.registerOutParameter(4, Types.ARRAY, "SENASA.T_SERV_ARRAY");
            cs.registerOutParameter(5, Types.VARCHAR);
            Log(" = ANTES DE EJECUTAR = ");
            cs.execute();
            tarifa = "" + cs.getDouble(3);
            codigoError = "" + cs.getInt(1);

            Log("fin de la invocacion, tarifa: " + tarifa +
                ", codigo error: " + codigoError);
        } catch (SQLException e) {
            Log("obtenerProductos", e);
        } catch (Exception e) {
            Log("obtenerProductos", e);
        } finally {
            //cleanup(conn, cs);
            //PCSM 06/01/2017
              try {
                  helper.cleanup(conn, cs, null);
              } catch (Exception e) {
                  e.printStackTrace();
              }
        }
        return tarifa;
    }

  // ---- FIN TARIFAS  ---- //


    public static void main(String[] args) {
    
       ArrayList<Producto> _arrProd = new ArrayList<Producto>();
      ProductoDAO producto = new ProductoDAO();
       _arrProd = producto.obtenerAnexos("Descripcion","zana","00063");
         
     
    }


    public ArrayList<CentroTramite> obtenerCentroTramites(String codigoProducto,String codigoPais,String codigoLugarProduccion)
    {
      String sql = SenasaSQL.OBTENER_CENTRO_TRAMITES_POR_PRODUCTO;
      Connection con = null;
      PreparedStatement pst = null;
      ResultSet rs = null;
      ArrayList<CentroTramite> listPuntoIngreso= new ArrayList<CentroTramite>();
      CentroTramite centroTramite=null;
      try
      {          
        logger.debug("sql :"+sql);  
        //con=cnApp.getConnection();  
        //con=cnApp.getConnProducto();  //PCSM 05/01/2017
        con = helper.getConnection();  //PCSM 06/01/2017
        pst = con.prepareStatement(sql);
        pst.setString(1,codigoProducto);
        pst.setString(2,codigoPais);
        pst.setString(3,codigoLugarProduccion==null ? "00" : codigoLugarProduccion);
          
        rs = pst.executeQuery();
          
        while(rs.next())
        {
            centroTramite = new CentroTramite();
            
            centroTramite.setCodigoCentroTramite(rs.getString(1));
            
            centroTramite.setCentroTramite(rs.getString(2));
            
            listPuntoIngreso.add(centroTramite);
        }
      }catch(Exception e){
          logger.fatal(e);
      }finally {
        //cleanup(con, pst, rs);
        //PCSM 06/01/2017
          try {
              helper.cleanup(con, pst, rs);
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
      
      return listPuntoIngreso;
    }

//Modificado 18/10/2011
  public ArrayList<PuestoControl> obtenerPuestosdeControlCuarentena(String codigoProducto,String codigoPais,String codigoLugarProduccion) {
      boolean _blCuarentena;
      //_blCuarentena = true;
    logger.debug("CODIGOPRODUCTO: |"+  codigoProducto.trim() +"| ");
    logger.debug("CODIGOPAIS: "+  codigoPais +" ");
    logger.debug("CODIGOLUGAR: "+ codigoLugarProduccion +" ");
    logger.debug("Ir a PRODUCTODAO.java: obtenerProducto(" + codigoProducto.trim() + ")");
    
    if(codigoProducto.trim()=="" || codigoProducto==null) 
    {
      logger.fatal("Codigo de Producto Nulo o Vacio");
      return null;
    }
    
    Producto _producto = obtenerProducto(codigoProducto);
    logger.debug("isIndicadorCuarentena(): "+  _producto.isIndicadorCuarentena() +" ");
      _blCuarentena = _producto.isIndicadorCuarentena();
      ArrayList<CentroTramite> _arrCentroTramite = new ArrayList<CentroTramite>();
      ArrayList<PuestoControl> _arrSede = new ArrayList<PuestoControl>();
    
      if(_blCuarentena) {
        logger.debug("Llamada a obtenerCentroTramites() ");
        _arrCentroTramite = obtenerCentroTramites(codigoProducto, codigoPais, codigoLugarProduccion);
        for (CentroTramite _ct : _arrCentroTramite) {
                    PuestoControl auxSede = new PuestoControl();
                    auxSede.setCodSede(_ct.getCodigoCentroTramite());
                    auxSede.setDescSede(_ct.getCentroTramite());
                    auxSede.setDescTipoSede(_ct.getDireccion());
                    _arrSede.add(auxSede);
                }
        int k;
        for(k=0;k<_arrSede.size();k++) {
          logger.debug("obtenerCentroTramites(): Añadiendo al _arrSede: " + _arrSede.get(k).getCodSede() + "-" + _arrSede.get(k).getDescSede() );
        }
        
        return _arrSede;  
        
      }
      else {
          logger.debug("Llamada a obtenerPuestosDeControl() ");  
          _arrSede = obtenerPuestosDeControl();
       /* int k;
        for(k=0;k<_arrSede.size();k++) {
          logger.debug("obtenerPuestosDeControl(): Añadiendo al _arrSede: " + _arrSede.get(k).getCodSede() + "-" + _arrSede.get(k).getDescSede() );
        }
       */
        return obtenerPuestosDeControl();  
      }
      
  }
 
}


