package com.ceiba.mascota.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.mascota.comando.ComandoMascota;
import com.ceiba.mascota.comando.fabrica.FabricaMascota;
import com.ceiba.mascota.modelo.entidad.Mascota;
import com.ceiba.mascota.servicio.ServicioActualizarMascota;
import com.ceiba.raza.modelo.dto.DtoRaza;
import com.ceiba.raza.modelo.entidad.Raza;
import com.ceiba.raza.parser.DtoRazaToEntity;
import com.ceiba.raza.puerto.dao.DaoRaza;

@Component
public class ManejadorActualizarMascota implements ManejadorComando<ComandoMascota> {

	private final FabricaMascota fabricaMascota;
    private final ServicioActualizarMascota servicioActualizarMascota;
    private final DaoRaza daoRaza;

    public ManejadorActualizarMascota(FabricaMascota fabricaMascota, ServicioActualizarMascota servicioActualizarMascota, DaoRaza daoRaza) {
        this.fabricaMascota = fabricaMascota;
        this.servicioActualizarMascota = servicioActualizarMascota;
        this.daoRaza = daoRaza;
    }

    public void ejecutar(ComandoMascota comandoMascota) {
    	DtoRaza dtoRaza = daoRaza.consultar(comandoMascota.getIdRaza());
        Raza raza = DtoRazaToEntity.dtoToEntity(dtoRaza);
        Mascota mascota = this.fabricaMascota.crear(comandoMascota, raza);
        this.servicioActualizarMascota.ejecutar(mascota);
    }
}
