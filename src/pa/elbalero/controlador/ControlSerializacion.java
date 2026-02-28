/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pa.elbalero.controlador;

import java.io.File;
import java.io.IOException;
import java.util.List;
import pa.elbalero.modelo.Equipo;
import pa.elbalero.modelo.Serializador;

/**
 *
 * @author Asus
 */
public class ControlSerializacion {
    
    private Serializador conexionSerializacion;

    public ControlSerializacion(Serializador conexionSerializacion) {
        this.conexionSerializacion = conexionSerializacion;
    }
    
    public void guardarEquipo(File archivo, List<Equipo> listaEquipos) throws IOException{
        conexionSerializacion.escribirObjeto(archivo, listaEquipos);
    }
    
    public List<Equipo> cargarEquipos(File archivo) throws IOException, ClassNotFoundException{
        Object datosRecuperados = conexionSerializacion.leerObjeto(archivo);
        return (List<Equipo>) datosRecuperados;
    }
            
    
}
