
package pa.elbalero.vista;

import javax.swing.JOptionPane;

/**
 * Clase utilitaria de la vista encargada de mostrar mensajes emergentes
 * y dialogos de confirmacion al usuario usando JOptionPane.
 */
public class Emergente {

    public Emergente() {      
    }
    /**
     * Muestra un mensaje informativo al usuario en un dialogo emergente
     * @param mensaje texto a mostrar en la ventana emergente
     */
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    /**
     * Muestra un dialogo de confirmacion para salir del aplicativo.
     * Si el usuario acepta se cierra el programa completamente.
     */
    public void confirmacionSalir(){
        int respuesta;
            respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿Seguro que quieres salir?",
                    "Confirmar salida",
                    JOptionPane.YES_NO_OPTION
            );
            if (respuesta == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
    }
    
    /**
     * Muestra un dialogo de confirmacion para abandonar la competencia en curso.
     * Si el usuario acepta se cierra el programa completamente.
     */
    public void confirmacionSalirCompetencia(){
        int respuesta;
            respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿Seguro que quieres salir de la competencia?\nSe cerrará el programa.",
                    "Confirmar salida",
                    JOptionPane.YES_NO_OPTION
            );
            if (respuesta == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
    }
}
