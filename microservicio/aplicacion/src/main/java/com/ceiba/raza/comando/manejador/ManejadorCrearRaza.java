package com.ceiba.raza.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.raza.comando.ComandoRaza;
import com.ceiba.raza.comando.fabrica.FabricaRaza;
import com.ceiba.raza.modelo.entidad.Raza;
import com.ceiba.raza.servicio.ServicioCrearRaza;

@Component
public class ManejadorCrearRaza implements ManejadorComandoRespuesta<ComandoRaza, ComandoRespuesta<Long>> {

    private final FabricaRaza fabricaRaza;
    private final ServicioCrearRaza servicioCrearRaza;

    public ManejadorCrearRaza(FabricaRaza fabricaRaza, ServicioCrearRaza servicioCrearRaza) {
        this.fabricaRaza = fabricaRaza;
        this.servicioCrearRaza = servicioCrearRaza;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoRaza comandoRaza) {
        Raza raza = this.fabricaRaza.crear(comandoRaza);
        return new ComandoRespuesta<>(this.servicioCrearRaza.ejecutar(raza));
    }
}
