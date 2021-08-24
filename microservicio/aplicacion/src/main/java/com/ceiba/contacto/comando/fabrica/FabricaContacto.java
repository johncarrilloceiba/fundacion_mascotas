package com.ceiba.contacto.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.contacto.comando.ComandoContacto;
import com.ceiba.contacto.modelo.entidad.Contacto;

@Component
public class FabricaContacto {

	public Contacto crear(ComandoContacto comandoContacto) {
		return new Contacto(comandoContacto.getId(), comandoContacto.getNombre(),
				comandoContacto.getNumero());
	}
}
