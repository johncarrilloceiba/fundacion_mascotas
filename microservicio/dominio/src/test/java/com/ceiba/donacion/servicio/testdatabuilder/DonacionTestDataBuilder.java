package com.ceiba.donacion.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.donacion.modelo.entidad.Donacion;
import com.ceiba.mascota.modelo.entidad.Mascota;
import com.ceiba.raza.modelo.entidad.Raza;

public class DonacionTestDataBuilder {

	private Long id;
	private Double valor;
	private LocalDateTime fechaCreacion;
	private Mascota mascota;

	public DonacionTestDataBuilder() {
		this.id = 1L;
		this.valor = 10000.00;
		this.fechaCreacion = LocalDateTime.now();
		LocalDateTime fechaNacimiento = LocalDateTime.parse("2010-01-01T00:00");
		Raza raza = new Raza(1L, "Akita Americano");
		this.mascota = new Mascota(id, "Fly Fly", fechaNacimiento, raza);
	}
	
	public DonacionTestDataBuilder setId(Long id) {
		this.id = id;
		return this;
	}
	
	public DonacionTestDataBuilder setValor(Double valor) {
		this.valor = valor;
		return this;
	}
	
	public DonacionTestDataBuilder setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
		return this;
	}
	
	public DonacionTestDataBuilder setMascota(Mascota mascota) {
		this.mascota = mascota;
		return this;
	}

	public Donacion build() {
		return new Donacion(this.id, this.mascota, this.valor);
	}
}
