package pe.gob.senasa.dbtypes;

import java.io.Serializable;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import java.util.Calendar;

import oracle.sql.Datum;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

import pe.gob.senasa.bean.SolicitudAnalisisAnimal;
import pe.gob.senasa.util.Utility;


public class SolicitudDiagnosticoAnimal  implements ORAData, ORADataFactory,
                                             Serializable {
    
    public static String SQL_TYPE = "SIGSVE.SOLICITUDUCDSA";
    
    private String anho;
    
    private Date fechaProducccion;
    
    private String distrito;
    
    private String provincia;
    
    private String departamento;
    
    private String predio;
    
    private String razonSocial;
    
    private String tipo;
    
    private String tipoVigilancia;
    
    private String programa;
    
    private String sede;
    
    private String empleado;
    
    private String cliente;
    
    private String producto;
    
    private String cantidadAnimales;
    
    public SolicitudDiagnosticoAnimal() {
        super();
    }
    
    public SolicitudDiagnosticoAnimal(SolicitudAnalisisAnimal solicitudAnalisisAnimal) {
       // super();
       Calendar now= Calendar.getInstance();
       this.anho = ""+now.YEAR;
       this.fechaProducccion = null;
       this.distrito = solicitudAnalisisAnimal.getIdDistrito();
       this.provincia = solicitudAnalisisAnimal.getIdProvincia();
       this.departamento = solicitudAnalisisAnimal.getIdDepartamento();
        this.predio = solicitudAnalisisAnimal.getPredio();
        this.razonSocial = null;
        this.tipo = solicitudAnalisisAnimal.getTipoSolicitud();
        this.tipoVigilancia = null;
        this.programa = null;
        this.sede = solicitudAnalisisAnimal.getCodigoSede();
        this.empleado = null;
        this.cliente = solicitudAnalisisAnimal.getIdPersona();
        this.producto = solicitudAnalisisAnimal.getProducto();
        this.cantidadAnimales = solicitudAnalisisAnimal.getCantidadAnimales();
        
    }

    public Datum toDatum(Connection conn) throws SQLException{
      StructDescriptor desc = new StructDescriptor(this.SQL_TYPE,conn);
      STRUCT struct =  new STRUCT(desc,conn,new Object[]{  
      this.anho,
      this.fechaProducccion,
      this.distrito,
      this.provincia,
      this.departamento,
      this.predio,
      this.razonSocial,
      this.tipo,
      this.tipoVigilancia,
      this.programa,
      this.sede,
      this.empleado,
      this.cliente,
      this.producto,
      this.cantidadAnimales});
      return struct;
    }

    public ORAData create(Datum datum, int i) {
      if (datum == null) {
              return null;
      }
      try {
              STRUCT oracleStruct = (STRUCT)datum;
              Object[] elements = (Object[])oracleStruct.getAttributes();
              SolicitudDiagnosticoAnimal retval = null;
       
              if(elements.length>0){
                  retval = new SolicitudDiagnosticoAnimal();
                  
                  retval.setAnho(Utility.validateString( elements[0])); 
                  retval.setFechaProducccion((java.sql.Date)elements[1]);
                  retval.setDistrito(Utility.validateString(elements[2]));
                  retval.setProvincia(Utility.validateString(elements[3])); 
                  retval.setDepartamento(Utility.validateString(elements[4])); 
                  retval.setPredio(Utility.validateString( elements[5])); 
                  retval.setRazonSocial(Utility.validateString( elements[6])); 
                  retval.setTipo(Utility.validateString( elements[7])); 
                  retval.setTipoVigilancia(Utility.validateString( elements[8])); 
                  retval.setPrograma(Utility.validateString( elements[9])); 
                  retval.setSede(Utility.validateString( elements[10])); 
                  retval.setEmpleado(Utility.validateString( elements[11])); 
                  retval.setCliente(Utility.validateString( elements[12]));   
                  retval.setProducto(Utility.validateString( elements[13]));   
                  retval.setCantidadAnimales(Utility.validateString( elements[14]));   
                
              }
              return retval;
      } catch (SQLException sqe) {
          sqe.printStackTrace();
          throw new RuntimeException(sqe);
      }
    }

    public static String getSQL_TYPE() {
        return SQL_TYPE;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getAnho() {
        return anho;
    }

    public void setFechaProducccion(Date fechaProducccion) {
        this.fechaProducccion = fechaProducccion;
    }

    public Date getFechaProducccion() {
        return fechaProducccion;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setPredio(String predio) {
        this.predio = predio;
    }

    public String getPredio() {
        return predio;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipoVigilancia(String tipoVigilancia) {
        this.tipoVigilancia = tipoVigilancia;
    }

    public String getTipoVigilancia() {
        return tipoVigilancia;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getPrograma() {
        return programa;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getSede() {
        return sede;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getProducto() {
        return producto;
    }

    public void setCantidadAnimales(String cantidadAnimales) {
        this.cantidadAnimales = cantidadAnimales;
    }

    public String getCantidadAnimales() {
        return cantidadAnimales;
    }
}
