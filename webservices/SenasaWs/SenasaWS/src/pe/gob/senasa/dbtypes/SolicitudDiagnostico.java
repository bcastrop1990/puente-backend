package pe.gob.senasa.dbtypes;

import java.io.Serializable;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.sql.Datum;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

import pe.gob.senasa.bean.CabeceraSolicitudAnalisis;
import pe.gob.senasa.bean.SolicitudAnalisisVegetal;
import pe.gob.senasa.util.Utility;


public class SolicitudDiagnostico implements ORAData, ORADataFactory,
                                             Serializable {
    public String SQL_TYPE = "SIGSVE.SOLICITUDDIAGNOSTICO";//"SIGSVE.SOLICITUDDIAGNOSTICO";//SIGSVE.SOLICITUDDIAGNOSTICO
    
    private String cliente;
    private String direccion;
    private String telefono;
    private String codigoPredio;
    private String pais;
    private String departamento;
    private String provincia;
    private String distrito;
    private String centroPoblado;
    private String responsableMuestreo;
    private String tipoUsuario;
    private String proyecto;
    private String producto;
    private String meta;
    private String documentoOrigen;
    private String cultivo;
    private String cultivar;
    private String distribucion;
    private String densidadPoblacional;
    private String procedenciaSemilla;
    private Double areaSembrada;
    private Double areaAfectada;
    private Double latitud;
    private Double longitud;
    private String temperatura;
    private String humedad;
    private String sede;
    private Double altitud;
    private String servicioTupa;
    private String usoPropuesto;
    private String tipoEnvase;
    
    
    public SolicitudDiagnostico() {
        super();
    }

    public SolicitudDiagnostico(SolicitudAnalisisVegetal cs) {
        this.cliente = cs.getCodigoSolicitante();
        this.direccion = null;
        this.telefono = null;
        this.codigoPredio = null; //codigo de producto
        this.pais = cs.getCodigoPaisOrigen();
        this.departamento = cs.getCodigoDepartamento();
        this.provincia = cs.getCodigoProvincia();
        this.distrito = cs.getCodigoDistrito();
        this.centroPoblado = null;
        this.responsableMuestreo = cs.getCodigoInspector();
        this.tipoUsuario = cs.getCodigoTipUsu();
        this.proyecto = null;
        // TODO: REVISAR ESTE DATO NO SE TOMO EN CUENTA EN LA DEFINICION DEL EXCEL QUE SE REALIZO CON JHON
        this.producto =cs.getProducto();
        this.meta = null;
        this.documentoOrigen = null;
        this.cultivo = null;
        this.cultivar = null;
        this.distribucion = null;
        this.densidadPoblacional = null;
        this.procedenciaSemilla = null;
        this.areaSembrada = null;
        this.areaAfectada = null;
        this.latitud = null;
        this.longitud = null;
        this.temperatura = null;
        this.humedad = null;
        this.sede = cs.getCodigoDireccionEjecutiva();
        this.altitud = null;
        this.servicioTupa = cs.getServicioTupa();
        this.usoPropuesto = cs.getUsoPropuesto();
        this.tipoEnvase = cs.getTipoEnvase();
    }
 

    public SolicitudDiagnostico(CabeceraSolicitudAnalisis cs) {
        this.cliente = cs.getCliente();
        this.direccion = cs.getDireccion();
        this.telefono = cs.getTelefono();
        this.codigoPredio = cs.getCodigoPredio();
        this.pais = cs.getPais();
        this.departamento = cs.getDepartamento();
        this.provincia = cs.getProvincia();
        this.distrito = cs.getDistrito();
        this.centroPoblado = cs.getCentroPoblado();
        this.responsableMuestreo = cs.getResponsableMuestreo();
        this.tipoUsuario = cs.getTipoUsuario();
        this.proyecto = cs.getProyecto();
        this.producto = cs.getProducto();
        this.meta = cs.getMeta();
        this.documentoOrigen = cs.getDocumentoOrigen();
        this.cultivo = cs.getCultivo();
        this.cultivar = cs.getCultivar();
        this.distribucion = cs.getDistribucion();
        this.densidadPoblacional = cs.getDensidadPoblacional();
        this.procedenciaSemilla = cs.getProcedenciaSemilla();
        this.areaSembrada = cs.getAreaSembrada();
        this.areaAfectada = cs.getAreaAfectada();
        this.latitud = cs.getLatitud();
        this.longitud = cs.getLongitud();
        this.temperatura = cs.getTemperatura();
        this.humedad = cs.getHumedad();
        this.sede = cs.getSede();
        this.altitud = cs.getAltitud();
        this.servicioTupa = cs.getServicioTupa();
        this.usoPropuesto = cs.getUsoPropuesto();
        this.tipoEnvase = cs.getTipoEnvase();
        
    }

    public SolicitudDiagnostico(String cliente, 
                                String direccion, String telefono, String codigoPredio,
                                String pais, String departamento,
                                String provincia, String distrito,
                                String centroPoblado,
                                String responsableMuestreo, String tipoUsuario,
                                String proyecto, String producto, String meta,
                                String documentoOrigen, String cultivo,
                                String cultivar, String distribucion,
                                String densidadPoblacional,
                                String procedenciaSemilla, Double areaSembrada,
                                Double areaAfectada, Double latitud,
                                Double longitud, String temperatura,
                                String humedad, String sede, Double altitud,
                                String servicioTupa, String usoPropuesto, String tipoEnvase) {
        super();
        this.cliente = cliente;
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigoPredio = codigoPredio;
        this.pais = pais;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.centroPoblado = centroPoblado;
        this.responsableMuestreo = responsableMuestreo;
        this.tipoUsuario = tipoUsuario;
        this.proyecto = proyecto;
        this.producto = producto;
        this.meta = meta;
        this.documentoOrigen = documentoOrigen;
        this.cultivo = cultivo;
        this.cultivar = cultivar;
        this.distribucion = distribucion;
        this.densidadPoblacional = densidadPoblacional;
        this.procedenciaSemilla = procedenciaSemilla;
        this.areaSembrada = areaSembrada;
        this.areaAfectada = areaAfectada;
        this.latitud = latitud;
        this.longitud = longitud;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.sede = sede;
        this.altitud = altitud;
        this.servicioTupa = servicioTupa;
        this.usoPropuesto = usoPropuesto;
        this.tipoEnvase = tipoEnvase;
        
    }

    public Datum toDatum(Connection conn) throws SQLException {
        StructDescriptor desc = new StructDescriptor(this.SQL_TYPE,conn);
        STRUCT struct =  new STRUCT(desc,conn,new Object[]{   
     cliente,
     direccion,
     telefono,
     codigoPredio,
     pais,
     departamento,
     provincia,
     distrito,
     centroPoblado,
     responsableMuestreo,
     tipoUsuario,
     proyecto,
     producto,
     meta,
     documentoOrigen,
     cultivo,
     cultivar,
     distribucion,
     densidadPoblacional,
     procedenciaSemilla,
     areaSembrada,
     areaAfectada,
     latitud,
     longitud,
     temperatura,
     humedad,
     sede,
     altitud,
     servicioTupa,
     usoPropuesto,
     tipoEnvase});
        return struct;
    }

    public ORAData create(Datum datum, int i) {
        if (datum == null) {
                return null;
        }
        try {
                STRUCT oracleStruct = (STRUCT)datum;
                Object[] elements = (Object[])oracleStruct.getAttributes();
                SolicitudDiagnostico retval = null;
         
                if(elements.length>0){
                    retval = new SolicitudDiagnostico();
                    retval.setCliente(Utility.validateString( elements[0])); 
                    retval.setDireccion(Utility.validateString( elements[1]));
                    retval.setTelefono(Utility.validateString( elements[2]));
                    retval.setCodigoPredio(Utility.validateString( elements[3])); 
                    retval.setPais(Utility.validateString( elements[4])); 
                    retval.setDepartamento(Utility.validateString( elements[5])); 
                    retval.setProvincia(Utility.validateString( elements[6])); 
                    retval.setDistrito(Utility.validateString( elements[7])); 
                    retval.setCentroPoblado(Utility.validateString( elements[8])); 
                    retval.setResponsableMuestreo(Utility.validateString( elements[9])); 
                    retval.setTipoUsuario(Utility.validateString( elements[10])); 
                    retval.setProyecto(Utility.validateString( elements[11])); 
                    retval.setProducto(Utility.validateString( elements[12])); 
                    retval.setMeta(Utility.validateString( elements[13])); 
                    retval.setDocumentoOrigen(Utility.validateString( elements[14])); 
                    retval.setCultivo(Utility.validateString( elements[15])); 
                    retval.setCultivar(Utility.validateString( elements[16])); 
                    retval.setDistribucion(Utility.validateString( elements[17]));  
                    retval.setDensidadPoblacional(Utility.validateString( elements[18])); 
                    retval.setProcedenciaSemilla(Utility.validateString( elements[19])); 
                    retval.setAreaSembrada(Utility.validateDouble( elements[20]));   
                    retval.setAreaAfectada(Utility.validateDouble( elements[21])); 
                    retval.setLatitud(Utility.validateDouble( elements[22])); 
                    retval.setLongitud(Utility.validateDouble( elements[23])); 
                    retval.setTemperatura(Utility.validateString( elements[24])); 
                    retval.setHumedad(Utility.validateString( elements[25])); 
                    retval.setSede(Utility.validateString( elements[26])); 
                    retval.setAltitud(Utility.validateDouble( elements[27]));  
                    retval.setServicioTupa(Utility.validateString( elements[28]));
                    retval.setUsoPropuesto(Utility.validateString( elements[29]));
                    retval.setTipoEnvase(Utility.validateString( elements[30]));
                }
                return retval;
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            throw new RuntimeException(sqe);
        }
    }


    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setCodigoPredio(String codigoPredio) {
        this.codigoPredio = codigoPredio;
    }

    public String getCodigoPredio() {
        return codigoPredio;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setCentroPoblado(String centroPoblado) {
        this.centroPoblado = centroPoblado;
    }

    public String getCentroPoblado() {
        return centroPoblado;
    }

    public void setResponsableMuestreo(String responsableMuestreo) {
        this.responsableMuestreo = responsableMuestreo;
    }

    public String getResponsableMuestreo() {
        return responsableMuestreo;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getProducto() {
        return producto;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getMeta() {
        return meta;
    }

    public void setDocumentoOrigen(String documentoOrigen) {
        this.documentoOrigen = documentoOrigen;
    }

    public String getDocumentoOrigen() {
        return documentoOrigen;
    }

    public void setCultivo(String cultivo) {
        this.cultivo = cultivo;
    }

    public String getCultivo() {
        return cultivo;
    }

    public void setCultivar(String cultivar) {
        this.cultivar = cultivar;
    }

    public String getCultivar() {
        return cultivar;
    }

    public void setDistribucion(String distribucion) {
        this.distribucion = distribucion;
    }

    public String getDistribucion() {
        return distribucion;
    }

    public void setDensidadPoblacional(String densidadPoblacional) {
        this.densidadPoblacional = densidadPoblacional;
    }

    public String getDensidadPoblacional() {
        return densidadPoblacional;
    }

    public void setProcedenciaSemilla(String procedenciaSemilla) {
        this.procedenciaSemilla = procedenciaSemilla;
    }

    public String getProcedenciaSemilla() {
        return procedenciaSemilla;
    }

    public void setAreaSembrada(Double areaSembrada) {
        this.areaSembrada = areaSembrada;
    }

    public Double getAreaSembrada() {
        return areaSembrada;
    }

    public void setAreaAfectada(Double areaAfectada) {
        this.areaAfectada = areaAfectada;
    }

    public Double getAreaAfectada() {
        return areaAfectada;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setHumedad(String humedad) {
        this.humedad = humedad;
    }

    public String getHumedad() {
        return humedad;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getSede() {
        return sede;
    }

    public void setAltitud(Double altitud) {
        this.altitud = altitud;
    }

    public Double getAltitud() {
        return altitud;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setServicioTupa(String servicioTupa) {
        this.servicioTupa = servicioTupa;
    }

    public String getServicioTupa() {
        return servicioTupa;
    }

    public void setUsoPropuesto(String usoPropuesto) {
        this.usoPropuesto = usoPropuesto;
    }

    public String getUsoPropuesto() {
        return usoPropuesto;
    }

    public void setTipoEnvase(String tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    public String getTipoEnvase() {
        return tipoEnvase;
    }
}
