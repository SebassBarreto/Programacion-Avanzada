package pa.elbalero.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import pa.elbalero.modelo.Equipo;

/**
 *
 * @author Asus
 */
public class ControlJuego {

    private ControlPrincipal controlPrincipal;
    private ControlEquipo controlEquipo;

    private final Random generadorAzarGlobal;

    public ControlJuego(ControlPrincipal controlPrincipal, ControlEquipo controlEquipo, Random generadorAzarGlobal) {
        this.controlPrincipal = controlPrincipal;
        this.controlEquipo = controlEquipo;
        //se instancia un unico random  para garantizar equidad estadistica en el torneo
        this.generadorAzarGlobal = new Random();
    }

    /**
     * Motor principal del juego. 
     * Recibe la lista de equipos inscritos y el tiempo total asignado, simula el torneo completo 
     * @param equiposParticipantes Lista dinámica (ArrayList) con los equipos.
     * @param tiempoTotal El tiempo (en intentos) que jugará cada equipo.
     * @return Un arreglo de objetos con el Equipo Ganador, sus Puntos y sus Aciertos, retornamos un map entry.
     */
    public Object[] iniciarTorneo(ArrayList<Equipo> equiposParticipantes, int tiempoTotal) {
        if (equiposParticipantes == null || equiposParticipantes.isEmpty()) {
            return null;
        }

        //Estructura de datos para guardar la tabla de posiciones temporal
        //llave el objeto equipo
        //valor un arreglo de enteros [Puntos, EmbocadasTotales]
        Map<Equipo, int[]> tablaPosiciones = new HashMap<>();

        //Fase 1 meter a los equipos a jugar
        for (Equipo equipoActual : equiposParticipantes) {
            //Le decimos quien va a jugar
            controlEquipo.setEquipoActual(equipoActual);
            //Le ordenamos jugar y recibimos los resultados [puntos, exitos]
            int[] resultadosRonda = controlEquipo.jugarTurnoEquipo(tiempoTotal, generadorAzarGlobal);
            //Guardamos el resultado de este equipo en la tabla
            tablaPosiciones.put(equipoActual, resultadosRonda);
        }

        //Fase 2 encontramos al ganador aplicando las reglas
        Equipo equipoGanador = null;
        int maxPuntos = -1;
        int minIntentosEmbocados;
        minIntentosEmbocados = Integer.MAX_VALUE;

        for (Map.Entry<Equipo, int[]> registro : tablaPosiciones.entrySet()) {
            Equipo equipoEvaluado = registro.getKey();
            int puntosObtenidos = registro.getValue()[0];
            int embocadasObtenidas = registro.getValue()[1];

            if (puntosObtenidos > maxPuntos) {
                maxPuntos = puntosObtenidos;
                minIntentosEmbocados = embocadasObtenidas;
                equipoGanador = equipoEvaluado;
            } //Regla desempate si tienen los mismos puntos, gana el de MENOS intentos embocados
            else if (puntosObtenidos == maxPuntos) {
                if (embocadasObtenidas < minIntentosEmbocados) {
                    minIntentosEmbocados = embocadasObtenidas;
                    equipoGanador = equipoEvaluado;
                }
            }
        }

        /* 
         * Fase 3 Retornamos los datos del campein empacados en un arreglo de Objetos 
         * para el ControlPrincipal .
         * [0] = Entidad Equipo
         * [1] = Integer (Puntos)
         * [2] = Integer (Intentos Exitosos)
         */
        return new Object[]{equipoGanador, maxPuntos, minIntentosEmbocados};

    }

}
