package pa.elbalero.controlador;

import pa.elbalero.modelo.Equipo;
import pa.elbalero.modelo.Jugador;

public class ControlJugador {
    private Jugador jugador;
    private Equipo equipo;
    
    public void crearJugador(String nombre, int codigo, String proyectoc ){
        jugador = new Jugador();
        jugador.setNombre(nombre);
        jugador.setCodigo(codigo);
        jugador.setProyecto_curricular(proyectoc);
        
    }
    
    
}
