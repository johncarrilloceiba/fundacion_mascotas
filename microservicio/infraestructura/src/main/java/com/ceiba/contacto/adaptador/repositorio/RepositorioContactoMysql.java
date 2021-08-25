package com.ceiba.contacto.adaptador.repositorio;

import org.springframework.stereotype.Repository;

import com.ceiba.contacto.modelo.entidad.Contacto;
import com.ceiba.contacto.puerto.repositorio.RepositorioContacto;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.repositoriogenerico.RepositorioGenericoMysql;

@Repository
public class RepositorioContactoMysql extends RepositorioGenericoMysql<Contacto> implements RepositorioContacto {


    @SqlStatement(namespace="contacto", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="contacto", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="contacto", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="contacto", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="contacto", value="existeExcluyendoId") 
    private static String sqlExisteExcluyendoId;

    public RepositorioContactoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
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
