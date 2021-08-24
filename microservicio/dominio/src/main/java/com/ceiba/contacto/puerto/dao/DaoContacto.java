package com.ceiba.contacto.puerto.dao;

import java.util.List;

import com.ceiba.contacto.modelo.dto.DtoContacto;

public interface DaoContacto {

	public List<DtoContacto> listar();

	public DtoContacto consultar(Long id);
}
