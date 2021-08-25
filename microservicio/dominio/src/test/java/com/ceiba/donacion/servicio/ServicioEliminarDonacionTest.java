package com.ceiba.donacion.servicio;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.donacion.puerto.repositorio.RepositorioDonacion;

public class ServicioEliminarDonacionTest {

	@Test
    public void validarEliminarDonacion() {
		// arrange
		Integer valorEsperado = 1;
		Long idDonacion = 1L;
		RepositorioDonacion repositorioDonacion = Mockito.mock(RepositorioDonacion.class);
		Mockito.when(repositorioDonacion.eliminar(Mockito.any())).thenReturn(1);
		ServicioEliminarDonacion servicioEliminarDonacion = new ServicioEliminarDonacion(repositorioDonacion);

		// act
		Integer respuesta = servicioEliminarDonacion.ejecutar(idDonacion);

		// assert
		Assert.assertEquals(valorEsperado, respuesta);
	}
}
