package com.soltel.elex.services;

import com.soltel.elex.model.ExpedientesModel;
import com.soltel.elex.repository.IExpedientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpedientesService {

    private final IExpedientesRepository expedientesRepository;

    @Autowired
    public ExpedientesService(IExpedientesRepository expedientesRepository) {
        this.expedientesRepository = expedientesRepository;
    }

    public List<ExpedientesModel> getAllExpedientes() {
        return expedientesRepository.findAll();
    }

    public ExpedientesModel createExpediente(ExpedientesModel expediente) {
        return expedientesRepository.save(expediente);
    }

    public Optional<ExpedientesModel> getExpedienteById(Long id) {
        return expedientesRepository.findById(id);
    }

    public ExpedientesModel updateExpediente(Long id, ExpedientesModel expedienteDetails) {
        ExpedientesModel expediente = expedientesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expediente no encontrado"));

        expediente.setNumeroExpediente(expedienteDetails.getNumeroExpediente());
        expediente.setFecha(expedienteDetails.getFecha());
        expediente.setNumero(expedienteDetails.getNumero());
        expediente.setMateria(expedienteDetails.getMateria());
        expediente.setEstado(expedienteDetails.getEstado());
        expediente.setResponsable(expedienteDetails.getResponsable());
        expediente.setSegundoResponsable(expedienteDetails.getSegundoResponsable());
        expediente.setDescripcion(expedienteDetails.getDescripcion());
        expediente.setCondicion(expedienteDetails.getCondicion());
        expediente.setPrecio(expedienteDetails.getPrecio());
        expediente.setConsejeria(expedienteDetails.getConsejeria());

        return expedientesRepository.save(expediente);
    }

    public void deleteExpediente(Long id) {
        expedientesRepository.deleteById(id);
    }
}
