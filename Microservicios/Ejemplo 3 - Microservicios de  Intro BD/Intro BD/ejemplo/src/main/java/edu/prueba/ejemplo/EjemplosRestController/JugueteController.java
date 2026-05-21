package edu.prueba.ejemplo.EjemplosRestController;

import edu.prueba.ejemplo.Modelo.Juguete;
import edu.prueba.ejemplo.Service.JugueteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//Permite generar una ruta igual para todos los endpoint
@RequestMapping("/juguete")
public class JugueteController {

    //Se va a inyectar el Service
    @Autowired
    private JugueteService servicios;
    
/**
 * Como estamos haciendo peticiones desde un navegador (sin ningun tipo de 
 * formulario o contexto), realiza una llamada GET porque esta solicitando 
 * la pagina correspondiente a la url, al acceder a la url localhost:8082/register 
 * el navegador realiza una llamada de tipo GET pero al tener solo definido el 
 * método POST genera el error Request method 'GET' is not supported. 
 * Si accedes con el navegador por con la url "/register" tienes que definir un
 * método anotado con @GetMapping("/register")ya que puedes tener los métodos 
 * POST y GET sobre la misma URL y dependiendo la acción se llamara a uno u otro.
 */

    @RequestMapping(value = "/juguete", method = RequestMethod.GET)
    public Juguete Juguete() {
        Juguete juguete=new Juguete("Bob el Constructor");
        return servicios.crearJuguete(juguete);
    }
    
    @RequestMapping(value = "/juguete", method = RequestMethod.POST)
    //Se mape POST porque va a guardar un objeto
    //La siguiente linea se usaria cuando se tenga el FrontEnd
    public Juguete crearJuguete(@RequestBody Juguete juguete) {
        return servicios.crearJuguete(juguete);
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
        Juguete juguete=servicios.getJuguetebyID(id);
        System.out.println(juguete.getNombre());
        return servicios.getJuguetebyID(id);
    }
    
    //@DeleteMapping("/api/borrarjuguete/{id}")
    @GetMapping("/borrarjuguete/{id}")
    //@RequestMapping(value = "/api/borrarjuguete/{id}", method = RequestMethod.DELETE)
    public void borrarUnJuguete(@PathVariable("id") Long id) {
        servicios.deleteJuguete(id);
    }   
}