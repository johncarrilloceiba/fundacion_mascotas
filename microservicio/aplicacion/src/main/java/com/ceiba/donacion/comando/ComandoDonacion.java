package com.ceiba.donacion.comando;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoDonacion {

	private Long id;
	private Double valor;
	private Long idMascota;
}
