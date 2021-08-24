package com.ceiba.donacion.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.donacion.consulta.ManejadorConsultarDonacion;
import com.ceiba.donacion.consulta.ManejadorListarDonacion;
import com.ceiba.donacion.modelo.dto.DtoDonacion;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/donaciones")
@Api(tags={"Controlador consulta donacion"})
public class ConsultaControladorDonacion {

    private final ManejadorListarDonacion manejadorListarDonacions;
    private final ManejadorConsultarDonacion manejadorConsultarDonacion;

    public ConsultaControladorDonacion(ManejadorListarDonacion manejadorListarDonacions, ManejadorConsultarDonacion manejadorConsultarDonacion) {
        this.manejadorListarDonacions = manejadorListarDonacions;
        this.manejadorConsultarDonacion = manejadorConsultarDonacion;
    }

    @GetMapping
    @ApiOperation("Listar Donaciones")
    public List<DtoDonacion> listar() {
        return this.manejadorListarDonacions.ejecutar();
    }

    @GetMapping(value="/{id}")
    @ApiOperation("Consultar Donaciones")
    public DtoDonacion consultar(@PathVariable Long id) {
        return this.manejadorConsultarDonacion.ejecutar(id);
    }
}
