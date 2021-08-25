package com.ceiba.donacion.servicio;

import com.ceiba.donacion.modelo.entidad.Donacion;
import com.ceiba.donacion.puerto.repositorio.RepositorioDonacion;

public class ServicioActualizarDonacion {

	private final RepositorioDonacion repositorioDonacion;

	public ServicioActualizarDonacion(RepositorioDonacion repositorioDonacion) {
		this.repositorioDonacion = repositorioDonacion;
	}
	
	public Integer ejecutar(Donacion donacion) {
        return this.repositorioDonacion.actualizar(donacion);
    }

}
