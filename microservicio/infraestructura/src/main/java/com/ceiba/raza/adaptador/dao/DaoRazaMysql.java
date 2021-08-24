package com.ceiba.raza.adaptador.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.raza.modelo.dto.DtoRaza;
import com.ceiba.raza.puerto.dao.DaoRaza;

@Component
public class DaoRazaMysql implements DaoRaza {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="raza", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="raza", value="consulta")
    private static String sqlConsulta;

    public DaoRazaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoRaza> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoRaza());
    }

	@Override
	public DtoRaza consultar(Long id) {
		Map<String, Long> parametros = new HashMap<>();
		parametros.put("id", id);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlConsulta, parametros, new MapeoRaza());
	}
}
