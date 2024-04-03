package com.soltel.elex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@CrossOrigin (origins = "http://localhost:4200")
public class LoginController {
    @GetMapping("/login")

    public String getLoginPage() {
        return "login"; // Esto devuelve el nombre de la plantilla HTML de tu página de inicio de sesión
    }
}
