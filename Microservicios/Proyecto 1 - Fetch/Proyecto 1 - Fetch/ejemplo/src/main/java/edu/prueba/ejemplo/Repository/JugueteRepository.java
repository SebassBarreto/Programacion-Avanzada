package edu.prueba.ejemplo.Repository;

import edu.prueba.ejemplo.Modelo.Juguete;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugueteRepository extends JpaRepository<Juguete, Long>{
    Juguete findByCodigo(String codigo);
    List<Juguete> insertarJuguetes();
}
