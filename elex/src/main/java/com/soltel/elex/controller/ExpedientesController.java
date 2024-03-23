package com.soltel.elex.controller;

import com.soltel.elex.model.ExpedientesModel;
import com.soltel.elex.services.ExpedientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.*;

@RestController
@RequestMapping("/expedientes")
public class ExpedientesController {

    @Autowired
    private ExpedientesService expedientesService;

    @GetMapping("/consultar")
    public ResponseEntity<List<ExpedientesModel>> consultarExpedientes() {
        List<ExpedientesModel> expedientes = expedientesService.consultarExpedientes();
        return ResponseEntity.ok(expedientes);
    }

    @GetMapping("/consultar/{id}")
    public ResponseEntity<ExpedientesModel> consultarExpedientePorId(@PathVariable Long id) {
        Optional<ExpedientesModel> expediente = expedientesService.consultarExpedientePorId(id);
        return expediente.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/insertar")
    public ResponseEntity<ExpedientesModel> insertarExpediente(@RequestBody ExpedientesModel expediente) {
        ExpedientesModel expedienteGuardado = expedientesService.insertarExpediente(expediente);
        return ResponseEntity.status(HttpStatus.CREATED).body(expedienteGuardado);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ExpedientesModel> actualizarExpediente(@PathVariable Long id, @RequestBody ExpedientesModel expediente) {
        Optional<ExpedientesModel> expedienteActualizado = expedientesService.actualizarExpediente(id, expediente);
        return expedienteActualizado.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> borrarExpediente(@PathVariable Long id) {
        boolean borrado = expedientesService.borrarExpediente(id);
        return borrado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
