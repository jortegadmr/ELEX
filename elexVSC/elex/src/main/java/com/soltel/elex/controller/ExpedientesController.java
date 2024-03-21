package com.soltel.elex.controller;

import com.soltel.elex.model.ExpedientesModel;
import com.soltel.elex.services.ExpedientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expedientes")
public class ExpedientesController {

    private final ExpedientesService expedientesService;

    @Autowired
    public ExpedientesController(ExpedientesService expedientesService) {
        this.expedientesService = expedientesService;
    }

    @GetMapping
    public List<ExpedientesModel> getAllExpedientes() {
        return expedientesService.getAllExpedientes();
    }

    @PostMapping
    public ExpedientesModel createExpediente(@RequestBody ExpedientesModel expediente) {
        return expedientesService.createExpediente(expediente);
    }

    @GetMapping("/{id}")
    public ExpedientesModel getExpedienteById(@PathVariable Long id) {
        Optional<ExpedientesModel> expediente = expedientesService.getExpedienteById(id);
        return expediente.orElseThrow(() -> new RuntimeException("Expediente no encontrado"));
    }

    @PutMapping("/{id}")
    public ExpedientesModel updateExpediente(@PathVariable Long id, @RequestBody ExpedientesModel expedienteDetails) {
        return expedientesService.updateExpediente(id, expedienteDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteExpediente(@PathVariable Long id) {
        expedientesService.deleteExpediente(id);
    }
}
