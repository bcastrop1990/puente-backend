package pe.gob.senasa.service;

import pe.gob.senasa.bean.Persona;

public interface IPersonaService {
  public Persona obtenerDatosPersona(String txId,String personaId);
}
