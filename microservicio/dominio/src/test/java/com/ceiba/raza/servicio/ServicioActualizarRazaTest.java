package com.ceiba.raza.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.raza.modelo.entidad.Raza;
import com.ceiba.raza.puerto.repositorio.RepositorioRaza;
import com.ceiba.raza.servicio.testdatabuilder.RazaTestDataBuilder;

public class ServicioActualizarRazaTest {

	@Test
    public void validarRazaExistenciaPreviaTest() {
        // arrange
		Raza raza = new RazaTestDataBuilder().conId(1L).build();
        RepositorioRaza repositorioRaza = Mockito.mock(RepositorioRaza.class);
        Mockito.when(repositorioRaza.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(true);
        ServicioActualizarRaza servicioActualizarRaza = new ServicioActualizarRaza(repositorioRaza);

        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarRaza.ejecutar(raza), ExcepcionDuplicidad.class, "La raza ya existe en el sistema.");
    }
}
