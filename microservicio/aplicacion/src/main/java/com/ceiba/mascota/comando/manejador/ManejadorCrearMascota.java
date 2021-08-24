package com.ceiba.mascota.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.mascota.comando.ComandoMascota;
import com.ceiba.mascota.comando.fabrica.FabricaMascota;
import com.ceiba.mascota.modelo.entidad.Mascota;
import com.ceiba.mascota.servicio.ServicioCrearMascota;
import com.ceiba.raza.modelo.dto.DtoRaza;
import com.ceiba.raza.modelo.entidad.Raza;
import com.ceiba.raza.parser.DtoRazaToEntity;
import com.ceiba.raza.puerto.dao.DaoRaza;


@Component
public class ManejadorCrearMascota implements ManejadorComandoRespuesta<ComandoMascota, ComandoRespuesta<Long>> {

    private final FabricaMascota fabricaMascota;
    private final ServicioCrearMascota servicioCrearMascota;
    private final DaoRaza daoRaza;

    public ManejadorCrearMascota(FabricaMascota fabricaMascota, ServicioCrearMascota servicioCrearMascota, DaoRaza daoRaza) {
        this.fabricaMascota = fabricaMascota;
        this.servicioCrearMascota = servicioCrearMascota;
        this.daoRaza = daoRaza;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoMascota comandoMascota) {
        DtoRaza dtoRaza = daoRaza.consultar(comandoMascota.getIdRaza());
        Raza raza = DtoRazaToEntity.dtoToEntity(dtoRaza);
        Mascota mascota = this.fabricaMascota.crear(comandoMascota, raza);
        return new ComandoRespuesta<>(this.servicioCrearMascota.ejecutar(mascota));
    }
}
