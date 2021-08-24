package com.ceiba.contacto.servicio.testdatabuilder;

import com.ceiba.contacto.comando.ComandoContacto;

public class ComandoContactoTestDataBuilder {

	private Long id;
	private String nombre;
	private String numero;

	public ComandoContactoTestDataBuilder() {
		this.id = 1L;
		this.nombre = "Juan Pedro";
		this.numero = "3004230343";
	}

	public ComandoContactoTestDataBuilder setId(Long id) {
		this.id = id;
		return this;
	}

	public ComandoContactoTestDataBuilder setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ComandoContactoTestDataBuilder setNumero(String numero) {
		this.numero = numero;
		return this;
	}

	public ComandoContacto build() {
		return new ComandoContacto(id, nombre, numero);
	}
	
}
