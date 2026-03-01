package pa.elbalero.controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import pa.elbalero.modelo.Equipo;
import pa.elbalero.modelo.Jugador;

/**
 *
 * @author Asus
 */
public class ControlProperties {

    private ControlPrincipal controlPrincipal;

    public ControlProperties(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
    }

    /**
     * Carga los equipos desde un archivo de propiedades
     *
     * @param archivo
     * @return lista de los equipos
     * @throws IOException
     */
        public List<Equipo> cargarEquipos(File archivo) throws IOException {
        Properties propiedades = new Properties();
        List<Equipo> listaEquipos = new ArrayList<>();

        try (FileInputStream entrada = new FileInputStream(archivo)) {
            propiedades.load(entrada);
            int totalEquipos = Integer.parseInt(propiedades.getProperty("total_equipos", "0"));

            for (int i = 1; i <= totalEquipos; i++) {
                Jugador[] arregloJugadores = new Jugador[3];  // ← DENTRO del for
                String formato = "equipo." + i + ".";
                String nombreEquipo = propiedades.getProperty(formato + "nombre");
                String proyecto = propiedades.getProperty(formato + "proyecto");

                for (int j = 1; j <= 3; j++) {
                    String nombreJugador = propiedades.getProperty(formato + "j" + j + ".nombre");
                    String codigoJugador = propiedades.getProperty(formato + "j" + j + ".cod");
                    arregloJugadores[j - 1] = new Jugador(nombreJugador, codigoJugador);
                }

                Equipo nuevoEquipo = new Equipo(nombreEquipo, proyecto, arregloJugadores);
                listaEquipos.add(nuevoEquipo);
            }
        }
        return listaEquipos;
    }

    public int obtenerNumeroEjecuciones() {

        Properties prop = new Properties();
        try (FileInputStream fis
                = new FileInputStream("Specs/data/conteoEjecuciones.properties")) {
            prop.load(fis);
            return Integer.parseInt(
                    prop.getProperty("ejecuciones", "0"));
        } catch (Exception e) {
            return 0;
        }
    }

    public void actualizarEjecuciones(int ejecuciones) {
        Properties prop = new Properties();
        prop.setProperty("ejecuciones",
                String.valueOf(ejecuciones));

        try (FileOutputStream fos = new FileOutputStream("Specs/data/conteoEjecuciones.properties")) {
            prop.store(fos, null);
        } catch (Exception e) {
        }
    }
}
