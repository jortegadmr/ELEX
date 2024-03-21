package com.soltel.elex.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.soltel.elex.model.ActuacionesModel;
import com.soltel.elex.services.ActuacionesService;

import java.util.List;

@RestController
@RequestMapping("/actuaciones")
public class ActuacionesController {

    @Autowired
    private ActuacionesService actuacionesService;
    @GetMapping
    public List<ActuacionesModel> getAllActuaciones() {
        return this.actuacionesService.getAllActuaciones();
    }
    
}
