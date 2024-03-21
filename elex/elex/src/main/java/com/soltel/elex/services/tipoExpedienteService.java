package com.soltel.elex.services;

import com.soltel.elex.model.tipoExpedienteModel;
import com.soltel.elex.repository.ITipoExpedienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class tipoExpedienteService {
    
    private final ITipoExpedienteRepository tipoExpedienteRepository;

    @Autowired
    public tipoExpedienteService(ITipoExpedienteRepository tipoExpedienteRepository) {
        this.tipoExpedienteRepository = tipoExpedienteRepository;
    }

    public List<tipoExpedienteModel> getAllTipoExpedientes() {
        return tipoExpedienteRepository.findAll();
    }

    public tipoExpedienteModel getTipoExpedienteById(Long id) {
        return tipoExpedienteRepository.findById(id)
                                       .orElseThrow(() -> new RuntimeException("Tipo de expediente no encontrado"));
    }

    public tipoExpedienteModel createTipoExpediente(tipoExpedienteModel tipoExpediente) {
        return tipoExpedienteRepository.save(tipoExpediente);
    }

    public tipoExpedienteModel updateTipoExpediente(Long id, tipoExpedienteModel tipoExpedienteDetails) {
        tipoExpedienteModel tipoExpediente = tipoExpedienteRepository.findById(id)
                                                                   .orElseThrow(() -> new RuntimeException("Tipo de expediente no encontrado"));

        tipoExpediente.setNombre(tipoExpedienteDetails.getNombre());

        return tipoExpedienteRepository.save(tipoExpediente);
    }

    public void deleteTipoExpediente(Long id) {
        tipoExpedienteRepository.deleteById(id);
    }
}
    
