package pa.microservicios.HomeTaskManager.Model;

import java.time.LocalDate;
import lombok.Data;

/**
 * Clase para responder
 * @author Asus Entidad de salida
 */
@Data
public class ActividadResponsive {

    private String titulo;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaTerminacion;
    private String tipoActividad;
    private int idQuehacer;
    private int idTutor;
    private int idHijoAcargo;

    public ActividadResponsive(String titulo, String descripcion, LocalDate fechaInicio, LocalDate fechaTerminacion, String tipoActividad, int idQuehacer, int idTutor, int idHijoAcargo) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaTerminacion = fechaTerminacion;
        this.tipoActividad = tipoActividad;
        this.idQuehacer = idQuehacer;
        this.idTutor = idTutor;
        this.idHijoAcargo = idHijoAcargo;
    }
}
