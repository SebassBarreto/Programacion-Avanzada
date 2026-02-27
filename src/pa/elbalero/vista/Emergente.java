
package pa.elbalero.vista;

import javax.swing.JOptionPane;

public class Emergente {

    public Emergente() {      
    }
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
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
}
