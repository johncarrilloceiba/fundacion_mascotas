package com.ceiba.contacto.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.ceiba.contacto.modelo.dto.DtoContacto;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.jdbc.core.RowMapper;

public class MapeoContacto implements RowMapper<DtoContacto>, MapperResult {

    @Override
    public DtoContacto mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("cont_id");
        String nombre = resultSet.getString("cont_nombre");
        String numero = resultSet.getString("cont_numero");

        return new DtoContacto(id,nombre,numero);
    }

}
