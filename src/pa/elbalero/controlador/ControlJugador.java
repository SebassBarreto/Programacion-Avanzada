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
        this.embocadas = 0;
        this.embocadasDesacertadas = 0;
        this.embocadasAcertadas = 0;
    }

    
    
    public void calcularPuntosJugada(TipoEmbocada jugada) {

        switch (jugada) {
            case SIMPLE:
                this.puntosObtenidos += 2;
                this.embocadas++;
                this.embocadasAcertadas++;
                if (jugadorActual != null) {
                    jugadorActual.agregarPuntaje(2);
                    jugadorActual.incrementarAcertadas();
                }
                break;
            case DOBLE:
                this.puntosObtenidos += 10;
                this.embocadas++;
                this.embocadasAcertadas++;
                if (jugadorActual != null) {
                    jugadorActual.agregarPuntaje(10);
                    jugadorActual.incrementarAcertadas();
                }
                break;
            case VERTICAL:
                this.puntosObtenidos += 3;
                this.embocadas++;
                this.embocadasAcertadas++;
                if (jugadorActual != null) {
                    jugadorActual.agregarPuntaje(3);
                    jugadorActual.incrementarAcertadas();
                }
                break;
            case MARIQUITA:
                this.puntosObtenidos += 4;
                this.embocadas++;
                this.embocadasAcertadas++;
                if (jugadorActual != null) {
                    jugadorActual.agregarPuntaje(4);
                    jugadorActual.incrementarAcertadas();
                }
                break;
            case PUNIALADA:
                this.puntosObtenidos += 5;
                this.embocadas++;
                this.embocadasAcertadas++;
                if (jugadorActual != null) {
                    jugadorActual.agregarPuntaje(5);
                    jugadorActual.incrementarAcertadas();
                }
                break;
            case PURTINIA:
                this.puntosObtenidos += 6;
                this.embocadas++;
                this.embocadasAcertadas++;
                if (jugadorActual != null) {
                    jugadorActual.agregarPuntaje(6);
                    jugadorActual.incrementarAcertadas();
                }
                break;
            case DOMINIO_DE_REVES:
                this.puntosObtenidos += 8;
                this.embocadas++;
                this.embocadasAcertadas++;
                if (jugadorActual != null) {
                    jugadorActual.agregarPuntaje(8);
                    jugadorActual.incrementarAcertadas();
                }
                break;
            case SIN_EMBOCADA:
                this.embocadasDesacertadas++;
                if (jugadorActual != null) {
                    jugadorActual.incrementarDesacertadas();
                }
                break;
        }
    }

    public void jugarTurno(int cantidadIntentos, Random generador) {
        TipoEmbocada[] opciones = TipoEmbocada.values();
        for (int i = 0; i < cantidadIntentos; i++) {
            TipoEmbocada jugada = opciones[generador.nextInt(opciones.length)];
            calcularPuntosJugada(jugada);
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
