package com.soltel.elex.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.soltel.elex.model.DocumentosModel;
import com.soltel.elex.services.DocumentosService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/documentos")
public class DocumentosController {

    private final DocumentosService documentosService;

    @Autowired
    public DocumentosController(DocumentosService documentosService) {
        this.documentosService = documentosService;
    }

    @GetMapping
    public List<DocumentosModel> getAllDocumentos() {
        return documentosService.getAllDocumentos();
    }

    @PostMapping
    public DocumentosModel createDocumento(@RequestBody DocumentosModel documento) {
        return documentosService.createDocumento(documento);
    }

    @GetMapping("/{id}")
    public DocumentosModel getDocumentoById(@PathVariable Long id) {
        Optional<DocumentosModel> documento = documentosService.getDocumentoById(id);
        return documento.orElseThrow(() -> new RuntimeException("Documento no encontrado"));
    }

    @PutMapping("/{id}")
    public DocumentosModel updateDocumento(@PathVariable Long id, @RequestBody DocumentosModel documentoDetails) {
        return documentosService.updateDocumento(id, documentoDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteDocumento(@PathVariable Long id) {
        documentosService.deleteDocumento(id);
    }
}
