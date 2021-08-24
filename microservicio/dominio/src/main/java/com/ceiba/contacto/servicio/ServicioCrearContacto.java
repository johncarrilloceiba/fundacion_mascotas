package com.ceiba.contacto.servicio;

import com.ceiba.contacto.modelo.entidad.Contacto;
import com.ceiba.contacto.puerto.repositorio.RepositorioContacto;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearContacto {

	private final RepositorioContacto repositorioContacto;

	private static final String EL_CONTACTO_YA_EXISTE_EN_EL_SISTEMA = "El contacto ya existe en el sistema.";

	public ServicioCrearContacto(RepositorioContacto repositorioContacto) {
		this.repositorioContacto = repositorioContacto;
	}

	public Long ejecutar(Contacto contacto) {
        validarExistenciaPrevia(contacto);
        return this.repositorioContacto.crear(contacto);
    }

	private void validarExistenciaPrevia(Contacto contacto) {
        boolean existe = this.repositorioContacto.existe(contacto.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_CONTACTO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
