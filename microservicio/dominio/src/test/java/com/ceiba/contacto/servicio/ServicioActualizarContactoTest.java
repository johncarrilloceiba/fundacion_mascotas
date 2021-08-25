package com.ceiba.contacto.servicio;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.contacto.modelo.entidad.Contacto;
import com.ceiba.contacto.puerto.repositorio.RepositorioContacto;
import com.ceiba.contacto.servicio.testdatabuilder.ContactoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarContactoTest {

	@Test
    public void validarContactoExistenciaPreviaTest() {
        // arrange
		Contacto contacto = new ContactoTestDataBuilder().conId(1L).build();
        RepositorioContacto repositorioContacto = Mockito.mock(RepositorioContacto.class);
        Mockito.when(repositorioContacto.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(true);
        ServicioActualizarContacto servicioActualizarContacto = new ServicioActualizarContacto(repositorioContacto);

        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarContacto.ejecutar(contacto), ExcepcionDuplicidad.class, "El contacto ya existe en el sistema.");
    }

	@Test
    public void validarContactoSinExistenciaPreviaTest() {
        // arrange
		Integer valorEsperado = 1;
		Contacto contacto = new ContactoTestDataBuilder().conId(1L).build();
        RepositorioContacto repositorioContacto = Mockito.mock(RepositorioContacto.class);
        Mockito.when(repositorioContacto.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioContacto.actualizar(Mockito.any())).thenReturn(1);
        ServicioActualizarContacto servicioActualizarContacto = new ServicioActualizarContacto(repositorioContacto);

        // act
        Integer respuesta = servicioActualizarContacto.ejecutar(contacto);

        // assert
        Assert.assertEquals(valorEsperado, respuesta);
    }
}
