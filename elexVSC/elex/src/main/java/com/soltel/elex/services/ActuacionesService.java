package com.soltel.elex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.soltel.elex.model.ActuacionesModel;
import com.soltel.elex.repository.IActuacionesRepository;
import java.util.List;
import java.util.Optional;

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

    public ActuacionesModel createActuacion(ActuacionesModel actuacion) {
        return actuacionesRepository.save(actuacion);
    }

    public Optional<ActuacionesModel> getActuacionById(Long id) {
        return actuacionesRepository.findById(id);
    }

    public ActuacionesModel updateActuacion(Long id, ActuacionesModel actuacionDetails) {
        ActuacionesModel actuacion = actuacionesRepository.findById(id)
                                                         .orElseThrow(() -> new RuntimeException("Actuación no encontrada"));

        actuacion.setNombre(actuacionDetails.getNombre());
        actuacion.setFecha(actuacionDetails.getFecha());
        actuacion.setDescripcion(actuacionDetails.getDescripcion());
        actuacion.setEstado(actuacionDetails.getEstado());
        // Actualiza otros campos según sea necesario

        return actuacionesRepository.save(actuacion);
    }

    public void deleteActuacion(Long id) {
        actuacionesRepository.deleteById(id);
    }
}
