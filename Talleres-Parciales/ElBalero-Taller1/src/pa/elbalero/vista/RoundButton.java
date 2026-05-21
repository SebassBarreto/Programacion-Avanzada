package pa.elbalero.vista;

import javax.swing.JButton;        // Clase base del botón en Swing
import java.awt.*;                 // Clases gráficas (Color, Graphics, etc.)
import java.awt.geom.Ellipse2D;    // Permite crear formas geométricas (círculos)

/**
 * Boton personalizado con forma circular que extiende JButton.
 * Sobreescribe el pintado y la deteccion de clics para que solo
 * responda dentro del area circular visible.
 */
// Creamos una nueva clase que hereda todo el comportamiento de JButton
public class RoundButton extends JButton {

    // Variable que almacenará la forma circular del botón
    private Shape shape;

    /**
     * Crea un boton circular desactivando el fondo rectangular
     * el borde de enfoque y el borde estandar de Swing
     */
    // Constructor del botón circular
    public RoundButton() {

        // Evita que Swing pinte el fondo rectangular por defecto
        setContentAreaFilled(false);

        // Quita el borde de enfoque cuando se hace clic
        setFocusPainted(false);

        // Evita que Swing dibuje el borde rectangular normal
        setBorderPainted(false);
    }

    /**
     * Dibuja el fondo circular del boton usando antialiasing.
     * Si el boton esta presionado se oscurece el color de fondo.
     * @param g objeto Graphics proporcionado por Swing
     */
    // Método encargado de dibujar el componente
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        int diameter = Math.min(getWidth(), getHeight());

        if (getModel().isArmed()) {
            g2.setColor(getBackground().darker());
        } else {
            g2.setColor(getBackground());
        }

        g2.fillOval(0, 0, diameter, diameter);

        super.paintComponent(g);

        g2.dispose();
    }

    /**
     * Dibuja un borde circular alrededor del boton
     * @param g objeto Graphics proporcionado por Swing
     */
    // Método que dibuja el borde del botón
    @Override
    protected void paintBorder(Graphics g) {

        // Dibuja un borde circular alrededor del botón
        g.drawOval(0, 0, getWidth() - 1, getHeight() - 1);
    }

    /**
     * Determina si un punto (x y) esta dentro del area circular del boton.
     * Solo devuelve true si el clic cae dentro de la elipse.
     * @param x coordenada horizontal del punto
     * @param y coordenada vertical del punto
     * @return true si el punto esta dentro del circulo del boton
     */
    // Define el área real donde el botón detecta clics
    @Override
    public boolean contains(int x, int y) {

        // Si la forma no existe o cambió el tamaño del botón
        if (shape == null
                || !shape.getBounds().equals(getBounds())) {

            // Se crea una nueva forma circular
            shape = new Ellipse2D.Float(
                    0, 0, getWidth(), getHeight()
            );
        }

        // Solo devuelve true si el clic está dentro del círculo
        return shape.contains(x, y);
    }
}
