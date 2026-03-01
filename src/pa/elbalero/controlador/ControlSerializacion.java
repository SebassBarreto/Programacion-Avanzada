package pa.elbalero.controlador;

import java.io.File;
import java.io.IOException;
import java.util.List;
import pa.elbalero.modelo.Equipo;
import pa.elbalero.modelo.ConexionSerializacion;

/**
 *
 * @author Asus
 */
public class ControlSerializacion {

    private ControlPrincipal controlPrincipal;
    private ConexionSerializacion conexionSerializacion;

    public ControlSerializacion(ControlPrincipal controlPrincipal, ConexionSerializacion conexionSerializacion) {
        this.controlPrincipal = controlPrincipal;
        this.conexionSerializacion = new ConexionSerializacion(); // ← agregar "this."
    }

    /**
     * Escribe el objeto en el archivo
     *
     * @param archivo
     * @param listaEquipos
     * @throws IOException
     */
    public void guardarEquipo(File archivo, List<Equipo> listaEquipos) throws IOException {
        conexionSerializacion.escribirObjeto(archivo, listaEquipos);
    }
    
    /**
     * Lee los objetos desde un archivo
     *
     * @param archivo
     * @return Lista de equipos con los datos
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public List<Equipo> cargarEquipos(File archivo) throws IOException, ClassNotFoundException {
        Object datosRecuperados = conexionSerializacion.leerObjeto(archivo);
        return (List<Equipo>) datosRecuperados;
    }
}
