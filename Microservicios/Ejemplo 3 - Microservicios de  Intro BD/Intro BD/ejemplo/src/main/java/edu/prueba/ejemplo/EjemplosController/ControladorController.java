package edu.prueba.ejemplo.EjemplosController;

import edu.prueba.ejemplo.Modelo.Persona;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller
public class ControladorController {
    ArrayList<Persona> personas=new ArrayList<>(List.of(
            new Persona("123","Jhon","Herrera"),
            new Persona("456","Cesar","Alvarez"),
            new Persona("789","Sara","Pelaez")));
    
    @GetMapping("/inicio")
    public String mostrarPersonas(Model modelo) { 
        modelo.addAttribute("usuarios",personas);
        return "indice";
    }
}