
package pa.elbalero.controlador;

import pa.elbalero.modelo.Equipo;
import pa.elbalero.modelo.Jugador;

public class ControlEquipo {
    private Equipo equipo;
    private Jugador[] arreglo;
    
    public ControlEquipo(){
       arreglo = new Jugador[2];
       equipo = new Equipo();
    }
    
    public void crearEquipo(Jugador jugador1, Jugador jugador2, Jugador jugador3, String nombre, String proyectoc){
        arreglo[0] = jugador1;
        arreglo[1] = jugador2;
        arreglo[2] = jugador3;
        equipo.setNombre(nombre);
        equipo.setJugador(arreglo);
        equipo.setProyecto_curricular(proyectoc);
    }
    
    public String obtenerNombreEquipo(){
        return equipo.getNombre();
    }
    
    public String obtenerProyectoCurricular(){
        return equipo.getProyecto_curricular();
    }
    
    public String obtenerJugadores(){
        return ""; //En proceso
    }
}
