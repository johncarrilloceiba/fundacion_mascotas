package com.ceiba.raza.puerto.dao;

import java.util.List;

import com.ceiba.raza.modelo.dto.DtoRaza;

public interface DaoRaza {

	public List<DtoRaza> listar();

	public DtoRaza consultar(Long id);
}
