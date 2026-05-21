//package pa.microservicios.ejemplo1;
//
//import java.util.ArrayList;
//import java.util.List;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class PersonaController {
//    
//    ArrayList<Persona> personas = new ArrayList<>(List.of(new Persona("921839", "Luis","Correa"),
//            new Persona("2342","santi", "arias"),
//            new Persona("2342","valentina", "aguilar")));
//    
//    @GetMapping("/popo")
//    public String iniciar(Model model) {
//        model.addAttribute("usuarios",  personas); // Envía datos a la vista
//        return "indice2";
//        
//    }
//
//}