package com.ceiba.mascota.comando;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.ceiba.contacto.modelo.entidad.Contacto;
import com.ceiba.raza.modelo.entidad.Raza;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoMascota {

	private Long id;
	private String nombre;
	private String fechaNacimiento;
	private Long idRaza;
}
