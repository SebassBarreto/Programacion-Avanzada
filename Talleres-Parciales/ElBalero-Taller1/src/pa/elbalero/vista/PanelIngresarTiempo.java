
package pa.elbalero.vista;

import pa.elbalero.controlador.ControlVista;

/**
 * Panel de la vista donde el usuario ingresa el tiempo total de la competencia en minutos.
 * Incluye un campo de texto y un boton para confirmar el valor ingresado.
 */
public class PanelIngresarTiempo extends javax.swing.JPanel {

    public PanelIngresarTiempo(ControlVista controlVista) {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1VolverPantallaPrincipal = new pa.elbalero.vista.RoundButton();
        jPanel1 = new PanelFondo("Imgs/2IngresarTiempo.png");
        jButton1AceptarTiempo = new javax.swing.JButton();
        jTextFieldTiempo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(900, 600));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(900, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1VolverPantallaPrincipal.setBackground(new java.awt.Color(255, 255, 255));
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
        jPanel1.add(jButton1AceptarTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 460, 240, 60));

        jTextFieldTiempo.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldTiempo.setFont(new java.awt.Font("Maiandra GD", 1, 48)); // NOI18N
        jPanel1.add(jTextFieldTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 372, 180, 60));

        jLabel2.setFont(new java.awt.Font("Maiandra GD", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("(Minutos)");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\Programacion-Avanzada\\Imgs\\2IngresarTiempo.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 599));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1AceptarTiempo;
    public javax.swing.JButton jButton1VolverPantallaPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField jTextFieldTiempo;
    // End of variables declaration//GEN-END:variables
}
