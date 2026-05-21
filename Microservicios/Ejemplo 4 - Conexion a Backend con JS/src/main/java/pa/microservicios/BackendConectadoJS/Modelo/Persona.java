package pa.microservicios.BackendConectadoJS.Modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @NonNull
    private String cedula;
    private String nombre;
    private String apellido;
}
