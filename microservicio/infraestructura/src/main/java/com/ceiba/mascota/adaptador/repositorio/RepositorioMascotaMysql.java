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
    private static String sqlCrearMascota;

    @SqlStatement(namespace="mascota", value="actualizar")
    private static String sqlActualizarMascota;

    @SqlStatement(namespace="mascota", value="eliminar")
    private static String sqlEliminarMascota;

    @SqlStatement(namespace="mascota", value="existe")
    private static String sqlExisteMascota;

    @SqlStatement(namespace="mascota", value="existeExcluyendoId") 
    private static String sqlExisteExcluyendoIdMascota;

    public RepositorioMascotaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
    	super(customNamedParameterJdbcTemplate);
    }

    @Override
	protected String getSqlCrear() {
		return sqlCrearMascota;
	}

	@Override
	protected String getSqlActualizar() {
		return sqlActualizarMascota;
	}

	@Override
	protected String getSqlEliminar() {
		return sqlEliminarMascota;
	}

	@Override
	protected String getSqlExiste() {
		return sqlExisteMascota;
	}

	@Override
	protected String getSqlExisteExcluyendoId() {
		return sqlExisteExcluyendoIdMascota;
	}

}
