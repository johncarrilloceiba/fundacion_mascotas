package com.ceiba.donacion.servicio;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.donacion.modelo.entidad.Donacion;
import com.ceiba.donacion.puerto.repositorio.RepositorioDonacion;
import com.ceiba.donacion.servicio.testdatabuilder.DonacionTestDataBuilder;

public class ServicioCrearDonacionTest {

	@Test
    public void validarDonacionExistenciaPreviaTest() {
        // arrange
		Donacion donacion = new DonacionTestDataBuilder().build();
        RepositorioDonacion repositorioDonacion = Mockito.mock(RepositorioDonacion.class);
        Long responseReturn = 1L;
        Mockito.when(repositorioDonacion.crear(donacion)).thenReturn(responseReturn);
        ServicioCrearDonacion servicioCrearDonacion = new ServicioCrearDonacion(repositorioDonacion);

        // act
        Long response = servicioCrearDonacion.ejecutar(donacion);

        //assert
        Assert.assertEquals(response, responseReturn);
    }
}
