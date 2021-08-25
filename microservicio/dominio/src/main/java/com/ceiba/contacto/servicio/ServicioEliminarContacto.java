package com.ceiba.contacto.servicio;

import com.ceiba.contacto.puerto.repositorio.RepositorioContacto;

public class ServicioEliminarContacto {

	private final RepositorioContacto repositorioContacto;

	public ServicioEliminarContacto(RepositorioContacto repositorioContacto) {
		this.repositorioContacto = repositorioContacto;
	}

	public Integer ejecutar(Long id) {
        return this.repositorioContacto.eliminar(id);
    }
}
