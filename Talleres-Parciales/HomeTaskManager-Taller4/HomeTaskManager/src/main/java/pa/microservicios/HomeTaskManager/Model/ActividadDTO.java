package pa.microservicios.HomeTaskManager.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Asus Entidad a la que se le van a aplicar microservicios TABLA
 * actividades con id autogenerado
 */
@Entity
@Table(name = "actividades")
@Data
@NoArgsConstructor
public class ActividadDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActividad;

    @Column(name = "titulo", nullable = false, unique = false, length = 50)
    private String titulo;

    @Column(name = "descripcion", nullable = false, unique = false, length = 250)
    private String descripcion;

    @Column(name = "fecha_inicio", nullable = false, unique = false, length = 50)
    private LocalDate fechaInicio;

    @Column(name = "fecha_terminacion", nullable = false, unique = false, length = 50)
    private LocalDate fechaTerminacion;

    @Column(name = "tipo_actividad", nullable = false, unique = false, length = 50)
    private String tipoActividad;

    @Column(name = "id_quehacer", nullable = false, unique = false, length = 50)
    private int idQuehacer;

    @Column(name = "id_tutor", nullable = false, unique = false, length = 50)
    private int idTutor;

    @Column(name = "id_hijo_acargo", nullable = false, unique = false, length = 50)
    private int idHijoAcargo;

    /**
     * Constructor para el DTO sin ID
     * @param titulo
     * @param descripcion
     * @param fechaInicio
     * @param fechaTerminacion
     * @param tipoActividad
     * @param idQuehacer
     * @param idTutor
     * @param idHijoAcargo
     */
    public ActividadDTO(String titulo, String descripcion, LocalDate fechaInicio, LocalDate fechaTerminacion, String tipoActividad, int idQuehacer, int idTutor, int idHijoAcargo) {
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
