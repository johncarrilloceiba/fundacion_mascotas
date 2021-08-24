package com.ceiba.contacto.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.contacto.consulta.ManejadorConsultarContacto;
import com.ceiba.contacto.consulta.ManejadorListarContactos;
import com.ceiba.contacto.modelo.dto.DtoContacto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/contactos")
@Api(tags={"Controlador consulta contacto"})
public class ConsultaControladorContacto {

    private final ManejadorListarContactos manejadorListarContactos;
    private final ManejadorConsultarContacto manejadorConsultarContacto;

    public ConsultaControladorContacto(ManejadorListarContactos manejadorListarContactos,
    		ManejadorConsultarContacto manejadorConsultarContacto) {
        this.manejadorListarContactos = manejadorListarContactos;
        this.manejadorConsultarContacto = manejadorConsultarContacto;
    }

    @GetMapping
    @ApiOperation("Listar Contactos")
    public List<DtoContacto> listar() {
        return this.manejadorListarContactos.ejecutar();
    }

    @GetMapping(value="/{id}")
    @ApiOperation("Consultar Donaciones")
    public DtoContacto consultar(@PathVariable Long id) {
        return this.manejadorConsultarContacto.ejecutar(id);
    }
}
