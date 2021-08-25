package com.ceiba.mascota.servicio;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.mascota.modelo.entidad.Mascota;
import com.ceiba.mascota.puerto.repositorio.RepositorioMascota;
import com.ceiba.mascota.servicio.testdatabuilder.MascotaTestDataBuilder;

public class ServicioCrearMascotaTest {

	@Test
	public void validarMascotaExistenciaPreviaTest() {
		// arrange
		Mascota mascota = new MascotaTestDataBuilder().build();
		RepositorioMascota repositorioMascota = Mockito.mock(RepositorioMascota.class);
		Mockito.when(repositorioMascota.existe(Mockito.anyString())).thenReturn(true);
		ServicioCrearMascota servicioCrearMascota = new ServicioCrearMascota(repositorioMascota);

		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearMascota.ejecutar(mascota), ExcepcionDuplicidad.class,
				"La mascota ya existe en el sistema.");
	}

	@Test
	public void validarMascotaSinExistenciaPreviaTest() {
		// arrange
		Long valorEsperado = 1L;
		Mascota mascota = new MascotaTestDataBuilder().build();
		RepositorioMascota repositorioMascota = Mockito.mock(RepositorioMascota.class);
		Mockito.when(repositorioMascota.existe(Mockito.anyString())).thenReturn(false);
		Mockito.when(repositorioMascota.crear(Mockito.any())).thenReturn(1L);
		ServicioCrearMascota servicioCrearMascota = new ServicioCrearMascota(repositorioMascota);

		// act
		Long respuesta = servicioCrearMascota.ejecutar(mascota);

		// assert
		Assert.assertEquals(valorEsperado, respuesta);
	}
}
