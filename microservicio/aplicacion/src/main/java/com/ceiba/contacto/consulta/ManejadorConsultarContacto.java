package com.ceiba.contacto.consulta;

import org.springframework.stereotype.Component;

import com.ceiba.contacto.modelo.dto.DtoContacto;
import com.ceiba.contacto.puerto.dao.DaoContacto;

@Component
public class ManejadorConsultarContacto {

	private final DaoContacto daoContacto;

	public ManejadorConsultarContacto(DaoContacto daoContacto) {
		this.daoContacto = daoContacto;
	}

	public DtoContacto ejecutar(Long id){
		return this.daoContacto.consultar(id);
	}
}
