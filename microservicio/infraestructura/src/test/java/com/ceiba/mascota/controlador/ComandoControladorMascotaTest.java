package com.ceiba.mascota.controlador;

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
import com.ceiba.contacto.comando.ComandoContacto;
import com.ceiba.contacto.controlador.ComandoControladorContacto;
import com.ceiba.contacto.servicio.testdatabuilder.ComandoContactoTestDataBuilder;
import com.ceiba.mascota.comando.ComandoMascota;
import com.ceiba.mascota.servicio.testdatabuilder.ComandoMascotaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorMascota.class)
public class ComandoControladorMascotaTest {


	@Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoMascota mascota = new ComandoMascotaTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/mascotas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(mascota)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    public void actualizar() throws Exception{
        // arrange
        Long id = 2L;
        ComandoMascota Mascota = new ComandoMascotaTestDataBuilder().build();

        // act - assert
        mocMvc.perform(put("/mascotas/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(Mascota)))
                .andExpect(status().isOk());
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 2L;

        // act - assert
        mocMvc.perform(delete("/mascotas/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
