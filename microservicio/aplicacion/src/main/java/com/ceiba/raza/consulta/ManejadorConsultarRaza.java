package com.ceiba.raza.consulta;

import org.springframework.stereotype.Component;

import com.ceiba.raza.modelo.dto.DtoRaza;
import com.ceiba.raza.puerto.dao.DaoRaza;

@Component
public class ManejadorConsultarRaza {

	private final DaoRaza daoRaza;

	public ManejadorConsultarRaza(DaoRaza daoRaza) {
		this.daoRaza = daoRaza;
	}
	
	public DtoRaza ejecutar(Long id){
		return this.daoRaza.consultar(id);
	}
}
