package pa.elbalero.vista;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pa.elbalero.controlador.ControlVista;
import pa.elbalero.modelo.Equipo;
import pa.elbalero.modelo.Jugador;

public class PanelResultados extends JPanel {

    public JButton jButtonGuardarYSalir;
    private JLabel labelNombreEquipo;
    private JLabel labelJugador1;
    private JLabel labelJugador2;
    private JLabel labelJugador3;
    private JLabel labelPuntaje;
    private JLabel labelEmbocadas;

    public PanelResultados(ControlVista controlVista) {
        initComponents();
        jButtonGuardarYSalir.addActionListener(controlVista);
        jButtonGuardarYSalir.setActionCommand("GuardarYSalir");
    }

    public void configurar(Equipo ganador, int puntos, int embocadas) {
        if (ganador == null) {
            return;
        }
        labelNombreEquipo.setText("Equipo Ganador: " + ganador.getNombreEquipo());
        Jugador[] jugadores = ganador.getJugadores();
        labelJugador1.setText("Jugador 1: " + (jugadores != null && jugadores.length > 0 && jugadores[0] != null ? jugadores[0].getNombre() : "N/A"));
        labelJugador2.setText("Jugador 2: " + (jugadores != null && jugadores.length > 1 && jugadores[1] != null ? jugadores[1].getNombre() : "N/A"));
        labelJugador3.setText("Jugador 3: " + (jugadores != null && jugadores.length > 2 && jugadores[2] != null ? jugadores[2].getNombre() : "N/A"));
        labelPuntaje.setText("Puntaje Total: " + puntos);
        labelEmbocadas.setText("Embocadas Acertadas: " + embocadas);
    }

    private void initComponents() {
        setLayout(new java.awt.GridLayout(7, 1, 10, 10));
        setPreferredSize(new java.awt.Dimension(900, 600));

        Font fuenteGrande = new Font("Arial", Font.BOLD, 24);
        Font fuenteNormal = new Font("Arial", Font.PLAIN, 18);

        labelNombreEquipo = new JLabel();
        labelNombreEquipo.setFont(fuenteGrande);

        labelJugador1 = new JLabel();
        labelJugador1.setFont(fuenteNormal);

        labelJugador2 = new JLabel();
        labelJugador2.setFont(fuenteNormal);

        labelJugador3 = new JLabel();
        labelJugador3.setFont(fuenteNormal);

        labelPuntaje = new JLabel();
        labelPuntaje.setFont(fuenteNormal);

        labelEmbocadas = new JLabel();
        labelEmbocadas.setFont(fuenteNormal);

        jButtonGuardarYSalir = new JButton("Guardar y Salir");
        jButtonGuardarYSalir.setFont(fuenteNormal);
        jButtonGuardarYSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        add(labelNombreEquipo);
        add(labelJugador1);
        add(labelJugador2);
        add(labelJugador3);
        add(labelPuntaje);
        add(labelEmbocadas);
        add(jButtonGuardarYSalir);
    }
}
