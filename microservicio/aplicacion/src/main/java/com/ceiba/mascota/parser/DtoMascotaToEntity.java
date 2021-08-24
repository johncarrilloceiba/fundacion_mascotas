package com.ceiba.mascota.parser;

import com.ceiba.mascota.modelo.dto.DtoMascota;
import com.ceiba.mascota.modelo.entidad.Mascota;
import com.ceiba.raza.modelo.dto.DtoRaza;
import com.ceiba.raza.modelo.entidad.Raza;

public class DtoMascotaToEntity {

	private DtoMascotaToEntity() {
	    throw new IllegalStateException("Utility class");
	 }
	
	public static Mascota dtoToEntity (DtoMascota dtoMascota, Raza raza) {
		return new Mascota(dtoMascota.getId(), dtoMascota.getNombre(), dtoMascota.getFechaNacimiento(), raza);
	}
}
