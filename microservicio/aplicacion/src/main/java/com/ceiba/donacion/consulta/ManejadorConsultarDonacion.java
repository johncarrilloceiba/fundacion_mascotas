package com.ceiba.donacion.consulta;

import org.springframework.stereotype.Component;

import com.ceiba.donacion.modelo.dto.DtoDonacion;
import com.ceiba.donacion.puerto.dao.DaoDonacion;

@Component
public class ManejadorConsultarDonacion {

	private final DaoDonacion daoDonacion;

	public ManejadorConsultarDonacion (DaoDonacion daoDonacion) {
		this.daoDonacion = daoDonacion;
	}
	
	public DtoDonacion ejecutar(Long id){
		return this.daoDonacion.consultar(id);
	}
}
