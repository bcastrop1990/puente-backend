package com.senasa.bpm.ng.dao;

import com.senasa.bpm.ng.model.bean.ObservacionBean;

import java.math.BigDecimal;
import java.util.List;

public interface SeguridadDao {
    BigDecimal validarConexion(String p_Usuario, String p_Password);
}
