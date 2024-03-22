package com.soltel.elex.services;

import org.springframework.stereotype.Service;
import com.soltel.elex.model.TipoExpedienteModel;
import com.soltel.elex.repository.ITipoExpedienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class TipoExpedienteService {

	@Autowired
    private ITipoExpedienteRepository repository;

    public List<TipoExpedienteModel> consultarTipos() {
        return repository.findAll();
    }

    public Optional<TipoExpedienteModel> obtenerTipoPorId(int id) {
        return repository.findById(id);
    }
    
    public TipoExpedienteModel insertarTipo(TipoExpedienteModel tipo) {
        return repository.save(tipo);
    }

    public TipoExpedienteModel actualizarTipo(TipoExpedienteModel tipo) {
        return repository.save(tipo);
    }

    public void borrarTipo(int id) {
        repository.deleteById(id);
    }

    
}
