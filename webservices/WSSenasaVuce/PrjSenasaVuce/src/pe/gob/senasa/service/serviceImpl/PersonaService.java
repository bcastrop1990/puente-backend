package pe.gob.senasa.service.serviceImpl;

import pe.gob.senasa.dao.IPersonaDao;
import pe.gob.senasa.dao.daoImpl.PersonaDao;
import pe.gob.senasa.service.IPersonaService;

public class PersonaService implements IPersonaService {
    IPersonaDao personaDao=null;
    public PersonaService() {
        super();
        personaDao= new PersonaDao();
    }

    public pe.gob.senasa.bean.Persona obtenerDatosPersona(String txId,String personaId) {
        return personaDao.obtenerDatosPersona(txId,personaId);
    }
}
