package com.ceiba.mascota.consulta;

import org.springframework.stereotype.Component;

import com.ceiba.mascota.modelo.dto.DtoMascota;
import com.ceiba.mascota.puerto.dao.DaoMascota;

@Component
public class ManejadorConsultarMascota {

	private final DaoMascota daoMascota;

	public ManejadorConsultarMascota(DaoMascota daoMascota) {
		this.daoMascota = daoMascota;
	}
	
	public DtoMascota ejecutar(Long id){
		return this.daoMascota.consultar(id);
	}
}
