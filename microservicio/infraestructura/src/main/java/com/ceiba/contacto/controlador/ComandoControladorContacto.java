package com.ceiba.contacto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.contacto.comando.ComandoContacto;
import com.ceiba.contacto.comando.manejador.ManejadorActualizarContacto;
import com.ceiba.contacto.comando.manejador.ManejadorCrearContacto;
import com.ceiba.contacto.comando.manejador.ManejadorEliminarContacto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/contactos")
@Api(tags = { "Controlador comando Contacto"})
public class ComandoControladorContacto {

    private final ManejadorCrearContacto manejadorCrearContacto;
	private final ManejadorEliminarContacto manejadorEliminarContacto;
	private final ManejadorActualizarContacto manejadorActualizarContacto;

    @Autowired
    public ComandoControladorContacto(ManejadorCrearContacto manejadorCrearContacto,
									 ManejadorEliminarContacto manejadorEliminarContacto,
									 ManejadorActualizarContacto manejadorActualizarContacto) {
        this.manejadorCrearContacto = manejadorCrearContacto;
		this.manejadorEliminarContacto = manejadorEliminarContacto;
		this.manejadorActualizarContacto = manejadorActualizarContacto;
    }

    @PostMapping
    @ApiOperation("Crear Contacto")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoContacto comandoContacto) {
        return manejadorCrearContacto.ejecutar(comandoContacto);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Contacto")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarContacto.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Contacto")
	public void actualizar(@RequestBody ComandoContacto comandoContacto,@PathVariable Long id) {
		comandoContacto.setId(id);
		manejadorActualizarContacto.ejecutar(comandoContacto);
	}
}
