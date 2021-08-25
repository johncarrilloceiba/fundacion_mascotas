package com.ceiba.raza.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.raza.modelo.entidad.Raza;
import com.ceiba.raza.puerto.repositorio.RepositorioRaza;

public class ServicioActualizarRaza {

	private final RepositorioRaza repositorioRaza;

	private static final String LA_RAZA_YA_EXISTE_EN_EL_SISTEMA = "La raza ya existe en el sistema.";

	public ServicioActualizarRaza(RepositorioRaza repositorioRaza) {
		this.repositorioRaza = repositorioRaza;
	}

	public Integer ejecutar(Raza raza) {
        validarExistenciaPrevia(raza);
        return this.repositorioRaza.actualizar(raza);
    }

	private void validarExistenciaPrevia(Raza raza) {
        boolean existe = this.repositorioRaza.existeExcluyendoId(raza.getId(), raza.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_RAZA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
