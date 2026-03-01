package pa.elbalero.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import pa.elbalero.modelo.Equipo;
import pa.elbalero.modelo.Jugador;

public class ControlEquipo {

    private ControlPrincipal controlPrincipal;
    private ControlJugador controlJugador;

    private List<Equipo> equiposInscritos;

    private Equipo equipoActual;

    public ControlEquipo(ControlPrincipal controlPrincipal, ControlJugador controlJugador) {
        this.controlPrincipal = controlPrincipal;
        this.controlJugador = controlJugador;
        //Inicializamos la lista dinamica vacia
        this.equiposInscritos = new ArrayList<>();
    }

    public void setEquipoActual(Equipo equipoActual) {
        this.equipoActual = equipoActual;
    }

    public void setEquiposInscritos(List<Equipo> equipos) {
        this.equiposInscritos = equipos;
    }

    public List<Equipo> getEquiposInscritos() {
        return equiposInscritos;
    }

    /**
     * Simula el turno de un equipo de jugar
     *
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
//                controlJugador.setJugadorActual(jugadorDeTurno);
//                controlJugador.jugarTurno(intentosPorJugador, generador);
//                puntosTotales += controlJugador.getPuntosObtenidos();
//                embocadasTotales += controlJugador.getEmbocadas();
            }

        }
        //Retornamos la estructura estatica con los resultados finales para control principal
        return new int[]{puntosTotales, embocadasTotales};
    }

    public Equipo getEquipoActual() {
        return equipoActual;
    }

    public int getCantidadEquipos() {
        return equiposInscritos.size();
    }

    public void cargarDatosAGrilla() {
        controlPrincipal.actualizarGrilla();
        for (Equipo equipo : getEquiposInscritos()) {
            for (Jugador jugador
                    : equipo.getJugadores()) {
                Object[] fila = {
                    equipo.getProyectoCurricular(),
                    equipo.getNombreEquipo(),
                    null,
                    jugador.getNombre(),
                    jugador.getPuntaje(),
                    jugador.getEmbocadasAcertadas(),
                    jugador.getEmbocadasDesacertadas(),
                    jugador.getEmbocadasAcertadas()
                    + jugador.getEmbocadasDesacertadas(),
                    0
                };
                controlPrincipal.agregarFilaGrilla(fila);
            }
        }
    }

    private Jugador obtenerJugador(int indiceEquipo, int indiceJugador) {
        if (indiceEquipo >= equiposInscritos.size()) {
            return null;
        }
        Equipo equipo = equiposInscritos.get(indiceEquipo);
        if (equipo.getJugadores() == null
                || indiceJugador >= equipo.getJugadores().length) {
            return null;
        }
        return equipo.getJugadores()[indiceJugador];
    }


    public Jugador getJugador(int indiceEquipo, int indiceJugador) {
        return obtenerJugador(indiceEquipo, indiceJugador);
    }

//    public String embocadaPuntos(int indiceEquipo, int indiceJugador){
//        Jugador j = getJugador(int indiceEquipo, int indiceJugador);
//        
//        return 
//    }
    public Jugador obtenerJugadorActual(
            int indiceEquipo,
            int indiceJugador) {

        return obtenerJugador(indiceEquipo, indiceJugador);
    }

    public Object[] ejecutarIntentoJugadorActual(int indiceEquipo, int indiceJugador, Random generador) {
        Jugador jugador = obtenerJugador(indiceEquipo, indiceJugador);
        if (jugador == null) {
            return null;
        }
        controlPrincipal.setJugadorActual(jugador);
        controlPrincipal.ejecutarIntento(generador);
        return new Object[]{jugador.getPuntaje(), jugador.getEmbocadasAcertadas(), jugador.getEmbocadasDesacertadas()};
    }

}
