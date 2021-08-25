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
    private static String sqlCrearDonacion;

    @SqlStatement(namespace="donacion", value="actualizar")
    private static String sqlActualizarDonacion;

    @SqlStatement(namespace="donacion", value="eliminar")
    private static String sqlEliminarDonacion;

    private static String sqlExiste;
    private static String sqlExisteExcluyendoId;

    public RepositorioDonacionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
    	super(customNamedParameterJdbcTemplate);
    }

    @Override
	protected String getSqlCrear() {
		return sqlCrearDonacion;
	}

	@Override
	protected String getSqlActualizar() {
		return sqlActualizarDonacion;
	}

	@Override
	protected String getSqlEliminar() {
		return sqlEliminarDonacion;
	}

	@Override
	protected String getSqlExiste() {
		return sqlExiste;
	}

	@Override
	protected String getSqlExisteExcluyendoId() {
		return sqlExisteExcluyendoId;
	}

}
