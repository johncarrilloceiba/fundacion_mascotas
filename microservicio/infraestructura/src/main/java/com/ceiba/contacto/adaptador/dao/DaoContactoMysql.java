package com.ceiba.contacto.adaptador.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @SqlStatement(namespace="contacto", value="consulta")
    private static String sqlConsulta;

    public DaoContactoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoContacto> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoContacto());
    }

	@Override
	public DtoContacto consultar(Long id) {
		Map<String, Long> parametros = new HashMap<>();
		parametros.put("id", id);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlConsulta, parametros, new MapeoContacto());
	}
}
