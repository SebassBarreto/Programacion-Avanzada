package pa.elbalero.controlador;

import java.util.Random;
import pa.elbalero.modelo.Equipo;
import pa.elbalero.modelo.Jugador;

public class ControlEquipo {

    private ControlPrincipal controlPrincipal;
    private ControlJugador controlJugador;

    private Equipo equipoActual;

    public ControlEquipo(ControlPrincipal controlPrincipal, ControlJugador controlJugador) {
        this.controlPrincipal = controlPrincipal;
        this.controlJugador = controlJugador;
    }

    public void setEquipoActual(Equipo equipoActual) {
        this.equipoActual = equipoActual;
    }

    /**
     * Simula el turno de un equipo de jugar
     * @param tiempoTotalEquipo
     * @param generador
     * @return
     */
    public int[] jugarTurnoEquipo(int tiempoTotalEquipo, Random generador) {
        if (equipoActual == null || equipoActual.getJugadores() == null) {
            return new int[]{0, 0};
        }

        int intentosPorJugador = tiempoTotalEquipo / 3;

        Jugador[] jugadores = equipoActual.getJugadores();

        int puntosTotales = 0;
        int embocadasTotales = 0;

        for (int i = 0; i < 3; i++) {
            Jugador jugadorDeTurno = jugadores[i];

            if (jugadorDeTurno != null) {
                controlJugador.setJugadorActual(jugadorDeTurno);
                controlJugador.jugarTurno(intentosPorJugador, generador);
                puntosTotales += controlJugador.getPuntosObtenidos();
                embocadasTotales += controlJugador.getEmbocadas();
            }

        }
        //Retornamos la estructura estatica con los resultados finales para control principal
        return new int[]{puntosTotales, embocadasTotales};
    }

    public Equipo getEquipoActual() {
        return equipoActual;
    }

}
