package microservicios.envioSaludo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Las anotaciones de mapeo permiten asignar solicitudes HTTP a métodos
 * específicos del controlador. Los dos métodos de este controlador están
 * mapeados a `/saludo`. El método `greetingForm()` está mapeado específicamente a GET mediante
 * `@GetMapping`, mientras que `greetingSubmit()` está mapeado a POST con
 * `@PostMapping`. Este mapeo permite al controlador diferenciar las solicitudes
 * al endpoint `/saludo`.
 * 
 * 
 * Lo presentado es un patrón muy común en Spring MVC (aplicaciones web con Thymeleaf o JSP) utilizar 
 * el mismo endpoint para @GetMapping y @PostMapping en el mismo controlador, 
 * donde el PostMapping utiliza @ModelAttribute para vincular los datos del formulario a un objeto Java
 *
 * @author User
 */
@Controller
public class SaludoController {

    /**
     * El método `greetingForm()` utiliza un objeto `Model` para exponer un
     * nuevo `Saludo` a la plantilla de vista. El objeto de tipo clase Saludo`
     * contiene campos como `nombre` y `contenido` que corresponden a los campos
     * del formulario en la vista `saludo` y se utilizan para capturar la
     * información del formulario
     *
     * @param model
     * @return
     */

    /**
     * La implementación del cuerpo del método se basa en una tecnología de
     * vista para realizar la renderización del HTML en el servidor,
     * convirtiendo el nombre de la vista (saludo) en una plantilla para su
     * renderización. En este caso, utilizamos Thymeleaf, que analiza la
     * plantilla saludo.html y evalúa las distintas expresiones de plantilla
     * para renderizar el formulario.
     *
     * @param model
     * @return
     */
    @GetMapping("/saludo")
    public String greetingForm(Model model) {
        model.addAttribute("saludo", new Saludo());
        return "saludo";
    }

    /**
     * Como se mencionó anteriormente, el formulario se envía al endpoint
     * /saludo mediante una llamada POST. El método greetingSubmit() recibe el
     * objeto Saludo que se completó con el formulario. Saludo es un
     * @ModelAttribute, por lo que está vinculado al contenido del formulario
     * entrante.
     * 
     * @ModelAttribute: En el PostMapping, esta anotación se encarga de realizar 
     * el data binding (vinculación de datos), mapeando automáticamente los campos 
     * del formulario HTML a los atributos del objeto Java.
     *
     * @param saludo
     * @param model
     * @return
     */
    @PostMapping("/saludo")
    public String greetingSubmit(@ModelAttribute Saludo saludo, Model model) {
        model.addAttribute("saludo", saludo);
        return "resultado";
    }
}
