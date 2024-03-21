package com.soltel.elex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.soltel.elex.model.ActuacionesModel;
import com.soltel.elex.repository.IActuacionesRepository;
import java.util.List;

@Service
public class ActuacionesService {
    
    private final IActuacionesRepository actuacionesRepository;

    @Autowired
    public ActuacionesService(IActuacionesRepository actuacionesRepository) {
        this.actuacionesRepository = actuacionesRepository;
    }

    public List<ActuacionesModel> getAllActuaciones() {
        return actuacionesRepository.findAll();
    }

    public ActuacionesModel getActuacionById(Long id) {
        return actuacionesRepository.findById(id)
                                    .orElseThrow(() -> new RuntimeException("Actuación no encontrada"));
    }

    public ActuacionesModel createActuacion(ActuacionesModel actuacion) {
        return actuacionesRepository.save(actuacion);
    }

    public ActuacionesModel updateActuacion(Long id, ActuacionesModel actuacionDetails) {
        ActuacionesModel actuacion = actuacionesRepository.findById(id)
                                                         .orElseThrow(() -> new RuntimeException("Actuación no encontrada"));

        actuacion.setNombre(actuacionDetails.getNombre());
        actuacion.setFecha(actuacionDetails.getFecha());
        actuacion.setDescripcion(actuacionDetails.getDescripcion());
        actuacion.setEstado(actuacionDetails.getEstado());
        actuacion.setExpediente(actuacionDetails.getExpediente());

        return actuacionesRepository.save(actuacion);
    }

    public void deleteActuacion(Long id) {
        actuacionesRepository.deleteById(id);
    }
}
