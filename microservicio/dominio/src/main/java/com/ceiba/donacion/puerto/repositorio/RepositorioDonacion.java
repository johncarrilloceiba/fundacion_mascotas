package com.ceiba.donacion.puerto.repositorio;

import com.ceiba.donacion.modelo.entidad.Donacion;

public interface RepositorioDonacion {

	public Long crear(Donacion donacion);

	public Integer actualizar(Donacion donacion);

	public Integer eliminar(Long id);

}
