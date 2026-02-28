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
    private int victorias;
    private int intentosEmbocados;
    
    private transient int Puntaje;

    public Equipo() { 
    }

    public Equipo(String nombreEquipo, String proyectoCurricular, Jugador[] jugadores, int victorias, int intentosEmbocados, int Puntaje) {
        this.nombreEquipo = nombreEquipo;
        this.proyectoCurricular = proyectoCurricular;
        this.jugadores = jugadores;
        this.victorias = victorias;
        this.intentosEmbocados = intentosEmbocados;
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

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getIntentosEmbocados() {
        return intentosEmbocados;
    }

    public void setIntentosEmbocados(int intentosEmbocados) {
        this.intentosEmbocados = intentosEmbocados;
    }

    public int getPuntaje() {
        return Puntaje;
    }

    public void setPuntaje(int Puntaje) {
        this.Puntaje = Puntaje;
    }
    
}
