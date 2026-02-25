
package pa.elbalero.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pa.elbalero.vista.Ventana;

/**
 *
 * @author ValenAguilar
 */
public class ControlVista implements ActionListener{
    
    private ControlPrincipal controlPrincipal;
    private Ventana ventana;
    
    public ControlVista(ControlPrincipal controlPrincipal){
        this.controlPrincipal = controlPrincipal;
        Ventana ventana = new Ventana();
        
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Iniciar")){
            
        } else if (e.getActionCommand().equalsIgnoreCase("Ir a panel registrar equipo")){
            
        } else if (e.getActionCommand().equalsIgnoreCase("pipipipipipipipipipipipipipipi")){
            
        }
    }
}
