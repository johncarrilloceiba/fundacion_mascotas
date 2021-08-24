package com.ceiba.raza.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarLongitudMinima;
import static com.ceiba.dominio.ValidadorArgumento.validarLongitudMaxima;
import lombok.Getter;

@Getter
public class Raza {

	private Long id;
	private String nombre;

	private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_RAZA = "Se debe ingresar el nombre de la raza.";
	private static final String SE_DEBE_INGRESAR_AL_MENOS_2_LETRAS = "Se debe ingresar al menos 2 letras de longitud para nombre de la raza.";
	private static final String SE_DEBE_INGRESAR_MENOS_DE_51_LETRAS = "Se debe ingresar menos de 51 letras de longitud para nombre de la raza.";
	private static final Integer LONGITUD_MINIMA_NOMBRE = 2;
	private static final Integer LONGITUD_MAXIMA_NOMBRE = 50;
	
	public Raza(Long id, String nombre) {
		
		validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_RAZA);
		validarLongitudMinima(nombre, LONGITUD_MINIMA_NOMBRE, SE_DEBE_INGRESAR_AL_MENOS_2_LETRAS);
		validarLongitudMaxima(nombre, LONGITUD_MAXIMA_NOMBRE, SE_DEBE_INGRESAR_MENOS_DE_51_LETRAS);

		this.id = id;
		this.nombre = nombre;
	}

	
}
