package com.ceiba.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.contacto.puerto.repositorio.RepositorioContacto;
import com.ceiba.contacto.servicio.ServicioActualizarContacto;
import com.ceiba.contacto.servicio.ServicioCrearContacto;
import com.ceiba.contacto.servicio.ServicioEliminarContacto;
import com.ceiba.donacion.puerto.repositorio.RepositorioDonacion;
import com.ceiba.donacion.servicio.ServicioActualizarDonacion;
import com.ceiba.donacion.servicio.ServicioCrearDonacion;
import com.ceiba.donacion.servicio.ServicioEliminarDonacion;
import com.ceiba.mascota.puerto.repositorio.RepositorioMascota;
import com.ceiba.mascota.servicio.ServicioActualizarMascota;
import com.ceiba.mascota.servicio.ServicioCrearMascota;
import com.ceiba.mascota.servicio.ServicioEliminarMascota;
import com.ceiba.raza.puerto.repositorio.RepositorioRaza;
import com.ceiba.raza.servicio.ServicioActualizarRaza;
import com.ceiba.raza.servicio.ServicioCrearRaza;
import com.ceiba.raza.servicio.ServicioEliminarRaza;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }
    
    
    
    @Bean
    public ServicioCrearContacto servicioCrearContacto(RepositorioContacto repositorioContacto) {
        return new ServicioCrearContacto(repositorioContacto);
    }

    @Bean
    public ServicioEliminarContacto servicioEliminarContacto(RepositorioContacto repositorioContacto) {
        return new ServicioEliminarContacto(repositorioContacto);
    }

    @Bean
    public ServicioActualizarContacto servicioActualizarContacto(RepositorioContacto repositorioContacto) {
        return new ServicioActualizarContacto(repositorioContacto);
    }


    @Bean
    public ServicioCrearRaza servicioCrearRaza(RepositorioRaza repositorioRaza) {
        return new ServicioCrearRaza(repositorioRaza);
    }

    @Bean
    public ServicioEliminarRaza servicioEliminarRaza(RepositorioRaza repositorioRaza) {
        return new ServicioEliminarRaza(repositorioRaza);
    }

    @Bean
    public ServicioActualizarRaza servicioActualizarRaza(RepositorioRaza repositorioRaza) {
        return new ServicioActualizarRaza(repositorioRaza);
    }


    @Bean
    public ServicioCrearDonacion servicioCrearDonacion(RepositorioDonacion repositorioDonacion) {
        return new ServicioCrearDonacion(repositorioDonacion);
    }

    @Bean
    public ServicioEliminarDonacion servicioEliminarDonacion(RepositorioDonacion repositorioDonacion) {
        return new ServicioEliminarDonacion(repositorioDonacion);
    }

    @Bean
    public ServicioActualizarDonacion servicioActualizarDonacion(RepositorioDonacion repositorioDonacion) {
        return new ServicioActualizarDonacion(repositorioDonacion);
    }


    @Bean
    public ServicioCrearMascota servicioCrearMascota(RepositorioMascota repositorioMascota) {
        return new ServicioCrearMascota(repositorioMascota);
    }

    @Bean
    public ServicioEliminarMascota servicioEliminarMascota(RepositorioMascota repositorioMascota) {
        return new ServicioEliminarMascota(repositorioMascota);
    }

    @Bean
    public ServicioActualizarMascota servicioActualizarMascota(RepositorioMascota repositorioMascota) {
        return new ServicioActualizarMascota(repositorioMascota);
    }
}
