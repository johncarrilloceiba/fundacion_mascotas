package com.ceiba.contacto.puerto.repositorio;

import com.ceiba.contacto.modelo.entidad.Contacto;

public interface RepositorioContacto {

	public Long crear(Contacto contacto);

	public Integer actualizar(Contacto contacto);

	public void eliminar(Long id);

	public boolean existe(String nombre);

	boolean existeExcluyendoId(Long id,String nombre);
}
