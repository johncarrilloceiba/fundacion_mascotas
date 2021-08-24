package com.ceiba.mascota.puerto.dao;

import java.util.List;

import com.ceiba.mascota.modelo.dto.DtoMascota;

public interface DaoMascota {

	public List<DtoMascota> listar();

	public DtoMascota consultar(Long id);
}
