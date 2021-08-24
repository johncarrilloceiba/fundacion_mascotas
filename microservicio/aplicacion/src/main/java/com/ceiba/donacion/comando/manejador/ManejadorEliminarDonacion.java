package com.ceiba.donacion.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.donacion.servicio.ServicioEliminarDonacion;
import com.ceiba.manejador.ManejadorComando;


@Component
public class ManejadorEliminarDonacion implements ManejadorComando<Long> {

    private final ServicioEliminarDonacion servicioEliminarDonacion;

    public ManejadorEliminarDonacion(ServicioEliminarDonacion servicioEliminarDonacion) {
        this.servicioEliminarDonacion = servicioEliminarDonacion;
    }

    public void ejecutar(Long idDonacion) {
        this.servicioEliminarDonacion.ejecutar(idDonacion);
    }
}
