package com.ceiba.raza.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.raza.comando.ComandoRaza;
import com.ceiba.raza.modelo.entidad.Raza;

@Component
public class FabricaRaza {

	public Raza crear(ComandoRaza comandoRaza) {
		return new Raza(comandoRaza.getId(), comandoRaza.getNombre());
	}
}
