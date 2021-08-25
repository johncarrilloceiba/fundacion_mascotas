package com.ceiba.raza.adaptador.repositorio;

import org.springframework.stereotype.Repository;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.raza.modelo.entidad.Raza;
import com.ceiba.raza.puerto.repositorio.RepositorioRaza;
import com.ceiba.repositoriogenerico.RepositorioGenericoMysql;

@Repository
public class RepositorioRazaMysql extends RepositorioGenericoMysql<Raza> implements RepositorioRaza {

    @SqlStatement(namespace="raza", value="crear")
    private static String sqlCrearRaza;

    @SqlStatement(namespace="raza", value="actualizar")
    private static String sqlActualizarRaza;

    @SqlStatement(namespace="raza", value="eliminar")
    private static String sqlEliminarRaza;

    @SqlStatement(namespace="raza", value="existe")
    private static String sqlExisteRaza;

    @SqlStatement(namespace="raza", value="existeExcluyendoId") 
    private static String sqlExisteExcluyendoIdRaza;

    public RepositorioRazaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
    	super(customNamedParameterJdbcTemplate);
    }

	@Override
	protected String getSqlCrear() {
		return sqlCrearRaza;
	}

	@Override
	protected String getSqlActualizar() {
		return sqlActualizarRaza;
	}

	@Override
	protected String getSqlEliminar() {
		return sqlEliminarRaza;
	}

	@Override
	protected String getSqlExiste() {
		return sqlExisteRaza;
	}

	@Override
	protected String getSqlExisteExcluyendoId() {
		return sqlExisteExcluyendoIdRaza;
	}

}
