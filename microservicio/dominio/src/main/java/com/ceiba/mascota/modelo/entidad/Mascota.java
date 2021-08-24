package com.ceiba.mascota.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitudMaxima;
import static com.ceiba.dominio.ValidadorArgumento.validarLongitudMinima;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDateTime;

import com.ceiba.contacto.modelo.entidad.Contacto;
import com.ceiba.dominio.excepcion.ExceptionAdopcionSinContacto;
import com.ceiba.dominio.excepcion.ExceptionAdopcionSinFecha;
import com.ceiba.dominio.excepcion.ExceptionAdopcionSinSeisMesesEdadMascota;
import com.ceiba.raza.modelo.entidad.Raza;

import lombok.Getter;

@Getter
public class Mascota {

	private Long id;
	private String nombre;
	private LocalDateTime fechaNacimiento;
	private LocalDateTime fechaAdopcion;
	private Contacto contacto;
	private Raza raza;
	private Long idRaza;
	private Long idContacto;

	private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_MASCOTA = "Se debe ingresar el nombre de la mascota.";
	private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO = "Se debe ingresar la fecha de nacimiento de la mascota.";
	private static final String SE_DEBE_INGRESAR_LA_RAZA_DE_LA_MASCOTA = "Se debe ingresar la raza de la mascota.";
	private static final String SE_DEBE_INGRESAR_AL_MENOS_3_LETRAS_NOMBRE = "Se debe ingresar al menos 3 letras de longitud para nombre de la mascota.";
	private static final String SE_DEBE_INGRESAR_MENOS_DE_51_LETRAS_NOMBRE = "Se debe ingresar menos de 51 letras de longitud para nombre de la mascota.";
	private static final Integer LONGITUD_MINIMA_NOMBRE = 3;
	private static final Integer LONGITUD_MAXIMA_NOMBRE = 50;

	private static final String SE_DEBE_INGRESAR_EL_CONTACTO_DE_ADOPCION = "Se debe ingresar el contacto de adopción de la mascota.";
	private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_ADOPCION = "Se debe ingresar la fecha de adopción de la mascota.";
	private static final String LA_MASCOTA_DEBE_TENER_SEIS_MESES_DE_EDAD = "La mascota debe de tener 6 meses de edad como minimo para ser adoptada.";
	private static final Integer DIAS_MINIMO_ADOPCION = 180;

	public Mascota(Long id, String nombre, LocalDateTime fechaNacimiento, Raza raza) {

		validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_LA_MASCOTA);
		validarObligatorio(fechaNacimiento, SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO);
		validarObligatorio(raza, SE_DEBE_INGRESAR_LA_RAZA_DE_LA_MASCOTA);
		
		validarLongitudMinima(nombre, LONGITUD_MINIMA_NOMBRE, SE_DEBE_INGRESAR_AL_MENOS_3_LETRAS_NOMBRE);
		validarLongitudMaxima(nombre, LONGITUD_MAXIMA_NOMBRE, SE_DEBE_INGRESAR_MENOS_DE_51_LETRAS_NOMBRE);

		this.id = id;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.raza = raza;
		this.idRaza = raza.getId();
	}

	public Mascota(Long id, String nombre, LocalDateTime fechaNacimiento, Raza raza, LocalDateTime fechaAdopcion,
			Contacto contacto) {

		this(id, nombre, fechaNacimiento, raza);

		validarObligatorio(contacto, new ExceptionAdopcionSinContacto (SE_DEBE_INGRESAR_EL_CONTACTO_DE_ADOPCION));
		validarObligatorio(fechaAdopcion, new ExceptionAdopcionSinFecha(SE_DEBE_INGRESAR_LA_FECHA_DE_ADOPCION));

		validarEdadMinimaMascotaParaAdopcion(this, fechaAdopcion);

		this.fechaAdopcion = fechaAdopcion;
		this.contacto = contacto;
		this.idContacto = contacto.getId();
	}

	public Boolean esAdoptado() {
		return fechaAdopcion != null;
	}

	public Boolean esCumpleanos () {
		LocalDateTime hoy = LocalDateTime.now();
		Long diasDiferencia = DAYS.between(this.fechaNacimiento, hoy);
		if (diasDiferencia <= 0) {
			return false;
		} else if (this.fechaNacimiento.getDayOfMonth() == hoy.getDayOfMonth()
				&& this.fechaNacimiento.getMonthValue() == hoy.getMonthValue()) {
			return true;
		}
		return false;
	}

	private static void validarEdadMinimaMascotaParaAdopcion (Mascota mascota, LocalDateTime fechaAdopcion) {
		Long diasDiferencia = DAYS.between(mascota.getFechaNacimiento(), fechaAdopcion);
		if (diasDiferencia < DIAS_MINIMO_ADOPCION) {
			throw new ExceptionAdopcionSinSeisMesesEdadMascota(LA_MASCOTA_DEBE_TENER_SEIS_MESES_DE_EDAD);
		}
	}

}
