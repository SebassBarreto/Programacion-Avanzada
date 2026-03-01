package pa.elbalero.controlador;

import java.util.Random;
import pa.elbalero.modelo.Jugador;
import pa.elbalero.modelo.TipoEmbocada;

/**
 * Controlador encargado de gestionar la logica de un jugador individual.
 * Calcula los puntos segun el tipo de embocada y lleva el conteo de
 * intentos acertados y desacertados durante su turno.
 */
public class ControlJugador {

    private ControlPrincipal controlPrincipal;

    private Jugador jugadorActual;
    private int puntosObtenidos;
    private int embocadas;
    private int embocadasDesacertadas;
    private int embocadasAcertadas;
    
    /**
     * Crea el controlador de jugador con referencia al controlador principal
     * @param controlPrincipal referencia al controlador principal del juego
     */
    public ControlJugador(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
    }

    /**
     * Establece el jugador que tomara el turno y reinicia todos los contadores
     * de puntos y embocadas a cero para comenzar limpio.
     * @param jugador instancia del jugador que va a jugar
     */
    public void setJugadorActual(Jugador jugador) {
        this.jugadorActual = jugador;
        this.puntosObtenidos = 0;
        this.embocadas = 0;
        this.embocadasDesacertadas = 0;
        this.embocadasAcertadas = 0;
    }

    
    
    /**
     * Evalua el tipo de embocada recibido y suma los puntos correspondientes
     * al jugador actual. Actualiza los contadores internos y los del objeto Jugador.
     * Si la jugada es SIN_EMBOCADA solo incrementa las desacertadas.
     * @param jugada tipo de embocada obtenido aleatoriamente del enum TipoEmbocada
     */
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

    /**
     * Simula el turno completo del jugador ejecutando la cantidad de intentos indicada.
     * En cada intento selecciona aleatoriamente un tipo de embocada y calcula los puntos.
     * @param cantidadIntentos numero de veces que el jugador lanzara el balero
     * @param generador objeto Random inyectado para la seleccion aleatoria
     */
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
