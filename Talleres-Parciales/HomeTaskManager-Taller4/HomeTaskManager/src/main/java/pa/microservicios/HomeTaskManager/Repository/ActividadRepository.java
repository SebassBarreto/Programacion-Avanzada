package pa.microservicios.HomeTaskManager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pa.microservicios.HomeTaskManager.Model.ActividadDTO;

/**
 *
 * @author Asus
 */
@Repository
public interface ActividadRepository extends JpaRepository<ActividadDTO, Long> {
}