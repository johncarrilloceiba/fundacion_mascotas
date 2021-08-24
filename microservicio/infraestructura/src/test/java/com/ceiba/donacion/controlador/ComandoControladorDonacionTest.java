package com.ceiba.donacion.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.ApplicationMock;
import com.ceiba.donacion.comando.ComandoDonacion;
import com.ceiba.donacion.servicio.testdatabuilder.ComandoDonacionTestDataBuilder;
import com.ceiba.raza.comando.ComandoRaza;
import com.ceiba.raza.controlador.ComandoControladorRaza;
import com.ceiba.raza.servicio.testdatabuilder.ComandoRazaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorDonacion.class)
public class ComandoControladorDonacionTest {

	@Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;


    @Test
    public void crear() throws Exception{
        // arrange
        ComandoDonacion donacion = new ComandoDonacionTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/donaciones")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(donacion)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    public void actualizar() throws Exception{
        // arrange
        Long id = 2L;
        ComandoDonacion donacion = new ComandoDonacionTestDataBuilder().build();

        // act - assert
        mocMvc.perform(put("/donaciones/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(donacion)))
                .andExpect(status().isOk());
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 2L;

        // act - assert
        mocMvc.perform(delete("/donaciones/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
