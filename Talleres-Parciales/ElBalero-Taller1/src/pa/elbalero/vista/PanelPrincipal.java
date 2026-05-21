
package pa.elbalero.vista;

import pa.elbalero.controlador.ControlVista;

/**
 * Panel principal del menu de inicio del juego del balero.
 * Contiene los botones de Jugar Sobre el juego Salir y Creditos.
 */
public class PanelPrincipal extends javax.swing.JPanel {

    public PanelPrincipal(ControlVista controlVista) {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1Jugar = new javax.swing.JButton();
        jButton2SobreElJuego = new javax.swing.JButton();
        jButton3Salir = new javax.swing.JButton();
        jButton4Creditos = new javax.swing.JButton();
        jPanel1 = new PanelFondo("Imgs/1PantallaPrincipal.png");

        setMaximumSize(new java.awt.Dimension(900, 600));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(900, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1Jugar.setBackground(new java.awt.Color(245, 246, 183));
        jButton1Jugar.setFont(new java.awt.Font("Maiandra GD", 1, 36)); // NOI18N
        jButton1Jugar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1Jugar.setLabel("Jugar");
        add(jButton1Jugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 152, 210, 60));

        jButton2SobreElJuego.setBackground(new java.awt.Color(245, 246, 183));
        jButton2SobreElJuego.setFont(new java.awt.Font("Maiandra GD", 1, 24)); // NOI18N
        jButton2SobreElJuego.setText("Sobre el juego");
        jButton2SobreElJuego.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(jButton2SobreElJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 237, 210, 60));
        jButton2SobreElJuego.getAccessibleContext().setAccessibleName("Reglas del juego");

        jButton3Salir.setBackground(new java.awt.Color(245, 246, 183));
        jButton3Salir.setFont(new java.awt.Font("Maiandra GD", 1, 36)); // NOI18N
        jButton3Salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3Salir.setLabel("Salir");
        add(jButton3Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 321, 210, 60));

        jButton4Creditos.setBackground(new java.awt.Color(245, 246, 183));
        jButton4Creditos.setFont(new java.awt.Font("Maiandra GD", 1, 36)); // NOI18N
        jButton4Creditos.setText("Créditos");
        jButton4Creditos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(jButton4Creditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 406, 210, 60));
        jButton4Creditos.getAccessibleContext().setAccessibleName("Sobre los desarrolladores");

        jPanel1.setMaximumSize(new java.awt.Dimension(900, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 6000));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 600));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6000, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1Jugar;
    public javax.swing.JButton jButton2SobreElJuego;
    public javax.swing.JButton jButton3Salir;
    public javax.swing.JButton jButton4Creditos;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
