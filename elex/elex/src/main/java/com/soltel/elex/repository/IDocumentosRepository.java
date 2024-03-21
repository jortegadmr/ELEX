package com.soltel.elex.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.soltel.elex.model.DocumentosModel;

@Repository
public interface IDocumentosRepository extends JpaRepository<DocumentosModel, Long> {
    // Puedes agregar métodos personalizados de consulta si es necesario
}
