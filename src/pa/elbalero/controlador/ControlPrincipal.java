package pa.elbalero.controlador;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.JFileChooser;
import pa.elbalero.modelo.ConexionSerializacion;
import pa.elbalero.modelo.Equipo;
import pa.elbalero.modelo.Jugador;
import pa.elbalero.modelo.TipoEmbocada;

public class ControlPrincipal {

    private ControlVista controlVista;
    private ControlProperties controlProperties;
    private ControlEquipo controlEquipo;
    private ControlJugador controlJugador;
    private ControlRAF controlRAF;
    private ControlSerializacion controlSerializacion;

    //private List<Equipo> equiposInscritos;
    private int tiempoCompetencia;
    private double tiempoPorEquipo;
    private double tiempoPorJugador;
    private Equipo equipoGanadorActual;
    private int puntosGanadorActual;
    private int embocadasGanadorActual;
    private final Random generadorAzarGlobal;

    public ControlPrincipal() {
        //Inicializamos la lista dinamica vacia
        //this.equiposInscritos = new ArrayList<>();
        //Instanciamos los controladores de persistencia (Archivos)
        controlProperties = new ControlProperties(this);
        controlRAF = new ControlRAF(this);
        controlSerializacion = new ControlSerializacion(this, new ConexionSerializacion());

        //Instanciamos el Motor del Juego (Inyeccion de dependencias en cascada)
        controlJugador = new ControlJugador(this);
        controlEquipo = new ControlEquipo(this, this.controlJugador);
        generadorAzarGlobal = new Random();
        cargarDatosIniciales();
        //Por ultimo, inicializamos la Vista
        //Se hace al final para asegurar que toda la logica ya existe si la vista dispara un evento
        controlVista = new ControlVista(this);
    }

    public File seleccionarArchivo() {
        JFileChooser chooser = new JFileChooser();
        int opcion = chooser.showOpenDialog(null);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }
        return null;
    }

    public void cargarDatosIniciales() {
        File archivo = seleccionarArchivo();
        int ejecuciones = controlProperties.obtenerNumeroEjecuciones();
        if (ejecuciones == 0) {
            try {
                cargarEquiposDesdeProperties(archivo);
            } catch (IOException ex) {

            }
        } else {
            try {
                precargarEquiposSerializados(archivo);
            } catch (IOException ex) {

            } catch (ClassNotFoundException ex) {

            }
        }
        //controlProperties.actualizarEjecuciones(ejecuciones + 1);
    }

    //Metodos de  (la vista los va a llamar para los eventos)
    /**
     * Carga los equipos desde un archivo .properties seleccionado por el
     * JFileChooser. Propaga la excepcion para que ControlVista se encarge.
     *
     * @param archivoProperties
     * @throws IOException
     */
    public void cargarEquiposDesdeProperties(File archivoProperties) throws IOException {
        controlEquipo.setEquiposInscritos(controlProperties.cargarEquipos(archivoProperties));
    }

    /**
     * Carga los equipos desde un archivo .properties seleccionado por el
     * JFileChooser. Propaga la excepcion para que ControlVista se encarge.
     *
     * @param archivoSerializado
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void precargarEquiposSerializados(File archivoSerializado) throws IOException, ClassNotFoundException {
        controlEquipo.setEquiposInscritos(controlSerializacion.cargarEquipos(archivoSerializado));
    }

    /**
     * Guarda el tiempo digitado por el usuario en la interfaz
     *
     * @param t
     */
    public void setTiempoDeLaCompetencia(int t) {
        tiempoCompetencia = t;
        tiempoPorEquipo = tiempoCompetencia / controlEquipo.getCantidadEquipos();
        tiempoPorJugador = tiempoPorEquipo / 3;
    }

    /**
     * Retorna un booleano para indicar a la vista si el torneo se pudo ejecutar
     * o no
     *
     * @return falso si se invalidó algo
     */
    public boolean ejecutarTorneo() {
        if (controlEquipo.getEquiposInscritos().isEmpty() || tiempoCompetencia <= 0) {
            return false;
        }

        //Delegando al motor del juego que haga los ciclos y calculos
        Object[] resultados;
        resultados = iniciarTorneo((ArrayList<Equipo>) controlEquipo.getEquiposInscritos(), tiempoCompetencia);

        //Si el torneo arrojo resutlado valido entonces que lo guarde en las variables de clase o sea memoria VOLATIL
        if (resultados != null) {
            this.equipoGanadorActual = (Equipo) resultados[0];
            this.puntosGanadorActual = (int) resultados[1];
            this.embocadasGanadorActual = (int) resultados[2];
            return true;
        }
        return false;
    }

    /**
     * Guarda al ganador en el RAF
     *
     * @param archivoDat
     * @return numero de victorias historicas de un equipo
     * @throws IOException
     */
    public int guardarYConsultarHistorial(File archivoDat) throws IOException {
        if (equipoGanadorActual == null) {
            return 0;
        }
        //Guardamos al ganador del momento
        controlRAF.registrarGanador(archivoDat, equipoGanadorActual, puntosGanadorActual, embocadasGanadorActual);
        //Leemos todo el archivo para saber cuantas veces ha ganado historicamente
        int victoriasHistoricas = controlRAF.contarVictoriasHistoricas(archivoDat, equipoGanadorActual.getNombreEquipo());
        return victoriasHistoricas;
    }

    public void serializarEquiposAlFinalizar(File archivoSerializado) throws IOException {
        if (!controlEquipo.getEquiposInscritos().isEmpty()) {
            controlSerializacion.guardarEquipo(archivoSerializado, controlEquipo.getEquiposInscritos());
        }
    }

    //geetters para que la vista pueda consultar el estado
    public List<Equipo> getEquiposInscritos() {
        return controlEquipo.getEquiposInscritos();
    }

    public Equipo getEquipoGanadorActual() {
        return equipoGanadorActual;
    }

    public int getPuntosGanadorActual() {
        return puntosGanadorActual;
    }

    public int getEmbocadasGanadorActual() {
        return embocadasGanadorActual;
    }

    public String parametrosDelJuego() {

        String p = "<html>"
                + "Tiempo total = " + tiempoCompetencia + "<br>"
                + "Cantidad de equipos = " + controlEquipo.getCantidadEquipos() + "<br>"
                + "Tiempo por equipo = " + tiempoPorEquipo + "<br>"
                + "Tiempo por jugador = " + tiempoPorJugador + "<br><br>"
                + "Si está de acuerdo con los parámetros, dé click en el botón "
                + "<b>Aceptar</b>; de lo contrario oprima el botón "
                + "<b>Volver</b> e ingrese nuevamente el tiempo."
                + "</html>";

        return p;
    }

    public void cargarDatosAGrilla() {
        controlEquipo.cargarDatosAGrilla();
    }

    public void agregarFilaGrilla(Object[] fila) {
        controlVista.agregarFilaGrilla(fila);
    }

    public void actualizarGrilla() {
        controlVista.actualizarGrilla();
    }

    public int getTiempoPorJugadorSegundos() {
        return (int) Math.round(tiempoPorJugador * 60);
    }

    /**
     * Motor principal del juego. Recibe la lista de equipos inscritos y el
     * tiempo total asignado, simula el torneo completo
     *
     * @param equiposParticipantes Lista dinámica (ArrayList) con los equipos.
     * @param tiempoTotal El tiempo (en intentos) que jugará cada equipo.
     * @return Un arreglo de objetos con el Equipo Ganador, sus Puntos y sus
     * Aciertos, retornamos un map entry.
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

    //Saca una jugada aleatoria con los valores del enum entre 0 y la longitud del enum
    private TipoEmbocada obtenerJugadaAleatoria(Random generador) {
        TipoEmbocada[] opciones = TipoEmbocada.values();
        return opciones[generador.nextInt(opciones.length)];
    }

    public void ejecutarIntento(Random r) {
        TipoEmbocada jugada = obtenerJugadaAleatoria(r);
        controlJugador.calcularPuntosJugada(jugada);
    }

    /**
     * Simula el turno completo del jugador.
     *
     * @param cantidadIntentos Cuántas veces lanzará el balero este jugador.
     * @param generador El objeto Random inyectado desde un controlador
     * superior.
     */
    public void jugarTurno(int cantidadIntentos, Random generador) {
        for (int i = 0; i < cantidadIntentos; i++) {
            TipoEmbocada jugada = obtenerJugadaAleatoria(generador);
            controlJugador.calcularPuntosJugada(jugada);
        }
    }

    public Object[] ejecutarIntentoJugadorActual(int indiceEquipo,int indiceJugador) {
        return controlEquipo.ejecutarIntentoJugadorActual(indiceEquipo,indiceJugador,generadorAzarGlobal);
    }
    
    public void setJugadorActual(Jugador jugador){
        controlJugador.setJugadorActual(jugador);
    }

}
