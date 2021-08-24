package com.ceiba.contacto.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.contacto.comando.ComandoContacto;
import com.ceiba.contacto.comando.fabrica.FabricaContacto;
import com.ceiba.contacto.modelo.entidad.Contacto;
import com.ceiba.contacto.servicio.ServicioActualizarContacto;
import com.ceiba.manejador.ManejadorComando;

@Component
public class ManejadorActualizarContacto implements ManejadorComando<ComandoContacto> {

	private final FabricaContacto fabricaContacto;
    private final ServicioActualizarContacto servicioActualizarContacto;

    public ManejadorActualizarContacto(FabricaContacto fabricaContacto, ServicioActualizarContacto servicioActualizarContacto) {
        this.fabricaContacto = fabricaContacto;
        this.servicioActualizarContacto = servicioActualizarContacto;
    }

    public void ejecutar(ComandoContacto comandoContacto) {
        Contacto contacto = this.fabricaContacto.crear(comandoContacto);
        this.servicioActualizarContacto.ejecutar(contacto);
    }
}
