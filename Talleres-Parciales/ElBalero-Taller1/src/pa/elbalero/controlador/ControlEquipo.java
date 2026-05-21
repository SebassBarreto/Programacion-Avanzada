package pa.elbalero.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.UIManager;
import pa.elbalero.modelo.Equipo;
import pa.elbalero.modelo.Jugador;

/**
 * Controlador encargado de gestionar los equipos inscritos en la competencia.
 * Maneja la lista dinamica de equipos la simulacion de turnos y la interaccion
 * con la grilla de la vista.
 */
public class ControlEquipo {

    private ControlPrincipal controlPrincipal;
    private ControlJugador controlJugador;

    private List<Equipo> equiposInscritos;

    private Equipo equipoActual;

    /**
     * Inicializa el controlador de equipos con referencias a los controladores
     * principal y de jugador. Crea la lista dinamica vacia de equipos inscritos.
     * @param controlPrincipal referencia al controlador principal
     * @param controlJugador referencia al controlador de jugador para delegar turnos
     */
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

    /**
     * Retorna la cantidad de equipos actualmente inscritos en la competencia
     * @return numero entero con el tamano de la lista de equipos
     */
    public int getCantidadEquipos() {
        return equiposInscritos.size();
    }

    /**
     * Recorre todos los equipos y sus jugadores para construir las filas de la grilla.
     * Cada fila contiene proyecto curricular nombre del equipo icono del jugador
     * nombre puntaje e intentos acertados y desacertados.
     */
    public void cargarDatosAGrilla() {
        controlPrincipal.actualizarGrilla();
        for (Equipo equipo : getEquiposInscritos()) {
            for (Jugador jugador
                    : equipo.getJugadores()) {
                Object[] fila = {
                    equipo.getProyectoCurricular(),
                    equipo.getNombreEquipo(),
                    UIManager.getIcon("OptionPane.informationIcon"),
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

    /**
     * Busca un jugador especifico por los indices de su equipo y posicion.
     * Retorna null si los indices estan fuera de rango.
     * @param indiceEquipo posicion del equipo en la lista
     * @param indiceJugador posicion del jugador en el arreglo del equipo
     * @return el jugador encontrado o null si no existe
     */
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

    /**
     * Ejecuta un intento de embocada para el jugador ubicado en los indices dados.
     * Establece al jugador como activo y delega la ejecucion al controlador principal.
     * @param indiceEquipo posicion del equipo en la lista
     * @param indiceJugador posicion del jugador dentro del equipo
     * @param generador objeto Random para la seleccion aleatoria de embocada
     * @return arreglo con puntaje embocadas acertadas y desacertadas o null si el jugador no existe
     */
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
