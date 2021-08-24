package com.ceiba.donacion.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.donacion.comando.ComandoDonacion;
import com.ceiba.donacion.comando.fabrica.FabricaDonacion;
import com.ceiba.donacion.modelo.entidad.Donacion;
import com.ceiba.donacion.servicio.ServicioActualizarDonacion;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.mascota.modelo.dto.DtoMascota;
import com.ceiba.mascota.modelo.entidad.Mascota;
import com.ceiba.mascota.parser.DtoMascotaToEntity;
import com.ceiba.mascota.puerto.dao.DaoMascota;
import com.ceiba.raza.modelo.dto.DtoRaza;
import com.ceiba.raza.modelo.entidad.Raza;
import com.ceiba.raza.parser.DtoRazaToEntity;
import com.ceiba.raza.puerto.dao.DaoRaza;

@Component
public class ManejadorActualizarDonacion implements ManejadorComando<ComandoDonacion> {

	private final FabricaDonacion fabricaDonacion;
    private final ServicioActualizarDonacion servicioActualizarDonacion;
    private final DaoMascota daoMascota;
    private final DaoRaza daoRaza;

    public ManejadorActualizarDonacion(FabricaDonacion fabricaDonacion, ServicioActualizarDonacion servicioActualizarDonacion, DaoMascota daoMascota, DaoRaza daoRaza) {
        this.fabricaDonacion = fabricaDonacion;
        this.servicioActualizarDonacion = servicioActualizarDonacion;
        this.daoMascota = daoMascota;
        this.daoRaza = daoRaza;
    }

    public void ejecutar(ComandoDonacion comandoDonacion) {
    	Mascota mascota = buscarMascota(daoMascota, comandoDonacion);
        Donacion donacion = this.fabricaDonacion.crear(comandoDonacion, mascota);
        this.servicioActualizarDonacion.ejecutar(donacion);
    }

    private Mascota buscarMascota (DaoMascota daoMascota, ComandoDonacion comandoDonacion) {
    	DtoMascota dtoMascota = daoMascota.consultar(comandoDonacion.getIdMascota());
    	DtoRaza dtoRaza = daoRaza.consultar(dtoMascota.getIdRaza());
    	Raza raza = DtoRazaToEntity.dtoToEntity(dtoRaza);
    	return DtoMascotaToEntity.dtoToEntity(dtoMascota, raza);
    }
}
