package com.ceiba.contacto.modelo;

import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.contacto.modelo.entidad.Contacto;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;

public class ContactoTest {

	@Test
	public void validarNombreNoNulo () {
		String mensaje = "Se debe ingresar el nombre del contacto.";

		BasePrueba.assertThrows(() -> new Contacto(1L, null, "3004230343"), ExcepcionValorObligatorio.class, mensaje);
	}

	@Test
	public void validarNumeroNoNulo () {
		String mensaje = "Se debe ingresar el número de telefono del contacto.";

		BasePrueba.assertThrows(() -> new Contacto(1L, "Juan", null), ExcepcionValorObligatorio.class, mensaje);
	}

	@Test
	public void validarNombreLongitudMinima () {
		String mensaje = "Se debe ingresar al menos 3 letras de longitud para nombre del contacto.";

		BasePrueba.assertThrows(() -> new Contacto(1L, "Yu", "3004230343"), ExcepcionLongitudValor.class, mensaje);
	}

	@Test
	public void validarNombreLongitudMaxima () {
		String mensaje = "Se debe ingresar menos de 51 letras de longitud para nombre del contacto.";

		BasePrueba.assertThrows(() -> new Contacto(1L, "Texto con mas de cincuenta caracteres de longitud..", "3004230343"), ExcepcionLongitudValor.class, mensaje);
	}

	@Test
	public void validarNumeroLongitudMinima () {
		String mensaje = "Se debe ingresar al menos 7 caracteres de longitud para el numero de contacto.";

		BasePrueba.assertThrows(() -> new Contacto(1L, "John Jairo Carrillo Ibarra", "572914"), ExcepcionLongitudValor.class, mensaje);
	}

	@Test
	public void validarNumeroLongitudMaxima () {
		String mensaje = "Se debe ingresar menos de 16 letras de longitud para el numero del contacto.";

		BasePrueba.assertThrows(() -> new Contacto(1L, "John Jairo Carrillo Ibarra", "+57 300423034300"), ExcepcionLongitudValor.class, mensaje);
	}
}
