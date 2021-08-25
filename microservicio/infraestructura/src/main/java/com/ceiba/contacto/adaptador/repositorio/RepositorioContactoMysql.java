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
    private static String sqlCrearContacto;

    @SqlStatement(namespace="contacto", value="actualizar")
    private static String sqlActualizarContacto;

    @SqlStatement(namespace="contacto", value="eliminar")
    private static String sqlEliminarContacto;

    @SqlStatement(namespace="contacto", value="existe")
    private static String sqlExisteContacto;

    @SqlStatement(namespace="contacto", value="existeExcluyendoId") 
    private static String sqlExisteExcluyendoIdContacto;

    public RepositorioContactoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        super(customNamedParameterJdbcTemplate);
    }

    @Override
	protected String getSqlCrear() {
		return sqlCrearContacto;
	}

	@Override
	protected String getSqlActualizar() {
		return sqlActualizarContacto;
	}

	@Override
	protected String getSqlEliminar() {
		return sqlEliminarContacto;
	}

	@Override
	protected String getSqlExiste() {
		return sqlExisteContacto;
	}

	@Override
	protected String getSqlExisteExcluyendoId() {
		return sqlExisteExcluyendoIdContacto;
	}

}
