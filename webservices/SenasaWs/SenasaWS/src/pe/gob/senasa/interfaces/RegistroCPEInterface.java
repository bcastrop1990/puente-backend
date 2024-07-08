package pe.gob.senasa.interfaces;

import java.util.ArrayList;
import java.util.List;

import pe.gob.senasa.bean.CpeGermpGC;
import pe.gob.senasa.bean.FuncionesEquipoTecnico;
import pe.gob.senasa.bean.RegistroCPE;


public interface RegistroCPEInterface {
    
    public ArrayList<FuncionesEquipoTecnico> obtenerFuncionesEquipoTecnicoCPE();
    
    public RegistroCPE obtenerRegistroCPE(String dniRuc);
    
    public boolean guardarRegistroCPE(RegistroCPE registroCPE);
    
    public List<CpeGermpGC> obtenerRegistrosCpeGermpGC(String nroDOC,String formato) ;
}
