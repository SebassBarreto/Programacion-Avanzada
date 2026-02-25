
package pa.elbalero.controlador;

import pa.elbalero.modelo.Equipo;
import pa.elbalero.modelo.Jugador;

public class ControlEquipo {
    private Equipo equipo;
    
    public void crearEquipo(Jugador jugador1, Jugador jugador2, Jugador jugador3, String nombre){
        Jugador[] arreglo = new Jugador[2];
        arreglo[0] = jugador1;
        arreglo[1] = jugador2;
        arreglo[2] = jugador3;
        equipo.setNombre(nombre);
        equipo.setJugador(arreglo);
    }
    
}
