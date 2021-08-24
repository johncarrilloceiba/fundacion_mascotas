package com.ceiba.donacion.adaptador.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ceiba.donacion.modelo.dto.DtoDonacion;
import com.ceiba.donacion.puerto.dao.DaoDonacion;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;


@Component
public class DaoDonacionMysql implements DaoDonacion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="donacion", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="donacion", value="consulta")
    private static String sqlConsulta;

    public DaoDonacionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoDonacion> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoDonacion());
    }

	@Override
	public DtoDonacion consultar(Long id) {
		Map<String, Long> parametros = new HashMap<>();
		parametros.put("id", id);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlConsulta, parametros, new MapeoDonacion());
	}
}
