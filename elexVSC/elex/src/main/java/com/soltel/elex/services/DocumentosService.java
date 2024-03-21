package com.soltel.elex.services;

import com.soltel.elex.model.DocumentosModel;
import com.soltel.elex.repository.IDocumentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DocumentosService {

    private final IDocumentosRepository documentosRepository;

    @Autowired
    public DocumentosService(IDocumentosRepository documentosRepository) {
        this.documentosRepository = documentosRepository;
    }

    public List<DocumentosModel> getAllDocumentos() {
        return documentosRepository.findAll();
    }

    public DocumentosModel createDocumento(DocumentosModel documento) {
        return documentosRepository.save(documento);
    }

    public DocumentosModel updateDocumento(Long id, DocumentosModel documentoDetails) {
        DocumentosModel documento = documentosRepository.findById(id)
                                                        .orElseThrow(() -> new RuntimeException("Documento no encontrado"));

        documento.setNombre(documentoDetails.getNombre());
        documento.setDescripcion(documentoDetails.getDescripcion());
        documento.setFecha(documentoDetails.getFecha());
        documento.setArchivo(documentoDetails.getArchivo());
        documento.setTipo(documentoDetails.getTipo());

        return documentosRepository.save(documento);
    }

    public void deleteDocumento(Long id) {
        documentosRepository.deleteById(id);
    }
}
