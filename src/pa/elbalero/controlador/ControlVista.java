
package pa.elbalero.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pa.elbalero.vista.PanelPrincipal;
import pa.elbalero.vista.Ventana;

public class ControlVista implements ActionListener{
    
    private ControlPrincipal controlPrincipal;
    private Ventana ventana;
    private PanelPrincipal panelPrincipal;
    
    public ControlVista(ControlPrincipal controlPrincipal){
        this.controlPrincipal = controlPrincipal;
        ventana = new Ventana(); //Creamos la ventana
        
        //Creamos los paneles
        panelPrincipal = new PanelPrincipal();
        
        cambiarAPanelPrincipal();//Ponemos en la ventana el Panel Principal
        
        ventana.setVisible(true); //Ventana visible en pantalla
        
        
    }
    
    public void cambiarAPanelPrincipal() {
        ventana.setContentPane(panelPrincipal);
        ventana.revalidate();
        ventana.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Iniciar")){
            
        } else if (e.getActionCommand().equalsIgnoreCase("Ir a panel registrar equipo")){
            
        } else if (e.getActionCommand().equalsIgnoreCase("pipipipipipipipipipipipipipipi")){
            
        }
    }
}
