package pa.elbalero.controlador;

import java.util.Random;
import pa.elbalero.modelo.Jugador;
import pa.elbalero.modelo.TipoEmbocada;

public class ControlJugador {

    private ControlPrincipal controlPrincipal;
    
    private Jugador jugadorActual;
    private int puntosObtenidos;
    private int embocadas;

    public ControlJugador(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
    }
    
    public void setJugadorActual(Jugador jugador){
        this.jugadorActual = jugador;
        this.puntosObtenidos = 0;
        this.embocadas = 0;
    }
    
    /**
     *  Simula el turno completo del jugador.
     * @param cantidadIntentos Cuántas veces lanzará el balero este jugador.
     * @param generador El objeto Random inyectado desde un controlador superior.
     */
    public void jugarTurno(int cantidadIntentos, Random generador){
        for (int i = 0; i < cantidadIntentos; i++) {
            TipoEmbocada jugada = obtenerJugadaAleatoria(generador);
            calcularPuntosJugada(jugada);
        }
    }

    //Saca una jugada aleatoria con los valores del enum entre 0 y la longitud del enum
    private TipoEmbocada obtenerJugadaAleatoria(Random generador) {
        
        TipoEmbocada[] opciones = TipoEmbocada.values();
        
        return opciones[generador.nextInt(opciones.length)];
    }

    //Calcula los puntos de una jugada con un switch case
    private void calcularPuntosJugada(TipoEmbocada jugada) {

        switch (jugada) {
            case SIMPLE:
                this.puntosObtenidos+=2;
                this.embocadas++;
                break;
            case DOBLE:
                this.puntosObtenidos+=10;
                this.embocadas++;
                break;
            case VERTICAL:
                this.puntosObtenidos+=3;
                this.embocadas++;
                break;
            case MARIQUITA:
                this.puntosObtenidos+=4;
                this.embocadas++;
                break;
            case PUNIALADA:
                this.puntosObtenidos+=5;
                this.embocadas++;
                break;
            case PURTINIA:
                this.puntosObtenidos+=6;
                this.embocadas++;
                break;
            case DOMINIO_DE_REVES:
                this.puntosObtenidos+=8;
                this.embocadas++;
                break;
            case SIN_EMBOCADA:
                //no se hace nada
                break;
        }
    }

    //getters para que el control equipo tome los resultados
    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public int getPuntosObtenidos() {
        return puntosObtenidos;
    }

    public int getEmbocadas() {
        return embocadas;
    }
    
}
