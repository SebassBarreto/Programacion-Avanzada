package pa.elbalero.modelo;

import java.io.Serializable;

/**
 * Representa un equipo con datos básicos y su resultado.
 */
public class Equipo implements Serializable{

    private String nombreEquipo;
    private String proyectoCurricular;
    private Jugador[] jugadores; // tamaño fijo 3
    private transient int Puntaje;

    public Equipo() {
    }

    public Equipo(String nombreEquipo, String proyectoCurricular, Jugador[] jugadores, int Puntaje) {
        this.nombreEquipo = nombreEquipo;
        this.proyectoCurricular = proyectoCurricular;
        this.jugadores = jugadores;
        this.Puntaje = Puntaje;
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

    public int getPuntaje() {
        return Puntaje;
    }

    public void setPuntaje(int Puntaje) {
        this.Puntaje = Puntaje;
    }
    
}
