package com.ceiba.mascota.adaptador.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.mascota.modelo.dto.DtoMascota;
import com.ceiba.mascota.puerto.dao.DaoMascota;

@Component
public class DaoMascotaMysql implements DaoMascota {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="mascota", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="mascota", value="consulta")
    private static String sqlConsulta;

    public DaoMascotaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoMascota> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoMascota());
    }

	@Override
	public DtoMascota consultar(Long id) {
		Map<String, Long> parametros = new HashMap<>();
		parametros.put("id", id);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlConsulta, parametros, new MapeoMascota());
	}
}
