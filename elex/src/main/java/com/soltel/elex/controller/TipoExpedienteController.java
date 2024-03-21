package com.soltel.elex.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soltel.elex.model.TipoExpedienteModel;
import com.soltel.elex.services.TipoExpedienteService;

@RestController
@RequestMapping("/tipo-expediente")
public class TipoExpedienteController {
	 @Autowired
	    private TipoExpedienteService servicioTipo;

	    @GetMapping("/consultar")
	    public List<TipoExpedienteModel> dameTiposExpediente() {
	        return servicioTipo.consultarTipos();
	    }

	    @PostMapping("/insertar/{materia}")
	    public TipoExpedienteModel insertarTipo(@PathVariable String materia) {
	    	TipoExpedienteModel tipo = new TipoExpedienteModel();
	        tipo.setNombre(materia);
	        return servicioTipo.insertarTipo(tipo);
	    }

	    @PutMapping("/actualizar/{id}/{materia}")
	    public ResponseEntity<?> actualizarTipo(@PathVariable int id, @PathVariable String materia) {
	        Optional<TipoExpedienteModel> tipo = servicioTipo.obtenerTipoPorId(id);
	        if (tipo.isPresent()) {
	        	TipoExpedienteModel tipoActualizado = tipo.get();
	            tipoActualizado.setNombre(materia);
	            TipoExpedienteModel guardaTipo = servicioTipo.actualizarTipo(tipoActualizado);
	            return ResponseEntity.ok(guardaTipo);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo no encontrado");
	        }
	    }

	    
	    @DeleteMapping("/borrar/{id}")
	    public ResponseEntity<Void> borrarTipo(@PathVariable int id) {
	        return servicioTipo.obtenerTipoPorId(id)
	                .map(tipo -> {
	                    servicioTipo.borrarTipo(id);
	                    return ResponseEntity.ok().<Void>build();
	                })
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }
	}