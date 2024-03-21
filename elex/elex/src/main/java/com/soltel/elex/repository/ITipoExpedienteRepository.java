package com.soltel.elex.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.soltel.elex.model.tipoExpedienteModel;
import java.util.List;

@Repository
public interface ITipoExpedienteRepository extends JpaRepository<tipoExpedienteModel, Long> {

    tipoExpedienteModel findByNombre(String nombre);

    List<tipoExpedienteModel> findByEstado(boolean estado);
    
}
