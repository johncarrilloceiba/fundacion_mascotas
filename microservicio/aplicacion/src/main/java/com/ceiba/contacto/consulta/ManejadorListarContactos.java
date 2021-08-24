package com.ceiba.contacto.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.contacto.modelo.dto.DtoContacto;
import com.ceiba.contacto.puerto.dao.DaoContacto;

@Component
public class ManejadorListarContactos {

	private final DaoContacto daoContacto;

	public ManejadorListarContactos(DaoContacto daoContacto) {
		this.daoContacto = daoContacto;
	}

	public List<DtoContacto> ejecutar(){
		return this.daoContacto.listar();
	}
}
