package com.ceiba.mascota.servicio;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.mascota.modelo.entidad.Mascota;
import com.ceiba.mascota.puerto.repositorio.RepositorioMascota;
import com.ceiba.mascota.servicio.testdatabuilder.MascotaTestDataBuilder;

public class ServicioActualizarMascotaTest {

	@Test
	public void validarMascotaExistenciaPreviaTest() {
		// arrange
		Mascota mascota = new MascotaTestDataBuilder().conId(1L).build();
		RepositorioMascota repositorioMascota = Mockito.mock(RepositorioMascota.class);
		Mockito.when(repositorioMascota.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(true);
		ServicioActualizarMascota servicioActualizarMascota = new ServicioActualizarMascota(repositorioMascota);

		// act - assert
		BasePrueba.assertThrows(() -> servicioActualizarMascota.ejecutar(mascota), ExcepcionDuplicidad.class,
				"La mascota ya existe en el sistema.");
	}

	@Test
	public void validarMascotaSinExistenciaPreviaTest() {
		// arrange
		Integer valorEsperado = 1;
		Mascota mascota = new MascotaTestDataBuilder().conId(1L).build();
		RepositorioMascota repositorioMascota = Mockito.mock(RepositorioMascota.class);
		Mockito.when(repositorioMascota.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(false);
		Mockito.when(repositorioMascota.actualizar(Mockito.any())).thenReturn(1);
		ServicioActualizarMascota servicioActualizarMascota = new ServicioActualizarMascota(repositorioMascota);

		// act
		Integer respuesta = servicioActualizarMascota.ejecutar(mascota);

		// assert
		Assert.assertEquals(valorEsperado, respuesta);
	}

}
