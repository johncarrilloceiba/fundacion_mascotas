package com.ceiba.mascota.puerto.repositorio;

import com.ceiba.mascota.modelo.entidad.Mascota;

public interface RepositorioMascota {

	public Long crear(Mascota mascota);

	public Integer actualizar(Mascota mascota);

	public Integer eliminar(Long id);

	public boolean existe(String nombre);

	boolean existeExcluyendoId(Long id,String nombre);
}
