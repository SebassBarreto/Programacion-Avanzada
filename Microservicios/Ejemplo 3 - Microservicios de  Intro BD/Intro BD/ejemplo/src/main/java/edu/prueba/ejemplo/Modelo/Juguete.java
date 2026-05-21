package edu.prueba.ejemplo.Modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity //entidad que se va a guardar
@Table(name="juguetes") //nombre que va a tener la tabla en la BD
@Data
public class Juguete {

    @Id //llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //que se autoincremente sola .IDENTITY
    private Long id;
    //nombre de la columna, si puede ser nula, si es unica, cantidad de caracteres
    @Column(name = "nombre", nullable = false, unique = false,length = 50)
    private String nombre;

    public Juguete() {
    }

    public Juguete(String nombre) {
        this.nombre = nombre;
    }
}
