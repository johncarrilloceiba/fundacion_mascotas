package com.ceiba.raza.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.raza.comando.ComandoRaza;
import com.ceiba.raza.comando.manejador.ManejadorActualizarRaza;
import com.ceiba.raza.comando.manejador.ManejadorCrearRaza;
import com.ceiba.raza.comando.manejador.ManejadorEliminarRaza;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/razas")
@Api(tags = { "Controlador comando raza"})
public class ComandoControladorRaza {

    private final ManejadorCrearRaza manejadorCrearRaza;
	private final ManejadorEliminarRaza manejadorEliminarRaza;
	private final ManejadorActualizarRaza manejadorActualizarRaza;

    @Autowired
    public ComandoControladorRaza(ManejadorCrearRaza manejadorCrearRaza,
									 ManejadorEliminarRaza manejadorEliminarRaza,
									 ManejadorActualizarRaza manejadorActualizarRaza) {
        this.manejadorCrearRaza = manejadorCrearRaza;
		this.manejadorEliminarRaza = manejadorEliminarRaza;
		this.manejadorActualizarRaza = manejadorActualizarRaza;
    }

    @PostMapping
    @ApiOperation("Crear Raza")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoRaza comandoRaza) {
        return manejadorCrearRaza.ejecutar(comandoRaza);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Raza")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarRaza.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Raza")
	public void actualizar(@RequestBody ComandoRaza comandoRaza,@PathVariable Long id) {
		comandoRaza.setId(id);
		manejadorActualizarRaza.ejecutar(comandoRaza);
	}
}
