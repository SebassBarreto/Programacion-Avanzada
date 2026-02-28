
package pa.elbalero.vista;

import pa.elbalero.controlador.ControlVista;

public class PanelParametrosDelJuego extends javax.swing.JPanel {

    public PanelParametrosDelJuego(ControlVista controlVista) {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1VolverPantallaPrincipal = new pa.elbalero.vista.RoundButton();
        jPanel1 = new PanelFondo("Imgs/3FondoCocasMultiusos.png");
        jLabel3 = new javax.swing.JLabel();
        jButton1AceptarParametros = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(900, 600));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(900, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1VolverPantallaPrincipal.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        jButton1VolverPantallaPrincipal.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\Programacion-Avanzada\\Imgs\\Flechas\\2FlechaBlanca.png")); // NOI18N
        jButton1VolverPantallaPrincipal.setToolTipText("");
        jButton1VolverPantallaPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1VolverPantallaPrincipal.setPreferredSize(new java.awt.Dimension(50, 50));
        add(jButton1VolverPantallaPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 50, 50));
        jButton1VolverPantallaPrincipal.getAccessibleContext().setAccessibleName("Volver");

        jPanel1.setMaximumSize(new java.awt.Dimension(900, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 6000));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Maiandra GD", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Parametros De La Competencia");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, -1));

        jButton1AceptarParametros.setBackground(new java.awt.Color(153, 0, 0));
        jButton1AceptarParametros.setFont(new java.awt.Font("Maiandra GD", 1, 36)); // NOI18N
        jButton1AceptarParametros.setForeground(new java.awt.Color(255, 255, 255));
        jButton1AceptarParametros.setText("Aceptar");
        jButton1AceptarParametros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jButton1AceptarParametros, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 480, 240, 60));

        jPanel2.setLayout(new java.awt.CardLayout());

        jLabel2.setFont(new java.awt.Font("Maiandra GD", 1, 24)); // NOI18N
        jPanel2.add(jLabel2, "card2");

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 530, 290));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\Programacion-Avanzada\\Imgs\\3FondoCocasMultiusos.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 599));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1AceptarParametros;
    public javax.swing.JButton jButton1VolverPantallaPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
