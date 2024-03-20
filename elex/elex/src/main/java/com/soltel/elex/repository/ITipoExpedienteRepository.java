package com.soltel.elex.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.soltel.elex.model.tipoExpedienteModel;

@Repository
public interface ITipoExpedienteRepository extends JpaRepository<tipoExpedienteModel, Long> {

}
