package avanzada.microservices.msfabricantes.Repository;

import avanzada.microservices.msfabricantes.Model.FabricanteDTO;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteRepository  extends JpaRepository<FabricanteDTO, Long>{
    @Query(
        nativeQuery = true,
        value
        = "SELECT fab.id, fab.codigo, fab.nombre, fab.juguete FROM fabricantes fab join juguetes jug on jug.codigo=fab.juguete where jug.codigo = :jugueteCodigo")
       Optional<FabricanteDTO> findFabricanteByJugueteCodigo(@Param("jugueteCodigo") String jugueteCodigo);
}







