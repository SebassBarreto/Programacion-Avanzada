package pa.elbalero.controlador;

import pa.elbalero.modelo.ConexionRandomAccessFile;
import pa.elbalero.modelo.Equipo;
import pa.elbalero.modelo.Jugador;
import java.io.File;
import java.io.IOException;

public class ControlRAF {

    private ControlPrincipal controlPrincipal;
    private ConexionRandomAccessFile conexionRaf;

    public ControlRAF(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
        this.conexionRaf = new ConexionRandomAccessFile();
    }
    
    /**
     * Guarda al ganador en el historial. 
     * Coordina el calculo del ID y averigua si había ganado antes.
     * @param file
     * @param ganador
     * @param puntajeFinal
     * @param embocadasTotales
     * @throws IOException
     */
    public void registrarGanador(File file, Equipo ganador, int puntajeFinal, int embocadasTotales) throws IOException {

        String nombreEquipo = ganador.getNombreEquipo();

        // Calculamos la clave primaria (Autoincremental) consultando al modelo
        int totalRegistros = conexionRaf.contarRegistros(file);
        int nuevaClave = totalRegistros + 1; // Si hay 0, será el ID 1

        // Lógica del historial: Averiguamos si este equipo ya gano en el pasado
        int victoriasPrevias = contarVictoriasHistoricas(file, nombreEquipo);
        boolean haGanadoAntes = victoriasPrevias > 0;

        // Extraemos a los jugadores del arreglo de la entidad pura
        Jugador[] jugadores = ganador.getJugadores();
        String j1 = (jugadores != null && jugadores[0] != null) ? jugadores[0].getNombre() : "N/A";
        String j2 = (jugadores != null && jugadores[1] != null) ? jugadores[1].getNombre() : "N/A";
        String j3 = (jugadores != null && jugadores[2] != null) ? jugadores[2].getNombre() : "N/A";

        //Entregamos las variables primitivas al Modelo Obrero para que las escriba
        conexionRaf.escribirRegistro(file, nuevaClave, nombreEquipo, j1, j2, j3, puntajeFinal, embocadasTotales, victoriasPrevias, haGanadoAntes);
    }

   

    /**
     * Lee el historial completo para buscar un equipo específico y contar sus victorias.
     * @param file
     * @param nombreEquipoBuscado
     * @return
     * @throws IOException
     */
    public int contarVictoriasHistoricas(File file, String nombreEquipoBuscado) throws IOException {

        int totalRegistros = conexionRaf.contarRegistros(file);
        int contador = 0;

        // Iteramos matemticamente sobre la cantidad de registros
        for (int i = 0; i < totalRegistros; i++) {

            //Le pedimos al modelo que nos lea solo el nombre guardado en la posición 'i'
            String nombreLeido = conexionRaf.leerNombreEquipo(file, i);

            //Si el nombre leído coincide con el que buscamos, sumamos una victoria
            if (nombreLeido.equalsIgnoreCase(nombreEquipoBuscado.trim())) {
                contador++;
            }
        }

        return contador;
    }
}