package com.ceiba.repositoriogenerico;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;

@Repository
public abstract class RepositorioGenericoMysql<T> {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    protected RepositorioGenericoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    public Long crear(T entidad) {
        return this.customNamedParameterJdbcTemplate.crear(entidad, this.getSqlCrear());
    }

    public Integer eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(this.getSqlEliminar(), paramSource);
    }

    public boolean existe(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(this.getSqlExiste(),paramSource, Boolean.class);
    }

    public Integer actualizar(T entidad) {
        return this.customNamedParameterJdbcTemplate.actualizar(entidad, this.getSqlActualizar());
    }

    public boolean existeExcluyendoId(Long id, String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(this.getSqlExisteExcluyendoId(),paramSource, Boolean.class);
    }

	protected abstract String getSqlCrear();

	protected abstract String getSqlActualizar();

	protected abstract String getSqlEliminar();

	protected abstract String getSqlExiste();

	protected abstract String getSqlExisteExcluyendoId();

    
}
