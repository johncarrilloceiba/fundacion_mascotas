package com.ceiba.donacion.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.donacion.comando.ComandoDonacion;
import com.ceiba.donacion.comando.fabrica.FabricaDonacion;
import com.ceiba.donacion.modelo.entidad.Donacion;
import com.ceiba.donacion.servicio.ServicioCrearDonacion;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.mascota.modelo.dto.DtoMascota;
import com.ceiba.mascota.modelo.entidad.Mascota;
import com.ceiba.mascota.parser.DtoMascotaToEntity;
import com.ceiba.mascota.puerto.dao.DaoMascota;
import com.ceiba.raza.modelo.dto.DtoRaza;
import com.ceiba.raza.modelo.entidad.Raza;
import com.ceiba.raza.parser.DtoRazaToEntity;
import com.ceiba.raza.puerto.dao.DaoRaza;

@Component
public class ManejadorCrearDonacion implements ManejadorComandoRespuesta<ComandoDonacion, ComandoRespuesta<Long>> {

    private final FabricaDonacion fabricaDonacion;
    private final ServicioCrearDonacion servicioCrearDonacion;
    private final DaoMascota daoMascota;
    private final DaoRaza daoRaza;

	public ManejadorCrearDonacion(FabricaDonacion fabricaDonacion, ServicioCrearDonacion servicioCrearDonacion, DaoMascota daoMascota, DaoRaza daoRaza) {
        this.fabricaDonacion = fabricaDonacion;
        this.servicioCrearDonacion = servicioCrearDonacion;
        this.daoMascota = daoMascota;
        this.daoRaza = daoRaza;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoDonacion comandoDonacion) {
    	Mascota mascota = buscarMascota(daoMascota, comandoDonacion);
        Donacion donacion = this.fabricaDonacion.crear(comandoDonacion, mascota);
        return new ComandoRespuesta<>(this.servicioCrearDonacion.ejecutar(donacion));
    }

    private Mascota buscarMascota (DaoMascota daoMascota, ComandoDonacion comandoDonacion) {
    	DtoMascota dtoMascota = daoMascota.consultar(comandoDonacion.getIdMascota());
    	DtoRaza dtoRaza = daoRaza.consultar(dtoMascota.getIdRaza());
    	Raza raza = DtoRazaToEntity.dtoToEntity(dtoRaza);
    	return DtoMascotaToEntity.dtoToEntity(dtoMascota, raza);
    }
}
