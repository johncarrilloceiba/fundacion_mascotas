package com.ceiba.donacion.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.donacion.consulta.ManejadorListarDonacion;
import com.ceiba.donacion.modelo.dto.DtoDonacion;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/donaciones")
@Api(tags={"Controlador consulta donacion"})
public class ConsultaControladorDonacion {

    private final ManejadorListarDonacion manejadorListarDonacions;

    public ConsultaControladorDonacion(ManejadorListarDonacion manejadorListarDonacions) {
        this.manejadorListarDonacions = manejadorListarDonacions;
    }

    @GetMapping
    @ApiOperation("Listar Donaciones")
    public List<DtoDonacion> listar() {
        return this.manejadorListarDonacions.ejecutar();
    }

}
