package pa.elbalero.controlador;

import pa.elbalero.modelo.Equipo;
import pa.elbalero.modelo.Jugador;
import pa.elbalero.modelo.ResultadoEquipo;

public class ControlEquipo {
    private Equipo equipo;
    private Jugador[] arreglo;
    
    public ControlEquipo(){
       arreglo = new Jugador[2];
       
    }
    //Falta verificar que el Equipo si tenga 3 jugadores y los datos completos
    
    public void crearEquipo(Jugador jugador1, Jugador jugador2, Jugador jugador3, String nombre, String proyectoc){
        arreglo[0] = jugador1;
        arreglo[1] = jugador2;
        arreglo[2] = jugador3;
        equipo = new Equipo(nombre, proyectoc, arreglo);
    }
    
    public String obtenerNombreEquipo(){
        return equipo.getNombreEquipo();
    }
    
    public String obtenerProyectoCurricular(){
        return equipo.getProyectoCurricular();
    }
    
    public String obtenerJugadores(){
        return ""; //En proceso
    }
    
    
}
