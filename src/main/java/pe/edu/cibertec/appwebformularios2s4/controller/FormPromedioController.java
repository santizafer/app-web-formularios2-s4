package pe.edu.cibertec.appwebformularios2s4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormPromedioController {
    @GetMapping("/formpromedio")
    public String formpromedio(Model model) {
        return "formpromedio";
    }
}
