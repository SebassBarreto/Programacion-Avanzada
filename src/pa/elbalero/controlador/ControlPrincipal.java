package pa.elbalero.controlador;

import java.io.File;
import java.io.IOException;
import java.util.List;
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
        int ejecuciones = controlProperties.obtenerNumeroEjecuciones();

        if (ejecuciones == 0) {
            File archivo = seleccionarArchivo();
            if (archivo == null) {
                return; // usuario canceló
            }
            try {
                cargarEquiposDesdeProperties(archivo);
            } catch (IOException ex) {
                System.out.println("Error cargando properties: " + ex.getMessage());
            }
        } else {
            File archivo = seleccionarArchivo();
            if (archivo == null) {
                return; // usuario canceló
            }
            try {
                precargarEquiposSerializados(archivo);
            } catch (IOException | ClassNotFoundException ex) {
                // Si falla el .bin, intentar cargar properties como respaldo
                System.out.println("Error cargando serializado, intentando properties...");
                archivo = seleccionarArchivo();
                if (archivo != null) {
                    try {
                        cargarEquiposDesdeProperties(archivo);
                    } catch (IOException ex2) {
                        System.out.println("Error: " + ex2.getMessage());
                    }
                }
            }
        }
        controlProperties.actualizarEjecuciones(ejecuciones + 1);
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
        tiempoPorEquipo = (double) tiempoCompetencia / controlEquipo.getCantidadEquipos();
        tiempoPorJugador = tiempoPorEquipo / 3.0;
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

    public Object[] ejecutarIntentoJugadorActual(int indiceEquipo, int indiceJugador) {
        return controlEquipo.ejecutarIntentoJugadorActual(indiceEquipo, indiceJugador, generadorAzarGlobal);
    }

    public void setJugadorActual(Jugador jugador) {
        controlJugador.setJugadorActual(jugador);
    }

    public List<String[]> obtenerHistorialCompleto(File archivoDat) throws IOException {
        return controlRAF.obtenerHistorialCompleto(archivoDat);
    }

    public void determinarGanadorVisual() {
        Equipo ganador = null;
        int maxPuntos = -1;
        int minEmbocadas = Integer.MAX_VALUE;

        for (Equipo equipo : controlEquipo.getEquiposInscritos()) {
            int puntosEquipo = 0;
            int embocadasEquipo = 0;

            for (Jugador jugador : equipo.getJugadores()) {
                if (jugador != null) {
                    puntosEquipo += jugador.getPuntaje();
                    embocadasEquipo += jugador.getEmbocadasAcertadas();
                }
            }

            if (puntosEquipo > maxPuntos) {
                maxPuntos = puntosEquipo;
                minEmbocadas = embocadasEquipo;
                ganador = equipo;
            } else if (puntosEquipo == maxPuntos) {
                if (embocadasEquipo < minEmbocadas) {
                    minEmbocadas = embocadasEquipo;
                    ganador = equipo;
                }
            }
        }

        this.equipoGanadorActual = ganador;
        this.puntosGanadorActual = maxPuntos;
        this.embocadasGanadorActual = minEmbocadas;
    }

    public void resetearJugadores() {
        for (Equipo equipo : controlEquipo.getEquiposInscritos()) {
            for (Jugador jugador : equipo.getJugadores()) {
                if (jugador != null) {
                    jugador.setPuntaje(0);
                    jugador.setEmbocadasAcertadas(0);
                    jugador.setEmbocadasDesacertadas(0);
                }
            }
        }
    }

}
