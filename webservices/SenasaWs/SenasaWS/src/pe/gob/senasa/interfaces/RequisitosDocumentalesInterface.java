package pe.gob.senasa.interfaces;

import java.util.ArrayList;
import java.util.List;

import pe.gob.senasa.bean.Adicional;
import pe.gob.senasa.bean.RequisitoServicio;
import pe.gob.senasa.bean.RequisitosDocumentales;
import pe.gob.senasa.bean.ValidaDocumentoPropio;


public interface RequisitosDocumentalesInterface {
    
    public ArrayList<RequisitosDocumentales> obtenerRequisitosDocumentales(String servicioTUPA);
    public ArrayList<RequisitoServicio> obtenerListaRequisitosPropios(String codigoServicio,String idPersona);
    public ValidaDocumentoPropio validarDocumentoPropio(ValidaDocumentoPropio prmDocPropio);
    public  List<Adicional> obtenerPredios(String idPersona);
}
