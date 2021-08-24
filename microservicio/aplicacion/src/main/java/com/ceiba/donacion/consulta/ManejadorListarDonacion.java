package com.ceiba.donacion.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.donacion.modelo.dto.DtoDonacion;
import com.ceiba.donacion.puerto.dao.DaoDonacion;

@Component
public class ManejadorListarDonacion {

	private final DaoDonacion daoDonacion;

	public ManejadorListarDonacion(DaoDonacion daoDonacion) {
		this.daoDonacion = daoDonacion;
	}

	public List<DtoDonacion> ejecutar(){
		return this.daoDonacion.listar();
	}
}
