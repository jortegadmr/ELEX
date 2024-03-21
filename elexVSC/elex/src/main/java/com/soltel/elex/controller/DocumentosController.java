package com.soltel.elex.controller;

import com.soltel.elex.model.DocumentosModel;
import com.soltel.elex.services.DocumentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/{id}")
    public DocumentosModel updateDocumento(@PathVariable Long id, @RequestBody DocumentosModel documentoDetails) {
        return documentosService.updateDocumento(id, documentoDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteDocumento(@PathVariable Long id) {
        documentosService.deleteDocumento(id);
    }
}
