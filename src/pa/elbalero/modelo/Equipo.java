package pa.elbalero.modelo;

import java.io.Serializable;

/**
 * Representa un equipo con datos básicos y su resultado.
 */
public class Equipo implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String nombreEquipo;
    private String proyectoCurricular;
    private Jugador[] jugadores; // tamaño fijo 3

    public Equipo() { 
    }

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

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }
    
}