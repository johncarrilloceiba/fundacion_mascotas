package com.ceiba.donacion.servicio;

import com.ceiba.donacion.puerto.repositorio.RepositorioDonacion;

public class ServicioEliminarDonacion {

	private final RepositorioDonacion repositorioDonacion;

	public ServicioEliminarDonacion(RepositorioDonacion repositorioDonacion) {
		this.repositorioDonacion = repositorioDonacion;
	}
	
	public Integer ejecutar(Long id) {
        return this.repositorioDonacion.eliminar(id);
    }
}
