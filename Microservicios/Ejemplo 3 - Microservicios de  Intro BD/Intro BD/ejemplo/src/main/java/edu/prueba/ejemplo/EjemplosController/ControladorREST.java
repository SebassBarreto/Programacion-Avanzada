package edu.prueba.ejemplo.EjemplosController;

import edu.prueba.ejemplo.Modelo.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//@Controller
public class ControladorREST {
    
    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("persona", new Persona());
        return "indice1";
    }

    @PostMapping("/registro")
    public String procesarFormularioRegistro(@ModelAttribute Persona persona) {
        return "indice2";
    }
}
