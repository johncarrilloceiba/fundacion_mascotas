package com.ceiba.dominio.excepcion;

public class ExceptionAdopcionSinMascota extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExceptionAdopcionSinMascota (String message) {
		super(message);
	}
}
