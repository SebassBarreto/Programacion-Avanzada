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
    private ConexionSerializacion  conexionSerializacion;
    

    public ControlSerializacion(ControlPrincipal controlPrincipal, ConexionSerializacion conexionSerializacion) {
        this.controlPrincipal = controlPrincipal;
        conexionSerializacion = new ConexionSerializacion();
    }
    
    public void guardarEquipo(File archivo, List<Equipo> listaEquipos) throws IOException{
        conexionSerializacion.escribirObjeto(archivo, listaEquipos);
    }
    
    public List<Equipo> cargarEquipos(File archivo) throws IOException, ClassNotFoundException{
        Object datosRecuperados = conexionSerializacion.leerObjeto(archivo);
        return (List<Equipo>) datosRecuperados;
    }   
}
