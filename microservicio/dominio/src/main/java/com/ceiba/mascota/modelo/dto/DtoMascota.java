package com.ceiba.mascota.modelo.dto;


import java.time.LocalDateTime;

import com.ceiba.contacto.modelo.entidad.Contacto;
import com.ceiba.raza.modelo.entidad.Raza;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoMascota {

	private Long id;
	private String nombre;
	private LocalDateTime fechaNacimiento;
	private LocalDateTime fechaAdopcion;
	private Long idContacto;
	private Long idRaza;
}
