package com.ceiba.raza.servicio;

import com.ceiba.raza.puerto.repositorio.RepositorioRaza;

public class ServicioEliminarRaza {

	private final RepositorioRaza repositorioRaza;

	public ServicioEliminarRaza(RepositorioRaza repositorioRaza) {
		this.repositorioRaza = repositorioRaza;
	}
	
	public void ejecutar(Long id) {
        this.repositorioRaza.eliminar(id);
    }
}
