package edu.prueba.ejemplo.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="juguetes")
@Data
public class Juguete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "codigo", nullable = false, unique = false, length = 50)
    private String codigo;
    @Column(name = "nombre", nullable = false, unique = false, length = 50)
    private String nombre;

    public Juguete() {
    }

    public Juguete(String codigo, String nombre) {
        this.codigo=codigo;
        this.nombre = nombre;
    }
}
