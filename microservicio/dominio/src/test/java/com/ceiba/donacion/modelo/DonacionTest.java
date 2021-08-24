package com.ceiba.donacion.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.contacto.modelo.entidad.Contacto;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.dominio.excepcion.ExceptionAdopcionSinFecha;
import com.ceiba.dominio.excepcion.ExceptionValorMaximo;
import com.ceiba.dominio.excepcion.ExceptionValorMinimo;
import com.ceiba.donacion.modelo.entidad.Donacion;
import com.ceiba.mascota.modelo.entidad.Mascota;
import com.ceiba.raza.modelo.entidad.Raza;

public class DonacionTest {

	@Test
	public void validarValorNulo () {
		String mensaje = "Se debe ingresar el valor de la donación";
		LocalDateTime fechaNacimiento = LocalDateTime.parse("2010-01-01T00:00");
		Raza raza = new Raza(1L, "Akita Americano");
		Mascota mascota = new Mascota(1L, "Fly Fly", fechaNacimiento, raza);


		BasePrueba.assertThrows(() -> new Donacion(1L, mascota, null), ExcepcionValorObligatorio.class, mensaje);
	}

	@Test
	public void validarMascotaNulo () {
		String mensaje = "Se debe ingresar la mascota de la donación.";

		BasePrueba.assertThrows(() -> new Donacion(1L, null, 5000.00), ExcepcionValorObligatorio.class, mensaje);
	}

	@Test
	public void validarValorMinimoDonacion () {
		String mensaje = "La donación es menor de que el valor minimo: $5000.";
		Double valor = 4999.99;
		LocalDateTime fechaNacimiento = LocalDateTime.parse("2010-01-01T00:00");
		Raza raza = new Raza(1L, "Akita Americano");
		Mascota mascota = new Mascota(1L, "Fly Fly", fechaNacimiento, raza);

		BasePrueba.assertThrows(() -> new Donacion(1L, mascota, valor), ExceptionValorMinimo.class, mensaje);
	}

	@Test
	public void validarValorMaximoDonacion () {
		String mensaje = "La donación es mayor que el valor maximo: $50000.";
		Double valor = 50000.01;
		LocalDateTime fechaNacimiento = LocalDateTime.parse("2010-01-01T00:00");
		Raza raza = new Raza(1L, "Akita Americano");
		Mascota mascota = new Mascota(1L, "Fly Fly", fechaNacimiento, raza);

		BasePrueba.assertThrows(() -> new Donacion(1L, mascota, valor), ExceptionValorMaximo.class, mensaje);
	}

	@Test
	public void validarValorMinimoDonacionCumpleanos () {
		String mensaje = "La donación es menor de que el valor minimo en sus cumpleaños: $20000.";
		Double valor = 19999.99;
		LocalDate hoy = LocalDate.now();
		LocalTime ahora = LocalTime.now();
		hoy = hoy.minusYears(1);
		LocalDateTime fechaNacimiento = LocalDateTime.of(hoy, ahora);
		Raza raza = new Raza(1L, "Akita Americano");
		Mascota mascota = new Mascota(1L, "Fly Fly", fechaNacimiento, raza);

		BasePrueba.assertThrows(() -> new Donacion(1L, mascota, valor), ExceptionValorMinimo.class, mensaje);
	}

	@Test
	public void validarValorMaximoDonacionCumpleanos () {
		String mensaje = "La donación es mayor que el valor maximo en sus cumpleaños: $100000.";
		Double valor = 100000.01;
		LocalDate hoy = LocalDate.now();
		LocalTime ahora = LocalTime.now();
		hoy = hoy.minusYears(1);
		LocalDateTime fechaNacimiento = LocalDateTime.of(hoy, ahora);
		Raza raza = new Raza(1L, "Akita Americano");
		Mascota mascota = new Mascota(1L, "Fly Fly", fechaNacimiento, raza);

		BasePrueba.assertThrows(() -> new Donacion(1L, mascota, valor), ExceptionValorMaximo.class, mensaje);
	}
}
