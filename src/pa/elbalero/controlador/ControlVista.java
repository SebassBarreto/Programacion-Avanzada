
package pa.elbalero.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import pa.elbalero.vista.Emergente;
import pa.elbalero.vista.PanelPrincipal;
import pa.elbalero.vista.PanelSobreElJuego;
import pa.elbalero.vista.Ventana;

public class ControlVista implements ActionListener{
    
    private ControlPrincipal controlPrincipal;
    private Ventana ventana;
    private PanelPrincipal panelPrincipal;
    private PanelSobreElJuego panelSobreElJuego;
    private Emergente emergente;
    public ControlVista(ControlPrincipal controlPrincipal){
        this.controlPrincipal = controlPrincipal;
        ventana = new Ventana(); //Creamos la ventana
        
        //PANELES
        emergente = new Emergente();
        panelPrincipal = new PanelPrincipal(this); 
        panelSobreElJuego = new PanelSobreElJuego(this);
        
        //BOTONES
        panelPrincipal.jButton1Jugar.addActionListener(this);
        panelPrincipal.jButton1Jugar.setActionCommand("Jugar");
        
        panelPrincipal.jButton2SobreElJuego.addActionListener(this);
        panelPrincipal.jButton2SobreElJuego.setActionCommand("SobreElJuego");
        
        panelPrincipal.jButton3Salir.addActionListener(this);
        panelPrincipal.jButton3Salir.setActionCommand("Salir");
        
        panelPrincipal.jButton4Creditos.addActionListener(this);
        panelPrincipal.jButton4Creditos.setActionCommand("Creditos");
        
        panelSobreElJuego.jButton1VolverPantallaPrincipal.addActionListener(this);
        panelSobreElJuego.jButton1VolverPantallaPrincipal.setActionCommand("Volver a pantalla principal");
        
        cambiarAPanelPrincipal();//Ponemos en la ventana el Panel Principal
        
        ventana.setVisible(true); //Ventana visible en pantalla    
    }
    
    public void cambiarAPanelPrincipal() {
        ventana.setContentPane(panelPrincipal);
        ventana.revalidate();
        ventana.repaint();
    }
    
    public void cambiarAPanelSobreElJuego() {
        ventana.setContentPane(panelSobreElJuego);
        ventana.revalidate();
        ventana.repaint();
    }
    
    
    
    private void sonido(String soundName) { //Método de nuestros sonidos ;)
        try {
            String path = "/Sonido/" + soundName + ".wav";
            InputStream is = getClass().getResourceAsStream(path);
            AudioInputStream audio = AudioSystem.getAudioInputStream(is);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (Exception e) {
            System.err.println("Error con sonido WAV: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Jugar")){
            
        } else if (e.getActionCommand().equalsIgnoreCase("SobreElJuego")){
            cambiarAPanelSobreElJuego();
            
        } else if (e.getActionCommand().equalsIgnoreCase("Creditos")){
            
            
        }else if (e.getActionCommand().equalsIgnoreCase("Volver a pantalla principal")){
            cambiarAPanelPrincipal();
            
        }else if (e.getActionCommand().equalsIgnoreCase("Salir")){
            emergente.confirmacionSalir();
            
        }else if (e.getActionCommand().equalsIgnoreCase(",,")){
            
        }else if (e.getActionCommand().equalsIgnoreCase(",,,")){
            
        }else if (e.getActionCommand().equalsIgnoreCase(",,,,")){
            
        }
    }
}
