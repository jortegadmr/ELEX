package com.soltel.elex.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soltel.elex.model.TipoExpedienteModel;

@Repository
public interface ITipoExpedienteRepository extends JpaRepository<TipoExpedienteModel, Integer>{
	
}
