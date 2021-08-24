package com.ceiba.contacto.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.contacto.modelo.dto.DtoContacto;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoContacto implements RowMapper<DtoContacto>, MapperResult {

    @Override
    public DtoContacto mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("cont_id");
        String nombre = resultSet.getString("cont_nombre");
        String numero = resultSet.getString("cont_numero");

        return new DtoContacto(id,nombre,numero);
    }

}
