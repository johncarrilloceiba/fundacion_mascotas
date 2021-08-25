package com.ceiba.mascota.adaptador.repositorio;

import org.springframework.stereotype.Repository;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.mascota.modelo.entidad.Mascota;
import com.ceiba.mascota.puerto.repositorio.RepositorioMascota;
import com.ceiba.repositoriogenerico.RepositorioGenericoMysql;

@Repository
public class RepositorioMascotaMysql extends RepositorioGenericoMysql<Mascota> implements RepositorioMascota {

    @SqlStatement(namespace="mascota", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="mascota", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="mascota", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="mascota", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="mascota", value="existeExcluyendoId") 
    private static String sqlExisteExcluyendoId;

    public RepositorioMascotaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
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
