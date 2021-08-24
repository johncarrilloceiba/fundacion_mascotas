package com.ceiba.mascota.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.mascota.servicio.ServicioEliminarMascota;


@Component
public class ManejadorEliminarMascota implements ManejadorComando<Long> {

    private final ServicioEliminarMascota servicioEliminarMascota;

    public ManejadorEliminarMascota(ServicioEliminarMascota servicioEliminarMascota) {
        this.servicioEliminarMascota = servicioEliminarMascota;
    }

    public void ejecutar(Long idMascota) {
        this.servicioEliminarMascota.ejecutar(idMascota);
    }
}
