/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pa.microservicios.HomeTaskManager.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pa.microservicios.HomeTaskManager.Model.ActividadDTO;
import pa.microservicios.HomeTaskManager.Service.ActividadService;

/**
 *
 * @author Asus Clase controladora encargada de retornar html usando el
 * renderizado dinamico de html
 */
@Controller
@RequestMapping("actividad")
public class ActividadController {

    //Inyeccion autogestionada por spring
    @Autowired
    private ActividadService actividadService;

    /**
     * Muestra el formulario para insertar
     *
     * @param model
     * @return html con un formulario para la insercion
     */
    @RequestMapping(value = "/actividad", method = RequestMethod.GET)
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("actividad", new ActividadDTO());
        return "ingresodatos";
    }

    /**
     * Procesa los datos para realizar la insercion delegando a service que este
     * a su vez delega a repository
     *
     * @param actividadDTO
     * @return
     */
    @RequestMapping(value = "/actividad", method = RequestMethod.POST)
    public String procesarFormularioRegistro(@ModelAttribute ActividadDTO actividadDTO) {
        actividadService.insertarActividad(actividadDTO);
        return "redirect:/actividad/actividades";
    }

    /**
     * Simple GET que muestra las actividades actualmente guardadas en la bd
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/actividades", method = RequestMethod.GET)
    public String getAllActividades(Model model) {
        List<ActividadDTO> actividades = actividadService.getAllActividades();
        model.addAttribute("actividades", actividades);
        return "listado";
    }

    /**
     * Simple GET para consultar una actividad en la base de datos
     *
     * @param id
     * @param model
     * @return html con la informacion
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getActividadById(@PathVariable("id") Long id, Model model) {
        ActividadDTO actividad = actividadService.getActividadById(id);
        model.addAttribute("actividad", actividad);
        return "actividad";
    }

    /**
     * No se como se hace para borrar si los navegadores solo soportan get y
     * post ;c
     *
     * @param id
     * @return en teoria el listado con las actividades, pero no sirve este
     * metodo... tendria que probarse en postman
     */
    @RequestMapping(value = "/borraractividad/{id}", method = RequestMethod.DELETE)
    public String borrarActividad(@PathVariable Long id) {
        actividadService.borrarActividad(id);
        return "redirect:/listado";
    }

    /**
     * Muestra un formulario con la informacion actual de la actividad
     *
     * @param id
     * @param model
     * @return html
     */
    @RequestMapping(value = "/actualizaractividad/{id}", method = RequestMethod.GET)
    public String mostrarFormularioActualizar(@PathVariable Long id, Model model) {
        ActividadDTO actividad = actividadService.getActividadById(id);
        model.addAttribute("actividad", actividad);
        return "ingresodatos";
    }

    /**
     * Procesa el formulario de actualizar
     *
     * @param id
     * @param actividad
     * @return la lista de actividades para evidenciar que se hizo la respectiva
     * modificacion
     */
    @RequestMapping(value = "/actualizaractividad/{id}", method = RequestMethod.POST)
    public String procesarFormularioActualizar(@PathVariable Long id, @ModelAttribute ActividadDTO actividad) {
        actividadService.actualizarActividad(id, actividad);
        return "redirect:/actividad/actividades";
    }
}
