package com.ceiba.contacto.servicio;

import com.ceiba.contacto.modelo.entidad.Contacto;
import com.ceiba.contacto.puerto.repositorio.RepositorioContacto;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarContacto {

	private static final String EL_USUARIO_YA_EXISTE_EL_CONTACTO = "El contacto ya existe en el sistema.";

	private final RepositorioContacto repositorioContacto;

	public ServicioActualizarContacto(RepositorioContacto repositorioContacto) {
		this.repositorioContacto = repositorioContacto;
	}

	public void ejecutar(Contacto contacto) {
        validarExistenciaPrevia(contacto);
        this.repositorioContacto.actualizar(contacto);
    }

	private void validarExistenciaPrevia(Contacto contacto) {
        boolean existe = this.repositorioContacto.existeExcluyendoId(contacto.getId(),contacto.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EL_CONTACTO);
        }
    }
}
