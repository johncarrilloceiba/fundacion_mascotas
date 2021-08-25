package com.ceiba.raza.servicio;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.raza.puerto.repositorio.RepositorioRaza;

public class ServicioEliminarRazaTest {

	@Test
    public void validarEliminarRaza() {
		// arrange
		Integer valorEsperado = 1;
		Long idRaza = 1L;
		RepositorioRaza repositorioRaza = Mockito.mock(RepositorioRaza.class);
		Mockito.when(repositorioRaza.eliminar(Mockito.any())).thenReturn(1);
		ServicioEliminarRaza servicioEliminarRaza = new ServicioEliminarRaza(repositorioRaza);

		// act
		Integer respuesta = servicioEliminarRaza.ejecutar(idRaza);

		// assert
		Assert.assertEquals(valorEsperado, respuesta);
	}
}
