package com.ceiba.raza.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.raza.modelo.dto.DtoRaza;
import com.ceiba.raza.puerto.dao.DaoRaza;

@Component
public class ManejadorListarRaza {

	private final DaoRaza daoRaza;

	public ManejadorListarRaza(DaoRaza daoRaza) {
		this.daoRaza = daoRaza;
	}

	public List<DtoRaza> ejecutar(){
		return this.daoRaza.listar();
	}
}
