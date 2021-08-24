package com.ceiba.mascota.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.mascota.comando.ComandoMascota;
import com.ceiba.raza.modelo.entidad.Raza;

public class ComandoMascotaTestDataBuilder {

	private Long id;
	private String nombre;
	private String fechaNacimiento;
	private Long idRaza;
	public ComandoMascotaTestDataBuilder() {
		this.id = 1L;
		this.nombre = "Doggy";
		this.fechaNacimiento = "2010-07-01T00:00";
		this.idRaza = 1L;
	}

	public ComandoMascotaTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public ComandoMascotaTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ComandoMascotaTestDataBuilder conFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		return this;
	}

	public ComandoMascotaTestDataBuilder conRaza(Long idRaza) {
		this.idRaza = idRaza;
		return this;
	}

	public ComandoMascota build() {
		return new ComandoMascota(id, nombre, fechaNacimiento, idRaza);
	}
}
