package com.ceiba.contacto.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.contacto.consulta.ManejadorListarContactos;
import com.ceiba.contacto.modelo.dto.DtoContacto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/contactos")
@Api(tags={"Controlador consulta contacto"})
public class ConsultaControladorContacto {

    private final ManejadorListarContactos manejadorListarContactos;

    public ConsultaControladorContacto(ManejadorListarContactos manejadorListarContactos) {
        this.manejadorListarContactos = manejadorListarContactos;
    }

    @GetMapping
    @ApiOperation("Listar Contactos")
    public List<DtoContacto> listar() {
        return this.manejadorListarContactos.ejecutar();
    }

}
