package pa.elbalero.modelo;

/**
 * Representa un equipo con datos básicos y su resultado.
 */
public class Equipo {

    private String nombreEquipo;
    private String proyectoCurricular;
    private Jugador[] jugadores; // tamaño fijo 3
    private ResultadoEquipo resultado;

    public Equipo() {
    }

    public Equipo(String nombreEquipo, String proyectoCurricular, Jugador[] jugadores, ResultadoEquipo resultado) {
        this.nombreEquipo = nombreEquipo;
        this.proyectoCurricular = proyectoCurricular;
        this.jugadores = jugadores;
        this.resultado = resultado;
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

    public ResultadoEquipo getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoEquipo resultado) {
        this.resultado = resultado;
    }
}