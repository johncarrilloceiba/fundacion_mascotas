package com.ceiba.dominio.excepcion;

public class ExceptionAdopcionSinContacto extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExceptionAdopcionSinContacto (String message) {
		super(message);
	}
}
