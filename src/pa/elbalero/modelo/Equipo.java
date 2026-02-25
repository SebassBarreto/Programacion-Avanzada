package pa.elbalero.modelo;

public class Equipo {
    
    private String proyecto_curricular;
    private String nombre;
    private Jugador[] jugadores; //tamaño fijo 3
    private ResultadoEquipo resultado;

    public Equipo(String nombre, Jugador[] jugadores, String proyecto_curricular) {
        this.nombre = nombre;
        this.jugadores = jugadores;
        this.proyecto_curricular = proyecto_curricular;
    }

    public Equipo(String proyecto_curricular, String nombre, Jugador[] jugadores, ResultadoEquipo resultado) {
        this.proyecto_curricular = proyecto_curricular;
        this.nombre = nombre;
        this.jugadores = jugadores;
        this.resultado = resultado;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Jugador[] getJugador() {
        return jugadores;
    }

    public void setJugador(Jugador[] arreglo) {
        this.jugadores = arreglo;
    }
    
    public String getProyecto_curricular() {
        return proyecto_curricular;
    }

    public void setProyecto_curricular(String proyecto_curricular) {
        this.proyecto_curricular = proyecto_curricular;
    }
    
    public ResultadoEquipo getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoEquipo resultado) {
        this.resultado = resultado;
    }
}
