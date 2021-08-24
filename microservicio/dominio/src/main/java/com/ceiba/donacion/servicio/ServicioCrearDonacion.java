package com.ceiba.donacion.servicio;

import com.ceiba.donacion.modelo.entidad.Donacion;
import com.ceiba.donacion.puerto.repositorio.RepositorioDonacion;
import com.ceiba.mascota.modelo.entidad.Mascota;

public class ServicioCrearDonacion {

	private final RepositorioDonacion repositorioDonacion;


	public ServicioCrearDonacion(RepositorioDonacion repositorioDonacion) {
		this.repositorioDonacion = repositorioDonacion;
	}

	public Long ejecutar(Donacion donacion) {
        return this.repositorioDonacion.crear(donacion);
    }

}
