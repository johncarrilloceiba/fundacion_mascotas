package com.ceiba.donacion.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.donacion.modelo.entidad.Donacion;
import com.ceiba.donacion.puerto.repositorio.RepositorioDonacion;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Repository
public class RepositorioDonacionMysql implements RepositorioDonacion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="donacion", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="donacion", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="donacion", value="eliminar")
    private static String sqlEliminar;

    public RepositorioDonacionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Donacion donacion) {
        return this.customNamedParameterJdbcTemplate.crear(donacion, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public void actualizar(Donacion donacion) {
        this.customNamedParameterJdbcTemplate.actualizar(donacion, sqlActualizar);
    }

}
