package edu.prueba.ejemplo.Service;

import edu.prueba.ejemplo.Modelo.Juguete;
import edu.prueba.ejemplo.Repository.JugueteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@Component
public class JugueteService {

    @Autowired
    private JugueteRepository repositorio;

    @CrossOrigin
    public Juguete crearJuguete(Juguete juguete) {
        return repositorio.save(juguete);
    }

    @CrossOrigin
    public ResponseEntity<Juguete> crearUnJuguete(Juguete juguete) {
        repositorio.save(juguete);
        return ResponseEntity.ok(juguete);
    }

    @CrossOrigin
    public Juguete getJuguetebyID(Long id) {
        Optional<Juguete> optionalJuguete = repositorio.findById(id);
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
    
    @CrossOrigin
    public Juguete findByCodigo(String codigo){
    return repositorio.findByCodigo(codigo);
    }
    
    @CrossOrigin
    public Juguete findByNombre(String nombre){
        return repositorio.findByNombre(nombre);
    }
}
