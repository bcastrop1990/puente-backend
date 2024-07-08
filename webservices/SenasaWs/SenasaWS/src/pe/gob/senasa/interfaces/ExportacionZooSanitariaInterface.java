package pe.gob.senasa.interfaces;

import java.util.ArrayList;

import pe.gob.senasa.bean.ExportacionZooSanitaria;


public interface ExportacionZooSanitariaInterface {
    
    public ArrayList obtenerRequisitosSanitariosExpoZoo(String partidaArancelaria, String paisProcedencia, String usoDestino);
    
    public ExportacionZooSanitaria obtenerExportacionZooXNoCertificado(String noCertificado);
    
    public ArrayList<ExportacionZooSanitaria> obtenerExportacionZooxSolicitante(String dniRuc);
    
    public Boolean guardarExportacionZoo(ExportacionZooSanitaria expoZoo);
    
  public String obtenerNumeroCertificadoExpoZoo(String sede);
}
