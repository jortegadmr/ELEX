package com.soltel.elex.services;

import com.soltel.elex.model.ExpedientesModel;
import com.soltel.elex.repository.IExpedientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpedientesService {

    @Autowired
    private IExpedientesRepository expedientesRepository;

    public List<ExpedientesModel> consultarExpedientes() {
        return expedientesRepository.findAll();
    }

    public Optional<ExpedientesModel> consultarExpedientePorId(Long id) {
        return expedientesRepository.findById(id);
    }

    public ExpedientesModel insertarExpediente(ExpedientesModel expediente) {
        return expedientesRepository.save(expediente);
    }

    public Optional<ExpedientesModel> actualizarExpediente(Long id, ExpedientesModel expedienteActualizado) {
        Optional<ExpedientesModel> expedienteExistente = expedientesRepository.findById(id);
        if (expedienteExistente.isPresent()) {
            ExpedientesModel expediente = expedienteExistente.get();
            expediente.setFecha(expedienteActualizado.getFecha());
            expediente.setNumero(expedienteActualizado.getNumero());
            expediente.setMateria(expedienteActualizado.getMateria());
            expediente.setEstado(expedienteActualizado.getEstado());
            expediente.setResponsable(expedienteActualizado.getResponsable());
            expediente.setResponsable2(expedienteActualizado.getResponsable2());
            expediente.setDescripcion(expedienteActualizado.getDescripcion());
            expediente.setCondicion(expedienteActualizado.getCondicion());
            expediente.setPrecio(expedienteActualizado.getPrecio());
            expediente.setConsejeria(expedienteActualizado.getConsejeria());
            expediente.setExpediente(expedienteActualizado.getExpediente());
            return Optional.of(expedientesRepository.save(expediente));
        } else {
            return Optional.empty();
        }
    }

    public boolean borrarExpediente(Long id) {
        if (expedientesRepository.existsById(id)) {
            expedientesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
