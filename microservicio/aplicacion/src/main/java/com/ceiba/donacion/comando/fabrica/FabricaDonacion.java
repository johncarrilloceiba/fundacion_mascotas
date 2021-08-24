package com.ceiba.donacion.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.donacion.comando.ComandoDonacion;
import com.ceiba.donacion.modelo.entidad.Donacion;
import com.ceiba.mascota.modelo.entidad.Mascota;

@Component
public class FabricaDonacion {

	public Donacion crear(ComandoDonacion comandoDonacion, Mascota mascota) {
		return new Donacion(comandoDonacion.getId(), mascota, comandoDonacion.getValor());
	}
}
