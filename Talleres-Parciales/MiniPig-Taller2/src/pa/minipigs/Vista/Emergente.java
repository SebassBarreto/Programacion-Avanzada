package pa.minipigs.Vista;

import javax.swing.JOptionPane;

/**
 * Clase utilitaria encargada de mostrar ventanas emergentes
 * (diálogos) al usuario dentro de la interfaz gráfica.
 *
 * Utiliza la clase JOptionPane para desplegar mensajes
 * informativos, advertencias y confirmaciones de acciones
 * dentro del sistema MiniPigs.
 *
 * Centralizar estos mensajes permite reutilizar el mismo
 * comportamiento en diferentes partes de la aplicación.
 *
 * @author Valen Aguilar
 */
public class Emergente {

    /**
    * Constructor de la clase Emergente.
    * Permite crear un objeto encargado de mostrar
    * mensajes emergentes en la interfaz.
    */
    public Emergente() {
    }

    /**
    * Muestra un mensaje informativo al usuario mediante
    * una ventana emergente.
    *
    * @param mensaje texto que se desea mostrar al usuario.
    */
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    /**
    * Muestra un cuadro de confirmación para preguntar
    * al usuario si desea salir de la aplicación.
    *
    * Si el usuario selecciona la opción "Sí",
    * el programa se cierra.
    */
    public void confirmacionSalir() {
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
    * Muestra un mensaje de advertencia al usuario
    * mediante una ventana emergente.
    *
    * @param mensaje texto de advertencia que se mostrará.
    */
    public void mostrarAdvertencia(String mensaje) {
        JOptionPane.showMessageDialog(
                null,
                mensaje,
                "Advertencia",
                JOptionPane.WARNING_MESSAGE
        );
    }
    
}
