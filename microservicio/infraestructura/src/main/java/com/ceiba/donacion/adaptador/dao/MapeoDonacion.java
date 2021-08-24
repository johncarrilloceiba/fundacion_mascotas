package com.ceiba.donacion.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.donacion.modelo.dto.DtoDonacion;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoUsuario;

public class MapeoDonacion implements RowMapper<DtoDonacion>, MapperResult {

    @Override
    public DtoDonacion mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("dona_id");
        Double valor = resultSet.getDouble("dona_valor");
        Long idMascota = resultSet.getLong("masc_id");
        LocalDateTime fechaCreacion = extraerLocalDateTime(resultSet, "dona_fecha_creacion");

        return new DtoDonacion(id, valor, fechaCreacion, idMascota);
    }

}
