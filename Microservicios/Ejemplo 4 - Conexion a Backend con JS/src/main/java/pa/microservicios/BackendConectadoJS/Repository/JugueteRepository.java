package pa.microservicios.BackendConectadoJS.Repository;

import pa.microservicios.BackendConectadoJS.Modelo.Juguete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugueteRepository extends JpaRepository<Juguete, Long>{
    Juguete findByCodigo(String codigo);
}
