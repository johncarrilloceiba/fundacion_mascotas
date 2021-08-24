package com.ceiba.mascota.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.mascota.modelo.entidad.Mascota;
import com.ceiba.mascota.puerto.repositorio.RepositorioMascota;

public class ServicioActualizarMascota {

	private final RepositorioMascota repositorioMascota;

	private static final String LA_MASCOTA_YA_EXISTE_EN_EL_SISTEMA = "La mascota ya existe en el sistema.";

	public ServicioActualizarMascota(RepositorioMascota repositorioMascota) {
		this.repositorioMascota = repositorioMascota;
	}

	public void ejecutar(Mascota mascota) {
        validarExistenciaPrevia(mascota);
        this.repositorioMascota.actualizar(mascota);
    }

	private void validarExistenciaPrevia(Mascota mascota) {
        boolean existe = this.repositorioMascota.existeExcluyendoId(mascota.getId(), mascota.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_MASCOTA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
