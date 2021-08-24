package com.ceiba.donacion.modelo.dto;


import java.time.LocalDateTime;

import com.ceiba.mascota.modelo.entidad.Mascota;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoDonacion {

	private Long id;
	private Double valor;
	private LocalDateTime fechaCreacion;
	private Long idMascota;
}
