package com.soltel.elex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.soltel.elex.model.TipoExpedienteModel;
import com.soltel.elex.services.TipoExpedienteService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipo-expediente")
public class TipoExpedienteController {

    @Autowired
    private TipoExpedienteService tipoExpedienteService;

    @GetMapping
    public List<TipoExpedienteModel> getAllTipoExpedientes() {
        return tipoExpedienteService.getAllTipoExpedientes();
    }

    @GetMapping("/{id}")
    public TipoExpedienteModel getTipoExpedienteById(@PathVariable Long id) {
        return tipoExpedienteService.getTipoExpedienteById(id);
    }

    @PostMapping
    public TipoExpedienteModel createTipoExpediente(@RequestBody TipoExpedienteModel tipoExpediente) {
        return tipoExpedienteService.createTipoExpediente(tipoExpediente);
    }

    @PutMapping("/{id}")
    public TipoExpedienteModel updateTipoExpediente(@PathVariable Long id, @RequestBody TipoExpedienteModel tipoExpedienteDetails) {
        return tipoExpedienteService.updateTipoExpediente(id, tipoExpedienteDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteTipoExpediente(@PathVariable Long id) {
        tipoExpedienteService.deleteTipoExpediente(id);
    }
}
