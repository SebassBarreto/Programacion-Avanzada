package pa.minipigs.Vista;

import pa.minipigs.Control.ControlVista;

/**
 * Panel principal de la interfaz gráfica del sistema MiniPigs.
 * 
 * Este panel constituye la pantalla inicial de la aplicación y
 * permite al usuario acceder a las funcionalidades principales
 * mediante botones, como la búsqueda de MiniPigs, la visualización
 * de créditos y la salida del sistema.
 * 
 * Las acciones generadas por los botones son gestionadas por
 * el controlador de la vista.
 * 
 * @author Valen Aguilar
 */
public class PanelSiNoIngresar extends javax.swing.JPanel {
    /** Referencia al controlador encargado de gestionar los eventos de la vista. */
    private ControlVista controlVista;
    
    /**
    * Constructor del panel principal.
     * 
     * Inicializa los componentes gráficos del panel y establece la
    * referencia al controlador de la vista que gestionará los eventos
    * generados por los botones.
    *
    * @param controlVista controlador de la vista encargado de manejar
    * las acciones de la interfaz.
     */
    public PanelSiNoIngresar(ControlVista controlVista) {
        this.controlVista = controlVista;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1IngresarunMiniPig = new javax.swing.JButton();
        jButton2NoingresarMiniPig = new javax.swing.JButton();
        javax.swing.JPanel jPanel1 = new PanelFondo("Imgs/6IngresarMiniPigs.png");

        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setName("PantallaPrincipal"); // NOI18N
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1IngresarunMiniPig.setBackground(new java.awt.Color(255, 255, 255));
        jButton1IngresarunMiniPig.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        jButton1IngresarunMiniPig.setForeground(new java.awt.Color(255, 101, 237));
        jButton1IngresarunMiniPig.setText("Ingresar un MiniPig");
        jButton1IngresarunMiniPig.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1IngresarunMiniPig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(jButton1IngresarunMiniPig, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 405, 300, 80));

        jButton2NoingresarMiniPig.setBackground(new java.awt.Color(255, 255, 255));
        jButton2NoingresarMiniPig.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        jButton2NoingresarMiniPig.setForeground(new java.awt.Color(255, 101, 237));
        jButton2NoingresarMiniPig.setText("No ingresar MiniPig");
        jButton2NoingresarMiniPig.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2NoingresarMiniPig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(jButton2NoingresarMiniPig, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 500, 300, 80));

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1IngresarunMiniPig;
    public javax.swing.JButton jButton2NoingresarMiniPig;
    // End of variables declaration//GEN-END:variables
}
