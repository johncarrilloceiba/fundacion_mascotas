package com.ceiba.dominio.excepcion;

public class ExceptionAdopcionSinSeisMesesEdadMascota extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExceptionAdopcionSinSeisMesesEdadMascota (String message) {
		super(message);
	}
}
