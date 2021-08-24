package com.ceiba.raza.parser;

import com.ceiba.raza.modelo.dto.DtoRaza;
import com.ceiba.raza.modelo.entidad.Raza;

public class DtoRazaToEntity {

	private DtoRazaToEntity() {
	    throw new IllegalStateException("Utility class");
	 }
	
	public static Raza dtoToEntity (DtoRaza dtoRaza) {
		return new Raza(dtoRaza.getId(), dtoRaza.getNombre());
	}
}
