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
    private static String sqlCrear;

    @SqlStatement(namespace="raza", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="raza", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="raza", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="raza", value="existeExcluyendoId") 
    private static String sqlExisteExcluyendoId;

    public RepositorioRazaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
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
		return sqlExiste;
	}

	@Override
	protected String getSqlExisteExcluyendoId() {
		return sqlExisteExcluyendoId;
	}

}
