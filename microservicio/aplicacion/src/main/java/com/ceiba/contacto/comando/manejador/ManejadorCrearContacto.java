package com.ceiba.contacto.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.contacto.comando.ComandoContacto;
import com.ceiba.contacto.comando.fabrica.FabricaContacto;
import com.ceiba.contacto.modelo.entidad.Contacto;
import com.ceiba.contacto.servicio.ServicioCrearContacto;
import com.ceiba.manejador.ManejadorComandoRespuesta;

@Component
public class ManejadorCrearContacto implements ManejadorComandoRespuesta<ComandoContacto, ComandoRespuesta<Long>> {

    private final FabricaContacto fabricaContacto;
    private final ServicioCrearContacto servicioCrearContacto;

    public ManejadorCrearContacto(FabricaContacto fabricaContacto, ServicioCrearContacto servicioCrearContacto) {
        this.fabricaContacto = fabricaContacto;
        this.servicioCrearContacto = servicioCrearContacto;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoContacto comandoContacto) {
        Contacto contacto = this.fabricaContacto.crear(comandoContacto);
        return new ComandoRespuesta<>(this.servicioCrearContacto.ejecutar(contacto));
    }
}
