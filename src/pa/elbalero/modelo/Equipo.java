
package pa.elbalero.modelo;

public class Equipo {
    private String nombre;
    private Jugador[] jugadores;

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
    
    
}
