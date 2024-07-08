package com.senasa.bpm.ng.dao.impl;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.senasa.bpm.ng.model.bean.UsuarioBean;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UsuarioDaoImpl {
	
	@Autowired
	private JdbcTemplate template;
	
	private SimpleJdbcCall call;
	
	@PostConstruct
    public void init() {
        template.setResultsMapCaseInsensitive(true);
    }
	
	public UsuarioBean getData(String usrname) {
		call = new SimpleJdbcCall(template)
				.withCatalogName("Pkg_webseguridad")
				.withProcedureName("Getdata")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(
	                    new SqlParameter("Usrname", Types.VARCHAR),
	                    new SqlParameter("Idapp", Types.VARCHAR),
	                    new SqlParameter("Inlevelmenu", Types.NUMERIC))
				.returningResultSet("Cur_user", BeanPropertyRowMapper.newInstance(UsuarioBean.class))
				.returningResultSet("Cur_menu", BeanPropertyRowMapper.newInstance(Void.class))
				;
				
		Map<String, Object> out = call.execute(usrname, "", 0);
		return ((List<UsuarioBean>) out.get("Cur_user")).get(0);
	}

}
