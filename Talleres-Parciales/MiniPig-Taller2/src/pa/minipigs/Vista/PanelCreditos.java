package pa.minipigs.Vista;

import pa.minipigs.Control.ControlVista;

/**
 * Panel de la interfaz gráfica que muestra los créditos del sistema MiniPigs.
 *
 * En este panel se presenta la información relacionada con los autores o
 * desarrolladores de la aplicación. También permite regresar a la pantalla
 * principal mediante un botón de navegación.
 *
 * Las acciones generadas en este panel son gestionadas por el controlador de la
 * vista.
 *
 * @author Valen Aguilar
 */
public class PanelCreditos extends javax.swing.JPanel {
    /** Referencia al controlador encargado de gestionar los eventos de la vista. */
    private ControlVista controlVista;
    
    /**
    * Constructor del panel de créditos.
    * 
    * Inicializa los componentes gráficos del panel y establece la
    * referencia al controlador de la vista.
    *
    * @param controlVista controlador encargado de manejar las acciones
    * generadas en la interfaz gráfica.
    */

    public PanelCreditos(ControlVista controlVista) {
        this.controlVista = controlVista;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1VolverPantallaPrincipal = new pa.minipigs.Vista.BotonRedondo();
        javax.swing.JPanel jPanel1 = new PanelFondo("Imgs/4Creditos.png");

        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setName("PantallaPrincipal"); // NOI18N
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1VolverPantallaPrincipal.setBackground(new java.awt.Color(255, 204, 255));
        jButton1VolverPantallaPrincipal.setFont(new java.awt.Font("Maiandra GD", 0, 14)); // NOI18N
        jButton1VolverPantallaPrincipal.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\MiniPigs\\Imgs\\Flechas\\FlechaAtras.png")); // NOI18N
        jButton1VolverPantallaPrincipal.setToolTipText("");
        jButton1VolverPantallaPrincipal.setActionCommand("Volver PantallaPrincipal");
        jButton1VolverPantallaPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1VolverPantallaPrincipal.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton1VolverPantallaPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1VolverPantallaPrincipalActionPerformed(evt);
            }
        });
        add(jButton1VolverPantallaPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 50, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 700));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1VolverPantallaPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1VolverPantallaPrincipalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1VolverPantallaPrincipalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1VolverPantallaPrincipal;
    // End of variables declaration//GEN-END:variables
}
