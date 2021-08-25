package com.ceiba.mascota.servicio;

import com.ceiba.mascota.puerto.repositorio.RepositorioMascota;

public class ServicioEliminarMascota {

	private final RepositorioMascota repositorioMascota;

	public ServicioEliminarMascota(RepositorioMascota repositorioMascota) {
		this.repositorioMascota = repositorioMascota;
	}
	
	public Integer ejecutar(Long id) {
        return this.repositorioMascota.eliminar(id);
    }
}
