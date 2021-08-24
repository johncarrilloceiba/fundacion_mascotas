package com.ceiba.raza.servicio.testdatabuilder;

import com.ceiba.raza.comando.ComandoRaza;

public class ComandoRazaTestDataBuilder {

	private Long id;
	private String nombre;

	public ComandoRazaTestDataBuilder() {
		this.id = 1L;
		this.nombre = "Dalmata";
	}

	public ComandoRazaTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public ComandoRazaTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ComandoRaza build() {
		return new ComandoRaza(this.id, this.nombre);
	}
}
