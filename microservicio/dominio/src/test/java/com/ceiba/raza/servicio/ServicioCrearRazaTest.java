package com.ceiba.raza.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.raza.modelo.entidad.Raza;
import com.ceiba.raza.puerto.repositorio.RepositorioRaza;
import com.ceiba.raza.servicio.testdatabuilder.RazaTestDataBuilder;

public class ServicioCrearRazaTest {

	@Test
    public void validarRazaExistenciaPreviaTest() {
        // arrange
		Raza raza = new RazaTestDataBuilder().build();
        RepositorioRaza repositorioRaza = Mockito.mock(RepositorioRaza.class);
        Mockito.when(repositorioRaza.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearRaza servicioCrearRaza = new ServicioCrearRaza(repositorioRaza);

        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearRaza.ejecutar(raza), ExcepcionDuplicidad.class, "La raza ya existe en el sistema.");
    }
}
