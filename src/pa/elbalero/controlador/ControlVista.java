package pa.elbalero.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.List;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
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
        panelResultados.jButtonVolverInicio.addActionListener(this);
        panelResultados.jButtonVolverInicio.setActionCommand("VolverAlInicio");
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

        // Protección: mínimo 1 segundo por jugador
        if (tiempoRestante <= 0) {
            tiempoRestante = 1;
        }

        // Resetear índices al iniciar
        indiceEquipo = 0;
        indiceJugador = 0;

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
            mostrarResultadosFinales();
            return;
        }
        tiempoRestante = controlPrincipal.getTiempoPorJugadorSegundos();
    }

    private void mostrarResultadosFinales() {
        // 1. Pedir al controlPrincipal que ejecute el torneo y determine ganador

        controlPrincipal.determinarGanadorVisual();

        // 2. Obtener datos del ganador
        pa.elbalero.modelo.Equipo ganador = controlPrincipal.getEquipoGanadorActual();
        int puntaje = controlPrincipal.getPuntosGanadorActual();

        if (ganador == null) {
            emergente.mostrarMensaje("No se pudo determinar un ganador.");
            return;
        }

        // 3. Guardar en RAF y obtener victorias históricas
        int victorias = 0;
        try {
            javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
            chooser.setDialogTitle("Seleccione el archivo historial (.dat)");
            int opcion = chooser.showSaveDialog(null);
            if (opcion == javax.swing.JFileChooser.APPROVE_OPTION) {
                java.io.File archivoDat = chooser.getSelectedFile();
                victorias = controlPrincipal.guardarYConsultarHistorial(archivoDat);
            }
        } catch (java.io.IOException ex) {
            emergente.mostrarMensaje("Error al guardar historial: " + ex.getMessage());
        }

        // 4. Mostrar el panel con los datos
        panelResultados.mostrarResultados(ganador.getNombreEquipo(), puntaje, victorias);
        cambiarPanel(panelResultados);
    }
    // En ControlVista.java

    private void mostrarDialogHistorial(java.io.File archivoDat) {
        List<String[]> historial;
        try {
            historial = controlPrincipal.obtenerHistorialCompleto(archivoDat);
        } catch (java.io.IOException ex) {
            emergente.mostrarMensaje("Error leyendo historial: " + ex.getMessage());
            return;
        }

        // Construir el JDialog
        javax.swing.JDialog dialog = new javax.swing.JDialog();
        dialog.setTitle("Historial de Partidas");
        dialog.setSize(700, 400);
        dialog.setLocationRelativeTo(null);
        dialog.setModal(true);

        // Tabla con los registros
        String[] columnas = {"#", "Equipo", "Jugador 1", "Jugador 2", "Jugador 3", "Puntaje"};
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        };

        for (String[] fila : historial) {
            modelo.addRow(fila);
        }

        javax.swing.JTable tabla = new javax.swing.JTable(modelo);
        javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(tabla);

        // Botón cerrar
        javax.swing.JButton btnCerrar = new javax.swing.JButton("Cerrar");
        btnCerrar.addActionListener(ev -> dialog.dispose());

        dialog.setLayout(new java.awt.BorderLayout());
        dialog.add(scroll, java.awt.BorderLayout.CENTER);
        dialog.add(btnCerrar, java.awt.BorderLayout.SOUTH);
        dialog.setVisible(true);
    }
    
    // ControlVista.java ← aquí debe estar
private void cargarFotosEnGrilla() {
    ImageIcon foto = null;
    try {
        java.io.File archivoFoto = new java.io.File("Imgs/FotoPerfil.png");
        if (archivoFoto.exists()) {
            ImageIcon original = new ImageIcon(archivoFoto.getAbsolutePath());
            java.awt.Image scaled = original.getImage()
                .getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
            foto = new ImageIcon(scaled);
        }
    } catch (Exception ex) {
        System.out.println("Error: " + ex.getMessage());
    }

    DefaultTableModel modelo = (DefaultTableModel) panelCompetencia.Grilla.getModel();
    for (int i = 0; i < modelo.getRowCount(); i++) {
        modelo.setValueAt(foto, i, 2);
    }
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
            controlPrincipal.resetearJugadores();
            panelCompetencia.configurarTabla();
            controlPrincipal.cargarDatosAGrilla();
            cargarFotosEnGrilla();
            cambiarPanel(panelCompetencia);
            iniciarTurnos();

        } else if (e.getActionCommand().equalsIgnoreCase("SalirDeLaCompetencia")) {
            emergente.confirmacionSalirCompetencia();

        } else if (e.getActionCommand().equalsIgnoreCase("VolverAlInicio")) {
            cambiarPanel(panelPrincipal);
        } else if (e.getActionCommand().equalsIgnoreCase("Salir")) {
            int opcion = javax.swing.JOptionPane.showConfirmDialog(
                    null,
                    "¿Desea salir? Se guardarán los datos.",
                    "Confirmar salida",
                    javax.swing.JOptionPane.YES_NO_OPTION
            );

            if (opcion == javax.swing.JOptionPane.YES_OPTION) {

                // 1. Serializar — fallo aquí NO bloquea el RAF
                try {
                    javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
                    chooser.setDialogTitle("Guardar equipos serializados (.ser)");
                    if (chooser.showSaveDialog(null) == javax.swing.JFileChooser.APPROVE_OPTION) {
                        controlPrincipal.serializarEquiposAlFinalizar(chooser.getSelectedFile());
                    }
                } catch (java.io.IOException ex) {
                    emergente.mostrarMensaje("Error al serializar: " + ex.getMessage());
                }

                // 2. RAF — try-catch independiente
                try {
                    javax.swing.JFileChooser chooserDat = new javax.swing.JFileChooser();
                    chooserDat.setDialogTitle("Seleccione el archivo historial (.dat)");
                    if (chooserDat.showOpenDialog(null) == javax.swing.JFileChooser.APPROVE_OPTION) {
                        mostrarDialogHistorial(chooserDat.getSelectedFile());
                    }
                } catch (Exception ex) {
                    emergente.mostrarMensaje("Error al leer historial: " + ex.getMessage());
                }

                // 3. Cerrar
                System.exit(0);
            }
        }
    }
}
