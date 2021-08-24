package com.ceiba.donacion.servicio;

import com.ceiba.donacion.puerto.repositorio.RepositorioDonacion;

public class ServicioEliminarDonacion {

	private final RepositorioDonacion repositorioDonacion;

	public ServicioEliminarDonacion(RepositorioDonacion repositorioDonacion) {
		this.repositorioDonacion = repositorioDonacion;
	}
	
	public void ejecutar(Long id) {
        this.repositorioDonacion.eliminar(id);
    }
}
