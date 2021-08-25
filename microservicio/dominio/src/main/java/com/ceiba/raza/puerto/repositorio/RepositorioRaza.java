package com.ceiba.raza.puerto.repositorio;

import com.ceiba.raza.modelo.entidad.Raza;

public interface RepositorioRaza {

	public Long crear(Raza raza);

	public Integer actualizar(Raza raza);

	public void eliminar(Long id);

	public boolean existe(String nombre);

	boolean existeExcluyendoId(Long id,String nombre);
}
