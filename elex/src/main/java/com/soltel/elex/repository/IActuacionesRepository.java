package com.soltel.elex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.soltel.elex.model.ActuacionesModel;
import org.springframework.stereotype.Repository;

@Repository
public interface IActuacionesRepository extends JpaRepository<ActuacionesModel, Long> {
	
}
