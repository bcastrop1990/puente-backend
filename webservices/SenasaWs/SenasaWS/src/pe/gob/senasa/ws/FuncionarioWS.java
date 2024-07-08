package pe.gob.senasa.ws;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;

import pe.gob.senasa.bean.Area;
import pe.gob.senasa.bean.DocType;
import pe.gob.senasa.bean.Entidad;
import pe.gob.senasa.bean.Funcionario;
import pe.gob.senasa.bean.SubArea;
import pe.gob.senasa.bean.SubEntidad;
import pe.gob.senasa.bean.SubTipo;
import pe.gob.senasa.dao.FuncionarioDAO;
import pe.gob.senasa.gestion.GestionFuncionario;
import pe.gob.senasa.interfaces.FuncionarioInterface;


/**
 * Manejo de información y operaciones de funcionarios.
 */
@XmlSeeAlso( { Funcionario.class })
@WebService(name = "Funcionario", serviceName = "Funcionario", targetNamespace = "http://funcionario.ws.senasa.gob.pe",
            portName = "FuncionarioPort")
public class FuncionarioWS implements FuncionarioInterface {
    FuncionarioDAO fDAO = null;

    /**
     */
    public FuncionarioWS() {
        fDAO = new FuncionarioDAO();
    }


    /**
     *
     * status: Terminado
     * @return
     */
    @WebMethod
    public ArrayList<Area> obtenerAreas() {
        return fDAO.obtenerAreas();
    }

    /**
     *
     * status: Terminado
     * @param codigoPadre
     * @return
     */
    @WebMethod
    public ArrayList<SubArea> obtenerSubareas(String codigoPadre) {
        return fDAO.obtenerSubareas(codigoPadre);
    }

    /**
     *
     * status: Terminado
     * @param codigoSubArea
     * @param codigoArea
     * @return
     */
    @WebMethod
    public ArrayList<Funcionario> obtenerFuncionarios(String codigoSubArea, String codigoArea) {
        return fDAO.obtenerFuncionariosConCargo(codigoSubArea, codigoArea);
    }

    /**
     *
     * status: Terminado
     * @return
     */
    @WebMethod
    public ArrayList<Entidad> obtenerEntidades() {
        return fDAO.obtenerEntidades();
    }

    /**
     *
     * status: Terminado
     * @param codigoEntidad
     * @return
     */
    @WebMethod
    public ArrayList<SubEntidad> obtenerSubentidades(String codigoEntidad) {
        return fDAO.obtenerSubentidades(codigoEntidad);
    }


    /**
     * @param codigoFuncionario
     * @return
     */
    @WebMethod
    public Funcionario obtenerJefeInmediato(String codigoFuncionario) {
        return fDAO.obtenerJefeInmediato(codigoFuncionario);
    }

    /**
     * @param codigoSubArea
     * @param codigoArea
     * @param codigoFuncionario
     * @return
     */
    @WebMethod
    public ArrayList<Funcionario> obtenerFuncionariosSubordinados(String codigoSubArea, String codigoArea, String codigoFuncionario) {
        return fDAO.obtenerFuncionariosSubordinados(codigoSubArea, codigoArea, codigoFuncionario);
    }


    @WebMethod
    public boolean validarUsuario(String login, String pass, String stringConnection) {
        return fDAO.validarUsuario(login, pass, stringConnection);
    }

    @WebMethod
    public int autenticarUsuario(@WebParam(name = "login")
        String login, @WebParam(name = "password")
        String password) {
        return fDAO.autenticarUsuario(login, password);
    }


    /**
     * @param filtro
     * @return
     */
    @WebMethod
    public ArrayList<Entidad> obtenerEntidadesPorFiltro(String filtro, String filtro2) {
        return fDAO.obtenerEntidadesPorFiltro(filtro, filtro2);
    }

    @WebMethod
    public ArrayList<DocType> obtenerTipos() {
        return fDAO.obtenerTipos();
    }

    @WebMethod
    public ArrayList<SubTipo> obtenerSubTipos(String tipo) {
        return fDAO.obtenerSubTipos(tipo);
    }

    @WebMethod
    public Funcionario obtenerFuncionarioPorUserName(String userName) {
        return fDAO.obtenerFuncionarioPorUserName(userName);
    }

    @WebMethod
    public Funcionario obtenerFuncionarioPorNombre(String nombrePersona) {
        return fDAO.obtenerFuncionarioPorNombre(nombrePersona);
    }

    @WebMethod
    public Funcionario obtenerFuncionarioPorIdPersona(@WebParam(name = "idPersona")
        String idPersona) {
        return fDAO.obtenerFuncionarioPorIdPersona(idPersona);
    }

    @WebMethod
    public ArrayList<DocType> obtenerTiposIE(String datoIE) {
        return fDAO.obtenerTiposIE(datoIE);
    }

    @WebMethod
    public ArrayList<Funcionario> obtenerReemplazo(String userName) {
        return fDAO.obtenerReemplazo(userName);
    }

    @WebMethod
    public Funcionario obtenerJefePorSede(String codSede, String codRol) {
        return fDAO.obtenerJefePorSede(codSede, codRol);
    }

    @WebMethod
    public Funcionario obtenerJefePorDepartamento(String codDepartamento, String codRol) {
        return fDAO.obtenerJefePorDepartamento(codDepartamento, codRol);
    }

    @WebMethod
    public ArrayList<Funcionario> buscarFuncionariosPorNombre(String nombre) {
        return fDAO.buscarFuncionariosPorNombre(nombre);
    }

    @WebMethod
    public String buscarDestinatarioPorCentroTramite(String centTraminte, String procTupa) {
        return fDAO.buscarDestinatarioPorCentroTramite(centTraminte, procTupa);
    }

    @WebMethod
    public ArrayList<Funcionario> obtenerFuncionarioConAsistentes(String userName) {
        return new GestionFuncionario().obtenerFuncionarioConAsistentes(userName);
    }

}
