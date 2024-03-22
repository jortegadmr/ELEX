package com.soltel.elex.services;

import com.soltel.elex.model.ActuacionesModel;
import com.soltel.elex.model.DocumentosModel;
import com.soltel.elex.repository.IDocumentosRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentosService {

    @Autowired
    private IDocumentosRepository documentosRepository;

    public List<DocumentosModel> consultarDocumentos() {
        return documentosRepository.findAll();
    }

    public Optional<DocumentosModel> consultarDocumentoPorId(Long id) {
        return documentosRepository.findById(id);
    }

    public DocumentosModel insertarDocumento(DocumentosModel documento) {
        return documentosRepository.save(documento);
    }

    public Optional<DocumentosModel> actualizarDocumento(Long id, DocumentosModel documentoActualizado) {
        Optional<DocumentosModel> documentoExistente = documentosRepository.findById(id);
        if (documentoExistente.isPresent()) {
            DocumentosModel documento = documentoExistente.get();
            BeanUtils.copyProperties(documentoActualizado, documento, "id");
            return Optional.of(documentosRepository.save(documento));
        } else {
            return Optional.empty();
        }
    }

    public boolean borrarDocumento(Long id) {
        if (documentosRepository.existsById(id)) {
            documentosRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<DocumentosModel> consultarDocumentosPorTipo(ActuacionesModel tipo) {
        return documentosRepository.findByTipo(tipo);
    }
}
