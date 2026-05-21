/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pa.microservicios.ejemplo1;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *  
 * @author Asus
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Estudiante extends Persona{
    private String codigo;

    public Estudiante(String cedula, String nombre, String apellido, String codigo) {
        super(cedula, nombre, apellido);
        this.codigo=codigo;
    }
}
