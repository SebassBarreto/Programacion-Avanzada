//package pa.microservicios.HomeTaskManager.Controller;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import pa.microservicios.HomeTaskManager.Model.ActividadDTO;
//import pa.microservicios.HomeTaskManager.Service.ActividadService;
//
///**
// *
// * @author Asus Clase RestController para devolver JSON y exponer los endpoints
// * mediante solicitudes http  DEBE PROBARSE USANDO POSTMAN ;D
// */
//@RestController
////generar una misma ruta para todos los endpoint
//@RequestMapping("actividad")
//public class ActividadRestController {
//
//    @Autowired
//    private ActividadService actividadService;
//
//    /**
//     * Inserta una actividad POST
//     *
//     * @param actividadDTO
//     * @return
//     */
//    @RequestMapping(method = RequestMethod.POST)
//    public ActividadDTO crearActividad(@RequestBody ActividadDTO actividadDTO) {
//        return actividadService.insertarActividad(actividadDTO);
//    }
//
//    /**
//     * Retorna una lista con todas las actividades GET
//     *
//     * @return
//     */
//    @RequestMapping(value = "/actividades", method = RequestMethod.GET)
//    public List<ActividadDTO> getAllActividades() {
//        return actividadService.getAllActividades();
//    }
//
//    /**
//     * Consulta una actividad por su id GET
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public ActividadDTO getActividadById(@PathVariable("id") Long id) {
//        return actividadService.getActividadById(id);
//    }
//
//    /**
//     * Borra una actividad por su id DELETE
//     *
//     * @param id
//     */
//    @RequestMapping(value = "/borraractividad/{id}", method = RequestMethod.DELETE)
//    public void borrarActividad(@PathVariable("id") Long id) {
//        actividadService.borrarActividad(id);
//    }
//
//    /**
//     * Actualiza una actividad por su id PUT
//     *
//     * @param id
//     * @param actividadDTO
//     * @return
//     */
//    @RequestMapping(value = "/actualizaractividad/{id}", method = RequestMethod.PUT)
//    public ActividadDTO actualizarActividad(@PathVariable("id") Long id, @RequestBody ActividadDTO actividadDTO) {
//        return actividadService.actualizarActividad(id, actividadDTO);
//    }
//}
