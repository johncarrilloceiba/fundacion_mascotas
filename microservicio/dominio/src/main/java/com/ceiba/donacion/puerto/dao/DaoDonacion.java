package com.ceiba.donacion.puerto.dao;

import java.util.List;

import com.ceiba.donacion.modelo.dto.DtoDonacion;

public interface DaoDonacion {

	public List<DtoDonacion> listar();

	public DtoDonacion consultar(Long id);
}
