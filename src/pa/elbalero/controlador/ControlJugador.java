package pa.elbalero.controlador;

import java.util.Random;
import pa.elbalero.modelo.Jugador;
import pa.elbalero.modelo.TipoEmbocada;

public class ControlJugador {

    private ControlPrincipal controlPrincipal;

    private Jugador jugadorActual;
    private int puntosObtenidos;
    private int embocadas;
    private int embocadasDesacertadas;
    private int embocadasAcertadas;
    
    public ControlJugador(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
    }

    public void setJugadorActual(Jugador jugador) {
        this.jugadorActual = jugador;
        this.puntosObtenidos = 0;
        this.embocadasDesacertadas = 0;
        this.embocadasAcertadas = 0;
    }

    
    
    //Calcula los puntos de una jugada con un switch case
    public void calcularPuntosJugada(TipoEmbocada jugada) {

        switch (jugada) {
            case SIMPLE:
                this.puntosObtenidos += 2;
                this.embocadas++;
                
                break;
            case DOBLE:
                this.puntosObtenidos += 10;
                this.embocadas++;
                break;
            case VERTICAL:
                this.puntosObtenidos += 3;
                this.embocadas++;
                break;
            case MARIQUITA:
                this.puntosObtenidos += 4;
                this.embocadas++;
                break;
            case PUNIALADA:
                this.puntosObtenidos += 5;
                this.embocadas++;
                break;
            case PURTINIA:
                this.puntosObtenidos += 6;
                this.embocadas++;
                break;
            case DOMINIO_DE_REVES:
                this.puntosObtenidos += 8;
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

    public void setPuntosObtenidos(int puntosObtenidos) {
        this.puntosObtenidos = puntosObtenidos;
    }

    public int getEmbocadas() {
        return embocadas;
    }

    public void setEmbocadas(int embocadas) {
        this.embocadas = embocadas;
    }

    public int getEmbocadasDesacertadas() {
        return embocadasDesacertadas;
    }

    public void setEmbocadasDesacertadas(int embocadasDesacertadas) {
        this.embocadasDesacertadas = embocadasDesacertadas;
    }

    public int getEmbocadasAcertadas() {
        return embocadasAcertadas;
    }

    public void setEmbocadasAcertadas(int embocadasAcertadas) {
        this.embocadasAcertadas = embocadasAcertadas;
    }
}
