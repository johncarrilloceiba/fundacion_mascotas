package com.ceiba.donacion.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.donacion.comando.ComandoDonacion;
import com.ceiba.donacion.comando.manejador.ManejadorActualizarDonacion;
import com.ceiba.donacion.comando.manejador.ManejadorCrearDonacion;
import com.ceiba.donacion.comando.manejador.ManejadorEliminarDonacion;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/donaciones")
@Api(tags = { "Controlador comando donacion"})
public class ComandoControladorDonacion {

    private final ManejadorCrearDonacion manejadorCrearDonacion;
	private final ManejadorEliminarDonacion manejadorEliminarDonacion;
	private final ManejadorActualizarDonacion manejadorActualizarDonacion;

    @Autowired
    public ComandoControladorDonacion(ManejadorCrearDonacion manejadorCrearDonacion,
									 ManejadorEliminarDonacion manejadorEliminarDonacion,
									 ManejadorActualizarDonacion manejadorActualizarDonacion) {
        this.manejadorCrearDonacion = manejadorCrearDonacion;
		this.manejadorEliminarDonacion = manejadorEliminarDonacion;
		this.manejadorActualizarDonacion = manejadorActualizarDonacion;
    }

    @PostMapping
    @ApiOperation("Crear Donacion")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoDonacion comandoDonacion) {
        return manejadorCrearDonacion.ejecutar(comandoDonacion);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Donacion")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarDonacion.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Donacion")
	public void actualizar(@RequestBody ComandoDonacion comandoDonacion,@PathVariable Long id) {
		comandoDonacion.setId(id);
		manejadorActualizarDonacion.ejecutar(comandoDonacion);
	}
}
