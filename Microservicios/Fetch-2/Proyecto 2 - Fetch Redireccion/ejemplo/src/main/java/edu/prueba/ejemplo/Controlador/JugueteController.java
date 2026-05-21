package edu.prueba.ejemplo.Controlador;

import edu.prueba.ejemplo.Modelo.Juguete;
import edu.prueba.ejemplo.Service.JugueteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/juguete")
public class JugueteController {

    @Autowired
    private JugueteService servicios;

    @RequestMapping(value = "/juguete", method = RequestMethod.GET)
    public Juguete Juguete() {
        Juguete juguete = new Juguete("123", "Bob el Constructor");
        return servicios.crearJuguete(juguete);
    }

    @RequestMapping(value = "/juguete", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:8383")
    public ResponseEntity<Juguete> crearJuguete(@RequestBody Juguete juguete) {
        return servicios.crearUnJuguete(juguete);
    }

    @RequestMapping(value = "/mostrarjuguetes", method = RequestMethod.GET)
    public List<Juguete> mostrarTodosJuguetes() {
        return servicios.getAllJuguetes();
    }

    @RequestMapping(value = "/juguetes", method = RequestMethod.GET)
    public void obtenerJuguetes() {
        List<Juguete> juguetes = servicios.getAllJuguetes();
        for (Juguete juguete : juguetes) {
            System.out.println(juguete);
        }
    }

    @RequestMapping(value = "/juguete/{id}", method = RequestMethod.GET)
    public Juguete mostrarUnJuguete(@PathVariable("id") Long id) {
        Juguete juguete = servicios.getJuguetebyID(id);
        System.out.println(juguete.getNombre());
        return servicios.getJuguetebyID(id);
    }

    @RequestMapping(value = "/juguetecodigo/{codigo}", method = RequestMethod.GET)
    @CrossOrigin(origins = "https://localhost:8383")
    public ResponseEntity<Juguete> obtenerUnJuguete(@PathVariable("codigo") String codigo) {
        Juguete juguete = servicios.findByCodigo(codigo);
        return ResponseEntity.ok(juguete);
    }

    //@DeleteMapping("/api/borrarjuguete/{id}")
    @GetMapping("/borrarjuguete/{id}")
    //@RequestMapping(value = "/api/borrarjuguete/{id}", method = RequestMethod.DELETE)
    public void borrarUnJuguete(@PathVariable("id") Long id) {
        servicios.deleteJuguete(id);
    }
    
    @RequestMapping(value = "/juguetenombre/{nombre}", method = RequestMethod.GET)
    public ResponseEntity<Juguete> getJugueteByNombre(@PathVariable("nombre") String nombre){
        Juguete juguete = servicios.findByNombre(nombre);
        return ResponseEntity.ok(juguete);
    }
}
