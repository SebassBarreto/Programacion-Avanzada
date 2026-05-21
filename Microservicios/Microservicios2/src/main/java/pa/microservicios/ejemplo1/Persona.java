package pa.microservicios.ejemplo1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Persona {
    
    @NonNull
    private String cedula;
    private String nombre;
    private String apellido;


}

