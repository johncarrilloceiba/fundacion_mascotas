package com.ceiba.contacto.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitudMaxima;
import static com.ceiba.dominio.ValidadorArgumento.validarLongitudMinima;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;


public class Contacto {

	private Long id;
	private String nombre;
	private String numero;

	private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_CONTACTO = "Se debe ingresar el nombre del contacto.";
	private static final String SE_DEBE_INGRESAR_EL_NUMERO_TELEFONICO_DEL_CONTACTO = "Se debe ingresar el número de telefono del contacto.";
	private static final String SE_DEBE_INGRESAR_AL_MENOS_3_LETRAS_NOMBRE = "Se debe ingresar al menos 3 letras de longitud para nombre del contacto.";
	private static final String SE_DEBE_INGRESAR_MENOS_DE_51_LETRAS_NOMBRE = "Se debe ingresar menos de 51 letras de longitud para nombre del contacto.";
	private static final String SE_DEBE_INGRESAR_AL_MENOS_7_LETRAS_NUMERO = "Se debe ingresar al menos 7 caracteres de longitud para el numero de contacto.";
	private static final String SE_DEBE_INGRESAR_MENOS_DE_15_LETRAS_NUMERO = "Se debe ingresar menos de 16 letras de longitud para el numero del contacto.";
	private static final Integer LONGITUD_MINIMA_NOMBRE = 3;
	private static final Integer LONGITUD_MINIMA_NUMERO = 7;
	private static final Integer LONGITUD_MAXIMA_NOMBRE = 50;
	private static final Integer LONGITUD_MAXIMA_NUMERO = 15;

	public Contacto(Long id, String nombre, String numero) {

		validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_CONTACTO);
		validarObligatorio(numero, SE_DEBE_INGRESAR_EL_NUMERO_TELEFONICO_DEL_CONTACTO);

		validarLongitudMinima(numero, LONGITUD_MINIMA_NUMERO, SE_DEBE_INGRESAR_AL_MENOS_7_LETRAS_NUMERO);
		validarLongitudMinima(nombre, LONGITUD_MINIMA_NOMBRE, SE_DEBE_INGRESAR_AL_MENOS_3_LETRAS_NOMBRE);

		validarLongitudMaxima(numero, LONGITUD_MAXIMA_NUMERO, SE_DEBE_INGRESAR_MENOS_DE_15_LETRAS_NUMERO);
		validarLongitudMaxima(nombre, LONGITUD_MAXIMA_NOMBRE, SE_DEBE_INGRESAR_MENOS_DE_51_LETRAS_NOMBRE);

		this.id = id;
		this.nombre = nombre;
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNumero() {
		return numero;
	}

	
}
