package com.ceiba.contacto.servicio.testdatabuilder;

import com.ceiba.contacto.modelo.entidad.Contacto;

public class ContactoTestDataBuilder {

	private Long id;
	private String nombre;
	private String numero;

	public ContactoTestDataBuilder() {
		this.id = 1L;
		this.nombre = "John Carrillo";
		this.numero = "3004230343";
	}

	public ContactoTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public ContactoTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ContactoTestDataBuilder conNumero(String numero) {
		this.numero = numero;
		return this;
	}

	public Contacto build() {
		return new Contacto(this.id, this.nombre, this.numero);
	}
}
