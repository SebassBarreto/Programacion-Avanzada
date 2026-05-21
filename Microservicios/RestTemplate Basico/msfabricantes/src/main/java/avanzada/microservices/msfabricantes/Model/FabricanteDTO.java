package avanzada.microservices.msfabricantes.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="fabricantes")
@Data
@NoArgsConstructor

public class FabricanteDTO {
   @Id
    //La forma en que se llena la comlumna, de forma secuencial
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @Column(name = "codigo", nullable = false, unique = true, length = 50) // 5. Personaliza la columna
    private String codigo;
   @Column(name = "nombre", nullable = false, unique = false, length = 50) // 5. Personaliza la columna
    private String nombre;
   @Column(name = "juguete", nullable = false, unique = false, length = 50) // 5. Personaliza la columna
    private String codigoJuguete;
    
    
        public FabricanteDTO(String codigo, String nombre, String codigoJuguete) {
        this.codigo=codigo;
        this.nombre = nombre;
        this.codigoJuguete=codigoJuguete;
    }
}
