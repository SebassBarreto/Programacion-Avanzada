package pa.microservicios.ejemplo1;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaRestController {

    ArrayList<Persona> personas = new ArrayList<>(List.of(new Persona("921839", "Luis","Correa"),
            new Persona("2342","santi", "arias"),
            new Persona("sasas","valentina", "aguilar")));
    
    @GetMapping("/personas/{cedula}")
    public Persona getPersonaByCedula(@PathVariable String cedula) {
        for(Persona persona : this.personas){
            if(persona.getCedula().equals(cedula)) return persona;
        }
        return null;
    }
}
