package pe.gob.senasa.interfaces;

import java.util.ArrayList;

import pe.gob.senasa.bean.Area;
import pe.gob.senasa.bean.DocType;
import pe.gob.senasa.bean.Entidad;
import pe.gob.senasa.bean.Funcionario;
import pe.gob.senasa.bean.SubArea;
import pe.gob.senasa.bean.SubEntidad;
import pe.gob.senasa.bean.SubTipo;


public interface FuncionarioInterface {

    public ArrayList<Area> obtenerAreas();

    public ArrayList<SubArea> obtenerSubareas(String codigoPadre);

    public ArrayList<Funcionario> obtenerFuncionarios(String codigoSubArea,
                                                      String codigoArea);

    public ArrayList<Entidad> obtenerEntidades();

    public ArrayList<DocType> obtenerTipos();

    public ArrayList<SubTipo> obtenerSubTipos(String tipo);

    public ArrayList<Entidad> obtenerEntidadesPorFiltro(String filtro,
                                                        String filtro2);

    public ArrayList<SubEntidad> obtenerSubentidades(String codigoEntidad);

    public Funcionario obtenerJefeInmediato(String codigoFuncionario);

    public ArrayList<Funcionario> obtenerFuncionariosSubordinados(String codigoSubArea,
                                                                  String codigoArea,
                                                                  String codigoFuncionario);

    public ArrayList<Funcionario> buscarFuncionariosPorNombre(String nombre);

    public boolean validarUsuario(String login, String pass,
                                  String stringConnection);

    public int autenticarUsuario(String login, String pass);

    public Funcionario obtenerFuncionarioPorUserName(String userName);

    public ArrayList<DocType> obtenerTiposIE(String datoIE);

    public ArrayList<Funcionario> obtenerReemplazo(String userName);

    public Funcionario obtenerJefePorSede(String codSede, String codRol);

    public Funcionario obtenerJefePorDepartamento(String codDepartamento,
                                                  String codRol);

    // public String obtenerFirma(String codServicio, String codCentroTramite, String tipoFirma);

    public String buscarDestinatarioPorCentroTramite(String centTraminte,
                                                                            String procTupa);
}
