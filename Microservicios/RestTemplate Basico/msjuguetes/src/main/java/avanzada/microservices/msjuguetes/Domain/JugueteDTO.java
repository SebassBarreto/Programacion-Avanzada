package avanzada.microservices.msjuguetes.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

//Esta clase se va a mapear como una tabla en la BD
@Entity // 1. Marca la clase como entidad
//Como se va a llamar la tabla en la BD
@Table(name="juguetes")// 2. Define el nombre de la tabla
@Data
@NoArgsConstructor

public class JugueteDTO {

    @Id // 3. Define la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 4. Autoincremental
    private Long id;
    @Column(name = "codigo", nullable = false, unique = true, length = 50) // 5. Personaliza la columna
    private String codigo;
    @Column(name = "nombre", nullable = false, unique = false, length = 50) // 6. Personaliza la columna
    private String nombre;

    public JugueteDTO(String codigo, String nombre) {
        this.codigo=codigo;
        this.nombre = nombre;
        
    }
}