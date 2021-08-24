package com.ceiba.raza.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.raza.consulta.ManejadorListarRaza;
import com.ceiba.raza.modelo.dto.DtoRaza;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/razas")
@Api(tags={"Controlador consulta raza"})
public class ConsultaControladorRaza {

    private final ManejadorListarRaza manejadorListarRaza;

    public ConsultaControladorRaza(ManejadorListarRaza manejadorListarRaza) {
        this.manejadorListarRaza = manejadorListarRaza;
    }

    @GetMapping
    @ApiOperation("Listar Razas")
    public List<DtoRaza> listar() {
        return this.manejadorListarRaza.ejecutar();
    }

}
