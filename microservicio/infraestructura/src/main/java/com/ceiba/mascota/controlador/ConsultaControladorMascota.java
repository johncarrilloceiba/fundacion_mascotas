package com.ceiba.mascota.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.mascota.consulta.ManejadorConsultarMascota;
import com.ceiba.mascota.consulta.ManejadorListarMascota;
import com.ceiba.mascota.modelo.dto.DtoMascota;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/mascotas")
@Api(tags={"Controlador consulta mascota"})
public class ConsultaControladorMascota {

    private final ManejadorListarMascota manejadorListarMascotas;
    private final ManejadorConsultarMascota manejadorConsultarMascota;

    public ConsultaControladorMascota(ManejadorListarMascota manejadorListarMascotas,
    		ManejadorConsultarMascota manejadorConsultarMascota) {
        this.manejadorListarMascotas = manejadorListarMascotas;
        this.manejadorConsultarMascota = manejadorConsultarMascota;
    }

    @GetMapping
    @ApiOperation("Listar Mascotas")
    public List<DtoMascota> listar() {
        return this.manejadorListarMascotas.ejecutar();
    }

    @GetMapping(value="/{id}")
    @ApiOperation("Consultar Mascotas")
    public DtoMascota consultar(@PathVariable Long id) {
        return this.manejadorConsultarMascota.ejecutar(id);
    }
}
