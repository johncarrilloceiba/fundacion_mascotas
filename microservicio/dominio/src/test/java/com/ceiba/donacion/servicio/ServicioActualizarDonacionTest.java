package com.ceiba.donacion.servicio;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.donacion.modelo.entidad.Donacion;
import com.ceiba.donacion.puerto.repositorio.RepositorioDonacion;
import com.ceiba.donacion.servicio.testdatabuilder.DonacionTestDataBuilder;

public class ServicioActualizarDonacionTest {

	@Test
    public void validarDonacionExistenciaPreviaTest() {
        // arrange
		Integer responseReturn = 1;
		Donacion donacion = new DonacionTestDataBuilder().build();
        RepositorioDonacion repositorioDonacion = Mockito.mock(RepositorioDonacion.class);
        Mockito.when(repositorioDonacion.actualizar(donacion)).thenReturn(1);
        ServicioActualizarDonacion servicioActualizarDonacion = new ServicioActualizarDonacion(repositorioDonacion);

        // act
        Integer response = servicioActualizarDonacion.ejecutar(donacion);

        //assert
        Assert.assertEquals(response, responseReturn);
    }
}
