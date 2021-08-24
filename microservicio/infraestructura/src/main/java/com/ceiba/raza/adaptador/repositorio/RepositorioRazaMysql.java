package com.ceiba.raza.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.raza.modelo.entidad.Raza;
import com.ceiba.raza.puerto.repositorio.RepositorioRaza;

@Repository
public class RepositorioRazaMysql implements RepositorioRaza {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

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
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Raza raza) {
        return this.customNamedParameterJdbcTemplate.crear(raza, sqlCrear);
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
    public void actualizar(Raza raza) {
        this.customNamedParameterJdbcTemplate.actualizar(raza, sqlActualizar);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
    }
}
