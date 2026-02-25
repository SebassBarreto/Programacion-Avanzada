package pa.elbalero.controlador;

import pa.elbalero.modelo.Equipo;
import pa.elbalero.modelo.Jugador;

public class ControlJugador {
    private Jugador jugador;
    private Equipo equipo;
    
    public void crearJugador(String nombre, int codigo){
        jugador = new Jugador(nombre,codigo);
    }
    
    //Falta la validación de datos
    
    public String obtenerNombreJugador(){
        return jugador.getNombre();
    }
    
    public String obtenerCodigoJugador(){
        return Integer.toString(jugador.getCodigo());
    }
    
}
