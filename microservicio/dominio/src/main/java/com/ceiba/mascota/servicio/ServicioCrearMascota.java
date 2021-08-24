package com.ceiba.mascota.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.mascota.modelo.entidad.Mascota;
import com.ceiba.mascota.puerto.repositorio.RepositorioMascota;

public class ServicioCrearMascota {

	private final RepositorioMascota repositorioMascota;

	private static final String LA_MASCOTA_YA_EXISTE_EN_EL_SISTEMA = "La mascota ya existe en el sistema.";

	public ServicioCrearMascota(RepositorioMascota repositorioMascota) {
		this.repositorioMascota = repositorioMascota;
	}

	public Long ejecutar(Mascota mascota) {
        validarExistenciaPrevia(mascota);
        return this.repositorioMascota.crear(mascota);
    }

	private void validarExistenciaPrevia(Mascota mascota) {
        boolean existe = this.repositorioMascota.existe(mascota.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_MASCOTA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
