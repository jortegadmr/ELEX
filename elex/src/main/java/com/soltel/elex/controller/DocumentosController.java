package com.soltel.elex.controller;

import com.soltel.elex.model.DocumentosModel;
import com.soltel.elex.services.DocumentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/documentos")
public class DocumentosController {

    @Autowired
    private DocumentosService documentosService;

    @GetMapping("/consultar")
    public List<DocumentosModel> consultarDocumentos() {
        return documentosService.consultarDocumentos();
    }

    @GetMapping("/consultar/{id}")
    public ResponseEntity<DocumentosModel> consultarDocumentoPorId(@PathVariable Long id) {
        Optional<DocumentosModel> documento = documentosService.consultarDocumentoPorId(id);
        return documento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/insertar")
    public ResponseEntity<DocumentosModel> insertarDocumento(@RequestBody DocumentosModel documento) {
        DocumentosModel documentoGuardado = documentosService.insertarDocumento(documento);
        return ResponseEntity.status(HttpStatus.CREATED).body(documentoGuardado);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<DocumentosModel> actualizarDocumento(@PathVariable Long id, @RequestBody DocumentosModel documentoActualizado) {
        Optional<DocumentosModel> documentoExistente = documentosService.actualizarDocumento(id, documentoActualizado);
        return documentoExistente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> borrarDocumento(@PathVariable Long id) {
        boolean borrado = documentosService.borrarDocumento(id);
        return borrado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
