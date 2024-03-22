package com.soltel.elex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soltel.elex.model.ActuacionesModel;
import com.soltel.elex.model.DocumentosModel;

public interface IDocumentosRepository extends JpaRepository<DocumentosModel, Long> {
    List<DocumentosModel> findByTipo(ActuacionesModel tipo);
}
