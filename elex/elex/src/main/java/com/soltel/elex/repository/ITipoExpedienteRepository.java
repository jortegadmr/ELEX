package com.soltel.elex.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.soltel.elex.model.TipoExpedienteModel;
import java.util.List;

@Repository
public interface ITipoExpedienteRepository extends JpaRepository<TipoExpedienteModel, Long> {

    TipoExpedienteModel findByNombre(String nombre);

    List<TipoExpedienteModel> findByEstado(boolean estado);
    
}
