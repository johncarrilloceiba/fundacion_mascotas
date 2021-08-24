package com.ceiba.mascota.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.mascota.comando.ComandoMascota;
import com.ceiba.mascota.comando.manejador.ManejadorActualizarMascota;
import com.ceiba.mascota.comando.manejador.ManejadorCrearMascota;
import com.ceiba.mascota.comando.manejador.ManejadorEliminarMascota;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/mascotas")
@Api(tags = { "Controlador comando mascota"})
public class ComandoControladorMascota {

    private final ManejadorCrearMascota manejadorCrearMascota;
	private final ManejadorEliminarMascota manejadorEliminarMascota;
	private final ManejadorActualizarMascota manejadorActualizarMascota;

    @Autowired
    public ComandoControladorMascota(ManejadorCrearMascota manejadorCrearMascota,
									 ManejadorEliminarMascota manejadorEliminarMascota,
									 ManejadorActualizarMascota manejadorActualizarMascota) {
        this.manejadorCrearMascota = manejadorCrearMascota;
		this.manejadorEliminarMascota = manejadorEliminarMascota;
		this.manejadorActualizarMascota = manejadorActualizarMascota;
    }

    @PostMapping
    @ApiOperation("Crear Mascota")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoMascota comandoMascota) {
        return manejadorCrearMascota.ejecutar(comandoMascota);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Mascota")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarMascota.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Mascota")
	public void actualizar(@RequestBody ComandoMascota comandoMascota,@PathVariable Long id) {
		comandoMascota.setId(id);
		manejadorActualizarMascota.ejecutar(comandoMascota);
	}
}
