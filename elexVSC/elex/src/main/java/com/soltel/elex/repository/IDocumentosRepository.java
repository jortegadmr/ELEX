package com.soltel.elex.repository;

import com.soltel.elex.model.DocumentosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocumentosRepository extends JpaRepository<DocumentosModel, Long> {
}
