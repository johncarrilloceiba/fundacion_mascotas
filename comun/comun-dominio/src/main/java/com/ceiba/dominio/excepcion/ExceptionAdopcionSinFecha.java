package com.ceiba.dominio.excepcion;

public class ExceptionAdopcionSinFecha extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExceptionAdopcionSinFecha (String message) {
		super(message);
	}
}
