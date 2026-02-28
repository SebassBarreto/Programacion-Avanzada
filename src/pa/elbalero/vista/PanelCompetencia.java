
package pa.elbalero.vista;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import pa.elbalero.controlador.ControlVista;

public class PanelCompetencia extends javax.swing.JPanel {

    public PanelCompetencia(ControlVista controlVista) {
        initComponents();
        
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

    DefaultTableModel modelo =
            new DefaultTableModel(null, columnas) {

        @Override
        public boolean isCellEditable(int r, int c) {
            return false;
        }

        @Override
        public Class<?> getColumnClass(int column) {
            if (column == 2)
                return ImageIcon.class;
            return Object.class;
        }
    };

    Grilla.setModel(modelo);

    Grilla.setRowHeight(60); // para fotos
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 500, 450));

        jTextFieldTiempo.setFont(new java.awt.Font("Maiandra GD", 1, 48)); // NOI18N
        jPanel1.add(jTextFieldTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 372, 180, 60));

        jLabel2.setFont(new java.awt.Font("Maiandra GD", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("(Minutos)");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\Programacion-Avanzada\\Imgs\\6FondoMultiusos.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 599));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));
    }// </editor-fold>//GEN-END:initComponents


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
