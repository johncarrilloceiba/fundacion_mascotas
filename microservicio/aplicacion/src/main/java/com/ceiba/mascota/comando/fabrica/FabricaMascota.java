package com.ceiba.mascota.comando.fabrica;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.ceiba.mascota.comando.ComandoMascota;
import com.ceiba.mascota.modelo.entidad.Mascota;
import com.ceiba.raza.modelo.entidad.Raza;

@Component
public class FabricaMascota {

	public Mascota crear(ComandoMascota comandoMascota, Raza raza) {
		return new Mascota(comandoMascota.getId(), comandoMascota.getNombre(),
				LocalDateTime.parse(comandoMascota.getFechaNacimiento()), raza);
	}
}
