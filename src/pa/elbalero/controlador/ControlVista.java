package pa.elbalero.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import pa.elbalero.modelo.Equipo;
import pa.elbalero.vista.Emergente;
import pa.elbalero.vista.PanelCompetencia;
import pa.elbalero.vista.PanelCreditos;
import pa.elbalero.vista.PanelIngresarTiempo;
import pa.elbalero.vista.PanelParametrosDelJuego;
import pa.elbalero.vista.PanelPrincipal;
import pa.elbalero.vista.PanelResultados;
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
    private PanelResultados panelResultados;

    private Timer timerTurno;

    private int tiempoRestante;
    private int indiceEquipo = 0;
    private int indiceJugador = 0;

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
        panelResultados = new PanelResultados(this);

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

    private void iniciarTurnos() {
        tiempoRestante = controlPrincipal.getTiempoPorJugadorSegundos();
        timerTurno = new Timer(1000, e -> avanzarTiempo());
        timerTurno.start();
    }

    public void actualizarFila(int indiceEquipo, int indiceJugador, Object[] datos) {
    int fila = indiceEquipo * 3 + indiceJugador;
    DefaultTableModel modelo = (DefaultTableModel) panelCompetencia.Grilla.getModel();

    int acertadas = (int) datos[1];
    int desacertadas = (int) datos[2];

    modelo.setValueAt(datos[0], fila, 4); // Puntaje
    modelo.setValueAt(acertadas, fila, 5); // Acertadas
    modelo.setValueAt(desacertadas, fila, 6); // Desacertadas
    modelo.setValueAt(acertadas + desacertadas, fila, 7); // Total intentos 
    modelo.setValueAt(datos[0], fila, 8); // Total puntos 
}

    private void avanzarTiempo() {
        tiempoRestante--;
        // Jugador juega y se captura el resultado
        Object[] datos = controlPrincipal.ejecutarIntentoJugadorActual(indiceEquipo, indiceJugador);
       // solo se actualiza si el jugador existe
        if (datos != null) {
            actualizarFila(indiceEquipo, indiceJugador, datos);
        }
        //Actualizar timer visual
        panelCompetencia.mostrarTiempo(tiempoRestante);
        //resaltar jugador activo
        panelCompetencia.resaltarTurnoActual(indiceEquipo, indiceJugador);
        if (tiempoRestante <= 0) {
            siguienteJugador();
        }
    }

    private void siguienteJugador() {
        indiceJugador++;
        if (indiceJugador == 3) {
            indiceJugador = 0;
            indiceEquipo++;
        }
        if (indiceEquipo == controlPrincipal.getEquiposInscritos().size()) {
            timerTurno.stop();
            mostrarResultados();
            return;
        }
        tiempoRestante = controlPrincipal.getTiempoPorJugadorSegundos();
    }

    private void mostrarResultados() {
        controlPrincipal.determinarGanadorDesdeEstado();
        panelResultados.configurar(
                controlPrincipal.getEquipoGanadorActual(),
                controlPrincipal.getPuntosGanadorActual(),
                controlPrincipal.getEmbocadasGanadorActual()
        );
        cambiarPanel(panelResultados);
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
            iniciarTurnos();

        } else if (e.getActionCommand().equalsIgnoreCase("SalirDeLaCompetencia")) {
            emergente.confirmacionSalirCompetencia();

        } else if (e.getActionCommand().equalsIgnoreCase("GuardarYSalir")) {
            JFileChooser chooserRaf = new JFileChooser();
            chooserRaf.setDialogTitle("Seleccionar archivo RAF");
            if (chooserRaf.showSaveDialog(ventana) == JFileChooser.APPROVE_OPTION) {
                File archivoRaf = chooserRaf.getSelectedFile();
                try {
                    int victorias = controlPrincipal.guardarYConsultarHistorial(archivoRaf);
                    JFileChooser chooserSer = new JFileChooser();
                    chooserSer.setDialogTitle("Seleccionar archivo de serialización");
                    if (chooserSer.showSaveDialog(ventana) == JFileChooser.APPROVE_OPTION) {
                        controlPrincipal.serializarEquiposAlFinalizar(chooserSer.getSelectedFile());
                    }
                    controlPrincipal.actualizarEjecuciones();
                    Equipo ganadorActual = controlPrincipal.getEquipoGanadorActual();
                    if (ganadorActual != null) {
                        JOptionPane.showMessageDialog(ventana,
                                "El equipo " + ganadorActual.getNombreEquipo() + " ha ganado " + victorias + " vez(ces).",
                                "Historial", JOptionPane.INFORMATION_MESSAGE);
                    }
                    System.exit(0);
                } catch (IOException ex) {
                    emergente.mostrarMensaje("Error al guardar: " + ex.getMessage());
                }
            }

        } else if (e.getActionCommand().equalsIgnoreCase(",,,")) {

        } else if (e.getActionCommand().equalsIgnoreCase(",,")) {

        } else if (e.getActionCommand().equalsIgnoreCase(",.,")) {

        } else if (e.getActionCommand().equalsIgnoreCase(",,,,..")) {

        }

    }
}
