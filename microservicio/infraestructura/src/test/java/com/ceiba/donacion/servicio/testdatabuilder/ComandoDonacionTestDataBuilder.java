package com.ceiba.donacion.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.donacion.comando.ComandoDonacion;

public class ComandoDonacionTestDataBuilder {

	private Long id;
	private Double valor;
	private LocalDateTime fechaCreacion;
	private Long idMascota;
	public ComandoDonacionTestDataBuilder() {
		this.id = 1L;
		this.valor = 10000.00;
		this.idMascota = 1L;
	}
	public ComandoDonacionTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}
	public ComandoDonacionTestDataBuilder conValor(Double valor) {
		this.valor = valor;
		return this;
	}
	public ComandoDonacionTestDataBuilder conFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
		return this;
	}
	public ComandoDonacionTestDataBuilder conMascota(Long idMascota) {
		this.idMascota = idMascota;
		return this;
	}
	
	public ComandoDonacion build() {
		return new ComandoDonacion(this.id, this.valor, this.idMascota);
	}
}
