
package pa.elbalero.modelo;

public class Equipo {
    private String nombre;
    private Jugador[] jugadores;
    private String proyecto_curricular;

    public Equipo() {
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
    
}
