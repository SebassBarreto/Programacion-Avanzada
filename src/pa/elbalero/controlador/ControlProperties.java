package pa.elbalero.controlador;

import java.io.File;
import java.io.FileInputStream;
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
                String formato = "equipo." + i + ".";

                String nombreEquipo = propiedades.getProperty(formato + "nombre");
                String proyecto = propiedades.getProperty(formato + "proyecto");

                Jugador j1 = new Jugador(propiedades.getProperty(formato + "j1.nombre"), propiedades.getProperty(formato + "j1.cod"));
                Jugador j2 = new Jugador(propiedades.getProperty(formato + "j2.nombre"), propiedades.getProperty(formato + "j2.cod"));
                Jugador j3 = new Jugador(propiedades.getProperty(formato + "j3.nombre"), propiedades.getProperty(formato + "j3.cod"));

                Jugador[] arregloJugadores = new Jugador[3];

                arregloJugadores[0] = j1;
                arregloJugadores[1] = j2;
                arregloJugadores[2] = j3;

                Equipo nuevoEquipo;
                nuevoEquipo = new Equipo(nombreEquipo, proyecto, arregloJugadores);

                listaEquipos.add(nuevoEquipo);

            }

        }
        return listaEquipos;

    }
}