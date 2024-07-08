package pe.gob.senasa.interfaces;

import java.util.ArrayList;
import java.util.Date;

import pe.gob.senasa.bean.Importador;
import pe.gob.senasa.bean.PredioCPE;
import pe.gob.senasa.bean.Recibo;
import pe.gob.senasa.bean.ReciboServicio;
import pe.gob.senasa.bean.Solicitante;
import pe.gob.senasa.bean.TipoDocIden;
import pe.gob.senasa.bean.TipoFiltro;


public interface SolicitanteInterface {
    
    public Solicitante obtenerSolicitante(String tipoDoc, String numeroDoc);
    
  public ArrayList<Solicitante> obtenerSolicitantesFiltrados(String tipoFiltro, String valorFiltro);
    
    public Solicitante obtenerSolicitanteXidPersona(String idPersona);
    
    public Boolean adicionarSolicitante(Solicitante argSolicitante);
    
    public ArrayList<PredioCPE> obtenerPrediosCPESolicitante(String dniRucSolicitante);
    
    public Boolean validarAlmacenGuardacustodia(String dniRucSolicitante, String registro);
    
    public Boolean validarGermoplasma(String dniRucSolicitante, String registro);
    
    public Boolean validarRegistroCPE(String dniRucSolicitante, String registro);
    
    public Double obtenerSaldoFavorSolicitante(String dniRucSolicitante);
    
    public String abonarSaldoFavorSolicitantePapeleta(String rucAgenteAduanas,String papeletaID,
                                                     Double excedente);
    
    public String abonarSaldoFavorSolicitanteNotaAbono(String rucAgenteAduanas,String notaabono,
                                                 Double excedente);
    
    public String crearDocPapeleta(String dniRucSolicitante,
                                  String tipodeposito,
                                  String numerodeposito,
                                  Date fechadeposito,
                                  Double montodepositado);
    
    public ArrayList<TipoDocIden> obtenerTiposDocInden();
    
  public ArrayList<TipoFiltro> obtenerTiposFiltroPersona();
    
  public ArrayList<Importador> obtenerImportadoresXPais(String codPais);
  public String cargarSaldo(String dniRucSolicitante, Double montoUtilizado);
  public String guardarRecibo(String numeroRecibo, String fechaRecibo, 
                                 String codigoCentroTramite, String dniRucSolicitante, String codigoExpediente, 
                                 Double montoPagado, Double montoRecibo, Double montoSaldo, String observacion, String urlRecibo, ArrayList<ReciboServicio> arrayRecibosServicios);
  
  //public Boolean guardarReciboServicio(String codigoRecibo, String codigoServicio, Double montoServicio, Double cantidad);
  public Recibo obtenerDatosRecibo(String codigoRecibo);
  public Boolean actualizaUrlRecibo(String codigoRecibo, String urlRecibo);
  public ArrayList<Solicitante> obtenerRepresentanteLegal(String codPersona);
  
}
