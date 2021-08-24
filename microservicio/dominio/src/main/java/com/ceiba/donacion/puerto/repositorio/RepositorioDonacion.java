package com.ceiba.donacion.puerto.repositorio;

import com.ceiba.donacion.modelo.entidad.Donacion;

public interface RepositorioDonacion {

	public Long crear(Donacion donacion);

	public void actualizar(Donacion donacion);

	public void eliminar(Long id);

}
