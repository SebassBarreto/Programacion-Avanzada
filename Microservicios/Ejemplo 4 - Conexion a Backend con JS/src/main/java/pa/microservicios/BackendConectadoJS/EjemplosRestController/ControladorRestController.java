package pa.microservicios.BackendConectadoJS.EjemplosRestController;

import pa.microservicios.BackendConectadoJS.Modelo.Persona;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class ControladorRestController {
ArrayList<Persona> personas=new ArrayList<>(List.of(new Persona("123","Jhon","Herrera"),
            new Persona("456","Cesar","Alvarez"),
            new Persona("789","Sara","Pelaez")));
    
    @GetMapping("/{cedula}/{apellido}")
    public Persona getPersona(@PathVariable String cedula,@PathVariable String apellido) {
        for(Persona persona : this.personas){
            if(persona.getCedula().equals(cedula) && (persona.getApellido().equals(apellido))){
                return persona;
            }
        
        }
        return null;
    }
}
