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

/**
 * Panel de la vista que muestra la grilla de competencia con los equipos y jugadores.
 * Incluye un cronometro visual y un sistema de resaltado por turnos usando un renderer personalizado.
 */
public class PanelCompetencia extends javax.swing.JPanel {

    public javax.swing.JLabel labelTimer;
    private RendererTurno renderer;

    public PanelCompetencia(ControlVista controlVista) {
        initComponents();
        labelTimer = new JLabel("00:00");
        labelTimer.setFont(new Font("Arial", Font.BOLD, 40));
        add(labelTimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, 200, 50));
        renderer = new RendererTurno();
        Grilla.setDefaultRenderer(Object.class, renderer);
    }

    /**
     * Marca visualmente al jugador y equipo activos en la grilla.
     * El jugador en turno se muestra mas oscuro y su equipo en amarillo.
     * @param equipo indice del equipo activo en la lista
     * @param jugador indice del jugador activo dentro del equipo
     */
    public void resaltarTurnoActual(int equipo, int jugador) {
        int filaActiva = equipo * 3 + jugador;
        renderer.setFilaActiva(filaActiva);
        renderer.setEquipoActivo(equipo);
        Grilla.repaint();
    }
    
    

    /**
     * Crea y asigna el modelo de tabla con las columnas de la competencia.
     * Las celdas no son editables y la columna de foto renderiza iconos.
     */
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

//    public void mostrarTiempo(double minutos) {
//        int totalSegundos = (int) Math.round(minutos * 60);
//        int min = totalSegundos / 60;
//        int seg = totalSegundos % 60;
//
//        labelTimer.setText(
//                String.format("%02d:%02d", min, seg)
//        );
//    }
    /**
     * Actualiza el label del cronometro con el tiempo restante formateado como MM:SS
     * @param segundos tiempo restante en segundos
     */
    public void mostrarTiempo(int segundos) {
        int min = segundos / 60;
        int seg = segundos % 60;

        labelTimer.setText(
                String.format("%02d:%02d", min, seg)
        );
    }

    class RendererTurno extends DefaultTableCellRenderer {

        private int filaActiva = -1;
        private int equipoActivo = -1;

        public void setFilaActiva(int fila) {
            this.filaActiva = fila;
        }

        public void setEquipoActivo(int indiceEquipo) {
            this.equipoActivo = indiceEquipo;
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value,
                boolean isSelected,
                boolean hasFocus,
                int row, int column) {

            Component c
                    = super.getTableCellRendererComponent(
                            table, value, isSelected, hasFocus, row, column);

            int equipoDeFila = row / 3;

            if (row == filaActiva) {
                c.setBackground(new Color(180, 150, 0));
                c.setForeground(Color.BLACK);
            } else if (equipoDeFila == equipoActivo) {
                c.setBackground(Color.YELLOW);
                c.setForeground(Color.BLACK);
            } else {
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
        jPanel1 = new PanelFondo("Imgs/2IngresarTiempo.png");
        jButton1AceptarTiempo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Grilla = new javax.swing.JTable();
        jTextFieldTiempo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

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

        jButton1AceptarTiempo.setBackground(new java.awt.Color(153, 0, 0));
        jButton1AceptarTiempo.setFont(new java.awt.Font("Maiandra GD", 1, 36)); // NOI18N
        jButton1AceptarTiempo.setForeground(new java.awt.Color(255, 255, 255));
        jButton1AceptarTiempo.setText("Aceptar");
        jButton1AceptarTiempo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jButton1AceptarTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 460, 240, 60));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 860, 310));

        jTextFieldTiempo.setFont(new java.awt.Font("Maiandra GD", 1, 48)); // NOI18N
        jTextFieldTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTiempoActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 180, 60));

        jLabel2.setFont(new java.awt.Font("Maiandra GD", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Grilla");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\Programacion-Avanzada\\Imgs\\6FondoMultiusos.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 599));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTiempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTiempoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable Grilla;
    public javax.swing.JButton jButton1AceptarTiempo;
    public javax.swing.JButton jButton1VolverPantallaPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField jTextFieldTiempo;
    // End of variables declaration//GEN-END:variables
}
