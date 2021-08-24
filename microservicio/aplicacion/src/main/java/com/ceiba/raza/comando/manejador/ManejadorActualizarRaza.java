package com.ceiba.raza.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.raza.comando.ComandoRaza;
import com.ceiba.raza.comando.fabrica.FabricaRaza;
import com.ceiba.raza.modelo.entidad.Raza;
import com.ceiba.raza.servicio.ServicioActualizarRaza;

@Component
public class ManejadorActualizarRaza implements ManejadorComando<ComandoRaza> {

	private final FabricaRaza fabricaRaza;
    private final ServicioActualizarRaza servicioActualizarRaza;

    public ManejadorActualizarRaza(FabricaRaza fabricaRaza, ServicioActualizarRaza servicioActualizarRaza) {
        this.fabricaRaza = fabricaRaza;
        this.servicioActualizarRaza = servicioActualizarRaza;
    }

    public void ejecutar(ComandoRaza comandoRaza) {
        Raza raza = this.fabricaRaza.crear(comandoRaza);
        this.servicioActualizarRaza.ejecutar(raza);
    }
}
