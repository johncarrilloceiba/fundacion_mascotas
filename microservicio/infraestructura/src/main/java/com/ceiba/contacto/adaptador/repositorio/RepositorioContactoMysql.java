package com.ceiba.contacto.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.contacto.modelo.entidad.Contacto;
import com.ceiba.contacto.puerto.repositorio.RepositorioContacto;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Repository
public class RepositorioContactoMysql implements RepositorioContacto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

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
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Contacto contacto) {
        return this.customNamedParameterJdbcTemplate.crear(contacto, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Contacto contacto) {
        this.customNamedParameterJdbcTemplate.actualizar(contacto, sqlActualizar);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
    }
}
