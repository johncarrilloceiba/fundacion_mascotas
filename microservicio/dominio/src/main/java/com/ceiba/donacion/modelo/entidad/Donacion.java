package com.ceiba.donacion.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDateTime;

import com.ceiba.dominio.excepcion.ExceptionValorMaximo;
import com.ceiba.dominio.excepcion.ExceptionValorMinimo;
import com.ceiba.mascota.modelo.entidad.Mascota;

public class Donacion {

	private Long id;
	private Double valor;
	private LocalDateTime fechaCreacion;
	private Mascota mascota;
	private Long idMascota;

	private static final String SE_DEBE_INGRESAR_LA_MASCOTA_DE_LA_DONACION = "Se debe ingresar la mascota de la donación.";
	private static final String SE_DEBE_INGRESAR_EL_VALOR_DE_LA_DONACION = "Se debe ingresar el valor de la donación.";

	private static final Double VALOR_DONACION_MINIMO = 5000.00;
	private static final String LA_DONACION_ES_MENOR_QUE_EL_VALOR_MINIMO = "La donación es menor de que el valor minimo: $5000.";

	private static final Double VALOR_DONACION_MAXIMO = 50000.00;
	private static final String LA_DONACION_ES_MAYOR_QUE_EL_VALOR_MAXIMO = "La donación es mayor que el valor maximo: $50000.";

	private static final Double VALOR_DONACION_MINIMO_CUMPLEANOS = 20000.00;
	private static final String LA_DONACION_ES_MENOR_QUE_EL_VALOR_MINIMO_EN_CUMPLEANOS = "La donación es menor de que el valor minimo en sus cumpleaños: $20000.";

	private static final Double VALOR_DONACION_MAXIMO_CUMPLEANOS = 100000.00;
	private static final String LA_DONACION_ES_MAYOR_QUE_EL_VALOR_MAXIMO_EN_CUMPLEANOS = "La donación es mayor que el valor maximo en sus cumpleaños: $100000.";

	public Donacion(Long id, Mascota mascota, Double valor) {
		validarObligatorio(mascota, SE_DEBE_INGRESAR_LA_MASCOTA_DE_LA_DONACION);
		validarObligatorio(valor, SE_DEBE_INGRESAR_EL_VALOR_DE_LA_DONACION);

		validarValorMinimo(valor, mascota);
		validarValorMaximo(valor, mascota);

		this.id = id;
		this.valor = valor;
		this.fechaCreacion = LocalDateTime.now();
		this.mascota = mascota;
		this.idMascota = this.mascota.getId();
	}
	
	public Long getId() {
		return id;
	}



	public Double getValor() {
		return valor;
	}



	public Mascota getMascota() {
		return mascota;
	}



	public Long getIdMascota() {
		return idMascota;
	}



	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	private static void validarValorMinimo(Double valor, Mascota mascota) {
		if (Boolean.TRUE.equals(mascota.esCumpleanos()) && valor < VALOR_DONACION_MINIMO_CUMPLEANOS) {
			throw new ExceptionValorMinimo(LA_DONACION_ES_MENOR_QUE_EL_VALOR_MINIMO_EN_CUMPLEANOS);
		} else if (valor < VALOR_DONACION_MINIMO) {
			throw new ExceptionValorMinimo(LA_DONACION_ES_MENOR_QUE_EL_VALOR_MINIMO);
		}
	}

	private static void validarValorMaximo(Double valor, Mascota mascota) {
		if (Boolean.TRUE.equals(mascota.esCumpleanos()) && valor > VALOR_DONACION_MAXIMO_CUMPLEANOS) {
			throw new ExceptionValorMaximo(LA_DONACION_ES_MAYOR_QUE_EL_VALOR_MAXIMO_EN_CUMPLEANOS);
		} else if (valor > VALOR_DONACION_MAXIMO) {
			throw new ExceptionValorMaximo(LA_DONACION_ES_MAYOR_QUE_EL_VALOR_MAXIMO);
		}
	}
}
