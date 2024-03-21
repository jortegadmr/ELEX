package com.soltel.elex.controller;

import org.springframework.web.bind.annotation.RestController;
import com.soltel.elex.model.TipoExpedienteModel;
import com.soltel.elex.services.TipoExpedienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/tipoExpediente")

public class TipoExpedienteController {

        @Autowired
        private TipoExpedienteService tipoExpedienteService;
        @GetMapping
        public List<TipoExpedienteModel> getTipoExpedientes() {
            return this.tipoExpedienteService.getAllTipoExpedientes();
}

}
