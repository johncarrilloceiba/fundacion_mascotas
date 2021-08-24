package com.ceiba.contacto.servicio;

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
        BasePrueba.assertThrows(() -> servicioCrearContacto.ejecutar(contacto), ExcepcionDuplicidad.class, "El contacto ya existe en el sistema.");
    }
}
