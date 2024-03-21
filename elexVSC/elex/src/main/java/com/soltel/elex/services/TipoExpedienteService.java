package com.soltel.elex.services;

import com.soltel.elex.model.TipoExpedienteModel;
import com.soltel.elex.repository.ITipoExpedienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TipoExpedienteService {
    
    private final ITipoExpedienteRepository tipoExpedienteRepository;

    @Autowired
    public TipoExpedienteService(ITipoExpedienteRepository tipoExpedienteRepository) {
        this.tipoExpedienteRepository = tipoExpedienteRepository;
    }

    public List<TipoExpedienteModel> getAllTipoExpedientes() {
        return tipoExpedienteRepository.findAll();
    }

    public TipoExpedienteModel getTipoExpedienteById(Long id) {
        return tipoExpedienteRepository.findById(id)
                                       .orElseThrow(() -> new RuntimeException("Tipo de expediente no encontrado"));
    }

    public TipoExpedienteModel createTipoExpediente(TipoExpedienteModel tipoExpediente) {
        return tipoExpedienteRepository.save(tipoExpediente);
    }

    public TipoExpedienteModel updateTipoExpediente(Long id, TipoExpedienteModel tipoExpedienteDetails) {
        TipoExpedienteModel tipoExpediente = tipoExpedienteRepository.findById(id)
                                                                   .orElseThrow(() -> new RuntimeException("Tipo de expediente no encontrado"));

        tipoExpediente.setNombre(tipoExpedienteDetails.getNombre());

        return tipoExpedienteRepository.save(tipoExpediente);
    }

    public void deleteTipoExpediente(Long id) {
        tipoExpedienteRepository.deleteById(id);
    }
}
    
