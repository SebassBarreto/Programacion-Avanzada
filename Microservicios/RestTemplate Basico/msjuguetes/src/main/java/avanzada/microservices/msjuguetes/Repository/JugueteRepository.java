
package avanzada.microservices.msjuguetes.Repository;

import avanzada.microservices.msjuguetes.Domain.JugueteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//  JpaRepository<Juguete, Long>  --> <a que clase aplica los metodos, tipo dato de la clave>
public interface JugueteRepository extends JpaRepository<JugueteDTO, Long>{
    JugueteDTO findByCodigo(String codigo);
}
