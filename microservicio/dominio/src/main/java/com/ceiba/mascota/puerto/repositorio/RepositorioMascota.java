package com.ceiba.mascota.puerto.repositorio;

import com.ceiba.mascota.modelo.entidad.Mascota;

public interface RepositorioMascota {

	public Long crear(Mascota mascota);

	public void actualizar(Mascota mascota);

	public void eliminar(Long id);

	public boolean existe(String nombre);

	boolean existeExcluyendoId(Long id,String nombre);
}
