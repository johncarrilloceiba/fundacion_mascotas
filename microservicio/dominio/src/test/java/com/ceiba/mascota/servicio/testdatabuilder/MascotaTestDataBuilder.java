package com.ceiba.mascota.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.contacto.modelo.entidad.Contacto;
import com.ceiba.mascota.modelo.entidad.Mascota;
import com.ceiba.raza.modelo.entidad.Raza;

public class MascotaTestDataBuilder {

	private Long id;
	private String nombre;
	private LocalDateTime fechaNacimiento;
	private LocalDateTime fechaAdopcion;
	private Contacto contacto;
	private Raza raza;

	public MascotaTestDataBuilder () {
		this.id = 1L;
		this.nombre = "Fly Fly";
		this.fechaNacimiento = LocalDateTime.parse("2010-01-01T00:00");
		this.fechaAdopcion = LocalDateTime.now();
		this.contacto = new Contacto(1L, "Juan Carlos", "3004230343");
		this.raza = new Raza(1L, "Bulldog");
	}

	public MascotaTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public MascotaTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public MascotaTestDataBuilder conFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		return this;
	}

	public MascotaTestDataBuilder conFechaAdopcion(LocalDateTime fechaAdopcion) {
		this.fechaAdopcion = fechaAdopcion;
		return this;
	}

	public MascotaTestDataBuilder conContacto(Contacto contacto) {
		this.contacto = contacto;
		return this;
	}

	public MascotaTestDataBuilder conRaza(Raza raza) {
		this.raza = raza;
		return this;
	}

	
	public Mascota build() {
		return new Mascota(this.id, this.nombre, this.fechaNacimiento, this.raza, this.fechaAdopcion, this.contacto);
	}
}
