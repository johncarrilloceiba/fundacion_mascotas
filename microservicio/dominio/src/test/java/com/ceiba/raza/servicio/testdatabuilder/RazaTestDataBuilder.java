package com.ceiba.raza.servicio.testdatabuilder;

import com.ceiba.raza.modelo.entidad.Raza;

public class RazaTestDataBuilder {

	private Long id;
	private String nombre;

	public RazaTestDataBuilder() {
		this.id = 1L;
		this.nombre = "Bulldog";
	}

	public RazaTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public RazaTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public Raza build() {
		return new Raza(this.id, this.nombre);
	}
}
