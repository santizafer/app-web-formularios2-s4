package pe.edu.cibertec.appwebformularios2s4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.appwebformularios2s4.model.ImcModel;
import pe.edu.cibertec.appwebformularios2s4.model.PrimoModel;
import pe.edu.cibertec.appwebformularios2s4.model.PromedioModel;

@Controller
public class FormPrimoController {
    @GetMapping("/validarprimo")
    public String index(Model model) {
        model.addAttribute("verresultado", false);
        model.addAttribute("primomodel", new PrimoModel());
        return "formprimo";
    }


    @PostMapping("/validarprimo")
    public String validarPrimo(
            @ModelAttribute("primomodel")
            PrimoModel primoModel,
            Model model) {
        String resultado = esPrimo(primoModel.getNumero())
                ? "El número " + primoModel.getNumero() + " es PRIMO"
                : "El número " + primoModel.getNumero() + " no es Primo";

        model.addAttribute("verresultado", true);
        model.addAttribute("resultado", resultado);
        return "formprimo";
    }

    private Boolean esPrimo(Integer numero) {
        Integer contador = 0;
        for (int i = 1; i <= numero; i++) {
            if((numero % i) == 0) {
                contador++;
            }
        }

        return contador <= 2;
    }

}
