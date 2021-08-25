package com.ceiba.mascota.servicio;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.mascota.puerto.repositorio.RepositorioMascota;

public class ServicioEliminarMascotaTest {

	@Test
    public void validarEliminarMascota() {
		// arrange
		Integer valorEsperado = 1;
		Long idMascota = 1L;
		RepositorioMascota repositorioMascota = Mockito.mock(RepositorioMascota.class);
		Mockito.when(repositorioMascota.eliminar(Mockito.any())).thenReturn(1);
		ServicioEliminarMascota servicioEliminarMascota = new ServicioEliminarMascota(repositorioMascota);

		// act
		Integer respuesta = servicioEliminarMascota.ejecutar(idMascota);

		// assert
		Assert.assertEquals(valorEsperado, respuesta);
	}
}
