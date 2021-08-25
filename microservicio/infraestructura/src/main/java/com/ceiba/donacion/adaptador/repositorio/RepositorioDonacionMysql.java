package com.ceiba.donacion.adaptador.repositorio;

import org.springframework.stereotype.Repository;

import com.ceiba.donacion.modelo.entidad.Donacion;
import com.ceiba.donacion.puerto.repositorio.RepositorioDonacion;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.repositoriogenerico.RepositorioGenericoMysql;

@Repository
public class RepositorioDonacionMysql extends RepositorioGenericoMysql<Donacion> implements RepositorioDonacion {

    @SqlStatement(namespace="donacion", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="donacion", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="donacion", value="eliminar")
    private static String sqlEliminar;

    public RepositorioDonacionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
    	super(customNamedParameterJdbcTemplate);
    }

    @Override
	protected String getSqlCrear() {
		return sqlCrear;
	}

	@Override
	protected String getSqlActualizar() {
		return sqlActualizar;
	}

	@Override
	protected String getSqlEliminar() {
		return sqlEliminar;
	}

	@Override
	protected String getSqlExiste() {
		return null;
	}

	@Override
	protected String getSqlExisteExcluyendoId() {
		return null;
	}

}
