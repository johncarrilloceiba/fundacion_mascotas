package com.ceiba.mascota.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.mascota.modelo.dto.DtoMascota;

public class MapeoMascota implements RowMapper<DtoMascota>, MapperResult {

    @Override
    public DtoMascota mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("masc_id");
        String nombre = resultSet.getString("masc_nombre");
        Long idRaza = resultSet.getLong("raza_id");
        Long idContacto = resultSet.getLong("cont_id");
        LocalDateTime fechaAdopcion = extraerLocalDateTime(resultSet, "masc_fecha_adopcion");
        LocalDateTime fechaNacimiento = extraerLocalDateTime(resultSet, "masc_fecha_nacimiento");

        return new DtoMascota(id, nombre, fechaNacimiento, fechaAdopcion, idContacto, idRaza);
    }

}
