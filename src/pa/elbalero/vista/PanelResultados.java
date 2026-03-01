
package pa.elbalero.vista;


import javax.swing.*;
import java.awt.*;
import pa.elbalero.controlador.ControlVista;

public class PanelResultados extends javax.swing.JPanel {

    public javax.swing.JButton jButtonVolverInicio;
    public javax.swing.JLabel jLabelTitulo;
    public javax.swing.JLabel jLabelEquipo;
    public javax.swing.JLabel jLabelPuntaje;
    public javax.swing.JLabel jLabelVictorias;

    public PanelResultados(ControlVista controlVista) {
        initComponents();
    }

    public void mostrarResultados(String nombreEquipo, int puntaje, int victorias) {
        jLabelEquipo.setText("🏆 Equipo Ganador: " + nombreEquipo);
        jLabelPuntaje.setText("Puntaje Final: " + puntaje + " puntos");

        if (victorias > 1) {
            jLabelVictorias.setText("¡Este equipo ha ganado " + victorias + " veces en total!");
        } else {
            jLabelVictorias.setText("¡Primera victoria de este equipo!");
        }
    }

    private void initComponents() {
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        setPreferredSize(new java.awt.Dimension(900, 600));

        jLabelTitulo = new JLabel("¡Resultados Finales!");
        jLabelTitulo.setFont(new Font("Maiandra GD", Font.BOLD, 48));
        jLabelTitulo.setForeground(Color.WHITE);
        add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 500, 60));

        jLabelEquipo = new JLabel("Equipo Ganador: ");
        jLabelEquipo.setFont(new Font("Maiandra GD", Font.BOLD, 28));
        jLabelEquipo.setForeground(Color.YELLOW);
        add(jLabelEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 650, 40));

        jLabelPuntaje = new JLabel("Puntaje Final: ");
        jLabelPuntaje.setFont(new Font("Maiandra GD", Font.PLAIN, 24));
        jLabelPuntaje.setForeground(Color.WHITE);
        add(jLabelPuntaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 600, 40));

        jLabelVictorias = new JLabel("");
        jLabelVictorias.setFont(new Font("Maiandra GD", Font.ITALIC, 22));
        jLabelVictorias.setForeground(new Color(255, 215, 0));
        add(jLabelVictorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 650, 40));

        jButtonVolverInicio = new JButton("Volver al Inicio");
        jButtonVolverInicio.setFont(new Font("Maiandra GD", Font.BOLD, 24));
        jButtonVolverInicio.setBackground(new Color(153, 0, 0));
        jButtonVolverInicio.setForeground(Color.WHITE);
        jButtonVolverInicio.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(jButtonVolverInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, 300, 60));

        // Fondo oscuro
        setBackground(new Color(40, 40, 40));
    }
}