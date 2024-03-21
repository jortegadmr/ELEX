package com.soltel.elex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.soltel.elex.model.ExpedientesModel;

public interface IExpedientesRepository extends JpaRepository<ExpedientesModel, Long> {
}
