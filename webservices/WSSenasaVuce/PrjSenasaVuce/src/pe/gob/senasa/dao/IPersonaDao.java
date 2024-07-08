package pe.gob.senasa.dao;

import pe.gob.senasa.bean.Persona;

public interface IPersonaDao {    
    public Persona obtenerDatosPersona(String txId,String personaId);
}
