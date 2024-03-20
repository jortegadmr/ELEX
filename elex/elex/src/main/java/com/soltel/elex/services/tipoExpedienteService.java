package com.soltel.elex.services;

import com.soltel.elex.model.tipoExpedienteModel;
import com.soltel.elex.repository.ITipoExpedienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class tipoExpedienteService {
    @Autowired
    ITipoExpedienteRepository tipoExpedienteRepository;

    public ArrayList<tipoExpedienteModel> getTipoExpedientes() {
        return (ArrayList<tipoExpedienteModel>) tipoExpedienteRepository.findAll();
    }
    
}   
    
