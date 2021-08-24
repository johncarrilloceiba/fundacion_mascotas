package com.ceiba.dominio.excepcion;

public class ExcepcionDuplicidadAdopcion extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionDuplicidadAdopcion(String mensaje) {
        super(mensaje);
    }
}
