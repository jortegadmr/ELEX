package com.soltel.elex.controller;

import org.springframework.web.bind.annotation.RestController;
import com.soltel.elex.model.tipoExpedienteModel;
import com.soltel.elex.services.tipoExpedienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/tipoExpediente")

public class tipoExpedienteController {

        @Autowired
        private tipoExpedienteService tipoExpedienteService;
        @GetMapping
        public List<tipoExpedienteModel> getTipoExpedientes() {
            return this.tipoExpedienteService.getAllTipoExpedientes();
}

}
