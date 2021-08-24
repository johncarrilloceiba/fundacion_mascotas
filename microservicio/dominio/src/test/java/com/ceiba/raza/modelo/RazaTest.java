package com.ceiba.raza.modelo;


import org.junit.Test;
import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.raza.modelo.entidad.Raza;

public class RazaTest {

	@Test
	public void validarNombreNoNulo () {
		String mensaje = "Se debe ingresar el nombre de la raza.";

		BasePrueba.assertThrows(() -> new Raza(1L, null), ExcepcionValorObligatorio.class, mensaje);
	}

	@Test
	public void validarNombreLongitudMinima () {
		String mensaje = "Se debe ingresar al menos 2 letras de longitud para nombre de la raza.";

		BasePrueba.assertThrows(() -> new Raza(1L, ""), ExcepcionLongitudValor.class, mensaje);
	}

	@Test
	public void validarNombreLongitudMaxima () {
		String mensaje = "Se debe ingresar menos de 51 letras de longitud para nombre de la raza.";

		BasePrueba.assertThrows(() -> new Raza(1L, "Texto con mas de cincuenta caracteres de longitud.."), ExcepcionLongitudValor.class, mensaje);
	}
}
