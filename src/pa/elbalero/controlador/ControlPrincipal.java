package pa.elbalero.controlador;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import pa.elbalero.modelo.ConexionSerializacion;
import pa.elbalero.modelo.Equipo;

public class ControlPrincipal {

    private ControlVista controlVista;
    private ControlProperties controlProperties;
    private ControlJuego controlJuego;
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

    public ControlPrincipal() {

        //Inicializamos la lista dinamica vacia
        //this.equiposInscritos = new ArrayList<>();
        //Instanciamos los controladores de persistencia (Archivos)
        this.controlProperties = new ControlProperties(this);
        this.controlRAF = new ControlRAF(this);
        this.controlSerializacion = new ControlSerializacion(this, new ConexionSerializacion());

        //Instanciamos el Motor del Juego (Inyeccion de dependencias en cascada)
        this.controlJugador = new ControlJugador(this);
        this.controlEquipo = new ControlEquipo(this, this.controlJugador);
        this.controlJuego = new ControlJuego(this, this.controlEquipo, new Random());
        
        cargarDatosIniciales();
        //Por ultimo, inicializamos la Vista
        //Se hace al final para asegurar que toda la logica ya existe si la vista dispara un evento
        this.controlVista = new ControlVista(this);
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
        tiempoPorEquipo = tiempoCompetencia/controlEquipo.getCantidadEquipos();
        tiempoPorJugador = tiempoPorEquipo/3;
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
        resultados = controlJuego.iniciarTorneo((ArrayList<Equipo>) controlEquipo.getEquiposInscritos(), tiempoCompetencia);

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
    
    public String parametrosDelJuego(){
        
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

    public void cargarDatosAGrilla(){
        controlEquipo.cargarDatosAGrilla();
    }
    
    public void agregarFilaGrilla(Object[] fila){
        controlVista.actualizarGrilla();
    }
    
    public void actualizarGrilla(){
        controlVista.actualizarGrilla();
    }
}
