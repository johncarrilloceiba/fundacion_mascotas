package com.ceiba.contacto.servicio;

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
}
