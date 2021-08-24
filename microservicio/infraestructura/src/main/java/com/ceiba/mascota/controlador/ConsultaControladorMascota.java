package com.ceiba.mascota.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.mascota.consulta.ManejadorListarMascota;
import com.ceiba.mascota.modelo.dto.DtoMascota;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/mascotas")
@Api(tags={"Controlador consulta mascota"})
public class ConsultaControladorMascota {

    private final ManejadorListarMascota manejadorListarMascotas;

    public ConsultaControladorMascota(ManejadorListarMascota manejadorListarMascotas) {
        this.manejadorListarMascotas = manejadorListarMascotas;
    }

    @GetMapping
    @ApiOperation("Listar Mascotas")
    public List<DtoMascota> listar() {
        return this.manejadorListarMascotas.ejecutar();
    }

}
