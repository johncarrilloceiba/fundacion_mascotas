package com.ceiba.donacion.servicio;

import com.ceiba.donacion.modelo.entidad.Donacion;
import com.ceiba.donacion.puerto.repositorio.RepositorioDonacion;

public class ServicioActualizarDonacion {

	private final RepositorioDonacion repositorioDonacion;

	public ServicioActualizarDonacion(RepositorioDonacion repositorioDonacion) {
		this.repositorioDonacion = repositorioDonacion;
	}
	
	public void ejecutar(Donacion donacion) {
        this.repositorioDonacion.actualizar(donacion);
    }

}
