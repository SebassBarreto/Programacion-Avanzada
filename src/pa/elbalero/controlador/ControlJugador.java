package pa.elbalero.controlador;

import pa.elbalero.modelo.Equipo;
import pa.elbalero.modelo.Jugador;

public class ControlJugador {
    private Jugador jugador;
    private Equipo equipo;
    

    public void crearJugador(String nombre, String codigo){
        jugador = new Jugador();
        jugador.setNombre(nombre);
        jugador.setCodigo(codigo);
    }
    //Falta la validación de datos
    
    public String obtenerNombreJugador(){
        return jugador.getNombre();
    }
    
    public String obtenerCodigoJugador(){
        return jugador.getCodigo();
    }  
}
