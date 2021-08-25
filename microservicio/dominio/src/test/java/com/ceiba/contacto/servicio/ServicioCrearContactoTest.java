package com.ceiba.contacto.servicio;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.contacto.modelo.entidad.Contacto;
import com.ceiba.contacto.puerto.repositorio.RepositorioContacto;
import com.ceiba.contacto.servicio.testdatabuilder.ContactoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearContactoTest {

	@Test
	public void validarContactoExistenciaPreviaTest() {
		// arrange
		Contacto contacto = new ContactoTestDataBuilder().build();
		RepositorioContacto repositorioContacto = Mockito.mock(RepositorioContacto.class);
		Mockito.when(repositorioContacto.existe(Mockito.anyString())).thenReturn(true);
		ServicioCrearContacto servicioCrearContacto = new ServicioCrearContacto(repositorioContacto);

		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearContacto.ejecutar(contacto), ExcepcionDuplicidad.class,
				"El contacto ya existe en el sistema.");
	}

	@Test
	public void validarContactoSinExistenciaPreviaTest() {
		// arrange
		Long valorEsperado = 1L;
		Contacto contacto = new ContactoTestDataBuilder().build();
		RepositorioContacto repositorioContacto = Mockito.mock(RepositorioContacto.class);
		Mockito.when(repositorioContacto.existe(Mockito.anyString())).thenReturn(false);
		Mockito.when(repositorioContacto.crear(Mockito.any())).thenReturn(1L);
		ServicioCrearContacto servicioCrearContacto = new ServicioCrearContacto(repositorioContacto);

		// act
		Long respuesta = servicioCrearContacto.ejecutar(contacto);

		// assert
		Assert.assertEquals(valorEsperado, respuesta);
	}
}
