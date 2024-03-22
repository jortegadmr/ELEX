package com.soltel.elex.controller;

import com.soltel.elex.services.ActuacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.soltel.elex.model.ActuacionesModel;
import java.util.*;

@RestController
@RequestMapping("/actuaciones")
public class ActuacionesController {

	@Autowired
	private ActuacionesService actuacionesService;
	
	
		@GetMapping("/listado")
	    public List<ActuacionesModel> getAllActuaciones() {
	        return actuacionesService.getAllActuaciones();
		}

        @PostMapping("/nueva")
        public ActuacionesModel createActuacion(@RequestBody ActuacionesModel actuacion) {
            return actuacionesService.createActuacion(actuacion);
        }

        @GetMapping("/{id}")
        public ActuacionesModel getActuacionById(@PathVariable Long id) {
            Optional<ActuacionesModel> actuacion = actuacionesService.getActuacionById(id);
            return actuacion.orElseThrow(() -> new RuntimeException("Actuación no encontrada"));
        }

        @PutMapping("/{id}")
        public ActuacionesModel updateActuacion(@PathVariable Long id, @RequestBody ActuacionesModel actuacionDetails) {
            return actuacionesService.updateActuacion(id, actuacionDetails);
        }

        @DeleteMapping("/{id}")
        public void deleteActuacion(@PathVariable Long id) {
            actuacionesService.deleteActuacion(id);
        }
    }