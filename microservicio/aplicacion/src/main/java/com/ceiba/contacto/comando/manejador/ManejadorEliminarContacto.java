package com.ceiba.contacto.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.contacto.servicio.ServicioEliminarContacto;
import com.ceiba.manejador.ManejadorComando;


@Component
public class ManejadorEliminarContacto implements ManejadorComando<Long> {

    private final ServicioEliminarContacto servicioEliminarContacto;

    public ManejadorEliminarContacto(ServicioEliminarContacto servicioEliminarContacto) {
        this.servicioEliminarContacto = servicioEliminarContacto;
    }

    public void ejecutar(Long idContacto) {
        this.servicioEliminarContacto.ejecutar(idContacto);
    }
}
