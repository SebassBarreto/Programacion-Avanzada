package edu.prueba.ejemplo.Service;


import edu.prueba.ejemplo.Modelo.Juguete;
import edu.prueba.ejemplo.Repository.JugueteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
    
//Esta clase Service es la encargada de realizar los metodos CRUD
//haciendo uso del repositorio manejado por JPA
//Se anota con componente para describirlo como un Bean
//Bean -- componente que permite prestar servicios
@Component
public class JugueteService {

    @Autowired
    //permite describir que esta variable se va a inyectar a jugueteService
    private JugueteRepository repositorio;

    @CrossOrigin
    public Juguete crearJuguete(Juguete juguete) {
        return repositorio.save(juguete);
    }

    @CrossOrigin
    public Juguete getJuguetebyID(Long id) {
        //Optinal es un tipo de dato insertado a partir de JDK8, 
        //permite manejar excepciones por ejemplo
        Optional<Juguete> optionalJuguete = repositorio.findById(id);
        //El metodo get permite traer el objeto empaquetado dentro del optional
        return optionalJuguete.get();
    }

    @CrossOrigin
    public List<Juguete> getAllJuguetes() {
        return repositorio.findAll();
    }

    @CrossOrigin
    public void deleteJuguete(Long id) {
        repositorio.deleteById(id);
    }
}
