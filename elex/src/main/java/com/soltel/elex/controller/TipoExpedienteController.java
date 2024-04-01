package com.soltel.elex.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soltel.elex.model.TipoExpedienteModel;
import com.soltel.elex.services.TipoExpedienteService;

@CrossOrigin (origins = "http://localhost:4200")
@RestController
@RequestMapping("/tipo-expediente")
public class TipoExpedienteController {
	 @Autowired
	    private TipoExpedienteService tipoExpedienteService;

	    @GetMapping("/consultar")
	    public List<TipoExpedienteModel> consultarTiposExpediente() {
	        return tipoExpedienteService.consultarTipos();
	    }

	    @PostMapping("/insertar/{nombre}")
	    public TipoExpedienteModel insertarTipo(@PathVariable String nombre) {
	    	TipoExpedienteModel tipo = new TipoExpedienteModel();
	        tipo.setNombre(nombre);
	        return tipoExpedienteService.insertarTipo(tipo);
	    }

	    @PutMapping("/actualizar/{id}/{nombre}")
	    public ResponseEntity<?> actualizarTipo(@PathVariable int id, @PathVariable String nombre) {
	        Optional<TipoExpedienteModel> tipo = tipoExpedienteService.obtenerTipoPorId(id);
	        if (tipo.isPresent()) {
	        	TipoExpedienteModel tipoActualizado = tipo.get();
	            tipoActualizado.setNombre(nombre);
	            TipoExpedienteModel guardaTipo = tipoExpedienteService.actualizarTipo(tipoActualizado);
	            return ResponseEntity.ok(guardaTipo);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo no encontrado");
	        }
	    }

	    
	    @DeleteMapping("/borrar/{id}")
	    public ResponseEntity<Void> borrarTipo(@PathVariable int id) {
	        return tipoExpedienteService.obtenerTipoPorId(id)
	                .map(tipo -> {
	                	tipoExpedienteService.borrarTipo(id);
	                    return ResponseEntity.ok().<Void>build();
	                })
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }
	}