package com.ceiba.mascota.modelo;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.contacto.modelo.entidad.Contacto;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.dominio.excepcion.ExceptionAdopcionSinContacto;
import com.ceiba.dominio.excepcion.ExceptionAdopcionSinFecha;
import com.ceiba.dominio.excepcion.ExceptionAdopcionSinSeisMesesEdadMascota;
import com.ceiba.mascota.modelo.entidad.Mascota;
import com.ceiba.raza.modelo.entidad.Raza;

public class MascotaTest {

	@Test
	public void validarNombreNoNulo () {
		String mensaje = "Se debe ingresar el nombre de la mascota.";
		Raza raza = new Raza(1L, "Akita Americano");
		LocalDateTime fechaNacimiento = LocalDateTime.now();
		
		BasePrueba.assertThrows(() -> new Mascota(1L, null, fechaNacimiento, raza, null, null),
				ExcepcionValorObligatorio.class, mensaje);
	}

	@Test
	public void validarFechaNacimientoNoNulo () {
		String mensaje = "Se debe ingresar la fecha de nacimiento de la mascota.";
		Raza raza = new Raza(1L, "Akita Americano");
		
		BasePrueba.assertThrows(() -> new Mascota(1L, "Fly Fly", null, raza, null, null),
				ExcepcionValorObligatorio.class, mensaje);
	}

	@Test
	public void validarRazaNoNulo () {
		String mensaje = "Se debe ingresar la raza de la mascota.";
		LocalDateTime fechaNacimiento = LocalDateTime.now();
		
		BasePrueba.assertThrows(() -> new Mascota(1L, "Fly Fly", fechaNacimiento, null, null, null),
				ExcepcionValorObligatorio.class, mensaje);
	}

	@Test
	public void validarNombreLongitudMinima () {
		String mensaje = "Se debe ingresar al menos 3 letras de longitud para nombre de la mascota.";
		LocalDateTime fechaNacimiento = LocalDateTime.now();
		Raza raza = new Raza(1L, "Akita Americano");
		
		BasePrueba.assertThrows(() -> new Mascota(1L, "Yi", fechaNacimiento, raza, null, null),
				ExcepcionLongitudValor.class, mensaje);
	}

	@Test
	public void validarNombreLongitudMaxima () {
		String mensaje = "Se debe ingresar menos de 51 letras de longitud para nombre de la mascota.";
		LocalDateTime fechaNacimiento = LocalDateTime.now();
		Raza raza = new Raza(1L, "Akita Americano");

		BasePrueba.assertThrows(() -> new Mascota(1L, "Texto con mas de cincuenta caracteres de longitud..",
				fechaNacimiento, raza, null, null),
				ExcepcionLongitudValor.class, mensaje);
	}

	@Test
	public void validarContactoNoNulo () {
		String mensaje = "Se debe ingresar el contacto de adopción de la mascota.";
		LocalDateTime fechaNacimiento = LocalDateTime.parse("2010-01-01T00:00");
		LocalDateTime fechaAdopcion = LocalDateTime.now();
		Raza raza = new Raza(1L, "Akita Americano");

		BasePrueba.assertThrows(() -> new Mascota(1L, "Fly Fly", fechaNacimiento, raza, fechaAdopcion, null), ExceptionAdopcionSinContacto.class, mensaje);
	}


	@Test
	public void validarFechaAdopcionNoNulo () {
		String mensaje = "Se debe ingresar la fecha de adopción de la mascota.";
		LocalDateTime fechaNacimiento = LocalDateTime.parse("2010-01-01T00:00");
		Raza raza = new Raza(1L, "Akita Americano");

		Contacto contacto = new Contacto(1L, "Juan Carlos", "3004232232");

		BasePrueba.assertThrows(() -> new Mascota(1L, "Fly Fly", fechaNacimiento, raza, null, contacto), ExceptionAdopcionSinFecha.class, mensaje);
	}

	@Test
	public void validarAdopcionMascota () {
		LocalDateTime fechaNacimiento = LocalDateTime.parse("2010-01-01T00:00");
		LocalDateTime fechaAdopcion = LocalDateTime.parse("2010-07-01T00:00");
		Raza raza = new Raza(1L, "Akita Americano");
		Contacto contacto = new Contacto(1L, "Juan Carlos", "3004232232");

		Mascota mascota = new Mascota(1L, "Fly Fly", fechaNacimiento, raza, fechaAdopcion, contacto);
		
		Assert.assertTrue(mascota.esAdoptado());
	}

	@Test
	public void validarNoAdopcionMascotaDesdeCreacion () {
		LocalDateTime fechaNacimiento = LocalDateTime.parse("2010-01-01T00:00");
		Raza raza = new Raza(1L, "Akita Americano");

		Mascota mascota = new Mascota(1L, "Fly Fly", fechaNacimiento, raza);
		
		Assert.assertFalse(mascota.esAdoptado());
	}

	@Test
	public void validarCumpleanosNegativo () {
		LocalDateTime fechaNacimiento = LocalDateTime.now();
		fechaNacimiento = fechaNacimiento.plusYears(1);
		Raza raza = new Raza(1L, "Akita Americano");

		Mascota mascota = new Mascota(1L, "Fly Fly", fechaNacimiento, raza);
		
		Assert.assertFalse(mascota.esCumpleanos());
	}

	@Test
	public void validarEdadMascotaParaAdopcion () {
		String mensaje = "La mascota debe de tener 6 meses de edad como minimo para ser adoptada.";
		LocalDateTime fechaNacimiento = LocalDateTime.parse("2010-01-01T00:00");
		LocalDateTime fechaAdopcion = LocalDateTime.parse("2010-05-01T00:00");
		Raza raza = new Raza(1L, "Akita Americano");
		Contacto contacto = new Contacto(1L, "Juan Carlos", "3004232232");
		
		BasePrueba.assertThrows(() -> new Mascota(1L, "Fly Fly", fechaNacimiento, raza, fechaAdopcion, contacto),
				ExceptionAdopcionSinSeisMesesEdadMascota.class, mensaje);
	}

	@Test
	public void validarIdRaza () {
		LocalDateTime fechaNacimiento = LocalDateTime.parse("2010-01-01T00:00");
		Raza raza = new Raza(1L, "Akita Americano");

		Mascota mascota = new Mascota(1L, "Fly Fly", fechaNacimiento, raza);
		
		Assert.assertEquals(mascota.getIdRaza(), raza.getId());
	}

	@Test
	public void validarIdContactoEnAdopcion () {
		LocalDateTime fechaNacimiento = LocalDateTime.parse("2010-01-01T00:00");
		LocalDateTime fechaAdopcion = LocalDateTime.parse("2010-07-01T00:00");
		Raza raza = new Raza(1L, "Akita Americano");
		Contacto contacto = new Contacto(1L, "Juan Carlos", "3004232232");

		Mascota mascota = new Mascota(1L, "Fly Fly", fechaNacimiento, raza, fechaAdopcion, contacto);
		
		Assert.assertEquals(mascota.getIdContacto(), contacto.getId());
	}

	@Test
	public void validarIdContactoNuloSinAdopcion () {
		LocalDateTime fechaNacimiento = LocalDateTime.parse("2010-01-01T00:00");
		Raza raza = new Raza(1L, "Akita Americano");

		Mascota mascota = new Mascota(1L, "Fly Fly", fechaNacimiento, raza);
		
		Assert.assertNull(mascota.getIdContacto());
	}
}
