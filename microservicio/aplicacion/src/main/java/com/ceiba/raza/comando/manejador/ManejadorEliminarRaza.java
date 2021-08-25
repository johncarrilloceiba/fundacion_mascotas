package com.ceiba.raza.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.raza.servicio.ServicioEliminarRaza;

@Component
public class ManejadorEliminarRaza implements ManejadorComando<Long> {

    private final ServicioEliminarRaza servicioEliminarRaza;

    public ManejadorEliminarRaza(ServicioEliminarRaza servicioEliminarRaza) {
        this.servicioEliminarRaza = servicioEliminarRaza;
    }

    public void ejecutar(Long idRaza) {
        this.servicioEliminarRaza.ejecutar(idRaza);
    }
}
