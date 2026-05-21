package pa.elbalero.modelo;

import java.io.Serializable;

/**
 * Representa un equipo participante en la competencia del balero.
 * Cada equipo tiene un nombre un proyecto curricular y un arreglo de tres jugadores.
 * Implementa Serializable para permitir la persistencia de datos.
 */
public class Equipo implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String nombreEquipo;
    private String proyectoCurricular;
    private Jugador[] jugadores; // tamaño fijo 3

    //Constructor Vacío
    public Equipo() { 
    }
    
    /**
     * Crea un equipo con todos sus datos basicos y su arreglo de jugadores
     * @param nombreEquipo nombre identificador del equipo
     * @param proyectoCurricular nombre del proyecto curricular al que pertenece
     * @param jugadores arreglo estatico de tres jugadores que conforman el equipo
     */
    public Equipo(String nombreEquipo, String proyectoCurricular, Jugador[] jugadores) {
        this.nombreEquipo = nombreEquipo;
        this.proyectoCurricular = proyectoCurricular;
        this.jugadores = jugadores;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getProyectoCurricular() {
        return proyectoCurricular;
    }

    public void setProyectoCurricular(String proyectoCurricular) {
        this.proyectoCurricular = proyectoCurricular;
    }
    
    //Devuelve los jugadores
    public Jugador[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }
    
}