package pe.gob.senasa.interfaces;

import pe.gob.senasa.bean.Documento;
import pe.gob.senasa.bean.Firmante;
import pe.gob.senasa.bean.Informacion;


public interface DocumentosInterface {
    
  /**
   * Método que genera el documento resultante
   * @param idPlantilla Código de la plantilla a descargar desde ucm y reemplazar sus valores.
   * @param conPlantilla Informacion de la plantilla, este va a ser una clase con atributos.
  @return idDocumento
   */
   public String crearDocumento(String idPlantilla, Documento conPlantilla);
  
  
  /**
   * Obtiene la url del documento ingresado en UCM
   * @param idDocumento dId o copntentId del documento ingresado
   * @return url del documento
   */
  public String obtenerUrlDocumento(String idDocumento);


    /**
     * @param idPlantilla
     * @param conPlantilla
     * @return
     */
    public byte[] obtenerDocumento(String idPlantilla, Documento conPlantilla);


    /**
     * @param documentoFisico
     * @param nombre
     * @param documento
     * @return
     */
    public String ejecutarIngreso(byte[] documentoFisico, String nombre, Documento documento);
    
    public String generarDocumento(String nombrePlantilla,Informacion informacion);
    public String generarNumeroDocumento(String subTipo, String area, String subArea,String personaId);
    public Boolean eliminarNumeroDocumento(String numero);
    
    public Firmante obtenerFirmante(String codigoCentroTramite, String codigoServicio);
}
