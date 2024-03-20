package com.soltel.elex.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.soltel.elex.model.tipoExpediente;

@Repository
public interface ITipoExpediente extends JpaRepository<tipoExpediente, Long> {

}
