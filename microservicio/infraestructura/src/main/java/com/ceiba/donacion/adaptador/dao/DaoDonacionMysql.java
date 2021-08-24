package com.ceiba.donacion.adaptador.dao;

import java.util.List;

import com.ceiba.donacion.modelo.dto.DtoDonacion;
import com.ceiba.donacion.puerto.dao.DaoDonacion;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;


@Component
public class DaoDonacionMysql implements DaoDonacion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="donacion", value="listar")
    private static String sqlListar;

    public DaoDonacionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoDonacion> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoDonacion());
    }

	@Override
	public DtoDonacion consultar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
