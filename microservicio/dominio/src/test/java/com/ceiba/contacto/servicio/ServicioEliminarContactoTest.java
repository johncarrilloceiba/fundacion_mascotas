package com.ceiba.contacto.servicio;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.contacto.modelo.entidad.Contacto;
import com.ceiba.contacto.puerto.repositorio.RepositorioContacto;
import com.ceiba.contacto.servicio.testdatabuilder.ContactoTestDataBuilder;

public class ServicioEliminarContactoTest {

	@Test
    public void validarEliminarContactoTest() {
        // arrange
		Integer valorEsperado = 1;
		Long idContacto = 1L;
		Contacto contacto = new ContactoTestDataBuilder().conId(1L).build();
        RepositorioContacto repositorioContacto = Mockito.mock(RepositorioContacto.class);
        Mockito.when(repositorioContacto.eliminar(Mockito.any())).thenReturn(1);
        ServicioEliminarContacto servicioEliminarContacto = new ServicioEliminarContacto(repositorioContacto);

        // act
        Integer respuesta = servicioEliminarContacto.ejecutar(idContacto);

        // assert
        Assert.assertEquals(valorEsperado, respuesta);
    }
}
