package com.ceiba.raza.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.raza.modelo.dto.DtoRaza;

public class MapeoRaza implements RowMapper<DtoRaza>, MapperResult {

    @Override
    public DtoRaza mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("raza_id");
        String nombre = resultSet.getString("raza_nombre");

        return new DtoRaza(id, nombre);
    }

}
