package pa.elbalero.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import pa.elbalero.vista.Emergente;
import pa.elbalero.vista.PanelCompetencia;
import pa.elbalero.vista.PanelCreditos;
import pa.elbalero.vista.PanelIngresarTiempo;
import pa.elbalero.vista.PanelParametrosDelJuego;
import pa.elbalero.vista.PanelPrincipal;
import pa.elbalero.vista.PanelSobreElJuego;
import pa.elbalero.vista.Ventana;

public class ControlVista implements ActionListener {

    private ControlPrincipal controlPrincipal;
    private Ventana ventana;
    private PanelPrincipal panelPrincipal;
    private PanelSobreElJuego panelSobreElJuego;
    private Emergente emergente;
    private PanelCreditos panelCreditos;
    private PanelIngresarTiempo panelIngresarTiempo;
    private PanelParametrosDelJuego panelParametrosDelJuego;
    private PanelCompetencia panelCompetencia;

    public ControlVista(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
        ventana = new Ventana(); //Creamos la ventana

        //PANELES
        emergente = new Emergente();
        panelPrincipal = new PanelPrincipal(this);
        panelSobreElJuego = new PanelSobreElJuego(this);
        panelCreditos = new PanelCreditos(this);
        panelIngresarTiempo = new PanelIngresarTiempo(this);
        panelParametrosDelJuego = new PanelParametrosDelJuego(this);
        panelCompetencia = new PanelCompetencia(this);

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

        panelCreditos.jButton1VolverPantallaPrincipal.addActionListener(this);
        panelCreditos.jButton1VolverPantallaPrincipal.setActionCommand("Volver a pantalla principal");

        panelIngresarTiempo.jButton1VolverPantallaPrincipal.addActionListener(this);
        panelIngresarTiempo.jButton1VolverPantallaPrincipal.setActionCommand("Volver a pantalla principal");

        panelIngresarTiempo.jButton1AceptarTiempo.addActionListener(this);
        panelIngresarTiempo.jButton1AceptarTiempo.setActionCommand("Aceptar Tiempo");

        panelParametrosDelJuego.jButton1VolverPantallaPrincipal.addActionListener(this);;
        panelParametrosDelJuego.jButton1VolverPantallaPrincipal.setActionCommand("Volver a pantalla ingresar tiempo");

        panelParametrosDelJuego.jButton1AceptarParametros.addActionListener(this);
        panelParametrosDelJuego.jButton1AceptarParametros.setActionCommand("Iniciar Competencia");

        panelCompetencia.jButton1VolverPantallaPrincipal.addActionListener(this);
        panelCompetencia.jButton1VolverPantallaPrincipal.setActionCommand("SalirDeLaCompetencia");
        cambiarPanel(panelPrincipal);//Ponemos en la ventana el Panel Principal
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true); //Ventana visible en pantalla    
    }

    public void cambiarPanel(javax.swing.JPanel panel) {
        ventana.setContentPane(panel);
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

        }
    }

    public void actualizarGrilla() {
        DefaultTableModel modelo = (DefaultTableModel) panelCompetencia.Grilla.getModel();
        modelo.setRowCount(0);
    }

    public void agregarFilaGrilla(Object[] fila) {
        DefaultTableModel modelo = (DefaultTableModel) panelCompetencia.Grilla.getModel();
        modelo.addRow(fila);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Jugar")) {
            cambiarPanel(panelIngresarTiempo);

        } else if (e.getActionCommand().equalsIgnoreCase("SobreElJuego")) {
            cambiarPanel(panelSobreElJuego);

        } else if (e.getActionCommand().equalsIgnoreCase("Creditos")) {
            cambiarPanel(panelCreditos);

        } else if (e.getActionCommand().equalsIgnoreCase("Volver a pantalla principal")) {
            cambiarPanel(panelPrincipal);

        } else if (e.getActionCommand().equalsIgnoreCase("Salir")) {
            emergente.confirmacionSalir();

        } else if (e.getActionCommand().equalsIgnoreCase("Aceptar Tiempo")) {
            String texto = panelIngresarTiempo.jTextFieldTiempo.getText();
            if (texto.isEmpty()) {
                panelIngresarTiempo.jTextFieldTiempo.setText("");
                emergente.mostrarMensaje("Ingrese un tiempo en minutos");
            } else if (!texto.matches("\\d+")) {
                panelIngresarTiempo.jTextFieldTiempo.setText("");
                emergente.mostrarMensaje("Solo se permiten números enteros positivos");
            } else {
                int tiempo = Integer.parseInt(panelIngresarTiempo.jTextFieldTiempo.getText());
                controlPrincipal.setTiempoDeLaCompetencia(tiempo);
                panelParametrosDelJuego.jLabelParametrosDelJuego.setText(controlPrincipal.parametrosDelJuego());
                cambiarPanel(panelParametrosDelJuego);
            }
            panelIngresarTiempo.jTextFieldTiempo.setText("");

        } else if (e.getActionCommand().equalsIgnoreCase("Volver a pantalla ingresar tiempo")) {
            cambiarPanel(panelIngresarTiempo);

        } else if (e.getActionCommand().equalsIgnoreCase("Iniciar Competencia")) {
            panelCompetencia.configurarTabla();
            controlPrincipal.cargarDatosAGrilla();
            cambiarPanel(panelCompetencia);

        } else if (e.getActionCommand().equalsIgnoreCase("SalirDeLaCompetencia")) {
            emergente.confirmacionSalirCompetencia();
            
        } else if (e.getActionCommand().equalsIgnoreCase(",,,")) {

        } else if (e.getActionCommand().equalsIgnoreCase(",,")) {

        } else if (e.getActionCommand().equalsIgnoreCase(",.,")) {

        } else if (e.getActionCommand().equalsIgnoreCase(",,,,..")) {

        }

    }
}
