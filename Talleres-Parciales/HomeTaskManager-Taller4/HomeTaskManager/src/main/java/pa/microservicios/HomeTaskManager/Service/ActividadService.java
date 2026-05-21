package pa.microservicios.HomeTaskManager.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pa.microservicios.HomeTaskManager.Model.ActividadDTO;
import pa.microservicios.HomeTaskManager.Repository.ActividadRepository;

/**
 * Esta clase service es la encargada de los metodos CRUD haciendo uso del jpa
 * repository
 *
 * @author Asus
 */
@Service
public class ActividadService {

    //inyeccion de dependencias auto gestionada por spring
    @Autowired
    private ActividadRepository actividadRepository;

    /**
     * Permite insertar una nueva actividad
     *
     * @param actividad
     * @return ActividadDTO guardada en al BD
     */
    public ActividadDTO insertarActividad(ActividadDTO actividad) {
        return actividadRepository.save(actividad);
    }

    /**
     * Retorna todas las actividades
     *
     * @return Lista de ActividadDTO  
     */
    public List<ActividadDTO> getAllActividades() {
        return actividadRepository.findAll();
    }

    /**
     * Buscar una actividad por id
     *
     * @param id
     * @return ActividadDTO 
     */
    public ActividadDTO getActividadById(Long id) {
        //Optional porque me permite manejar excepciones
        Optional<ActividadDTO> optionalActividadDTO = actividadRepository.findById(id);
        //Metodo get, me permite traer el objeto empaquetado dentro del optional
        return optionalActividadDTO.get();
    }

    /**
     * Borra una actividad por id
     *
     * @param id
     */
    public void borrarActividad(Long id) {
        actividadRepository.deleteById(id);
    }

    /**
     * Actualiza una actividad, si existe le coloca un nuevo id y la guarda,
     * pero como ya esta adentro le hace UPDATE
     *
     * @param id
     * @param actividadActualizada
     * @return ActividadDTO actualizada y guardada en la BD usando .save
     */
    public ActividadDTO actualizarActividad(Long id, ActividadDTO actividadActualizada) {
        //verificar que existe
        if (!actividadRepository.existsById(id)) {
            throw new RuntimeException("Actividad no encontrada");
        }

        //setear el ID al objeto nuevo
        actividadActualizada.setIdActividad(id);

        //guardar (JPA detecta que existe y hace UPDATE)
        return actividadRepository.save(actividadActualizada);
    }

}
