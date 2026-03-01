package pa.elbalero.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import pa.elbalero.controlador.ControlVista;

public class PanelCompetencia extends javax.swing.JPanel {

    public javax.swing.JLabel labelTimer;
    private RendererTurno renderer;

    public PanelCompetencia(ControlVista controlVista) {
        initComponents();
        labelTimer = new JLabel("00:00");
        labelTimer.setFont(new Font("Arial", Font.BOLD, 80));
        jPanel1.add(labelTimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, 300, 60));
        renderer = new RendererTurno();
        Grilla.setDefaultRenderer(Object.class, renderer);
    }

    public void resaltarTurnoActual(int equipo, int jugador) {
        int filaActiva = equipo * 3 + jugador;
        renderer.setFilaActiva(filaActiva);
        renderer.setEquipoActivo(equipo); // ← agregar esta línea
        Grilla.repaint();
    }

    public void configurarTabla() {

        String[] columnas = {
            "Proyecto Curricular",
            "Equipo",
            "Foto",
            "Jugador",
            "Puntaje",
            "Intentos Acertados",
            "Intentos Desacertados",
            "Intentos Totales",
            "Total Puntos"
        };

        DefaultTableModel modelo = new DefaultTableModel(null, columnas) {

            @Override
            public boolean isCellEditable(int r, int c) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 2) {
                    return ImageIcon.class;
                }
                return Object.class;
            }
        };

        Grilla.setModel(modelo);

        Grilla.setRowHeight(60); // para fotos
    }

    public void mostrarTiempo(int segundos) {
        int min = segundos / 60;
        int seg = segundos % 60;

        labelTimer.setText(
                String.format("%02d:%02d", min, seg)
        );
    }

    class RendererTurno extends DefaultTableCellRenderer {

        private int filaActiva;
        private int equipoActivo; // ← nuevo

        public void setFilaActiva(int fila) {
            this.filaActiva = fila;
        }

        public void setEquipoActivo(int equipo) { // ← nuevo
            this.equipoActivo = equipo;
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value,
                boolean isSelected, boolean hasFocus,
                int row, int column) {

            Component c = super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);

            int equipoDeFila = row / 3; // cada equipo ocupa 3 filas

            if (row == filaActiva) {
                // Jugador activo — azul oscuro
                c.setBackground(new Color(30, 90, 180));
                c.setForeground(Color.WHITE);
            } else if (equipoDeFila == equipoActivo) {
                // Mismo equipo jugando — azul claro
                c.setBackground(new Color(173, 216, 230));
                c.setForeground(Color.BLACK);
            } else {
                // Equipos en espera — gris traslúcido
                c.setBackground(new Color(220, 220, 220));
                c.setForeground(new Color(150, 150, 150));
            }

            return c;
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1VolverPantallaPrincipal = new pa.elbalero.vista.RoundButton();
        jPanel1 = new PanelFondo("Imgs/6FondoMultiusos.png");
        jScrollPane1 = new javax.swing.JScrollPane();
        Grilla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(900, 600));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(900, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1VolverPantallaPrincipal.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        jButton1VolverPantallaPrincipal.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\Programacion-Avanzada\\Imgs\\Flechas\\FlechaAtras.png")); // NOI18N
        jButton1VolverPantallaPrincipal.setToolTipText("");
        jButton1VolverPantallaPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1VolverPantallaPrincipal.setPreferredSize(new java.awt.Dimension(50, 50));
        add(jButton1VolverPantallaPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 50, 50));
        jButton1VolverPantallaPrincipal.getAccessibleContext().setAccessibleName("Volver");

        jPanel1.setMaximumSize(new java.awt.Dimension(900, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 6000));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Grilla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 860, 350));

        jLabel2.setFont(new java.awt.Font("Maiandra GD", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Grilla");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable Grilla;
    public javax.swing.JButton jButton1VolverPantallaPrincipal;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
