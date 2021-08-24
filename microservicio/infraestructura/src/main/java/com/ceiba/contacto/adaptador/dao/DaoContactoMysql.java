package com.ceiba.contacto.adaptador.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.contacto.modelo.dto.DtoContacto;
import com.ceiba.contacto.puerto.dao.DaoContacto;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Component
public class DaoContactoMysql implements DaoContacto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="contacto", value="listar")
    private static String sqlListar;

    public DaoContactoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoContacto> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoContacto());
    }

	@Override
	public DtoContacto consultar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
