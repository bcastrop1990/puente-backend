package pe.gob.senasa.gestion;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import pe.gob.senasa.bean.Funcionario;
import pe.gob.senasa.dao.FuncionarioDAO;
import pe.gob.senasa.db.SenasaSQL;
import pe.gob.senasa.helper.DBHelper;


public class GestionFuncionario {
    private FuncionarioDAO funcDAO = null;
    protected static Logger logger = Logger.getLogger(GestionFuncionario.class);
    private DBHelper helper;
    public GestionFuncionario() {
        super();
        helper = new DBHelper(SenasaSQL.dsFuncionario);
        funcDAO = new FuncionarioDAO();
    }
    
    public ArrayList<Funcionario> obtenerFuncionarioConAsistentes(String userName) {
        ArrayList<Funcionario> resultado = new ArrayList<Funcionario>();
        Connection con = null;
        try {
            con = helper.getConnection();
            Funcionario f = funcDAO.obtenerFuncionarioPorUserName(con, userName);
            if (f != null) {
                resultado.add(f);
                ArrayList<Funcionario> asistentes = funcDAO.buscarAsistentesPorFuncionario(con, f.getUserName());
                for (Funcionario a : asistentes) {
                    Funcionario f2 = funcDAO.obtenerFuncionarioPorUserName(con, a.getUserName());
                    if (f2 != null) {
                        f2.setNombre(f2.getNombre());
                        resultado.add(f2);
                    }
                }
            }
        } catch (SQLException e) {
            logger.debug("SQLException: " + e.getMessage());
            logger.fatal(e);
        } catch (Exception e) {
            logger.debug("Exception: " + e.getMessage());
            logger.fatal(e);
        } finally {
            funcDAO.cleanup(con);
        }
        return resultado;
    }    
}
